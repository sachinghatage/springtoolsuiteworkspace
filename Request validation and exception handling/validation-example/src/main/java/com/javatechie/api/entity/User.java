package com.javatechie.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor(staticName = "build")   
@NoArgsConstructor
@Table(name="User_TBL")
public class User {
	@Id
	@GeneratedValue
	private int userId;
	@NotNull(message="name shouldnot be null")
	private String name;
	@Email(message="invalid email address")
	private String email;
	@Pattern(regexp = "^\\d{10}$",message="invalid mobile number")
	private String mobile;
	private String gender;
	@Min(18)
	@Max(60)
	private int age;
	@NotBlank
	private String nationality;

}







