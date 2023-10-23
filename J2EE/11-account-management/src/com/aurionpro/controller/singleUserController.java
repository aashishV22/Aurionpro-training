package com.aurionpro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.aurionpro.model.Account;
import com.aurionpro.model.Transaction;
import com.aurionpro.model.User;
import com.aurionpro.util.AccountUtil;

/**
 * Servlet implementation class singleUserController
 */
@WebServlet("/singleUserController")
public class singleUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/employee-source")
	private DataSource dataSource; 
	
	private AccountUtil util;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public singleUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
   	public void init() throws ServletException {
   		super.init();
   		try 
   		{			util=new AccountUtil(dataSource);		}
   		catch(Exception e) 
   		{			e.getMessage();							}
   	
   	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionParameter = request.getParameter("action");
		if(actionParameter==null) {
			actionParameter="login";
		}
		switch(actionParameter) 
		{
		case "validateAdmin":
			RequestDispatcher dispatcher = request.getRequestDispatcher("UserController");
			request.getSession().setAttribute("action", actionParameter);
			dispatcher.forward(request, response);
			break;
		case "login":
			try {	checkUser(request,response);		}										  
													  catch (ServletException e) {e.printStackTrace();} 
												  	  catch (IOException  e) 	 {e.printStackTrace();} 
												  	  catch (SQLException e)	 {e.printStackTrace();}	
			break;
		case "depositButton":
			try {	deposit(request,response);		}										  
													  catch (ServletException e) {e.printStackTrace();} 
												  	  catch (IOException  e) 	 {e.printStackTrace();} 
													  catch (SQLException e) 	 {e.printStackTrace();} 
			break;
		case "withdrawButton":
			try {	withdraw(request,response);		}										  
													  catch (ServletException e) {e.printStackTrace();} 
												  	  catch (IOException  e) 	 {e.printStackTrace();} 
													  catch (SQLException e) 	 {e.printStackTrace();} 
			break;
		case "transferButton":
			try {	transfer(request,response);		}										  
													  catch (ServletException e) {e.printStackTrace();} 
												  	  catch (IOException  e) 	 {e.printStackTrace();} 
													  catch (SQLException e) 	 {e.printStackTrace();} 
			break;
		case "withdrawClicked":
			try {	finalWithdraw(request,response);		}										  
													  catch (ServletException e) {e.printStackTrace();} 
												  	  catch (IOException  e) 	 {e.printStackTrace();} 
													  catch (SQLException e) 	 {e.printStackTrace();} 
			break;
		case "deposited":
			try {	finalDeposit(request,response);		}										  
													  catch (ServletException e) {e.printStackTrace();} 
		  	  										  catch (IOException  e) 	 {e.printStackTrace();} 
													  catch (SQLException e) 	 {e.printStackTrace();} 
			break;
		case "transferClicked":
			try {	finalTransfer(request,response);		}										  
													  catch (IOException  e) 	 {e.printStackTrace();} 
													  catch (SQLException e) 	 {e.printStackTrace();} 
			break;
		case "gotoSingleAccountTransaction":
			try {	getSingleAccountTransactions(request, response);		}
													  catch (SQLException e1)    {e1.printStackTrace();}
			break;
		case "gotoAccount":
			try {	gotoAccount(request, response);		}
													  catch (SQLException e1)    {e1.printStackTrace();}
			break;
		default :
			try	{	checkUser(request, response);		} 	  
													  catch (SQLException e)	 {e.printStackTrace();}	
		}		
	}

	


	private void finalTransfer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int ammountDeposit     = Integer.parseInt(request.getParameter("amount"));
		int sendersAccountNumber = Integer.parseInt(request.getParameter("sendersAccountNumber"));
		int receiversAccountNumber = Integer.parseInt(request.getParameter("receiversAccountNumber"));
		int user_id= Integer.parseInt(request.getParameter("userId"));
		int transaction_typeID = Integer.parseInt(request.getParameter("transactioType_id"));
		Transaction transaction=new Transaction(sendersAccountNumber, receiversAccountNumber, transaction_typeID, ammountDeposit);
		util.addTransaction(transaction);
		util.transferAmount(sendersAccountNumber,receiversAccountNumber,ammountDeposit);
		gotoAccount(request, response);
	}

	private void transfer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int user_id		   = Integer.parseInt(request.getParameter("id"));
		String accountType = request.getParameter("transactioType_id");
		int sendersAccountNumber  = Integer.parseInt(request.getParameter("number"));
		String userWholeName = null;
		List<User> allUsers=util.getUsers(dataSource);
		for (User user : allUsers) {
			if(user.getUser_id()==user_id){
				userWholeName=user.getFirstName()+" "+user.getLastName();
			}
		}
		Account tempAccount=util.getAccountByNumber(sendersAccountNumber, user_id);
		System.out.println(tempAccount);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user/transfer.jsp");
		request.getSession().setAttribute("Account", tempAccount);
		request.setAttribute("userName", userWholeName);
		System.out.println(user_id);
		dispatcher.forward(request, response);
				
	}

	private void getSingleAccountTransactions(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int user_id		       = Integer.parseInt(request.getParameter ("id"));
		int accountNumber      = Integer.parseInt(request.getParameter ("number"));
		List<Transaction> transactions=util.getSingleAccountTransactions(accountNumber);
		String userWholeName = null;
		List<User> allUsers=util.getUsers(dataSource);
		for (User user : allUsers) {
			if(user.getUser_id()==user_id){
				userWholeName=user.getFirstName()+" "+user.getLastName();
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user/transactions.jsp");
		request.getSession().setAttribute("transactions", transactions);
		request.getSession().setAttribute("userName", userWholeName);
		request.getSession().setAttribute("userId", user_id);
		request.getSession().setAttribute("action", "gotoAccount");

		dispatcher.forward(request, response);
		
	}

	private void finalWithdraw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int ammountWithdraw     = Integer.parseInt(request.getParameter("amount"));
		int accountNumber      = Integer.parseInt(request.getParameter ("accountNumber"));
		int user_id		       = Integer.parseInt(request.getParameter ("user_id"));
		int transaction_typeID = Integer.parseInt(request.getParameter ("transactioType_id"));
		Transaction transaction=new Transaction(accountNumber, accountNumber, transaction_typeID, ammountWithdraw);
		System.out.println("inside final Withdraw "+transaction);
		util.addTransaction(transaction);
		util.withdrawAmount(accountNumber,ammountWithdraw,user_id);
		getAccounts(request, response, user_id);
	}
	
	
	private void withdraw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int user_id		   = Integer.parseInt(request.getParameter("id"));
		String accountType = request.getParameter("transactioType_id");
		int accountNumber  = Integer.parseInt(request.getParameter("number"));
		String userWholeName = null;
		List<User> allUsers=util.getUsers(dataSource);
		for (User user : allUsers) {
			if(user.getUser_id()==user_id){
				userWholeName=user.getFirstName()+" "+user.getLastName();
			}
		}
		Account tempAccount=util.getAccountByNumber(accountNumber, user_id);
		System.out.println(tempAccount);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user/withdraw.jsp");
		request.getSession().setAttribute("Account", tempAccount);
		request.setAttribute("userName", userWholeName);
		dispatcher.forward(request, response);
		
	}
	
	private void finalDeposit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int ammountDeposit     = Integer.parseInt(request.getParameter("amount"));
		int accountNumber      = Integer.parseInt(request.getParameter("accountNumber"));
		int user_id		       = Integer.parseInt(request.getParameter("userId"));
		int transaction_typeID = Integer.parseInt(request.getParameter("transactioType_id"));
		
		Transaction transaction=new Transaction(accountNumber, accountNumber, transaction_typeID, ammountDeposit);
		System.out.println(user_id);
		System.out.println(transaction);
		util.addTransaction(transaction);
		util.depositAmount(accountNumber,ammountDeposit,user_id);
		gotoAccount(request, response);
	}

	
	private void deposit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int user_id		   = Integer.parseInt(request.getParameter("id"));
		String accountType = request.getParameter("transactioType_id");
		int accountNumber  = Integer.parseInt(request.getParameter("number"));
		String userWholeName = null;
		List<User> allUsers=util.getUsers(dataSource);
		for (User user : allUsers) {
			if(user.getUser_id()==user_id){
				userWholeName=user.getFirstName()+" "+user.getLastName();
			}
		}
		Account tempAccount=util.getAccountByNumber(accountNumber, user_id);
		System.out.println(tempAccount);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user/deposit.jsp");
		request.getSession().setAttribute("Account", tempAccount);
		request.setAttribute("userName", userWholeName);

		dispatcher.forward(request, response);
		
	}

	private void checkUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String userName = request.getParameter("uname");
		String password = request.getParameter("password");
		String userWholeName = null;
		boolean isUser  = util.checkUser(userName,password);
		List<Account> allAccounts=new ArrayList<>();
		if(isUser) {
			List<User> allUsers=util.getUsers(dataSource);
			for (User user : allUsers) {
				if(user.getUserName().equals(userName)) {
					userWholeName=user.getFirstName()+" "+user.getLastName();
				}
			}
			allAccounts=util.getAccounts(userName);
			int id=allAccounts.get(allAccounts.size()-1).getUser_id();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/singleUser.jsp");
			request.setAttribute("userName", userWholeName);
			request.setAttribute("allAccounts", allAccounts);
			request.setAttribute("userId", id);
			dispatcher.forward(request, response);
		}else {
			System.out.println ("wrong password");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/userLogin.jsp");
			response.setContentType("text/html");
			PrintWriter out1 = response.getWriter();
			out1.println("<p>wrong Password </p>");
			dispatcher.forward(request, response);
		}
	}
	
	private void getAccounts(HttpServletRequest request, HttpServletResponse response,int user_id) throws SQLException, ServletException, IOException {
		List<Account> allAccounts=new ArrayList<>();
		allAccounts =util.getAccountById(user_id);
		System.out.println("inside get Accounts"+allAccounts);
		response.sendRedirect(request.getContextPath()+"/singleUser.jsp");
		request.getSession().setAttribute("allAccounts", allAccounts);
		request.getSession().setAttribute("userId", user_id);
	}
	
	private void gotoAccount(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int user_id		       = Integer.parseInt(request.getParameter ("userId"));
		System.out.println("Inside gotoAccount :"+user_id);
		List<Account> allAccounts = util.getAccountById(user_id);
		String userWholeName = null;
		List<User> allUsers=util.getUsers(dataSource);
		for (User user : allUsers) {
			if(user.getUser_id()==user_id){
				userWholeName=user.getFirstName()+" "+user.getLastName();
			}
		}
		response.sendRedirect(request.getContextPath()+"/singleUser.jsp");
		request.getSession().setAttribute("userName", userWholeName);
		request.getSession().setAttribute("allAccounts", allAccounts);
		request.getSession().setAttribute("userId", user_id);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
