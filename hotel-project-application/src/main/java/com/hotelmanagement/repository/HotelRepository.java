package com.hotelmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{
	//Optional<Hotel> findByName(String hotelName);
	public List<Hotel> findByHotelId(long hotelId);

}
