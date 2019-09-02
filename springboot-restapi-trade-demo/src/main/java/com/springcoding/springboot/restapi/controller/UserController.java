package com.springcoding.springboot.restapi.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springcoding.springboot.restapi.data.User;
import com.springcoding.springboot.restapi.exception.UserNotFoundException;
import com.springcoding.springboot.restapi.service.UserService;

/**
 * 
 * Controller Class for User API end point/operations
 * 
 * @author Srikanth
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Creates a new User
	 * @param user
	 * @return User
	 */
	@PostMapping("/users")
	User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	/**
	 * Retrives all Users
	 * 
	 * @return List of User
	 */
	@GetMapping("/users")
	List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	/**
	 * Retrieves User based on user id
	 * 
	 * @param id
	 * @return User
	 */
	@GetMapping("/users/{id}")
	User getUserById(@PathVariable Long id) {
		try {
			return userService.getUserById(id);
		} catch (EntityNotFoundException ex) {
			throw new UserNotFoundException(id);
		}
	}

	/**
	 * Deletes User by user id
	 * @param id
	 */
	@DeleteMapping("/users/{id}")
	void deleteUserById(@PathVariable Long id) {
		userService.deleteUserById(id);
	}

}
