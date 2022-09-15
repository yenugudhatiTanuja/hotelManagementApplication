package com.hotelmanagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.exception.ResourceNotFoundException;
import com.hotelmanagement.model.Admin;
import com.hotelmanagement.model.Hotel;
import com.hotelmanagement.service.AdminService;
import com.hotelmanagement.service.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	private AdminService adminservice;
	
/*	@Autowired
	private ProductService productService;*/


	@Autowired
	private UserService userService;
	
	  public AdminController(AdminService adminservice) { 
		super();
	  this.adminservice = adminservice; }
	 
	// admin register
	@PostMapping("/register")
	public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody Admin admin) {
		System.out.println("admin register " + admin);
		return new ResponseEntity<Admin>(adminservice.saveAdmin(admin), HttpStatus.CREATED);
	}

	// admin login
	@PostMapping("/login")
	public ResponseEntity<Admin> loginAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminservice.loginAdmin(admin), HttpStatus.OK);

	}
	

	}