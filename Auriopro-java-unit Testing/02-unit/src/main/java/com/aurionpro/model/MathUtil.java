package com.aurionpro.model;

public class MathUtil 
{
	private int input=5;
	private int Fact=1;
    

    public int factorial() {
    	for(int i=1;i<=input;i++)
        {   
            Fact=Fact*i;
        }
    	return Fact;
    }

    public int[] addTenToArray(int[] numbers) {
    	for(int i=0;i<numbers.length;i++) {
    		numbers[i]+=10;
    	}
    	return numbers;
    }

    public int division(int number1,int number2) {
    	return number1/number2;
    }
}
