package com.ja5g4.homeloan.entities;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public enum Status {
	
	@Enumerated(EnumType.STRING)
	PENDING,
	
	@Enumerated(EnumType.STRING)
	APPROVED,
	
	@Enumerated(EnumType.STRING)
	WAITING_FOR_FINANCE_APPROVAL,
	
	@Enumerated(EnumType.STRING)
	WAITING_FOR_LAND_VERIFICATION_OFFICE_APPROVAL,
	
	@Enumerated(EnumType.STRING)
	REJECTED,
	
	@Enumerated(EnumType.STRING)
	DOCUMENTS_NOT_UPLOADED,
	
	@Enumerated(EnumType.STRING)
	DOCUMENTS_UPLOADED


}
