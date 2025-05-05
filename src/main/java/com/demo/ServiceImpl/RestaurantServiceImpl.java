package com.demo.ServiceImpl;

import java.util.List;

import com.demo.Service.RestaurantService;
import com.demo.entity.Reservation;
import com.demo.entity.Restaurant;
import com.demo.dao.RestaurantDao;
import com.demo.daoImpl.RestaurantDaoImpl;

public class RestaurantServiceImpl implements RestaurantService {

	// Creating an instance of RestaurantDao to interact with the database layer
	RestaurantDao restaurantDao = new RestaurantDaoImpl();

	// Method to create a new restaurant
	@Override
	public Restaurant createRestaurant(Restaurant restaurant) {
		// Calling the createRestaurant method of RestaurantDao to persist the
		// restaurant
		return restaurantDao.createRestaurant(restaurant);
	}

	// Method to retrieve a specific restaurant by its ID
	@Override
	public Restaurant getRestaurant(String restaurantId) {
		// Calling the getRestaurant method of RestaurantDao to fetch the restaurant by
		// its ID
		return restaurantDao.getRestaurant(restaurantId);
	}

	// Method to retrieve a list of all restaurants
	@Override
	public List<Restaurant> getAllRestaurant() {
		// Calling the getAllRestaurant method of RestaurantDao to fetch all restaurants
		return restaurantDao.getAllRestaurant();
	}

	// Method to handle table reservation for a restaurant
	@Override
	public Reservation tableReservation(Reservation reservation) {
		// Calling the tableReservation method of RestaurantDao to make a reservation
		return restaurantDao.tableReservation(reservation);
	}

	// Method to get reservation details by restaurant ID
	@Override
	public List<Reservation> getReservationDetailsByRestaurantId(String restaurantId) {
		// Calling the getReservationDetailsByRestauratId method of RestaurantDao to
		// fetch reservations for the specified restaurant
		return restaurantDao.getReservationDetailsByRestauratId(restaurantId);
	}

	// Method to update restaurant details
	@Override
	public Restaurant updateRestaurant(String restaurantId, Restaurant updatedRestaurant) {
		// Calling the updateRestaurant method of RestaurantDao to update the restaurant
		// details
		return restaurantDao.updateRestaurant(restaurantId, updatedRestaurant);
	}

	// Method to delete a restaurant by its ID
	@Override
	public String deleteRestaurant(String restaurantId) {
		// Calling the deleteRestaurant method of RestaurantDao to remove the restaurant
		return restaurantDao.deleteRestaurant(restaurantId);
	}
}
