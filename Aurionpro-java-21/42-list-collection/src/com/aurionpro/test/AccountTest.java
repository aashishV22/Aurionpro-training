package com.aurionpro.test;
import java.util.*;

import com.aurionpro.model.Account;

public class AccountTest {
	public static void main(String[] args) {
		List<Account> accounts = new ArrayList<>();
		accounts.add(new Account(1,"Aashish",232343));
		accounts.add(new Account(2,"bhavess",23243));
		accounts.add(new Account(3,"Jigness",2343));
		accounts.add(new Account(4,"Mahess",343));
		System.out.println(accounts);
		System.out.println("________________________");
		accounts.remove(0);
		System.out.println(accounts);		// After removing zero-th element
		System.out.println("________________________");
//		for(int i=0;i<accounts.size();i++) {
//			System.out.println(accounts.get(i).getName());
//		}
		Iterator<Account> iterator=accounts.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getName());
		}
//		Collections.sort(accounts);
		Collections.sort(accounts,Collections.reverseOrder());
		System.out.println(accounts);
	}
}
