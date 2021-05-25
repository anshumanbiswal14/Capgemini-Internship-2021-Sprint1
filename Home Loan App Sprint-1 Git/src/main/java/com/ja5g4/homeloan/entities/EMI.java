package com.ja5g4.homeloan.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EMI {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long EMIId;
	@Column
	private LocalDate dueDate;
	@Column
	private double emiAmount;
	@Column
	private double loanAmount;
	@Column
	private double interestAmount;
	
	
	public EMI() {
		
		super();	
	}
	
	public EMI(long eMIId, LocalDate dueDate, double emiAmount, double loanAmount, double interestAmount) {
		super();
		EMIId = eMIId;
		this.dueDate = dueDate;
		this.emiAmount = emiAmount;
		this.loanAmount = loanAmount;
		this.interestAmount = interestAmount;
	}
	public long getEMIId() {
		return EMIId;
	}
	public void setEMIId(long eMIId) {
		EMIId = eMIId;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public double getEmiAmount() {
		return emiAmount;
	}
	public void setEmiAmount(double emiAmount) {
		this.emiAmount = emiAmount;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public double getInterestAmount() {
		return interestAmount;
	}
	public void setInterestAmount(double interestAmount) {
		this.interestAmount = interestAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (EMIId ^ (EMIId >>> 32));
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
		EMI other = (EMI) obj;
		if (EMIId != other.EMIId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EMI [EMIId=" + EMIId + ", dueDate=" + dueDate + ", emiAmount=" + emiAmount + ", loanAmount="
				+ loanAmount + ", interestAmount=" + interestAmount + "]";
	}
	
}
