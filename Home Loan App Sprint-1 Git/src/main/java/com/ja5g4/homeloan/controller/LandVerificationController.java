package com.ja5g4.homeloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja5g4.homeloan.entities.LandVerificationOfficer;
import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;
import com.ja5g4.homeloan.exception.LandVerificationException;
import com.ja5g4.homeloan.service.ILandVerificationService;

@RestController
@RequestMapping("/landverify")
public class LandVerificationController {
	
	@Autowired
	private ILandVerificationService lservice;
	
	public LandVerificationController() {
		System.out.println("-----> Land Rest Controller Working!");
		
	}
	
	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome : Home Loan Application (Version 1.0)";
	}
	
	@PutMapping("/landstatus")
	public LoanApplication updateStatus(@RequestBody LoanApplication loanapplication) throws InvalidLoanApplicationException {
		
		return this.lservice.updateStatus(loanapplication);
	}
	
	@PostMapping("/addofficer")
	public LandVerificationOfficer addOfficer(@RequestBody LandVerificationOfficer landVerificationOfficer ) throws LandVerificationException{
		
		return this.lservice.addOfficer(landVerificationOfficer);
		
	}
	
	@PutMapping("/updateofficer")
	public LandVerificationOfficer updateOfficer(@RequestBody LandVerificationOfficer landVerificationOfficer ) throws LandVerificationException{
		
		return this.lservice.updateOfficer(landVerificationOfficer);
		
	}
	
	
	
}