package com.hotelmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByEmailIDAndPassword(String emailID,String password);
	Optional<User> findByEmailID(String emailID); 
}
