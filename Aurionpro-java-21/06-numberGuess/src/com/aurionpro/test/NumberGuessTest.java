package com.aurionpro.test;

import com.aurionpro.model.NumberGuess;
import java.util.Scanner;
public class NumberGuessTest {
	public static void main(String[] args) 
	{
		Scanner input= new Scanner(System.in);
		NumberGuess guess=new NumberGuess();
		System.out.print(" Turn 1 \n Guess the number:");
		int userInput=input.nextInt();
		guess.setInput(userInput);
		
		//System.out.println(guess.getInput());
		System.out.println("\n The correct answer is "+guess.getNumberIs());		

	}

}
