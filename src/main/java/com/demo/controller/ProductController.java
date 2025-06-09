package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.SpringBootRestApplication;
import com.demo.dao.CategoryDao;
import com.demo.model.Category;
import com.demo.model.Product;
import com.demo.service.CategoryServiceImpl;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;
@RestController
@RequestMapping("/api/products")
public class ProductController {

   

	@Autowired
	private ProductService productService;


    ProductController() {
       
    }
	
	//get all products
	@GetMapping
	public Page<Product> getAllProducts(@RequestParam(defaultValue = "0")int page){
		return productService.getAllProducts(PageRequest.of(page, 2));
	}
	
	//get products by id
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable long id) {
		return productService.getProduct(id);
	}
	
	//add new product
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	//update product by id
	@PutMapping("/{id}")
	public Product updateProductById(@PathVariable long id,@RequestBody Product product) {
			return productService.updateProductById(id, product);
	}
	
//delete product by id
	@DeleteMapping("/{id}")
	public void deleteProductbyId(@PathVariable long id) {
		productService.deleteProductById(id);
	}
}