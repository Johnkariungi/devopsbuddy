package com.devopsbuddy.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	/** The login view name */
	private static final String LOGIN_WITH_NAME = "user/login";
	
	@RequestMapping("/login")
	public String login() {
		return LoginController.LOGIN_WITH_NAME;
	}
}
