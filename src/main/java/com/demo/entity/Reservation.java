package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // Marks the class as a Hibernate entity (mapped to a database table)
public class Reservation {

	@Id // Marks the field as primary key
	private String reservationId; // Unique identifier for the reservation
	private String restaurantId; // Identifier for the associated restaurant
	private String customerId; // Identifier for the customer making the reservation
	private String tableId; // Identifier for the reserved table
	private String reservationDate; // Date of the reservation
	private String reservationTime; // Time of the reservation

	// Default constructor for Hibernate
	public Reservation() {
		super();
	}

	// Parameterized constructor for creating a Reservation instance
	public Reservation(String reservationId, String restaurantId, String customerId, String tableId,
			String reservationDate, String reservationTime) {
		super();
		this.reservationId = reservationId;
		this.restaurantId = restaurantId;
		this.customerId = customerId;
		this.tableId = tableId;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
	}

	// Getter method for reservationId
	public String getReservationId() {
		return reservationId;
	}

	// Setter method for reservationId
	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	// Getter method for restaurantId
	public String getRestaurantId() {
		return restaurantId;
	}

	// Setter method for restaurantId
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}

	// Getter method for customerId
	public String getCustomerId() {
		return customerId;
	}

	// Setter method for customerId
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	// Getter method for tableId
	public String getTableId() {
		return tableId;
	}

	// Setter method for tableId
	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	// Getter method for reservationDate
	public String getReservationDate() {
		return reservationDate;
	}

	// Setter method for reservationDate
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	// Getter method for reservationTime
	public String getReservationTime() {
		return reservationTime;
	}

	// Setter method for reservationTime
	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}

	// Overridden toString method to provide a string representation of the
	// Reservation object
	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", restaurantId=" + restaurantId + ", customerId="
				+ customerId + ", tableId=" + tableId + ", reservationDate=" + reservationDate + ", reservationTime="
				+ reservationTime + "]";
	}
}
