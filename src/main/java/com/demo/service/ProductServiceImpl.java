package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductDao;
import com.demo.model.Category;
import com.demo.model.Product;
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	//get all products
	@Override
	public Page<Product> getAllProducts(Pageable pageable) {
		// TODO Auto-generated method stub
		return productDao.findAll(pageable);
	}

	//get product by id
	@Override
	public Product getProduct(long id) {
		// TODO Auto-generated method stub
		return productDao.findById(id).orElseThrow();
	}
	
	//add new product
	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.save(product);
	}

	//update product by id
	@Override
	public Product updateProductById(Long id, Product product) {
		// TODO Auto-generated method stub
		Product oldpro=productDao.findById(id).orElseThrow();
		oldpro.setName(product.getName());
		oldpro.setPrice(product.getPrice());
		oldpro.setCategory(product.getCategory());
		return productDao.save(oldpro);
	}

	//delete product by id
	@Override
	public void deleteProductById(Long id) {
			
		productDao.deleteById(id);
	}

	
	

}
