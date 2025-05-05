package com.demo.restaurant_reservation_system;

import java.util.List;
import java.util.Scanner;
import static com.demo.restaurant_reservation_system.MainOperations.*;

import com.demo.entity.Admin;
import com.demo.entity.Customer;
import com.demo.entity.Feedback;
import com.demo.entity.Reservation;
import com.demo.entity.Restaurant;
import com.demo.entity.RestaurantTable;

import exception.ResourceNotFoundException;

import com.demo.Service.AdminService;
import com.demo.Service.CustomerService;
import com.demo.Service.FeedbackService;
import com.demo.Service.ReservationService;
import com.demo.Service.RestaurantService;
import com.demo.Service.TableService;

import com.demo.ServiceImpl.AdminServiceImpl;
import com.demo.ServiceImpl.CustomerServiceImpl;
import com.demo.ServiceImpl.FeedbackServiceImpl;
import com.demo.ServiceImpl.ReservationServiceImpl;
import com.demo.ServiceImpl.RestaurantServiceImpl;
import com.demo.ServiceImpl.TableServiceImpl;

public class AllOperations {
	static ReservationService reservationService = new ReservationServiceImpl();
	static RestaurantService restaurantService = new RestaurantServiceImpl();
	static CustomerService customerService = new CustomerServiceImpl();
	static TableService tableService = new TableServiceImpl();
	static AdminService adminService = new AdminServiceImpl();
	static FeedbackService feedbackService = new FeedbackServiceImpl();

	static Scanner sc = new Scanner(System.in);

	// For admin login
	public static boolean adminLogin() {
		System.out.print("Enter username: ");
		String username = sc.next();

		System.out.print("Enter password: ");
		String password = sc.next();

		Admin admin = adminService.loginAdmin(username, password);

		if (admin != null) {
			System.out.println("Login successful! Welcome " + admin.getUsername());
			adminDashboard();
			return true;
		} else {
			System.out.println("Invalid username or password. Please try again.");
			return false;
		}
	}

	// Admin dashboard
	public static void adminDashboard() {
		System.out.println("\n1.Restaurant details\n" + "2.Customer details\n" + "3.Table details\n"
				+ "4.Reservation details\n" + "5.Feedback details\n" + "6.To get back");
		int a = sc.nextInt();

		switch (a) {
		case 1:
			RestaurantOperations();
			break;
		case 2:
			CustomerDetails();
			break;
		case 3:
			TableOperations();
			break;
		case 4:
			ReservationDetails();
			break;
		case 5:
			FeedbackDetails();
			break;
		case 6:
			mainOps();
		default:
			System.out.println("Invalid choice. Please try again.");
		}
	}

	// Restaurant details(admin)
	public static Void RestaurantOperations() {
		while (true) {
			System.out.println("\nPress 1.Add Restaurant Details\n" + "Press 2.Retrieve All Restaurant Data\n"
					+ "Press 3.Update Restaurant Data\n" + "Press 4.Delete Restaurant Data\n" + "Press 5.To getback");
			int ip2 = sc.nextInt();

			switch (ip2) {
			case 1:
				Restaurant restaurant = restaurantInputs();
				Restaurant savedEntity = restaurantService.createRestaurant(restaurant);
				System.out.println("Restaurant Data has been saved successfully");
				System.out.println(savedEntity);
				break;

			case 2:
				List<Restaurant> restaurants = restaurantService.getAllRestaurant();
				for (Restaurant res : restaurants) {
					System.out.println(res);
				}
				break;
			case 3:
				sc.nextLine();
				System.out.println("Enter Restaurant Id to update the infromation");
				String restaurantId = sc.next();
				Restaurant r = restaurantService.getRestaurant(restaurantId);
				if (r != null) {
					Restaurant res = updatedRestaurantData();
					// service
					Restaurant updatedInfo = restaurantService.updateRestaurant(restaurantId, res);
					System.out.println("Restaurant Data has been updated Successfully");
					System.out.println(updatedInfo);
				} else {
					throw new ResourceNotFoundException("Restaurant Id not found");
				}
				break;
			case 4:
				System.out.println("Enter Restaurant Id to delete the infromation");
				String restaurantID = sc.next();
				String message = restaurantService.deleteRestaurant(restaurantID);
				System.out.println(message);
				break;
			case 5:
				adminDashboard();
			}
		}
	}

