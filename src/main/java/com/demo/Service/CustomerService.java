package com.demo.Service;

import java.util.List;

import com.demo.entity.Admin;
import com.demo.entity.Customer;

// CustomerService interface provides the operations related to Customer management
public interface CustomerService {
	// Method to create a new Customer
	Customer createCustomer(Customer customer);

	// Method to get a Customer by their ID
	Customer getCustomer(String customerId);

	// Method to get a list of all Customers
	List<Customer> getAllCustomer();

	// Method to update an existing Customer's information
	Customer updateCustomer(String customerId, Customer updatedCustomer);

	// Method to delete a Customer by their ID
	String deleteCustomer(String customerId);

	// Method for Customer login using username and password
	Customer loginCustomer(String username, String password);
}
