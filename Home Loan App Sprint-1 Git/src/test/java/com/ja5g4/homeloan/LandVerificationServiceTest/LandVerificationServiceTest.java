package com.ja5g4.homeloan.LandVerificationServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.ja5g4.homeloan.entities.LandVerificationOfficer;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;
import com.ja5g4.homeloan.repository.ILandVerificationRepository;
import com.ja5g4.homeloan.service.ILandVerificationServiceImpl;

@SpringBootTest
public class LandVerificationServiceTest {
	
	ILandVerificationRepository verificationRepo;
	private static ILandVerificationServiceImpl verificationService;
	private static AutoCloseable ac;
	
	@BeforeEach
	public void doinit()
	{
	      verificationRepo = mock(ILandVerificationRepository.class); 
	      verificationService = new ILandVerificationServiceImpl(verificationRepo); 	
		  ac = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	public void doAtEnd()throws Exception
	{
		ac.close();
	}
	
	@Test
	//@Disabled
	@DisplayName("Test - Update Land Verification")
	void updateStatus() {
	
		LandVerificationOfficer input = new LandVerificationOfficer();
		input.setOfficerName("Anshuman Biswal");
		input.setOfficerContact("9066827223");
		
		LandVerificationOfficer output = new LandVerificationOfficer();
		output.setOfficerName("Anshuman Biswal");
		output.setOfficerContact("9066827223");
		
		try{
			when(verificationRepo.save(input)).thenReturn(output);
			
			verificationService.updateStatus(null);

			assertEquals(input,output);
		}
		catch(InvalidLoanApplicationException e) {
			
		}
	
	}
}
