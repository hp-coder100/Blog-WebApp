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
import com.hemant.blog.payloads.UserDto;
import com.hemant.blog.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//Create user
	
	@RequestMapping( value="/create", method=RequestMethod.POST)
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto createUserDto = userService.createUser(userDto);
		
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
	
	//Update User
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UserDto> updateUser(@Valid @PathVariable int id, @RequestBody UserDto userDto){
		UserDto updatedUserDto = userService.updateUser(userDto, id);
		return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
	}
	
	//Delete User
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable int id){
		userService.deleteUser(id);
		return new ResponseEntity<>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
	}
	
	//Get All User
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public ResponseEntity<List<UserDto>> getAllUsers(){
		
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
		
	}
	
	//Get Single User by Id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") Integer userId){
		return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
	}
}
