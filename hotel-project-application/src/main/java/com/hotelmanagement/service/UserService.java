package com.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.exception.ResourceNotFoundException;
import com.hotelmanagement.model.User;
import com.hotelmanagement.repository.UserRepository;

@Service
public class UserService{
	@Autowired
private UserRepository userRepository;
	

	public User getUserById(long userId) {
		
		return userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
	}


	public User saveUser(User user) {
		
		return userRepository.save(user);
	}
	public User loginUser(User user) {
		
		return this.userRepository.findByEmailIDAndPassword(user.emailID,user.password).orElseThrow(()->new ResourceNotFoundException("Useer ", "Id",user.emailID+" and password "+user.password ));
	}
	public User getUserByEmail(User user)
	{
		return this.userRepository.findByEmailID(user.emailID).orElseThrow(()->new ResourceNotFoundException("User ", "Email",user.emailID ));
	}

	public User updateUser(User user,long userId) {
	
	User existingUser=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));	
	existingUser.setFirstName(user.getFirstName());
	existingUser.setLastName(user.getLastName());
	existingUser.setDateOfBirth(user.getDateOfBirth());
	existingUser.setDistrict(user.getDistrict());
	existingUser.setPhoneNumber(user.getPhoneNumber());
	existingUser.setState(user.getState());
	existingUser.setZipCode(user.getZipCode());
	existingUser.setEmailID(user.getEmailID());
	existingUser.setPassword(user.getPassword());
	userRepository.save(existingUser);
	return existingUser;
	}


	public List<User> getAllUsers() {
	
		return userRepository.findAll();
	}



	public void deleteUser(long userId) {
		userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		userRepository.deleteById(userId);
		
	}
	


}