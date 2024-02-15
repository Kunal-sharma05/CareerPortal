package com.hexa.CareerPortal.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	public ErrorDetails(LocalDateTime timeStamp, String message, String errorCode) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.errorCode = errorCode;
	}
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
	
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}

	public String getErrorCode() {
		return errorCode;
	}
	@Override
	public String toString() {
		return "ErrorDetails [timeStamp=" + timeStamp + ", message=" + message + ", path=" + path + ", errorCode="
				+ errorCode + "]";
	}
	
}
