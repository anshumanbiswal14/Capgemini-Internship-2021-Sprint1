package com.ja5g4.homeloan.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;
import com.ja5g4.homeloan.service.IFinanceVerificationService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/financeverify")
@ApiModel(value="Finance Verification Controller", description = "Holds all APIs related to the Finanace")
public class FinanceVerificationController {

	@Autowired
	private IFinanceVerificationService service;
	
	public FinanceVerificationController() {
		System.out.println("-----> Finance Rest Controller Working!");
		
	}
	
	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome : Home Loan Application (Version 1.0)";
	}
	@ApiOperation(value="PUT mapping for the Finance Verification to update the status of application",response=FinanceVerificationController.class)
	@PutMapping("/financestatus")
	public LoanApplication updateStatus(@RequestBody @Valid LoanApplication loanapplication) throws InvalidLoanApplicationException {
		
		return this.service.updateStatus(loanapplication);
	}

}
