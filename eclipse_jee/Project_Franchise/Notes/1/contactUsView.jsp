
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="/WEB-INF/herc.tld" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%--
<h:loadContent key="siteContent" section="home" file="siteFrame.xml" />
<h:loadContent key="pageContent" section="home" file="contactUsView.xml" />
<h:loadContent key="formContent" section="home" file="formLabels.xml" />

<div class="centerContainers">
	<s:form action="contact-us-submit" namespace="/">
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
								<s:select name="contactUsInfo.country"
									list='countryState.countryList'
									id="proximityCountry" headerKey="" headerValue="%{pageContent['contactUsView.chooseOneContent']}"
									requiredLabel="true" listKey="name" listValue="value"
									cssClass="formFieldDefault"
									value="contactUsInfo.country" />
								<td>&nbsp;</td>
									<s:select name="contactUsInfo.state"
									list="countryState.stateList" 
									id="proximityState" headerKey="" headerValue="%{pageContent['contactUsView.chooseOneContent']}"
									requiredLabel="true" listKey="name" listValue="value"
									cssClass="formFieldDefault"
									value="contactUsInfo.state" />
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
--%>

<%--
<hr/>
<table>
	<tr>
		<s:form action="abc" method="post">
<s:doubleselect name="country" 
label="Select Country and City" 
list="{'Australia','India','Pakistan','USA'}" 
doubleName="city" 
doubleList="top == 'Australia'? {'Sydney', 'Melbourne','Brisbane','Perth'}
:top=='India'? {'Delhi', 'Mumbai','Chennai','Kolkata'}
:top=='Pakistan'? {'Karachi','Lahore','Islamabad','Rawalpindi'}
:{'New York','Los Angeles','Chicago','Houston'}" /> 
		</s:form>
	<tr>
	</tr>
</table>

<hr/>
<table>
<tr>
<s:form action="def" method="post">
<s:doubleselect label="Fruits (OGNL) " 
name="fruit1" list="{'fruit','meat'}" 
doubleName="fruit2" 
doubleList="top == 'fruit' ? {'apple', 'orange','banana'} : {'chicken', 'pig'}" />
</s:form>
</tr>
</table>
--%>

<%--
<hr/>
<table>
<tr>
<s:form action="ghj" method="post">
<s:set name="serverList" 
     value="#{
         'AppServer': {'Apache', 'Tomcat', 'JBoss'},
         'Database': {'Oracle', 'MySQL'}
         }" />
<td>
<s:doubleselect label="Server (OGNL) " 
name="server1" list="#serverList.keySet()" 
doubleName="server2" doubleList="#serverList[top]" />
</td>

<td>
<s:doubleselect label="Language (Java List) " 
name="language1" list="languageMap.keySet()" 
doubleName="language2" doubleList="languageMap.get(top)" />
</td>
<td>
<s:submit value="submit" name="submit" />
</td>
</s:form>
</tr>
</table>
--%>


<hr/>
<table>
<tr>
<s:form action="contact-us-submit" namespace="/">
<td>
<s:select label="Months"
       name="months"
       headerKey="-1" headerValue="Select Month"
       list="#{'01' : 'Jan', '02' : 'Feb', '03' : 'March'}"
       value="selectedMonth"
       required="true"/>
</td>
</s:form>
</tr>
</table>
<hr/>

<hr/>
<table>
<tr>
<s:form action="contact-us-submit" namespace="/">
<td>
<s:select 
       name="country"
       headerKey="-1" headerValue="Select Country"
       list="#{'US' : 'United States', 'CA' : 'Canada', 'AF' : 'Afghanistan'}"
       value="selectedCountry"
       required="true"/>
</td>
</s:form>
</tr>
</table>
<hr/>

<hr/>
fred 2
<table>
<tr>
<s:form action="contact-us-submit" namespace="/">
<td>
	<s:select name="contactUsInfo.country"
		list='countryState.countryList'
		id="proximityCountry" headerKey="" headerValue="%{pageContent['contactUsView.chooseOneContent']}"
		requiredLabel="true" listKey="key" listValue="key"
		cssClass="formFieldDefault"
		value="selectedCountry" />
</td>

<td>
		<s:select name="contactUsInfo.state"
		list="countryState.countryList['Canada'].entrySet()" 
		id="proximityState" headerKey="" headerValue="%{pageContent['contactUsView.chooseOneContent']}"
		requiredLabel="true" listKey="key" listValue="value"
		cssClass="formFieldDefault"
		value="selectedState" />
