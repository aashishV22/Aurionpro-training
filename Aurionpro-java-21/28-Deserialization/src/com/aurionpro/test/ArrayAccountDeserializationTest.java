package com.aurionpro.test;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import com.aurionpro.model.Account;
import java.io.FileOutputStream;
import java.io.IOException;

public class ArrayAccountDeserializationTest 
{
	public static void main(String[] args) 
	{
		try 
		{	
				FileInputStream file=new FileInputStream("C:\\Users\\aashish.verma\\Documents\\array2.txt");
				ObjectInputStream in=new ObjectInputStream(file);

				Account[] account=(Account[])in.readObject();
				in.close();
				file.close();
				for(int i=0;i<account.length;i++) 
				{
					System.out.println(account[i]);
				}
		}
		catch(IOException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		System.out.println("Serialization Successful");
	}

}
