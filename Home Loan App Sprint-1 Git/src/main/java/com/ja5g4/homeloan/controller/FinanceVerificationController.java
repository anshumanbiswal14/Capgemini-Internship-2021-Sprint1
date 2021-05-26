package com.ja5g4.homeloan.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja5g4.homeloan.entities.FinanceVerificationOfficer;
import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.service.IFinanceVerificationService;

@RestController
@RequestMapping("/api")
public class FinanceVerificationController {

	@Autowired
	private IFinanceVerificationService service;

	@PostMapping("/financestatus")
	public FinanceVerificationOfficer updateStatus(@RequestBody LoanApplication loanapplication) {
		return null;
	}


}
