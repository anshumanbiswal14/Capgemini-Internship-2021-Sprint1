package com.ja5g4.homeloan.exception;

public class InvalidLoanAgreementException extends Exception {

	/**
	 * 
	 */
	public InvalidLoanAgreementException() {
		super();

	}

	public InvalidLoanAgreementException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidLoanAgreementException(String message, Throwable cause) {
		super(message, cause);

	}

	/**
	 * @param message
	 */
	public InvalidLoanAgreementException(String message) {
		super(message);

	}

	/**
	 * @param cause
	 */
	public InvalidLoanAgreementException(Throwable cause) {
		super(cause);

	}

}
