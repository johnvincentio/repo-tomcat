
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/herc.tld" prefix="h" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h:loadContent key="frameContent" section="home" file="siteFrame.xml" />

<div class="centerContainers">
	<table class="maxWidth" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td class="navigationLogoImg">
				<a class="navigationLinks" href="<c:url value = "/" />">
					<img class="navigationLogoImg" src="<h:image prefix="misc" image="hertz_equipment_rental_logo.gif" dialect="false" />" alt="" />
				</a>
			</td>
			<td>
				<table cellpadding="0" cellspacing="0" border="0">
					<tr><td></td></tr>
					<tr>
						<td class="navigationSeperatorLine">&nbsp;</td>
					</tr>
					<tr><td></td></tr>
				</table>				
			</td>
			<td class="navigationTitle"><s:text name="site.siteHeader"></s:text></td>
			<td class="navigationLinksContainer">
				<a class="navigationLinksText" href="<c:url value = "/" />">
					<s:text name="site.homeLink"></s:text>
				</a> | 
				<a class="navigationLinksText" href="<s:url value='dialects'></s:url>">
					<s:text name="site.dialectsLink"></s:text>
				</a>
			</td>
		</tr>
	</table>
</div>
<div class="clear"></div>
