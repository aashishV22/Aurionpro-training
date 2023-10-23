package com.aurionpro.util;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.aurionpro.model.Account;
import com.aurionpro.model.Transaction;
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

	public List<Account> getAccounts(String userName) throws SQLException {
		List<Account> accounts=new ArrayList<Account>();
		Connection conn=null;
		PreparedStatement stmnt=null;
		ResultSet result=null;
		try 
		{
			conn=dataSource.getConnection();
			String sql="SELECT account.*,users.user_Fname,users.user_Lname FROM account inner JOIN users on account.user_id = users.user_id where users.user_Username= ? ";
			stmnt = conn.prepareStatement(sql);
			stmnt.setString(1, userName);
			result = stmnt.executeQuery();
			while(result.next()) {
				int accountNumber= result.getInt("account_number");
				String accountType= result.getString("account_type");
				int accountBalance= result.getInt("account_balance");
				int user_id= result.getInt("user_id");
				String firstName=result.getString("user_Fname");
				String lastName=result.getString("user_Lname");
				String fullName=firstName+" "+lastName;
				Account tempAccount= new Account(accountNumber, accountType, accountBalance, user_id,fullName);
				accounts.add(tempAccount);
			}
		}catch(SQLException e) {	e.getMessage();				}
		finally 			   {	close(conn,stmnt,result);	}
		
		return accounts;
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

	public void depositAmount(int accountNumber, int ammountDeposit, int user_id) throws SQLException {
		List<Account> accounts=new ArrayList<Account>();
		accounts=getAccountById(user_id);
		int total = 0;
		for (Account account : accounts) {
			if(account.getAccountNumber()==accountNumber) {
				total=account.getAccountBalance()+ammountDeposit;
			}
		}
		Connection conn=null;
		PreparedStatement stmnt=null;
		try 
		{
			conn=dataSource.getConnection();
			String sql="UPDATE account SET account_balance = ? WHERE (account_number = ?)";
			stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1,total);
			stmnt.setInt(2, accountNumber);
			stmnt.execute();
			
		}catch(SQLException e) {	e.getMessage();				}
		finally 			   {	close(conn,stmnt,null);	}
	}

	public void addTransaction(Transaction transaction) throws SQLException {
		Connection conn=null;
		PreparedStatement stmnt=null;
		try 
		{
			conn=dataSource.getConnection();
			String sql="INSERT INTO `accountmanagement`.`transaction` (`account_no_sender`, `account_no_receiver`, `transaction_typeid`, `transaction_amount`) VALUES (?, ?, ?, ?)";
			stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1,transaction.getAccount_no_sender());
			stmnt.setInt(2,transaction.getAccount_no_receiver());
			stmnt.setInt(3, transaction.getTransaction_typeID());
			stmnt.setInt(4, transaction.getTransaction_amount());
			stmnt.execute();
			
		}catch(SQLException e) {	e.getMessage();				}
		finally 			   {	close(conn,stmnt,null);	}
	}

	public Account getAccountByNumber(int accountNumber, int user_id) throws SQLException 
	{
		List<Account> accounts=new ArrayList<Account>();
		accounts=getAccountById(user_id);
		Account tempAccount = null;
		for (Account account : accounts) 
		{
			if(account.getAccountNumber()==accountNumber) {
				tempAccount=account;
			}
		}
		return tempAccount;
	}

	public void withdrawAmount(int accountNumber, int ammountWithdraw, int user_id) throws SQLException {
		List<Account> accounts=new ArrayList<Account>();
		accounts=getAccountById(user_id);
		int total = 0;
		for (Account account : accounts) {
			if(account.getAccountNumber()==accountNumber) {
				total=account.getAccountBalance()-ammountWithdraw;
			}
		}
		Connection conn=null;
		PreparedStatement stmnt=null;
		try 
		{
			conn=dataSource.getConnection();
			String sql="UPDATE account SET account_balance = ? WHERE (account_number = ?)";
			stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1,total);
			stmnt.setInt(2, accountNumber);
			stmnt.execute();
			
		}catch(SQLException e) {	e.getMessage();				}
		finally 			   {	close(conn,stmnt,null);	}
		
	}

	public List<Transaction> getSingleAccountTransactions(int accountNumber) throws SQLException {
		List<Transaction> transactions=new ArrayList<Transaction>();
		System.out.println(accountNumber);
		Connection conn=null;
		PreparedStatement stmnt=null;
		ResultSet result=null;
		try 
		{
			conn=dataSource.getConnection();
			String sql="SELECT * FROM transaction WHERE account_no_sender = ? OR account_no_receiver = ?";
			stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, accountNumber);
			stmnt.setInt(2, accountNumber);
			System.out.println(stmnt);
			result = stmnt.executeQuery();
			while(result.next()) {
				int transaction_id	   = result.getInt("transaction_id");
				int account_no_sender  = result.getInt("account_no_sender");
				int account_no_receiver= result.getInt("account_no_receiver");
				int transaction_typeId = result.getInt("transaction_typeId");
				String transactionType=null;
				if(transaction_typeId==300) {
					transactionType="Deposit";
				}else if(transaction_typeId==301) {
					transactionType="Withdrawl";
				}else {
					transactionType="Transfer";
				}
			    Date transaction_time   = result.getTimestamp("transaction_time");
			    int transaction_amount = result.getInt("transaction_amount");
				 
				Transaction tempAccount= new Transaction(transaction_id, account_no_sender, account_no_receiver, transaction_typeId, transaction_time, transaction_amount,transactionType);
				transactions.add(tempAccount);

			}
		}catch(SQLException e) {	e.getMessage();				}
		finally 			   {	close(conn,stmnt,result);	}
		
		return transactions;
	}

	public void transferAmount(int sendersAccountNumber,int receiversAccountNumber, int ammountDeposit) throws SQLException {
		Connection conn=null;
		PreparedStatement stmnt=null;
		PreparedStatement stmnt2=null;
		Account sendersAccount=getByAccntNmbr(sendersAccountNumber);
		System.out.println(sendersAccount);
		Account receiversAccount=getByAccntNmbr(receiversAccountNumber);
		System.out.println(receiversAccount);
		int deduct=sendersAccount.getAccountBalance()-ammountDeposit;
		int total = 0;
			total=receiversAccount.getAccountBalance()+ammountDeposit;
		try 
		{
			conn=dataSource.getConnection();
			String sql="UPDATE account SET account_balance = ? WHERE (account_number = ? )";
			String sql2="UPDATE account SET account_balance = ? WHERE (account_number = ? )";
			stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1,total);
			stmnt.setInt(2,receiversAccountNumber);
			stmnt.execute();

			stmnt2= conn.prepareStatement(sql2);
			stmnt2.setInt(1,deduct);
			stmnt2.setInt(2,sendersAccountNumber);
			stmnt2.execute();
		}catch(SQLException e) {	e.getMessage();				}
		finally 			   {	close(conn,stmnt,null);	}
	}

	private Account getByAccntNmbr(int accountNumber) throws SQLException {
		Connection conn=null;
		PreparedStatement stmnt=null;
		Account account=null;
		ResultSet result=null;
		try 
		{
			conn=dataSource.getConnection();
			String sql="SELECT account.*,users.user_Fname,users.user_Lname FROM account inner JOIN users on account.user_id = users.user_id where account.account_number= ? ";
			stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, accountNumber);
			result = stmnt.executeQuery();
			while(result.next()) {
				int accountNumberReceived= result.getInt("account_number");
				String accountType= result.getString("account_type");
				int accountBalance= result.getInt("account_balance");
				int userId= result.getInt("user_id");
				String firstName=result.getString("user_Fname");
				String lastName=result.getString("user_Lname");
				String fullName=firstName+" "+lastName;
				account= new Account(accountNumberReceived, accountType, accountBalance, userId,fullName);
			}
		}catch(SQLException e) {	e.getMessage();				}
		finally 			   {	close(conn,stmnt,result);	}
		
		return account;
				
	}

	
}
