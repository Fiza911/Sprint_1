package com.demo.Service;

import java.util.List;

import com.demo.entity.RestaurantTable;

// TableService interface defines the operations related to managing restaurant tables
public interface TableService {

	// Method to create a new restaurant table
	RestaurantTable createTable(RestaurantTable table);

	// Method to retrieve a restaurant table by its ID
	RestaurantTable getTable(String tableId);

	// Method to retrieve all restaurant tables
	List<RestaurantTable> getAllRestaurantTable();

	// Method to update a restaurant table's details
	RestaurantTable updateRestaurantTable(String tableId, RestaurantTable updatedRestaurantTable);

	// Method to delete a restaurant table by its ID
	String deleteRestaurantTable(String tableId);
}
