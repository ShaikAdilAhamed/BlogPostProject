package com.first.ramSirRstApi.exception;

import java.util.Date;

import lombok.Data;

@Data
public class CustomExceptionResponse {

	private Date date;
	private String path;
	private String description;
	
	
}
