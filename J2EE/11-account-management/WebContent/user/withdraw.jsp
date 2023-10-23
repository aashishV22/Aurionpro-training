<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<!-- <script type="text/javascript">
setTimeout(function(){
	  location.reload();
	}, 60000*5);
</script> -->
<meta charset="ISO-8859-1">
<title>Withdraw</title>
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
	<li><form action="singleUserController">	
		<input type="hidden" name="userId" 	value="${Account.user_id }">
	    <button >Home</button>
	    <input type="hidden" name="action" value="gotoAccount">
	    </form>
	</li>
	<li><form action="userLogin.jsp">	
	    	<button onclick="myFunction()" >LogOut</button></form>
	</li>
</div>
</ul>
<div class="container">
<br><br>
<h1 class="container" name="userWholeName" value="${userName}">${userName} </h1>
<h2 class="container">Withdraw Amount </h2>
<br><br>
<table class="table  table-hover">
<thead>
<th>Account Number</th>
<th>Account Type</th>
<th>Account Balance</th>
<th><center> Amount</center></th>

</thead>
<%-- 	<c:url var="depositLink" value="singleUserController">
            <c:param name="action" value="deposited" />
            <c:param name="id" value="${Account.user_id}" />
            <c:param name="amount" value="${amount }" />
	</c:url>
 --%>	
 	<tr class="table-active">
	<td name="number">  ${Account.accountNumber}  </td>
	<td name="type">	${Account.accountType}    </td> 
	<td name="balance"> ${Account.accountBalance} </td> 
	<td>  		
	<form action="singleUserController" >
		<input type="hidden" name="action" 		  value="withdrawClicked">
		<input type="hidden" name="userId"    	  value="${Account.user_id }">			
		<input type="hidden" name="accountNumber" value="${Account.accountNumber}">
		<input type="hidden" name="accountType"   value="${Account.accountType}">
		<input type="hidden" name="balance" 	  value=" ${Account.accountBalance}">
		<input type="hidden" name="transactioType_id" value="301">
 		<input type="text" placeholder="Enter Ammout to withdraw" name="amount" required>
		<button type="submit" id="withdraw" class="btn btn-secondary">Withdraw </button>	
	</form>
	</td>
	</tr>
</table>


</div>






<script type="text/javascript">
function myFunction() {
	  alert("Logged Out");
	}
</script>
<script type="text/javascript" src="user/withdraw.js"></script>

</body>
</html>