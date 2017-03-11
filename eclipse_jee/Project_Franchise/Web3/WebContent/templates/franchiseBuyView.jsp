
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/herc.tld" prefix="h" %>

<h:loadContent key="pageContent" section="home" file="franchiseBuyView.xml" />
<h:loadContent key="siteContent" section="home" file="siteFrame.xml" />

<div class="centerContainers"> 
	<div class="mainContainer">
		<div class="franchisePageTitle">${pageContent['franchiseBuyView.pageTitle']} </div>
		<div class="navigationCorner"></div>
		<div class="contentContainer">
			<div>
				<div class="inline floatLeft mainNarrowLftContent"> 
					<h1 class="franchisePageHeading">${pageContent['franchiseBuyView.pageHeading']} </h1>
					<div> ${pageContent['franchiseBuyView.mainContent']}</div>
				</div>
				<div class="inline floatLeft mainNarrowRgtContent">
					<h2 class="franchiseSecondHeading"> ${pageContent['franchiseBuyView.firstTitle']} </h2>
					<h3 class="franchiseSecondHeading spacer">${pageContent['franchiseBuyView.firstHeading']}</h3>
					<div>${pageContent['franchiseBuyView.firstHeadingDetail1']}</div>
					<div>${pageContent['franchiseBuyView.firstHeadingDetail2']}</div>
					<div class="franchiseSecondHeading spacer">${pageContent['franchiseBuyView.secondHeading']} </div>
					<div>${pageContent['franchiseBuyView.secondHeadingDetail1']} </div>
					<div>${pageContent['franchiseBuyView.secondHeadingDetail2']} </div>
					<div class="spacer underline">${pageContent['franchiseBuyView.thirdHeading']}</div>
					<div>
						<ul class="buyBulletList">
							<li>${pageContent['franchiseBuyView.thirdHeadingDetail1']}</li>
							<li>${pageContent['franchiseBuyView.thirdHeadingDetail2']}</li>
							<li>${pageContent['franchiseBuyView.thirdHeadingDetail3']}</li>
						</ul>
					</div>
					<div class="spacer"><a class="fontCategorySubLinkText" href="<h:image prefix="documents" image="franchise_application_form.docx" />">${pageContent['franchiseBuyView.applicationLink']}</a><img class="downloadImg" alt="" src="<h:image prefix="misc" image="download-icon.gif" />" /></div>
					<div class="spacer">
						${pageContent['franchiseBuyView.requirementContent']} 
						<a class="fontCategorySubLinkText" href="mailto:${pageContent['franchiseBuyView.emailAddress']}">${pageContent['franchiseBuyView.emailAddress']} </a> 
					</div>
					<div class="spacer">${pageContent['franchiseBuyView.submitalContent']}</div> 
				</div>
				<div class="clear"></div>
			</div>	
			<div class="disclaimerContent">${siteContent['siteFrame.disclaimerContent']}</div>
		</div>
	</div>
</div>