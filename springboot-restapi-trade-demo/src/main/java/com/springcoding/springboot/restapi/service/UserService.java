package com.springcoding.springboot.restapi.service;

import java.util.List;


import com.springcoding.springboot.restapi.data.User;

public interface UserService {

	/**
	 * Creates a new User
	 * @param user
	 * @return User
	 */
	User createUser(User user);

	/**
	 * Retrives all Users
	 * 
	 * @return List of User
	 */
	List<User> getAllUsers();


	/**
	 * Deletes User by user id
	 * @param id
	 */
	void deleteUserById(Long id);

	/**
	 * Retrieves User based on user id
	 * 
	 * @param id
	 * @return User
	 */
	User getUserById(Long id);

}
