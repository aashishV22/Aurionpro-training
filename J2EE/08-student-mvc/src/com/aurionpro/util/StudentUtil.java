package com.aurionpro.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.sql.DataSource;

import com.aurionpro.model.Student;

public class StudentUtil {
	private DataSource dataSource;

	public StudentUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<Student> getStudents(DataSource dataSource){
		List<Student> allStudents=new ArrayList<Student>();
		try 
		{
			Connection conn=null;
			Statement stmnt=null;
			ResultSet result=null;
			
			conn=dataSource.getConnection();
			String sql="SELECT * FROM studentnew";
			stmnt = conn.createStatement();
			result = stmnt.executeQuery(sql);
			
			while(result.next()) {
				int id= result.getInt("id");
				String firstName= result.getString("name");
				String lastName= result.getString("last_name");
				String email= result.getString("email");
				
				allStudents.add(new Student(id,firstName,lastName,email));
			}
			
		}catch(SQLException e) {
			e.getMessage();
		}
		return allStudents;
	
		
	}
	
	
}
