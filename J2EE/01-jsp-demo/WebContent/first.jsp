<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.Date , com.aurionpro.model.* " %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>hello world</h1>
<br>
<h2>Expression tag</h2>
<h2> Todays date <%= new Date() %> </h2>
<h2> Hello world in lower case <%= new String ("Hello world").toLowerCase() %> </h2>
<br>
<h3>Scriptlet tags </h3>
	<%
		for(int i=1;i<=10;i++){
			out.println("i = "+i+"<br>");	
		}
	%>
<br>

<h1>Declaration tag</h1>
	<%--<%!
		String str(String value){
		return value.toUpperCase();
	}
	%>	--%>
<h1>hello world in upper case <%=  StringUtil.str("hello worl") %></h1>


</body>
</html>