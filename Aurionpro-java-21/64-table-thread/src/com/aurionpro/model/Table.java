package com.aurionpro.model;

public class Table extends Thread
{
	int number;
	

	public int getNumber(int number) {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public Table(int number) {
		super();
		this.number = number;
	}


	@Override
	public  void run() 
	{
		synchronized(this) {
		
		for(int i=1;i<=10;i++) 
		{
			try 
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) 			{			e.printStackTrace();		}
			System.out.println(number+"*"+i+"="+number*i);
		}
		}}
	
}
