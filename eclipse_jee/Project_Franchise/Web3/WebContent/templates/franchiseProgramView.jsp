
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/herc.tld" prefix="h" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h:loadContent key="pageContent" section="home" file="franchiseProgramView.xml" />
<h:loadContent key="siteContent" section="home" file="siteFrame.xml" />

<div class="centerContainers">
	<div class="mainContainer">
		<div class="franchisePageTitle">${pageContent['franchiseProgramView.pageTitle']} </div>
		<div class="navigationCorner"></div>
		<div class="contentContainer">	
			<h1 class="franchisePageHeading">${pageContent['franchiseProgramView.pageHeading']} </h1>
			<div> ${pageContent['franchiseProgramView.mainContent']}</div>
			<div class="programListContainer">	
				<div class="spacer fontNormalTextBold">${pageContent['franchiseProgramView.firstHeading']}</div>
				<div>
					<ul class="programBulletList"><li>${pageContent['franchiseProgramView.firstDetail']}</li></ul>
				</div>
				<h2 class="spacer fontNormalTextBold">${pageContent['franchiseProgramView.secondHeading']}</h2>
				<div>
					<ul class="programBulletList"><li>${pageContent['franchiseProgramView.secondDetail']}</li></ul>
				</div>
				<div class="spacer fontNormalTextBold">${pageContent['franchiseProgramView.thirdHeading']}</div>
				<div>
					<ul class="programBulletList"><li>${pageContent['franchiseProgramView.thirdDetail']}</li></ul>
				</div>
				<h2 class="spacer fontNormalTextBold">${pageContent['franchiseProgramView.fourthHeading']}</h2>
				<div>
					<ul class="programBulletList"><li>${pageContent['franchiseProgramView.fourthDetail']}</li></ul>
				</div>
				<h3 class="spacer fontNormalTextBold">${pageContent['franchiseProgramView.fifthHeading']}</h3>
				<div>
					<ul class="programBulletList"><li>${pageContent['franchiseProgramView.fifthDetail']}</li></ul>
				</div>
				<div class="spacer fontNormalTextBold">${pageContent['franchiseProgramView.sixthHeading']}</div>
				<div>
					<ul class="programBulletList"><li>${pageContent['franchiseProgramView.sixthDetail']}</li></ul>
				</div>
				<div class="spacer fontNormalTextBold">${pageContent['franchiseProgramView.seventhHeading']}</div>
				<div>
					<ul class="programBulletList"><li>${pageContent['franchiseProgramView.seventhDetail']}</li></ul>
				</div>
				<h3 class="spacer fontNormalTextBold">${pageContent['franchiseProgramView.eigthHeading']}</h3>
				<div>
					<ul class="programBulletList"><li>${pageContent['franchiseProgramView.eigthDetail']}</li></ul>
				</div>
				<div class="spacer fontNormalTextBold">${pageContent['franchiseProgramView.ninethHeading']}</div>
				<div>
					<ul class="programBulletList"><li>${pageContent['franchiseProgramView.ninethDetail']}</li></ul>
				</div>
				<h3 class="spacer fontNormalTextBold">${pageContent['franchiseProgramView.tenthHeading']}</h3>
				<div>
					<ul class="programBulletList"><li>${pageContent['franchiseProgramView.tenthDetail']}</li></ul>
				</div>
				<div class="spacer fontNormalTextBold">${pageContent['franchiseProgramView.eleventhHeading']}</div>
				<div>
					<ul class="programBulletList"><li>${pageContent['franchiseProgramView.eleventhDetail']}</li></ul>
				</div>
				<div class="spacer fontNormalTextBold">${pageContent['franchiseProgramView.twelvethHeading']}</div>
				<div>
					<ul class="programBulletList"><li>${pageContent['franchiseProgramView.twelvethDetail']}</li></ul>
				</div>
				<div class="spacer fontNormalTextBold">${pageContent['franchiseProgramView.thirteenthHeading']}</div>
				<div>
					<ul class="programBulletList"><li>${pageContent['franchiseProgramView.thirteenthDetail']}</li></ul>
				</div>
			</div>
			<div class="spacer">${pageContent['franchiseProgramView.bottomContent']}</div>
			<div class="spacer">${pageContent['franchiseProgramView.informationContent1']} <a class="programLink" href="<c:url value="contact-us" />">${siteContent['siteFrame.contactUsLink']}</a> ${pageContent['franchiseProgramView.informationContent2']} <a class="programLink" href="mailto:${siteContent['siteFrame.emailContactUs']}">${siteContent['siteFrame.emailContactUs']}</a></div>
			<div class="disclaimerContent">${siteContent['siteFrame.disclaimerContent']}</div>
		</div>
	</div>
</div>
	
