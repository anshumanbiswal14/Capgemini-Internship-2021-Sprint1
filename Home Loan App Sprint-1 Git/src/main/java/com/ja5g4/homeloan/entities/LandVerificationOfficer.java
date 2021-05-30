package com.ja5g4.homeloan.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@DiscriminatorValue(value = "5")
@ApiModel(value="Land Verification Officer Bean Class")
public class LandVerificationOfficer extends User {
	
	@ApiModelProperty(name="Land Verification Officer Name",value="It holds only alphabets",required=true)
	@NotEmpty(message = "Land Verification Officer Name can't be empty!")
	@Size(min = 3, max = 25, message = "Invalid Land Verification Officer Name please enter a vaild Name!")
	@Pattern(regexp="^[A-Za-z]+",message = "INVALID PLEASE ENTER AGAIN")	
	private String officerName;
	
	@ApiModelProperty(name = "Land Verification Officer Mobile Number", value = "It holds Land verification officer phone number", required = true)	
	@NotEmpty(message = "Phone Number can't be empty!")
	@Size(min = 10, max = 10, message = "Invalid Phone Number please enter a vaild phone number of minimum 10 digits")
	@Pattern(regexp ="^\\d{10}$",message="Invalid input:Enter numbers only")
	private String officerContact;
	
	public LandVerificationOfficer() {
		super();
		
	}
	
	public LandVerificationOfficer(int userId, String password, String role) {
		super(userId, password, role);
		
	}
	
	public LandVerificationOfficer(int userId) {
		super(userId);
		
	}
	
	public LandVerificationOfficer(int userId, String password, String role, String officerName,
			String officerContact) {
		super(userId, password, role);
		this.officerName = officerName;
		this.officerContact = officerContact;
	}
	
	public String getOfficerName() {
		return officerName;
	}
	public void setOfficerName(String officerName) {
		this.officerName = officerName;
	}
	public String getOfficerContact() {
		return officerContact;
	}
	public void setOfficerContact(String officerContact) {
		this.officerContact = officerContact;
	}
	
	@Override
	public String toString() {
		return "LandVerificationOfficer [officerName=" + officerName + ", officerContact=" + officerContact + "]";
	}

}
