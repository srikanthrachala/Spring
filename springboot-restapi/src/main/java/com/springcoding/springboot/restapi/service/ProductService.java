package com.springcoding.springboot.restapi.service;

import java.util.List;

import com.springcoding.springboot.restapi.data.Product;

/**
 * Interface for Product Service
 * 
 * @author Srikanth
 *
 */
public interface ProductService {

	/**
	 * Retrieves all Products
	 * 
	 * @return Product List
	 */
	List<Product> getProducts();

	/**
	 * Creates a new Product
	 * 
	 * @param product
	 * @return Product
	 */
	Product createProduct(Product product);

	/**
	 * Retrieves the Product by id
	 * 
	 * @param id
	 * @return Product
	 */
	Product getProductById(Long id);

	/**
	 * Updates Product data
	 * 
	 * @param updateProduct
	 * @param id
	 * @return Product
	 */
	Product updateProduct(Product updateProduct, Long id);

	/**
	 * Deletes the Product based on id
	 * 
	 * @param id
	 */
	void deleteProduct(Long id);
}
