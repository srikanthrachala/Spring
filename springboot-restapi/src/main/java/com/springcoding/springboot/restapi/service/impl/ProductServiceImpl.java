package com.springcoding.springboot.restapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcoding.springboot.restapi.dao.ProductRepository;
import com.springcoding.springboot.restapi.data.Product;
import com.springcoding.springboot.restapi.exception.ProductNotFoundException;
import com.springcoding.springboot.restapi.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository repository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Product> getProducts() {
		return repository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Product createProduct(Product product) {
		return repository.save(product);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Product getProductById(Long id) {

		return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Product updateProduct(Product updateProduct, Long id) {

		return repository.findById(id).map(product -> {
			product.setName(updateProduct.getName());
			product.setPrice(updateProduct.getPrice());
			return repository.save(product);
		}).orElseThrow(() -> new ProductNotFoundException(id));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteProduct(Long id) {
		repository.deleteById(id);
	}

}
