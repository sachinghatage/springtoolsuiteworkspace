package com.javatechie.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")     
@NoArgsConstructor
public class UserRequest {
	
	private String name;
	private String email;
	private String mobile;
	private String gender;
	private int age;
	private String nationality;

}
//In your example, @AllArgsConstructor(staticName = "build") specifies that the generated 
//constructor should have a static factory method named "build". This means that instead of 
//creating an instance of the class using the standard constructor syntax (new MyClass(...)),
//you can use the generated static factory method to create an instance (MyClass.build(...)).
//
