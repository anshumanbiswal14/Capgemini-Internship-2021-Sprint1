package com.ja5g4.homeloan.service;

import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;

/*Finance Verification Officer Service
 *IFinanceVerificationService checks for the existing of loan application and 
 *other field as per necessity if existing
 *
 * Author : Gaurav Shrivastava 
 * */

public interface IFinanceVerificationService  {
	
public LoanApplication updateStatus(LoanApplication loanApplication) throws InvalidLoanApplicationException ;

	}
