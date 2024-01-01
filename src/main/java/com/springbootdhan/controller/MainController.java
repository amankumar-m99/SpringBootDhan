package com.springbootdhan.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootdhan.data.StaticData;

@RestController
@CrossOrigin(origins = StaticData.origins)
public class MainController {
	
	@GetMapping("/home")
	public String home() {
		return "ATM is working";
	}
}
