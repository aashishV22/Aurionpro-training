package com.aurionpro.test;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import com.aurionpro.model.Account;
import java.io.FileOutputStream;

public class AccountSerializationTest 
{
	public static void main(String[] args) 
	{
		Account account=new Account(1,"aashish",332423);
		try 
		{
			FileOutputStream file=new FileOutputStream("C:\\Users\\aashish.verma\\Documents\\text.txt");
			ObjectOutputStream out=new ObjectOutputStream(file);
			out.writeObject(account);
			out.close();
			file.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		System.out.println("Serialization Successful");
	}

}
