package com.aurionpro.model;

public class Account {
	private int accountID;
	private String accountHolder;
	private Gender gender;
	private AccountType accountType;
	private double balance;
	public Account(int accountID, String accountHolder, Gender gender, AccountType accountType,double balance) {
		super();
		this.accountID = accountID;
		this.accountHolder = accountHolder;
		this.gender = gender;
		this.accountType = accountType;
		this.balance=balance;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public String getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", accountHolder=" + accountHolder + ", gender=" + gender
				+ ", accountType=" + accountType + ", balance=" + balance + "]";
	}
	
	
	
	
}
