
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/herc.tld" prefix="h" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="centerContainers navigationMenuContainer">
	<table class="maxWidth" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td class="navigationMenu">			
				<table class="maxWidth" border="0" cellpadding="0" cellspacing="0">
					<c:forEach var="topNavItem" varStatus="loopOuter" items="${nav.items}">
						<c:if test="${loopOuter.last}"> 
							<c:set var="navigationMenuUnselectedText" value="navigationMenuItemUnselectedTextLast" /> 
							<c:set var="navigationMenuItemBorder" value="" />
						</c:if>
						<c:if test="${!loopOuter.last}">
							<c:set var="navigationMenuUnselectedText" value="navigationMenuItemUnselectedText" />
							<c:set var="navigationGrayArrow" value="navigationGrayArrow" />
							<c:set var="navigationMenuItemBorder" value="navigationMenuItemBorder" />
						</c:if>
						<c:choose>
							<c:when test="${topNavItem.selected}">
								<tr>
									<td class="navigationMenuItemSpacer">&nbsp;</td>
									<td class="${navigationMenuItemBorder}"><img src="<h:image prefix="misc" image="nav-grayarrow.gif" dialect="false" />" alt="" /></td>
									<td class="navigationMenuItem ${navigationMenuItemBorder}"><a class="navigationMenuItemText navigationMenuItemSelectedText" href="<c:url value="${topNavItem.url}"/>">${topNavItem.text}</a> </td>
									<td class="navigationMenuItemSpacer">&nbsp;</td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr>
									<td class="navigationMenuItemSpacer">&nbsp;</td>
									<td class="${navigationMenuItemBorder}">&nbsp;</td>
									<td class="navigationMenuItem ${navigationMenuItemBorder}"><a class="navigationMenuItemText ${navigationMenuItemUnselectedText}" href="<c:url value="${topNavItem.url}"/>">${topNavItem.text}</a></td>
									<td class="navigationMenuItemSpacer">&nbsp;</td>
								</tr> 	
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</table>				
			</td>
			<td><img class="navImgBorder" src="<h:image prefix="banners" image="${imageName}" dialect="true" />" alt="${altText}" /></td>
		</tr>	
	</table>
	
</div>
<div class="clear"></div>
 