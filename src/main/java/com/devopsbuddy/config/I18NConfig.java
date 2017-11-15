package com.devopsbuddy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class I18NConfig { /* things to appear on the pages */

	@Bean /* Spring looks for the file messages.properties folder in resources/i18n*/
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource resourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
		resourceBundleMessageSource.setBasename("classpath:i18n/messages");
		// checks for new messages  every 30 minutes
		resourceBundleMessageSource.setCacheSeconds(1800);
		return resourceBundleMessageSource;
 	}
}
