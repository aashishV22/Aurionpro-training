package com.aurionpro.test;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import com.aurionpro.model.Account;
import java.io.FileOutputStream;
import java.io.IOException;

public class AccountDeserializationTest 
{
	public static void main(String[] args) 
	{
		Account account=new Account(1,"aashish",332423);
		try 
		{
			FileInputStream file=new FileInputStream("C:\\Users\\aashish.verma\\Documents\\array.txt");
			ObjectInputStream in=new ObjectInputStream(file);
			Account account1=(Account)in.readObject();
			in.close();
			file.close();
			System.out.println(account1);
		}
		catch(IOException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		System.out.println("Serialization Successful");
	}

}
