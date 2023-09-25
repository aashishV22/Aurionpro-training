package com.aurionpro.test;

import java.sql.Array;

import com.aurionpro.model.CircleShapeFactory;
import com.aurionpro.model.IShape;

public class FlyWeightTest {
	public static void main(String[] args) {
		String[] values = new String[4];
		values[0]="red";
		values[1]="blue";
		values[2]="green";
		values[3]="red";
		CircleShapeFactory shape=new CircleShapeFactory();
		for(String x:values) {
			IShape tempObj=shape.getCircle(x);
			tempObj.draw(x);
		}
	
	}
}
