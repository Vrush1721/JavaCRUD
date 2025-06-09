package com.demo.service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.demo.dao.CategoryDao;
import com.demo.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	public CategoryServiceImpl() {
	}

	// get Category by id
	@Override
	public Category getCategory(Long long1) {

		return categoryDao.findById(long1).orElseThrow();
	}

	// create new category
	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub

		return categoryDao.save(category);
	}

	//get all categories
	@Override
	public Page<Category> getAllCategories(org.springframework.data.domain.Pageable pageable) {
		// TODO Auto-generated method stub

		return categoryDao.findAll(pageable);
	}

	//update category by id
	@Override
	public Category updateCategoryById(Long id, Category category) {
		// TODO Auto-generated method stub
		Category oldcat = categoryDao.findById(id).orElseThrow();
		oldcat.setName(category.getName());

		return categoryDao.save(oldcat);
	}

	//delete category by id
	@Override
	public void deleteCategory(long id) {
		// TODO Auto-generated method stub
		categoryDao.deleteById(id);
	}

}
