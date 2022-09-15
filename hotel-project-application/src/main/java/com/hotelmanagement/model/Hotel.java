package com.hotelmanagement.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="hotel_table")
public class Hotel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="hotel_id")
	private int hotelId;
	
	@Column(name="hotel_name")
	@NotEmpty
	@Size(min=3 , message="hotelName must contain atleast 3 characters")
	private String hotelName;
	
	@Column(name="city")
	@NotEmpty
	@Size(min=3 , message="city must contain atleast 3 characters")
	private String hotelCity;
	
	@Column(name="hotel_review")
	@NotEmpty
	@Size(min=3 , message="hotelreview must contain atleast 3 characters")
	private String hotelReview;
	
	@Column(name="hotel_rating")
	@NotNull
	private int hotelRating;
	
	@Column(name="phone_number")
	@NotEmpty
	@Size(min=10 ,max=10, message="phoneNumber must contain  10 digits")
	private String phoneNumber;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "hts")
    private Set < Admin > adm = new HashSet < > ();

	
	public Set<Admin> getAdm() {
		return adm;
	}

	public void setAdm(Set<Admin> adm) {
		this.adm = adm;
	}
	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelCity() {
		return hotelCity;
	}

	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}

	public String getHotelReview() {
		return hotelReview;
	}

	public void setHotelReview(String hotelReview) {
		this.hotelReview = hotelReview;
	}

	public int getHotelRating() {
		return hotelRating;
	}

	public void setHotelRating(int hotelRating) {
		this.hotelRating = hotelRating;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelCity=" + hotelCity + ", hotelReview="
				+ hotelReview + ", hotelRating=" + hotelRating + ", phoneNumber=" + phoneNumber + "]";
	}
	
	

}
