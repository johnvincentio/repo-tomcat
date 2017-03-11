
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">

<head>
	<tiles:insertAttribute name="head" />
	<link rel="stylesheet" id="style" type="text/css" href="<c:url value="/theme/master.css" />" media="all" />
	<link rel="stylesheet" id="style" type="text/css" href="<c:url value="/theme/lightbox.css" />" media="all" />
</head>

<body>
	<div class="tmplPageContainer">
		<div class="headerContainer">
			<tiles:insertAttribute name="header" />
		</div>
		<div class="navigationContainer">
			<tiles:insertAttribute name="navigation" />
		</div>
		<div class="bodyContainer">
			<tiles:insertAttribute name="body" ignore="true" />
		</div>
		<div class="footerContainer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
	<script type="text/javascript">
		//<![CDATA[ 
			<tiles:insertAttribute name="globalInPage" />		
 		//]]> 
 	</script>		
	<script language="JavaScript" type="text/javascript" src="<c:url value="/theme/jquery-1.4.2.min.js"/>"></script>
	<script language="JavaScript" type="text/javascript" src="<c:url value="/theme/utils.js"/>"></script>
	<script language="JavaScript" type="text/javascript" src="<c:url value="/theme/overlayBox.js"/>"></script>
	<script language="JavaScript" type="text/javascript" src="<c:url value="/theme/master.js"/>"></script>
</body>

</html>
