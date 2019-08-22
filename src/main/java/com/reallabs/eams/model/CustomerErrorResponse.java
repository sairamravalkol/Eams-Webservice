package com.reallabs.eams.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomerErrorResponse {
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern ="yyyy-MM-dd hh:mm:ss")
	private LocalDateTime timeStamp;
	private int status;
	private String error;
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	

}
