package com.aurionpro.model;

import java.util.Date;

public class Transaction 
{
	private int transaction_id;
	private int account_no_sender;
	private int account_no_receiver;
	private int transaction_typeID;
	private Date transaction_time;
	private int transaction_amount;
	private String transactionType; 
	
	public Transaction(int transaction_id, int account_no_sender, int account_no_receiver, int transaction_typeID,int transaction_amount) {
		super();
		this.transaction_id = transaction_id;
		this.account_no_sender = account_no_sender;
		this.account_no_receiver = account_no_receiver;
		this.transaction_typeID = transaction_typeID;
		this.transaction_amount= transaction_amount;
	}
	public Transaction(int account_no_sender, int account_no_receiver, int transaction_typeID,int transaction_amount) {
		this.account_no_sender = account_no_sender;
		this.account_no_receiver = account_no_receiver;
		this.transaction_typeID = transaction_typeID;
		this.transaction_amount= transaction_amount;

	}
	
	
	
	public Transaction(int transaction_id, int account_no_sender, int account_no_receiver, int transaction_typeID,
			Date transaction_time, int transaction_amount, String transactionType) {
		this.transaction_id = transaction_id;
		this.account_no_sender = account_no_sender;
		this.account_no_receiver = account_no_receiver;
		this.transaction_typeID = transaction_typeID;
		this.transaction_time = transaction_time;
		this.transaction_amount = transaction_amount;
		this.transactionType=transactionType;
	}
	
	
	
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Date getTransaction_time() {
		return transaction_time;
	}
	public void setTransaction_time(Date transaction_time) {
		this.transaction_time = transaction_time;
	}
	public int getTransaction_amount() {
		return transaction_amount;
	}
	public void setTransaction_amount(int transaction_amount) {
		this.transaction_amount = transaction_amount;
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public int getAccount_no_sender() {
		return account_no_sender;
	}
	public void setAccount_no_sender(int account_no_sender) {
		this.account_no_sender = account_no_sender;
	}
	public int getAccount_no_receiver() {
		return account_no_receiver;
	}
	public void setAccount_no_receiver(int account_no_receiver) {
		this.account_no_receiver = account_no_receiver;
	}
	public int getTransaction_typeID() {
		return transaction_typeID;
	}
	public void setTransaction_typeID(int transaction_typeID) {
		this.transaction_typeID = transaction_typeID;
	}
	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transaction_id + ", account_no_sender=" + account_no_sender
				+ ", account_no_receiver=" + account_no_receiver + ", transaction_typeID=" + transaction_typeID
				+ ", transaction_time=" + transaction_time + ", transaction_amount=" + transaction_amount + "]";
	}
	
	
	
}
