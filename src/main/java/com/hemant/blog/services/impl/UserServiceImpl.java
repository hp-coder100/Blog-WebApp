package com.hemant.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hemant.blog.entities.User;
import com.hemant.blog.exceptions.ResourceNotFoundException;
import com.hemant.blog.payloads.UserDto;
import com.hemant.blog.repositories.UserRepo;
import com.hemant.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = dtoToUser(userDto);
		User savedUser = userRepo.save(user);
		return userToDto(savedUser);
		
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		
		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		
		User updatedUser = userRepo.save(user);
		return userToDto(updatedUser);
	}

	@Override
	public UserDto getUser(int userId) {
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		
		return userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> list = userRepo.findAll();
		List<UserDto> dtoList = list.stream().map(user -> userToDto(user)).collect(Collectors.toList());
		
		return dtoList;
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		userRepo.delete(user);

	}
	
	private User dtoToUser(UserDto userDto) {
		
		return modelMapper.map(userDto, User.class);
	}
	private UserDto userToDto(User user) {
		
		return modelMapper.map(user, UserDto.class);
	}

}
