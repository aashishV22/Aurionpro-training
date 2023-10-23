package com.aurionpro.controller; 
 
import java.io.IOException; 
import java.sql.SQLException; 
import java.util.List; 
 
import javax.annotation.Resource; 
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.sql.DataSource;

import com.aurionpro.util.AccountUtil;
import com.aurionpro.util.BankDbUtil;
import com.aurionpro.model.Account;
import com.aurionpro.model.Admin;
import com.aurionpro.model.Transaction;
import com.aurionpro.model.User; 
 
 
@WebServlet("/UserController") 
public class UserController extends HttpServlet 
{ 
	@Resource(name = "jdbc/employee-source") 
	private DataSource dataSource; 
	private BankDbUtil dbUtil; 
	private AccountUtil util;

    @Override 
    public void init() throws ServletException
    { 
    	super.init(); 
    	dbUtil = new BankDbUtil(dataSource);
    	util   = new AccountUtil(dataSource);
    	
    } 
 
    public UserController() {	super();	} 
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 	{ 
    	String command = request.getParameter("action"); 
    	System.out.println(command);
		if (command == null) {		command = "list"; 	} 
		switch(command) 
		{ 
			case "list": 
				try {	list(request,response);			} 
														  catch (ServletException | IOException e1) {	e1.printStackTrace();	} 
			break; 
			case "validateAdmin": 
				try {	validateAdmin(request,response);		}										  
														  catch (ServletException e) {e.printStackTrace();} 
													  	  catch (IOException  e) 	 {e.printStackTrace();} 
													  	  catch (SQLException e)	 {e.printStackTrace();}	
			break;
			case "showUsers": 
				try {	showUsers(request,response);		}										  
														  catch (ServletException e) {e.printStackTrace();} 
													  	  catch (IOException  e) 	 {e.printStackTrace();} 
													  	  catch (SQLException e)	 {e.printStackTrace();}	
			break;
			case "add": 
				try {	addUser(request,response);				}										  
													  	  catch (IOException  e) 	 {e.printStackTrace();} 
													  	  catch (SQLException e)	 {e.printStackTrace();}	
			break;
			case "addAccount":
				try {	addAccount(request,response); 			} 
			 											  catch (IOException e) 	 {e.printStackTrace();} 
			break;
			case "addingAccount":
				try {	addingAccount(request,response);		}										  
														  catch (ServletException e) {e.printStackTrace();} 
													  	  catch (IOException  e) 	 {e.printStackTrace();} 
													  	  catch (SQLException e)	 {e.printStackTrace();}	
			break;
			case "gotoAccount":
				try {	gotoAccount(request, response);		}
														  catch (SQLException e1)    {e1.printStackTrace();}
				break;
			case "gotoSingleAccountTransaction":
				try {	getSingleAccountTransactions(request, response);		}
														  catch (SQLException e1)    {e1.printStackTrace();}
				break;
			case "deleteUser":
				try {deleteUser(request, response);} catch (SQLException e1) {	e1.printStackTrace();
			}
				break;

			case "search":
				try {	search(request,response);				}										  
														  catch (ServletException e) {e.printStackTrace();} 
													  	  catch (IOException  e) 	 {e.printStackTrace();} 
													  	  catch (SQLException e)	 {e.printStackTrace();}	
			break;
		} 
 	} 
 

