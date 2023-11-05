package com.omvg.springboot.CompaniaABC1.Exceptions;

public class IncorrectPasswordException extends RuntimeException{
	
	public IncorrectPasswordException(String message) {
		super(message);
	}
}
