<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
  <li><a class="active" href="JdbcTest">Home</a></li>
  <li><a onclick="myFunction()" href="#">Update</a></li>
</ul>
<div class="container">
<br><br><br><br>
<table class="table  table-hover">
<thead>
<th>Student id</th>
<th>First  Name</th>
<th>Last  Name</th>
<th>Email</th>
<th><center> Action</center></th>
<th><center> Courses</center></th>

</thead>

<c:forEach var="student" items="${allNewStudents}">
	<c:url var="updateLink" value="JdbcTest">
            <c:param name="action" value="update" />
            <c:param name="id" value="${student.id}" />
	</c:url>
	<c:url var="deleteLink" value="JdbcTest">
            <c:param name="action" value="delete" />
            <c:param name="id" value="${student.id}" />
	</c:url>
	
	<tr class="table-active">
	<td name="id">${student.id} </td>
	<td name="firstName">${student.firstName}</td> 
	<td name="lastName">${student.lastName}</td> 
	<td name="email">${student.email}</td>
	<td>  		
		<a href="${updateLink}" class="btn btn-secondary">Update Student  </a>		
		<a href="${deleteLink}" class="btn btn-secondary">Delete Student  </a>
	</td>
	<td>${student.courses }	</td>
	</tr>
</c:forEach>
</table>
<a href="add-Student.jsp" class="btn btn-primary">Add Student </a>

</div>






<script type="text/javascript">
function myFunction() {
	  alert("First select a student to Update it!");
	}
</script>
</body>
</html>