<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${headerMessage}</h1>
	
	<h3>Admission form</h3>

	<form:errors path="student1.*" />

	<form action="./submitAdmissionForm.html" method="post">
	<table>
		<tr>
			<td>Student's Name</td>
			<td><input type="text" name="studentName" /></td>
		</tr>
		<tr>
			<td>Student's Hobby</td>
			<td><input type="text" name="studentHobby" /></td>
		</tr>
		<tr>
			<td>Student's Mobile (Long)</td>
			<td><input type="text" name="studentMobile" /></td>
		</tr>
		<tr>
			<td>Student's DOB (yyyy/mm/dd)</td>
			<td><input type="text" name="studentDOB" /></td>
		</tr>
		<tr>
			<td>Skills set</td>
			<td>
				<select name="studentSkills" multiple>
					<option value="Java Core">Java Core</option>
					<option value="Spring Core">Spring Core</option>
					<option value="Spring MVC">Spring MVC</option>
				</select>
			</td>
		</tr>
	</table>

	<table>
		<tr><td>Address</td></tr>
		<tr>
			<td>country: <input type="text" name="studentAddress.country" /></td>
			<td>city: <input type="text" name="studentAddress.city" /></td>
			<td>street: <input type="text" name="studentAddress.street" /></td>
			<td>pincode: <input type="text" name="studentAddress.pincode" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit form" /></td>
		</tr>
	</table>
	</form>
	
	<p>${privateMessage}</p>

</body>
</html>