package com.ja5g4.homeloan.CustomerServiceTest;

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

import com.ja5g4.homeloan.entities.Customer;
import com.ja5g4.homeloan.exception.CustomerNotFoundException;
import com.ja5g4.homeloan.repository.ICustomerRepository;
import com.ja5g4.homeloan.service.ICustomerServiceImpl;

@SpringBootTest
public class CustomerServiceTest {
	
	ICustomerRepository customerRepo;
	private static ICustomerServiceImpl customerService;
	private static AutoCloseable ac;
	
	@BeforeEach
	public void doinit()
	{
	      customerRepo = mock(ICustomerRepository.class); // test through approach 2
	      customerService = new  ICustomerServiceImpl(customerRepo); 	// Approach 2
		ac = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	public void doAtEnd()throws Exception
	{
		ac.close();
	}
	
	@Test
	//@Disabled
	@DisplayName("Test-Save-Customer")
	void testSaveCustomer() {
	
		Customer input = new Customer();
		input.setUserId(1);
		input.setCustomerName("srividya");
		input.setMobileNumber("9876543210");
		input.setEmailId("vaddi.srividya0103@gmail.com");
		input.setPassword("srividya0103");
		input.setDateOfBirth(LocalDate.parse("2020-01-08"));
		input.setGender("Female");
		input.setNationality("Indian");
		input.setAadharNumber("1231231223");
		input.setPanNumber("123456yuio");
        
		Customer output = new Customer();
		output.setUserId(1);
		output.setCustomerName("srividy");
		output.setMobileNumber("9876543210");
		output.setEmailId("vaddi.srividya0103@gmail.com");
		output.setPassword("srividya0103");
		output.setDateOfBirth(LocalDate.parse("2020-01-08"));
		output.setGender("Female");
		output.setNationality("Indian");
		output.setAadharNumber("1231231223");
		output.setPanNumber("123456yuio");
    	
		
		when(customerRepo.save(input)).thenReturn(output);
	    customerService.addCustomer(input);
	 	verify(customerRepo).save(input);
		assertEquals(input,output);
	}
	
	@Test
	//@Disabled
	@DisplayName("Test-Get All Customer")
	void testGetAllCustomers() {
		
		Customer c1 = new Customer();
		c1.setUserId(1);
		c1.setCustomerName("srividya");
		c1.setMobileNumber("9876543210");
		c1.setEmailId("vaddi.srividya0103@gmail.com");
		c1.setPassword("srividya0103");
		c1.setDateOfBirth(LocalDate.parse("2020-01-08"));
		c1.setGender("Female");
		c1.setNationality("Indian");
		c1.setAadharNumber("123123123123");
		c1.setPanNumber("123456yuio");
		
		Customer c2 = new Customer();
		c2.setUserId(1);
		c2.setCustomerName("srividya");
		c2.setMobileNumber("9876543210");
		c2.setEmailId("vaddi.srividya0103@gmail.com");
		c2.setPassword("srividya0103");
		c2.setDateOfBirth(LocalDate.parse("2020-01-08"));
		c2.setGender("Female");
		c2.setNationality("Indian");
		c2.setAadharNumber("123123123123");
		c2.setPanNumber("123456yuio");
		
		List<Customer> customerList1 = new ArrayList<>();
		customerList1.add(c1);
		customerList1.add(c2);
		
		when(customerRepo.findAll()).thenReturn(customerList1);
		
		List<Customer> customerListOutput = customerService.viewAllCustomers();
		
		
		verify(customerRepo).findAll();
		assertIterableEquals(customerList1, customerListOutput);
	}

	@Test
	//@Disabled
	@DisplayName("Test-Get Customer by Id")
	void testViewCustomerById()  throws CustomerNotFoundException{
		
		Optional<Customer> s = Optional.empty();
		
		when(customerRepo.findById(1)).thenReturn(s);
		verify(customerRepo).findById(1);
		Executable executable = ()->{
			assertNotNull(customerService.viewCustomer(1));
		};
		assertThrows(CustomerNotFoundException.class, executable);
	}
	
	

	@Test
	//@Disabled
	@DisplayName("Test-Delete Customer")
	void testDeleteCustomer() throws CustomerNotFoundException {
		Customer input = new Customer();
		input.setUserId(1);
		input.setCustomerName("srividya");
		input.setMobileNumber("9876543210");
		input.setEmailId("vaddi.srividya0103@gmail.com");
		input.setPassword("srividya0103");
		input.setDateOfBirth(LocalDate.parse("2020-01-08"));
		input.setGender("Female");
		input.setNationality("Indian");
		input.setAadharNumber("1231231223");
		input.setPanNumber("123456yuio");
        
		Customer output = new Customer();
		output.setUserId(1);
		output.setCustomerName("srividy");
		output.setMobileNumber("9876543210");
		output.setEmailId("vaddi.srividya0103@gmail.com");
		output.setPassword("srividya0103");
		output.setDateOfBirth(LocalDate.parse("2020-01-08"));
		output.setGender("Female");
		output.setNationality("Indian");
		output.setAadharNumber("1231231223");
		output.setPanNumber("123456yuio");
		
		
		try{
			doNothing().
			 when(customerRepo).delete(input);

			customerService.deleteCustomer(1);

			verify(customerRepo).delete(input);
			assertEquals(input,output);

		}
		catch(CustomerNotFoundException e) {
			
		}
		  
	}
	
	@Test
	//@Disabled
	@DisplayName("Test-Update customer")
	void testUpdateSeed() throws CustomerNotFoundException {
		
		Customer input = new Customer();
		input.setUserId(1);
		input.setCustomerName("srividya");
		input.setMobileNumber("9876543210");
		input.setEmailId("vaddi.srividya0103@gmail.com");
		input.setPassword("srividya0103");
		input.setDateOfBirth(LocalDate.parse("2020-01-08"));
		input.setGender("Female");
		input.setNationality("Indian");
		input.setAadharNumber("1231231223");
		input.setPanNumber("123456yuio");
        
		Customer output = new Customer();
		output.setUserId(1);
		output.setCustomerName("srividy");
		output.setMobileNumber("9876543210");
		output.setEmailId("vaddi.srividya0103@gmail.com");
		output.setPassword("srividya0103");
		output.setDateOfBirth(LocalDate.parse("2020-01-08"));
		output.setGender("Female");
		output.setNationality("Indian");
		output.setAadharNumber("1231231223");
		output.setPanNumber("123456yuio");
		
		try{
			when(customerRepo.save(input)).thenReturn(output);
			
			customerService.updateCustomer(input);

			assertEquals(input,output);
		}
		catch(CustomerNotFoundException e) {
			
		}
	}
	

	
	
}
