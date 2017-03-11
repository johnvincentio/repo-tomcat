
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/herc.tld" prefix="h" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h:loadContent key="pageContent" section="common" file="siteFrame.xml" />

<hr/>
before page content
<hr/>
<div>${pageContent['siteFrame.copyrightContent']}</div>
<hr/>
after page content
<hr/>
