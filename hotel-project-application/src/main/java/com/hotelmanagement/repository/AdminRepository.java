package com.hotelmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.model.Admin;
import com.hotelmanagement.model.Hotel;

public interface AdminRepository extends JpaRepository<Admin,Long> {
	
	Optional<Admin> findByAdminEmailIdAndAdminPassword(String emailId,String password);
	public List<Admin> findByAdminId(long AdminId);

} 
