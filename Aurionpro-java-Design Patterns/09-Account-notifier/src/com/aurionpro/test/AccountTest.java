package com.aurionpro.test;

import com.aurionpro.model.*;

public class AccountTest 
{
	public static void main(String[] args) {
		Account account1=new Account(2322,"Asshish",2323);
		account1.registerNotifier(new SmsNotifier());
		account1.registerNotifier(new EmailNotifier());
		account1.withdraw(323);
		account1.deposit(1);

	}
}
