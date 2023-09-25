package com.aurionpro.test;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import com.aurionpro.model.Account;
import java.io.FileOutputStream;

public class ArrayAccountSerializationTest 
{
	public static void main(String[] args) 
	{
		Account[] account= {
				new Account(1,"aashish",332423),
				new Account(2,"vedang",5835522),
				new Account(3,"Tanish",5522),
				new Account(4,"Siddhant",835522),
		};
		try 
		{
//			FileOutputStream file=new FileOutputStream("C:\\Users\\aashish.verma\\Documents\\array.txt");
//			ObjectOutputStream out=new ObjectOutputStream(file);
//			for(int i=0;i<account.length;i++) 
//			{	
				FileOutputStream file=new FileOutputStream("C:\\Users\\aashish.verma\\Documents\\array2.txt");
				ObjectOutputStream out=new ObjectOutputStream(file);
				out.writeObject(account);
				out.close();
				file.close();
			//}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		System.out.println("Serialization Successful");
	}

}
