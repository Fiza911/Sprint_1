package com.demo.dao;

import java.util.List;
import com.demo.entity.Customer;

// This interface defines the methods for Customer-related database operations
public interface CustomerDao {
	// Method to create and save a new customer
	Customer createCustomer(Customer customer);

	// Method to get a customer by their ID
	Customer getCustomer(String customerId);

	// Method to get a list of all customers
	List<Customer> getAllCustomer();

	// Method to update customer details using customer ID
	Customer updateCustomer(String customerId, Customer updatedCustomer);

	// Method to delete a customer by their ID
	String deleteCustomer(String customerId);

	// Method to get a customer by username and password (used for login)
	Customer getCustomerByUsernameAndPassword(String username, String password);
}
