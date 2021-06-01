package com.ja5g4.homeloan.FinanceVerificationServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.entities.Status;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;
import com.ja5g4.homeloan.repository.ILoanApplicationRepository;
import com.ja5g4.homeloan.service.IFinanceVerificationServiceImpl;

@SpringBootTest
public class FinanceVerificationServiceTest {

	ILoanApplicationRepository loanApplicationRepo;

	private static IFinanceVerificationServiceImpl financeservice;

	private static AutoCloseable ac;

	@BeforeEach
	public void doinit() {
		loanApplicationRepo = mock(ILoanApplicationRepository.class); // test through approach 2
		financeservice = new IFinanceVerificationServiceImpl(loanApplicationRepo); // Approach 2
		ac = MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	public void doAtEnd() throws Exception {
		ac.close();
	}

	@Test
	@DisplayName("Test to update Status")
	void testUpdateStatus() throws InvalidLoanApplicationException {
		LoanApplication loanApplication = new LoanApplication(1,Status.APPROVED);

		
		Optional<LoanApplication> optionalApplication=Optional.of(loanApplication);
		LoanApplication updateLoanApplication = new LoanApplication(1,Status.PENDING);
		when(loanApplicationRepo.findById((long) 1)).thenReturn(optionalApplication);
		when(loanApplicationRepo.save(updateLoanApplication)).thenReturn(updateLoanApplication);
		LoanApplication test_loanapplication=financeservice.updateStatus(updateLoanApplication);
		assertEquals(updateLoanApplication,test_loanapplication);
	}

}
