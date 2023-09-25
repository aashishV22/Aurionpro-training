package com.aurionpro.test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.aurionpro.model.*;

public class LineItemTest 
{
	public static void main(String[] args) {
		Product p1=new Product(3121,"LifeBoy",32,4.0);
		Product p2=new Product(4121,"Dove",42,2.0);
		Product p3=new Product(5121,"BornVita",42,7.0);
		Product p4=new Product(6121,"Amul Butter",67,2.0);
		LineItem l1=new LineItem(1,2,p1);
		LineItem l2=new LineItem(2,5,p2);
		LineItem l3=new LineItem(3,1,p3);
		LineItem l4=new LineItem(4,5,p1);
		LineItem l5=new LineItem(5,8,p3);
		LineItem l6=new LineItem(6,3,p4);
		Order order1=new Order(1,LocalDate.now() ,Arrays.asList(l1,l2,l3));
		Order order2=new Order(2,LocalDate.now() ,Arrays.asList(l4,l5,l6));
		
//		System.out.println(l1.calculateLineItemCost());
//		System.out.println(order1);
//		System.out.println("================================================================================================");
//		System.out.println(order2);
		Customer customer1=new Customer(1,"Aashish",Arrays.asList(order1,order2));
		System.out.println("================================================================================================");
		System.out.println(customer1);
		
		
	}
}
