package com.first.ramSirRstApi.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = ResourceNotFoundException.class)
	public ResponseEntity< CustomExceptionResponse>resourceNotFoundException(ResourceNotFoundException me,WebRequest we) {
		
		CustomExceptionResponse response= new CustomExceptionResponse();
		response.setDate(new Date());
		response.setDetails(we.getDescription(false));
		response.setMessage(me.getMessage());
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(exception = BlogAPIException.class)
	public ResponseEntity< CustomExceptionResponse>resourceNotFoundException(BlogAPIException exception,WebRequest we) {
		
		CustomExceptionResponse errorDetails= new CustomExceptionResponse();
		errorDetails.setDate(new Date());
		errorDetails.setDetails(we.getDescription(false));
		errorDetails.setMessage(exception.getMessage());
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(exception = Exception.class)
	public ResponseEntity< CustomExceptionResponse>resourceNotFoundException(Exception exception,WebRequest we) {
		
		CustomExceptionResponse errorDetails= new CustomExceptionResponse();
		errorDetails.setDate(new Date());
		errorDetails.setDetails(we.getDescription(false));
		errorDetails.setMessage(exception.getMessage());
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
