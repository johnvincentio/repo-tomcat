
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/herc.tld" prefix="h" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<hr/>
starting testing_2/footerView.jsp
<hr/>

<h:loadContent key="frameContent" section="home" file="siteFrame.xml" />

<hr/>
 ${siteContent['siteFrame.headerThree']}
<hr/>

<div class="centerContainers">
	<div class="footerCenterContainer">
		<div class="inline floatLeft footerColumn"> 
			<div class="footerHeader"> ${frameContent['siteFrame.headerThree']} </div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="${frameContent['siteFrame.linkFifteenURL']}" >${frameContent['siteFrame.linkFifteenLabel']}</a> </div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="${frameContent['siteFrame.linkSixteenURL']}" >${frameContent['siteFrame.linkSixteenLabel']}</a> </div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="${frameContent['siteFrame.linkSeventeenURL']}" >${frameContent['siteFrame.linkSeventeenLabel']}</a> </div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="${frameContent['siteFrame.linkEighteenURL']}" >${frameContent['siteFrame.linkEighteenLabel']}</a> </div>
		</div>
		<div class="inline floatLeft footerColumn"> 
			<div class="footerHeader"> ${frameContent['siteFrame.headerOne']}</div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="${frameContent['siteFrame.linkOneURL']}" >${frameContent['siteFrame.linkOneLabel']}</a> </div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="${frameContent['siteFrame.linkTwoURL']}" >${frameContent['siteFrame.linkTwoLabel']}</a> </div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="${frameContent['siteFrame.linkThreeURL']}" >${frameContent['siteFrame.linkThreeLabel']}</a> </div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="${frameContent['siteFrame.linkFourURL']}" >${frameContent['siteFrame.linkFourLabel']}</a> </div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="${frameContent['siteFrame.linkFiveURL']}" >${frameContent['siteFrame.linkFiveLabel']}</a> </div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="${frameContent['siteFrame.linkSixURL']}" >${frameContent['siteFrame.linkSixLabel']}</a> </div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="${frameContent['siteFrame.linkSevenURL']}" >${frameContent['siteFrame.linkSevenLabel']}</a> </div>
		</div>
		<div class="inline floatLeft footerColumn"> 
			<div class="footerHeader"> ${frameContent['siteFrame.headerTwo']} </div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="${frameContent['siteFrame.linkNineURL']}" >${frameContent['siteFrame.linkNineLabel']}</a> </div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="${frameContent['siteFrame.linkElevenURL']}" >${frameContent['siteFrame.linkElevenLabel']}</a> </div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="${frameContent['siteFrame.linkTwelveURL']}" >${frameContent['siteFrame.linkTwelveLabel']}</a> </div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="${frameContent['siteFrame.linkTwentyURL']}" >${frameContent['siteFrame.linkTwentyLabel']}</a> </div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="${frameContent['siteFrame.linkTwentyOneURL']}" >${frameContent['siteFrame.linkTwentyOneLabel']}</a> </div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="${frameContent['siteFrame.linkFourteenURL']}" >${frameContent['siteFrame.linkFourteenLabel']}</a> </div>
		</div>
		<div class="inline floatLeft"> 
			<div class="footerHeader"> ${frameContent['siteFrame.headerFour']} </div>
			<div class="footerLinkItem">
				<div class="inline floatLeft footerPhoneIcon"></div><div class="inline floatLeft footerLinkText">${frameContent['siteFrame.phoneContactUs']}</div>
				<div class="clear"></div>
			</div>
			<div class="footerLinkItem">
				<div class="inline floatLeft footerFaxIcon"></div><div class="inline floatLeft footerLinkText">${frameContent['siteFrame.faxContactUs']}</div>
				<div class="clear"></div>
			</div>
			<div class="footerLinkItem">
				<div class="inline floatLeft footerEmailIcon"></div><div class="inline floatLeft"><a class="footerLinkText" href="mailto:${footerContent['siteFrame.emailContactUs']}">${footerContent['siteFrame.emailContactUs']}</a></div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
	<div class="clear"> </div>
	<div class="footerDivider"></div>
	<div class="footerCopyRightContent">
		<div> 
			<div class="inline footerLinkItem footerCopyRightLinkDiv"><a class="footerCopyRightLinks" href="https://www.hertz.com/rentacar/navigation/enUS/privacyPolicyView.html" onclick="window.open(this.href, 'PrivacyPolicy', 'height=463,width=340,scrollbars=1,resizable=yes'); return false;">${frameContent['siteFrame.privacyPolicyLink']}</a></div>
			<div class="inline footerLinkItem footerCopyRightLinkDiv"><a class="footerCopyRightLinks" href="https://www.hertz.com/rentacar/navigation/enUS/legalView.jsp" onclick="window.open(this.href, 'LegalPolicy', 'height=463,width=340,scrollbars=1,resizable=yes'); return false;">${frameContent['siteFrame.legalLink']}</a></div>
			<div class="inline footerLinkItem"><a class="footerCopyRightLinks" href="<c:url value="/contact-us" />" >${frameContent['siteFrame.contactUsLink']}</a></div>
		</div> 
		<div>${frameContent['siteFrame.copyrightContent']}</div> 
	</div>
</div>

<hr/>
ending testing_2/footerView.jsp
<hr/>
