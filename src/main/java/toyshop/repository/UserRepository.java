package toyshop.repository;

import java.util.List;

import toyshop.model.User;

public interface UserRepository {

	List<User> findUsers();
	User findUserByUsername(String username);
	User save(User user);
}
