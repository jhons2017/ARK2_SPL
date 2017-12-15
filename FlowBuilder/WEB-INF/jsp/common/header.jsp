<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Shift_JIS" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html:html>
<head>
	<title></title>												
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link href="/FlowBuilder/css/flowbuilder_global.css"  rel="stylesheet" type="text/css" />
	<link href="/FlowBuilder/css/flowbuilder_internal.css"  rel="stylesheet" type="text/css" />
</head>
<body>
<div id="container">
<div id="header">
	<div id="headerright">
			<div id="icons">
			<ul>
				<br>
				<html:link forward="logout" >
				<img border="0" src="/FlowBuilder/images/logout.gif" alt="���O�A�E�g��">
				</img>
				</html:link>
			</ul>
		</div>
	</div>
	<img src="/FlowBuilder/images/flowbuilder_logo.jpg"  alt="�؉Ď��u�Ǘ��n��" width="223" height="99" hspace="13" />
	<logic:present name="sessionMap">
        <p class="tagline1">�g�D�F<bean:write name="sessionMap" property="orgName"/></p>
        <p class="tagline2">�����F<bean:write name="sessionMap" property="roleName"/></p>
        <p class="tagline3">���O�F<bean:write name="sessionMap" property="userName"/></p>
   </logic:present>
</div>
<div id="navigation">
	<ul id="nav">
	</ul>
</div>
</body>
</html:html>
