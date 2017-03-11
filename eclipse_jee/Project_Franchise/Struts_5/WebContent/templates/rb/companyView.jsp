
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="centerContainers"> 
	<div class="mainContainer">
		<div class="franchisePageTitle"><s:text name="company.pageTitle"></s:text></div>
		<div class="navigationCorner"></div>
		<div class="contentContainer">
			<div>
				<h1 class="franchisePageHeading"><s:text name="company.pageHeading"></s:text></h1> 
				<div> <s:text name="company.mainContent"></s:text></div>
				<h2 class="franchiseSecondHeading spacer"> <s:text name="company.firstTitle"></s:text></h2>
				<div>
					<ul class="companyBulletList">
						<li><span class="fontNormalTextItalic"> <s:text name="company.firstHeading"></s:text></span></li>
						<li><span class="fontNormalTextItalic"> <s:text name="company.secondHeading"></s:text></span></li>
						<li><span class="fontNormalTextItalic"> <s:text name="company.thirdHeading"></s:text></span></li>
						<li><span class="fontNormalTextItalic"> <s:text name="company.fourthHeading"></s:text></span></li>
						<li><span class="fontNormalTextItalic"> <s:text name="company.fifthHeading"></s:text></span></li>
						<li><span class="fontNormalTextItalic"> <s:text name="company.sixthHeading"></s:text></span></li>
						<li><span class="fontNormalTextItalic"> <s:text name="company.seventhHeading"></s:text></span></li>
						<li><span class="fontNormalTextItalic"> <s:text name="company.eigthHeading"></s:text></span></li>
					</ul>
				</div>
				<div class="spacer"><s:text name="company.secondContent"></s:text></div>
			</div>
			<div class="disclaimerContent"><s:text name="site.disclaimerContent"></s:text></div>
		</div>
	</div>
</div>
