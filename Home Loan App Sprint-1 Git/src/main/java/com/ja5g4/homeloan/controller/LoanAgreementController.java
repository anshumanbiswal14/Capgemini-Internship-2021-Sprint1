package com.ja5g4.homeloan.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ja5g4.homeloan.service.ILoanAgreementService;


@RestController
public class LoanAgreementController {

@Autowired
ILoanAgreementService loanAgreement_service;


}
