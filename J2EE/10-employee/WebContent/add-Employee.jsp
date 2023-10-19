<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add-students</title>
<link 
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
	crossorigin="anonymous">
<script 
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" 
	crossorigin="anonymous">
</script>
<style>
table, th, td {
  border:1px solid black;
}
label {
  display: inline-block;
  width: 100px;
  text-align: right;
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #04AA6D;
}
</style>
</head>

<body>

<ul>
  <li><a href="EmployeeController" name="action" value="list">Home</a></li>
  <li><a onclick="myFunction()" href="#">Update</a></li>
  <li><a class="active" >Add</a></li>
</ul>

<div class="container">
	<form class="form" action="EmployeeController">
		<br><br>
		<label for="firstName">First Name:</label>
  		<input type="text" id="firstName" name="firstName"><br><br>

		<label for="lastName">Last Name:</label>
  		<input type="text" id="lastName" name="lastName"><br><br>

  		<label for="email" >Email:</label>
  		<input type="text" id="email" name="email"><br><br>
		
		<label for="dob" >DoB:</label>
  		<input type="text" id="dob" name="dob"><br><br>
  		
  		<label for="doj" >DoJ:</label>
  		<input type="text" id="doj" name="doj"><br><br>
  		
		<input type="hidden" name="action" value="add">	
  		<button type="submit" class="btn btn-danger">Submit</button>		  		
	</form>
</div>






<script type="text/javascript">
function myFunction() {
	  alert("First select a student to Update it!");
	}
</script>
</body>
</html>