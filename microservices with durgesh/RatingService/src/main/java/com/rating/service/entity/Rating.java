package com.rating.service.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ratings")
public class Rating {
	@Id
	@GeneratedValue
	private int	ratingId;
	private int	userId;
	private int	hotelId;
	private int	rating;
	private String	feedback;
	
}
