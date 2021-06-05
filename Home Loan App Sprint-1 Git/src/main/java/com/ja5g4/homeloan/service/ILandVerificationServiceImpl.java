package com.ja5g4.homeloan.service;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;
import com.ja5g4.homeloan.repository.ILoanApplicationRepository;

@Service
public class ILandVerificationServiceImpl implements ILandVerificationService{

	
	@Autowired
	ILoanApplicationRepository applicationRepository;
	
	

	public ILandVerificationServiceImpl(ILoanApplicationRepository applicationRepository) {
		super();
		this.applicationRepository = applicationRepository;
	}



	@Override
	@Transactional
	//method to check loan application is present in the DB, update if application is present else invoke Exception class
	public LoanApplication updateStatus(LoanApplication loanApplication) throws InvalidLoanApplicationException {
		Optional<LoanApplication> optional=Optional.empty();
		optional=applicationRepository.findById(loanApplication.getApplicationId());
		
			if(optional.isPresent()) {
			applicationRepository.save(loanApplication);
			
			return loanApplication;		//returns updated loan application
			}
			else {
				throw new InvalidLoanApplicationException("Loan application couldn't be Updated! ");	//returns the stated exception message
			}
		
		
	}
}	

