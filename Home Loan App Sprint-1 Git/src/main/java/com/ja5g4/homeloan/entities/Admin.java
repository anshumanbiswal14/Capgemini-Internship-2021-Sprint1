package com.ja5g4.homeloan.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "2")
public class Admin extends User {

private String adminName;
private String adminContact;

public Admin() {
	super();
	// TODO Auto-generated constructor stub
}

public Admin(int userId, String password, String role) {
	super(userId, password, role);
	// TODO Auto-generated constructor stub
}

public Admin(int userId) {
	super(userId);
	// TODO Auto-generated constructor stub
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
