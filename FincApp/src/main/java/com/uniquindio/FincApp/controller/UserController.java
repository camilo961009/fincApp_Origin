package com.uniquindio.FincApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniquindio.FincApp.model.User;
import com.uniquindio.FincApp.service.IUserService;


@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@PostMapping("/registrarUsuario")
	public User saveUser(@RequestBody User user) {
		System.out.println("Entra");
		return userService.save(user);
		
	}
}
