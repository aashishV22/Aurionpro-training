<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello inside resultt</h1>
<%	
	List styles =(List)request.getAttribute("styles");
	Iterator iterator = styles.iterator();
	while(iterator.hasNext()) {
	out.println("<br> Try-> "+iterator.next());
}
%>


<c:forEach var="style" items="${styles}">
	<p>${style}   </p>  
</c:forEach>

</body>
</html>