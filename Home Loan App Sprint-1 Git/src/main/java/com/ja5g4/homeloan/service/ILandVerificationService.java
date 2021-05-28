package com.ja5g4.homeloan.service;



import com.ja5g4.homeloan.entities.LandVerificationOfficer;
import com.ja5g4.homeloan.entities.LoanApplication;

import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;
import com.ja5g4.homeloan.exception.LandVerificationException;



public interface ILandVerificationService {
	
		public LoanApplication updateStatus(LoanApplication loanApplication) throws InvalidLoanApplicationException ;
		
//		public LandVerificationOfficer updateOfficer(LandVerificationOfficer landVerificationOfficer ) throws LandVerificationException;
//		
//		public LandVerificationOfficer addOfficer(LandVerificationOfficer landVerificationOfficer) throws LandVerificationException;
		}


