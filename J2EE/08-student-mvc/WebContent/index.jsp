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
</style>
</head>
<body>
<h1>
	Index page 
</h1>
<c:forEach var="student" items="${allStudents}">
	${student}
</c:forEach>

<table class="table  table-hover">
<thead>
<th>Student id</th>
<th>First  Name</th>
<th>Last  Name</th>
<th>Email</th>
<th>Action</th>
</thead>

<c:forEach var="student" items="${allNewStudents}">
	<c:url var="updateLink" value="JdbcTest">
            <c:param name="action" value="update" />
            <c:param name="id" value="${student.id}" />
	</c:url>
	<tr class="table-active">
	<td>${student.id} </td>
	<td>${student.firstName}</td> 
	<td>${student.lastName}</td> 
	<td>${student.email}</td>
	<td>  		
		<a href="${updateLink}" class="btn btn-secondary">Update Student  </a>
	</td>
	
	
	</tr>
</c:forEach>
</table>

<a href="add-Student.jsp" class="btn btn-primary">Add Student </a>
</body>
</html>