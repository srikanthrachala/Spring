package com.springcoding.springboot.restapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcoding.springboot.restapi.dao.UserRepository;
import com.springcoding.springboot.restapi.data.User;
import com.springcoding.springboot.restapi.exception.UserNotFoundException;
import com.springcoding.springboot.restapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteUserById(Long id) {

		userRepository.deleteById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User createUser(User user) {

		return userRepository.save(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User getUserById(Long id){

		Optional<User> user= userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException(id);
		}

		return user.get();
	}
}
