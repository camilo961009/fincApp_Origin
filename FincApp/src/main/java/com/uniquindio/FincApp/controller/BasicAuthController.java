package com.uniquindio.FincApp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.uniquindio.FincApp.login.AuthenticationBean;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="http://localhost:4200")
public class BasicAuthController {
	
	@GetMapping(path = "/basicauth")
	public AuthenticationBean helloWorldBean() {
		return new AuthenticationBean("You are authenticated");
	}	

}
