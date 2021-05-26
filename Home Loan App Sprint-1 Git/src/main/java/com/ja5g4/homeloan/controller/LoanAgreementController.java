package com.ja5g4.homeloan.controller;

<<<<<<< HEAD
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanAgreementController {

=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ja5g4.homeloan.service.ILoanAgreementService;


@RestController
public class LoanAgreementController {

@Autowired
ILoanAgreementService loanAgreement_service;

>>>>>>> df28d5882458fa4639886566c2b71096b31d8eed
}
