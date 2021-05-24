package com.ja5g4.homeloan.service;

import java.util.List;


import com.ja5g4.homeloan.entities.LoanAgreement;
import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.InvalidLoanAgreementException;
import com.ja5g4.homeloan.repository.ILoanAgreementRepository;

public interface ILoanAgreementService{
	
	public LoanAgreement addLoanAgreement(LoanAgreement loanAgreement) ;
		
		public LoanAgreement updateLoanAgreement(LoanAgreement loanAgreement) throws InvalidLoanAgreementException;
		public LoanAgreement deleteLoanAgreement(long loanAgreementId) throws InvalidLoanAgreementException;
		public List<LoanAgreement> retrieveAllLoanAgreement();
		public LoanAgreement retrieveLoanAgreementById(long loanAgreementId)throws InvalidLoanAgreementException;
		
		




}
