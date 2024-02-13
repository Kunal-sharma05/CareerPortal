package com.hexa.CareerPortal.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	private LocalDateTime timeStamp;
	private String message;
	private String path;
	private String errorCode;
	public ErrorDetails(LocalDateTime t, String m, String path, String errorCode) {
		super();
		this.timeStamp = t;
		this.message = m;
		this.path = path;
		this.errorCode = errorCode;
	}
	public ErrorDetails() {
		super();
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setT(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setM(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	@Override
	public String toString() {
		return "ErrorDetails [timeStamp=" + timeStamp + ", message=" + message + ", path=" + path + ", errorCode="
				+ errorCode + "]";
	}
	
}
