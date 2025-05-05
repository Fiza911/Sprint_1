package com.demo.dao;

import java.util.List;
import com.demo.entity.Feedback;

// This interface defines the methods for Feedback-related database operations
public interface FeedbackDao {

	// Method to create and save a new feedback entry
	Feedback createFeedback(Feedback feedback);

	// Method to retrieve a feedback entry by its ID
	Feedback getFeedback(String feedbackID);

	// Method to get a list of all feedback entries
	List<Feedback> getAllFeedback();

	// Method to update a feedback entry using its ID
	Feedback updateFeedback(String feedbackId, Feedback updatedFeedback);

	// Method to delete a feedback entry by its ID
	String deleteFeedback(String feedbackId);
}
