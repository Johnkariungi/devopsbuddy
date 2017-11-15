package com.devopsbuddy.web.controllers;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devopsbuddy.backend.service.EmailService;
import com.devopsbuddy.web.domain.fontend.FeedbackPojo;


@Controller
public class ContactController {
	
	/* The application logger */
	private static final Logger LOG = LoggerFactory.getLogger(ContactController.class);
	
	/*
	 * declare 2 constants that can be used in automated testing
	 * */
	
	/** The Key which identifies the feedback payload in the model **/
	private static final String FEEDBACK_MODEL_KEY = "feedback";
	
	/** The Contact Us view name. */
	private static final String CONTACT_US_VIEW_PAGE = "contact/contact";
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contactGet(ModelMap model) {
		FeedbackPojo feedbackPojo = new FeedbackPojo();
		model.addAttribute(ContactController.FEEDBACK_MODEL_KEY, feedbackPojo);
		return ContactController.CONTACT_US_VIEW_PAGE;
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String contactPost(@ModelAttribute(FEEDBACK_MODEL_KEY) FeedbackPojo feedback) {
		LOG.debug("Feeback POJO content {}", feedback);
		emailService.sendFeedbackEmail(feedback);
		return ContactController.CONTACT_US_VIEW_PAGE;
	}
}
