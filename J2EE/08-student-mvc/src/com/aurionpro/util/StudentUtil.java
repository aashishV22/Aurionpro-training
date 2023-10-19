package com.aurionpro.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public List<Student> getStudents(DataSource dataSource) throws SQLException
	{
		List<Student> allStudents=new ArrayList<Student>();
		Connection conn=null;
		Statement stmnt=null;
		ResultSet result=null;
		try 
		{
			conn=dataSource.getConnection();
			String sql="select * from studentnew";
			stmnt = conn.createStatement();
			result = stmnt.executeQuery(sql);
			while(result.next()) {
				int id= result.getInt("id");
				String firstName = result.getString("name");
				String lastName  = result.getString("last_name");
				String email     = result.getString("email");
//				String course    = result.getString("course_name");
//				List<String> courses=new ArrayList<String>();
//				courses.add(course);
				Student temp=new Student(id, firstName, lastName, email);
				allStudents.add(temp);
//				if(allStudents.size()==0) {
//			
////					System.out.println("inside 1st if"+courses);
//					allStudents.add(new Student(id,firstName,lastName,email,courses));
////					System.out.println(allStudents);
////					System.out.println("********************************************");
//				}
//				for(int i=0;i<allStudents.size();i++) {
////					System.out.println("Start of for loop-"+i);
////					System.out.println(allStudents);
//					if(allStudents.get(i).getId()==temp.getId()) 
//					{	
//						courses=allStudents.get(i).getCourses();
////						System.out.println("Indise 2nd ifs if-else "+courses);
////						System.out.println(allStudents.get(i));
////						System.out.println(i);
//						if(!courses.contains(course)) 
//						{
//							courses.add(course);
//							allStudents.get(i).setCourses(courses);
//						}
////						System.out.println("This is temp"+ temp);
////						System.out.println(allStudents.get(i));
//					}else if(allStudents.get(i).getId()!=id) 
//					{
////						System.out.println("inside 3rd if-else");
//						courses=new ArrayList<String>();
//						courses.add(course);
////						System.out.println(id);
//						allStudents.add(new Student(id,firstName,lastName,email,courses));
//						break;
//					}
////					System.out.println("***********End of one oteration****************");
//				}
//				System.out.println("===================End of while==========================");
				
			}
		}catch(SQLException e) {	e.getMessage();				}
		finally 			   {	close(conn,stmnt,result);	}
		return allStudents;
	}
	

	private void close(Connection conn, Statement stmnt, ResultSet result) throws SQLException 
	{
		if(conn!=null) 		{	conn.close();		};
		if(stmnt!=null) 	{	stmnt.close();		};
		if(result!=null) 	{	result.close();		};
	}

	public void addStudent(Student student) throws SQLException {
		Connection conn=null;
		PreparedStatement stmnt=null;
		try 
		{
			conn=dataSource.getConnection();
			String sql="insert into studentnew (name,last_name,email) values (?,?,?) ";
			stmnt = conn.prepareStatement(sql)        ;
			stmnt.setString(1, student.getFirstName());
			stmnt.setString(2, student.getLastName()) ;
			stmnt.setString(3, student.getEmail())	  ;
			stmnt.execute();
			
		}catch(SQLException e) 	{	e.getMessage();		}
		finally 				{close(conn,stmnt,null);}
	}

	public Student getStudentById(int id) throws SQLException {
		Connection conn=null;
		PreparedStatement stmnt=null;
		ResultSet result=null;
		Student tempStudent=null;
		try 
		{
			conn=dataSource.getConnection();
			String sql="SELECT * FROM studentnew where id=?";
			stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1,id);
			result = stmnt.executeQuery();
			
			if(result.next()) 
			{
				String firstName= result.getString("name");
				String lastName= result.getString("last_name");
				String email= result.getString("email");
				tempStudent=new Student(id,firstName, lastName, email);
			}
		}
		catch(SQLException e) {	e.getMessage();				}
		finally				  {	close(conn,stmnt,result);	}
		return tempStudent;
	}

	public void updateStudent(Student updatedStudent) throws SQLException {
		Connection conn=null;
		PreparedStatement stmnt=null;
		try 
		{
			conn=dataSource.getConnection();
			String sql="UPDATE studentnew SET name = ?, last_name = ?, email = ? WHERE (id = ?)";
			stmnt = conn.prepareStatement(sql)        ;
			stmnt.setString(1, updatedStudent.getFirstName());
			stmnt.setString(2, updatedStudent.getLastName()) ;
			stmnt.setString(3, updatedStudent.getEmail())	  ;
			stmnt.setInt(4, updatedStudent.getId())	  ;
			stmnt.execute();	
			
		}catch(SQLException e) 	{	e.getMessage();		}
		finally 				{close(conn,stmnt,null);}
	}

	public void deleteStudent(int id) throws SQLException {
		Connection conn=null;
		PreparedStatement stmnt=null;
		try 
		{
			System.out.println(id);
			conn=dataSource.getConnection();
			String sql="DELETE FROM studentnew WHERE (id = ? )";
			stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, id)	  ;
			stmnt.execute();	
		}
		catch(SQLException e) 	{	e.getMessage();		}
		finally 				{close(conn,stmnt,null);}
	}

	public List<Student> search(String value, String columnName) throws SQLException {
		Connection conn=null;
		PreparedStatement stmnt=null;
		ResultSet result=null;
		List<Student> tempStudent=new ArrayList<>();
		System.out.println(columnName);
		String sql;

		try 
		{
			switch(columnName) {
			case "StudentId":
				sql="SELECT * FROM studentnew WHERE id LIKE ?";
				break;
			case "First Name":
				sql="SELECT * FROM studentnew WHERE name LIKE ?";
				break;
			case "Last Nam":
				sql="SELECT * FROM studentnew WHERE last_name LIKE ?";
				break;
			case "Student Email":
				sql="SELECT * FROM studentnew WHERE email LIKE ?";
				break;
			default:
				sql="SELECT * FROM studentnew WHERE name LIKE ?";
			}
			
			conn=dataSource.getConnection();
			stmnt = conn.prepareStatement(sql);
			stmnt.setString(1,"%"+value+"%");
			System.out.println(stmnt);
			result = stmnt.executeQuery();
			
			while(result.next()) 
			{
				int id= result.getInt("id");
				String firstName= result.getString("name");
				String lastName= result.getString("last_name");
				String email= result.getString("email");
				Student likeStudent=new Student(id,firstName, lastName, email);
				tempStudent.add(likeStudent);
			}
		}
		catch(SQLException e) {	e.getMessage();				}
		finally				  {	close(conn,stmnt,result);	}
		return tempStudent;
	}
	


}
