package com.ja5g4.homeloan.entities;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class LoanAgreement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long loanAgreementId;
	@Column
	private long loanApplicationId;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "LOAN_EMI", joinColumns = @JoinColumn(name = "loanAgreementId" ),
	inverseJoinColumns = @JoinColumn(name = "EMIId"))
	private Set<EMI> allemis = new HashSet<>();
	
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
