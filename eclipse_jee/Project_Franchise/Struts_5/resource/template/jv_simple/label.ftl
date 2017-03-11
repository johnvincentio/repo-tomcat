<#--
/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
-->

<#assign hasFieldErrors = parameters.name?exists && fieldErrors?exists && fieldErrors[parameters.name]?exists/>
<#if parameters.labelposition?default("td") == 'td'>
<td><#rt/>
</#if>

<label <#rt/>
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
</label><#rt/>
<#if parameters.labelposition?default("td") == 'td'>
</td><#lt/>
</#if>
