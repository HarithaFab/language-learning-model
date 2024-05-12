package com.bits.wilp.fsa.langLearnModel.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .authorizeHttpRequests(requests -> requests
	            .requestMatchers("/userLogin").hasAnyRole("USER1", "USER2", "USER3")
	            .anyRequest().authenticated()
	        )
	        .authorizeHttpRequests(requests -> requests
		            .requestMatchers("/adminLogin").hasAnyRole("ADMIN1", "ADMIN2", "ADMIN3")
		            .anyRequest().authenticated()
		        )
	        .formLogin(form -> form
	            .loginPage("/login")
	            .permitAll()
	        )
	        .logout(logout -> logout
	            .permitAll());
	    
	    return http.build();
	}

}
