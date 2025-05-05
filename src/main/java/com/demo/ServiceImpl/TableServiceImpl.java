package com.demo.ServiceImpl;

import java.util.List;

import com.demo.Service.TableService;
import com.demo.dao.TableDao;
import com.demo.daoImpl.TableDaoImpl;
import com.demo.entity.RestaurantTable;

public class TableServiceImpl implements TableService {

	// Creating an instance of TableDao to interact with the database layer
	TableDao tableDao = new TableDaoImpl();

	// Method to create a new restaurant table
	@Override
	public RestaurantTable createTable(RestaurantTable table) {
		// Calling the createTable method of TableDao to save the table to the database
		return tableDao.createTable(table);
	}

	// Method to retrieve a specific restaurant table by its ID
	@Override
	public RestaurantTable getTable(String TableId) {
		// Calling the getTable method of TableDao to fetch the table by its ID
		return tableDao.getTable(TableId);
	}

	// Method to retrieve a list of all restaurant tables
	@Override
	public List<RestaurantTable> getAllRestaurantTable() {
		// Calling the getAllRestaurantTable method of TableDao to fetch all tables
		return tableDao.getAllRestaurantTable();
	}

	// Method to update the details of an existing restaurant table
	@Override
	public RestaurantTable updateRestaurantTable(String tableId, RestaurantTable updatedRestaurantTable) {
		// Calling the updateRestaurantTable method of TableDao to update table details
		return tableDao.updateRestaurantTable(tableId, updatedRestaurantTable);
	}

	// Method to delete a restaurant table by its ID
	@Override
	public String deleteRestaurantTable(String tableId) {
		// Calling the deleteRestaurantTable method of TableDao to remove the table
		return tableDao.deleteRestaurantTable(tableId);
	}
}
