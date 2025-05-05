// Declares that this file belongs to the com.demo.dao package
package com.demo.dao;

// Importing necessary classes
import java.util.List; // Used for handling lists of reservations
import com.demo.entity.Reservation; // Importing the Reservation entity class

// This interface defines methods for performing CRUD operations on Reservation entities
public interface ReservationDao {

	// Method to create and save a new reservation
	Reservation createReservation(Reservation reservation);

	// Method to retrieve a reservation by its ID
	Reservation getReservation(String reservationId);

	// Method to get a list of all reservations
	List<Reservation> getAllReservation();

	// Method to update an existing reservation by its ID
	Reservation updateReservation(String reservationId, Reservation updatedReservation);

	// Method to delete a reservation by its ID
	String deleteReservation(String reservationId);

	// Method to get a reservation by the associated restaurant ID
	Reservation getReservationByRestaurantId(String restaurantId);
}
