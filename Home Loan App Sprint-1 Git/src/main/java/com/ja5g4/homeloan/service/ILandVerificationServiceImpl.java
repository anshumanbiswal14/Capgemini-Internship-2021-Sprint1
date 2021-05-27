package com.ja5g4.homeloan.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja5g4.homeloan.entities.LandVerificationOfficer;
import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;
import com.ja5g4.homeloan.exception.LandVerificationException;
import com.ja5g4.homeloan.repository.ILandVerificationRepository;
import com.ja5g4.homeloan.repository.ILoanApplicationRepository;

@Service
public class ILandVerificationServiceImpl implements ILandVerificationService{

	@Autowired
	ILandVerificationRepository landVerificationRepository;
	
	@Autowired
	ILoanApplicationRepository loanapplicationrepository;
	
	@Override
	@Transactional
	public LoanApplication updateStatus(LoanApplication loanApplication) throws InvalidLoanApplicationException {
		Optional<LoanApplication> optional=null;
		try {
			
			loanapplicationrepository.save(loanApplication);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new InvalidLoanApplicationException("Loan application couldn't be Updated! ");

		}
		return loanApplication;
	}

	@Override
	public LandVerificationOfficer updateOfficer(LandVerificationOfficer landVerificationOfficer)
			throws LandVerificationException {
		Optional<LandVerificationOfficer> optional=null;
		try {
			
			landVerificationRepository.save(landVerificationOfficer);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new LandVerificationException ("Loan officer couldn't be Updated! ");

		}
		return landVerificationOfficer;
		
		
	}

	@Override
	public LandVerificationOfficer addOfficer(LandVerificationOfficer landVerificationOfficer)
			throws LandVerificationException {
		
		try {
			landVerificationRepository.save(landVerificationOfficer);
		} catch (Exception e) {
			
		}
				return landVerificationOfficer;
	}

}
