package com.omvg.springboot.CompaniaABC1.Exceptions;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException (String message) {
		super(message);
	}
}
