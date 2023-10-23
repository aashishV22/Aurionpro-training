package com.aurionpro.util; 
 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ArrayList; 
import java.util.List; 
 
import javax.sql.DataSource;

import com.aurionpro.model.Account;
import com.aurionpro.model.Admin; 
import com.aurionpro.model.User; 
 
public class BankDbUtil { 
 
 private DataSource dataSource; 
 
 public BankDbUtil(DataSource dataSource) { 
  this.dataSource = dataSource; 
 } 
 
 public List<Admin> getAllAdmins() throws SQLException { 
  List<Admin> admins = new ArrayList<>(); 
  Connection conn = null; 
  Statement stmt = null; 
  ResultSet result = null; 
  try { 
 
   conn = dataSource.getConnection(); 
   String sql = "select * from admin"; 
   stmt = conn.createStatement(); 
   result = stmt.executeQuery(sql); 
 
   while (result.next()) { 
    int id = result.getInt("id"); 
    String userName = result.getString("user_name"); 
    String password = result.getString("password"); 
    admins.add(new Admin(id, userName, password)); 
   } 
  } catch (SQLException e) { 
   e.printStackTrace(); 
  } finally { 
   close(conn, stmt, result); 
  } 
  return admins; 
 } 
 
 private void close(Connection conn, Statement stmt, ResultSet result) throws SQLException { 
  if (conn != null) { 
   conn.close(); 
  } 
  if (stmt != null) { 
   conn.close(); 
  } 
  if (result != null) { 
   result.close(); 
  } 
 } 
 
  
 public boolean validAdminLogin(Admin ad) throws SQLException { 
  List<Admin>allAdmins = getAllAdmins(); 
  boolean isValid = false; 
  for(Admin x:allAdmins) { 
   if(x.getUserName().equals(ad.getUserName()) && x.getPassword().equals(ad.getPassword())) { 
    isValid=true; 
   } 
  } 
  return isValid; 
 } 
 
 public void addNewUser(User us) throws SQLException { 
  Connection conn = null; 
  PreparedStatement stmt = null; 
 
  try { 
   conn = dataSource.getConnection(); 
   String sql = "insert into users (user_Fname , user_Lname, user_Username , user_password) value (?,?,?,?)"; 
   stmt = conn.prepareStatement(sql); 
 
   stmt.setString(1, us.getFirstName()); 
   stmt.setString(2, us.getLastName()); 
   stmt.setString(3, us.getUserName()); 
   stmt.setString(4,us.getPassword()); 
   stmt.execute(); 
  } catch (SQLException e) { 
   e.printStackTrace(); 
  } finally { 
   close(conn, stmt, null); 
  } 
 } 
 
 public List<User> getAllUsers() throws SQLException 
 { 
  List<User> users = new ArrayList<>(); 
  Connection conn = null; 
  Statement stmt = null; 
  ResultSet result = null; 
  try 
  { 
   conn = dataSource.getConnection(); 
   String sql = "select * from users"; 
   stmt = conn.createStatement(); 
   result = stmt.executeQuery(sql); 
 
   while (result.next()) 
   	{ 
	    int id = result.getInt("user_id"); 
	    String firstName = result.getString("user_Fname"); 
	    String lastName = result.getString("user_Lname"); 
	    String userName = result.getString("user_Username"); 
	    String pass = result.getString("user_password"); 
	    users.add(new User(id, firstName, lastName, userName,pass)); 
   	} 
  } catch (SQLException e) { 
   e.printStackTrace(); 
  } finally { 
   close(conn, stmt, result); 
  } 
  return users; 
  
 }
 
 public List<User> searchStudent(String option, String value) throws SQLException { 
  List<User> users = new ArrayList<>(); 
  Connection conn = null; 
  PreparedStatement stmt = null; 
  ResultSet result = null; 
 
  try { 
 
   conn = dataSource.getConnection(); 
   String sql = "select * from users where user_Fname=?"; 
   switch (option) { 
   case "firstName": 
    sql = "select * from users where user_Fname=?"; 
    break; 
 
   case "lastName": 
    sql = "select * from users where user_Lname=?"; 
    break; 
 
   case "UserName": 
    sql = "select * from users where user_Username =?"; 
    break; 
   case "id": 
    sql = "select * from users where user_id =?"; 
    break; 
 
 
 
   } 
 
   stmt = conn.prepareStatement(sql); 
    
   if(option.equals("id")) { 
    stmt.setInt(1,Integer.parseInt(value)); 
   } 
   stmt.setString(1, value); 
   result =stmt.executeQuery();
   while (result.next()) {    int id = result.getInt("user_id");
   String firstName = result.getString("user_Fname");    String lastName = result.getString("user_Lname");
   String userName = result.getString("user_Username");    User tempUser = new User(id, firstName, lastName, userName);
   users.add(tempUser);   }
 } catch (SQLException e) {
  e.printStackTrace();  } finally {
  close(conn, stmt, result);  }
       System.out.println(users);  return users;
}

public void addNewAccount(String accountType, int accountBalance, int user_id) throws SQLException {
	  Connection conn = null; 
	  PreparedStatement stmt = null; 
	 
	  try { 
	   conn = dataSource.getConnection(); 
	   String sql = "INSERT INTO account (account_type, account_balance, user_id) VALUES (?, ?, ?);"; 
	   stmt = conn.prepareStatement(sql); 
	 
	   stmt.setString(1, accountType); 
	   stmt.setInt(2, accountBalance); 
	   stmt.setInt(3,user_id); 
	   stmt.execute(); 
	  } catch (SQLException e) { 
	   e.printStackTrace(); 
	  } finally { 
	   close(conn, stmt, null); 
	  } 
	}

public List<Account> getAccountById(int user_id) throws SQLException {
	List<Account> accounts=new ArrayList<Account>();
	Connection conn=null;
	PreparedStatement stmnt=null;
	ResultSet result=null;
	try 
	{
		conn=dataSource.getConnection();
		String sql="SELECT account.*,users.user_Fname,users.user_Lname FROM account inner JOIN users on account.user_id = users.user_id where users.user_id= ? ";
		stmnt = conn.prepareStatement(sql);
		stmnt.setInt(1, user_id);
		result = stmnt.executeQuery();
		while(result.next()) {
			int accountNumber= result.getInt("account_number");
			String accountType= result.getString("account_type");
			int accountBalance= result.getInt("account_balance");
			int userId= result.getInt("user_id");
			String firstName=result.getString("user_Fname");
			String lastName=result.getString("user_Lname");
			String fullName=firstName+" "+lastName;
			Account tempAccount= new Account(accountNumber, accountType, accountBalance, userId,fullName);
			accounts.add(tempAccount);
		}
	}catch(SQLException e) {	e.getMessage();				}
	finally 			   {	close(conn,stmnt,result);	}
	
	return accounts;

}

	public void deletUser(int user_id) throws SQLException 
	{
			Connection conn = null; 
		  PreparedStatement stmt = null; 
		 
		  try { 
		   conn = dataSource.getConnection(); 
		   String sql = "DELETE FROM users WHERE (user_id = ?)"; 
		   stmt = conn.prepareStatement(sql); 
		 
		   stmt.setInt(1, user_id); 
		   stmt.execute(); 
		  } catch (SQLException e) { 
		   e.printStackTrace(); 
		  } finally { 
		   close(conn, stmt, null); 
		  } 
		
	}

}