package com.ja5g4.homeloan.LandVerificationServiceTest;

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
import com.ja5g4.homeloan.service.ILandVerificationServiceImpl;

@SpringBootTest
public class LandVerificationServiceTest {

	ILoanApplicationRepository verificationRepo;
	private static ILandVerificationServiceImpl verificationService;
	private static AutoCloseable ac;

	@BeforeEach
	public void doinit() {
		verificationRepo = mock(ILoanApplicationRepository.class);
		verificationService = new ILandVerificationServiceImpl(verificationRepo);
		ac = MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	public void doAtEnd() throws Exception {
		ac.close();
	}

	@Test
	// @Disabled
	@DisplayName("Test - Update Land Verification")
	void updateStatus() throws InvalidLoanApplicationException{

		LoanApplication loanApplication = new LoanApplication(1, Status.APPROVED);

		Optional<LoanApplication> optionalApplication = Optional.of(loanApplication);
		LoanApplication updateLoanApplication = new LoanApplication(1, Status.PENDING);
		when(verificationRepo.findById((long) 1)).thenReturn(optionalApplication);
		when(verificationRepo.save(updateLoanApplication)).thenReturn(updateLoanApplication);
		LoanApplication test_loanapplication = verificationService.updateStatus(updateLoanApplication);
		assertEquals(updateLoanApplication, test_loanapplication);

	}
}
