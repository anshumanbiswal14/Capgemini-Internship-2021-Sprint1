package com.ja5g4.homeloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja5g4.homeloan.service.ICustomerService;

@RestController
@RequestMapping("/api")
public class CustomerServiceController {
	
	@Autowired
	private ICustomerService customerservice;
	

}
