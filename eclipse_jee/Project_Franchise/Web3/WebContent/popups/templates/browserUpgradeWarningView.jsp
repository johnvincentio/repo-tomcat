<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/herc.tld" prefix="h" %>

<h:loadContent key="pageContent" section="home" file="contactUsView.xml" />

<style type="text/css"> 
	div.brLogoCont table td {vertical-align:top;width:100px; text-align: center; font-size:12px;}
	div.brLogoCont {text-align:left;}
	.brImgCont {height:80px;background-image:url('https://images.hertz.com/herc/herc/misc/sprite-130910.gif');background-repeat:no-repeat;}
	.brIELogo {background-position:20px -1492px;}
	.brFFLogo {background-position:20px -1579px;}
	.brCHLogo {background-position:20px -1670px;}
	.brSFLogo {background-position:20px -1761px;}
</style>

<div style="padding:10px;">
	<div>${pageContent['contactUsView.browserUpgradeMessage']}</div>
	<div style="padding-top:10px;"></div>
	<div class="brLogoCont">
		<table cellpadding="0" cellspacing="10" border="0">
			<tr> 
				<td>
					<div class="brImgCont brIELogo gblCurs" onclick="window.open('http://windows.microsoft.com/en-US/internet-explorer/downloads/ie-8');">&nbsp;</div>
					Internet Explorer 
				</td>
				<td>
					<div class="brImgCont brFFLogo gblCurs" onclick="window.open('http://www.mozilla.com/firefox/');">&nbsp;</div>
					Firefox 3+
				</td>
				<td>
					<div class="brImgCont brCHLogo gblCurs" onclick="window.open('http://www.google.com/chrome');">&nbsp;</div>
					Chrome 9+
				</td>
				<td>
					<div class="brImgCont brSFLogo gblCurs" onclick="window.open('http://www.apple.com/safari/download/');">&nbsp;</div>
					Safari 3+
				</td>
			</tr>
		</table>
	</div>
</div>

<h:set var="upgradeWarningShown" value="Y" scope="session" />
