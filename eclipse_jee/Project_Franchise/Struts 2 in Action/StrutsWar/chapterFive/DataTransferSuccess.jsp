<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>Data Transfer Success</title>
	</head>

	<body>
		<h5>Congratulations! You have transferred data in a bunch of different ways.</h5>
		<h3>Age number 3 = <s:property value="ages[2]" /> </h3> 
		<h3>Name number 3 = <s:property value="names[2]" /> </h3> 
		<h3>Last name number 3 = <s:property value="lastNames[2]" /> </h3> 
		<h3>Middle name number 3  = <s:property value="middleNames[2]" /> </h3> 
		<h3>User.username number 3  = <s:property value="users[2].username" /> </h3> 
		<h3>MyUsers 'jimmy' username  = <s:property value="myUsers.jimmy.username" /> </h3> 
		<h3>MyUsers 'jimmy' birthday  = <s:property value="myUsers.jimmy.birthday" /> </h3> 
		
		<h3>trueOrFalse  = <s:property value="trueOrFalse" /> </h3> 
		<h3>aLetter  = <s:property value="aLetter" /> </h3> 
		
		
		
	</body>
	
</html>
