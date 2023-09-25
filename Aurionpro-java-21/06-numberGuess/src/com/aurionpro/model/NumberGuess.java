package com.aurionpro.model;
import java.util.Random;
import java.util.Scanner;

public class NumberGuess 
{
	Scanner input= new Scanner(System.in);
	Random random=new Random();
	private int answer = random.nextInt(101);

	private int userInput;
	public void setInput(int userInput)
	{	
		this.userInput=guessingTheNumber(userInput);
	}
	public int getInput()
	{	
		return userInput;
	}
	public int getNumberIs()
	{
		return answer;
	}
	public int guessingTheNumber(int userInput)
	{	
		
			for(int i=2;i<7;i++)
			{
				if(userInput>0 && userInput<101)
				{	
				if(userInput!=answer && userInput<answer)
				{
					System.out.print("Turn:"+ i +" \n Your guessed number "+ userInput+" is low , Re-enter a higher number: " );
					userInput=input.nextInt();
				}
				else if (userInput!=answer && userInput>answer) 
				{
					System.out.print("Turn:"+ i +" \n + Your guessed number "+ userInput+" is high , Re-enter a lower number: ");				
					userInput=input.nextInt();
				}
				else if(userInput==answer){
					System.out.print("You guesssed it right, The number is "+userInput);
					break;
				}
				if(i==6)
				{
					System.out.println("OOps! You guessed it wrong and Your limit has been reached. \nThe correct answer was "+answer);
					askToContinue();
				}
			}
			else
			{
				i--;
				System.out.println("Enter a valid input \n Turn: "+i +" \nRe-enter a valid number: ");
				userInput=input.nextInt();
//				guessingTheNumber(userInput);
				
				
			}	
			}
		
		
		return userInput;

	}
	public void askToContinue() {
		System.out.println("Do you want to continue playing? (y/n)");
        String choice = input.next().toLowerCase();
        if (choice.equals("y")) {
            answer = (int) (100 * Math.random());
            System.out.print(" Turn 1 \n Guess the number:");
    		int userInput=input.nextInt();
    		setInput(userInput);
        }
        else {
        	System.out.println("Game ended");
        }
	}
}
