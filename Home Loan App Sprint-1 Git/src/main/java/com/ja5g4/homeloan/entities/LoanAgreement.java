package com.ja5g4.homeloan.entities;

import java.util.Set;

public class LoanAgreement {
	private long loanAgreementId;
	private long loanApplicationId;
	private Set<EMI> allemis;
	
	public LoanAgreement() {
		super();
		
	}
	
	public LoanAgreement(long loanAgreementId, long loanApplicationId, Set<EMI> allemis) {
		super();
		this.loanAgreementId = loanAgreementId;
		this.loanApplicationId = loanApplicationId;
		this.allemis = allemis;
	}
	
	public LoanAgreement(long loanAgreementId, long loanApplicationId) {
		super();
		this.loanAgreementId = loanAgreementId;
		this.loanApplicationId = loanApplicationId;
	}
	public long getLoanAgreementId() {
		return loanAgreementId;
	}
	public void setLoanAgreementId(long loanAgreementId) {
		this.loanAgreementId = loanAgreementId;
	}
	public long getLoanApplicationId() {
		return loanApplicationId;
	}
	public void setLoanApplicationId(long loanApplicationId) {
		this.loanApplicationId = loanApplicationId;
	}
	public Set<EMI> getAllemis() {
		return allemis;
	}
	public void setAllemis(Set<EMI> allemis) {
		this.allemis = allemis;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (loanAgreementId ^ (loanAgreementId >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanAgreement other = (LoanAgreement) obj;
		if (loanAgreementId != other.loanAgreementId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LoanAgreement [loanAgreementId=" + loanAgreementId + ", loanApplicationId=" + loanApplicationId
				+ ", allemis=" + allemis + "]";
	}

}
