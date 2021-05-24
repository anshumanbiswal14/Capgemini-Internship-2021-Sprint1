package com.ja5g4.homeloan.entities;

public class LandVerificationOfficer extends User {
	
	
	private String officerName;
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
