
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="/WEB-INF/herc.tld" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<h:loadContent key="siteContent" section="home" file="siteFrame.xml" />
<h:loadContent key="pageContent" section="home" file="contactUsView.xml" />
<h:loadContent key="formContent" section="home" file="formLabels.xml" />

<div class="centerContainers">
	<s:form action="contactUsSubmit" namespace="/">
		<div class="mainContainer">
			<div class="franchisePageTitle">${pageContent['contactUsView.pageTitle']}</div>
			<div class="navigationCorner"></div>
			<div>
				<s:actionmessage />
				<s:actionerror />
				<s:fielderror />
			</div>
			<div class="contentContainer">
			<table class="fontNormalTextRegular" cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td>
					<div class="inline floatLeft mainWideContent">
						<h1 class="franchisePageHeading">${pageContent['contactUsView.sectionTitle']} </h1>
						<div>${pageContent['contactUsView.informationContent']} </div>
						<br />
						<table class="fontNormalTextRegular"  border="0" cellpadding="0" cellspacing="0">
							<tr>
								<s:label label="%{formContent['formLabels.prefix']}" name="contactUsInfo.prefix" requiredLabel="false" />
								<td class="formFieldSpacer">&nbsp;</td>
								<td>&nbsp;</td>							
							</tr>
							<tr>
								<s:select name="contactUsInfo.prefix" list='prefixList' 
								id="prefix" 
								headerKey="" headerValue="%{pageContent['contactUsView.chooseOneContent']}"
								requiredLabel="false" 
								listKey="name" listValue="value" 
								value="contactUsInfo.prefix" />																				
							</tr>
							<tr>
								<s:label label="%{formContent['formLabels.firstName']}" name="contactUsInfo.firstName" requiredLabel="true" />
								<td>&nbsp;</td>
								<s:label label="%{formContent['formLabels.middleName']}" name="contactUsInfo.middleName" requiredLabel="false" /> 
							</tr>
							<tr>	
								<s:textfield cssClass="formFieldDefault" name="contactUsInfo.firstName" requiredLabel="true" size="29" maxlength="50" />
								<td>&nbsp;</td>
								<s:textfield cssClass="formFieldDefault" name="contactUsInfo.middleName" requiredLabel="false" size="29" maxlength="50" />
							</tr>
							<tr>
								<s:label label="%{formContent['formLabels.lastName']}" name="contactUsInfo.lastName" requiredLabel="true" />
								<td>&nbsp;</td>
								<s:label label="%{formContent['formLabels.suffix']}" name="contactUsInfo.suffix" requiredLabel="false" />
							</tr>
							<tr>	
								<s:textfield cssClass="formFieldDefault" name="contactUsInfo.lastName" requiredLabel="true" size="29" maxlength="50" />
								<td>&nbsp;</td>
								<s:select name="contactUsInfo.suffix"
									list='suffixList'
									id="prefix" headerKey="" headerValue="%{pageContent['contactUsView.chooseOneContent']}"
									requiredLabel="false" listKey="name" listValue="name"
									cssClass="formFieldDefault"
									value="contactUsInfo.suffix" />	
							</tr>
							<tr>
								<s:label label="%{formContent['formLabels.businessName']}" name="contactUsInfo.businessName" requiredLabel="false" />							
							</tr>
							<tr>
								<s:textfield cssClass="formFieldDefault" name="contactUsInfo.businessName" requiredLabel="false" size="29" maxlength="50" />										
							</tr>
							<tr>
								<s:label label="%{formContent['formLabels.address1']}" name="contactUsInfo.address1" requiredLabel="true" />
								<td>&nbsp;</td>
								<s:label label="%{formContent['formLabels.address2']}" name="contactUsInfo.address2" requiredLabel="false" />
							</tr>	
							<tr>
								<s:textfield cssClass="formFieldDefault" name="contactUsInfo.address1" requiredLabel="true" size="29" maxlength="50" />
								<td>&nbsp;</td>
								<s:textfield cssClass="formFieldDefault" name="contactUsInfo.address2" requiredLabel="false" size="29" maxlength="50" />
							</tr>	
							<tr>
								<s:label label="%{formContent['formLabels.city']}" name="contactUsInfo.city" requiredLabel="true" />
							</tr>	
							<tr>
								<s:textfield cssClass="formFieldDefault" name="contactUsInfo.city" requiredLabel="true" size="29" maxlength="50" />
							</tr>
							<tr>
								<s:label label="%{formContent['formLabels.country']}" name="contactUsInfo.country" requiredLabel="true" />
								<td>&nbsp;</td>
								<s:label label="%{formContent['formLabels.state']}" name="contactUsInfo.state" requiredLabel="true" />
							</tr>

							<tr>
								<s:doubleselect 
								name="contactUsInfo.country" 
								list="countryState.keySet()" 
								doubleName="contactUsInfo.state" 
								doubleList="countryState.get(top)" 
								doubleListKey="key" doubleListValue="value" />
							</tr>

							<tr>
								<s:label label="%{formContent['formLabels.zip']}" name="contactUsInfo.zip" requiredLabel="true" />							
							</tr>	
								
							<tr>
								<s:textfield cssClass="formFieldDefault" name="contactUsInfo.zip" requiredLabel="true" size="29" maxlength="50" />							
							</tr>	
							<tr>
								<s:label label="%{formContent['formLabels.email1']}" name="contactUsInfo.email1" requiredLabel="true" />
								<td>&nbsp;</td>
								<s:label label="%{formContent['formLabels.email2']}" name="contactUsInfo.email2" requiredLabel="true" />
							</tr>	
							<tr>
								<s:textfield cssClass="formFieldDefault" name="contactUsInfo.email1" requiredLabel="true" size="29" maxlength="50" />
								<td>&nbsp;</td>
								<s:textfield cssClass="formFieldDefault" name="contactUsInfo.email2" requiredLabel="true" size="29" maxlength="50" />
							</tr>	
							<tr>
								<s:label label="%{formContent['formLabels.phone']}" name="contactUsInfo.phone" requiredLabel="true" />
								<td>&nbsp;</td>
								<s:label label="%{formContent['formLabels.fax']}" name="contactUsInfo.fax" requiredLabel="false" />
							</tr>	
							<tr>
								<s:textfield cssClass="formFieldDefault" name="contactUsInfo.phone" requiredLabel="true" size="29" maxlength="50" />
								<td>&nbsp;</td>
								<s:textfield cssClass="formFieldDefault" name="contactUsInfo.fax" requiredLabel="false" size="29" maxlength="50" />
							</tr>
							<tr>
								<s:label label="%{formContent['formLabels.comments']}" name="contactUsInfo.comments" requiredLabel="false" />							
							</tr>
							<tr>
								<s:textarea cssClass="formTextareaDefault" name="contactUsInfo.comments" id="contactUsInfo.comments" />							
							</tr>
						</table>											
					</div>
					<div class="floatLeft contactUsContainer">
						<img alt="" src="<h:image prefix="misc" image="herc-worker.gif" />" />
					</div>
					<div class="inline floatLeft">
						<div class="fontNormalTextBold"> <h2 class="fontNormalTextBold">${pageContent['contactUsView.contactTitle']}</h2> </div>
						<div> ${pageContent['contactUsView.contactAddress']} </div>
						<div> ${pageContent['contactUsView.contactCityState']} </div>
						<div class="spacer"> ${pageContent['contactUsView.contactPhone']} </div>
						<div> ${pageContent['contactUsView.contactPhone1']} </div>
						<div> ${pageContent['contactUsView.contactFax']} </div>
						<div class="spacer"> <a href="mailto:${pageContent['contactUsView.contactEmail']}">${pageContent['contactUsView.contactEmail']}</a> </div>
					</div>
					<div class="clear"></div>
					<div class="disclaimerContent">${siteContent['siteFrame.disclaimerContent']}</div>
				</td>	
			</tr>	
			</table>	
			</div>
		</div>
		<div class="formFieldContainer">
			<s:submit cssClass="submitBtn pointer" type="button" label="%{pageContent['contactUsView.submit']}" />
		</div>
	</s:form>
</div>

<%--
<hr/>
birds 1 - this is current working version
<br/>
<table>

<s:form action="contactUsSubmit" >
<tr>
<s:doubleselect 
name="contactUsInfo.country"
list="countryState.keySet()" 
doubleName="contactUsInfo.state" 
doubleList="countryState.get(top)" 
doubleListKey="key" doubleListValue="value" />
</tr>

<tr>
<td>
<s:submit />
</td>
<tr/>
</s:form>

</table>
<hr/>
--%>
