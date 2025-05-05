package com.demo.Service;

import java.util.List;

import com.demo.entity.Reservation;

// ReservationService interface defines the operations related to managing reservations
public interface ReservationService {

	// Method to create a new reservation
	Reservation createReservation(Reservation reservation);

	// Method to retrieve a reservation by its ID
	Reservation getReservation(String reservationId);

	// Method to retrieve all reservations
	List<Reservation> getAllReservation();

	// Method to update an existing reservation
	Reservation updateReservation(String reservationId, Reservation updatedReservation);

	// Method to delete a reservation by its ID
	String deleteReservation(String reservationId);

	// Method to get a reservation by its associated restaurant ID
	Reservation getReservationByRestaurantId(String restaurantId);
}
