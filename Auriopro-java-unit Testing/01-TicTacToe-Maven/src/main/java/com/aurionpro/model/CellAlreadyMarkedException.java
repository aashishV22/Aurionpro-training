package com.aurionpro.model;

public class CellAlreadyMarkedException extends Exception 
{
	String message;
	public CellAlreadyMarkedException(String message) 
	{
		super(message);
		this.message=message;
	}
	private static final long serialVersionUID = 1L;
	@Override
	public String getMessage() 
	{
		return this.getClass().getSimpleName()+" " +super.getMessage();
	}
	@Override
	public String toString() 
	{
		return "Cell Already Marked Exception [message=" + message + "]";
	}
}