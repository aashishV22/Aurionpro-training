package com.aurionpro.model;

public abstract class Account
{
	private int id;
	private String name;
	protected int balance;
	private int amount;
	private boolean isTrue;
	public Account(int id, String name, int balance) 
		{
			super();
			this.id = id;
			this.name = name;
			this.balance = balance;
		}
	public Account() 
		{
		super();
		}
	
	public int getAmount() 
		{
			return amount;
		}

	public void setAmount(int amount) 
		{
			this.amount = amount;
		}

	public int getId() 
		{
			return id;
		}
	public void setId(int id) 
		{
			this.id = id;
		}
	public String getName() 
		{
			return name;
		}
	public void setName(String name) 
		{
			this.name = name;
		}
	public int getBalance() 
		{
			return balance;
		}
	public void setBalance(int balance) 
		{
			this.balance = balance;
		}
	
	public abstract boolean withdrawl(int amount,Account user1); 
//		{
//			if(amount<balance) 
//			{
//				balance-=amount;
//				return true;
//			}
//			return false;
//		}
//	
	
	
}
