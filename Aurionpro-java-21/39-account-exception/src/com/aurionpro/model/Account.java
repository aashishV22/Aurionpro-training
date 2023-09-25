package com.aurionpro.model;

public class Account {
	private int accountNumber;
	private String name;
	private double balance;
	private int depositAmount;
	private double withdrawAmount;
	public Account(int accountNumber, String name, int balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setDeposit(int depositAmount) {
		this.depositAmount=depositAmount;
	}
	public void setWithdraw(double withdrawlAmount) {
		this.withdrawAmount=withdrawAmount;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance
				+ ", depositAmount=" + depositAmount + ", withdrawAmount=" + withdrawAmount + "]";
	}
	
	
	
}
