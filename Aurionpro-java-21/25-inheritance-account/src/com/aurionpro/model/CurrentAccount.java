package com.aurionpro.model;

public class CurrentAccount extends Account 
{
private static final int MIN_BALANCE=-25000;
	
	public CurrentAccount(int id, String name, int balance) {
		// TODO Auto-generated constructor stub
		super(id,name,balance);
	}


	public boolean withdrawl(int amount, Account user2) {
		if(amount-this.getBalance()>MIN_BALANCE) 
		{
			amount = balance-amount;	
			this.setBalance(amount);
			System.out.println("\n Balance of current account"+this.getBalance());
			return true;
		}
		return false;
	}
}
