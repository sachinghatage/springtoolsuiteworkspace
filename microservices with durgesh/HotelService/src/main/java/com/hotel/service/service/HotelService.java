package com.hotel.service.service;

import java.util.List;

import com.hotel.service.entity.Hotel;

public interface HotelService {
	
	Hotel save(Hotel hotel);
	List<Hotel> getHotels();
	Hotel getHotel(Integer id);

}
