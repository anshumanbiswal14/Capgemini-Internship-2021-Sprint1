package com.ja5g4.homeloan.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request){
				
		Map<String, String> map = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError)error).getField();
			String msg = error.getDefaultMessage();
			
			map.put(fieldName, msg);
		});
		
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(AdminApprovalException.class)
	public ResponseEntity<String> handleAdminApprovalException(AdminApprovalException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Trying to get Admin Approval");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
		
	}
	
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> handleCustomerException(CustomerNotFoundException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Trying to get a customer");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
		
	}
	
	
	@ExceptionHandler(FinanceVerificationException.class)
	public ResponseEntity<String> handleFinanceException(FinanceVerificationException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Trying to get a Finance Verification Officer");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
		
	}
	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<String> handleInvalidCredentialException(InvalidCredentialException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Trying to get Credentials");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
		
	}
	@ExceptionHandler(InvalidLoanApplicationException.class)
	public ResponseEntity<String> handleInvalidLoanApplicationException(InvalidLoanApplicationException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Trying to get Loan Application");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
		
	}
	@ExceptionHandler(InvalidLoanAgreementException.class)
	public ResponseEntity<String> handleInvalidLoanAgrementException(InvalidLoanAgreementException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Trying to get Loan Agreement");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
		
	}

	@ExceptionHandler(LandVerificationException.class)
	public ResponseEntity<String> handleLandException(LandVerificationException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Trying to get a Land Verification Officer");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).build();
		
	}
	

}
