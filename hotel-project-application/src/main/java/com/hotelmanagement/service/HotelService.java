package com.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.exception.ResourceNotFoundException;
import com.hotelmanagement.model.Hotel;
import com.hotelmanagement.repository.HotelRepository;


@Service
public class HotelService{
	@Autowired
	private HotelRepository hotelRepository;
	
	
	
	public Hotel addHotel(Hotel hotel) {
		System.out.println("Hotel added Succesfully "+hotel);
		hotel.setHotelCity(hotel.getHotelCity());
		hotel.setHotelName(hotel.getHotelName());
		hotel.setHotelRating(hotel.getHotelRating());
		hotel.setHotelReview(hotel.getHotelReview());
		hotel.setPhoneNumber(hotel.getPhoneNumber());
		return hotelRepository.save(hotel);
	}

	



	public Hotel updateHotel(Hotel hotel,long hotelId) {
		
		Hotel existingHotel = hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("hotel","hotelId",hotelId));
		existingHotel.setHotelName(hotel.getHotelName());
		existingHotel.setHotelCity(hotel.getHotelCity());
		existingHotel.setHotelRating(hotel.getHotelRating());
		existingHotel.setHotelReview(hotel.getHotelReview());
		existingHotel.setPhoneNumber(hotel.getPhoneNumber());
		hotelRepository.save(existingHotel);
		
		return existingHotel;
		
	}

	public void deleteHotel(long hotelId) {
		hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("hotel","Id",hotelId));
		hotelRepository.deleteById(hotelId);	
	

	}





	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}





	public Hotel getHotelByHotelId(long hotelId) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("hotel","Id",hotelId));
	}

}