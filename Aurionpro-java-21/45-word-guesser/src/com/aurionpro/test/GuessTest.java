package com.aurionpro.test;
import java.util.Iterator;
import java.util.Random;
import java.util.*;
public class GuessTest 
{
	public static void main(String[] args) 
	{
		boolean isGuessed=false;
		Scanner input=new Scanner(System.in);
		String characters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String randomWordGenerated="";
		
		Random random=new Random();
		int length=8;
		char[] text=new char[length];
		for(int i=0;i<length;i++) {
			text[i]=characters.charAt(random.nextInt(characters.length()));
		}
		for (int i = 0; i < text.length; i++) {
			randomWordGenerated+=text[i];
		}
		
		
		System.out.println(randomWordGenerated);
		
		
		char[] inputAnswer= new char[length];
			for (int i = 0; i < inputAnswer.length; i++) 
			{
				inputAnswer[i]='-';
			}
			System.out.println(inputAnswer);
		
		int lives=10;
		int j=1;
		boolean isGuessCorrect = false;
		while(lives!=0) 
		{
			System.out.println("enter an alphabet: ");
			char userInput=input.next().charAt(0);
			char userInputUpper=Character.toUpperCase(userInput);
			System.out.println(userInputUpper);
			isGuessCorrect = false;
			for (int i = 0; i < length; i++) 
			{
					if(userInputUpper==text[i]) 
						{
						isGuessCorrect = true;
						inputAnswer[i]=userInputUpper;
						}
			}
//			lives-=1;
//			System.out.println("Live remaining: "+lives);
			System.out.println(inputAnswer);
			j++;
			if(!isGuessCorrect) {
				lives-=1;
				System.out.println("Live remaining: "+lives);
			}
		}
	}
}
