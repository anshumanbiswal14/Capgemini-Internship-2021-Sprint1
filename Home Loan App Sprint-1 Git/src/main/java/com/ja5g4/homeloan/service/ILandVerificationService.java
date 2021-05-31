package com.ja5g4.homeloan.service;

import com.ja5g4.homeloan.entities.LoanApplication;

import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;

public interface ILandVerificationService {

	public LoanApplication updateStatus(LoanApplication loanApplication) throws InvalidLoanApplicationException;

//		public LandVerificationOfficer updateOfficer(LandVerificationOfficer landVerificationOfficer ) throws LandVerificationException;
//		
//		public LandVerificationOfficer addOfficer(LandVerificationOfficer landVerificationOfficer) throws LandVerificationException;
}
//By Gaurav Shrivastava