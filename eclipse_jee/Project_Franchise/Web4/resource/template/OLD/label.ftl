<#assign hasFieldErrors = parameters.name?exists && fieldErrors?exists && fieldErrors[parameters.name]?exists/>
<#if parameters.labelposition?default("td") == 'td'>
<td><#rt/>
</#if>
	<label <#t/>
<#if parameters.id?exists>
		for="${parameters.id?html}" <#t/>
</#if>
<#if hasFieldErrors>
		class="errorField"<#t/>
<#else>
		class="formFieldDefault"<#t/>
</#if>
	><#t/>
		${parameters.label?html}<#t/>:<#t/>
<#if parameters.required?default(false)>
        <span class="required">*</span><#t/>
</#if>
<#include "/${parameters.templateDir}/xhtml/tooltip.ftl" /> 
	</label><#t/>
<#if parameters.labelposition?default("td") == 'td'>
</td><#lt/>
</#if>
