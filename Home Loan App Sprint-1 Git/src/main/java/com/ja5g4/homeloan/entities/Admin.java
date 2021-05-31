package com.ja5g4.homeloan.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@DiscriminatorValue(value = "2")
@ApiModel(value = "Admin Bean Class")
public class Admin extends User {

	
	@ApiModelProperty(name = "Admin Name", value = "It holds only alphabets and accepts minimum 3 Chars", required = true)
	@NotEmpty(message = "Admin Name can't be empty!")
	@Size(min = 3, max = 25, message = "Invalid Admin Name please enter a vaild Admin Name!")	
	@Pattern(regexp = "^[a-zA-Z]*$",message = "Accepts only alphabets! re-enter the admin name")
	private String adminName;

	@ApiModelProperty(name = "Phone Number", value = "It holds phone number only 10 digits allowed", required = true)
	@NotEmpty(message = "Phone Number can't be empty!")
	@Size(min = 10, max = 10, message = "Invalid Phone Number please enter a vaild phone number minimum of 10 digits")
	@Pattern(regexp ="^\\d{10}$",message="Invalid input:Enter numbers only")
	private String adminContact;

public Admin() {
	super();
	
}

public Admin(int userId, String password, String role) {
	super(userId, password, role);
	
}

public Admin(int userId) {
	super(userId);
	
}


public Admin(int userId, String password, String role, String adminName, String adminContact) {
	super(userId, password, role);
	this.adminName = adminName;
	this.adminContact = adminContact;
}

public String getAdminName() {
	return adminName;
}

public void setAdminName(String adminName) {
	this.adminName = adminName;
}

public String getAdminContact() {
	return adminContact;
}

public void setAdminContact(String adminContact) {
	this.adminContact = adminContact;
}

@Override
public String toString() {
	return "Admin [adminName=" + adminName + ", adminContact=" + adminContact + "]";
}


}
