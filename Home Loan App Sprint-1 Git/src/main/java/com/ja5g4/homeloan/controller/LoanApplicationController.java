package com.ja5g4.homeloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/loanapplication")
public class LoanApplicationController {
	
	

	public LoanApplicationController() {
		System.out.println("-----> Loan Application Rest Controller Working!");
		
	}

	@Autowired
	ILoanApplicationService loanApplication_service;
	
	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome : Home Loan Application (Version 1.0)";
	}

	@PostMapping("/add")
	public LoanApplication addLoanApplication(@RequestBody LoanApplication loanApplication) {
		this.loanApplication_service.addLoanApplication(loanApplication);
		return loanApplication;
	}

	@PutMapping("/update")
	public LoanApplication updateLoanApplication(@RequestBody LoanApplication loanApplication) throws InvalidLoanApplicationException {
		this.loanApplication_service.updateLoanApplication(loanApplication);
		return loanApplication;
	}

	@DeleteMapping("/delete/{applicationid}")
	public LoanApplication deleteLoanApplication(@PathVariable("applicationid") long loanApplicationId) throws  InvalidLoanApplicationException {
		return this.loanApplication_service.deleteLoanApplication(loanApplicationId);
		
	}
	@GetMapping("/viewallloan")
	public List<LoanApplication> retrieveAllLoanApplication(@RequestBody LoanApplication loanApplication){
		return this.loanApplication_service.retrieveAllLoanApplication();
		

	}
	@GetMapping("/viewbyid/{loanid}")
	public LoanApplication retrieveLoanApplicationById(@PathVariable("loanid") long loanApplicationId) throws InvalidLoanApplicationException{
		return this.loanApplication_service.retrieveLoanApplicationById(loanApplicationId);
		
	}
	
	
}
