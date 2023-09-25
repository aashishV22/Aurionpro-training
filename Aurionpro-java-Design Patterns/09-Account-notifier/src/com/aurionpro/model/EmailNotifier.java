package com.aurionpro.model;

public class EmailNotifier implements INotifier
{
	@Override
	public void notifyUser(Account account, double amount,TansactionType type) {
		System.out.println("Email Notification\n"+type+" of "+amount+"\nAccount Details:- "+account);
	}

}
