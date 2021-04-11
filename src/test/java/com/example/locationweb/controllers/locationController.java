package com.example.locationweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class locationController {
	
	@RequestMapping("/")
	public String showCreate() {
		return "createLocation";
		
	}

}
