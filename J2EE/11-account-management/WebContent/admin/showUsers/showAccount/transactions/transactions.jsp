<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Transactions</title>
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
.button-container {
    display: flex;
    justify-content: space-between;
    flex-wrap:wrap;
  }
</style>
</head>

<body>

<ul>
<div class="button-container container">
	<li><form action="UserController">		
		<input type="hidden" name="userId" 	value="${userId }">
	    <button >Home</button>
	    <input type="hidden" name="action" value="${action }">
	    </form>
	</li>
</div>
</ul>
<div class="container">
<br>
<h1 class="container" name="userWholeName" value="${userName}">${userName} </h1>
<h2 class ="container">Transactions</h2>

<br><br>
<table class="table  table-hover">
<thead>
<th>Transaction Id		</th>
<th>Sender Account no.	</th>
<th>Receiver Account no.</th>
<th>Transaction Type	</th>
<th>Transaction Time	</th>
<th>Transaction Amount	</th>

</thead>

<c:forEach var="transaction" items="${transactions}">
	<tr class="table-active">
	<td>  ${transaction.transaction_id}  </td>
	<td>  ${transaction.account_no_sender}    </td> 
	<td>  ${transaction.account_no_receiver} </td> 
	<td>  ${transaction.transactionType} </td> 
	<td>  ${transaction.transaction_time} </td> 
	<td>  ${transaction.transaction_amount} </td> 
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