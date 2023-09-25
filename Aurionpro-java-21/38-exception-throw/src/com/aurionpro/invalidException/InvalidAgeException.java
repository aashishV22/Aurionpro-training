package com.aurionpro.invalidException;

public class InvalidAgeException extends Exception 
{
	String message;
	public InvalidAgeException(String message) {
		super(message);
		this.message=message;
	}
	private static final long serialVersionUID = 1L;
@Override
public String getMessage() {
	return this.getClass().getSimpleName()+" " +super.getMessage();
	}
@Override
public String toString() {
	return "InvalidAgeException [message=" + message + "]";
}
	
}
