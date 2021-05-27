package com.ja5g4.homeloan.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja5g4.homeloan.entities.User;
import com.ja5g4.homeloan.service.IUserService;

@RestController
@RequestMapping("/api")
public class UserServiceController {
	public UserServiceController() {
		System.out.println("------>User Service Running");
	}
	
	@Autowired
	IUserService userService;
	
	@PostMapping("/adduser")
	public User addNewUser(@RequestBody User user) {
		this.userService.addNewUser(user);
		return user;
		
	}
	
	@PostMapping("/signIn")
	public User signIn(@RequestBody User user) {
		this.userService.signIn(user);
		return user;
		
	}

	@PostMapping("/signOut")
	public User signOut(@RequestBody User user) {
		this.userService.signOut(user);
		return user;
		
	}
}
