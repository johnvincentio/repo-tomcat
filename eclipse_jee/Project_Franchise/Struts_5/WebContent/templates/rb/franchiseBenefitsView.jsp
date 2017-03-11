
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="centerContainers"> 
	<div class="mainContainer">
		<div class="franchisePageTitle"><s:text name="benefits.pageTitle"></s:text></div>
		<div class="navigationCorner"></div>
		<div class="contentContainer">
			<div>
				<div class="inline floatLeft benefitsMainNarrowLftContent"> 
					<h1 class="franchisePageHeading"><s:text name="benefits.pageHeading"></s:text></h1>					
					<div><s:text name="benefits.mainContent"></s:text></div>
					<s:text name="benefits.firstTitle"></s:text><br /><br />
					<div> <s:text name="benefits.mainContent2"></s:text></div>
				</div>
				<div class="inline floatLeft benefitsMainNarrowRgtContent">
					<h2 class="franchiseSecondHeading"><s:text name="benefits.firstHeading"></s:text></h2>
					<div>
						<ul class="benefitsBulletList">
							<li><span class="fontNormalTextItalic"> <s:text name="benefits.firstHeadingDetail1"></s:text></span></li>
							<li><span class="fontNormalTextItalic"> <s:text name="benefits.firstHeadingDetail2"></s:text> </span></li>
							<li><span class="fontNormalTextItalic"> <s:text name="benefits.firstHeadingDetail3"></s:text> </span></li>
							<li><span class="fontNormalTextItalic"> <s:text name="benefits.firstHeadingDetail4"></s:text></span></li>
							<li><span class="fontNormalTextItalic"> <s:text name="benefits.firstHeadingDetail5"></s:text> </span></li>
							<li><span class="fontNormalTextItalic"> <s:text name="benefits.firstHeadingDetail6"></s:text> </span></li>
							<li><span class="fontNormalTextItalic"> <s:text name="benefits.firstHeadingDetail7"></s:text></span></li>
							<li><span class="fontNormalTextItalic"> <s:text name="benefits.firstHeadingDetail8"></s:text> </span></li>
							<li><span class="fontNormalTextItalic"> <s:text name="benefits.firstHeadingDetail9"></s:text> </span></li>
							<li><span class="fontNormalTextItalic"> <s:text name="benefits.firstHeadingDetail10"></s:text></span></li>
						</ul>
					</div>					
				</div>
				<div class="clear"></div>
			</div>	
			<div class="disclaimerContent"><s:text name="site.disclaimerContent"></s:text></div>
		</div>
	</div>
</div>