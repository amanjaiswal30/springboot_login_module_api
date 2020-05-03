package com.server.service;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.server.dao.UserDao;
import com.server.model.UserDataAccessObject;
import com.server.model.UserDataStoringObject;
@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private PasswordEncoder bcryptEncoder;
	/**
	 * This is used for authenticating the username from the database using the UserDao interface.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDataAccessObject user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	/**
	 * @param user parameter entered by the user to signup.
	 * @return username as a response if data has been successfully stored in the database.
	 */
	public UserDataAccessObject save(UserDataStoringObject user) {
		UserDataAccessObject newUser = new UserDataAccessObject();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userDao.save(newUser);
	}
}