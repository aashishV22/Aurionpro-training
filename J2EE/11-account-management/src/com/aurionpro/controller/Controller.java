package com.aurionpro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.aurionpro.model.User;
import com.aurionpro.util.AccountUtil;


/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/employee-source")
	private DataSource dataSource; 
	private AccountUtil util;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
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
//		System.out.println(actionParameter);
		if(actionParameter==null) {
			actionParameter="gotUsers";
		}
		switch(actionParameter) 
		{
		case "gotUsers":
			try {	gotUsers(request,response);		}										  
													  catch (ServletException e) {e.printStackTrace();} 
													  catch (IOException e) 	 {e.printStackTrace();} 
													  catch (SQLException e)	 {e.printStackTrace();}	
			break;
			
		case "login":
			try {	checkUser(request,response);		}										  
													  catch (ServletException e) {e.printStackTrace();} 
												  	  catch (IOException e) 	 {e.printStackTrace();} 
												  	  catch (SQLException e)	 {e.printStackTrace();}	
			break;
			
		default :
			try	{	gotUsers(request,response);	} 	  catch (ServletException | IOException | SQLException e) {e.printStackTrace();}	
		}		
	}

	private void checkUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String userName = request.getParameter("uname");
		String password = request.getParameter("password");
		boolean isUser  = util.checkUser(userName,password);
		if(isUser) {
			
//			response.sendRedirect(request.getContextPath()+"/singleUser.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/singleUser.jsp");
			dispatcher.forward(request, response);


			System.out.println("its right");
		}else {
			System.out.println("its wrong");

			response.sendRedirect(request.getContextPath()+"/userLogin.jsp");
			response.setContentType("text/html");
			PrintWriter out1 = response.getWriter();
			out1.println("<p>wrong Password </p>");

		}
	}
	private void gotUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		List<User> allUsers    = util.getUsers(dataSource);
		System.out.println(allUsers);
		request.setAttribute("allUsers", allUsers);
		dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
