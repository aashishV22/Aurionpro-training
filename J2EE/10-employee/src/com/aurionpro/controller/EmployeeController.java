package com.aurionpro.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.text.ParseException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.aurionpro.model.Employee;
import com.aurionpro.util.EmployeeUtil;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/student-source")
	private DataSource dataSource; 
	private EmployeeUtil util;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    @Override
	public void init() throws ServletException {
		super.init();
		try 
		{			util=new EmployeeUtil(dataSource);		}
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
			try {	gotEmployee(request,response);		}										  
													  catch (ServletException e) {e.printStackTrace();} 
													  catch (IOException e) 	 {e.printStackTrace();} 
													  catch (SQLException e)	 {e.printStackTrace();}	
			break;

		case "add":
			try {	addNewEmployee(request,response);	}
													  catch (SQLException e) {e.printStackTrace();}
			break;
//		
//		case "update":
//			try	{	getEmployeeForUpdate(request,response);}
//													  catch (SQLException e1) {e1.printStackTrace();}
//			break;
//		case "delete":
//			try	{	deleteEmployee(request,response);}
//													  catch (SQLException e1) {e1.printStackTrace();}
//			break;	
//		case "updated":
//			try {	updateEmployee(request,response);	}
//													  catch (Exception e1) {e1.printStackTrace();}
//			break;
//		case "search":
//			try {	searchEmployee(request,response);	}
//													  catch (Exception e1) {e1.printStackTrace();}
//			break;
		default :
			try	{	gotEmployee(request,response);	} catch (ServletException | IOException | SQLException e) {e.printStackTrace();}	
		}
		
		
	}

	private void gotEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		List<Employee> allEmployees    = util.getStudents(dataSource);
//		System.out.println(allStudents);
		request.setAttribute("allEmployees", allEmployees);
		dispatcher.forward(request, response);
	}
	
	private void addNewEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName  = request.getParameter("lastName");
		String email     = request.getParameter("email");
		String dob		 = request.getParameter("dob");
		String doj		 = request.getParameter("doj");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOfBirth  = null;
		Date dateOfJoining=null;
		try {
            dateOfBirth = formatter.parse(dob);
            dateOfJoining = formatter.parse(doj);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		Employee employee  = new Employee(firstName, lastName, email, dateOfBirth, dateOfJoining);
		
		util.addEmployee(employee);
//		System.out.println(student);
		response.sendRedirect(request.getContextPath()+"/EmployeeController");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
