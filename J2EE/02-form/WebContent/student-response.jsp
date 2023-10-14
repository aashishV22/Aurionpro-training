<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	Student Details<br><br>
	Name: <%= request.getParameter("name") %>
	<br><br>
	Email:   		 ${param.email} 
	<br><br>
	Gender:	 		 ${param.gender }
	<br><br>
	Qualification:	 ${param.degree }
	<br><br>
	Subjects:	
	<%
		String[] subjects=request.getParameterValues("subject");
		for(int i=0;i<subjects.length;i++){
			out.print(subjects[i]+",");
		}
	%>

	<br><br>	
	
	
	</div>

</body>
</html>