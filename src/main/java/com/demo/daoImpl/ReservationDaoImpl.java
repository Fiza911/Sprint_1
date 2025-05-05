package com.demo.daoImpl;

import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.demo.dao.ReservationDao;
import com.demo.entity.Reservation;
import util.HibernateUtil;

public class ReservationDaoImpl implements ReservationDao {

	// Scanner object for user input, used for delete confirmation
	Scanner sc = new Scanner(System.in);

	// Method to create a new reservation
	@Override
	public Reservation createReservation(Reservation reservation) {
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

	// Method to retrieve a reservation by its ID
	@Override
	public Reservation getReservation(String reservationId) {
		try (Session session = HibernateUtil.getSession()) {
			Reservation reservation = session.get(Reservation.class, reservationId); // Fetch reservation by ID
			return reservation; // Return the reservation object
		} catch (HibernateException e) {
			System.out.println(e); // Print any Hibernate exceptions
		} catch (Exception e) {
			System.out.println(e); // Print any other exceptions
		}
		return null; // Return null if something goes wrong
	}

	// Method to retrieve all reservations
	@Override
	public List<Reservation> getAllReservation() {
		try (Session session = HibernateUtil.getSession()) {
			// Create and execute an HQL query to fetch all reservations
			Query<Reservation> query = session.createQuery("FROM Reservation");
			List<Reservation> reservationList = query.list(); // Get the list of all reservations
			return reservationList; // Return the list of reservations
		} catch (HibernateException e) {
			System.out.println(e); // Print any Hibernate exceptions
		} catch (Exception e) {
			System.out.println(e); // Print any other exceptions
		}
		return null; // Return null if something goes wrong
	}

	// Method to update an existing reservation
	@Override
	public Reservation updateReservation(String reservationID, Reservation updatedReservation) {
		try (Session session = HibernateUtil.getSession()) {
			Reservation reservation = session.get(Reservation.class, reservationID); // Fetch reservation by ID
			session.beginTransaction(); // Begin transaction

			// Update reservation properties with the new values
			reservation.setReservationDate(updatedReservation.getReservationDate());
			reservation.setReservationTime(updatedReservation.getReservationTime());

			session.saveOrUpdate(reservation); // Save or update the reservation
			session.getTransaction().commit(); // Commit transaction
			return reservation; // Return the updated reservation
		} catch (HibernateException e) {
			System.out.println(e); // Print any Hibernate exceptions
		} catch (Exception e) {
			System.out.println(e); // Print any other exceptions
		}
		return null; // Return null if something goes wrong
	}

	// Method to delete a reservation
	@Override
	public String deleteReservation(String reservationId) {
		String message = null;
		try (Session session = HibernateUtil.getSession()) {
			Reservation reservation = session.get(Reservation.class, reservationId); // Fetch reservation by ID
			session.beginTransaction(); // Begin transaction

			// Prompt user for confirmation to delete the reservation
			System.out.println("Are you sure you want to delete?");
			String status = sc.next(); // Read user input
			if (status.equalsIgnoreCase("yes")) {
				session.delete(reservation); // Delete reservation from the database
				session.getTransaction().commit(); // Commit transaction
				session.evict(reservation); // Evict reservation from session cache
				message = "Object is deleted"; // Success message
			} else {
				message = "User wants to retain this object!!"; // Message if user cancels deletion
			}
		} catch (HibernateException e) {
			System.out.println(e); // Print any Hibernate exceptions
		} catch (Exception e) {
			System.out.println(e); // Print any other exceptions
		}
		return message; // Return the result message
	}

	// Method to retrieve reservation by restaurant ID
	@Override
	public Reservation getReservationByRestaurantId(String restaurantId) {
		Reservation reservation = null;
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();

			// Create and execute HQL query to find reservation by restaurant ID
			reservation = (Reservation) session.createQuery("FROM Reservation r WHERE r.reservationId = :reservationId")
					.setParameter("restaurantId", restaurantId.trim()).getSingleResult();

			if (reservation != null) {
				System.out.println("RestaurantId: " + reservation.getRestaurantId());
			}

			session.getTransaction().commit();
		} catch (NoResultException e) {
			System.out.println("No matching reservation found.");
		} catch (HibernateException e) {
			System.out.println("Hibernate error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return reservation; // Return the reservation object or null if not found
	}
}
