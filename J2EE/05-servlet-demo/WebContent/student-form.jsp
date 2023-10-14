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
	<form class="form" action="StudentServlet">
		<br><br>
		<label for="name">Name:</label>
  		<input type="text" id="name" name="name"><br><br>
  		<label for="email">Email:</label>
  		<input type="text" id="email" name="email"><br><br>
  		<label for="select">Graduation Degree: </label>
		<select name="degree" id="select">
  			<option value="BE">BE</option>
  			<option value="BSc">BSc</option>
		  	<option value="BCom">BCom</option>
		</select><br><br>
		<p>Please select your Gender:</p>
  			<input type="radio" id="gender" name="gender" value="M">
  			<label for="gender">Male</label><br>
  			<input type="radio" id="gender" name="gender" value="F">
  			<label for="gender">Female</label><br>
  			<input type="radio" id="gender" name="gender" value="Other">
  			<label for="gender">Other</label><br>
		<br><br>
		<p>Please select your Subjects:</p>
			<input type="checkbox" id="subject" name="subject" value="Java">
			<label for="subject"> Java</label><br>
			<input type="checkbox" id="subject" name="subject" value="Angular">
			<label for="subject"> Angular</label><br>
			<input type="checkbox" id="subject" name="subject" value="React">
			<label for="subject"> React</label><br><br>
			
			
  		<button type="submit">Submit</button>		  		
	</form>
</div>


</body>
</html>