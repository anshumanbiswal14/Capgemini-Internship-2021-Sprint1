package com.ja5g4.homeloan.service;

import com.ja5g4.homeloan.entities.LoanApplication;

import com.ja5g4.homeloan.repository.ILandVerificationRepository;

public interface ILandVerificationService {
	
		public void updateStatus(LoanApplication loanApplication);

		}


