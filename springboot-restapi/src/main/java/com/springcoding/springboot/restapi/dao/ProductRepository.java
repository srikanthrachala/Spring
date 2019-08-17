package com.springcoding.springboot.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcoding.springboot.restapi.data.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
