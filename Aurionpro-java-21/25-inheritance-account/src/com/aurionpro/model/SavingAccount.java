package com.aurionpro.model;

public class SavingAccount extends Account {
	private static final int MIN_BALANCE=1000;
	
	public SavingAccount(int id, String name, int balance) {
		// TODO Auto-generated constructor stub
		super(id,name,balance);
	}
	
	public SavingAccount() {
		
	}
	
	@Override
	public boolean withdrawl(int amount, Account user1) {
		if(amount-this.getBalance()<MIN_BALANCE) 
		{
			amount = this.getBalance()-amount;	
			this.setBalance(amount);
			System.out.println(this.getBalance());
			return true;
		}
		return false;
	}
	
	

	

	
}
