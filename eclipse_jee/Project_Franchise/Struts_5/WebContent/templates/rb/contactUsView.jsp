
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="/WEB-INF/herc.tld" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<div class="centerContainers">
	<s:form action="contactUsSubmit" namespace="/">
		<div class="mainContainer">
			<div class="franchisePageTitle"><s:text name="contact.pageTitle"></s:text></div>
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
						<h1 class="franchisePageHeading"><s:text name="contact.sectionTitle"></s:text></h1>
						<div><s:text name="contact.informationContent"></s:text></div>
						<br />
						<table class="fontNormalTextRegular contactUsPadding">
							<tr>
								<s:label key="form.prefix" name="prefix" requiredLabel="false" />
								<td class="formFieldSpacer">&nbsp;</td>
								<td>&nbsp;</td>							
							</tr>
							<tr>
								<s:select name="prefix" list='prefixList'  
								id="prefix" 
								headerKey="" headerValue="%{getText('contact.chooseOneContent')}"
								requiredLabel="false" 
								listKey="name" listValue="value" 
								value="prefix" />																				
							</tr>
							<tr>
								<s:label key="form.firstName" name="firstName" requiredLabel="true" />
								<td>&nbsp;</td>
								<s:label key="form.middleName" name="middleName" requiredLabel="false" /> 
							</tr>
							<tr>	
								<s:textfield cssClass="formFieldDefault" name="firstName" requiredLabel="true" size="29" maxlength="50" />
								<td>&nbsp;</td>
								<s:textfield cssClass="formFieldDefault" name="middleName" requiredLabel="false" size="29" maxlength="50" />
							</tr>
							<tr>
								<s:label key="form.lastName" name="lastName" requiredLabel="true" />
								<td>&nbsp;</td>
								<s:label key="form.suffix" name="suffix" requiredLabel="false" />
							</tr>
							<tr>	
								<s:textfield cssClass="formFieldDefault" name="lastName" requiredLabel="true" size="29" maxlength="50" />
								<td>&nbsp;</td>
								<s:select name="suffix"
									list='suffixList'
									id="prefix" headerKey="" headerValue="%{getText('contact.chooseOneContent')}"
									requiredLabel="false" listKey="name" listValue="name"
									cssClass="formFieldDefault"
									value="suffix" />	
							</tr>
							<tr>
								<s:label key="form.businessName" name="businessName" requiredLabel="false" />							
							</tr>
							<tr>
								<s:textfield cssClass="formFieldDefault" name="businessName" requiredLabel="false" size="29" maxlength="50" />										
							</tr>
							<tr>
								<s:label key="form.address1" name="address1" requiredLabel="true" />
								<td>&nbsp;</td>
								<s:label key="form.address2" name="address2" requiredLabel="false" />
							</tr>	
							<tr>
								<s:textfield cssClass="formFieldDefault" name="address1" requiredLabel="true" size="29" maxlength="50" />
								<td>&nbsp;</td>
								<s:textfield cssClass="formFieldDefault" name="address2" requiredLabel="false" size="29" maxlength="50" />
							</tr>	
							<tr>
								<s:label key="form.city" name="city" requiredLabel="true" />
							</tr>	
							<tr>
								<s:textfield cssClass="formFieldDefault" name="city" requiredLabel="true" size="29" maxlength="50" />
							</tr>
							<tr>
								<s:label key="form.country" name="country" requiredLabel="true" />
								<td>&nbsp;</td>
								<s:label key="form.state" name="state" requiredLabel="true" />
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
								<s:label key="form.zip" name="zip" requiredLabel="true" />							
							</tr>	
								
							<tr>
								<s:textfield cssClass="formFieldDefault" name="zip" requiredLabel="true" size="29" maxlength="50" />							
							</tr>	
							<tr>
								<s:label key="form.email1" name="email1" requiredLabel="true" />
								<td>&nbsp;</td>
								<s:label key="form.email2" name="email2" requiredLabel="true" />
							</tr>	
							<tr>
								<s:textfield cssClass="formFieldDefault" name="email1" requiredLabel="true" size="29" maxlength="50" />
								<td>&nbsp;</td>
								<s:textfield cssClass="formFieldDefault" name="email2" requiredLabel="true" size="29" maxlength="50" />
							</tr>	
							<tr>
								<s:label key="form.phone" name="phone" requiredLabel="true" />
								<td>&nbsp;</td>
								<s:label key="form.fax" name="fax" requiredLabel="false" />
							</tr>	
							<tr>
								<s:textfield cssClass="formFieldDefault" name="phone" requiredLabel="true" size="29" maxlength="50" />
								<td>&nbsp;</td>
								<s:textfield cssClass="formFieldDefault" name="fax" requiredLabel="false" size="29" maxlength="50" />
							</tr>
							<tr>
								<s:label key="form.comments" name="comments" requiredLabel="false" />							
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
						<div class="fontNormalTextBold"> <h2 class="fontNormalTextBold"><s:text name="contact.contactTitle"></s:text></h2> </div>
						<div><s:text name="contact.contactAddress"></s:text></div>
						<div><s:text name="contact.contactCityState"></s:text></div>
						<div class="spacer"><s:text name="contact.contactPhone"></s:text></div>
						<div><s:text name="contact.contactPhone1"></s:text></div>
						<div><s:text name="contact.contactFax"></s:text></div>
						<div class="spacer">
							<a href="mailto:<s:text name='contact.contactEmail'></s:text>"><s:text name="contact.contactEmail"></s:text></a>
						</div>
					</div>
					<div class="clear"></div>
					<div class="disclaimerContent"><s:text name="site.disclaimerContent"></s:text></div>
				</td>	
			</tr>	
			</table>	
			</div>
		</div>
		<div class="formFieldContainer">
			<s:submit cssClass="submitBtn pointer" type="button" />
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
