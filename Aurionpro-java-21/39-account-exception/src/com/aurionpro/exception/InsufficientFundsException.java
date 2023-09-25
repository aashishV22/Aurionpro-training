package com.aurionpro.exception;

public class InsufficientFundsException extends RuntimeException{
	String message;
	public InsufficientFundsException(String message) {
		super(message);
		this.message=message;
	}
	private static final long serialVersionUID = 1L;
	@Override
	public String getMessage() {
		return this.getClass().getSimpleName()+" " +super.getMessage();
		}
}
