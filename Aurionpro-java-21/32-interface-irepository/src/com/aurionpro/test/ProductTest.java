package com.aurionpro.test;

import com.aurionpro.model.IRepository;
import com.aurionpro.model.ProductRepository;

public class ProductTest 
{
	public static void main(String[] args) 
	{
		ProductRepository repository=new ProductRepository();
		repository.create();
		repository.read();
		repository.update();       //   Update of interface is called using productRepository file
		IRepository.delete();
		int temp=IRepository.varities;
		System.out.println("\n"+temp);
	}
}
