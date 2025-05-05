package com.demo.ServiceImpl;

import java.util.List;

import com.demo.Service.FeedbackService;
import com.demo.dao.FeedbackDao;
import com.demo.daoImpl.FeedbackDaoImpl;
import com.demo.entity.Feedback;

public class FeedbackServiceImpl implements FeedbackService {
	// Creating an instance of FeedbackDao to interact with the database layer
	FeedbackDao feedbackDao = new FeedbackDaoImpl();

	// Method to create new feedback
	@Override
	public Feedback createFeedback(Feedback feedback) {
		// Calling the createFeedback method of FeedbackDao to persist the feedback
		return feedbackDao.createFeedback(feedback);
	}

	// Method to retrieve a specific feedback by its ID
	@Override
	public Feedback getFeedback(String feedbackId) {
		// Calling the getFeedback method of FeedbackDao to fetch the feedback by ID
		return feedbackDao.getFeedback(feedbackId);
	}

	// Method to retrieve a list of all feedbacks
	@Override
	public List<Feedback> getAllFeedback() {
		// Calling the getAllFeedback method of FeedbackDao to fetch all feedbacks
		return feedbackDao.getAllFeedback();
	}

	// Method to update feedback details
	@Override
	public Feedback updateFeedback(String feedbackId, Feedback updatedFeedback) {
		// Calling the updateFeedback method of FeedbackDao to update the feedback data
		return feedbackDao.updateFeedback(feedbackId, updatedFeedback);
	}

	// Method to delete feedback by its ID
	@Override
	public String deleteFeedback(String feedbackId) {
		// Calling the deleteFeedback method of FeedbackDao to remove the feedback
		return feedbackDao.deleteFeedback(feedbackId);
	}
}