	// to add restaurant data
	public static Restaurant restaurantInputs() {
		sc.nextLine();
		System.out.println("Enter Restaurant ID : ");
		String restaurantId = sc.nextLine();

		System.out.println("Enter Restaurant Name : ");
		String restaurantName = sc.nextLine();

		System.out.println("Enter Restaurant Address : ");
		String address = sc.nextLine();

		System.out.println("Enter Restaurant Menu : ");
		String menu = sc.nextLine();

		System.out.println("Enter Restaurant Contact no : ");
		String restaurantContactNo = sc.nextLine();

		return new Restaurant(restaurantId, restaurantName, address, menu, restaurantContactNo);
	}

	// to update restaurant data
	public static Restaurant updatedRestaurantData() {
		sc.nextLine();

		System.out.println("Enter Restaurant id");
		String restaurantId = sc.nextLine();

		System.out.println("Enter Restaurant Name");
		String restaurantName = sc.nextLine();

		System.out.println("Enter Addresss");
		String address = sc.nextLine();

		System.out.println("Enter Menu");
		String menu = sc.nextLine();

		System.out.println("Enter contact no");
		String restaurantContactNo = sc.nextLine();

		return new Restaurant(restaurantId, restaurantName, address, menu, restaurantContactNo);
	}

	// To retrieve customer details(admin)
	public static void CustomerDetails() {
		while (true) {
			System.out.println("\n1.To retrieve customer details\n" + "2.To getback");
			int c = sc.nextInt();
			switch (c) {
			case 1:
				List<Customer> customers = customerService.getAllCustomer();
				for (Customer c1 : customers) {
					System.out.println(c1);
				}
				break;
			case 2:
				adminDashboard();
			default:
				System.out.println("Invalid choice. Please try again.");

			}
		}
	}

