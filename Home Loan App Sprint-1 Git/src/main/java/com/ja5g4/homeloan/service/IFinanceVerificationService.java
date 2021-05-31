package com.ja5g4.homeloan.service;


import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;

//method for finance interface
public interface IFinanceVerificationService  {
	
public LoanApplication updateStatus(LoanApplication loanApplication) throws InvalidLoanApplicationException ;

	}
//By Gaurav Shrivastava