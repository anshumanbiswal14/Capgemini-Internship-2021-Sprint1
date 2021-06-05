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


import com.ja5g4.homeloan.entities.LoanAgreement;
import com.ja5g4.homeloan.exception.InvalidLoanAgreementException;
import com.ja5g4.homeloan.service.ILoanAgreementService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;


@Validated
@RestController
@RequestMapping("/loanagreement")
@ApiModel(value = "Loan Agreement Rest Controller" , description = "Holds all APIs related to the Loan Agreement")
public class LoanAgreementController {
	
Logger logger = Logger.getLogger(LoanAgreementController.class.getName());
public LoanAgreementController() {
	logger.log(Level.INFO,"----->Inside Loan Agreement Controller Working!");
}

@Autowired
ILoanAgreementService loanAgreement_service;


@GetMapping("/home")
public String homeRequest() {
	return "Welcome : Home Loan Application (Version 1.0)";
}

@ApiOperation(value = "POST mapping to add new loan agreements to the LOAN_AGREEMENT table in the Database", response = LoanAgreement.class)
@PostMapping("/add")
public LoanAgreement addLoanAgreement(@RequestBody @Valid LoanAgreement loanAgreement) {
	this.loanAgreement_service.addLoanAgreement(loanAgreement);
	return loanAgreement;
}

@ApiOperation(value = "PUT mapping to update the loan agreements in the LOAN_AGREEMENT table in the Database", response = LoanAgreement.class)
@PutMapping("/update")
public LoanAgreement updateLoanAgreement(@RequestBody @Valid LoanAgreement loanAgreement) throws InvalidLoanAgreementException {
	this.loanAgreement_service.updateLoanAgreement(loanAgreement);
	return loanAgreement;
}

@ApiOperation(value = "DELETE mapping to delete the agreements from LOAN_AGREEMENT table by agreement ID in the Database", response = LoanAgreement.class)
@DeleteMapping("/delete/{loanid}")
public LoanAgreement deleteLoanAgreement(@PathVariable("loanid") long loanAgreementId) throws InvalidLoanAgreementException {
	return this.loanAgreement_service.deleteLoanAgreement(loanAgreementId);
		
}

@ApiOperation(value = "GET mapping to view all the loan agreements in the database ", response = List.class)
@GetMapping("/viewallloan")
public List<LoanAgreement> retrieveAllLoanAgreement(@RequestBody @Valid LoanAgreement loanAgreement){
	return this.loanAgreement_service.retrieveAllLoanAgreement();
	
}

@ApiOperation(value = "GET mapping to view all the loan agreements by loan ID", response = LoanAgreement.class)
@GetMapping("/viewbyid/{loanid}")
public LoanAgreement retrieveLoanAgreementById(@PathVariable("loanid") long loanAgreementId) throws InvalidLoanAgreementException{
	return this.loanAgreement_service.retrieveLoanAgreementById(loanAgreementId);
	
}

}
