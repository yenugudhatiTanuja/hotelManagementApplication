package com.hotelmanagement.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.model.Admin;
import com.hotelmanagement.model.Hotel;
import com.hotelmanagement.model.User;
import com.hotelmanagement.service.AdminService;
import com.hotelmanagement.service.HotelService;
import com.hotelmanagement.service.UserService;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private AdminService adminservice;

	@PostMapping("/addhotels")
	public ResponseEntity<Hotel> addHotels(@Valid @RequestBody Hotel hotel) {

		return new ResponseEntity<Hotel>(hotelService.addHotel(hotel), HttpStatus.CREATED);
	}
	
	
	// get hotel by id
		@GetMapping("hotel/{id}")
		public ResponseEntity<Hotel> getHotelById(@PathVariable("id") long hotelId) {
			return new ResponseEntity<Hotel>(hotelService.getHotelByHotelId(hotelId), HttpStatus.OK);
		}
		@PostMapping("/addhotel/{adminId}")
		public ResponseEntity<Hotel> addHotel(@Valid @RequestBody Hotel hotel, @RequestParam("adminID") int adminId) {
            Admin ad=this.adminservice.getAdminByAdminId(adminId);
            hotel.setAdm((Set<Admin>) ad);
			return new ResponseEntity<Hotel>(hotelService.addHotel(hotel), HttpStatus.CREATED);
		}
		// to get all products
		@GetMapping
		public List<Hotel> getAllHotels(){
				return hotelService.getAllHotels();
		}
		
		// to update product
		@PutMapping("{hotelId}")
		public ResponseEntity<Hotel> updateHotel(@Valid @PathVariable("hotelId") long hotelId, @RequestBody Hotel hotel) {
			return new ResponseEntity<Hotel>(hotelService.updateHotel(hotel, hotelId), HttpStatus.OK);
		}

		@DeleteMapping("{hotelId}")
		public ResponseEntity<Boolean> deleteHotel(@PathVariable("hotelId") long hotelId) {
			hotelService.deleteHotel(hotelId);
			boolean flag = true;
			return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
			}

}
