package com.epam.javatask3;

@SuppressWarnings("serial")
public class UserException extends Exception {

	String message;

	public UserException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
