
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/herc.tld" prefix="h" %>

<h:loadContent key="pageContent" section="home" file="franchiseBenefitsView.xml" />
<h:loadContent key="siteContent" section="home" file="siteFrame.xml" />

<div class="centerContainers"> 
	<div class="mainContainer">
		<div class="franchisePageTitle">${pageContent['franchiseBenefitsView.pageTitle']} </div>
		<div class="navigationCorner"></div>
		<div class="contentContainer">
			<div>
				<div class="inline floatLeft benefitsMainNarrowLftContent"> 
					<h1 class="franchisePageHeading">${pageContent['franchiseBenefitsView.pageHeading']} </h1>					
					<div>${pageContent['franchiseBenefitsView.mainContent']}</div>
					${pageContent['franchiseBenefitsView.firstTitle']}<br /><br />
					<div> ${pageContent['franchiseBenefitsView.mainContent2']}</div>
				</div>
				<div class="inline floatLeft benefitsMainNarrowRgtContent">
					<h2 class="franchiseSecondHeading">${pageContent['franchiseBenefitsView.firstHeading']}</h2>
					<div>
						<ul class="benefitsBulletList">
							<li><span class="fontNormalTextItalic"> ${pageContent['franchiseBenefitsView.firstHeadingDetail1']}</span></li>
							<li><span class="fontNormalTextItalic"> ${pageContent['franchiseBenefitsView.firstHeadingDetail2']} </span></li>
							<li><span class="fontNormalTextItalic"> ${pageContent['franchiseBenefitsView.firstHeadingDetail3']} </span></li>
							<li><span class="fontNormalTextItalic"> ${pageContent['franchiseBenefitsView.firstHeadingDetail4']}</span></li>
							<li><span class="fontNormalTextItalic"> ${pageContent['franchiseBenefitsView.firstHeadingDetail5']} </span></li>
							<li><span class="fontNormalTextItalic"> ${pageContent['franchiseBenefitsView.firstHeadingDetail6']} </span></li>
							<li><span class="fontNormalTextItalic"> ${pageContent['franchiseBenefitsView.firstHeadingDetail7']}</span></li>
							<li><span class="fontNormalTextItalic"> ${pageContent['franchiseBenefitsView.firstHeadingDetail8']} </span></li>
							<li><span class="fontNormalTextItalic"> ${pageContent['franchiseBenefitsView.firstHeadingDetail9']} </span></li>
							<li><span class="fontNormalTextItalic"> ${pageContent['franchiseBenefitsView.firstHeadingDetail10']}</span></li>
						</ul>
					</div>					
				</div>
				<div class="clear"></div>
			</div>	
			<div class="disclaimerContent">${siteContent['siteFrame.disclaimerContent']}</div>
		</div>
	</div>
</div>