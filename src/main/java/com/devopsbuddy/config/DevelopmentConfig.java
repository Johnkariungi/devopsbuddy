package com.devopsbuddy.config;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.devopsbuddy.backend.service.EmailService;
import com.devopsbuddy.backend.service.MockEmailService;

@Configuration
@Profile("dev")
@PropertySource("file:///${user.home}/.devopsbuddy/application-dev.properties")

public class DevelopmentConfig {
	
	@Value("${stripe.test.private.key}")
	private String stripeDevKey;
	
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
	
	@Bean /*add for console JPA inMemory H2 DB */
    public ServletRegistrationBean h2ConsoleServletRegistration() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new WebServlet());
        bean.addUrlMappings("/console/*");
        return bean;
    }
	/* method that returns the property we have just declared */
	@Bean
	public String stripeKey() {
		return stripeDevKey;
	}
}
