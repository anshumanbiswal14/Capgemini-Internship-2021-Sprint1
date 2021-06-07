package com.ja5g4.homeloan.service;

import java.util.List; 

import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;

/* Loan Application Service
 * ILoanApplicationServiceImpl implements ILoanApplicationService interface
 * LoanApplication addLoanApplication(LoanApplication loanApplication) to add new loan application
 * LoanApplication updateLoanApplication(LoanApplication loanApplication) throws InvalidLoanApplicationException to update the loan application
 * LoanApplication deleteLoanApplication(long loanApplicationId) throws InvalidLoanApplicationException to delete the loan application
 * List<LoanApplication> retrieveAllLoanApplication() to get all the loan applications
 * LoanApplication retrieveLoanApplicationById(long loanApplicationId) throws InvalidLoanApplicationException to get all the loan applications by loan Id
 * 
 * Author : Ashwin
 * */

public interface ILoanApplicationService  {
	
	public LoanApplication addLoanApplication(LoanApplication loanApplication);
	public LoanApplication updateLoanApplication(LoanApplication loanApplication) throws InvalidLoanApplicationException;
	public LoanApplication deleteLoanApplication(long loanApplicationId) throws InvalidLoanApplicationException;
	public List<LoanApplication> retrieveAllLoanApplication();
	public LoanApplication retrieveLoanApplicationById(long loanApplicationId) throws InvalidLoanApplicationException;
	
	

}
