package com.ja5g4.homeloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja5g4.homeloan.entities.LoanAgreement;
import com.ja5g4.homeloan.exception.InvalidLoanAgreementException;
import com.ja5g4.homeloan.service.ILoanAgreementService;


@RestController
@RequestMapping("/loanAgreement")
public class LoanAgreementController {

@Autowired
ILoanAgreementService loanAgreement_service;

@GetMapping("/home")
public String homeRequest() {
	return "Welcome ";
}

@PostMapping("/add")
public LoanAgreement addLoanAgreement(@RequestBody LoanAgreement loanAgreement) {
	this.loanAgreement_service.addLoanAgreement(loanAgreement);
	return loanAgreement;
}

@PostMapping("/update/{loanAgreement}")
public LoanAgreement updateLoanAgreement(@RequestBody LoanAgreement loanAgreement) throws InvalidLoanAgreementException {
	this.loanAgreement_service.updateLoanAgreement(loanAgreement);
	return loanAgreement;
}

@DeleteMapping("/delete/{loanAgreementId}")
public LoanAgreement deleteLoanAgreement(@PathVariable("loanid") long loanAgreementId) throws InvalidLoanAgreementException {
	return this.loanAgreement_service.deleteLoanAgreement(loanAgreementId);
	
}



}
