package com.reallabs.eams.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.reallabs.eams.model.CustomerErrorResponse;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<CustomerErrorResponse> customHandleNotFound(Exception ex,WebRequest request) {
		CustomerErrorResponse cer = new CustomerErrorResponse();
		cer.setError(ex.getLocalizedMessage());
		cer.setTimeStamp(LocalDateTime.now());
		cer.setStatus(HttpStatus.NOT_FOUND.value());
		
		
		return new ResponseEntity<>(cer,HttpStatus.NOT_FOUND);
	}
}
