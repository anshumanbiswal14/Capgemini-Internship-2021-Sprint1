package com.ja5g4.homeloan.service;

import java.util.List;

import java.util.Optional;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja5g4.homeloan.entities.LoanAgreement;
import com.ja5g4.homeloan.exception.InvalidLoanAgreementException;
import com.ja5g4.homeloan.repository.ILoanAgreementRepository;

@Service
public class ILoanAgreementServiceImpl implements ILoanAgreementService {
    
	@Autowired
	ILoanAgreementRepository repository;
	
	
	@Override
	@Transactional
	public LoanAgreement addLoanAgreement(LoanAgreement loanAgreement) {
		
		try {
		repository.save(loanAgreement);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return loanAgreement;
	}

	
	@Override
	@Transactional
	public LoanAgreement updateLoanAgreement(LoanAgreement loanAgreement) throws InvalidLoanAgreementException {
		
		Optional<LoanAgreement> optional = null;
		try {
		optional = repository.findById(loanAgreement.getLoanAgreementId());
		repository.save(loanAgreement);
		}catch (Exception e) {
			e.printStackTrace();
			throw new InvalidLoanAgreementException("Loan agreement couldn't be Updated! ");
		}
		return loanAgreement;
	}

	
	@Override
	@Transactional
	public LoanAgreement deleteLoanAgreement(long loanAgreementId) throws InvalidLoanAgreementException {
		
		Optional<LoanAgreement> optional = null;
		try {
			optional = repository.findById(loanAgreementId);
			repository.deleteById(loanAgreementId);
		}catch (Exception e) {
			e.printStackTrace();
			if(optional.get() == null) {
				throw new InvalidLoanAgreementException("Loan agreement not found for delete operation!");
				}
		}
		return optional.get();
	}

	@Override
	public List<LoanAgreement> retrieveAllLoanAgreement() {
		
		List<LoanAgreement>list = null;
		try {
			 list = repository.findAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public LoanAgreement retrieveLoanAgreementById(long loanAgreementId) throws InvalidLoanAgreementException {
		
		Optional<LoanAgreement> optional = null;
		try {
			optional = repository.findById(loanAgreementId);
			
		}catch (Exception e) {
			e.printStackTrace();
			if(optional.get() == null) {
				throw new InvalidLoanAgreementException("Loan agreement ID not found in records!");
				}
		}
		return optional.get();
	}

}