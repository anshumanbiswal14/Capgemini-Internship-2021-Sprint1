package com.ja5g4.homeloan.service;

import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja5g4.homeloan.entities.FinanceVerificationOfficer;
import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;
import com.ja5g4.homeloan.repository.IFinanceVerificationRepository;
import com.ja5g4.homeloan.repository.ILoanApplicationRepository;


@Service
public class IFinanceVerificationServiceImpl implements IFinanceVerificationService {

	@Autowired
	IFinanceVerificationRepository verificationRepository;
	@Autowired
	ILoanApplicationRepository applicationRepository;
	
	@Override
	@Transactional
	//method to check loan application is present in the DB, update if application is present else invoke Exception class
	public LoanApplication updateStatus(LoanApplication loanApplication) throws InvalidLoanApplicationException {
		
		Optional<LoanApplication> optional = null;
		optional=applicationRepository.findById(loanApplication.getApplicationId());
			if(optional.isPresent()) {
			applicationRepository.save(loanApplication);
			return loanApplication;
			}
			else {
				throw new InvalidLoanApplicationException("Loan application couldn't be Updated! ");//returns updated loan application
			}
	}

}
//By Gaurav Shrivastava