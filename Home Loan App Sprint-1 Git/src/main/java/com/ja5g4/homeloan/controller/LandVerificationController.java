package com.ja5g4.homeloan.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;
import com.ja5g4.homeloan.service.ILandVerificationService;

@RestController
@RequestMapping("/landverify")
public class LandVerificationController {
	
	@Autowired
	private ILandVerificationService lservice;
	
	public LandVerificationController() {
		System.out.println("-----> Land Rest Controller Working!");
		
	}
	
	@PostMapping("/landstatus")
	public LoanApplication updateStatus(@RequestBody LoanApplication loanapplication) throws InvalidLoanApplicationException {
		
		return this.lservice.updateStatus(loanapplication);
	}
	
}