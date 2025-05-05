package com.demo.Service;

import com.demo.entity.Admin;

// AdminService interface provides the operations related to Admin management
public interface AdminService {
	// Method to create a new Admin
	Admin createAdmin(Admin admin);

	// Method to get an Admin by their ID
	Admin getAdmin(String adminID);

	// Method to log in an Admin using username and password
	Admin loginAdmin(String username, String password);
}
