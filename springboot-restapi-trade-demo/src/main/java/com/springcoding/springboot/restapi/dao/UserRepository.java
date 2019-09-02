package com.springcoding.springboot.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcoding.springboot.restapi.data.User;

/**
 * DAO Class for User Operations
 * 
 * @author Srikanth
 *
 */
public interface UserRepository extends JpaRepository<User,Long>{

}
