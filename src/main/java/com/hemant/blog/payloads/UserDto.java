package com.hemant.blog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min= 4, message = "Username must be mininum of 4 characters.")
	private String name;

	@NotEmpty
	@Email(message="Please proive a valid email.")
	private String email;
	
	@NotNull(message="this field cant't be empty.")
	private String about;
	@NotNull
	@Size(min=8, max = 15, message= "Password must be greater than 7 char and max of 15 char")
	private String password;
	
	
}
