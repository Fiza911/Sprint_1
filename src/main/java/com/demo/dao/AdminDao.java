package com.demo.dao;

import com.demo.entity.Admin;

// This interface is used to define methods for Admin-related database operations
public interface AdminDao {
	// Method to create and save a new admin in the database
	Admin createAdmin(Admin admin);

	// Method to get admin details by admin ID
	Admin getAdmin(String adminId);

	// Method to get admin details by username and password (used for login)
	Admin getAdminByUsernameAndPassword(String username, String password);
}
