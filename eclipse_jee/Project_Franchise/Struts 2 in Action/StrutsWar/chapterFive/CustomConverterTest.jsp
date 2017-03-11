<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>Data Transfer Test</title>
	</head>

	<body>
	  <hr/>
		<h4>Submit the form to test the flexible data transfer of the Struts 2 framework.</h4> 
		<s:form action="CustomConverterTest">
    	<s:textfield name="circle" label='Circle "C:r5"'/>
     	<s:submit/>
		</s:form>	
	 	  <hr/> 
		
	</body>
	
</html>
