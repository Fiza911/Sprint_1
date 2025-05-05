// Declares the package for this DAO interface
package com.demo.dao;

// Import necessary classes
import java.util.List; // Used to handle list of tables
import com.demo.entity.RestaurantTable; // Entity representing a table in the restaurant

// Interface to define database operations related to restaurant tables
public interface TableDao {

	// Method to create and save a new restaurant table
	RestaurantTable createTable(RestaurantTable table);

	// Method to retrieve a specific table by its ID
	RestaurantTable getTable(String tableId);

	// Method to retrieve a list of all restaurant tables
	List<RestaurantTable> getAllRestaurantTable();

	// Method to update the details of an existing table by its ID
	RestaurantTable updateRestaurantTable(String tableId, RestaurantTable updatedRestaurantTable);

	// Method to delete a table from the database using its ID
	String deleteRestaurantTable(String tableId);
}
