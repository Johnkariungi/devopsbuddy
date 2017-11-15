package com.devopsbuddy.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.devopsbuddy.web.domain.fontend.FeedbackPojo;

public abstract class AbstractEmailService implements EmailService {

	@Value("$(default.to.address)") /*added in the application.properties file*/
	private String defaultToAddress;
	
	/**
     * Creates a Simple Mail Message from a Feedback Pojo.
     * @param feedback The Feedback pojo
     * @return
     */
	protected SimpleMailMessage prepareSimpleMailMessageFromFeedbackPojo(FeedbackPojo feedback) {
		SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(defaultToAddress);
        message.setFrom(feedback.getEmail());
        message.setReplyTo(feedback.getEmail());
        message.setSubject("[DevOps Buddy]: Feedback received from " + feedback.getFirstName() + " " + feedback
                .getLastName() + "!");
        message.setText("User with email: " + feedback.getEmail() + " left this feedback:\n" + feedback.getFeedback());
        return message;
	}
	
	@Override
	public void sendFeedbackEmail(FeedbackPojo feedbackPojo) {
		sendGenericEmailMessage(prepareSimpleMailMessageFromFeedbackPojo(feedbackPojo));
	}
}
