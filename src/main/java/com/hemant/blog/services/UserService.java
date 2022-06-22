package com.hemant.blog.services;

import java.util.List;

import com.hemant.blog.payloads.UserDto;



public interface UserService {
	
	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user, Integer userId);
	
	UserDto getUser(int userId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(int userId);
	
	
}
