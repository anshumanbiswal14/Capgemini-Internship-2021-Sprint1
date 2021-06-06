package com.ja5g4.homeloan.LoanAgreementServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.ja5g4.homeloan.entities.LoanAgreement;

import com.ja5g4.homeloan.exception.InvalidLoanAgreementException;
import com.ja5g4.homeloan.repository.ILoanAgreementRepository;
import com.ja5g4.homeloan.repository.ILoanApplicationRepository;
import com.ja5g4.homeloan.service.ILoanAgreementServiceImpl;

@SpringBootTest
class LoanAgreementServiceTest {

	ILoanAgreementRepository agreementrepo;
	ILoanApplicationRepository applicationrepo;
	private static ILoanAgreementServiceImpl agreementService;
	private static AutoCloseable ac;

	@BeforeEach
	public void doinit() {
		agreementrepo = mock(ILoanAgreementRepository.class);
		agreementService = new ILoanAgreementServiceImpl(agreementrepo);
		ac = MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	public void doAtEnd() throws Exception {
		ac.close();
	}

	@Test
	// @Disabled
	@DisplayName("Test - Add Loan Agreement")
	void testaddLoanAgreement() {

		LoanAgreement agreementInput = new LoanAgreement();
		agreementInput.setAllemis(null);
		agreementInput.setLoanAgreementId(1);
		agreementInput.setLoanApplicationId(101);

		LoanAgreement agreement_test = agreementService.addLoanAgreement(agreementInput);
		assertEquals(agreementInput, agreement_test);

	}

	@Test
	// @Disabled
	@DisplayName("Test - Get All Loan Agreements")
	void testretrieveAllLoanAgreements() {
		List<LoanAgreement> agreementList = mock(List.class);
		when(agreementrepo.findAll()).thenReturn(agreementList);
		List<LoanAgreement> outputAgreementList = agreementService.retrieveAllLoanAgreement();
		assertEquals(agreementList, outputAgreementList);
	}

	@Test
	// @Disabled
	@DisplayName("Test - Get Loan Agreements by ID")
	void testViewCustomerById() throws InvalidLoanAgreementException {

		Long input = (long) 101;
		LoanAgreement loanAgreement = mock(LoanAgreement.class);
		Optional<LoanAgreement> optional_loanAgreement = Optional.of(loanAgreement);
		when(agreementrepo.findById(input)).thenReturn(optional_loanAgreement);
		Optional<LoanAgreement> agreement_test = Optional.of(agreementService.retrieveLoanAgreementById(input));
		assertEquals(optional_loanAgreement, agreement_test);
	}

	@Test
	// @Disabled
	@DisplayName("Test - Delete Loan Agreement")
	void deleteLoanAgreement() throws InvalidLoanAgreementException {

		LoanAgreement input = new LoanAgreement();
		input.setAllemis(null);
		input.setLoanAgreementId(1);
		input.setLoanApplicationId(1);

		LoanAgreement output = new LoanAgreement();
		output.setAllemis(null);
		output.setLoanAgreementId(1);
		output.setLoanApplicationId(1);

		try {
			doNothing().when(agreementrepo).delete(input);

			agreementService.deleteLoanAgreement(1);

			verify(agreementrepo).delete(input);
			assertEquals(input, output);

		} catch (InvalidLoanAgreementException e) {

		}

	}

	@Test
	// @Disabled
	@DisplayName("Test- Update Loan Agreement")
	void updateLoanAgreement() throws InvalidLoanAgreementException {

		LoanAgreement input = new LoanAgreement();
		input.setAllemis(null);
		input.setLoanAgreementId(1);
		input.setLoanApplicationId(1);

		Optional<LoanAgreement> optionalAgreement = Optional.of(input);
		LoanAgreement output = new LoanAgreement();
		output.setAllemis(null);
		output.setLoanAgreementId(1);
		output.setLoanApplicationId(1);

		when(agreementrepo.findById((long) 1)).thenReturn(optionalAgreement);
		when(agreementrepo.save(output)).thenReturn(output);
		LoanAgreement agreement_test = agreementService.updateLoanAgreement(output);
		assertEquals(output, agreement_test);

	}

}
