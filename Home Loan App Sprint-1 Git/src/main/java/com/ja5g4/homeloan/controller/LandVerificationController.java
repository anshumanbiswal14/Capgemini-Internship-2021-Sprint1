package com.ja5g4.homeloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja5g4.homeloan.entities.LandVerificationOfficer;
import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;
import com.ja5g4.homeloan.service.ILandVerificationService;

import io.swagger.annotations.ApiOperation;

@Validated
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
	@ApiOperation(value="PUT mapping for the Land Verification to update the status of application",response=LandVerificationOfficer.class)
	@PutMapping("/landstatus")
	public LoanApplication updateStatus(@RequestBody LoanApplication loanapplication) throws InvalidLoanApplicationException {
		
		return this.lservice.updateStatus(loanapplication);
	}
		
}