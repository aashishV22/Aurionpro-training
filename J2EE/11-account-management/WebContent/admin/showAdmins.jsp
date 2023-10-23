<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="ISO-8859-1"> 
<title>Insert title here</title> 
</head> 
<link 
 href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
 rel="stylesheet" 
 integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
 crossorigin="anonymous"> 
<script 
 src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
 integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" 
 crossorigin="anonymous"></script>
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
<body> 
<ul>
<div class="button-container container">
 	<li><form action="UserController" method="post">		
			<input type="hidden" name="userId" 	value="${userId}">
			<input type="hidden" name="action" value="showUsers">
	    	<button class="active">Home</button>
	     </form>
	</li>
	<li><form action="userLogin.jsp">
	    	<button onclick="myFunction()" >LogOut</button></form>
	</li>
</div>
</ul>
<div class="container mt-5"> 
<br><br> 
<h1>Admin Table</h1> 
 <table class="table table-striped mt-3"> 
  <thead class="thead-dark"> 
   <tr> 
    <th scope="row">id</th> 
    <th scope="row">User Name</th>  
    <th>Department</th> 
   </tr> 
  </thead> 
 
  <c:forEach var="allAdmins" items="${allAdmins}"> 
    
   <tr scope="row"> 
    <td>${allAdmins.id}</td> 
    <td>${allAdmins.userName}</td> 
    <td>Cashier</td> 
   </tr> 
  </c:forEach> 
 
 </table> 
 <a href="admin/add-user.jsp" class="btn btn-info m-3">Add User</a> 
 <form action=UserController method="post">
 	<input type="hidden" name="action" value="showUsers">
 	<button  class="btn btn-danger">Show Users</button>
 </form>
 </div> 
 
 
 
 <script type="text/javascript">
function myFunction() {
	  alert("Logged Out");
	}
</script>
</body> 
</html>