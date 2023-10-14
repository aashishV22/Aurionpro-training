<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.*" %>
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
</head>
<body>
<div>
	<form class="form" action="session-todo.jsp" method="POST">
		<br><br>
  		<input type="text" placeholder="Enter Task" id="task" name="task"><br><br>
  		<button type="submit">Add task</button>		  		
	</form>
</div>
  	<%
		String todoTask= request.getParameter("task");
  		List<String>itemList=(List<String>) session.getAttribute("todoList");
  		
  		if(itemList==null){
  			itemList=new ArrayList<>();
  		}
		
  		if(todoTask!=null && todoTask.length()>0 && itemList.contains(todoTask)!=true){
  			itemList.add(todoTask);
  			session.setAttribute("todoList",itemList);
  		}
	%>	
	
	<div>
		<ul>
		<%
			if(itemList != null){
				for(String x:itemList){
					out.println("<li>"+ x +"</li>");
				}
			}
			
		%>
		</ul>
	</div>
	
</body>
</html>