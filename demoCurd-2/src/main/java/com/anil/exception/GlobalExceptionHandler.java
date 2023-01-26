package com.anil.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(userNotFoundException.class)
	public ResponseEntity<?> userNotFoundException (userNotFoundException ex,WebRequest request) {
		Errordetails errordetails = new Errordetails(new Date(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<>(errordetails,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(emailIsAlreadyExist.class)
	public ResponseEntity<?> AlreadyFoundException (emailIsAlreadyExist ex,WebRequest request) {
		Errordetails errordetails = new Errordetails(new Date(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<>(errordetails,HttpStatus.ALREADY_REPORTED);
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> Exception (Exception ex,WebRequest request) {
		Errordetails errordetails = new Errordetails(new Date(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<>(errordetails,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
