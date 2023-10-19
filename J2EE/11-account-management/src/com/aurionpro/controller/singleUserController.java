package com.aurionpro.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
