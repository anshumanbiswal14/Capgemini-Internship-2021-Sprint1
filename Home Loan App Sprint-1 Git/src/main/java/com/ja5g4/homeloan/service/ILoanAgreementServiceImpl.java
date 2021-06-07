package com.ja5g4.homeloan.service;

import java.time.LocalDate; 

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

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

/* Loan Agreement Service
 * LoanAgreement addLoanAgreement(LoanAgreement loanAgreement) to add new loan agreement
 * LoanAgreement updateLoanAgreement(LoanAgreement loanAgreement) throws InvalidLoanAgreementException to update the loan agreement
 * LoanAgreement deleteLoanAgreement(long loanAgreementId) throws InvalidLoanAgreementException to delete the loan agreement
 * List<LoanAgreement> retrieveAllLoanAgreement() to get all the loan agreement
 * LoanAgreement retrieveLoanAgreementById(long loanAgreementId)throws InvalidLoanAgreementException to get loan agreement by loan Id
 
 * Author : Bharath Surya 
 * */


@Service
public class ILoanAgreementServiceImpl implements ILoanAgreementService {
	Logger logger = Logger.getLogger(ILoanAgreementServiceImpl.class.getName());

	@Autowired
	ILoanAgreementRepository repository;

	@Autowired
	ILoanApplicationRepository loanApplicationRepository;

	public ILoanAgreementServiceImpl(ILoanAgreementRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	@Transactional
	public LoanAgreement addLoanAgreement(LoanAgreement loanAgreement) {

		try {
			long appId = loanAgreement.getLoanApplicationId();

			Optional<LoanApplication> optional = loanApplicationRepository.findById(appId);
			if (optional.isPresent()) {
				double loanAmount = optional.get().getLoanApprovedAmount();

				EmiCalculator emiCal = new EmiCalculator();
				emiCal.setLoanAmount(loanAmount);
				emiCal.setTenure(12);
				emiCal.setRateOfInterest(0.10);

				double emi = emiCal.getEMIAmount();
				Set<EMI> allemis = loanAgreement.getAllemis();
				EMI emi1 = new EMI();
				emi1.setEmiAmount(emi);
				emi1.setDueDate(LocalDate.now());
				emi1.setInterestAmount(0.10);
				emi1.setLoanAmount(loanAmount);
				allemis.add(emi1);

				EMI emi2 = new EMI();
				emi2.setEmiAmount(emi);
				emi2.setDueDate(LocalDate.now().plusMonths(1));
				emi2.setInterestAmount(0.10);
				emi2.setLoanAmount(loanAmount);
				allemis.add(emi2);

				EMI emi3 = new EMI();
				emi3.setEmiAmount(emi);
				emi3.setDueDate(LocalDate.now().plusMonths(2));
				emi3.setInterestAmount(0.10);
				emi3.setLoanAmount(loanAmount);
				allemis.add(emi3);

				EMI emi4 = new EMI();
				emi4.setEmiAmount(emi);
				emi4.setDueDate(LocalDate.now().plusMonths(3));
				emi4.setInterestAmount(0.10);
				emi4.setLoanAmount(loanAmount);
				allemis.add(emi4);

				EMI emi5 = new EMI();
				emi5.setEmiAmount(emi);
				emi5.setDueDate(LocalDate.now().plusMonths(4));
				emi5.setInterestAmount(0.10);
				emi5.setLoanAmount(loanAmount);
				allemis.add(emi5);

				EMI emi6 = new EMI();
				emi6.setEmiAmount(emi);
				emi6.setDueDate(LocalDate.now().plusMonths(5));
				emi6.setInterestAmount(0.10);
				emi6.setLoanAmount(loanAmount);
				allemis.add(emi6);

				EMI emi7 = new EMI();
				emi7.setEmiAmount(emi);
				emi7.setDueDate(LocalDate.now().plusMonths(6));
				emi7.setInterestAmount(0.10);
				emi7.setLoanAmount(loanAmount);
				allemis.add(emi7);

				EMI emi8 = new EMI();
				emi8.setEmiAmount(emi);
				emi8.setDueDate(LocalDate.now().plusMonths(7));
				emi8.setInterestAmount(0.10);
				emi8.setLoanAmount(loanAmount);
				allemis.add(emi8);

				EMI emi9 = new EMI();
				emi9.setEmiAmount(emi);
				emi9.setDueDate(LocalDate.now().plusMonths(8));
				emi9.setInterestAmount(0.10);
				emi9.setLoanAmount(loanAmount);
				allemis.add(emi9);

				EMI emi10 = new EMI();
				emi10.setEmiAmount(emi);
				emi10.setDueDate(LocalDate.now().plusMonths(9));
				emi10.setInterestAmount(0.10);
				emi10.setLoanAmount(loanAmount);
				allemis.add(emi10);

				EMI emi11 = new EMI();
				emi11.setEmiAmount(emi);
				emi11.setDueDate(LocalDate.now().plusMonths(10));
				emi11.setInterestAmount(0.10);
				emi11.setLoanAmount(loanAmount);
				allemis.add(emi11);

				EMI emi12 = new EMI();
				emi12.setEmiAmount(emi);
				emi12.setDueDate(LocalDate.now().plusMonths(11));
				emi12.setInterestAmount(0.10);
				emi12.setLoanAmount(loanAmount);
				allemis.add(emi12);

				repository.save(loanAgreement);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return loanAgreement;
	}

	@Override
	@Transactional
	public LoanAgreement updateLoanAgreement(LoanAgreement loanAgreement) throws InvalidLoanAgreementException {

		Optional<LoanAgreement> optional = repository.findById(loanAgreement.getLoanAgreementId());
		if (optional.isPresent()) {

			repository.save(loanAgreement);
			return loanAgreement;

		} else {

			throw new InvalidLoanAgreementException("Loan agreement couldn't be Updated! ");
		}

	}

	@Override
	@Transactional
	public LoanAgreement deleteLoanAgreement(long loanAgreementId) throws InvalidLoanAgreementException {

		Optional<LoanAgreement> optional = repository.findById(loanAgreementId);
		if (optional.isPresent()) {
			repository.deleteById(loanAgreementId);
			return optional.get();
		} else {
			throw new InvalidLoanAgreementException("Loan agreement not found for delete operation!");
		}

	}

	@Override
	public List<LoanAgreement> retrieveAllLoanAgreement() {

		List<LoanAgreement> list = null;
		try {
			list = repository.findAll();
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return list;
	}

	@Override
	public LoanAgreement retrieveLoanAgreementById(long loanAgreementId) throws InvalidLoanAgreementException {

		Optional<LoanAgreement> optional = repository.findById(loanAgreementId);
		if (optional.isPresent()) {
			repository.findById(loanAgreementId);
			return optional.get();
		} else {
			throw new InvalidLoanAgreementException("Loan agreement ID not found in records!");
		}

	}

}