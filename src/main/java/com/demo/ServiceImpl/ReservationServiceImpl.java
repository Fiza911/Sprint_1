package com.demo.ServiceImpl;

import java.util.List;

import com.demo.Service.ReservationService;
import com.demo.dao.ReservationDao;
import com.demo.daoImpl.ReservationDaoImpl;
import com.demo.entity.Reservation;

public class ReservationServiceImpl implements ReservationService {
	// Creating an instance of ReservationDao to interact with the database layer
	ReservationDao reservationDao = new ReservationDaoImpl();

	// Method to create a new reservation
	@Override
	public Reservation createReservation(Reservation reservation) {
		// Calling the createReservation method of ReservationDao to persist the
		// reservation
		return reservationDao.createReservation(reservation);
	}

	// Method to retrieve a specific reservation by its ID
	@Override
	public Reservation getReservation(String reservationId) {
		// Calling the getReservation method of ReservationDao to fetch the reservation
		// by ID
		return reservationDao.getReservation(reservationId);
	}

	// Method to retrieve a list of all reservations
	@Override
	public List<Reservation> getAllReservation() {
		// Calling the getAllReservation method of ReservationDao to fetch all
		// reservations
		return reservationDao.getAllReservation();
	}

	// Method to update reservation details
	@Override
	public Reservation updateReservation(String reservationId, Reservation updatedReservation) {
		// Calling the updateReservation method of ReservationDao to update the
		// reservation data
		return reservationDao.updateReservation(reservationId, updatedReservation);
	}

	// Method to delete reservation by its ID
	@Override
	public String deleteReservation(String reservationId) {
		// Calling the deleteReservation method of ReservationDao to remove the
		// reservation
		return reservationDao.deleteReservation(reservationId);
	}

	// Method to get a reservation by its associated restaurant ID
	@Override
	public Reservation getReservationByRestaurantId(String restaurantId) {
		// Calling the getReservationByRestaurantId method of ReservationDao to fetch
		// reservation details by restaurant ID
		return reservationDao.getReservationByRestaurantId(restaurantId);
	}
}
