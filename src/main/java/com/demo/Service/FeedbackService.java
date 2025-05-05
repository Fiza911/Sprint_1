package com.demo.Service;

import java.util.List;

import com.demo.entity.Feedback;
import com.demo.entity.Restaurant;

// FeedbackService interface provides operations related to managing feedback
public interface FeedbackService {
	// Method to create a new Feedback entry
	Feedback createFeedback(Feedback feedback);

	// Method to get Feedback by its ID
	Feedback getFeedback(String feedbackID);

	// Method to get a list of all Feedback entries
	List<Feedback> getAllFeedback();

	// Method to update an existing Feedback entry
	Feedback updateFeedback(String feedbackId, Feedback updatedFeedback);

	// Method to delete a Feedback entry by its ID
	String deleteFeedback(String feedbackId);
}
