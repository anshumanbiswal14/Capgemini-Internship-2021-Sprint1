package com.ja5g4.homeloan.service;

import com.ja5g4.homeloan.entities.LoanApplication;

import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;

/*Land Verification Officer Service
 *ILandVerificationService checks for the existing of loan application and updates the status and 
 *other field as per necessity if existing
 * Author : Gaurav Shrivastava 
 * */
public interface ILandVerificationService {

	public LoanApplication updateStatus(LoanApplication loanApplication) throws InvalidLoanApplicationException;

}
