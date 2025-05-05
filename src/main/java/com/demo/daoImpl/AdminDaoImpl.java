// Declares the package where this class belongs
package com.demo.daoImpl;

// Imports needed for exception handling and Hibernate session
import javax.persistence.NoResultException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.demo.dao.AdminDao;
import com.demo.entity.Admin;

import util.HibernateUtil; // Utility class to get Hibernate sessions

// Implementation of AdminDao interface
public class AdminDaoImpl implements AdminDao {

	// Method to create and save a new Admin
	@Override
	public Admin createAdmin(Admin admin) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction(); // Start transaction
			session.save(admin); // Save admin to the database
			session.getTransaction().commit(); // Commit transaction
			return admin;
		} catch (HibernateException e) {
			System.out.println(e); // Handle Hibernate-specific errors
		} catch (Exception e) {
			System.out.println(e); // Handle any other unexpected errors
		}
		return null; // Return null if creation fails
	}

	// Method to get an Admin by ID
	@Override
	public Admin getAdmin(String adminId) {
		try (Session session = HibernateUtil.getSession()) {
			Admin admin = session.get(Admin.class, adminId); // Fetch admin by primary key
			return admin;
		} catch (HibernateException e) {
			System.out.println(e); // Handle Hibernate-specific errors
		} catch (Exception e) {
			System.out.println(e); // Handle other errors
		}
		return null; // Return null if retrieval fails
	}

	// Method to get an Admin using username and password (for login)
	@Override
	public Admin getAdminByUsernameAndPassword(String username, String password) {
		Admin admin = null;
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction(); // Start transaction

			// HQL query to find admin by username and password
			admin = (Admin) session.createQuery("FROM Admin a WHERE a.username = :username AND a.password = :password")
					.setParameter("username", username.trim()).setParameter("password", password.trim())
					.getSingleResult();

			if (admin != null) {
				System.out.println("Username: " + admin.getUsername() + ", Password: " + admin.getPassword());
			}

			session.getTransaction().commit(); // Commit transaction
		} catch (NoResultException e) {
			System.out.println("No matching admin found."); // No result case
		} catch (HibernateException e) {
			System.out.println("Hibernate error: " + e.getMessage()); // Hibernate error
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage()); // General error
		}
		return admin; // Return the found admin or null
	}
}
