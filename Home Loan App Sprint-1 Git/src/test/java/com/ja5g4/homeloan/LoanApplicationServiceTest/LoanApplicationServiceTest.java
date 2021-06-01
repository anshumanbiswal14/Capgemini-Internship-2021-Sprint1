package com.ja5g4.homeloan.LoanApplicationServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;
import com.ja5g4.homeloan.repository.ILoanApplicationRepository;
import com.ja5g4.homeloan.service.ILoanApplicationServiceImpl;

@SpringBootTest
public class LoanApplicationServiceTest {
	
	ILoanApplicationRepository applicationrepo;
	private static ILoanApplicationServiceImpl applicationService;
	private static AutoCloseable ac;
	
	@BeforeEach
	public void doinit()
	{
		applicationrepo = mock(ILoanApplicationRepository.class); // Test through Approach 2
		applicationService = new  ILoanApplicationServiceImpl(applicationrepo); // Approach 2
		ac = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	public void doAtEnd()throws Exception
	{
		ac.close();
	}
	
	@Test
	//@Disabled
	@DisplayName("Test- Add Loan Application")
	void testaddLoanApplication() {
	
		LoanApplication input = new LoanApplication();
		input.setApplicationId(101);
		input.setApplicationDate(LocalDate.parse("2020-01-08"));
		input.setCustomer(null);
		input.setLoanAppliedAmount(190000);
		input.setLoanApprovedAmount(90000);
		input.setLandVerificationApproval(true);
		input.setFinanceVerificationApproval(false);
		input.setAdminApproval(true);
		input.setStatus(null);
		
		LoanApplication output = new LoanApplication();
		output.setApplicationId(101);
		output.setApplicationDate(LocalDate.parse("2020-01-08"));
		output.setCustomer(null);
		output.setLoanAppliedAmount(190000);
		output.setLoanApprovedAmount(90000);
		output.setLandVerificationApproval(true);
		output.setFinanceVerificationApproval(false);
		output.setAdminApproval(true);
		output.setStatus(null);
			
		when(applicationrepo.save(output)).thenReturn(output);
		applicationService.addLoanApplication(output);
	 	verify(applicationrepo).save(output);
		assertEquals(output,output);
		
	}
	
	
	@Test
	//@Disabled
	@DisplayName("Test - Get All Loan Applications")
	void testGetAllCustomers() {
		
		LoanApplication L1 = new LoanApplication();
		L1.setApplicationId(101);
		L1.setApplicationDate(LocalDate.parse("2020-01-08"));
		L1.setCustomer(null);
		L1.setLoanAppliedAmount(190000);
		L1.setLoanApprovedAmount(90000);
		L1.setLandVerificationApproval(true);
		L1.setFinanceVerificationApproval(false);
		L1.setAdminApproval(true);
		L1.setStatus(null);
		
		LoanApplication L2 = new LoanApplication();
		L2.setApplicationId(101);
		L2.setApplicationDate(LocalDate.parse("2020-01-08"));
		L2.setCustomer(null);
		L2.setLoanAppliedAmount(190000);
		L2.setLoanApprovedAmount(90000);
		L2.setLandVerificationApproval(true);
		L2.setFinanceVerificationApproval(false);
		L2.setAdminApproval(true);
		L2.setStatus(null);
		
		List<LoanApplication> loanApplicationList1 = new ArrayList<>();
		loanApplicationList1.add(L1);
		loanApplicationList1.add(L2);
		
		when(applicationrepo.findAll()).thenReturn(loanApplicationList1);
		
		List<LoanApplication> applicationListOutput = applicationService.retrieveAllLoanApplication();
		
		
		verify(applicationrepo).findAll();
		assertIterableEquals(loanApplicationList1, applicationListOutput);
	}

	
	@Test
	//@Disabled
	@DisplayName("Test - Get Loan Application by ID")
	void retrieveLoanApplicationById()  throws InvalidLoanApplicationException{
		
		Optional<LoanApplication> s = Optional.empty();
		
		when(applicationrepo.findById(null)).thenReturn(s);
		verify(applicationrepo).findById(null);
		Executable executable = ()->{
			assertNotNull(applicationService.retrieveLoanApplicationById(101));
		};
		assertThrows(InvalidLoanApplicationException.class, executable);
	}
	
	@Test
	//@Disabled
	@DisplayName("Test - Delete Loan Application")
	void deleteLoanApplication() throws InvalidLoanApplicationException {
		
		LoanApplication input = new LoanApplication();
		input.setApplicationId(101);
		input.setApplicationDate(LocalDate.parse("2020-01-08"));
		input.setCustomer(null);
		input.setLoanAppliedAmount(190000);
		input.setLoanApprovedAmount(90000);
		input.setLandVerificationApproval(true);
		input.setFinanceVerificationApproval(false);
		input.setAdminApproval(true);
		input.setStatus(null);
        
		LoanApplication output = new LoanApplication();
		output.setApplicationId(101);
		output.setApplicationDate(LocalDate.parse("2020-01-08"));
		output.setCustomer(null);
		output.setLoanAppliedAmount(190000);
		output.setLoanApprovedAmount(90000);
		output.setLandVerificationApproval(true);
		output.setFinanceVerificationApproval(false);
		output.setAdminApproval(true);
		output.setStatus(null);
		
		
		try{
			doNothing().
			 when(applicationrepo).delete(input);

			applicationService.deleteLoanApplication(1);

			verify(applicationrepo).delete(input);
			assertEquals(input,output);

		}
		catch(InvalidLoanApplicationException e) {
			
		}
		  
	}
	
	@Test
	//@Disabled
	@DisplayName("Test- Update Loan Application")
	void updateLoanApplication() throws InvalidLoanApplicationException {
		
		LoanApplication input = new LoanApplication();
		input.setApplicationId(101);
		input.setApplicationDate(LocalDate.parse("2020-01-08"));
		input.setCustomer(null);
		input.setLoanAppliedAmount(190000);
		input.setLoanApprovedAmount(90000);
		input.setLandVerificationApproval(true);
		input.setFinanceVerificationApproval(false);
		input.setAdminApproval(true);
		input.setStatus(null);
        
		LoanApplication output = new LoanApplication();
		output.setApplicationId(101);
		output.setApplicationDate(LocalDate.parse("2020-01-08"));
		output.setCustomer(null);
		output.setLoanAppliedAmount(190000);
		output.setLoanApprovedAmount(90000);
		output.setLandVerificationApproval(true);
		output.setFinanceVerificationApproval(false);
		output.setAdminApproval(true);
		output.setStatus(null);
		
		try{
			when(applicationrepo.save(input)).thenReturn(output);
			
			applicationService.updateLoanApplication(input);

			assertEquals(input,output);
		}
		catch(InvalidLoanApplicationException e) {
			
		}
	}
	
}	
