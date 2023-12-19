package com.user.service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.user.service.entity.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {

	@PostMapping("/ratings")
	Rating createRating(Rating values);
}
