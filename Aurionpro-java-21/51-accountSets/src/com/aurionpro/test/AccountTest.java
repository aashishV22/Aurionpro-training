package com.aurionpro.test;
import java.util.*;
import com.aurionpro.model.*;
public class AccountTest 
{
	public static void main(String[] args) 
	{

		Set<Account> enterySet=new HashSet();
		enterySet.add(new Account("aashish","saving"));
		enterySet.add(new Account("aashish","saving"));
		System.out.println(enterySet);
		
	}
}
