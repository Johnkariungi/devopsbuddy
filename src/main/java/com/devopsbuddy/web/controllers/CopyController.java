package com.devopsbuddy.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller /*copy cause of adding all copyright info*/
public class CopyController {
	
	private static final String ABOUT_VIEW_NAME = "copy/about";
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about() {
		return CopyController.ABOUT_VIEW_NAME;
	}
}
