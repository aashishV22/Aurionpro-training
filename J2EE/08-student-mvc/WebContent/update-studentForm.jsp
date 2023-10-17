<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Inside Update-Students-Form</h1>
<div>
	<form class="form" action="JdbcTest">
		<br><br>
		<label for="firstName">First Name:</label>
  		<input type="text" id="firstName" name="firstName" value="${particularStudent.firstName}"><br><br>

		<label for="lastName">Last Name:</label>
  		<input type="text" id="lastName" name="lastName" value="${particularStudent.lastName}"><br><br>

  		<label for="email">Email:</label>
  		<input type="text" id="email" name="email" value="${particularStudent.email}"><br><br>
		
		
		<input type="hidden" name="action" value="updated">	
  		<input type="hidden" id="ID" name="id" value="${particularStudent.id}"><br><br>
		
		
  		<button type="submit" class="btn btn-danger">Submit</button>		  		
	</form>
</div>
</body>
</html>