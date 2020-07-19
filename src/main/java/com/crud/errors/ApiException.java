package com.crud.errors;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiException {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private int status;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private String message;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private String debugMessage;
	
	
	private ApiException() { timestamp = LocalDateTime.now(); }
	
	public ApiException(int status){
		this();
		this.status = status;
	}
	
	public ApiException(int status, Throwable ex){
		this();
		this.status = status;
		this.message = "Unexpected error";
		this.debugMessage = ex.getLocalizedMessage();
	}
	
	public ApiException(int status, String message, Throwable ex){
		this();
		this.status = status;
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}
}
