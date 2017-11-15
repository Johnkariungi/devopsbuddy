package com.devopsbuddy.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller /*copy cause of adding all copyright info*/
public class CopyController {
	
	@RequestMapping("/about")
	public String about() {
		return "	copy/about";
	}
}
