package com.aurionpro.model;

public class WhatsAppNotifier implements INotifier
{
	public void notifyUser(Account account, double amount,TansactionType type) {
	System.out.println("Email Notification\n"+type+" of "+amount+"\nAccount Details:- "+account);
	}

}
