<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="java.util.* , com.aurionpro.model.* " %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  


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
	
<c:set var="curDate" value="<%= new java.util.Date() %>" />
current Date is ${curDate}		

<%
	List<Student> students= new ArrayList<>();
	students.add(new Student(1,"Nitesh","nitesh@email.com",85.0));
	students.add(new Student(2,"Mahesh","mahesh@email.com",75.0));
	students.add(new Student(3,"bhavesh","bhavesh@email.com",95.0));
	students.add(new Student(4,"bignESH","bignesh@email.com",74.0));
	students.add(new Student(5,"ritesh","ritesh@email.com",70.0));
	students.add(new Student(6,"jignESH","jignesh@email.com",66.0));
	students.add(new Student(7,"aashiSH-verma","aashish@email.com",76.0));

	
	pageContext.setAttribute("all", students);

%>
<table>
<thead>
<th>id</th>
<th>name</th>
<th>email</th>
<th>percant</th>
<th>remark</th>
</thead>
<c:forEach var="student" items="${all}">
	<tr>
	<td>${student.id} </td>
	<td>${student.name}
		<c:if test="${fn:contains(student.name, 'esh')}">  
   			<p>esh founded in ${student.name}<p>  
		</c:if> 
		
		<c:if test="${fn:endsWith(student.name, 'ma')}">  
   			<p>String ends with "ma"<p>  
		</c:if>
		
		<c:set var="name" value="<h1> ${student.name}</h1>"/>  
		<p>string-1 : ${fn:escapeXml(name)}</p>
		<p>string-2 : ${name}</p> 
		<p>Index of fn : ${fn:indexOf(student.name, "i")}</p>  
		  
		    
	</td> 
	<td>${student.email}
		<c:set var="name" value="${fn:split(student.name, '-')}" />  
		<c:set var="name2" value="${fn:join(name, ' ')}" />  
		
		<p>Split fn : ${name2}</p>  
	
	</td> 
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