package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NamesTest {
	public static void main(String[] args) {
		List<String> nameArray= new ArrayList<>();
		nameArray.add("Aashish");
		nameArray.add("Vedang");
		nameArray.add("ved");
		nameArray.add("Tan");
		nameArray.add("Tani");
		System.out.println(nameArray);
		List<String> newList=new ArrayList<String>();
		for(String x:nameArray) {
			if(x.length()==3 || x.length()==4){
				newList.add(x);
			};
		};
		System.out.println(newList);
		
		List<String> collectNames=nameArray.stream()
				.filter((name)->(name.length()==3 || name.length()==4))
				.collect(Collectors.toList());
		collectNames.stream().forEach((name)->System.out.println(name));
		
	}
}
