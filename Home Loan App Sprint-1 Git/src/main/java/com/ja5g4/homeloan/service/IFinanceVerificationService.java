package com.ja5g4.homeloan.service;

import com.ja5g4.homeloan.entities.LoanApplication;

import com.ja5g4.homeloan.repository.IFinanceVerificationRepository;

public interface IFinanceVerificationService  {
public void updateStatus(LoanApplication loanApplication) ;

}