	private void addingAccount(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException 
    {
    	int user_id		  = Integer.parseInt(request.getParameter("userId"));
		int accountBalance= Integer.parseInt(request.getParameter("accountBalance"));
    	String accountType= request.getParameter("accountType");
		dbUtil.addNewAccount(accountType,accountBalance,user_id);
		List<User> allUsers = dbUtil.getAllUsers();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/showUsers/showUsers.jsp"); 
		request.setAttribute("allUsers", allUsers); 
		dispatcher.forward(request, response); 
    }

    private void addAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
		int allUsers=Integer.parseInt(request.getParameter("id"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/showUsers/addAccount/addAccount.jsp"); 
		request.setAttribute("allUsers", allUsers ); 
		dispatcher.forward(request, response); 
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException 
    { 
    	String value  = request.getParameter("searchValue"); 
    	String option = request.getParameter("searchOption"); 
    	List<User> allUsers = dbUtil.searchStudent(option, value); 
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/showUsers/showUsers.jsp"); 
    	request.setAttribute("allUsers", allUsers); 
    	dispatcher.forward(request, response); 
    } 
 
    private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException 
    {
    	String fName = request.getParameter("firstName");
    	String lName = request.getParameter("lastName"); 
    	String uName = request.getParameter("userName"); 
    	String pass  = request.getParameter("password"); 
    	User us = new User(fName, lName, uName, pass); 
    	dbUtil.addNewUser(us); 
    	showUsers(request,response); 
    	response.sendRedirect(request.getContextPath() + "/UserController"); 
    } 
 
    private void validateAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException 
    { 
    	String uName= request.getParameter("uname"); 
    	String pass = request.getParameter("password"); 
    	Admin ad 	= new Admin(uName, pass); 
    	if(dbUtil.validAdminLogin(ad)) 
    	{ 
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/showAdmins.jsp"); 
    		List<Admin> allAdmins = dbUtil.getAllAdmins(); 
    		request.setAttribute("uName", uName); 
    		request.setAttribute("allAdmins", allAdmins); 
    		dispatcher.forward(request, response); 
    	}else
    	{ 
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/userLogin.jsp"); 
    		dispatcher.forward(request, response); 
    	} 
    } 
 
    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    { 
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/home.jsp"); 
    	dispatcher.forward(request, response); 
    } 

 	private void showUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
 	{ 
	  RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/showUsers/showUsers.jsp"); 
	  List<User> allUsers = dbUtil.getAllUsers(); 
	  request.setAttribute("allUsers", allUsers); 
	  dispatcher.forward(request, response); 
	 } 
 	
 	private void gotoAccount(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int user_id		       = Integer.parseInt(request.getParameter ("userId"));
		System.out.println("Inside gotoAccount :"+user_id);
		List<Account> allAccounts = dbUtil.getAccountById(user_id);
		String userWholeName = null;
		List<User> allUsers=util.getUsers(dataSource);
		for (User user : allUsers) {
			if(user.getUser_id()==user_id){
				userWholeName=user.getFirstName()+" "+user.getLastName();
			}
		}
		response.sendRedirect(request.getContextPath()+"/admin/showUsers/showAccount/singleUserAccounts.jsp");
		request.getSession().setAttribute("allAccounts", allAccounts);
		request.getSession().setAttribute("userName", userWholeName);
		request.getSession().setAttribute("userId", user_id);
	}
 	
 	private void getSingleAccountTransactions(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int user_id		       = Integer.parseInt(request.getParameter ("id"));
		int accountNumber      = Integer.parseInt(request.getParameter ("number"));
		System.out.println(accountNumber);
		List<Transaction> transactions=util.getSingleAccountTransactions(accountNumber);
		String userWholeName = null;
		List<User> allUsers=util.getUsers(dataSource);
		for (User user : allUsers) {
			if(user.getUser_id()==user_id){
				userWholeName=user.getFirstName()+" "+user.getLastName();
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/showUsers/showAccount/transactions/transactions.jsp");
		request.getSession().setAttribute("transactions", transactions);
		request.getSession().setAttribute("userName", userWholeName);
		request.getSession().setAttribute("userId", user_id);
		request.getSession().setAttribute("action", "showUsers");
		dispatcher.forward(request, response);
	}
 	
 	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int user_id		       = Integer.parseInt(request.getParameter ("userId"));
		dbUtil.deletUser(user_id);
		showUsers(request, response);
	}

	 
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
 	{	doGet(request, response);	} 
	
}