package com.rating.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.service.entity.Rating;
import com.rating.service.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/save")
	public ResponseEntity<Rating> save(@RequestBody Rating rating){
	return new ResponseEntity<Rating>(ratingService.save(rating),HttpStatus.CREATED);
	}
	
	@GetMapping("/getRatings")
	public ResponseEntity<List<Rating>> getRating(){
		return new ResponseEntity<List<Rating>>(ratingService.ratings(), HttpStatus.OK);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable Integer userId){
		return new ResponseEntity<List<Rating>>(ratingService.getRatingByUserId(userId), HttpStatus.OK);
	}
	
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable Integer hotelId){
		return new ResponseEntity<List<Rating>>(ratingService.getRatingByHotelId(hotelId), HttpStatus.OK);
	}
		
	
}
