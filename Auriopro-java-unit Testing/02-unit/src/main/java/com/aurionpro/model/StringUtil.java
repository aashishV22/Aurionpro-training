package com.aurionpro.model;

public class StringUtil
{
	public String truncateAInFirst2Positions(String str) {
		StringBuilder sc=new StringBuilder(str);
		if(sc.charAt(0)=='A') {
			sc.deleteCharAt(0);
		} if(sc.charAt(0)=='A') {
			sc.deleteCharAt(0);
		}
		String str1=sc.toString();
		System.out.println(sc);
		return str1;
	}
	
	public boolean areFirstAndLastTwoCharactersTheSame(String str) {
		int length=str.length();
		if(str.charAt(0)==str.charAt(1) && str.charAt(length-1)==str.charAt(length-2)) {
			return true;
		}else {
			return false;
		}
	}
}
