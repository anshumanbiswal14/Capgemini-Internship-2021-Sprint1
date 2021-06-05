package com.ja5g4.homeloan.service;

import java.util.List;

import java.util.Optional;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;
import com.ja5g4.homeloan.repository.ILoanApplicationRepository;

@Service
public class ILoanApplicationServiceImpl implements ILoanApplicationService {
	Logger logger = Logger.getLogger(ILoanApplicationServiceImpl.class.getName());
	
	@Autowired
	ILoanApplicationRepository repository;

	

	public ILoanApplicationServiceImpl(ILoanApplicationRepository repository) {
		super();
		this.repository = repository;
	}

	@Transactional
	@Override
	public LoanApplication addLoanApplication(LoanApplication loanApplication) {
		
		try {
			repository.save(loanApplication);
			}catch (Exception e) {
				logger.info(e.getMessage());
			}
			return loanApplication;
	}

	@Transactional
	@Override
	public LoanApplication updateLoanApplication(LoanApplication loanApplication)
			throws InvalidLoanApplicationException {
		
		Optional<LoanApplication> optional = Optional.empty();
		
	    optional = repository.findById(loanApplication.getApplicationId());
	    if(optional.isPresent()) {
		repository.save(loanApplication);
		return optional.get();
	    }
	    else {
	    	
	    	throw new InvalidLoanApplicationException("Loan application couldn't be Updated! ");
	    }
		
		
	}

	@Transactional
	@Override
	public LoanApplication deleteLoanApplication(long loanApplicationId) throws InvalidLoanApplicationException {
		
		Optional<LoanApplication> optional = Optional.empty();
		
			optional = repository.findById(loanApplicationId);
			if(optional.isPresent()) {
			repository.deleteById(loanApplicationId);
			return optional.get();
			}
			else {
				throw new InvalidLoanApplicationException("Loan application ID not found for delete operation!");
			}
		
		}
		

	@Override
	public List<LoanApplication> retrieveAllLoanApplication() {
		
		List<LoanApplication>list = null;
		try {
			 list = repository.findAll();
		}catch (Exception e) {
			logger.info(e.getMessage());
		}
		return list;
	}

	@Override
	public LoanApplication retrieveLoanApplicationById(long loanApplicationId) throws InvalidLoanApplicationException {
		
		Optional<LoanApplication> optional = Optional.empty();
		
			optional = repository.findById(loanApplicationId);
			if(optional.isPresent()) {
				repository.findById(loanApplicationId);
				return optional.get();
			}
			else {
				throw new InvalidLoanApplicationException ("Loan application ID not found in records!");
			}
		
		
		
	}

}
