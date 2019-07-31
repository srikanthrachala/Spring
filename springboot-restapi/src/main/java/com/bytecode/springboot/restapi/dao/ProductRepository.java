package com.bytecode.springboot.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytecode.springboot.restapi.data.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
