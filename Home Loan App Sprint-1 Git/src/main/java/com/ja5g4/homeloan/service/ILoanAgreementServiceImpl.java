package com.ja5g4.homeloan.service;

import java.util.List;

import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja5g4.homeloan.entities.EMI;
import com.ja5g4.homeloan.entities.LoanAgreement;
import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.InvalidLoanAgreementException;
import com.ja5g4.homeloan.repository.ILoanAgreementRepository;
import com.ja5g4.homeloan.repository.ILoanApplicationRepository;
import com.ja5g4.homeloan.util.EmiCalculator;

@Service
public class ILoanAgreementServiceImpl implements ILoanAgreementService {
    
	@Autowired
	ILoanAgreementRepository repository;
	
	@Autowired
	ILoanApplicationRepository loanApplicationRepository;
	
	
	@Override
	@Transactional
	public LoanAgreement addLoanAgreement(LoanAgreement loanAgreement) {
		
		try {
		long appId = loanAgreement.getLoanApplicationId();	
		LoanApplication loanApplication = loanApplicationRepository.findById(appId).get();
		double loanAmount = loanApplication.getLoanAppliedAmount();
		
		EmiCalculator emiCal = new EmiCalculator();
		emiCal.setLoanAmount(loanAmount);
		emiCal.setTenure(12);
		emiCal.setRateOfInterest(0.10);
		
		double emi = emiCal.getEMIAmount();
		Set<EMI> allemis =  loanAgreement.getAllemis();
		EMI emi1  = new EMI();
		emi1.setEmiAmount(emi);
		// to find the due date
		emi1.setDueDate(null);
		emi1.setInterestAmount(0.10);
		emi1.setLoanAmount(loanAmount);
		allemis.add(emi1);
		
		EMI emi2  = new EMI();
		emi1.setEmiAmount(emi);
		// to find the due date
		emi1.setDueDate(null);
		emi1.setInterestAmount(0.10);
		emi1.setLoanAmount(loanAmount);
		allemis.add(emi2);
		
		EMI emi3  = new EMI();
		emi1.setEmiAmount(emi);
		// to find the due date
		emi1.setDueDate(null);
		emi1.setInterestAmount(0.10);
		emi1.setLoanAmount(loanAmount);
		allemis.add(emi3);
		
		EMI emi4  = new EMI();
		emi1.setEmiAmount(emi);
		// to find the due date
		emi1.setDueDate(null);
		emi1.setInterestAmount(0.10);
		emi1.setLoanAmount(loanAmount);
		allemis.add(emi4);
		
		EMI emi5  = new EMI();
		emi1.setEmiAmount(emi);
		// to find the due date
		emi1.setDueDate(null);
		emi1.setInterestAmount(0.10);
		emi1.setLoanAmount(loanAmount);
		allemis.add(emi5);
		
		EMI emi6  = new EMI();
		emi1.setEmiAmount(emi);
		// to find the due date
		emi1.setDueDate(null);
		emi1.setInterestAmount(0.10);
		emi1.setLoanAmount(loanAmount);
		allemis.add(emi6);
		
		EMI emi7  = new EMI();
		emi1.setEmiAmount(emi);
		// to find the due date
		emi1.setDueDate(null);
		emi1.setInterestAmount(0.10);
		emi1.setLoanAmount(loanAmount);
		allemis.add(emi7);
		
		EMI emi8  = new EMI();
		emi1.setEmiAmount(emi);
		// to find the due date
		emi1.setDueDate(null);
		emi1.setInterestAmount(0.10);
		emi1.setLoanAmount(loanAmount);
		allemis.add(emi8);
		
		EMI emi9  = new EMI();
		emi1.setEmiAmount(emi);
		// to find the due date
		emi1.setDueDate(null);
		emi1.setInterestAmount(0.10);
		emi1.setLoanAmount(loanAmount);
		allemis.add(emi9);
		
		EMI emi10  = new EMI();
		emi1.setEmiAmount(emi);
		// to find the due date
		emi1.setDueDate(null);
		emi1.setInterestAmount(0.10);
		emi1.setLoanAmount(loanAmount);
		allemis.add(emi10);
		
		EMI emi11  = new EMI();
		emi1.setEmiAmount(emi);
		// to find the due date
		emi1.setDueDate(null);
		emi1.setInterestAmount(0.10);
		emi1.setLoanAmount(loanAmount);
		allemis.add(emi11);
		
		EMI emi12  = new EMI();
		emi1.setEmiAmount(emi);
		// to find the due date
		emi1.setDueDate(null);
		emi1.setInterestAmount(0.10);
		emi1.setLoanAmount(loanAmount);
		allemis.add(emi12);
			
			
			
			
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