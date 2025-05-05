package com.demo.Service;

import java.util.List;

import com.demo.entity.Reservation;
import com.demo.entity.Restaurant;

// RestaurantService interface defines the operations related to managing restaurants and reservations
public interface RestaurantService {

	// Method to create a new restaurant
	Restaurant createRestaurant(Restaurant restaurant);

	// Method to retrieve all restaurants
	List<Restaurant> getAllRestaurant();

	// Method to create a reservation for a table at a restaurant
	Reservation tableReservation(Reservation reservation);

	// Method to retrieve a restaurant by its ID
	Restaurant getRestaurant(String restaurantId);

	// Method to retrieve all reservations made for a specific restaurant
	List<Reservation> getReservationDetailsByRestaurantId(String restaurantId);

	// Method to update an existing restaurant's details
	Restaurant updateRestaurant(String restaurantId, Restaurant updatedRestaurant);

	// Method to delete a restaurant by its ID
	String deleteRestaurant(String restaurantId);
}
