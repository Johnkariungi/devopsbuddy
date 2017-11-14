package com.devopsbuddy.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devopsbuddy.web.domain.fontend.FeedbackPojo;


@Controller
public class ContactController {
	
	/** The Key which identifies the feedback payload in the model **/
	private static final String FEEDBACK_MODEL_KEY = "feedback";
	
	/** The Contact Us view name. */
	private static final String CONTACT_US_VIEW_PAGE = "contact/contact";
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contactGet(ModelMap model) {
		FeedbackPojo feedbackPojo = new FeedbackPojo();
		model.addAttribute(ContactController.FEEDBACK_MODEL_KEY, feedbackPojo);
		return ContactController.CONTACT_US_VIEW_PAGE;
	}
}
