package com.aurionpro.test;

import com.aurionpro.model.PrintCharacters;

public class ThreadTest 
{
	public static void main(String[] args) {
		PrintCharacters printChar=new PrintCharacters();
		
//		Thread t1=new Thread(printChar);
//		t1.start();
//		
//		Thread t2=new Thread(printChar);
//		t2.start();
//		
		Runnable anonyFunc=new Runnable() 
		{
			@Override
			public void run() 
			{
				for(char i='A';i<'E';i++) 
				{
					try 
					{
						Thread.sleep(1000);
					} catch (InterruptedException e) 				{		e.printStackTrace();		}
					System.out.println(Thread.currentThread().getName());
					System.out.println("hello"+(char)i);
				}	
			}
		};
		Thread t3=new Thread(anonyFunc);
		t3.start();
	
		Runnable lambdaFunc=()-> {
			for(char i='A';i<'F';i++) 
			{
				try 
				{
					Thread.sleep(1000);
				} catch (InterruptedException e) 				{		e.printStackTrace();		}
				System.out.println(Thread.currentThread().getName());
				System.out.println("hello"+(char)i);
			}	
		};
		Thread t4=new Thread(lambdaFunc);
		t4.start();
		
	}
	
}
