<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>Iterator Tag</title>
	</head>

	<body>
		<h4>Iterator Tag</h4>
		
		<h3>Existing User Portfolios:</h3> 	
		
	  	<s:iterator value="users" status="itStatus">
	  		<li>
	  			<s:property value="#itStatus.count" />
	  			<s:property value="portfolioName"/>
	  		</li>
		</s:iterator>		
	</body>
	
</html>



