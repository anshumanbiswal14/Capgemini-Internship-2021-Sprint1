package com.ja5g4.homeloan.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

@Entity

public class LoanApplication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(name = "Loan application ID", value = "It holds the loan application ID", required = true)
	private long applicationId;
	
	@Column
	@ApiModelProperty(name = "Loan application date", value = "It holds the loan application date", required = true)
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate applicationDate;
	
	@OneToOne
	@JoinColumn(name = "user_Info", referencedColumnName = "userId")
	@ApiModelProperty(name = "Customer", value = "It holds the customer information", required = true)
	private Customer customer;
	
	@Column
	@ApiModelProperty(name = "Loan applied amount", value = "It holds the loan applied amount", required = true)
	@DecimalMin(value = "0", message = "Loan applied amount should not be less than thousand values")
	private double loanAppliedAmount;
	
	@Column	
	@ApiModelProperty(name = "Loan approved amount", value = "It holds the loan approved amount", required = true)
	@DecimalMin(value = "0", message = "Loan approved amount should not be less than thousand values")
	private double loanApprovedAmount;
	
	@Column
	@ApiModelProperty(name = "Land verification approval status", value = "It holds the land verification approval status", required = true)
	private boolean landVerificationApproval;
	
	@Column
	@ApiModelProperty(name = "Finance verification approval status", value = "It holds the finance verification approval status", required = true)
	private boolean financeVerificationApproval;
	
	@Column
	@ApiModelProperty(name = "Admin approval status", value = "It holds the admin approval status", required = true)
	private boolean adminApproval;
	
	@Column
	@Enumerated(EnumType.STRING)
	@ApiModelProperty(name = "Status", value = "It holds the status", required = true)
	private Status status;
	
	public LoanApplication() {
		super();
		
	}
	
	public LoanApplication(long applicationId, LocalDate applicationDate, Customer customer, double loanAppliedAmount,
			double loanApprovedAmount, boolean landVerificationApproval, boolean financeVerificationApproval,
			boolean adminApproval, Status status) {
		super();
		this.applicationId = applicationId;
		this.applicationDate = applicationDate;
		this.customer = customer;
		this.loanAppliedAmount = loanAppliedAmount;
		this.loanApprovedAmount = loanApprovedAmount;
		this.landVerificationApproval = landVerificationApproval;
		this.financeVerificationApproval = financeVerificationApproval;
		this.adminApproval = adminApproval;
		this.status = status;
	}
	
	
	public LoanApplication(long applicationId, Status status) {
		super();
		this.applicationId = applicationId;
		this.status = status;
	}

	public long getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}
	public LocalDate getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public double getLoanAppliedAmount() {
		return loanAppliedAmount;
	}
	public void setLoanAppliedAmount(double loanAppliedAmount) {
		this.loanAppliedAmount = loanAppliedAmount;
	}
	public double getLoanApprovedAmount() {
		return loanApprovedAmount;
	}
	public void setLoanApprovedAmount(double loanApprovedAmount) {
		this.loanApprovedAmount = loanApprovedAmount;
	}
	public boolean isLandVerificationApproval() {
		return landVerificationApproval;
	}
	public void setLandVerificationApproval(boolean landVerificationApproval) {
		this.landVerificationApproval = landVerificationApproval;
	}
	public boolean isFinanceVerificationApproval() {
		return financeVerificationApproval;
	}
	public void setFinanceVerificationApproval(boolean financeVerificationApproval) {
		this.financeVerificationApproval = financeVerificationApproval;
	}
	public boolean isAdminApproval() {
		return adminApproval;
	}
	public void setAdminApproval(boolean adminApproval) {
		this.adminApproval = adminApproval;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (applicationId ^ (applicationId >>> 32));
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
		LoanApplication other = (LoanApplication) obj;
		if (applicationId != other.applicationId)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "LoanApplication [applicationId=" + applicationId + ", applicationDate=" + applicationDate
				+ ", customer=" + customer + ", loanAppliedAmount=" + loanAppliedAmount + ", loanApprovedAmount="
				+ loanApprovedAmount + ", landVerificationApproval=" + landVerificationApproval
				+ ", financeVerificationApproval=" + financeVerificationApproval + ", adminApproval=" + adminApproval
				+ ", status=" + status + "]";
	}
	
}
