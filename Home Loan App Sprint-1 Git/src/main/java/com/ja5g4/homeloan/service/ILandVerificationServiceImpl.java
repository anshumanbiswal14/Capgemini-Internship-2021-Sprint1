package com.ja5g4.homeloan.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;
import com.ja5g4.homeloan.repository.ILandVerificationRepository;

@Service
public class ILandVerificationServiceImpl implements ILandVerificationService{

	@Autowired
	ILandVerificationRepository landVerificationRepository;
	
	@Override
	@Transactional
	public LoanApplication updateStatusofLand (LoanApplication loanApplication) throws InvalidLoanApplicationException {
		Optional<LoanApplication> optional=null;
		try {
			
			landVerificationRepository.save(loanApplication);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new InvalidLoanApplicationException("Loan application couldn't be Updated! ");

		}
		return loanApplication;
	}

}
