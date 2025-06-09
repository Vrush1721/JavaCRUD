package com.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.demo.model.Product;

public interface ProductService {

	//pagination
	Page<Product> getAllProducts(Pageable pageable);
	
	//get Product By Id
	Product getProduct(long id);
	
	//create a New Product
	Product addProduct(Product product);
	
	//update product By ID
	Product updateProductById(Long id,Product product);
	
	//Delete Product by Id
	void deleteProductById(Long id);
}
