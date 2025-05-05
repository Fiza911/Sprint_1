package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // Marks the class as a Hibernate entity (mapped to a database table)
public class Customer {

	@Id // Marks the field as primary key
	private String customerId;
	private String customerName;
	private String email;
	private String customerContactNo;
	private int totalReservations;
	private String username;
	private String password;

	// Default constructor
	public Customer() {
		super();
	}

	// Parameterized constructor
	public Customer(String customerId, String customerName, String email, String customerContactNo,
			int totalReservations, String username, String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.customerContactNo = customerContactNo;
		this.totalReservations = totalReservations;
		this.username = username;
		this.password = password;
	}

	// Getter and Setter methods
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCustomerContactNo() {
		return customerContactNo;
	}

	public void setCustomerContactNo(String customerContactNo) {
		this.customerContactNo = customerContactNo;
	}

	public int getTotalReservations() {
		return totalReservations;
	}

	public void setTotalReservations(int totalReservations) {
		this.totalReservations = totalReservations;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Overridden toString method for providing a string representation of the
	// Customer object
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", email=" + email
				+ ", customerContactNo=" + customerContactNo + ", totalReservations=" + totalReservations
				+ ", username=" + username + ", password=" + password + "]";
	}
}
