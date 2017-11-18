package com.devopsbuddy.config;

import java.security.SecureRandom;
<<<<<<< HEAD
import java.util.Arrays;
import java.util.List;
=======
>>>>>>> security

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
<<<<<<< HEAD
import org.springframework.core.env.Environment;
=======
>>>>>>> security
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

<<<<<<< HEAD
	@Autowired
    private Environment env;
	
	/** The encryption SALT. */
   private static final String SALT = "fdalkjalk;3jlwf00sfaof";
    
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
    }
	
	/** Public URLs. */
=======
	/*@Autowired
    private UserSecurityService userSecurityService;

    @Autowired
    private Environment env;*/

    /** The encryption SALT. */
    private static final String SALT = "fdalkjalk;3jlwf00sfaof";

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
    }

    /** Public URLs. */
>>>>>>> security
    private static final String[] PUBLIC_MATCHERS = {
            "/webjars/**",
            "/css/**",
            "/js/**",
            "/images/**",
            "/",
            "/about/**",
            "/contact/**",
<<<<<<< HEAD
            "/error/**/*",
            "/console/**"
=======
            "/error/**/*"
>>>>>>> security
    };
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
<<<<<<< HEAD
    
    		List<String> activeProfiles = Arrays.asList(env.getActiveProfiles()); /*get the profiles*/
        if (activeProfiles.contains("dev")) {/* disable if inMemory DB for dev*/
            http.csrf().disable();
            http.headers().frameOptions().disable();
        }
        
	    	http
	        .authorizeRequests()
	        .antMatchers(PUBLIC_MATCHERS).permitAll()
	        .anyRequest().authenticated()
	        .and()
	        .formLogin().loginPage("/login").defaultSuccessUrl("/payload")
	        .failureUrl("/login?error").permitAll()
	        .and()
	        .logout().permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.withUser("user").password("password")
		.roles("USER");
	        //.userDetailsService(userSecurityService)
	       // .passwordEncoder(passwordEncoder());
	}
=======

       /*List<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
        if (activeProfiles.contains("dev")) {
            http.csrf().disable();
            http.headers().frameOptions().disable();
        }*/

        http
                .authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/payload")
                .failureUrl("/login?error").permitAll()
                .and()
                .logout().permitAll();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
        		.inMemoryAuthentication()
        		.withUser("user").password("password")
        		.roles("USER");
                /*.userDetailsService(userSecurityService)
                .passwordEncoder(passwordEncoder());*/
    }
            
>>>>>>> security
}
