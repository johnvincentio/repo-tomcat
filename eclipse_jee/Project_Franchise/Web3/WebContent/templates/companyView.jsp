
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/herc.tld" prefix="h" %>

<h:loadContent key="pageContent" section="home" file="companyView.xml" />
<h:loadContent key="siteContent" section="home" file="siteFrame.xml" />

<div class="centerContainers"> 
	<div class="mainContainer">
		<div class="franchisePageTitle">${pageContent['companyView.pageTitle']} </div>
		<div class="navigationCorner"></div>
		<div class="contentContainer">
			<div>
				<h1 class="franchisePageHeading">${pageContent['companyView.pageHeading']} </h1> 
				<div> ${pageContent['companyView.mainContent']}</div>
				<h2 class="franchiseSecondHeading spacer"> ${pageContent['companyView.firstTitle']} </h2>
				<div>
					<ul class="companyBulletList">
						<li><span class="fontNormalTextItalic"> ${pageContent['companyView.firstHeading']}</span></li>
						<li><span class="fontNormalTextItalic"> ${pageContent['companyView.secondHeading']} </span></li>
						<li><span class="fontNormalTextItalic"> ${pageContent['companyView.thirdHeading']} </span></li>
						<li><span class="fontNormalTextItalic"> ${pageContent['companyView.fourthHeading']} </span></li>
						<li><span class="fontNormalTextItalic"> ${pageContent['companyView.fifthHeading']} </span></li>
						<li><span class="fontNormalTextItalic"> ${pageContent['companyView.sixthHeading']} </span></li>
						<li><span class="fontNormalTextItalic"> ${pageContent['companyView.seventhHeading']} </span></li>
						<li><span class="fontNormalTextItalic"> ${pageContent['companyView.eigthHeading']}</span></li>
						
					</ul>
				</div>
				<div class="spacer">${pageContent['companyView.secondContent']}</div>
			</div>
			<div class="disclaimerContent">${siteContent['siteFrame.disclaimerContent']}</div>
		</div>
	</div>
</div>
