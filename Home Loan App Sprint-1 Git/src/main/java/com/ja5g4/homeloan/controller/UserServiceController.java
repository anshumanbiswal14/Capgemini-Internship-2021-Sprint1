package com.ja5g4.homeloan.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja5g4.homeloan.entities.Admin;
import com.ja5g4.homeloan.entities.FinanceVerificationOfficer;
import com.ja5g4.homeloan.entities.LandVerificationOfficer;
import com.ja5g4.homeloan.entities.User;
import com.ja5g4.homeloan.service.IUserService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/user")
@ApiModel(value = "User Service Rest Controller" , description = "Holds all APIs related to the User Service")
public class UserServiceController {
	Logger logger = Logger.getLogger(LoanAgreementController.class.getName());	
	
	public UserServiceController() {
		logger.log(Level.INFO,"----->Inside User Service Controller Working!");
	}
	
	@Autowired
	IUserService userService;
	
	@ApiOperation(value = "POST mapping to add new user as admin to the LOAN_USER table in the Database", response = User.class)
	@PostMapping("/adduserasadmin")
	public Admin addNewUser(@RequestBody  @Valid Admin admin) {
		this.userService.addNewUser(admin);
		return admin;
		
	}
	
	@ApiOperation(value = "POST mapping to add new user as landofficer to the LOAN_USER table in the Database", response = User.class)
	@PostMapping("/adduseraslandofficer")
	public LandVerificationOfficer addNewUser(@RequestBody @Valid LandVerificationOfficer landOfficerVerificationOfficer) {
		this.userService.addNewUser(landOfficerVerificationOfficer);
		return landOfficerVerificationOfficer;
		
	}
	
	@ApiOperation(value = "POST mapping to add new user as financeofficer to the LOAN_USER table in the Database", response = User.class)
	@PostMapping("/adduserasfinanceofficer")
	public FinanceVerificationOfficer addNewUser(@RequestBody  @Valid FinanceVerificationOfficer financeVerificationOfficer) {
		this.userService.addNewUser(financeVerificationOfficer);
		return financeVerificationOfficer;
		
	}
	
	@ApiOperation(value = "POST mapping to add new user to the LOAN_USER table in the Database", response = User.class)
	@PostMapping("/signin")
	public User signIn(@RequestBody  @Valid User user) {
		this.userService.signIn(user);
		return user;
		
	}

	@ApiOperation(value = "POST mapping to logout from the LOAN_USER table in the Database", response = User.class)
	@PostMapping("/signout")
	public User signOut(@RequestBody  @Valid User user) {
		this.userService.signOut(user);
		return user;
		
	}
}
