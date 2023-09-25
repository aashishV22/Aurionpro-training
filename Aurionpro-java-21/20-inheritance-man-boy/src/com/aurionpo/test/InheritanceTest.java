package com.aurionpo.test;

import com.aurionpo.model.Boy;
import com.aurionpo.model.Infant;
import com.aurionpo.model.Man;

public class InheritanceTest {
	public static void main(String[] args) {
		Man man=new Man();
		man.play();
		man.read();
		
		Boy boy1=new Boy();
		boy1.eat();
		boy1.play();//Takes man referance(parents)
		
		
		Man man1=new Infant();
		//man1.sleep();
		man1.play();
		
		
		Object obj;
		
		obj=1;
		System.out.println(obj.getClass().getSimpleName());
		
		obj="aashish";
		System.out.println(obj.getClass().getSimpleName());
		
	}
}
