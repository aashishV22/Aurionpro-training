package com.aurionpro.test;
import com.aurionpro.model.*;
public class WorkerTest 
{
	public static void main(String[] args) {
		IWorker labour=new Labour();
		labour.startWork();
		IWorker robo=new Robot();
		robo.drink();
	}
	
}
