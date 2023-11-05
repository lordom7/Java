package com.omvg.springboot.CompaniaABC1.Exceptions;

public class UserAlreadyExistsException extends RuntimeException{
	
	public UserAlreadyExistsException(String message) {
		super(message);
	}
		
}
