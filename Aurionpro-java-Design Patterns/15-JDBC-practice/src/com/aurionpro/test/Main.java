package com.aurionpro.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.aurionpro.model.*;

public class Main 
{		
	public static void main(String[] args) 
	{
		Student st=new Student();
//		st.createTable();
//		st.createData();
		st.readData();
//		st.updateData();
//		st.deleteData();
	}

}
