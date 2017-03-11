<#if parameters.get("image")?exists>
	<#if parameters.prefix?exists>
		<#assign prefix = parameters.prefix/>
	<#else>
		<#assign prefix = 'misc'/>
	</#if>
	<#assign path="https://images.hertz.com/herc/herc/"+prefix+"/"+parameters.image />
<img
<#if parameters.cssClass?exists>
 class="${parameters.cssClass?html}"<#rt/>
</#if>
 alt="${parameters.alt?default("")?html}"<#rt/>
 src="${path?html}"<#rt/>
 />
</#if>