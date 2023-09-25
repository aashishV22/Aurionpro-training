package com.aurionpro.model;

public class Statistics 
{
	public static void main(String[] args) 
	{
		int numbers[] = new int[args.length];
		for(int i=0;i<args.length;i++)
		{
			numbers[i]=Integer.parseInt(args[i]);
		}
		System.out.print("Numbers=");
		int sum=0;
		for(int i=0;i<numbers.length;i++) 
			{
			System.out.print(numbers[i]+",");
			}
		
		System.out.print("\nAfter sorting the array is ");
		int temp=0;
		for(int i=0;i<numbers.length;i++) 
		{
			for(int j=i+1;j<numbers.length;j++) 
			{
				if(numbers[i]>numbers[j]) 
					{
						temp=numbers[j];
						numbers[j]=numbers[i];
						numbers[i]=temp;
					}
		
			}
		}
		for(int i=0;i<numbers.length;i++) 
			{
				System.out.print(numbers[i]+",");
			}
		System.out.print("\n");
		for(int i=0;i<numbers.length;i++) 
			{
				sum+=numbers[i];
			//System.out.print(numbers[i]+",");
			}
		
		
		System.out.print("\nsum is "+sum);
		int average=sum/(numbers.length);
		System.out.print("\nAverage is "+average);
		
		
		int median=0;
		if(numbers.length%2==0) 
			{	
				int medianIndex1=numbers.length/2;
				int medianIndex2=medianIndex1-1;
				median=(numbers[medianIndex1]+numbers[medianIndex2])/2;
				System.out.print("\nMedian is "+median);
			}
		else 
			{
				int medianIndexOdd=numbers[(numbers.length/2)];
				System.out.print("\nMedian is "+medianIndexOdd);
			}
		System.out.println("");
		System.out.print("Frequency is ");
		int [] frequency = new int[args.length];
        int counted = -1;
        for(int i = 0; i < numbers.length; i++)
        {
          int count = 1;
          for(int j = i+1; j < numbers.length; j++)
          {
            if(numbers[i] == numbers[j])
            	{
            		count++;
            		frequency[j] = counted;
            	}
          }
          if(frequency[i] != counted) 
          	{
        	  frequency[i] = count;
          	}
          }
        for (int i = 0; i < frequency.length; i++) 
        {
			System.out.print(frequency[i] + " ");
		}
       
	}
		
		
		
		
	}
	

