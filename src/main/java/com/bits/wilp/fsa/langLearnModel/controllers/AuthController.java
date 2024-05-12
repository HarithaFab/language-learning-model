package com.bits.wilp.fsa.langLearnModel.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	
	@PostMapping("/userLogin")
	public String userValidation()
	{
		return "User logged in successfully";
	}
	@PostMapping("/adminLogin")
	public String adminValidation()
	{
		return "Admin logged in successfully";
	}
	
}