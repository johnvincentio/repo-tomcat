
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/herc.tld" prefix="h" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="centerContainers">
	<div class="footerCenterContainer">
		<div class="inline floatLeft footerColumn"> 
			<div class="footerHeader"><s:text name="site.headerThree"></s:text></div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="<s:text name='site.linkFifteenURL'></s:text>"><s:text name="site.linkFifteenLabel"></s:text></a> </div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="<s:text name='site.linkSixteenURL'></s:text>"><s:text name="site.linkSixteenLabel"></s:text></a> </div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="<s:text name='site.linkSeventeenURL'></s:text>"><s:text name="site.linkSeventeenLabel"></s:text></a> </div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="<s:text name='site.linkEighteenURL'></s:text>"><s:text name="site.linkEighteenLabel"></s:text></a> </div>
		</div>
		<div class="inline floatLeft footerColumn"> 
			<div class="footerHeader"><s:text name="site.headerOne"></s:text></div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="<s:text name='site.linkOneURL'></s:text>" ><s:text name="site.linkOneLabel"></s:text></a></div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="<s:text name='site.linkTwoURL'></s:text>" ><s:text name="site.linkTwoLabel"></s:text></a></div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="<s:text name='site.linkThreeURL'></s:text>" ><s:text name="site.linkThreeLabel"></s:text></a></div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="<s:text name='site.linkFourURL'></s:text>" ><s:text name="site.linkFourLabel"></s:text></a></div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="<s:text name='site.linkFiveURL'></s:text>" ><s:text name="site.linkFiveLabel"></s:text></a></div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="<s:text name='site.linkSixURL'></s:text>" ><s:text name="site.linkSixLabel"></s:text></a></div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="<s:text name='site.linkSevenURL'></s:text>" ><s:text name="site.linkSevenLabel"></s:text></a></div>
		</div>
		<div class="inline floatLeft footerColumn"> 
			<div class="footerHeader"><s:text name="site.headerTwo"></s:text></div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="<s:text name='site.linkNineURL'></s:text>" ><s:text name="site.linkNineLabel"></s:text></a> </div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="<s:text name='site.linkElevenURL'></s:text>" ><s:text name="site.linkElevenLabel"></s:text></a> </div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="<s:text name='site.linkTwelveURL'></s:text>" ><s:text name="site.linkTwelveLabel"></s:text></a> </div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="<s:text name='site.linkTwentyURL'></s:text>" ><s:text name="site.linkTwentyLabel"></s:text></a> </div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="<s:text name='site.linkTwentyOneURL'></s:text>" ><s:text name="site.linkTwentyOneLabel"></s:text></a> </div>
			<div class="footerLinkItem"> <a class="footerLinkText" href="<s:text name='site.linkFourteenURL'></s:text>" ><s:text name="site.linkFourteenLabel"></s:text></a> </div>
		</div>
		<div class="inline floatLeft"> 
			<div class="footerHeader"><s:text name="site.headerFour"></s:text></div>
			<div class="footerLinkItem">
				<div class="inline floatLeft footerPhoneIcon"></div><div class="inline floatLeft footerLinkText"><s:text name="site.phoneContactUs"></s:text></div>
				<div class="clear"></div>
			</div>
			<div class="footerLinkItem">
				<div class="inline floatLeft footerFaxIcon"></div><div class="inline floatLeft footerLinkText"><s:text name="site.faxContactUs"></s:text></div>
				<div class="clear"></div>
			</div>
			<div class="footerLinkItem">
				<div class="inline floatLeft footerEmailIcon"></div>
				<div class="inline floatLeft">
					<a class="footerLinkText" href="mailto:<s:text name='site.emailContactUs'></s:text>">
						<s:text name='site.emailContactUs'></s:text>
					</a>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
	<div class="clear"> </div>
	<div class="footerDivider"></div>
	<div class="footerCopyRightContent">
		<div> 
			<div class="inline footerLinkItem footerCopyRightLinkDiv"><a class="footerCopyRightLinks" href="https://www.hertz.com/rentacar/navigation/enUS/privacyPolicyView.html" onclick="window.open(this.href, 'PrivacyPolicy', 'height=463,width=340,scrollbars=1,resizable=yes'); return false;"><s:text name="site.privacyPolicyLink"></s:text></a></div>
			<div class="inline footerLinkItem footerCopyRightLinkDiv"><a class="footerCopyRightLinks" href="https://www.hertz.com/rentacar/navigation/enUS/legalView.jsp" onclick="window.open(this.href, 'LegalPolicy', 'height=463,width=340,scrollbars=1,resizable=yes'); return false;"><s:text name="site.legalLink"></s:text></a></div>
			<div class="inline footerLinkItem"><a class="footerCopyRightLinks" href="<c:url value='/contact-us' />" ><s:text name="site.contactUsLink"></s:text></a></div>
		</div> 
		<div><s:text name="site.copyrightContent"></s:text></div> 
	</div>
</div>
	