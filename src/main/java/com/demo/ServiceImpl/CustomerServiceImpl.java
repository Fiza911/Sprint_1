package com.demo.ServiceImpl;

import java.util.List;

import com.demo.Service.CustomerService;
import com.demo.dao.CustomerDao;
import com.demo.daoImpl.CustomerDaoImpl;
import com.demo.entity.Customer;

public class CustomerServiceImpl implements CustomerService {
	// Creating an instance of CustomerDao to interact with the database layer
	CustomerDao customerDao = new CustomerDaoImpl();

	// Method to create a new customer
	@Override
	public Customer createCustomer(Customer customer) {
		// Calling the createCustomer method of CustomerDao to persist the new customer
		return customerDao.createCustomer(customer);
	}

	// Method to retrieve a customer by their ID
	@Override
	public Customer getCustomer(String customerId) {
		// Calling the getCustomer method of CustomerDao to fetch the customer details
		// by ID
		return customerDao.getCustomer(customerId);
	}

	// Method to retrieve a list of all customers
	@Override
	public List<Customer> getAllCustomer() {
		// Calling the getAllCustomer method of CustomerDao to fetch all customers
		return customerDao.getAllCustomer();
	}

	// Method to update customer details
	@Override
	public Customer updateCustomer(String customerId, Customer updatedCustomer) {
		// Calling the updateCustomer method of CustomerDao to update customer data
		return customerDao.updateCustomer(customerId, updatedCustomer);
	}

	// Method to delete a customer by their ID
	@Override
	public String deleteCustomer(String customerId) {
		// Calling the deleteCustomer method of CustomerDao to remove a customer
		return customerDao.deleteCustomer(customerId);
	}

	// Method to authenticate customer login by their username and password
	@Override
	public Customer loginCustomer(String username, String password) {
		// Calling the getCustomerByUsernameAndPassword method of CustomerDao to
		// validate customer login
		return customerDao.getCustomerByUsernameAndPassword(username, password);
	}
}
