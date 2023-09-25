package com.aurionpro.test;

import com.aurionpro.model.Time;

public class TimeTest 
{
	public static void main(String[] args) 
	{
		
		Time time1=new Time(16,32,47);
		Time time2=new Time(10,16,40);
		System.out.println(addTime(time1,time2));
	}
	private static Time addTime(Time time1,Time time2) 
	{
		Time addition=new Time(0,0,0);
		int seconds=0;
		int minutes=0;
		int hours=0;
		if(time1.getSeconds()+time2.getSeconds()>60) 
			{
				minutes+=1;
				seconds=(time1.getSeconds()+time2.getSeconds())-60;
				addition.setSeconds(seconds);
			}		
		else 
			{
				seconds=(time1.getSeconds()+time2.getSeconds());
				addition.setSeconds(seconds);
			}
		if(time1.getMinutes()+time2.getMinutes()>60) 
			{
				hours+=1;
				minutes=(time1.getMinutes()+time2.getMinutes()-60)+minutes;
				addition.setMinutes(minutes);
			}
		else 
			{
			minutes=time1.getMinutes()+time2.getMinutes()+minutes;
			addition.setMinutes(minutes);
			}
		if(time1.getHours()+time2.getHours()>24) 
			{
				hours=time1.getHours()+time2.getHours()-24;
				addition.setHours(hours);
			}
		else 
			{
				hours=time1.getHours()+time2.getHours();
				addition.setHours(hours);
			}

		return addition;
	}

}
