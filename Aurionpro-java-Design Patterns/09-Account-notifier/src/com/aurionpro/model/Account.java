package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;

public class Account 
{
	private int accountNumber;
	private String name;
	private double balance;
	private List<INotifier> notifiers;
	public Account(int accountNumber, String name, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		this.notifiers = new ArrayList<INotifier>();
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
	public List<INotifier> getNotifiers() {
		return notifiers;
	}
	public void setNotifiers(List<INotifier> notifiers) {
		this.notifiers = notifiers;
	}
	
	public void deposit(double amount) {
		this.setBalance(this.getBalance()+amount);
		for(INotifier x:notifiers) {
			x.notifyUser(this,amount,TansactionType.DEPOSIT );
		}
	}
	public void withdraw(double amount) {
		if((this.getBalance()-amount)>0) {
			this.setBalance(this.getBalance()-amount);
			for(INotifier x:notifiers) {
				x.notifyUser(this,amount,TansactionType.WITHDRAW);
			}
		}
		else {
			System.out.println("Insufficient balance");
		}
	}
	
	public void registerNotifier(INotifier notifier) {
		this.notifiers.add(notifier);
	}
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "[accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + "]";
	}




	
}
