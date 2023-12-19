package com.hibernate.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mobile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mobileId;
	private String mobileName;
	@ManyToMany(mappedBy = "mobiles")
	List<Person> persons;

}
