package com.aurionpro.model;

import java.util.Scanner;
public class ArrayMultiplication 
{
	public static void main(String[] args) 
	{
		int m;
		int n;
		Scanner input=new Scanner(System.in);
		System.out.print("Enter the numbers of rows: ");
		m=input.nextInt();
		System.out.print("Enter the numbers of columns: ");
		n=input.nextInt();
		int[][] twoDArray1=new int[m][n];
		int[][] twoDArray2= new int[m][n];
		int[][] multiplication=new int[twoDArray1.length][twoDArray1.length+1];
		//System.out.println(twoDArray1[0][1]);
		
		System.out.println("Enter the elements of 1st martix row wise \n");
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                twoDArray1[i][j] = input.nextInt();
            }
        }
        System.out.println("Enter the elements of 2nd martix row wise \n");
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                twoDArray2[i][j] = input.nextInt();
            }
        }
        System.out.println("Multiplying the matrices...");
		
		

		
		for(int i=0;i<twoDArray1.length;i++) 
		{
			for(int j=0;j<twoDArray1[i].length;j++) 
			{
				for(int k=0;k<twoDArray1.length;k++) {
				multiplication[i][j]+=(twoDArray1[i][k]*twoDArray2[k][j]);
	
				}
			System.out.print(multiplication[i][j]+" ");
			}
			System.out.println();
		}
		
	
	}
	
}


