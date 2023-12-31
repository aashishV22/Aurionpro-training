package com.aurionpro.model;

import java.util.HashMap;

public class CircleShapeFactory {

	private HashMap<String, IShape> circleMap=new HashMap<String, IShape>();
	
	public IShape getCircle(String color) 
	{
		if(!circleMap.containsKey(color)) {
			circleMap.put(color, new Circle(color));
			return circleMap.get(color);
		}
		else {
			return circleMap.get(color);
		}
	}
	
}
