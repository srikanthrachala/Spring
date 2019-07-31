package com.bytecode.springboot.restapi.db;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bytecode.springboot.restapi.dao.ProductRepository;
import com.bytecode.springboot.restapi.data.Product;

@Configuration
@Slf4j
class LoadDatabase {

  @Bean
  CommandLineRunner initDatabase(ProductRepository repository) {
    return args -> {
      repository.save(new Product("iPhone X", 699.99));
      repository.save(new Product("Pixel 3a", 399.00));
   
    };
  }
}