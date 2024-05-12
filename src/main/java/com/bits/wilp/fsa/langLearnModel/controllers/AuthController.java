package com.bits.wilp.fsa.langLearnModel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bits.wilp.fsa.langLearnModel.models.Users;
import com.bits.wilp.fsa.langLearnModel.service.UserService;

@RestController
public class AuthController{
	
	@Autowired 
	UserService userService;
	
	@PostMapping("/registerUser")
	public String addUser(@RequestBody Users user)
	{
		return userService.addUser(user);
	}
	
	@GetMapping("/authenticateUsers")
	public String authenticateUser(@RequestBody Users user)
	{
		return userService.authenticateUser(user);
	}
	
	@GetMapping("/userLogin")
	public String loginUser()
	{
		return "Logged in";
	}
	
	
}