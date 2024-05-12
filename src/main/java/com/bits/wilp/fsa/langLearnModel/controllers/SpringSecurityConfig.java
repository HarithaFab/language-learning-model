package com.bits.wilp.fsa.langLearnModel.controllers;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
   
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .authorizeHttpRequests(requests -> requests
	            .requestMatchers("/userLogin").hasAnyRole("USER")     
	            .anyRequest().authenticated()
	        )
	        .authorizeHttpRequests(requests -> requests
		            .requestMatchers("/adminLogin").hasAnyRole("ADMIN")
		            .anyRequest().authenticated()
		        )

	        .logout(logout -> logout
	            .permitAll());
    
	    return http.build();
	}


}
