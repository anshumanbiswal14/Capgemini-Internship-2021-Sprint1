package com.ja5g4.homeloan.controller;

import java.util.List; 
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;
import com.ja5g4.homeloan.service.ILoanApplicationService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

/*Loan Application REST Controller
 * Loan Application controller contains various methods to interact with the loan application table
 * "/home" is to check the home page 
 * "/add" is to add new loan application connected to an user to the database
 * "/viewbyid/{loan_id}" to view the application details by using the loan ID
 * "/update" to update the application details or make any specific changes to details
 * "/delete/{loan_id}" to delete the application from the database using the loan_id
 * "/viewallloan" to viewall the loan applications available in the database

 * Author : Ashwin 
 * */


@Validated
@RestController
@RequestMapping("/loanapplication")
@ApiModel(value = "Loan Application Rest Controller", description = "Holds all APIs related to the Loan Application")
public class LoanApplicationController {

	Logger logger = Logger.getLogger(LoanApplicationController.class.getName());

	public LoanApplicationController() {
		logger.log(Level.INFO, "----->Inside Loan Application Controller Working!");

	}

	@Autowired
	ILoanApplicationService loanApplicationService;

	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome : Home Loan Application (Version 1.0)";
	}

	@ApiOperation(value = "POST mapping to add new loan applications to the LOAN_APPLICATION table in the Database", response = LoanApplication.class)
	@PostMapping("/add")
	public LoanApplication addLoanApplication(@RequestBody @Valid LoanApplication loanApplication) {
		this.loanApplicationService.addLoanApplication(loanApplication);
		return loanApplication;
	}

	@ApiOperation(value = "PUT mapping to update the loan application in the LOAN_APPLICATION table in the Database", response = LoanApplication.class)
	@PutMapping("/update")
	public LoanApplication updateLoanApplication(@RequestBody @Valid LoanApplication loanApplication)
			throws InvalidLoanApplicationException {
		this.loanApplicationService.updateLoanApplication(loanApplication);
		return loanApplication;
	}

	@ApiOperation(value = "DELETE mapping to delete the application from LOAN_APPLICATION table by application ID in the Database", response = LoanApplication.class)
	@DeleteMapping("/delete/{applicationid}")
	public LoanApplication deleteLoanApplication(@PathVariable("applicationid") long loanApplicationId)
			throws InvalidLoanApplicationException {
		return this.loanApplicationService.deleteLoanApplication(loanApplicationId);

	}

	@ApiOperation(value = "GET mapping to view all the loan applications in the database ", response = List.class)
	@GetMapping("/viewallloan")
	public List<LoanApplication> retrieveAllLoanApplication() {
		return this.loanApplicationService.retrieveAllLoanApplication();

	}

	@ApiOperation(value = "GET mapping to view all the loan applications by loan ID", response = LoanApplication.class)
	@GetMapping("/viewbyid/{loanid}")
	public LoanApplication retrieveLoanApplicationById(@PathVariable("loanid") long loanApplicationId)
			throws InvalidLoanApplicationException {
		return this.loanApplicationService.retrieveLoanApplicationById(loanApplicationId);

	}

}
