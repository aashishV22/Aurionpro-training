package com.aurionpro.test;

import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class threadsMulti 
{
	public static void main(String[] args) 
	{
		Runnable task=()->
		{
			for(int i=0;i<4;i++) 
			{
				System.out.println(Thread.currentThread().getName());
				try 
				{
					Thread.sleep(1000);
				} catch (InterruptedException e) 			{	e.printStackTrace();	}
			}
		};
		
//		for(int i=0;i<10;i++) {
//			String name = "Thread-" +i;
//			Thread temp=new Thread(task,name);
//			temp.start();
//		}
	
		Executor services= Executors.newFixedThreadPool(10);
//		for(int i=0;i<10;i++)s {
			services.execute(task);
//		}
		
	}
}
