package com.ja5g4.homeloan.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja5g4.homeloan.entities.Customer;
import com.ja5g4.homeloan.entities.LoanAgreement;
import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.CustomerNotFoundException;
import com.ja5g4.homeloan.repository.ICustomerRepository;
import com.ja5g4.homeloan.repository.ILoanAgreementRepository;
import com.ja5g4.homeloan.repository.ILoanApplicationRepository;

@Service
public class ICustomerServiceImpl implements ICustomerService  {
	
	@Autowired
	ICustomerRepository repository;
	@Autowired
	ILoanAgreementRepository agreementRepository;
	@Autowired
	ILoanApplicationRepository applicationRepository;
	
	public ICustomerServiceImpl(ICustomerRepository repository) {
		super();
		this.repository = repository;
	}

	@Transactional
	@Override
	public Customer addCustomer(Customer customer) {
		
		try {
			repository.save(customer);
		} catch (Exception e) {
			
		}
				return customer;
	}

	@Transactional
	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
		
		Optional<Customer> optional = Optional.empty();
		
			optional = repository.findById(customer.getUserId());
			if(optional.isPresent()) {
				repository.save(customer);
				return optional.get();
			}
			else {
				throw new CustomerNotFoundException("Customer couldn't be Updated! ");
			}
		
				
	}
	
	@Transactional
	@Override
	public Customer deleteCustomer(int custid) throws CustomerNotFoundException {
		
		Optional<Customer> optional =Optional.empty();
		
			optional = repository.findById(custid);
			if(optional.isPresent()) 
			{
			repository.deleteById(custid);
			return optional.get();
			}
			else {
				throw new CustomerNotFoundException("Customer not found for delete operation!");
			}
		

	}

	@Override
	public Customer viewCustomer(int custid) throws CustomerNotFoundException {
	
		Optional<Customer> optional = Optional.empty();
		try {
			optional = repository.findById(custid);
			if(optional.isPresent()) {
				repository.findById(custid);
			}
			else {
				throw new CustomerNotFoundException("Customer not found with the matching ID!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomerNotFoundException("Customer not found with the matching ID!");
		}
		return optional.get();
	}

	@Override
	public List<Customer> viewAllCustomers() {
		List<Customer> customerList = null;
		try {
			customerList = repository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return customerList;
	}

	@Override
	public List<Customer> viewCustomerList(LocalDate dateOfApplication) {
		List<Customer> customerList = new ArrayList<>();
		List<LoanAgreement> allAgreement = null;
		try {
			allAgreement = agreementRepository.findAll();
			for(LoanAgreement la : allAgreement) {
				Long agreementId = la.getLoanApplicationId();
				
				Optional<LoanApplication> optional = applicationRepository.findById(agreementId);
				if(optional.isPresent()){
					if(optional.get().getApplicationDate().equals(dateOfApplication)){
						
						customerList.add(optional.get().getCustomer());
						
					}

				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return customerList;
	}

}
