<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%> 
<%@page import="com.aurionpro.model.Admin"%>
<!DOCTYPE html> 
<html> 
<head> 
<style>
table, th, td {
  border:1px solid black;
}
ul {
  overflow: hidden;
  background-color: #333;
}

.active {
  background-color: #04AA6D;
}
.button-container {
    display: flex;
    justify-content: space-between;
    flex-wrap:wrap;
  }
</style>

<meta charset="ISO-8859-1"> 
<title>Insert title here</title> 
</head> 
<body> 
<ul>
<div class="button-container container">
 	<li><form action="../UserController" method="post">		
			<input type="hidden" name="action" value="showUsers">
	    	<button class="active">Home</button>
	     </form>
	</li>
	<li><form action="../UserController">
			<input type="hidden" name="action" value="logOutClicked">
	    	<button>LogOut</button></form>
	</li>
</div>
</ul>

<%
	Admin ad = (Admin) session.getAttribute("ad");
	if(ad==null){
	 response.sendRedirect("../userLogin.jsp");}
%>
 <form action="../UserController" method="post"> 
  <div class="form-group m-3"> 
   <label for="exampleInputEmail1">First Name</label> 
   <input type="text" class="form-control" name="firstName" placeholder="First name" required> 
 
  </div> 
  <div class="col m-3"> 
   <label for="exampleInputName">Last Name</label> 
   <input type="text" class="form-control" name="lastName" placeholder="Last name" required> 
  </div> 
 
  <div class="form-group m-3"> 
   <label for="exampleInputEmail1">User Name</label> 
   <input type="text" class="form-control" name="userName" 
   id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="User name" required> 
 
  </div> 
   <div class="form-group m-3"> 
    <label for="exampleInputPassword1">Password</label> 
    <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required> 
  </div> 
 
  <input type="hidden" name="action" value="add"></input> 
  <button type="submit" class="btn btn-primary m-3">Add User</button> 
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