package com.aurionpro.test;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.model.LineItem;

public class LineItemTest 
{
	public static void main(String[] args) 
	{
		List<LineItem> LineItems=new ArrayList<LineItem>();
		LineItems.add(new LineItem(1,"maaza",3,54));
		LineItems.add(new LineItem(2,"frooti",5,66));
		LineItems.add(new LineItem(3,"Coca-cola",7,34));
		LineItems.add(new LineItem(4,"Slice",8,54));
		LineItems.add(new LineItem(5,"Sprite",9,56));
		LineItems.add(new LineItem(6,"ThumbsUp",7,45));

		for(int i=0;i<((List<LineItem>)LineItems).size();i++) 
		{
			System.out.println(LineItems.get(i));
		}
		System.out.println("Total cart cost is "+LineItem.totalCaetCost(LineItems));
		
		
	}
}
