<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>Data Transfer Test</title>
	</head>

	<body>
		<h4>The following form fields submit to Array backed, indexed JavaBeans properties.</h4> 
		<s:form action="ArraysDataTransferTest">
    	  <s:textfield name="ages" label="Ages"/>
     	  <s:textfield name="ages" label="Ages"/>
     	  <s:textfield name="ages" label="Ages"/>
  	 
    	  <s:textfield name="names[0]" label="names"/>
     	  <s:textfield name="names[1]" label="names"/>
     	  <s:textfield name="names[2]" label="names"/>
     	  
   	<s:submit/>
		</s:form>	
	  
		
	</body>
	
</html>
