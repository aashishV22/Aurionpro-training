<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		/* Cookie[] cookies = request.getCookies();
		boolean isColorSet=false;
		
		if(cookies!=null)
		{
			for(Cookie c:cookies){
				if(c.getName().equals("color")){
					String bgColor=c.getValue();
					out.println("<p> Cookie is set with bgcolor "+bgColor);
					isColorSet=true;
				}
			}
		}
	
		if(!isColorSet){
			Cookie newCookie=new Cookie("color","green");
			newCookie.setMaxAge(60*60*24);
			response.addCookie(newCookie);
		}
		 */
	
		Cookie[] cookies = request.getCookies();
		boolean isCounterSet=false;
	
		if(cookies!=null)
		{
			for(Cookie c:cookies){
				if(c.getName().equals("counterFirst")){
					String bgCounter=c.getValue();
					int counter =Integer.parseInt(bgCounter);
					out.println("<p> Counter is set "+ counter);
					int countInc=++counter;
					String countValue=Integer.toString(countInc);
					Cookie cookieUpdate=new Cookie(c.getName(),countValue);
					response.addCookie(cookieUpdate);
					isCounterSet=true;
				}
			}
		}
	
		
		if(!isCounterSet){
			Cookie newCookie=new Cookie("counterFirst","0");
			newCookie.setMaxAge(60*60*24);
			response.addCookie(newCookie);
		}
	
	
	%>
	
</body>
</html>