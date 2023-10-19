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
  <li><a href="userLogin.jsp" onclick="myFunction()">Logout</a></li>

</ul>
<div class="container">
<br><br>
<div>
<form action="Controller">
      <input type="text" placeholder="Enter Name..." name="searchName">
      <input type="hidden" name="action" value="search" >
      <select name="columnName" id="find">
  		<option value="StudentId">id</option>
  		<option value="First Name">First name</option>
  		<option value="Last Name">Last Name</option>
	  	<option value="Student Email">Email</option>
	</select>
	  <button type="submit" class="btn btn-primary">Search  User </button>
    </form>
</div>
<br><br>
<table class="table  table-hover">
<thead>
<th>Account Number</th>
<th>Account Type</th>
<th>Account Balance</th>


</thead>

<c:forEach var="account" items="${allAccounts}">
	<c:url var="updateLink" value="Controller">
            <c:param name="action" value="update" />
            <c:param name="id" value="${account.user_id}" />
	</c:url>
	<c:url var="deleteLink" value="JdbcTest">
            <c:param name="action" value="delete" />
            <c:param name="id" value="${account.user_id}" />
	</c:url>
	
	<tr class="table-active">
	<td name="number">  ${account.number}  </td>
	<td name="type">	${account.type}    </td> 
	<td name="balance"> ${account.balance} </td> 
	<td>  		
		<a href="${updateLink}" class="btn btn-secondary">Send Money  </a>		
	</td>
	</tr>
</c:forEach>
</table>

</div>






<script type="text/javascript">
function myFunction() {
	  alert("First select a student to Update it!");
	}
</script>
</body>
</html>