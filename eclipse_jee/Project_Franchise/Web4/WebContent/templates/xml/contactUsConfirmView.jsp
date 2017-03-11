
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="/WEB-INF/herc.tld" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h:loadContent key="siteContent" section="home" file="siteFrame.xml" />
<h:loadContent key="pageContent" section="home" file="contactUsConfirmView.xml" />

<div class="centerContainers">
	<div class="mainContainer">
		<div class="franchisePageTitle">${pageContent['contactUsConfirmView.pageTitle']}</div>
		<div class="navigationCorner"></div>
		<div class="contentContainer">
			<div class="inline floatLeft mainWideNoBorderContent">
				<h1 class="franchisePageHeading">${pageContent['contactUsConfirmView.sectionTitle']} </h1>
				<div>${pageContent['contactUsConfirmView.confirmationContent']} </div>
			</div>
			<div class="inline floatLeft contactUsConfirmBorder">
				<div class="floatLeft contactUsContainer">
					<img alt="" src="<h:image prefix="misc" image="herc-worker.gif" />" />
				</div>
				<div class="inline floatLeft">
					<div class="fontNormalTextBold"> <h2 class="fontNormalTextBold">${pageContent['contactUsConfirmView.contactTitle']}</h2></div>
					<div> ${pageContent['contactUsConfirmView.contactAddress']} </div>
					<div> ${pageContent['contactUsConfirmView.contactCityState']} </div>
					<div class="spacer"> ${pageContent['contactUsConfirmView.contactPhone']} </div>
					<div> ${pageContent['contactUsConfirmView.contactPhone1']} </div>
					<div> ${pageContent['contactUsConfirmView.contactFax']} </div>
					<div class="spacer"> <a href="mailto:${pageContent['contactUsConfirmView.contactEmail']}">${pageContent['contactUsConfirmView.contactEmail']}</a> </div>
				</div>
			</div>
			<div class="clear"></div>
			<div class="disclaimerContent">${siteContent['siteFrame.disclaimerContent']}</div>
		</div>
	</div>
</div>
