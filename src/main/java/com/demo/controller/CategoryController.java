package com.demo.controller;

import java.util.List;
import com.demo.service.CategoryServiceImpl;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.demo.SpringBootRestApplication;
import com.demo.dao.CategoryDao;
import com.demo.model.Category;
import com.demo.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    

	@Autowired
	private CategoryService categoryService;

	//get all categories
	@GetMapping
	public Page<Category> getAllCategories(@RequestParam(defaultValue = "0")int page){
		return categoryService.getAllCategories(PageRequest.of(page, 2));
	}
	
	
	//get category by id
	@GetMapping("/{category_id}")
	public Category getCategory(@PathVariable Long category_id) {
		return categoryService.getCategory(category_id);
	}
	
	//create new category
	@PostMapping
	public Category addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}
	
	//update category by id
	@PutMapping("/{id}")
	public Category updateCategoryById(@PathVariable Long id,@RequestBody Category category) {
		return categoryService.updateCategoryById(id, category);
	}
	
	//delete category by id
	@DeleteMapping("/{Category_id}")
	public ResponseEntity<HttpStatus>deleteCategory(@PathVariable String Category_id){
		try {
			categoryService.deleteCategory(Long.parseLong(Category_id));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
