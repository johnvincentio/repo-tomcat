<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<h1>Form submitted</h1>
	<h2>message :${msg}</h2>
	<table>
		<tr>
			<td>Name</td>
			<td>${student1.studentName}</td>
		</tr>
		<tr>
			<td>Hobby</td>
			<td>${student1.studentHobby}</td>
		</tr>	
	</table>
	<p>${privateMessage}</p>
</body>
</html>