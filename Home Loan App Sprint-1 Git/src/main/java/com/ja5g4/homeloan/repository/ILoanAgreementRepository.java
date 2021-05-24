package com.ja5g4.homeloan.repository;
import java.util.List;


import com.ja5g4.homeloan.entities.LoanAgreement;
import com.ja5g4.homeloan.entities.LoanApplication;

public interface ILoanAgreementRepository {
	
	public LoanAgreement addLoanAgreement(LoanAgreement loanAgreement);
		
		public LoanAgreement updateLoanAgreement(LoanAgreement loanAgreement);
		public LoanAgreement deleteLoanAgreement(long loanAgreementId);
		public List<LoanAgreement> retrieveAllLoanAgreement();
		public LoanAgreement retrieveLoanAgreementById(long loanAgreementId);
		
		




}