
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="/WEB-INF/herc.tld" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h:loadContent key="frameContent" section="home" file="siteFrame.xml" />

<meta name="Keywords" content="${frameContent['siteFrame.metaKeywords']}" />   
<meta name="Description" content="${frameContent['siteFrame.metaDescriptions']}" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta http-equiv="X-UA-Compatible" content="IE=7" /> 
<link href="<c:url value="/favicon.ico" />" type="image/x-icon" rel="shortcut icon" />
<link href="<c:url value="/favicon.ico" />" type="image/x-icon" rel="icon"/>  

<title>${frameContent['siteFrame.siteTitle']}</title>
