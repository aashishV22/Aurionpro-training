package com.aurionpro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Student 
{
	public void createDatabase() {
		try 
		{
			String url= "jdbc:mysql://localhost:3306/";
			
		    // Load MySQL JDBC driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection to the MySQL database
            Connection conn = DriverManager.getConnection(url, "root", "root123");
            System.out.println("Connection established");
			
          //statement create
            Statement stm = conn.createStatement();
            String queryCreate="create database javaConnection";
            stm.execute(queryCreate);
            conn.close();
	 	
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
	
	}
	
	public void createTable() {
		try 
		{
			String url= "jdbc:mysql://localhost:3306/javaConnection";
		    // Load MySQL JDBC driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection to the MySQL database
            Connection conn = DriverManager.getConnection(url, "root", "root123");
            System.out.println("Connection established");
			
            //statement create
            Statement stm = conn.createStatement();
            String queryCreate="create table StudentNew (s_id int auto_increment primary key,name varchar(255) not null,s_email varchar(200) )";
            stm.execute(queryCreate);
            conn.close();
            System.out.println("Table created");
		}
		catch(Exception e)		{	e.printStackTrace();	}
	
	}

	public void createData() {
		try 
		{
			String url= "jdbc:mysql://localhost:3306/javaConnection";
		    // Load MySQL JDBC driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection to the MySQL database
            Connection conn = DriverManager.getConnection(url, "root", "root123");
            System.out.println("Connection established");
			
//          statement create-	Method 1
//            Statement stm = conn.createStatement();
//            String queryInsert="insert into StudentNew(name,s_email) values('aashish','aashish@gmail.com' )";
//            stm.execute(queryInsert);
            
//          Statement create-	Method 2
//            String queryInsert="insert into StudentNew(name,s_email) values('ved','ved@gmail.com' )";
//            PreparedStatement preparedStatement= conn.prepareStatement(queryInsert);
//            preparedStatement.execute();
            
//          Statement create-	Method 3
            
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter Name:-");
       		String firstName=sc.nextLine();
            System.out.print("Enter email address:-");
       		String email=sc.nextLine();

       		String queryInsert="insert into StudentNew(name,s_email) values(?,? )";
            PreparedStatement preparedStatement= conn.prepareStatement(queryInsert);
            preparedStatement.setString(1, firstName );
            preparedStatement.setString(2, email );
            
            preparedStatement.execute();
            
            
            conn.close();
            System.out.println("Table created");
		}
		catch(Exception e)		{	e.printStackTrace();	}
		
	}

	public void readData() {
		try 
		{
			
			ArrayList<StudentNew> studentList= new ArrayList<StudentNew>();
			String url= "jdbc:mysql://localhost:3306/javaConnection";
		    // Load MySQL JDBC driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection to the MySQL database
            Connection conn = DriverManager.getConnection(url, "root", "root123");
            System.out.println("Connection established");

            Statement stm = conn.createStatement();
       		String queryRead="select * from StudentNew";
       		
     
       		ResultSet rs =  stm.executeQuery(queryRead);
            while(rs.next()) {
            	StudentNew stu=new StudentNew();
            	stu.setStudentId(rs.getInt(1));
            	stu.setStudentName(rs.getString(2));
            	stu.setStudentEmail(rs.getString(3));
            	studentList.add(stu);
//            	System.out.println(stu);
            
            }
            for (StudentNew x : studentList) {
                System.out.println(x);
            }
            conn.close();
            System.out.println("Table read");
		}
		catch(Exception e)		{	e.printStackTrace();	}		
	}

	public void updateData() {
		try 
		{
			String url= "jdbc:mysql://localhost:3306/javaConnection";

			// Create a connection to the MySQL database
            Connection conn = DriverManager.getConnection(url, "root", "root123");
            System.out.println("Connection established");
			            
//          Statement create-	Method 3
            
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter Name:-");
       		String firstName=sc.nextLine();
            System.out.print("Enter studdnt id :-");
       		int s_id=sc.nextInt();

       		String queryUpdate="update StudentNew set name = ? where s_id= ? " ;
            PreparedStatement preparedStatement= conn.prepareStatement(queryUpdate);
            preparedStatement.setString(1, firstName );
            preparedStatement.setInt(2, s_id );
            preparedStatement.execute();

            conn.close();
            System.out.println("Table created");
		}
		catch(Exception e)		{	e.printStackTrace();	}
		
	}

	public void deleteData() {
		try 
		{
			String url= "jdbc:mysql://localhost:3306/javaConnection";

			// Create a connection to the MySQL database
            Connection conn = DriverManager.getConnection(url, "root", "root123");
            System.out.println("Connection established");
			            
//          Statement create-	Method 3
            
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter studdnt id :-");
       		int s_id=sc.nextInt();

       		String queryUpdate="DELETE FROM studentnew WHERE (s_id = ? )" ;
            PreparedStatement preparedStatement= conn.prepareStatement(queryUpdate);
            preparedStatement.setInt(1, s_id );
            preparedStatement.execute();

            conn.close();
            System.out.println("row deleted");
		}
		catch(Exception e)		{	e.printStackTrace();	}
		
	}
}
