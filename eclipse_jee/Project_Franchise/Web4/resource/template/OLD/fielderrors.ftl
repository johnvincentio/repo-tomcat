<#assign hasErrors = fieldErrors?exists/>
<#if hasErrors && (fieldErrors?size > 0)>
	<#assign keys = fieldErrors?keys>
	<div>   
		<ul class="errorList"><#rt/>
	<#list keys as key>
		<#list fieldErrors[key] as errorMessage>
			<li>${errorMessage?html}</li><#rt/>
		</#list>
	</#list>
		</ul><#rt/>
	</div><#rt/>
</#if>