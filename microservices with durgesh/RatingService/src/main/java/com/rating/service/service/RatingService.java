package com.rating.service.service;

import java.util.List;

import com.rating.service.entity.Rating;

public interface RatingService {

	Rating save(Rating rating);
	List<Rating> ratings();
	List<Rating> getRatingByUserId(Integer userId);
	List<Rating> getRatingByHotelId(Integer hotelId);
}
