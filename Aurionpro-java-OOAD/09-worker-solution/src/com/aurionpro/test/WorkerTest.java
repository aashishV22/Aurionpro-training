package com.aurionpro.test;
import com.aurionpro.model.*;
public class WorkerTest 
{
	public static void main(String[] args) {
		IWorker labour=new Labour();
		labour.startWork();
		labour.eat();
		IWorkable robo=new Robot();
		robo.startWork();
	}
	
}
