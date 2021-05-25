package com.ja5g4.homeloan.service;

import com.ja5g4.homeloan.entities.LandVerificationOfficer;
import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;
import com.ja5g4.homeloan.repository.ILandVerificationRepository;

public interface ILandVerificationService {
	
		public LoanApplication updateStatus(LoanApplication loanApplication) throws InvalidLoanApplicationException ;

		}


