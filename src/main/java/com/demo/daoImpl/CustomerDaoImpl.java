package com.demo.daoImpl;

import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.demo.dao.CustomerDao;
import com.demo.entity.Customer;
import util.HibernateUtil;

public class CustomerDaoImpl implements CustomerDao {
    // Scanner object to take user input
    Scanner sc = new Scanner(System.in);

    // Method to create a new customer
    @Override
    public Customer createCustomer(Customer customer) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction(); // Start transaction
            session.save(customer); // Save customer data to the database
            session.getTransaction().commit(); // Commit transaction
            return customer; // Return the saved customer object
        } catch (HibernateException e) {
            System.out.println(e); // Print Hibernate exception if any
        } catch (Exception e) {
            System.out.println(e); // Print any other exception
        }
        return null; // Return null if something goes wrong
    }

    // Method to get a customer by their ID
    @Override
    public Customer getCustomer(String customerId) {
        try (Session session = HibernateUtil.getSession()) {
            Customer customer = session.get(Customer.class, customerId); // Retrieve customer by ID
            return customer; // Return the found customer object
        } catch (HibernateException e) {
            System.out.println(e); // Print Hibernate exception if any
        } catch (Exception e) {
            System.out.println(e); // Print any other exception
        }
        return null; // Return null if something goes wrong
    }

    // Method to get a list of all customers
    @Override
    public List<Customer> getAllCustomer() {
        try (Session session = HibernateUtil.getSession()) {
            // Create HQL query to fetch all customers
            Query<Customer> query = session.createQuery("FROM Customer");
            List<Customer> customerList = query.list(); // Execute query and store result in list
            return customerList; // Return the list of customers
        } catch (HibernateException e) {
            System.out.println(e); // Print Hibernate exception if any
        } catch (Exception e) {
            System.out.println(e); // Print any other exception
        }
        return null; // Return null if something goes wrong
    }

    // Method to update an existing customer
    @Override
    public Customer updateCustomer(String customerID, Customer updatedCustomer) {
        try (Session session = HibernateUtil.getSession()) {
            Customer customer = session.get(Customer.class, customerID); // Retrieve customer by ID
            session.beginTransaction(); // Start transaction
            
            // Update the customer data with the new values
            customer.setCustomerId(customerID);
            customer.setCustomerName(updatedCustomer.getCustomerName());
            customer.setEmail(updatedCustomer.getEmail());
            customer.setCustomerContactNo(updatedCustomer.getCustomerContactNo());
            customer.setTotalReservations(updatedCustomer.getTotalReservations());

            session.saveOrUpdate(customer); // Save or update the customer in the database
            session.getTransaction().commit(); // Commit transaction
            return customer; // Return the updated customer
        } catch (HibernateException e) {
            System.out.println(e); // Print Hibernate exception if any
        } catch (Exception e) {
            System.out.println(e); // Print any other exception
        }
        return null; // Return null if something goes wrong
    }

    // Method to delete a customer
    @Override
    public String deleteCustomer(String customerId) {
        String message = null;
        try (Session session = HibernateUtil.getSession()) {
            Customer customer = session.get(Customer.class, customerId); // Retrieve customer by ID
            session.beginTransaction(); // Start transaction

            // Prompt the user for confirmation before deleting
            System.out.println("Are you sure you want to delete?");
            String status = sc.next();
            if (status.equalsIgnoreCase("yes")) {
                session.delete(customer); // Delete customer from the database
                session.getTransaction().commit(); // Commit transaction
                session.evict(customer); // Evict customer from session cache
                message = "Object is deleted"; // Return success message
            } else {
                message = "User wants to retain this object!!"; // Return message if not confirmed
            }
        } catch (HibernateException e) {
            System.out.println(e); // Print Hibernate exception if any
        } catch (Exception e) {
            System.out.println(e); // Print any other exception
        }
        return message; // Return the message
    }

    // Method to get a customer by username and password for login
    @Override
    public Customer getCustomerByUsernameAndPassword(String username, String password) {
        Customer customer = null;
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction(); // Start transaction

            // Create HQL query to get customer by username and password
            customer = (Customer) session
                    .createQuery("FROM Customer c WHERE c.username = :username AND c.password = :password")
                    .setParameter("username", username.trim()).setParameter("password", password.trim())
                    .getSingleResult(); // Execute the query and retrieve the result

            if (customer != null) {
                // Print the customer details if found
                System.out.println("Username: " + customer.getUsername() + ", Password: " + customer.getPassword());
            }

            session.getTransaction().commit(); // Commit transaction
        } catch (NoResultException e) {
            System.out.println("No matching customer found."); // Print message if no customer is found
        } catch (HibernateException e) {
            System.out.println("Hibernate error: " + e.getMessage()); // Print Hibernate exception
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage()); // Print other exceptions
        }
        return customer; // Return the customer if found, or null if not
    }
}