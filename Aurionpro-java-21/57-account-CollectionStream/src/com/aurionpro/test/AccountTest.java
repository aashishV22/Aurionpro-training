package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.aurionpro.model.*;
public class AccountTest {

	public static void main(String[] args) {
		List<Account> accounts= new ArrayList();
		accounts.add(new Account(1,"Aashish",Gender.MALE,  AccountType.SAVING,  10000.570));
		accounts.add(new Account(2,"Vedang", Gender.MALE,  AccountType.SAVING,  20000.570));
		accounts.add(new Account(3,"Tanish", Gender.MALE,  AccountType.CURRENT, 30000.570));
		accounts.add(new Account(4,"Sid",	 Gender.MALE,  AccountType.CURRENT, 40000.570));
		accounts.add(new Account(5,"Tanuja", Gender.FEMALE,AccountType.SAVING,  60000.570));
		
	
		System.out.println("--------------Maximum balance-------------------");
		List<Account> topBalances=accounts.stream()
				.sorted(Comparator.comparingDouble(Account::getBalance).reversed())
				.limit(1)
				.collect(Collectors.toList());
		topBalances.forEach((ammount)->System.out.println(ammount));
		
		System.out.println("--------------Minimum balance-------------------");
		List<Account> minBalances=accounts.stream()
				.sorted(Comparator.comparingDouble(Account::getBalance))
				.limit(1)
				.collect(Collectors.toList());
		minBalances.forEach((ammount)->System.out.println(ammount));
		
		System.out.println("--------------Names greater than 6 characters--------");
		List<Account> greater6 =accounts.stream()
				.sorted(Comparator.comparingDouble(Account::getBalance).reversed())
				.filter((account)->account.getAccountHolder().length()>=6)
				.collect(Collectors.toList());
		greater6.forEach((ammount)->System.out.println(ammount));
		
		System.out.println("--------------Total balance------------------");
		Double sum =accounts.stream()
				.map((account)->account.getBalance())
				.reduce( (double) 0, (a,b)-> a+b);
		System.out.println("sum is "+sum);
	}
}