</td>

</s:form>
</tr>
</table>
<hr/>

<hr/>
fred 6
<table>
<tr>
<s:form action="contact-us-submit" namespace="/">
<td>
	<s:select name="country"
		list='countryState.countryList'
		id="proximityCountry" headerKey="" headerValue="%{pageContent['contactUsView.chooseOneContent']}"
		requiredLabel="true" listKey="key" listValue="key"
		cssClass="formFieldDefault"
		value="selectedCountry" />
</td>

<td>
		<s:select name="state"
		list="countryState.countryList['Canada'].entrySet()" 
		id="proximityState" headerKey="" headerValue="%{pageContent['contactUsView.chooseOneContent']}"
		requiredLabel="true" listKey="key" listValue="value"
		cssClass="formFieldDefault"
		value="selectedState" />
</td>

</s:form>
</tr>
</table>
<hr/>

<hr/>
ted 1
<table>
<tr>
<s:form action="abcv" method="post">
<td>
<s:set name="serverList" value="#{'101':'AppServer', '202':'Database'}" />
<s:set name="serverList2" 
     value="#{'101': #{'11':'Apache', '12':'Tomcat', '13':'JBoss'}, '202': #{'21':'Oracle', '22':'MySQL'}}" />

<s:doubleselect label="Server (OGNL) "
name="server1" list="#serverList.keys" listValue="#serverList[top]"
doubleName="server2" doubleList="#serverList2[top]" doubleListKey="key" 
doubleListValue="value"/>
</td>
</s:form>
</tr>
</table>
<hr/>

<hr/>
jim 1
<table>
<tr>
<s:form action="defrd" method="post">
<td>
<s:doubleselect label="Language (Java List) " 
name="language1" list="languageMap.keySet()" 
doubleName="language2" doubleList="languageMap.get(top)" />
</td>
<td>
<s:submit value="submit" name="submit" />
</td>
</s:form>
</tr>
</table>
<hr/>

<hr/>
bill 6b
<table>
<tr>
<s:form action="unique_1" method="post">
<td>
<s:doubleselect 
name="country" list="countryState.countryList" 
requiredLabel="true" listKey="key" listValue="key"
doubleName="state" 
doubleList="countryState.countryList.get(top)" 
doubleListKey="value" doubleListValue="key" 
/>
</td>
</s:form>
</tr>
</table>
<hr/>

<hr/>
rats 3
<table>
<tr>
<s:form action="unique_11" method="post">
<td>
<s:doubleselect 
name="country" list="countryState.countryList.keySet()" 
doubleName="state" 
doubleList="countryState.countryList.get(top)" 
doubleListKey="key" doubleListValue="value" 
/>
</td>
</s:form>
</tr>
</table>
<hr/>


<%--
<table>
<tr>
<s:form action="abcv" method="post">
<td>
<s:doubleselect 
name="contactUsInfo.state" list="countryState.stateList['CA'].entrySet()" 
requiredLabel="true" listKey="key" listValue="value"
doubleName="contactUsInfo.country" 
doubleList="countryState.countryList" 
doubleListKey="key" doubleListValue="value" 
/>
</td>
</s:form>
</tr>
</table>
<hr/>
--%>

<%--
<table>
<tr>
<s:form action="abcv" method="post">
<td>
<s:doubleselect label="Countries (OGNL) " 
name="fruit1" list="{'fruit','meat'}" 
doubleName="fruit2" 
doubleList="top == 'fruit' ? {'apple', 'orange','banana'} : {'chicken', 'pig'}" />
</td>
</s:form>
</tr>
</table>
<hr/>
--%>

<%--
<table>
<tr>
<s:form action="ghj" method="post">
<s:set name="serverList" 
     value="#{'AppServer': {'01' : 'Apache', '02' : 'Tomcat', '03' : 'JBoss'}, 'Database': {'04' : 'Oracle', '05' : 'MySQL'} }" />
<td>
<s:doubleselect label="Server (OGNL) " 
name="server1" list="#serverList.keySet()" 
doubleListKey="key" doubleListValue="value" 
doubleName="server2" doubleList="#serverList[top]" 
/>
</td>
</s:form>
</tr>
</table>
--%>

<hr/>

