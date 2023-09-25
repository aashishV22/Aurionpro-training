package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.exception.InsufficientFundsException;
import com.aurionpro.model.Account;
import com.aurionpro.util.WithdrawUtil;

public class AccountTest 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Account account1=new Account(1,"Aashish",3000);
		System.out.println(account1);
		System.out.println("Enter Deposit amount: ");
		int depostiAmount=sc.nextInt();
		System.out.println("After deposit:");
		System.out.println(deposit(account1, depostiAmount));
		
		try {
//			WithdrawUtil.withdraw(account1);
			System.out.println(WithdrawUtil.withdraw(account1));
		}
		catch(InsufficientFundsException e)
			{
//			 e.printStackTrace();
			System.out.println(e.getMessage());
			}
		
	}
	
	public static Account deposit(Account account1,int depositAmount) {
		double balance=account1.getBalance()+depositAmount;
		account1.setDeposit(depositAmount);
		account1.setBalance(balance);
		return account1;
	}
	
}
