package com.bits.wilp.fsa.langLearnModel.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userLogin")
public class AuthController {
	
	
	@GetMapping
	public String userValidation()
	{
		return "User logged in successfully";
	}
	
}