package com.hemant.blog.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
	
	
	private Integer categoryId;
	
	@NotBlank
	@Size(min=4, message="Category title must be atleat of 4 char")
	private String categoryTitle;
	
	@NotBlank
	@Size(min=20, message="Category Discription must be atleast 20 char long")
	private String categoryDiscription;
	
}
