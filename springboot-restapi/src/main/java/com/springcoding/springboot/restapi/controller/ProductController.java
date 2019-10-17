package com.springcoding.springboot.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springcoding.springboot.restapi.data.Product;
import com.springcoding.springboot.restapi.service.ProductService;

/**
 * Controller Class for Product API end point/operations
 * 
 * @author Srikanth
 */
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;


	@GetMapping("/products")
	List<Product> getProducts() {
		return productService.getProducts();
	}

	@PostMapping("/products")
	Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@GetMapping("/products/{id}")
	Product getProductById(@PathVariable Long id) {

		return productService.getProductById(id);
	}

	@PutMapping("/products/{id}")
	Product  updateProduct(@RequestBody Product updateProduct, @PathVariable Long id) {

		return productService.updateProduct(updateProduct, id);
	}

	@DeleteMapping("/products/{id}")
	void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}

}
