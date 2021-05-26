package com.ja5g4.homeloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja5g4.homeloan.entities.LandVerificationOfficer;
import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.service.ILandVerificationService;

@RestController
@RequestMapping("/api")
public class LandVerificationController {
	@Autowired
	private ILandVerificationService service;
	
	@PostMapping("/landstatus")
	public LandVerificationOfficer updateStatus(@RequestBody LoanApplication loanapplication) {
		return null;
	}
	

}
