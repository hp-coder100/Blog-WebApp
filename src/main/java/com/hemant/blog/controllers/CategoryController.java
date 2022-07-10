package com.hemant.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hemant.blog.payloads.ApiResponse;
import com.hemant.blog.payloads.CategoryDto;
import com.hemant.blog.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//Create category
	
	@RequestMapping( value="/create", method=RequestMethod.POST)
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		CategoryDto createCategoryDto = categoryService.createCategory(categoryDto);
		
		return new ResponseEntity<>(createCategoryDto, HttpStatus.CREATED);
	}
	
	//Update Category
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<CategoryDto> updateCategory(@Valid @PathVariable int id, @RequestBody CategoryDto categoryDto){
		CategoryDto updatedCategoryDto = categoryService.updateCategory(categoryDto, id);
		return new ResponseEntity<>(updatedCategoryDto, HttpStatus.OK);
	}
	
	//Delete Category
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCategory(@PathVariable int id){
		categoryService.deleteCategory(id);
		return new ResponseEntity<>(new ApiResponse("Category Deleted Successfully", true), HttpStatus.OK);
	}
	
	//Get All Category
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public ResponseEntity<List<CategoryDto>> getAllCategorys(){
		
		return new ResponseEntity<>(categoryService.getAllCategory(), HttpStatus.OK);
		
	}
	
	//Get Single Category by Id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") Integer categoryId){
		return new ResponseEntity<>(categoryService.getCategory(categoryId), HttpStatus.OK);
	}
}
