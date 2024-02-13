package com.hexa.CareerPortal.exception;

//@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class NameAlreadyExistException extends Exception {
	public NameAlreadyExistException(String message)
	{
		super(message);
	}

}
