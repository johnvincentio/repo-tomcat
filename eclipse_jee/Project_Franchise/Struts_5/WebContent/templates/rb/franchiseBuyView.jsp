
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/herc.tld" prefix="h" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="centerContainers"> 
	<div class="mainContainer">
		<div class="franchisePageTitle"><s:text name="buy.pageTitle"></s:text></div>
		<div class="navigationCorner"></div>
		<div class="contentContainer">
			<div>
				<div class="inline floatLeft mainNarrowLftContent"> 
					<h1 class="franchisePageHeading"><s:text name="buy.pageHeading"></s:text></h1>
					<div><s:text name="buy.mainContent"></s:text></div>
				</div>
				<div class="inline floatLeft mainNarrowRgtContent">
					<h2 class="franchiseSecondHeading"><s:text name="buy.firstTitle"></s:text></h2>
					<h3 class="franchiseSecondHeading spacer"><s:text name="buy.firstHeading"></s:text></h3>
					<div><s:text name="buy.firstHeadingDetail1"></s:text></div>
					<div><s:text name="buy.firstHeadingDetail2"></s:text></div>
					<div class="franchiseSecondHeading spacer"><s:text name="buy.secondHeading"></s:text></div>
					<div><s:text name="buy.secondHeadingDetail1"></s:text></div>
					<div><s:text name="buy.secondHeadingDetail2"></s:text></div>
					<div class="spacer underline"><s:text name="buy.thirdHeading"></s:text></div>
					<div>
						<ul class="buyBulletList">
							<li><s:text name="buy.thirdHeadingDetail1"></s:text></li>
							<li><s:text name="buy.thirdHeadingDetail2"></s:text></li>
							<li><s:text name="buy.thirdHeadingDetail3"></s:text></li>
						</ul>
					</div>
					<div class="spacer">
						<a class="fontCategorySubLinkText" href="<h:image prefix='documents' image='franchise_application_form.docx' />">
							<s:text name="buy.applicationLink"></s:text>
						</a>
						<img class="downloadImg" alt="" src="<h:image prefix='misc' image='download-icon.gif' />" />
					</div>
					<div class="spacer">
						<s:text name="buy.requirementContent"></s:text> 
						<a class="fontCategorySubLinkText" href="mailto:<s:text name='buy.emailAddress'></s:text>">
							<s:text name="buy.emailAddress"></s:text>
						</a> 
					</div>
					<div class="spacer"><s:text name="buy.submitalContent"></s:text></div> 
				</div>
				<div class="clear"></div>
			</div>	
			<div class="disclaimerContent"><s:text name="site.disclaimerContent"></s:text></div>
		</div>
	</div>
</div>