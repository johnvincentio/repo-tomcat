<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
    <title>Data Transfer Test</title>
	</head>

	<body>
		<h4>Submit the form to test the flexible data transfer of the Struts 2 framework.</h4> 
				<s:form action="DataTransferTest">
    	  <s:textfield name="ages" label="Ages"/>
     	  <s:textfield name="ages" label="Ages"/>
     	  <s:textfield name="ages" label="Ages"/>
  	 
    	  <s:textfield name="names[0]" label="names"/>
     	  <s:textfield name="names[1]" label="names"/>
     	  <s:textfield name="names[2]" label="names"/>
     	  
   	 		<s:textfield name="middleNames[0]" label="middleNames"/>
     	  <s:textfield name="middleNames[1]" label="middleNames"/>
     	  <s:textfield name="middleNames[2]" label="middleNames"/>
 
   	 		<s:textfield name="lastNames" label="lastNames"/>
     	  <s:textfield name="lastNames" label="lastNames"/>
     	  <s:textfield name="lastNames" label="lastNames"/>

   	 		<s:textfield name="users[0].username" label="Usernames"/>
     	  <s:textfield name="users[1].username" label="Usernames"/>
     	  <s:textfield name="users[2].username" label="Usernames"/>
   	  
   	 		<s:textfield name="myUsers['chad'].username" label="Usernames"/>
     	  <s:textfield name="myUsers['jimmy'].username" label="Usernames"/>
     	  <s:textfield name="myUsers['elephant'].username" label="Usernames"/>
     	  
   	 		<s:textfield name="myUsers['chad'].birthday" label="birthday"/>
     	  <s:textfield name="myUsers['jimmy'].birthday" label="birthday"/>
     	  <s:textfield name="myUsers['elephant'].birthday" label="birthday"/>
   
      	  <s:textfield name="aLetter" label="charLetter"/>
      	  <s:textfield name="trueOrFalse" label="trueOrFalse"/>
   
   	  
  	<s:submit/>
		</s:form>	
	  
		
	</body>
	
</html>
