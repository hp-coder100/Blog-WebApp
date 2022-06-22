package com.hemant.blog.services;

import java.util.List;

import com.hemant.blog.payloads.CategoryDto;

public interface CategoryService {

	
	//create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	
	//update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer id);
	
	//delete
	void deleteCategory(Integer categoryId);
	
	//get-all-Category
	List<CategoryDto> getAllCategory();
	
	//get Single user
	CategoryDto getCategory(Integer categoryId);
}
