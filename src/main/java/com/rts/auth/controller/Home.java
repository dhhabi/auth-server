package com.rts.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

	@RequestMapping("/")
	public String home(){
		return "home";
	}
	
	@RequestMapping("/secure")
	public String secure(){
		return "secure url";
	}
	
}
