package com.aurionpro.test;
import java.util.Scanner;
import com.aurionpro.model.CurrentAccount;
import com.aurionpro.model.Account;
import com.aurionpro.model.SavingAccount;

public class AccountTest 
{
	public static void main(String[] args) 
	{
		SavingAccount user1=new SavingAccount(1,"aashish",10000);
		CurrentAccount user2=new CurrentAccount(2,"vedang",20000);
		System.out.print(user1.withdrawl(11000,user1));
		System.out.print(user2.withdrawl(21000,user2));
		Account acc=new SavingAccount();
		printDetails(acc);
	}

	private static void printDetails(Account acc) {
		// TODO Auto-generated method stub
		System.out.println("\n"+acc.getId());
	}
	
		
	
}   
