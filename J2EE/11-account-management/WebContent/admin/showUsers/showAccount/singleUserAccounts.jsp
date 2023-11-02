<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.aurionpro.model.Admin"%>
    
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
</head>

<body>
<%
	Admin ad = (Admin) session.getAttribute("ad");
	if(ad==null){
	 response.sendRedirect("../../../userLogin.jsp");}
%>
<ul>
<div class="button-container container">
 	<li><form action="../../../UserController" method="post">		
			<input type="hidden" name="userId" 	value="${userId}">
			<input type="hidden" name="action" value="showUsers">
	    	<button class="active">Home</button>
	     </form>
	</li>
	<li><form action="../../../UserController">
			<input type="hidden" name="action" value="logOutClicked">
	    	<button>LogOut</button></form>
	</li>
</div>
</ul>
<br>
<h1 class="container" name="userWholeName" value="${userName}">${userName} </h1>
<div class="container">
<br><br>
<table class="table  table-hover">
<thead>
<th>Account Number</th>
<th>Account Type</th>
<th>Account Balance</th>
<th><center> Action</center></th>

</thead>

<c:forEach var="account" items="${allAccounts}">
	<tr class="table-active">
	<td>  ${account.accountNumber}  </td>
	<td>  ${account.accountType}    </td> 
	<td>  ${account.accountBalance} </td> 
	<td>
		<div class="button-container" method="post">
		<form action="../../../UserController">
			<input type="hidden" name="action"  value="gotoSingleAccountTransaction">
			<input type="hidden" name="id" 				  value="${account.user_id}">		
			<input type="hidden" name="number"  	  	  value="${account.accountNumber}">
			<button type="submit" class="btn btn-secondary">Transactions</button>
		</form>
		</div>
	</td>
	</tr>
</c:forEach>
</table>

</div>






<script type="text/javascript">
function myFunction() {
	  alert("Logged Out");
	}
</script>
</body>
</html>