package com.aurionpro.test;

import com.aurionpro.model.HotelReception;

public class HotelTest 
{
	public static void main(String[] args) {
		HotelReception hotel=new HotelReception();
		hotel.getIndianMenu();
		System.out.println("________________________________");
		hotel.getItalianMenu();
	}
}
