package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // Marks the class as a Hibernate entity (mapped to a database table)
public class Feedback {

	@Id // Marks the field as primary key
	private String feedbackId;
	private String restaurantId;
	private String customerId;
	private String feedbackText;

	// Default constructor
	public Feedback() {
		super();
	}

	// Parameterized constructor
	public Feedback(String feedbackId, String restaurantId, String customerId, String feedbackText) {
		super();
		this.feedbackId = feedbackId;
		this.restaurantId = restaurantId;
		this.customerId = customerId;
		this.feedbackText = feedbackText;
	}

	// Getter and Setter methods
	public String getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFeedbackText() {
		return feedbackText;
	}

	public void setFeedbackText(String feedbackText) {
		this.feedbackText = feedbackText;
	}

	// Overridden toString method for providing a string representation of the
	// Feedback object
	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", restaurantId=" + restaurantId + ", customerId=" + customerId
				+ ", feedbackText=" + feedbackText + "]";
	}
}
