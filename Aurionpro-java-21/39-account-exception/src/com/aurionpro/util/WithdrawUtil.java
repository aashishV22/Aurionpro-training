package com.aurionpro.util;

import java.util.Scanner;

import com.aurionpro.exception.InsufficientFundsException;
import com.aurionpro.model.Account;

public class WithdrawUtil {

	public static Account withdraw(Account account)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the withdraw amount");
		double withdrawlAmount=sc.nextInt();
		if(account.getBalance()-withdrawlAmount>1000) 
		{
			withdrawlAmount=account.getBalance()-withdrawlAmount;
			account.setWithdraw(withdrawlAmount);
			account.setBalance(withdrawlAmount);
		}
		else{
			throw new InsufficientFundsException("Insufficient Balance");
		}
		return account;
		
	}
	
}
