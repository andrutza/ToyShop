package toyshop.repository;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import toyshop.model.User;


@Repository
public class HibernateUserRepositoryImpl implements UserRepository{

	private SessionFactory sessionFactory;
	
	@Inject
	public HibernateUserRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<User> findUsers() {
		return (List<User>) currentSession().createCriteria(User.class).list();
	}

	public User findUserByUsername(String username) {
		User user = (User) currentSession().createCriteria(User.class).add(Restrictions.eq("username", username)).list().get(0);
		return user;
	}

	public User save(User user) {
		currentSession().persist(user);
		return user;
	}

}
