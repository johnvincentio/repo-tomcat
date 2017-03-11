<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
	<title><tiles:insertAttribute name="title" /></title>
</head>

<body>
<table width="100%" cellpadding="0" cellspacing="0" border="0">
	<tr valign="top">
		<td width="175">
			<table width="175" cellpadding="4" cellspacing="0" border="0">
				<tr valign="top">
					<td width="175">
						<tiles:insertAttribute name="menu" />
					</td>
				</tr>
			</table>
		</td>

		<td width="510">
			<table width="510" cellpadding="5" cellspacing="5" border="0">
				<tr valign="top">
					<td width="510">
						<tiles:insertAttribute name="body" />
					</td>
				</tr>
				<tr valign="top">
					<td width="510">
						<tiles:insertAttribute name="footer" />
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>
