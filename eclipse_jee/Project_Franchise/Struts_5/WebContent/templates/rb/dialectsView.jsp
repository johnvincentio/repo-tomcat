<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="centerContainers">
	<s:form action="dialectsSubmit" namespace="/" >
		<div>
			<s:actionmessage cssClass="errorList" />
			<s:actionerror cssClass="errorList" />
			<s:fielderror cssClass="errorList" />
		</div>
		<s:select list="{'en_US','fr_FR','de_DE'}" name="myLocale"></s:select>
		<div class="formFieldContainer">
			<s:submit cssClass="submitBtn pointer" type="button" />
		</div>
	</s:form>
</div>
