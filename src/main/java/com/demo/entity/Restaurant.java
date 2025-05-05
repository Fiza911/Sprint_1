package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // Marks the class as a Hibernate entity (mapped to a database table)
public class Restaurant {

	@Id // Marks the field as primary key
	private String restaurantId; // Unique identifier for the restaurant
	private String restaurantName; // Name of the restaurant
	private String address; // Address of the restaurant
	private String menu; // Menu offered by the restaurant
	private String restaurantContactNo; // Contact number for the restaurant

	// Default constructor for Hibernate
	public Restaurant() {
		super();
	}

	// Parameterized constructor for creating a Restaurant instance
	public Restaurant(String restaurantId, String restaurantName, String address, String menu,
			String restaurantContactNo) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.address = address;
		this.menu = menu;
		this.restaurantContactNo = restaurantContactNo;
	}

	// Getter method for restaurantId
	public String getRestaurantId() {
		return restaurantId;
	}

	// Setter method for restaurantId
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}

	// Getter method for restaurantName
	public String getRestaurantName() {
		return restaurantName;
	}

	// Setter method for restaurantName
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	// Getter method for restaurantAddress
	public String getRestaurantAddress() {
		return address;
	}

	// Setter method for restaurantAddress
	public void setRestaurantAddress(String address) {
		this.address = address;
	}

	// Getter method for menu
	public String getMenu() {
		return menu;
	}

	// Setter method for menu
	public void setMenu(String menu) {
		this.menu = menu;
	}

	// Getter method for restaurantContactNo
	public String getRestaurantContactNo() {
		return restaurantContactNo;
	}

	// Setter method for restaurantContactNo
	public void setRestaurantContactNo(String restaurantContactNo) {
		this.restaurantContactNo = restaurantContactNo;
	}

	// Overridden toString method to provide a string representation of the
	// Restaurant object
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName
				+ ", restaurantAddress=" + address + ", menu=" + menu + ", restaurantContactNo=" + restaurantContactNo
				+ "]";
	}
}
