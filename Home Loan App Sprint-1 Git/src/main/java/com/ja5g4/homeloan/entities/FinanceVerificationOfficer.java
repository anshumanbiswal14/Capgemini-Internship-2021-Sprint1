package com.ja5g4.homeloan.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "4")
public class FinanceVerificationOfficer extends User {

	
	private String finOfficerName;
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
