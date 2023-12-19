package com.rating.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.service.entity.Rating;
import com.rating.service.repository.RatingRepository;
import com.rating.service.service.RatingService;
@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating save(Rating rating) {
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> ratings() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(Integer userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(Integer hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

}
