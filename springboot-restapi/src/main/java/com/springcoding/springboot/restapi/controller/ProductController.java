package com.springcoding.springboot.restapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springcoding.springboot.restapi.dao.ProductRepository;
import com.springcoding.springboot.restapi.data.Product;
import com.springcoding.springboot.restapi.exception.ProductNotFoundException;

@RestController
public class ProductController {

	private final ProductRepository repository;

	public ProductController(ProductRepository repository) {

		this.repository = repository;
	}

	@GetMapping("/products")
	List<Product> getProducts() {
		return repository.findAll();
	}

	@PostMapping("/products")
	Product createProduct(@RequestBody Product product) {
		return repository.save(product);
	}

	@GetMapping("/products/{id}")
	Product getProductById(@PathVariable Long id) {

		return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
	}

	@PutMapping("/product/{id}")
	Product replaceEmployee(@RequestBody Product updateProduct, @PathVariable Long id) {

		return repository.findById(id).map(product -> {
			product.setName(updateProduct.getName());
			product.setPrice(updateProduct.getPrice());
			return repository.save(product);
		}).orElseThrow(() -> new ProductNotFoundException(id));
	}

	@DeleteMapping("/product/{id}")
	void deleteProduct(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
