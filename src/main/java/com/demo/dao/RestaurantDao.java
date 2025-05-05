// Declares the package this class belongs to
package com.demo.dao;

// Import required classes
import java.util.List; // Used for returning lists
import com.demo.entity.Reservation; // Used for reservation-related operations
import com.demo.entity.Restaurant; // Used for restaurant-related operations

// Interface defining operations for managing restaurants and related reservations
public interface RestaurantDao {

	// Method to create and save a new restaurant
	Restaurant createRestaurant(Restaurant restaurant);

	// Method to retrieve a restaurant by its ID
	Restaurant getRestaurant(String restaurantId);

	// Method to retrieve a list of all restaurants
	List<Restaurant> getAllRestaurant();

	// Method to reserve a table (creates a reservation)
	Reservation tableReservation(Reservation reservation);

	// Method to get reservation details for a specific restaurant by its ID
	List<Reservation> getReservationDetailsByRestauratId(String restaurantId);

	// Method to update an existing restaurant's details by its ID
	Restaurant updateRestaurant(String restaurantID, Restaurant updatedRestaurant);

	// Method to delete a restaurant by its ID
	String deleteRestaurant(String restaurantID);
}
