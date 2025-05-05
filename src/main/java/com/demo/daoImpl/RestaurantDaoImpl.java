package com.demo.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.demo.dao.RestaurantDao;
import com.demo.entity.Reservation;
import com.demo.entity.Restaurant;
import exception.ResourceNotFoundException;
import util.HibernateUtil;

public class RestaurantDaoImpl implements RestaurantDao {

	// Scanner object for user input, used for delete confirmation
	Scanner sc = new Scanner(System.in);

	// Method to create a new restaurant
	@Override
	public Restaurant createRestaurant(Restaurant restaurant) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction(); // Begin transaction
			session.save(restaurant); // Save the restaurant object to the database
			session.getTransaction().commit(); // Commit transaction
			return restaurant; // Return the saved restaurant object
		} catch (HibernateException e) {
			System.out.println(e); // Print any Hibernate exceptions
		} catch (Exception e) {
			System.out.println(e); // Print any other exceptions
		}
		return null; // Return null if something goes wrong
	}

	// Method to retrieve a restaurant by its ID
	@Override
	public Restaurant getRestaurant(String restaurantId) {
		try (Session session = HibernateUtil.getSession()) {
			Restaurant restaurant = session.get(Restaurant.class, restaurantId); // Fetch restaurant by ID
			return restaurant; // Return the restaurant object
		} catch (HibernateException e) {
			System.out.println(e); // Print any Hibernate exceptions
		} catch (Exception e) {
			System.out.println(e); // Print any other exceptions
		}
		return null; // Return null if something goes wrong
	}

	// Method to retrieve all restaurants
	@Override
	public List<Restaurant> getAllRestaurant() {
		try (Session session = HibernateUtil.getSession()) {
			// Create and execute an HQL query to fetch all restaurants
			Query<Restaurant> query = session.createQuery("FROM Restaurant");
			List<Restaurant> restaurantList = query.list(); // Get the list of all restaurants
			return restaurantList; // Return the list of restaurants
		} catch (HibernateException e) {
			System.out.println(e); // Print any Hibernate exceptions
		} catch (Exception e) {
			System.out.println(e); // Print any other exceptions
		}
		return null; // Return null if something goes wrong
	}

	// Method to create a table reservation
	@Override
	public Reservation tableReservation(Reservation reservation) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction(); // Begin transaction
			session.save(reservation); // Save the reservation object to the database
			session.getTransaction().commit(); // Commit transaction
			return reservation; // Return the saved reservation object
		} catch (HibernateException e) {
			System.out.println(e); // Print any Hibernate exceptions
		} catch (Exception e) {
			System.out.println(e); // Print any other exceptions
		}
		return null; // Return null if something goes wrong
	}

	// Method to retrieve reservation details by restaurant ID
	@Override
	public List<Reservation> getReservationDetailsByRestauratId(String restaurantId) {
		try (Session session = HibernateUtil.getSession()) {
			Restaurant restaurant = session.get(Restaurant.class, restaurantId); // Fetch restaurant by ID
			if (restaurant != null) {
				List<Reservation> reserve = new ArrayList<>(); // Create a list for storing reservations
				// Execute HQL query to retrieve all reservations
				Query<Reservation> query = session.createQuery("FROM Reservation");
				List<Reservation> reservationList = query.list(); // Get the list of all reservations
				// Filter reservations that belong to the given restaurant
				for (Reservation r : reservationList) {
					if (r.getRestaurantId().equals(restaurantId)) {
						reserve.add(r); // Add matching reservations to the list
					}
				}
				return reserve; // Return the filtered list of reservations
			} else {
				throw new ResourceNotFoundException("Restaurant id is not found"); // Throw exception if restaurant not
																					// found
			}
		} catch (HibernateException e) {
			System.out.println(e); // Print any Hibernate exceptions
		} catch (Exception e) {
			System.out.println(e); // Print any other exceptions
		}
		return null; // Return null if something goes wrong
	}

	// Method to update an existing restaurant
	@Override
	public Restaurant updateRestaurant(String restaurantID, Restaurant updatedRestaurant) {
		try (Session session = HibernateUtil.getSession()) {
			Restaurant restaurant = session.get(Restaurant.class, restaurantID); // Fetch restaurant by ID
			session.beginTransaction(); // Begin transaction

			// Update restaurant properties with the new values
			restaurant.setRestaurantId(restaurantID);
			restaurant.setRestaurantName(updatedRestaurant.getRestaurantName());
			restaurant.setRestaurantAddress(updatedRestaurant.getRestaurantAddress());
			restaurant.setMenu(updatedRestaurant.getMenu());
			restaurant.setRestaurantContactNo(updatedRestaurant.getRestaurantContactNo());

			session.saveOrUpdate(restaurant); // Save or update the restaurant
			session.getTransaction().commit(); // Commit transaction
			return restaurant; // Return the updated restaurant
		} catch (HibernateException e) {
			System.out.println(e); // Print any Hibernate exceptions
		} catch (Exception e) {
			System.out.println(e); // Print any other exceptions
		}
		return null; // Return null if something goes wrong
	}

	// Method to delete a restaurant
	@Override
	public String deleteRestaurant(String restaurantId) {
		String message = null;
		try (Session session = HibernateUtil.getSession()) {
			Restaurant restaurant = session.get(Restaurant.class, restaurantId); // Fetch restaurant by ID
			session.beginTransaction(); // Begin transaction

			// Prompt user for confirmation to delete the restaurant
			System.out.println("Are you sure you want to delete?");
			String status = sc.next(); // Read user input
			if (status.equalsIgnoreCase("yes")) {
				session.delete(restaurant); // Delete the restaurant from the database
				session.getTransaction().commit(); // Commit transaction
				session.evict(restaurant); // Evict restaurant from session cache
				message = "Restaurant is deleted"; // Success message
			} else {
				message = "User wants to retain this restaurant"; // Message if user cancels deletion
			}
		} catch (HibernateException e) {
			System.out.println(e); // Print any Hibernate exceptions
		} catch (Exception e) {
			System.out.println(e); // Print any other exceptions
		}
		return message; // Return the result message
	}
}
