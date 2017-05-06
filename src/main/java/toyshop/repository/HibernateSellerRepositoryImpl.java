package toyshop.repository;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import toyshop.model.Category;
import toyshop.model.Toy;

@Repository
public class HibernateSellerRepositoryImpl implements SellerRepository {

	private SessionFactory sessionFactory;
	
	@Inject
	public HibernateSellerRepositoryImpl(SessionFactory sessionFactory) {
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

	public Toy update(Toy toy) {
		currentSession().update(toy);
		return toy;
	}

}
