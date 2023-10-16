package com.aurionpro.jdbc;

import java.io.IOException;
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

import com.aurionpro.model.Student;
import com.aurionpro.util.StudentUtil;

/**
 * Servlet implementation class JdbcTest
 */

@WebServlet("/JdbcTest")
public class JdbcTest extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/student-source")
	private DataSource dataSource; 
	private StudentUtil util;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JdbcTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    @Override
	public void init() throws ServletException {
		super.init();
		try 
		{			util=new StudentUtil(dataSource);		}
		catch(Exception e) 
		{			e.getMessage();							}
	
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		List<Student> allStudents= util.getStudents(dataSource);
		request.setAttribute("allNewStudents", allStudents);
		dispatcher.forward(request, response);
		
		
		for(Student x:allStudents) {
			System.out.println(x);
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
