package toyshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import toyshop.model.User;
import toyshop.repository.UserRepository;

@Transactional
@Service("userDetailsService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		User user = null;
		user = userRepository.findUserByUsername(username);
		return user;
	}

	public User save(User user) {
		return userRepository.save(user);
	}
	
	public List<User> findUsers() {
		return userRepository.findUsers();
	}
}
