package com.ja5g4.homeloan.util;

public class HomeLoanBorrowingAmountCalculator extends EmiCalculator {
	
	private double totalAnnualIncome;
	private double monthlyExpenses;
	private int otherMonthlyIncome;


public double getHomeLoanBorrowingAmount() {
	return 0;
}

public HomeLoanBorrowingAmountCalculator() {
	super();
	
}


public HomeLoanBorrowingAmountCalculator(double loanAmount, double rateOfInterest, int tenure) {
	super(loanAmount, rateOfInterest, tenure);
	
}


public double getTotalAnnualIncome() {
	return totalAnnualIncome;
}


public void setTotalAnnualIncome(double totalAnnualIncome) {
	this.totalAnnualIncome = totalAnnualIncome;
}


public double getMonthlyExpenses() {
	return monthlyExpenses;
}


public void setMonthlyExpenses(double monthlyExpenses) {
	this.monthlyExpenses = monthlyExpenses;
}


public int getOtherMonthlyIncome() {
	return otherMonthlyIncome;
}


public void setOtherMonthlyIncome(int otherMonthlyIncome) {
	this.otherMonthlyIncome = otherMonthlyIncome;
}


@Override
public String toString() {
	return "HomeLoanBorrowingAmountCalculator [totalAnnualIncome=" + totalAnnualIncome + ", monthlyExpenses="
			+ monthlyExpenses + ", otherMonthlyIncome=" + otherMonthlyIncome + "]";
}

}
