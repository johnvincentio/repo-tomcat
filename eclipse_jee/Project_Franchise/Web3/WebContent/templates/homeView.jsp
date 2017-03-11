
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/herc.tld" prefix="h" %>

<h:loadContent key="pageContent" section="home" file="homeView.xml" />
<h:loadContent key="siteContent" section="home" file="siteFrame.xml" />

<div class="centerContainers">
	<div class="mainContainer">
		<div class="franchisePageTitle">${pageContent['homeView.pageTitle']} </div>
		<div class="navigationCorner"></div>
		<div class="contentContainer">
			<div>
				<table cellpadding="0" cellspacing="0" border="0">
					<tr>
						<td class="mainContent">
							<h1 class="franchisePageHeading">${pageContent['homeView.pageHeading']} </h1>
							<div> ${pageContent['homeView.mainContent']}</div>	
						</td>
						<td class="contentImageCell">
							<img class="contentImage" height="282" width="336" src="<h:image prefix="misc" image="heavy_equipment_rental_collage.jpg" dialect="false" />" alt="Heavy Equipment Rental" />	
						</td>
					</tr>
				</table>
			</div>
			<hr />
			<div class="homeInfoContent">${pageContent['homeView.infoContent']}</div>
			<h2 class="franchiseSecondHeading"> ${pageContent['homeView.firstTitle']} </h2>
			<div>
				<div class="inline floatLeft">
					<ul class="homeFirstList">
						<li><span class="fontNormalTextItalic"> ${pageContent['homeView.firstHeading']}</span></li>
						<li><span class="fontNormalTextItalic"> ${pageContent['homeView.secondHeading']} </span></li>
						<li><span class="fontNormalTextItalic"> ${pageContent['homeView.thirdHeading']} </span></li>
					</ul>
				</div>
				<div class="inline floatLeft">
					<ul class="homeSecondList">
						<li><span class="fontNormalTextItalic"> ${pageContent['homeView.fourthHeading']} </span></li>
						<li><span class="fontNormalTextItalic"> ${pageContent['homeView.sixthHeading']} </span></li>					
						<li><span class="fontNormalTextItalic"> ${pageContent['homeView.seventhHeading']}</span></li>
					</ul>
				</div>
				<div class="inline floatLeft">
					<ul class="homeThirdList">
						<li><span class="fontNormalTextItalic"> ${pageContent['homeView.eigthHeading']}</span></li>
						<li><span class="fontNormalTextItalic"> ${pageContent['homeView.ninethHeading']}</span></li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<h2 class="franchiseSecondHeading spacer">${pageContent['homeView.secondTitle']}</h2>
			<div>
				<div class="inline floatLeft">
					<ul class="homeFourthList">
						<li><span class="fontNormalTextItalic"> ${pageContent['homeView.tenthHeading']}</span></li>
						<li><span class="fontNormalTextItalic"> ${pageContent['homeView.eleventhHeading']} </span></li>
						<li><span class="fontNormalTextItalic"> ${pageContent['homeView.twelvethHeading']} </span></li>
					</ul>
				</div>
				<div class="inline floatLeft">
					<ul class="homeFifthList">
						<li><span class="fontNormalTextItalic"> ${pageContent['homeView.thirteenthHeading']} </span></li>
						<li><span class="fontNormalTextItalic"> ${pageContent['homeView.fourteenthHeading']} </span></li>
						<li><span class="fontNormalTextItalic"> ${pageContent['homeView.fifteenthHeading']} </span></li>
					</ul>
				</div>
				<div class="inline floatLeft">
					<ul class="homeSixthList">
						<li><span class="fontNormalTextItalic"> ${pageContent['homeView.sixteenthHeading']} </span></li>
						<li><span class="fontNormalTextItalic"> ${pageContent['homeView.seventeenthHeading']} </span></li>
						<li><span class="fontNormalTextItalic"> ${pageContent['homeView.eighteenthHeading']} </span></li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<div class="disclaimerContent">${siteContent['siteFrame.disclaimerContent']}</div>
		</div>
	</div>
</div>
	
