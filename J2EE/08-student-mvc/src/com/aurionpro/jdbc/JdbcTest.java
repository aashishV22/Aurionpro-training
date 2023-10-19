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
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String actionParameter = request.getParameter("action");
//		System.out.println(actionParameter);
		if(actionParameter==null) {
			actionParameter="list";
		}
		switch(actionParameter) 
		{
		case "list":
			try {	gotStudents(request,response);		}										  
													  catch (ServletException e) {e.printStackTrace();} 
													  catch (IOException e) 	 {e.printStackTrace();} 
													  catch (SQLException e)	 {e.printStackTrace();}	
			break;

		case "add":
			try {	addNewStudent(request,response);	}
													  catch (SQLException e) {e.printStackTrace();}
			break;
		
		case "update":
			try	{	getStudentForUpdate(request,response);}
													  catch (SQLException e1) {e1.printStackTrace();}
			break;
		case "delete":
			try	{	deleteStudent(request,response);}
													  catch (SQLException e1) {e1.printStackTrace();}
			break;	
		case "updated":
			try {	updateStudent(request,response);	}
													  catch (Exception e1) {e1.printStackTrace();}
			break;
		case "search":
			try {	searchStudent(request,response);	}
													  catch (Exception e1) {e1.printStackTrace();}
			break;
		default :
			try	{	gotStudents(request,response);	} catch (ServletException | IOException | SQLException e) {e.printStackTrace();}	
		}
		
		
	}

	private void searchStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String value=request.getParameter("searchName");
		String columnName=request.getParameter("columnName");
		List<Student> searched=new ArrayList<Student>();
//		if(columnName=="id") {
//			int searchId=Integer.parseInt(value);
//			System.out.println("inside id if"+searchId);
//			Student searchedById= util.getStudentById(searchId);
//			searched.add(searchedById);
//		}
		if(value=="") {
			response.sendRedirect(request.getContextPath()+"/JdbcTest");
		}
//		System.out.println(name);
		searched= util.search(value,columnName);
//		System.out.println("inside controller"+searched);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		request.setAttribute("allNewStudents", searched);
		dispatcher.forward(request, response);
	
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("Inside controller"+id);
		util.deleteStudent(id);
		response.sendRedirect(request.getContextPath()+"/JdbcTest");
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int id=Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName  = request.getParameter("lastName");
		String email     = request.getParameter("email");
		Student updatedStudent = new Student(id, firstName, lastName, email);
		util.updateStudent(updatedStudent);
//		System.out.println(updatedStudent);
		response.sendRedirect(request.getContextPath()+"/JdbcTest");
//		gotStudents(request, response);
	}

	private void getStudentForUpdate(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Student student=util.getStudentById(id);
//		System.out.println(student);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-studentForm.jsp");
		request.setAttribute("particularStudent", student);
		dispatcher.forward(request, response);
	}

	private void gotStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		List<Student> allStudents    = util.getStudents(dataSource);
//		System.out.println(allStudents);
		request.setAttribute("allNewStudents", allStudents);
		dispatcher.forward(request, response);
	}
	
	
	private void addNewStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName  = request.getParameter("lastName");
		String email     = request.getParameter("email");
		Student student  = new Student(firstName,lastName,email);
		
		util.addStudent(student);
//		System.out.println(student);
		response.sendRedirect(request.getContextPath()+"/JdbcTest");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
