package com.demo.daoImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.demo.dao.FeedbackDao;
import com.demo.entity.Feedback;
import util.HibernateUtil;

public class FeedbackDaoImpl implements FeedbackDao {

	// Scanner object to take user input for delete confirmation
	Scanner sc = new Scanner(System.in);

	// Method to create a new feedback
	@Override
	public Feedback createFeedback(Feedback feedback) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction(); // Begin transaction
			session.save(feedback); // Save feedback data to the database
			session.getTransaction().commit(); // Commit transaction
			return feedback; // Return the saved feedback object
		} catch (HibernateException e) {
			System.out.println(e); // Print Hibernate exception if any
		} catch (Exception e) {
			System.out.println(e); // Print any other exception
		}
		return null; // Return null if something goes wrong
	}

	// Method to get feedback by its ID
	@Override
	public Feedback getFeedback(String feedbackId) {
		try (Session session = HibernateUtil.getSession()) {
			Feedback feedback = session.get(Feedback.class, feedbackId); // Retrieve feedback by ID
			return feedback; // Return the found feedback object
		} catch (HibernateException e) {
			System.out.println(e); // Print Hibernate exception if any
		} catch (Exception e) {
			System.out.println(e); // Print any other exception
		}
		return null; // Return null if something goes wrong
	}

	// Method to get a list of all feedbacks
	@Override
	public List<Feedback> getAllFeedback() {
		try (Session session = HibernateUtil.getSession()) {
			// Create and execute HQL query to fetch all feedbacks
			Query<Feedback> query = session.createQuery("FROM Feedback");
			List<Feedback> feedbackList = query.list(); // Get the list of feedbacks
			return feedbackList; // Return the list of feedbacks
		} catch (HibernateException e) {
			System.out.println(e); // Print Hibernate exception if any
		} catch (Exception e) {
			System.out.println(e); // Print any other exception
		}
		return null; // Return null if something goes wrong
	}

	// Method to update an existing feedback
	@Override
	public Feedback updateFeedback(String feedbackID, Feedback updatedFeedback) {
		try (Session session = HibernateUtil.getSession()) {
			Feedback feedback = session.get(Feedback.class, feedbackID); // Retrieve feedback by ID
			session.beginTransaction(); // Begin transaction

			// Update feedback properties with the new values
			feedback.setCustomerId(feedbackID);
			feedback.setFeedbackId(updatedFeedback.getFeedbackId());
			feedback.setRestaurantId(updatedFeedback.getRestaurantId());
			feedback.setCustomerId(updatedFeedback.getCustomerId());
			feedback.setFeedbackText(updatedFeedback.getFeedbackText());

			session.saveOrUpdate(feedback); // Save or update the feedback in the database
			session.getTransaction().commit(); // Commit transaction
			return feedback; // Return the updated feedback object
		} catch (HibernateException e) {
			System.out.println(e); // Print Hibernate exception if any
		} catch (Exception e) {
			System.out.println(e); // Print any other exception
		}
		return null; // Return null if something goes wrong
	}

	// Method to delete feedback
	@Override
	public String deleteFeedback(String feedbackId) {
		String message = null;
		try (Session session = HibernateUtil.getSession()) {
			Feedback feedback = session.get(Feedback.class, feedbackId); // Retrieve feedback by ID
			session.beginTransaction(); // Begin transaction

			// Prompt the user for confirmation before deleting
			System.out.println("Are you sure you want to delete?");
			String status = sc.next(); // Read user input for confirmation
			if (status.equalsIgnoreCase("yes")) {
				session.delete(feedback); // Delete feedback from the database
				session.getTransaction().commit(); // Commit transaction
				session.evict(feedback); // Evict feedback from session cache
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
}
