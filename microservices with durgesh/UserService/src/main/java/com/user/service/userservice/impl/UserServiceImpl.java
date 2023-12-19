package com.user.service.userservice.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.entity.Hotel;
import com.user.service.entity.Rating;
import com.user.service.entity.User;
import com.user.service.exception.ResourceNotFoundException;
import com.user.service.external.services.HotelService;
import com.user.service.repository.UserRepository;
import com.user.service.userservice.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	//while using feign client
	//instead of restTemplate we can use feign client
	@Autowired
	private HotelService hotelService;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(int userId) {
		 User user = userRepository.findById(userId)
				 .orElseThrow(()->new ResourceNotFoundException("Resource not found with id: "+userId));
		 
		 Rating[] ratingOfUser = restTemplate.getForObject("http://USER-SERVICE/ratings/users/"+user.getUserId(),Rating[].class);
		List<Rating> ratings = Arrays.stream(ratingOfUser).toList();
		 List<Rating> ratingList=ratings.stream().map(rating->{
			 //api call to hotel service to get the hotel
		//	 ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("HOTEL-SERVICE/hotels/"+rating.getHotelId(),Hotel.class);
		// Hotel hotel = forEntity.getBody();
		 
	//while using feign client comment above restTemplate		 
			Hotel hotel=hotelService.getHotel(rating.getHotelId()); 
			 
			 
			 
		 //set hotel to rating
		 rating.setHotel(hotel);
		 
		 //return rating
		 return rating;
		 }).collect(Collectors.toList());
		 
		 
		 
		 user.setRatings(ratingList);
		 return user;
	}

}
