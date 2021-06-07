package com.ja5g4.homeloan.util;

public class EmiCalculator {
	
	private double loanAmount;
	private double rateOfInterest;
	private int tenure;
	
	
	public double getEMIAmount() {
		return (loanAmount+(loanAmount*rateOfInterest))/(tenure);
	}

	public EmiCalculator() {
		super();
		
	}

	public EmiCalculator(double loanAmount, double rateOfInterest, int tenure) {
		super();
		this.loanAmount = loanAmount;
		this.rateOfInterest = rateOfInterest;
		this.tenure = tenure;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	@Override
	public String toString() {
		return "EmiCalculator [loanAmount=" + loanAmount + ", rateOfInterest=" + rateOfInterest + ", tenure=" + tenure
				+ "]";
	}

}