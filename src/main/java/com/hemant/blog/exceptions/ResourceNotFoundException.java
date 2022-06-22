package com.hemant.blog.exceptions;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	String resourceName;
	String fieldName;
	long fieldvalue;
	
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s :%s", resourceName, fieldName, fieldValue ));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldvalue = fieldValue;
		
	}
	
	
	
	
}
