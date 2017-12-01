package com.devopsbuddy.web.controllers;

import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.devopsbuddy.enums.PlansEnum;
import com.devopsbuddy.web.domain.fontend.ProAccountPayload;

@Controller
public class SignupController {
	/** The application logger */
    private static final Logger LOG = LoggerFactory.getLogger(SignupController.class);

    public static final String SIGNUP_URL_MAPPING = "/signup";

    public static final String PAYLOAD_MODEL_KEY_NAME = "payload";

    public static final String SUBSCRIPTION_VIEW_NAME = "registration/signup";

    public static final String DUPLICATED_USERNAME_KEY = "duplicatedUsername";

    public static final String DUPLICATED_EMAIL_KEY = "duplicatedEmail";

    public static final String SIGNED_UP_MESSAGE_KEY = "signedUp";

    public static final String ERROR_MESSAGE_KEY = "message";

    public static final String GENERIC_ERROR_VIEW_NAME = "error/genericError";
    
    @RequestMapping(value = SIGNUP_URL_MAPPING, method = RequestMethod.GET)
    public String signupGet(@RequestParam("planId") int planId, ModelMap model) {
    		if (planId != PlansEnum.BASIC.getId() && planId != PlansEnum.PRO.getId()) {
    			throw new IllegalArgumentException("Plan is not valid.");
    		}
    		model.addAttribute(PAYLOAD_MODEL_KEY_NAME,  new ProAccountPayload());
    		return SUBSCRIPTION_VIEW_NAME;
    }
}
