package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OccuranceTest 
{
	public static void main(String[] args) 
	{
		List<Integer> numberList = Arrays.asList(13,233,24,23,24,2,1,1,11,13,24,10,0,0,10);
		for(Integer x:numberList) 
		{
			System.out.print(x+",");
		}
		
		Map<Integer, Integer> occuranceMap = new HashMap<Integer,Integer>();
//
// we are passing array elemts as a key and assigning values (frequency)
		for(Integer x:numberList) {
			if(!occuranceMap.containsKey(x)) {
				occuranceMap.put(x, 1);
			}else {
				occuranceMap.put(x, occuranceMap.get(x)+1);
			}
		}
	
//		for(int i=0;i<((List<Integer>)numberList).size();i++) {
//			int value=numberList.get(i);
//			if(!occuranceMap.containsKey(numberList.get(i))) 
//			{
//				occuranceMap.put(value, 1);
//			}else {
//				occuranceMap.put(value, occuranceMap.get(i)+1);
//			}
//		}
		
		occuranceMap.forEach((key,value)->{
			System.out.println(key+"-"+value);
		});
		
		
	}
}