	// For table details(admin)
	public static Void TableOperations() {
		while (true) {
			System.out.println("\nPress 1.Add Table Details\n" + "Press 2.Retrieve All Table Data\n"
					+ "Press 3.Update Table Data\n" + "Press 4.Delete Table Data\n" + "Press 5.To getback");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				RestaurantTable table = tableInputs();
				RestaurantTable tbl = tableService.createTable(table);
				System.out.println("Table details added successfully");
				System.out.println(tbl);
				break;
			case 2:
				List<RestaurantTable> tables = tableService.getAllRestaurantTable();
				for (RestaurantTable tbls : tables) {
					System.out.println(tbls);
				}
				break;
			case 3:
				sc.nextLine();
				System.out.println("Enter table Id to update the infromation");
				String tableId = sc.next();
				RestaurantTable t = tableService.getTable(tableId);
				if (t != null) {
					RestaurantTable rt = updatedRestaurantTableData();
					// service
					RestaurantTable updatedInfo = tableService.updateRestaurantTable(tableId, rt);
					System.out.println("table Data has been updated Successfully" + updatedInfo);
				} else {
					throw new ResourceNotFoundException("table Id not found");
				}
				break;

			case 4:
				System.out.println("Enter Table Id to delete the infromation");
				String tableID = sc.next();
				String message = tableService.deleteRestaurantTable(tableID);
				System.out.println(message);
				break;
			case 5:
				adminDashboard();
			}
		}
	}

	// to add table details
	public static RestaurantTable tableInputs() {
		sc.nextLine();
		System.out.println("Enter Table ID : ");
		String tableId = sc.nextLine();

		System.out.println("Enter Table no : ");
		int tableNo = sc.nextInt();

		System.out.println("Enter table capacity : ");
		int capacity = sc.nextInt();

		System.out.println("Enter table reservations : ");
		int reservations = sc.nextInt();

		System.out.println("Is table available :  : ");
		boolean isAvailable = sc.nextBoolean();

		sc.nextLine();

		return new RestaurantTable(tableId, tableNo, capacity, reservations, isAvailable);
	}

	// to update table details
	public static RestaurantTable updatedRestaurantTableData() {
		sc.nextLine();
		System.out.println("Enter table Id");
		String tableId = sc.nextLine();

		System.out.println("Enter table no");
		int tableNo = sc.nextInt();

		System.out.println("Enter capacity");
		int capacity = sc.nextInt();

		System.out.println("Enter reservations");
		int reservations = sc.nextInt();

		System.out.println("Enter is table available");
		boolean isAvailable = sc.nextBoolean();

		return new RestaurantTable(tableId, tableNo, capacity, reservations, isAvailable);
	}

	// To retrieve reservation details(admin)
	public static Void ReservationDetails() {
		while (true) {
			System.out.println("\n1.To retrieve reservation details\n" + "2.To getback");
			int c = sc.nextInt();
			switch (c) {
			case 1:
				List<Reservation> reservation = reservationService.getAllReservation();
				for (Reservation tbls : reservation) {
					System.out.println(tbls);
				}
				break;
			case 2:
				adminDashboard();
			default:
				System.out.println("Invalid choice. Please try again.");

			}
		}
	}

	// To retrieve feedback details(admin)
	public static Void FeedbackDetails() {
		while (true) {
			System.out.println("\n1.To retrieve feedback details\n" + "2.To getback");
			int c = sc.nextInt();
			switch (c) {
			case 1:
				List<Feedback> feedbacks = feedbackService.getAllFeedback();
				for (Feedback fed : feedbacks) {
					System.out.println(fed);
				}
				break;
			case 2:
				adminDashboard();
			default:
				System.out.println("Invalid choice. Please try again.");

			}
		}
	}

	// For customer login
	public static boolean customerLogin() {
		System.out.print("Enter username: ");
		String username = sc.next();

		System.out.print("Enter password: ");
		String password = sc.next();

		Customer customer = customerService.loginCustomer(username, password);

		if (customer != null) {
			System.out.println("Login successful! Welcome " + customer.getUsername());
			customerDashboard();
			return true;
		} else {
			System.out.println("Invalid username or password. Please try again.");
			return false;
		}
	}

	// customer dashboard
	public static void customerDashboard() {
		System.out.println("\n1.Customer details\n" + "2.Restaurant details\n" + "3.Table details\n"
				+ "4.Reservation details\n" + "5.Feedback details\n" + "6.To get back");
		int a = sc.nextInt();

		switch (a) {
		case 1:
			CustomerOperations();
			break;
		case 2:
			RestaurantDetails();
			break;
		case 3:
			TableDetails();
			break;
		case 4:
			ReservationOperations();
			break;
		case 5:
			feedbackOperations();
			break;
		case 6:
			mainOps();
		default:
			System.out.println("Invalid choice. Please try again.");
		}
	}

	// for customer details(customer)
	public static Void CustomerOperations() {
		while (true) {
			System.out.println("\nPress 1.Add Customer Details\n" + "Press 2.Retrieve Customer Details\n"
					+ "Press 3.Update Customer Details\n" + "Press 4.Delete Customer Data\n" + "Press 5.To getback");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				Customer customer = customerInputs();
				Customer savedEntity = customerService.createCustomer(customer);
				System.out.println("Customer Data has been saved successfully");
				System.out.println(savedEntity);
				break;
			case 2:
				List<Customer> customers = customerService.getAllCustomer();
				for (Customer c : customers) {
					System.out.println(c);
				}
				break;
			case 3:
				sc.nextLine();
				System.out.println("Enter Customer Id to update the infromation");
				String customerId = sc.next();
				Customer c = customerService.getCustomer(customerId);
				if (c != null) {
					Customer res = updatedCustomerData();
					// service
					Customer updatedInfo = customerService.updateCustomer(customerId, res);
					System.out.println("Restaurant Data has been updated Successfully" + updatedInfo);
				} else {
					throw new ResourceNotFoundException("Customer Id not found");
				}
				break;
			case 4:
				System.out.println("Enter Customer Id to delete the infromation");
				String customerID = sc.next();
				String message = customerService.deleteCustomer(customerID);
				System.out.println(message);
				break;
			case 5:
				customerDashboard();
			}
		}
	}

	// to add customer data
	public static Customer customerInputs() {
		sc.nextLine();
		System.out.println("Enter Customer ID : ");
		String customerId = sc.nextLine();

		System.out.println("Enter Customer Name : ");
		String customerName = sc.nextLine();

		System.out.println("Enter Email : ");
		String email = sc.nextLine();

		System.out.println("Enter Customer Contact no : ");
		String customerContactNo = sc.nextLine();

		System.out.println("Enter totalReservations : ");
		int totalReservations = sc.nextInt();

		System.out.println("Enter username : ");
		String username = sc.nextLine();

		System.out.println("Enter password : ");
		String password = sc.nextLine();

		return new Customer(customerId, customerName, email, customerContactNo, totalReservations, username, password);
	}

	// to update customer data
	public static Customer updatedCustomerData() {
		sc.nextLine();
		System.out.println("Enter Customer Id");
		String customerId = sc.nextLine();

		System.out.println("Enter Customer Name");
		String customerName = sc.nextLine();

		System.out.println("Enter Email");
		String email = sc.nextLine();

		System.out.println("Enter contact no");
		String customerContactNo = sc.nextLine();

		System.out.println("Enter totalReservations");
		int totalReservations = sc.nextInt();

		System.out.println("Enter username : ");
		String username = sc.nextLine();

		System.out.println("Enter password : ");
		String password = sc.nextLine();

		return new Customer(customerId, customerName, email, customerContactNo, totalReservations, username, password);
	}

	// To retrieve restaurant details(customer)
	public static Void RestaurantDetails() {
		while (true) {
			System.out.println("\n1.To retrieve restaurant details\n" + "2.To getback");
			int c = sc.nextInt();
			switch (c) {
			case 1:
				List<Restaurant> restaurants = restaurantService.getAllRestaurant();
				for (Restaurant res : restaurants) {
					System.out.println(res);
				}
				break;
			case 2:
				customerDashboard();
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	// to retrieve table details(customer)
	public static Void TableDetails() {
		while (true) {
			System.out.println("\n1.To retrieve table details\n" + "2.To getback");
			int c = sc.nextInt();
			switch (c) {
			case 1:
				List<RestaurantTable> tables = tableService.getAllRestaurantTable();
				for (RestaurantTable tbls : tables) {
					System.out.println(tbls);
				}
				break;
			case 2:
				customerDashboard();
			default:
				System.out.println("Invalid choice. Please try again.");

			}
		}
	}

	// for reservation(customer)
	public static Void ReservationOperations() {
		while (true) {
			System.out.println("\nPress 1.To make Reservation \n" + "Press 2.To Retrieve Reservation Data\n"
					+ "Press 3.To Update Reservation Data\n" + "Press 4.To cancel Reservation \n"
					+ "Press 5.To getback");
			int ip2 = sc.nextInt();

			switch (ip2) {
			case 1:
				Reservation reservation = reservationInputs();
				Reservation savedEntity = reservationService.createReservation(reservation);
				System.out.println("Reservation Data has been saved successfully");
				System.out.println(savedEntity);
				break;

			case 2:
				List<Reservation> reservations = reservationService.getAllReservation();
				for (Reservation res : reservations) {
					System.out.println(res);
				}
				break;
			case 3:
				sc.nextLine();
				System.out.println("Enter Reservation Id to update the infromation");
				String reservationId = sc.next();
				Reservation r = reservationService.getReservation(reservationId);
				if (r != null) {
					Reservation res = updatedreservationData(); // ✅ corrected method name
					Reservation updatedInfo = reservationService.updateReservation(reservationId, res);
					System.out.println("Reservation Data has been updated Successfully");
					System.out.println(updatedInfo);
				} else {
					throw new ResourceNotFoundException("Reservation Id not found");
				}
				break;

			case 4:
				System.out.println("Enter Reservation Id to delete the infromation");
				String reservationID = sc.next();
				String message = reservationService.deleteReservation(reservationID);
				System.out.println(message);
				break;
			case 5:
				customerDashboard();
			}
		}
	}

	// to add reservation details
	public static Reservation reservationInputs() {
		sc.nextLine();
		System.out.println("Enter Reservation ID : ");
		String reservationId = sc.nextLine();

		System.out.println("Enter Restaurant Id : ");
		String restaurantId = sc.nextLine();

		System.out.println("Enter Customer Id : ");
		String customerId = sc.nextLine();

		System.out.println("Enter Table Id : ");
		String tableId = sc.nextLine();

		System.out.println("Enter Reservation date : ");
		String reservationDate = sc.nextLine();

		System.out.println("Enter Reservation time : ");
		String reservationTime = sc.nextLine();

		return new Reservation(reservationId, restaurantId, customerId, tableId, reservationDate, reservationTime);
	}

	// to update reservation details
	public static Reservation updatedreservationData() {
		sc.nextLine();

		System.out.println("Enter Reservation Date");
		String reservationDate = sc.nextLine();

		System.out.println("Enter Reservation Time");
		String reservationTime = sc.nextLine();

		Reservation res = new Reservation();
		res.setReservationDate(reservationDate);
		res.setReservationTime(reservationTime);

		return res;
	}

	// For feedback details
	public static Void feedbackOperations() {
		while (true) {
			System.out.println("\nPress 1.Add Feedback\n" + "Press 2.Retrieve Feedback\n" + "Press 3.Update Feedback\n"
					+ "Press 4.Delete Feedback Data\n" + "Press 5.To getback");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				Feedback feedback = provideFeedback();
				Feedback savedEntity = feedbackService.createFeedback(feedback);
				System.out.println("Your feedback has been stored successfully");
				System.out.println(savedEntity);
				break;
			case 2:
				List<Feedback> feedbacks = feedbackService.getAllFeedback();
				for (Feedback fed : feedbacks) {
					System.out.println(fed);
				}
				break;
			case 3:
				sc.nextLine();
				System.out.println("Enter Feedback Id to update the infromation");
				String feedbackId = sc.next();
				Feedback f = feedbackService.getFeedback(feedbackId);
				if (f != null) {
					Feedback fed = updatedFeedbackData();
					// service
					Feedback updatedInfo = feedbackService.updateFeedback(feedbackId, fed);
					System.out.println("feedback Data has been updated Successfully");
					System.out.println(updatedInfo);
				} else {
					throw new ResourceNotFoundException("feedback Id not found");
				}
				break;
			case 4:
				System.out.println("Enter Feedback Id to delete the infromation");
				String feedbackID = sc.next();
				String message = feedbackService.deleteFeedback(feedbackID);
				System.out.println(message);
				break;
			case 5:
				customerDashboard();
			}
		}
	}

	// to provide feedback
	public static Feedback provideFeedback() {
		sc.nextLine();

		System.out.println("Enter Feedback Id : ");
		String feedbackId = sc.nextLine();

		System.out.println("Enter Restaurant Id : ");
		String restaurantId = sc.nextLine();

		System.out.println("Enter customer ID");
		String customerId = sc.nextLine();

		System.out.println("Please Provide your feedback");
		String feedbackText = sc.nextLine();

		Feedback feedback = feedbackService.getFeedback(feedbackId);

		return new Feedback(feedbackId, restaurantId, customerId, feedbackText);
	}

	// to update feedback
	public static Feedback updatedFeedbackData() {
		sc.nextLine();
		System.out.println("Enter Feedback Id");
		String feedbackId = sc.nextLine();

		System.out.println("Enter restaurantId");
		String restaurantId = sc.nextLine();

		System.out.println("Enter customerId");
		String customerId = sc.nextLine();

		System.out.println("Enter feedbackText");
		String feedbackText = sc.nextLine();

		return new Feedback(feedbackId, restaurantId, customerId, feedbackText);
	}

	// for making a reservation
	static Reservation tableReservation() {
		System.out.println("Enter Reservation Id");
		String reservationId = sc.nextLine();

		System.out.println("Enter Restaurant Id");
		String restaurantId = sc.nextLine();

		System.out.println("Enter Customer Id");
		String customerId = sc.nextLine();

		System.out.println("Enter Table Id");
		String tableId = sc.nextLine();

		System.out.println("Enter Date : ");
		String reservationDate = sc.nextLine();

		System.out.println("Enter time : ");
		String reservationTime = sc.nextLine();

		// fetch restaurant object
		Restaurant restaurant = restaurantService.getRestaurant(restaurantId);

		// fetch customer object
		Customer customer = customerService.getCustomer(customerId);

		//// fetch table object
		RestaurantTable table = tableService.getTable(tableId);

		return new Reservation(reservationId, restaurantId, customerId, tableId, reservationDate, reservationTime);
	}

	// to retrieve reservation details
	public static List<Reservation> getReservationByRestaurant() {
		sc.nextLine();
		System.out.println("Enter Restaurant Id");
		String restId = sc.next();
		List<Reservation> reserve = restaurantService.getReservationDetailsByRestaurantId(restId);
		return reserve;
	}

}
