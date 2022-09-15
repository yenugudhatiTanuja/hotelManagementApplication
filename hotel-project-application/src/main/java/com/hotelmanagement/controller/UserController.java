package com.hotelmanagement.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.model.User;
import com.hotelmanagement.service.UserService;

@RestController // is controller which provides different end points to access the services

@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;

	
	 public UserController(UserService userService) { super();
	  this.userService = userService; }
	 

//Register
	//http://localhost:8084/register
	@PostMapping("/register")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {

		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
	}

//Login
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestBody User user) {

		return new ResponseEntity<User>(userService.loginUser(user), HttpStatus.OK);

	}

//Update User	
	@PutMapping("user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long userId, @RequestBody User user) {
		return new ResponseEntity<User>(userService.updateUser(user, userId), HttpStatus.OK);
	}

//Get All User	
	@GetMapping()
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	// get user by email
	@PostMapping("/forgotpassword")
	public User getUserByEmail(@RequestBody User user) {
		return userService.getUserByEmail(user);
	}

	// get user by id
	@GetMapping("user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long userId) {
		return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);
	}

//Delete user	
	@DeleteMapping("user/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable("id") long userId) {
		userService.deleteUser(userId);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
}