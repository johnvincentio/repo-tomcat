
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/herc.tld" prefix="h" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="centerContainers">
	<div class="mainContainer">
		<div class="franchisePageTitle"><s:text name="confirm.pageTitle"></s:text></div>
		<div class="navigationCorner"></div>
		<div class="contentContainer">
			<div class="inline floatLeft mainWideNoBorderContent">
				<h1 class="franchisePageHeading"><s:text name="confirm.sectionTitle"></s:text></h1>
				<div><s:text name="confirm.confirmationContent"></s:text></div>
			</div>
			<div class="inline floatLeft contactUsConfirmBorder">
				<div class="floatLeft contactUsContainer">
					<img alt="" src="<h:image prefix="misc" image="herc-worker.gif" />" />
				</div>
				<div class="inline floatLeft">
					<div class="fontNormalTextBold"> <h2 class="fontNormalTextBold"><s:text name="confirm.contactTitle"></s:text></h2></div>
					<div><s:text name="confirm.contactAddress"></s:text></div>
					<div><s:text name="confirm.contactCityState"></s:text></div>
					<div class="spacer"><s:text name="confirm.contactPhone"></s:text></div>
					<div><s:text name="confirm.contactPhone1"></s:text></div>
					<div><s:text name="confirm.contactFax"></s:text></div>
					<div class="spacer"> <a href="mailto:<s:text name='confirm.contactEmail'></s:text>"><s:text name="contactEmail"></s:text></a></div>
				</div>
			</div>
			<div class="clear"></div>
			<div class="disclaimerContent"><s:text name="site.disclaimerContent"></s:text></div>
		</div>
	</div>
</div>
