package com.ja5g4.homeloan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja5g4.homeloan.entities.LoanAgreement;
import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;
import com.ja5g4.homeloan.repository.ILoanApplicationRepository;

@Service
public class ILoanApplicationServiceImpl implements ILoanApplicationService {
	
	@Autowired
	ILoanApplicationRepository repository;

	@Override
	public LoanApplication addLoanApplication(LoanApplication loanApplication) {
		
		try {
			repository.save(loanApplication);
			}catch (Exception e) {
				e.printStackTrace();
			}
			return loanApplication;
	}

	@Override
	public LoanApplication updateLoanApplication(LoanApplication loanApplication)
			throws InvalidLoanApplicationException {
		
		Optional<LoanAgreement> optional = null;
		try {
		
		repository.save(loanApplication);
		}catch (Exception e) {
			e.printStackTrace();
			throw new InvalidLoanApplicationException("Loan application couldn't be Updated! ");
		}
		return loanApplication;
	}

	@Override
	public LoanApplication deleteLoanApplication(long loanApplicationId) throws InvalidLoanApplicationException {
		
		Optional<LoanApplication> optional = null;
		try {
			optional = repository.findById(loanApplicationId);
			repository.deleteById(loanApplicationId);
		}catch (Exception e) {
			e.printStackTrace();
			if(optional.get() == null) {
				throw new InvalidLoanApplicationException("Loan application ID not found for delete operation!");
				}
		}
		return optional.get();
	}

	@Override
	public List<LoanApplication> retrieveAllLoanApplication() {
		
		List<LoanApplication>list = null;
		try {
			 list = repository.findAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public LoanApplication retrieveLoanApplicationById(long loanApplicationId) throws InvalidLoanApplicationException {
		
		Optional<LoanApplication> optional = null;
		try {
			optional = repository.findById(loanApplicationId);
			repository.findById(loanApplicationId);
		}catch (Exception e) {
			e.printStackTrace();
			if(optional.get() == null) {
				throw new InvalidLoanApplicationException ("Loan application ID not found in records!");
				}
		}
		return optional.get();
	}

}
