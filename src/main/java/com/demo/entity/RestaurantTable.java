package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Marks the class as a Hibernate entity (mapped to a database table)
@Table(name = "tables") // Specifies the table name in the database
public class RestaurantTable {

	@Id // Marks the field as the primary key
	private String tableId; // Unique identifier for the table
	private int tableNo; // Table number
	private int capacity; // Seating capacity of the table
	private int reservations; // Number of reservations made for the table
	private boolean isAvailable; // Availability status of the table (true if available, false if occupied)

	// Default constructor for Hibernate
	public RestaurantTable() {
		super();
	}

	// Parameterized constructor for creating a RestaurantTable instance
	public RestaurantTable(String tableId, int tableNo, int capacity, int reservations, boolean isAvailable) {
		super();
		this.tableId = tableId;
		this.tableNo = tableNo;
		this.capacity = capacity;
		this.reservations = reservations;
		this.isAvailable = isAvailable;
	}

	// Getter method for tableId
	public String getTableId() {
		return tableId;
	}

	// Setter method for tableId
	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	// Getter method for tableNo
	public int getTableNo() {
		return tableNo;
	}

	// Setter method for tableNo
	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}

	// Getter method for capacity
	public int getCapacity() {
		return capacity;
	}

	// Setter method for capacity
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	// Getter method for reservations
	public int getReservations() {
		return reservations;
	}

	// Setter method for reservations
	public void setReservations(int reservations) {
		this.reservations = reservations;
	}

	// Getter method for availability status
	public boolean isAvailable() {
		return isAvailable;
	}

	// Setter method for availability status
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	// Overridden toString method to provide a string representation of the
	// RestaurantTable object
	@Override
	public String toString() {
		return "Table [tableId=" + tableId + ", tableNo=" + tableNo + ", capacity=" + capacity + ", reservations="
				+ reservations + ", isAvailable=" + isAvailable + "]";
	}
}
