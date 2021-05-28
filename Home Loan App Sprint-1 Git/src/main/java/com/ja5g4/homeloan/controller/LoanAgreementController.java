package com.ja5g4.homeloan.controller;

import java.util.List;

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


import com.ja5g4.homeloan.entities.LoanAgreement;
import com.ja5g4.homeloan.exception.InvalidLoanAgreementException;
import com.ja5g4.homeloan.service.ILoanAgreementService;

import io.swagger.annotations.ApiModel;


@Validated
@RestController
@RequestMapping("/loanagreement")
@ApiModel(value = "Loan Agreement Rest Controller" , description = "Holds all APIs related to the Loan Agreement")
public class LoanAgreementController {
	

public LoanAgreementController() {
	System.out.println("-----> Loan Agreement Rest Controller Working!");
}

@Autowired
ILoanAgreementService loanAgreement_service;

@GetMapping("/home")
public String homeRequest() {
	return "Welcome : Home Loan Application (Version 1.0)";
}


@PostMapping("/add")
public LoanAgreement addLoanAgreement(@RequestBody LoanAgreement loanAgreement) {
	this.loanAgreement_service.addLoanAgreement(loanAgreement);
	return loanAgreement;
}

@PutMapping("/update")
public LoanAgreement updateLoanAgreement(@RequestBody LoanAgreement loanAgreement) throws InvalidLoanAgreementException {
	this.loanAgreement_service.updateLoanAgreement(loanAgreement);
	return loanAgreement;
}

@DeleteMapping("/delete/{loanid}")
public LoanAgreement deleteLoanAgreement(@PathVariable("loanid") long loanAgreementId) throws InvalidLoanAgreementException {
	return this.loanAgreement_service.deleteLoanAgreement(loanAgreementId);
	
}
@GetMapping("/viewallloan")
public List<LoanAgreement> retrieveAllLoanAgreement(@RequestBody LoanAgreement loanAgreement){
	return this.loanAgreement_service.retrieveAllLoanAgreement();
	

}
@GetMapping("/viewbyid/{loanid}")
public LoanAgreement retrieveLoanAgreementById(@PathVariable("loanid") long loanAgreementId) throws InvalidLoanAgreementException{
	return this.loanAgreement_service.retrieveLoanAgreementById(loanAgreementId);
	
}

}
