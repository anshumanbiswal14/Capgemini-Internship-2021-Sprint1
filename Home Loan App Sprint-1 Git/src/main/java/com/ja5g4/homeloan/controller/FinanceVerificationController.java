package com.ja5g4.homeloan.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

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
	Logger logger = Logger.getLogger(FinanceVerificationController.class.getName());
	@Autowired
	private IFinanceVerificationService service;
	
	//Method to check the working of rest controller in the console
	public FinanceVerificationController() {
		logger.log(Level.INFO,"-----> Finance Rest Controller Working!");
		
	}
	
	//Method to check the connection with the webservice
	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome : Home Loan Application (Version 1.0)"; //returns String value
	}

	
	@ApiOperation(value="PUT mapping for the Finance Verification to update the status of application",response=FinanceVerificationController.class)
	@PutMapping("/financestatus")
	//Method to update the status of application and loan amount if approved, passes the parameters of application class
	public LoanApplication updateStatus(@RequestBody @Valid LoanApplication loanapplication) throws InvalidLoanApplicationException {
		
		return this.service.updateStatus(loanapplication);  //returns the updated loan application
	}

}

//By Gaurav Shrivastava