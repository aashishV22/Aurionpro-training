package com.aurionpro.model;

public class Account {
	private int accountId;
//	private int ids;
	private String holderName;

	private double balanceAmount;
	//private String[] accountType = new String[45];

	private AccountType accountType;
	private static int count;
	
	
	public Account(int accountId, String holderName, double balanceAmount, AccountType accountType) {
		super();
		this.accountId = accountId;
		this.holderName = holderName;
		this.balanceAmount = balanceAmount;
		this.accountType = accountType;
		this.count=count;
	}
	
	

	public void setAccountId(int id) {
		this.accountId=id;
		
	}
	
	public static int getCount() {
		return count;
	}
	public int getAccountId() {
		return accountId;
	}
	
	public void setAccountType(AccountType type) {
		this.accountType = type;
	}

	public void setName(String name) {
		this.holderName = name;
	}

	public void setBalance(double balance) {
		this.balanceAmount=balance;
	}
	public double getBalance() {
		return balanceAmount;
	}

	public AccountType getAccountType() {
		return this.accountType;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ",  holderName=" + holderName + ", balanceAmount="
				+ balanceAmount + ", accountType=" + accountType + "]";
	}
	
}
