package toyshop.repository;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import toyshop.model.Category;
import toyshop.model.Toy;

@Repository
public class HibernateToyRepositoryImpl implements ToyRepository {

	private SessionFactory sessionFactory;
	
	@Inject
	public HibernateToyRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Category> findCategories() {
		return (List<Category>) currentSession().createCriteria(Category.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Toy> findToysByCategoryId(int id) {
		return (List<Toy>) currentSession().createCriteria(Toy.class)
				.add(Restrictions.eq("category.id", id)).list();
	}
	
	public Toy findById(int id) {
		return (Toy)currentSession().createCriteria(Toy.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}

	public Toy updateCount(Toy toy) {
		Toy toyInDb = findById(toy.getId());
		toyInDb.setCount(toyInDb.getCount() - toy.getCount());
		currentSession().merge(toyInDb);
		return toy;
	}
	
	public void update(Map<String, String> data) {
		Toy toyInDb = findById(Integer.parseInt(data.get("id")));
		toyInDb.setCount(Integer.parseInt(data.get("count")));
		toyInDb.setDescription(data.get("description"));
		toyInDb.setPrice(Integer.parseInt(data.get("price")));
		toyInDb.setName(data.get("name"));
		currentSession().merge(toyInDb);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Toy> getToys() {
		return (List<Toy>) currentSession().createCriteria(Toy.class).list();
	}

	@Override
	public Toy addToy(Toy toy) {
		currentSession().persist(toy);
		return toy;
	}

	@Override
	public Category findCategoryById(int id) {
		return (Category)currentSession().createCriteria(Category.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public void deleteToy(int id) {
		Toy toy = findById(id);
		currentSession().delete(toy);
	}

}
