<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
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
 <link 
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
  rel="stylesheet" 
  integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" 
  crossorigin="anonymous"> 
 <script 
  src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
  integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
  crossorigin="anonymous"></script> 
<body> 
<%
	Admin ad = (Admin) session.getAttribute("ad");
	if(ad==null){
	 response.sendRedirect("userLogin.jsp");}
%>
<ul>
<div class="button-container container">
 	<li><form action="UserController" method="post">		
			<input type="hidden" name="action" value="showUsers">
	    	<button class="active">Home</button>
	     </form>
	</li>
	<li><form action="UserController">
			<input type="hidden" name="action" value="logOutClicked">
	    	<button>LogOut</button></form>
	</li>
</div>
</ul>
<div class="container"> 
<br><br> 
<h1>All Users of Bank App</h1> 
  <Form action="UserController"> 
   <div class="input-group mb-3 mt-5"> 
    <input type="text" class="form-control" name="searchValue" 
     placeholder="Search" aria-label="Recipient's username" 
     aria-describedby="basic-addon2"> 
    <div class="input-group-append"> 
     <input type="hidden" name="action" value="search"></input> 
     <div> 
      <select class="form-select m-3" name="searchOption"> 
       <option value="firstName">First Name</option> 
       <option value="lastName">Last Name</option> 
       <option value="UserName">User Name</option> 
       <option value="id">Id</option> 
      </select> 
     </div> 
     </div> 
   </div> 
     <button type="submit" class="btn btn-outline-success m-2" 
      type="button">Search</button> 
     
  </Form> 
 </div> 
 <div class="container"> 
 <table class="table table-striped"> 
  <thead> 
   <tr> 
    <th>id</th> 
    <th>First name</th> 
    <th>Last name</th> 
    <th>Username</th> 
    <th>Action</th> 
   </tr> 
  </thead> 
 
  <c:forEach var="allUsers" items="${allUsers}"> 
   <tr> 
    <td>${allUsers.user_id}</td> 
    <td>${allUsers.firstName}</td> 
    <td>${allUsers.lastName}</td> 
    <td>${allUsers.userName}</td> 
    <td><div class="button-container">
    	<form action="UserController" method="post">
    		<input type="hidden" name="action" value="addAccount">
    		<input type="hidden" name="id" value="${allUsers.user_id}">
    		<button class="btn btn-primary btn-sm">Add Account Details</button>
    	</form>
    	<form action="UserController" method="post">
    		<input type="hidden" name="action" value="gotoAccount"> 
    		<input type="hidden" name="userId" value="${allUsers.user_id}">
    		<button class="btn btn-success btn-sm">Show Accounts </button>
    	</form>
		<form action="UserController" >
    		<input type="hidden" name="action" value="deleteUser">
    		<input type="hidden" name="userId" value="${allUsers.user_id}">
    		<button class="btn btn-danger btn-sm">Delete User </button>
    	</form>
    	<%-- <form action="UserController" method="post">
<!--     		<input type="hidden" name="action" value="updateUser">
 -->    		<input type="hidden" name="userId" value="${allUsers.user_id}">
    		<button class="btn btn-info btn-sm">Update User </button>
    	</form> --%>	
    	</div>
    	</td> 
   </tr> 
  </c:forEach> 
 
 </table> 
  <a href="admin/add-user.jsp" class="btn btn-info m-3">Add User</a> 
 
 </div> 
</body> 
</html>