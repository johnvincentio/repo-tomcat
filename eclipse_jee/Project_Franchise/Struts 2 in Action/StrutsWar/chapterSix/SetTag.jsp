<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>Set Tag</title>
	</head>

	<body>
		<h4>Set Tag</h4>
		<hr/>
		<s:set name="username" value="user.username"/>
	  Your username is <s:property value="#username"/>. 
			<hr/>
	</body>
	
</html>



