package com.first.ramSirRstApi.exception;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = ResourceNotFoundException.class)
	public ResponseEntity< CustomExceptionResponse>resourceNotFoundException(ResourceNotFoundException me,WebRequest we) {
		
		CustomExceptionResponse response= new CustomExceptionResponse();
		//response.setDate();
		response.setPath(we.getContextPath());
		//response.setDescription(null);
		return null;
	}
}
