package com.ja5g4.homeloan.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value="Finance Verification Officer Bean Class")
@DiscriminatorValue(value = "4")
public class FinanceVerificationOfficer extends User {

	@ApiModelProperty(name="Finance Verification Officer Name",value="It holds only alphabets",required=true)
	@NotEmpty(message = "Finance Verification Officer Name can't be empty!")
	@Size(min = 3, max = 25, message = "Invalid Finance Verification Officer Name please enter a vaild Name!")
	@Pattern(regexp="^[A-Za-z]+",message = "INVALID PLEASE ENTER AGAIN")	
	private String finOfficerName;
	
	@ApiModelProperty(name = "Finance Verification Officer Mobile Number", value = "It holds finance verification officer phone number", required = true)	
	@NotEmpty(message = "Phone Number can't be empty!")
	@Size(min = 10, max = 10, message = "Invalid Phone Number please enter a vaild phone number of minimum 10 digits")
	@Pattern(regexp ="^\\d{10}$",message="Invalid input:Enter numbers only")
	private String finOfficerContact;
	
	public FinanceVerificationOfficer() {
		super();
		
	}
	
	public FinanceVerificationOfficer(int userId, String password, String role) {
		super(userId, password, role);
		
	}
	
	public FinanceVerificationOfficer(int userId) {
		super(userId);
		
	}

	public FinanceVerificationOfficer(String finOfficerName, String finOfficerContact) {
		super();
		this.finOfficerName = finOfficerName;
		this.finOfficerContact = finOfficerContact;
	}

	public String getFinOfficerName() {
		return finOfficerName;
	}

	public void setFinOfficerName(String finOfficerName) {
		this.finOfficerName = finOfficerName;
	}

	public String getFinOfficerContact() {
		return finOfficerContact;
	}

	public void setFinOfficerContact(String finOfficerContact) {
		this.finOfficerContact = finOfficerContact;
	}

	@Override
	public String toString() {
		return "FinanceVerificationOfficer [finOfficerName=" + finOfficerName + ", finOfficerContact="
				+ finOfficerContact + "]";
	}
	

}
