package com.demo.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.demo.model.Category;

public interface CategoryService {
	
	//get all categories
	Page<Category> getAllCategories(Pageable pageable);
	
	//get category by id
	public Category getCategory(Long long1);
	
	//create new category
	public Category addCategory(Category category);
	
	
	//update category by id
	public Category updateCategoryById(Long id,Category category);
	
	//delete category by id
	public void deleteCategory(long id);
}
