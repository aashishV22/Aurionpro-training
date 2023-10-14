<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

<table>
<thead>
<th>id</th>
<th>name</th>
<th>email</th>
<th>percant</th>
<th>remark</th>
</thead>

<c:forEach var="student" items="${allNewStudents}">
	<tr>
	<td>${student.id} </td>
	<td>${student.name}</td> 
	<td>${student.email}</td> 
	<td>${student.percentage}</td>
	<td>
	<c:choose>
		<c:when test="${student.percentage>80}">Great</c:when>
		<c:when test="${student.percentage<=70}">Not good</c:when>
		<c:otherwise>All good keep it up</c:otherwise>	
	</c:choose>		 

	</td> 
	</tr>
</c:forEach>
</table>
</body>
</html>