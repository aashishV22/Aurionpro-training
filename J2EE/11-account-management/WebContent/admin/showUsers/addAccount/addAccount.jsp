<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%> 
<%@page import="com.aurionpro.model.Admin"%>

<!DOCTYPE html> 
<html> 
<head> 
<meta charset="ISO-8859-1"> 
<title>Insert title here</title> 
</head> 
<body> 
<%
	Admin ad = (Admin) session.getAttribute("ad");
	if(ad==null){
	 response.sendRedirect("userLogin.jsp");}
%>

 <form action="UserController" > 
  
  <div class="col m-3"> 
   <label for="exampleInputName">Account Type</label> 
   
   <div class="container">
		<label for="accountType">Select Account Type:</label>
        <select id="accountType" name="accountType">
        	<option value="saving">Saving</option>
        	<option value="current">Current</option>
        </select>
	</div>
	</div>
 
  <div class="form-group m-3"> 
   <label for="exampleInputEmail1">Account Balance</label> <input 
    type="text" class="form-control" name="accountBalance" 
    placeholder="Enter balance"> 
 
  </div> 
 
 	<input type="hidden" name="userId" value="${allUsers}"></input> 
    <input type="hidden" name="action" value="addingAccount"></input> 
  <button type="submit" class="btn btn-primary m-3">Add Account</button> 
 </form> 
 
 
 
 <link 
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
  rel="stylesheet" 
  integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" 
  crossorigin="anonymous"> 
 <script 
  src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
  integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
  crossorigin="anonymous"></script> 
</body> 
</html>