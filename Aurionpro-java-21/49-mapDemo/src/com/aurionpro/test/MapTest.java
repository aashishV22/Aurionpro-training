package com.aurionpro.test;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		Map<Integer, String> demoMap = new HashMap<>();
		Scanner sc=new Scanner(System.in);
		demoMap.put(1,"Aashish");
		demoMap.put(3, "mahess");
		demoMap.put(4, "bhavesss");
		demoMap.put(5, "Jigness");
		demoMap.remove(3);
		System.out.println(demoMap.containsKey(3));
		
//		Set<Entry<Integer, String>> enterySet=demoMap.entrySet();
		
//		for(Entry x:enterySet) {
//			System.out.println(x.getKey()+" "+x.getValue());
//		}
		demoMap.forEach((key,value)->
		{
			System.out.println(key+" "+value);
		});
		System.out.print("Enter name to be removed:");
		String input=sc.next();
		System.out.println(input);
		int keyValue=0;
		if(demoMap.containsValue(input)) 
		{
			for(Entry<Integer, String> entery:demoMap.entrySet()) {
				if(entery.getValue().equals(input)) 
					{
						keyValue=entery.getKey();
				
						System.out.println(entery.getValue());
						System.out.println("-----------------------");
					}
			}
			
		};
		demoMap.remove(keyValue);
		demoMap.forEach((key,value)->
		{
			System.out.println(key+" "+value);
		});
		
	}
}
