package com.ja5g4.homeloan.service;



import com.ja5g4.homeloan.entities.LoanApplication;

import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;


public interface ILandVerificationService {
	
		public LoanApplication updateStatusofLand(LoanApplication loanApplication) throws InvalidLoanApplicationException ;

		}


