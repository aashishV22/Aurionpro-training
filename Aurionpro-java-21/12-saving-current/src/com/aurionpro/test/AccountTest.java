package com.aurionpro.test;
import java.util.Scanner;

import com.aurionpro.model.Account;
import com.aurionpro.model.AccountType;
public class AccountTest 
{
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		Account accountDetails= 
			new Account(1,"Aahish",12000,AccountType.CURRENT);
//			new Account(2,"Aashish",10000,AccountType.CURRENT)

		System.out.println("Balance after deposit is  "+ deposit(accountDetails,2000));
		withdrawl(accountDetails,17000);
	}
	private static Account deposit(Account accountDetails,double amount) 
		{
			double balanceAmmount = accountDetails.getBalance();
			if(amount>0) 
				{	
					balanceAmmount+=amount;
					accountDetails.setBalance(balanceAmmount);

				}
			return accountDetails;
		}
	private static void withdrawl(Account accountDetails,double amount) 
		{
			if(AccountType.SAVING.equals(accountDetails.getAccountType())) 
				{	
					double balanceAmmount = accountDetails.getBalance();
					if(accountDetails.getBalance()-amount>0) 
						{
							balanceAmmount=balanceAmmount-amount;
							accountDetails.setBalance(balanceAmmount);
							System.out.println("Transaction Successful \n Your Balance after deducting "+ amount +" is"+accountDetails);
						}
					else 
						{
							accountDetails.setBalance(balanceAmmount);
							System.out.println("Transaction Cancelled due to Insufficient Balance \n Your Balance is"+accountDetails);
						}
				}
			else 
				{
					double balanceAmmount = accountDetails.getBalance();
					if((accountDetails.getBalance()-amount)>(-25000)) 
					{
						balanceAmmount=balanceAmmount-amount;
						accountDetails.setBalance(balanceAmmount);
						System.out.println("Transaction Successful \n Your Balance after deducting "+ amount +" is"+accountDetails);
					}
				else 
					{
						accountDetails.setBalance(balanceAmmount);
						System.out.println("Transaction Cancelled due to Insufficient Balance \n Your Balance is"+accountDetails);
					}
				}
		
			}
	
}   
