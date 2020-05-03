package com.server.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.server.model.UserDataAccessObject;
/**
 * This interface is used in the JwtUserDetailsService to retrieve data from the database using default CrudRepository methods 
 */
@Repository
public interface UserDao extends CrudRepository<UserDataAccessObject, Integer> {
	UserDataAccessObject findByUsername(String username);
}