package com.aurionpro.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import com.aurionpro.model.User;

public class AccountUtil 
{
	private DataSource dataSource;

	public AccountUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public List<User> getUsers(DataSource dataSource) throws SQLException {
		List<User> allUsers=new ArrayList<>();
		Connection conn=null;
		Statement stmnt=null;
		ResultSet result=null;
		try 
		{
			conn=dataSource.getConnection();
			String sql="select * from users";
			stmnt = conn.createStatement();
			result = stmnt.executeQuery(sql);
			while(result.next()) {
				int user_id= result.getInt("user_id");
				String firstName= result.getString("user_Fname");
				String lastName = result.getString("user_Lname");
				String userName= result.getString("user_Username");
				String password= result.getString("user_password");
				User tempUser=new User(user_id, firstName, lastName, userName, password);
				allUsers.add(tempUser);
				
			}
		}catch(SQLException e) {	e.getMessage();				}
		finally 			   {	close(conn,stmnt,result);	}
		return allUsers;
	}
	

	private void close(Connection conn, Statement stmnt, ResultSet result) throws SQLException 
	{
		if(conn!=null) 		{	conn.close();		};
		if(stmnt!=null) 	{	stmnt.close();		};
		if(result!=null) 	{	result.close();		};
	}

	public boolean checkUser(String userName, String password) throws SQLException {
		List<User> allUsers= getUsers(this.dataSource);
		boolean isUser=false;
		for (User user : allUsers) {
			if(user.getUserName().equals(userName) && user.getPassword().equals(password)) {
				isUser=true;
			}
		}
		return isUser;
	}
	
}
