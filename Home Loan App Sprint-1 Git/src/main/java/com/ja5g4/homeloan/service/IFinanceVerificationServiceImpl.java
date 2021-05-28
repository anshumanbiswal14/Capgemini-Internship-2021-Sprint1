package com.ja5g4.homeloan.service;

import java.util.Optional;

import javax.transaction.Transactional;

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
	@Transactional
	public LoanApplication updateStatus(LoanApplication loanApplication) throws InvalidLoanApplicationException {
		
		Optional<FinanceVerificationOfficer> optional = null;
		try {
			if(optional.isPresent()) {
			verificationRepository.save(loanApplication);
			}
			else {
				throw new InvalidLoanApplicationException("Loan application couldn't be Updated! ");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new InvalidLoanApplicationException("Loan application couldn't be Updated! ");

		}
		return loanApplication;
	}

	
}
