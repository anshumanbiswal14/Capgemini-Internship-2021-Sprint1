package com.ja5g4.homeloan.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja5g4.homeloan.entities.Admin;
import com.ja5g4.homeloan.entities.FinanceVerificationOfficer;
import com.ja5g4.homeloan.entities.LandVerificationOfficer;
import com.ja5g4.homeloan.entities.User;
import com.ja5g4.homeloan.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserServiceController {
	
	public UserServiceController() {
		System.out.println("------>User Service Rest Working!");
	}
	
	@Autowired
	IUserService userService;
	
	@PostMapping("/adduserasadmin")
	public Admin addNewUser(@RequestBody Admin admin) {
		this.userService.addNewUser(admin);
		return admin;
		
	}
	
	@PostMapping("/adduseraslandofficer")
	public LandVerificationOfficer addNewUser(@RequestBody LandVerificationOfficer landOfficerVerificationOfficer) {
		this.userService.addNewUser(landOfficerVerificationOfficer);
		return landOfficerVerificationOfficer;
		
	}
	
	@PostMapping("/adduserasfinanceofficer")
	public FinanceVerificationOfficer addNewUser(@RequestBody FinanceVerificationOfficer financeVerificationOfficer) {
		this.userService.addNewUser(financeVerificationOfficer);
		return financeVerificationOfficer;
		
	}
	
	@PostMapping("/signin")
	public User signIn(@RequestBody User user) {
		this.userService.signIn(user);
		return user;
		
	}

	@PostMapping("/signout")
	public User signOut(@RequestBody User user) {
		this.userService.signOut(user);
		return user;
		
	}
}
