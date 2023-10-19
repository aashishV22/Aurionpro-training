package com.aurionpro.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.aurionpro.model.Employee;

public class EmployeeUtil {

	private DataSource dataSource;

	public EmployeeUtil(DataSource datasource) {
		super();
		this.dataSource = datasource;
	}
	public List<Employee> getStudents(DataSource dataSource) throws SQLException
	{
		List<Employee> allEmployees=new ArrayList<>();
		Connection conn=null;
		Statement stmnt=null;
		ResultSet result=null;
		try 
		{
			conn=dataSource.getConnection();
			String sql="select * from employee";
			stmnt = conn.createStatement();
			result = stmnt.executeQuery(sql);
			while(result.next()) {
				int    id        = result.getInt("employee_id");
				String firstName = result.getString("employee_Fname");
				String lastName  = result.getString("employee_Lname");
				String email     = result.getString("employee_email");
				Date   dob		 = result.getDate("employee_dob");
				Date   doj		 = result.getDate("employee_doj");
				Employee temp=new Employee(id, firstName, lastName, email,dob,doj);
				allEmployees.add(temp);
			}
		}catch(SQLException e) {	e.getMessage();				}
		finally 			   {	close(conn,stmnt,result);	}
		return allEmployees;
	}

	private void close(Connection conn, Statement stmnt, ResultSet result) throws SQLException 
	{
		if(conn!=null) 		{	conn.close();		};
		if(stmnt!=null) 	{	stmnt.close();		};
		if(result!=null) 	{	result.close();		};
	}
	
	public void addEmployee(Employee employee) throws SQLException {
		Connection conn=null;
		PreparedStatement stmnt=null;
		try 
		{
			conn=dataSource.getConnection();
			String sql="insert into employee (employee_Fname,employee_Lname,employee_email,employee_dob,employee_doj) values (?,?,?,?,?) ";
			stmnt = conn.prepareStatement(sql)        ;
			stmnt.setString(1, employee.getFirstName());
			stmnt.setString(2, employee.getLastName()) ;
			stmnt.setString(3, employee.getEmail())	  ;
			stmnt.setDate(4, new java.sql.Date(employee.getDob().getTime()))	  ;
			stmnt.setDate(5, new java.sql.Date(employee.getDoj().getTime()))	  ;
			System.out.println(stmnt);
			stmnt.execute();
			
		}catch(SQLException e) 	{	e.getMessage();		}
		finally 				{close(conn,stmnt,null);}
	}

}
