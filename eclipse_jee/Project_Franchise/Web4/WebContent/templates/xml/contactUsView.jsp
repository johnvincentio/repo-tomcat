
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
				<s:actionmessage cssClass="errorList" />
				<s:actionerror cssClass="errorList" />
				<s:fielderror cssClass="errorList" />
			</div>
			<div class="contentContainer">
			<table class="fontNormalTextRegular contactUsPadding">
			<tr>
				<td>
					<div class="inline floatLeft mainWideContent">
						<h1 class="franchisePageHeading">${pageContent['contactUsView.sectionTitle']} </h1>
						<div>${pageContent['contactUsView.informationContent']} </div>
						<br />
						<table class="fontNormalTextRegular contactUsPadding">
							<tr>
								<s:label label="%{formContent['formLabels.prefix']}" name="prefix" requiredLabel="false" />
								<td class="formFieldSpacer">&nbsp;</td>
								<td>&nbsp;</td>							
							</tr>
							<tr>
								<s:select name="prefix" list='prefixList'  
								id="prefix" 
								headerKey="" headerValue="%{pageContent['contactUsView.chooseOneContent']}"
								requiredLabel="false" 
								listKey="name" listValue="value" 
								value="prefix" />																				
							</tr>
							<tr>
								<s:label label="%{formContent['formLabels.firstName']}" name="firstName" requiredLabel="true" />
								<td>&nbsp;</td>
								<s:label label="%{formContent['formLabels.middleName']}" name="middleName" requiredLabel="false" /> 
							</tr>
							<tr>	
								<s:textfield cssClass="formFieldDefault" name="firstName" requiredLabel="true" size="29" maxlength="50" />
								<td>&nbsp;</td>
								<s:textfield cssClass="formFieldDefault" name="middleName" requiredLabel="false" size="29" maxlength="50" />
							</tr>
							<tr>
								<s:label label="%{formContent['formLabels.lastName']}" name="lastName" requiredLabel="true" />
								<td>&nbsp;</td>
								<s:label label="%{formContent['formLabels.suffix']}" name="suffix" requiredLabel="false" />
							</tr>
							<tr>	
								<s:textfield cssClass="formFieldDefault" name="lastName" requiredLabel="true" size="29" maxlength="50" />
								<td>&nbsp;</td>
								<s:select name="suffix"
									list='suffixList'
									id="prefix" headerKey="" headerValue="%{pageContent['contactUsView.chooseOneContent']}"
									requiredLabel="false" listKey="name" listValue="name"
									cssClass="formFieldDefault"
									value="suffix" />	
							</tr>
							<tr>
								<s:label label="%{formContent['formLabels.businessName']}" name="businessName" requiredLabel="false" />							
							</tr>
							<tr>
								<s:textfield cssClass="formFieldDefault" name="businessName" requiredLabel="false" size="29" maxlength="50" />										
							</tr>
							<tr>
								<s:label label="%{formContent['formLabels.address1']}" name="address1" requiredLabel="true" />
								<td>&nbsp;</td>
								<s:label label="%{formContent['formLabels.address2']}" name="address2" requiredLabel="false" />
							</tr>	
							<tr>
								<s:textfield cssClass="formFieldDefault" name="address1" requiredLabel="true" size="29" maxlength="50" />
								<td>&nbsp;</td>
								<s:textfield cssClass="formFieldDefault" name="address2" requiredLabel="false" size="29" maxlength="50" />
							</tr>	
							<tr>
								<s:label label="%{formContent['formLabels.city']}" name="city" requiredLabel="true" />
							</tr>	
							<tr>
								<s:textfield cssClass="formFieldDefault" name="city" requiredLabel="true" size="29" maxlength="50" />
							</tr>
							<tr>
								<s:label label="%{formContent['formLabels.country']}" name="country" requiredLabel="true" />
								<td>&nbsp;</td>
								<s:label label="%{formContent['formLabels.state']}" name="state" requiredLabel="true" />
							</tr>

							<tr>
								<s:doubleselect 
								name="country" 
								list="countryState.keySet()" 
								doubleName="state" 
								doubleList="countryState.get(top)" 
								doubleListKey="key" doubleListValue="value" />
							</tr>

							<tr>
								<s:label label="%{formContent['formLabels.zip']}" name="zip" requiredLabel="true" />							
							</tr>	
								
							<tr>
								<s:textfield cssClass="formFieldDefault" name="zip" requiredLabel="true" size="29" maxlength="50" />							
							</tr>	
							<tr>
								<s:label label="%{formContent['formLabels.email1']}" name="email1" requiredLabel="true" />
								<td>&nbsp;</td>
								<s:label label="%{formContent['formLabels.email2']}" name="email2" requiredLabel="true" />
							</tr>	
							<tr>
								<s:textfield cssClass="formFieldDefault" name="email1" requiredLabel="true" size="29" maxlength="50" />
								<td>&nbsp;</td>
								<s:textfield cssClass="formFieldDefault" name="email2" requiredLabel="true" size="29" maxlength="50" />
							</tr>	
							<tr>
								<s:label label="%{formContent['formLabels.phone']}" name="phone" requiredLabel="true" />
								<td>&nbsp;</td>
								<s:label label="%{formContent['formLabels.fax']}" name="fax" requiredLabel="false" />
							</tr>	
							<tr>
								<s:textfield cssClass="formFieldDefault" name="phone" requiredLabel="true" size="29" maxlength="50" />
								<td>&nbsp;</td>
								<s:textfield cssClass="formFieldDefault" name="fax" requiredLabel="false" size="29" maxlength="50" />
							</tr>
							<tr>
								<s:label label="%{formContent['formLabels.comments']}" name="comments" requiredLabel="false" />							
							</tr>
							<tr>
								<s:textarea cssClass="formTextareaDefault" name="comments" id="comments" />							
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
mice 1
<br/>
<table>

<s:form action="contactUsSubmit" >
			<div>
				<s:actionmessage />
				<s:actionerror />
				<s:fielderror />
			</div>
<tr>
	<s:label label="%{formContent['formLabels.firstName']}" name="firstName" requiredLabel="true" />
</tr>
<tr>	
	<s:textfield cssClass="formFieldDefault" name="firstName" requiredLabel="true" size="29" maxlength="50" />
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
