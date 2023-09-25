package com.aurionpro.model;

public class Account{
	private int id;
	private String holderName;
	private double balanceAmmount;
	private AccountType accountType;
	public Account(int id, String holderName, double balanceAmmount, AccountType accountType) {
		super();
		this.id = id;
		this.holderName = holderName;
		this.balanceAmmount = balanceAmmount;
		this.accountType = accountType;
	}
	public void setBalance(double balanceAmmount){
		this.balanceAmmount=balanceAmmount;
	}
	public double getBalance() 
		{
			return this.balanceAmmount;
		}
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", holderName=" + holderName + ", balanceAmmount=" + balanceAmmount
				+ ", accountType=" + accountType + "]";
	}
	
	

}
