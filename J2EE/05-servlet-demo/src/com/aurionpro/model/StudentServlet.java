package com.aurionpro.model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			System.out.println("hello student");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String degree = request.getParameter("degree");
			String gender = request.getParameter("gender");
			String[] subjects=request.getParameterValues("subject");
			for(int i=0;i<subjects.length;i++){
				System.out.print(subjects[i]+",");
			}
	
			PrintWriter out1 = response.getWriter();
			out1.println("<h1>name: "+name  +"</h1>");
			out1.println("<h2>email: "+email  +"</h2>");
			out1.println("<h1>degree: ");
			for(int i=0;i<subjects.length;i++){
				out1.print(subjects[i]+",");
			}
			out1.println("</h1>");
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
