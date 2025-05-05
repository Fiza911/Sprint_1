package com.demo.ServiceImpl;

import com.demo.Service.AdminService;
import com.demo.dao.AdminDao;
import com.demo.daoImpl.AdminDaoImpl;
import com.demo.entity.Admin;

public class AdminServiceImpl implements AdminService {
	// Creating an instance of AdminDao to interact with the database layer
	AdminDao adminDao = new AdminDaoImpl();

	// Method to create a new admin
	@Override
	public Admin createAdmin(Admin admin) {
		// Calling the createAdmin method of AdminDao to persist the new admin
		return adminDao.createAdmin(admin);
	}

	// Method to retrieve an admin by their ID
	@Override
	public Admin getAdmin(String adminId) {
		// Calling the getAdmin method of AdminDao to fetch the admin details by ID
		return adminDao.getAdmin(adminId);
	}

	// Method to login an admin using their username and password
	@Override
	public Admin loginAdmin(String username, String password) {
		// Calling the getAdminByUsernameAndPassword method of AdminDao to validate
		// admin login
		return adminDao.getAdminByUsernameAndPassword(username, password);
	}
}
