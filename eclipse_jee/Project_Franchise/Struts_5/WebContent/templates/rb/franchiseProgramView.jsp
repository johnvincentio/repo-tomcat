
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/herc.tld" prefix="h" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="centerContainers">
	<div class="mainContainer">
		<div class="franchisePageTitle"><s:text name="program.pageTitle"></s:text></div>
		<div class="navigationCorner"></div>
		<div class="contentContainer">	
			<h1 class="franchisePageHeading"><s:text name="program.pageHeading"></s:text></h1>
			<div><s:text name="program.mainContent"></s:text></div>
			<div class="programListContainer">	
				<div class="spacer fontNormalTextBold"><s:text name="program.firstHeading"></s:text></div>
				<div>
					<ul class="programBulletList"><li><s:text name="program.firstDetail"></s:text></li></ul>
				</div>
				<h2 class="spacer fontNormalTextBold"><s:text name="program.secondHeading"></s:text></h2>
				<div>
					<ul class="programBulletList"><li><s:text name="program.secondDetail"></s:text></li></ul>
				</div>
				<div class="spacer fontNormalTextBold"><s:text name="program.thirdHeading"></s:text></div>
				<div>
					<ul class="programBulletList"><li><s:text name="program.thirdDetail"></s:text></li></ul>
				</div>
				<h2 class="spacer fontNormalTextBold"><s:text name="program.fourthHeading"></s:text></h2>
				<div>
					<ul class="programBulletList"><li><s:text name="program.fourthDetail"></s:text></li></ul>
				</div>
				<h3 class="spacer fontNormalTextBold"><s:text name="program.fifthHeading"></s:text></h3>
				<div>
					<ul class="programBulletList"><li><s:text name="program.fifthDetail"></s:text></li></ul>
				</div>
				<div class="spacer fontNormalTextBold"><s:text name="program.sixthHeading"></s:text></div>
				<div>
					<ul class="programBulletList"><li><s:text name="program.sixthDetail"></s:text></li></ul>
				</div>
				<div class="spacer fontNormalTextBold"><s:text name="program.seventhHeading"></s:text></div>
				<div>
					<ul class="programBulletList"><li><s:text name="program.seventhDetail"></s:text></li></ul>
				</div>
				<h3 class="spacer fontNormalTextBold"><s:text name="program.eigthHeading"></s:text></h3>
				<div>
					<ul class="programBulletList"><li><s:text name="program.eigthDetail"></s:text></li></ul>
				</div>
				<div class="spacer fontNormalTextBold"><s:text name="program.ninethHeading"></s:text></div>
				<div>
					<ul class="programBulletList"><li><s:text name="program.ninethDetail"></s:text></li></ul>
				</div>
				<h3 class="spacer fontNormalTextBold"><s:text name="program.tenthHeading"></s:text></h3>
				<div>
					<ul class="programBulletList"><li><s:text name="program.tenthDetail"></s:text></li></ul>
				</div>
				<div class="spacer fontNormalTextBold"><s:text name="program.eleventhHeading"></s:text></div>
				<div>
					<ul class="programBulletList"><li><s:text name="program.eleventhDetail"></s:text></li></ul>
				</div>
				<div class="spacer fontNormalTextBold"><s:text name="program.twelvethHeading"></s:text></div>
				<div>
					<ul class="programBulletList"><li><s:text name="program.twelvethDetail"></s:text></li></ul>
				</div>
				<div class="spacer fontNormalTextBold"><s:text name="program.thirteenthHeading"></s:text></div>
				<div>
					<ul class="programBulletList"><li><s:text name="program.thirteenthDetail"></s:text></li></ul>
				</div>
			</div>
			<div class="spacer"><s:text name="program.bottomContent"></s:text></div>
			<div class="spacer">
				<s:text name="program.informationContent1"></s:text>
				<a class="programLink" href="<c:url value='contact-us' />">
					<s:text name="site.contactUsLink"></s:text>
				</a>
				<s:text name="program.informationContent2"></s:text>
				<a class="programLink" href="mailto:<s:text name='site.emailContactUs'></s:text>"><s:text name='site.emailContactUs'></s:text></a>
			</div>
			<div class="disclaimerContent"><s:text name="site.disclaimerContent"></s:text></div>
		</div>
	</div>
</div>
	
