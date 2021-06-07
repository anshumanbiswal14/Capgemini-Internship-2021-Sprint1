package com.ja5g4.homeloan.service;

import java.util.List; 

import com.ja5g4.homeloan.entities.LoanAgreement;
import com.ja5g4.homeloan.exception.InvalidLoanAgreementException;

/* Loan Agreement Service
 * LoanAgreement addLoanAgreement(LoanAgreement loanAgreement) to add new loan agreement
 * LoanAgreement updateLoanAgreement(LoanAgreement loanAgreement) throws InvalidLoanAgreementException to update the loan agreement
 * LoanAgreement deleteLoanAgreement(long loanAgreementId) throws InvalidLoanAgreementException to delete the loan agreement
 * List<LoanAgreement> retrieveAllLoanAgreement() to get all the loan agreement
 * LoanAgreement retrieveLoanAgreementById(long loanAgreementId)throws InvalidLoanAgreementException to get loan agreement by loan Id
 
 * Author : Bharath Surya 
 * */



public interface ILoanAgreementService{
	
		public LoanAgreement addLoanAgreement(LoanAgreement loanAgreement);
		public LoanAgreement updateLoanAgreement(LoanAgreement loanAgreement) throws InvalidLoanAgreementException;
		public LoanAgreement deleteLoanAgreement(long loanAgreementId) throws InvalidLoanAgreementException;
		public List<LoanAgreement> retrieveAllLoanAgreement();
		public LoanAgreement retrieveLoanAgreementById(long loanAgreementId)throws InvalidLoanAgreementException;
		
		




}
