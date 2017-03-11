<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${headerMessage}</h1>
	
	<h1>Admission form</h1>
	<form action="./submitAdmissionForm.html" method="post">
		<p>Name <input type="text" name="studentName" /></p>
		<p>Hobby <input type="text" name="studentHobby" /></p>
		<input type="submit" value="Submit form" />
	</form>
	
	<h1>Admission form - use ModelAttribute</h1>
	<form action="submitAdmissionForm2.html" method="post">
		<p>Name <input type="text" name="studentName" /></p>
		<p>Hobby <input type="text" name="studentHobby" /></p>
		<input type="submit" value="Submit form" />
	</form>

	<p>${privateMessage}</p>

</body>
</html>