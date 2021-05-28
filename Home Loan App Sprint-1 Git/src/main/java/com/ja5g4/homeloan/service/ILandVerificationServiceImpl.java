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
	
//	@Autowired
//	ILoanApplicationRepository loanapplicationrepository;
	@Autowired
	ILoanApplicationRepository applicationRepository;
	
	
	@Override
	@Transactional
	public LoanApplication updateStatus(LoanApplication loanApplication) throws InvalidLoanApplicationException {
		Optional<LoanApplication> optional=null;
		optional=applicationRepository.findById(loanApplication.getApplicationId());
		
			if(optional.isPresent()) {
			applicationRepository.save(loanApplication);
			
			return loanApplication;
			}
			else {
				throw new InvalidLoanApplicationException("Loan application couldn't be Updated! ");
			}
		
		
	}}
//
//	@Override
//	public LandVerificationOfficer updateOfficer(LandVerificationOfficer landVerificationOfficer)
//			throws LandVerificationException {
//		Optional<LandVerificationOfficer> optional=null;
//		
//			landVerificationRepository.save(landVerificationOfficer);
//			return landVerificationOfficer;
//		
//		
//	}
//
//	@Override
//	public LandVerificationOfficer addOfficer(LandVerificationOfficer landVerificationOfficer)
//			throws LandVerificationException {
//		
//		try {
//			landVerificationRepository.save(landVerificationOfficer);
//		} catch (Exception e) {
//			
//		}
//				return landVerificationOfficer;
//	}
//
//}
