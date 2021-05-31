package com.ja5g4.homeloan.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "EMI Bean Class")
public class EMI  {

	
	
	@ApiModelProperty(name = "EMI ID", value = "holding EMI ID", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long EMIId;
	
	@ApiModelProperty(name = "Due Date", value = "It holds the Due Date", required = true)
	@NotEmpty(message = "Due Date can't be empty!")
	@Pattern(regexp="^\\\\d{4}-\\\\d{2}-\\\\d{2}$",message = "INVALID Due Date ENTER AGAIN")
	private LocalDate dueDate;
	
	@ApiModelProperty(name = "EMI Amount", value = "It holds the EMI Amount", required = true)
	@NotEmpty(message = "EMI Amount can't be empty!")
	@Size(min = 3, max = 7,message = "INVALID EMI Amount ENTER AGAIN")
	private double emiAmount ;
	
	@ApiModelProperty(name = "Loan Amount", value = "It holds the Loan Amount", required = true)
	@NotEmpty(message = "Loan Amount can't be empty!")
	@Size(min = 3, max = 7,message = "INVALID Loan Amount ENTER AGAIN")
	private double loanAmount ;
	
	@ApiModelProperty(name = "Interest Amount", value = "It holds the Interest Amount", required = true)
	private double interestAmount ;
	

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
	public String toString() {
		return "EMI [EMIId=" + EMIId + ", dueDate=" + dueDate + ", emiAmount=" + emiAmount + ", loanAmount="
				+ loanAmount + ", interestAmount=" + interestAmount + "]";
	}
	
}
