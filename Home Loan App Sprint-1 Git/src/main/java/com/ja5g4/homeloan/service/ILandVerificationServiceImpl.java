package com.ja5g4.homeloan.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;
import com.ja5g4.homeloan.repository.ILandVerificationRepository;

public class ILandVerificationServiceImpl implements ILandVerificationService{

	@Autowired
	ILandVerificationRepository landVerificationRepository;
	
	@Override
	public LoanApplication updateStatus (LoanApplication loanApplication) throws InvalidLoanApplicationException {
		Optional<LoanApplication> optional=null;
		try {
			
			landVerificationRepository.save(loanApplication);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new InvalidLoanApplicationException("Loan application couldn't be Updated! ");

		}
		return loanApplication;
	}

}
//By Gaurav Shrivastava