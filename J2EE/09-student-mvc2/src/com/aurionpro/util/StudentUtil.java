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
			String sql="select * from studentnew as s right  join student_course on s.id=student_course.student_id right  join coursenew on student_course.course_id=coursenew.id order by s.id";
			stmnt = conn.createStatement();
			result = stmnt.executeQuery(sql);
			while(result.next()) {
				int id= result.getInt("id");
				String firstName = result.getString("name");
				String lastName  = result.getString("last_name");
				String email     = result.getString("email");
				String course    = result.getString("course_name");
				List<String> courses=new ArrayList<String>();
				courses.add(course);
				Student temp=new Student(id, firstName, lastName, email, courses);
				boolean isEntryDone=false;
				if(allStudents.size()==0) {
			
					System.out.println("inside 1st if"+courses);
					allStudents.add(new Student(id,firstName,lastName,email,courses));
					System.out.println(allStudents);
					System.out.println("********************************************");
				}
				while(!isEntryDone) {
					System.out.println("Start of for loop-"+allStudents.get(allStudents.size()-1));
					System.out.println(allStudents);
					if(allStudents.get(allStudents.size()-1).getId()==temp.getId()) 
					{	
						courses=allStudents.get(allStudents.size()-1).getCourses();
						System.out.println("Indise 2nd ifs if-else "+courses);
						System.out.println(allStudents.get(allStudents.size()-1));
						if(!courses.contains(course)) 
						{
							courses.add(course);
							allStudents.get(allStudents.size()-1).setCourses(courses);
						}
						System.out.println(allStudents.get(allStudents.size()-1));
						isEntryDone=true;
					}else if(allStudents.get(allStudents.size()-1).getId()!=id) 
					{
						System.out.println("inside 3rd if-else");
						courses=new ArrayList<String>();
						courses.add(course);
//						System.out.println(id);
						allStudents.add(new Student(id,firstName,lastName,email,courses));
						isEntryDone=true;
						break;
					}
					System.out.println("***********End of one oteration****************");
//						else if(x.getId()==id) 
//					{	
//						courses=x.getCourses();
//						courses.add(course);
//						x.setCourses(courses);
//					}
				}
				System.out.println("===================End of while==========================");
				
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
			conn=dataSource.getConnection();
			String sql="DELETE FROM studentnew WHERE (id = ?)";
			stmnt = conn.prepareStatement(sql)        ;
			stmnt.setInt(1, id)	  ;
			stmnt.execute();	
		}
		catch(SQLException e) 	{	e.getMessage();		}
		finally 				{close(conn,stmnt,null);}
	}
	


}
