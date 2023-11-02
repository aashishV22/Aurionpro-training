package com.aurionpro.exception;

public class StudentExceptionResponse 
{
	private int status;
	private String message;
	private long timeStamp;

	public StudentExceptionResponse() 		{		super();		}
	public StudentExceptionResponse(int status, String message, long timeStamp) 
	{
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	
	public int    getStatus() 					{	return status;		}
	public String getMessage() 					{	return message;		}
	public long   getTimeStamp() 				{	return timeStamp;	}

	public void setStatus(int status) 			{	this.status = status;		}
	public void setMessage(String message) 		{	this.message = message;		}
	public void setTimeStamp(long timeStamp) 	{	this.timeStamp = timeStamp;	}
	
	@Override
	public String toString() 
	{
		return "StudentExceptionResponse [status=" + status + ", message=" + message + ", timeStamp=" + timeStamp + "]";
	}
}
