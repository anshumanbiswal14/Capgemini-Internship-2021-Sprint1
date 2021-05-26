package com.ja5g4.homeloan.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja5g4.homeloan.entities.FinanceVerificationOfficer;
import com.ja5g4.homeloan.entities.LoanApplication;

import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;
import com.ja5g4.homeloan.repository.IFinanceVerificationRepository;


@Service
public class IFinanceVerificationServiceImpl implements IFinanceVerificationService {

	@Autowired
	IFinanceVerificationRepository verificationRepository;
	
	@Override
	public LoanApplication updateStatus(LoanApplication loanApplication) throws InvalidLoanApplicationException {
		
		Optional<FinanceVerificationOfficer> optional = null;
		try {
			verificationRepository.save(loanApplication);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new InvalidLoanApplicationException("Loan application couldn't be Updated! ");

		}
		return loanApplication;
	}

	
}
//By Gaurav Shrivastava