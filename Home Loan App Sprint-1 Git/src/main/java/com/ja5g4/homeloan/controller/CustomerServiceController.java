package com.ja5g4.homeloan.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja5g4.homeloan.entities.Customer;
import com.ja5g4.homeloan.exception.CustomerNotFoundException;
import com.ja5g4.homeloan.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerServiceController {
	
	@Autowired
	private ICustomerService customerService;
	
	
	
	public CustomerServiceController() {
		System.out.println("-----> Customer Rest Controller Working!");
		
	}

	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome : Home Loan Application (Version 1.0)";
	}
	
	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer customer) {
		this.customerService.addCustomer(customer);
		return customer;
	}
		
	@GetMapping("/view/{custid}")
	public Customer viewCustomer(@PathVariable("custid") int custid) throws CustomerNotFoundException {
		return this.customerService.viewCustomer(custid);
		
	}
	@PostMapping("/update")
	public Customer updateCustomer(@RequestBody Customer customer) throws CustomerNotFoundException{
		return this.customerService.updateCustomer(customer);
		
	}
	@DeleteMapping("/delete/{custid}")
	public Customer deleteCustomer(@PathVariable("custid") int custid) throws CustomerNotFoundException{
		return this.customerService.deleteCustomer(custid);
		
	}
	@GetMapping("/viewall")
	public List<Customer> viewAllCustomers(@RequestBody Customer customer){
		return this.customerService.viewAllCustomers();
		
	}
	@GetMapping("/viewbydate/{date}")
	public List<Customer> viewCustomerList(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfApplication){
		return this.customerService.viewCustomerList(dateOfApplication);
		
	}
	
}
