package com.demo.daoImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.demo.dao.TableDao;
import com.demo.entity.Customer;
import com.demo.entity.RestaurantTable;

import util.HibernateUtil;

public class TableDaoImpl implements TableDao {

	// Scanner object for user input, used for delete confirmation
	Scanner sc = new Scanner(System.in);

	// Method to create a new restaurant table
	@Override
	public RestaurantTable createTable(RestaurantTable table) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction(); // Begin transaction
			session.save(table); // Save the table object to the database
			session.getTransaction().commit(); // Commit transaction
			return table; // Return the saved table object
		} catch (HibernateException e) {
			System.out.println(e); // Print any Hibernate exceptions
		} catch (Exception e) {
			System.out.println(e); // Print any other exceptions
		}
		return null; // Return null if something goes wrong
	}

	// Method to retrieve a restaurant table by its ID
	@Override
	public RestaurantTable getTable(String tableId) {
		try (Session session = HibernateUtil.getSession()) {
			RestaurantTable table = session.get(RestaurantTable.class, tableId); // Fetch table by ID
			return table; // Return the table object
		} catch (HibernateException e) {
			System.out.println(e); // Print any Hibernate exceptions
		} catch (Exception e) {
			System.out.println(e); // Print any other exceptions
		}
		return null; // Return null if something goes wrong
	}

	// Method to retrieve all restaurant tables
	@Override
	public List<RestaurantTable> getAllRestaurantTable() {
		try (Session session = HibernateUtil.getSession()) {
			// Create and execute an HQL query to fetch all restaurant tables
			Query<RestaurantTable> query = session.createQuery("FROM RestaurantTable");
			List<RestaurantTable> tableList = query.list(); // Get the list of all tables
			return tableList; // Return the list of tables
		} catch (HibernateException e) {
			System.out.println(e); // Print any Hibernate exceptions
		} catch (Exception e) {
			System.out.println(e); // Print any other exceptions
		}
		return null; // Return null if something goes wrong
	}

	// Method to update an existing restaurant table
	@Override
	public RestaurantTable updateRestaurantTable(String tableID, RestaurantTable updatedCustomer) {
		try (Session session = HibernateUtil.getSession()) {
			RestaurantTable table = session.get(RestaurantTable.class, tableID); // Fetch table by ID
			session.beginTransaction(); // Begin transaction

			// Update table properties with the new values
			table.setTableId(tableID);
			table.setTableNo(updatedCustomer.getTableNo());
			table.setCapacity(updatedCustomer.getCapacity());
			table.setReservations(updatedCustomer.getReservations());
			table.setAvailable(updatedCustomer.isAvailable());

			session.saveOrUpdate(table); // Save or update the table
			session.getTransaction().commit(); // Commit transaction
			return table; // Return the updated table
		} catch (HibernateException e) {
			System.out.println(e); // Print any Hibernate exceptions
		} catch (Exception e) {
			System.out.println(e); // Print any other exceptions
		}
		return null; // Return null if something goes wrong
	}

	// Method to delete a restaurant table
	@Override
	public String deleteRestaurantTable(String customerId) {
		String message = null;
		try (Session session = HibernateUtil.getSession()) {
			RestaurantTable table = session.get(RestaurantTable.class, customerId); // Fetch table by ID
			session.beginTransaction(); // Begin transaction

			// Prompt user for confirmation to delete the table
			System.out.println("Are you sure you want to delete?");
			String status = sc.next(); // Read user input
			if (status.equalsIgnoreCase("yes")) {
				session.delete(table); // Delete the table from the database
				session.getTransaction().commit(); // Commit transaction
				session.evict(table); // Evict table from session cache
				message = "Table is deleted"; // Success message
			} else {
				message = "User wants to retain this table"; // Message if user cancels deletion
			}
		} catch (HibernateException e) {
			System.out.println(e); // Print any Hibernate exceptions
		} catch (Exception e) {
			System.out.println(e); // Print any other exceptions
		}
		return message; // Return the result message
	}
}
