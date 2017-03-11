<#if (fieldErrors?exists && (fieldErrors?size > 0)) || (actionErrors?exists && (actionErrors?size > 0))>
	<div>        
		<ul class="errorList"><#rt/>
	<#list actionErrors as error>
		<li>${error?html}</li><#rt/>
	</#list>		
	<#assign keys = fieldErrors?keys>
	<#list keys as key>
		<#list fieldErrors[key] as errorMessage>
			<li>${errorMessage?html}</li><#rt/>
		</#list>
	</#list>
		</ul><#rt/>
	</div><#rt/>
</#if>