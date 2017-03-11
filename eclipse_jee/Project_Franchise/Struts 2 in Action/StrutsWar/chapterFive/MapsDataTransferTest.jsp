<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>Data Transfer Test</title>
	</head>

	<body>
		<h4>Submit the form to test the data transfer into and out of a Map property.</h4> 
		
		<s:form action="MapsDataTransferTest">

   	 		<s:textfield name="maidenNames.mary" label="Maiden Name"/>
     	  <s:textfield name="maidenNames.jane" label="Maiden Name"/>
     	  <s:textfield name="maidenNames.hellen" label="Maiden Name"/>

  	 		<s:textfield name="maidenNames['beth']" label="Maiden Name"/>
     	  <s:textfield name="maidenNames['sharon']" label="Maiden Name"/>
     	  <s:textfield name="maidenNames['martha']" label="Maiden Name"/>

   	 		<s:textfield name="myUsers['chad'].username" label="Usernames"/>
     	  <s:textfield name="myUsers['jimmy'].username" label="Usernames"/>
     	  <s:textfield name="myUsers['elephant'].username" label="Usernames"/>
     	  
   	 		<s:textfield name="myUsers.chad.birthday" label="birthday"/>
     	  <s:textfield name="myUsers.jimmy.birthday" label="birthday"/>
     	  <s:textfield name="myUsers.elephant.birthday" label="birthday"/>
 
   	 		<s:textfield name="myOrderedUsers['1'].birthday" label="birthday"/>
     	  <s:textfield name="myOrderedUsers['2'].birthday" label="birthday"/>
     	  <s:textfield name="myOrderedUsers['3'].birthday" label="birthday"/>
     	  
  	<s:submit/>
		</s:form>	
	  
		
	</body>
	
</html>
