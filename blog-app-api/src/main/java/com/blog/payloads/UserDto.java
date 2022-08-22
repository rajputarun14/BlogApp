package com.blog.payloads;

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
	@Size(min = 4, message="Username must be min of 4 characters")
	private String name;
	
	@NotEmpty
	@Email(message = "Email address not valid")
	private String email;
	
	@NotEmpty
	private String about;
	
	@NotEmpty
	@Size(min = 4, max=10,message="password must be min of 4 chars and max 10 chars")
	private String password;
}
