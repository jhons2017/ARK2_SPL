<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/FlowBuilder.tld" prefix="FlowBuilder" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<html>
<head>
	<title>FlowBuilder</title>												
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link href="/FlowBuilder/css/flowbuilder_global.css" tppabs="octopz_global.css" rel="stylesheet" type="text/css" />
	<link href="/FlowBuilder/css/flowbuilder_internal.css" tppabs="octopz_internal.css" rel="stylesheet" type="text/css" />
	<script src="/FlowBuilder/css/flowbuilder.js" tppabs="octopz.js" language="javascript" type="text/javascript"></script>
</head>
<br/><br/><br/><br/><br/>
<BODY BGCOLOR="#FFFFFF" LEFTMARGIN="0" TOPMARGIN="0" MARGINWIDTH="0" MARGINHEIGHT="0">
	<div id="container">
			<div id="left">
			<div id="topleft">
				<div id="buttons">
		    		<ul>
					</ul>			
				</div>
			  </div>
				<div id="bottomleft">
				</div>
			</div>
	<div id="content">
	<table bgcolor='#999999' align=center border=0 cellpadding=1 cellspacing=1 width='100%'>
		<tr bgcolor='#efefef' align='center' valign='middle'>
			<td height="30" width='100%' nowrap> 組織名称／役割名称 </td>	
		</tr>
		<logic:iterate id="orgSummary" name="orgSummaryList" type="flowbuilder.view.orglist.OrgDTO" indexId="index">
		<tr align='center' bgcolor='#ffffff' valign='middle' onMouseOut ="this.style.backgroundColor='#FFFFFF'">
			<td height=25 nowrap>
				<bean:define id="orgId" name="orgSummary" property="orgId" />
				<bean:define id="roleId" name="orgSummary" property="roleId" />
				<html:link page='<%="/do/flowbuilder/JobList?method=jobDetail&amp;orgId=" + orgId + "&amp;roleId=" + roleId%>' styleClass="go">
					<bean:write name="orgSummary" property="orgName"/>／<bean:write name="orgSummary" property="roleName"/>
				</html:link>
			</td>
		</tr>
		</logic:iterate>

	</table>
		<h6 align="left"></h6><p><br />
		</p>
		<p><br />
		</p>
<BR>
<BR>
<BR>
<BR>
<BR>
<BR>
<BR>
<BR>
  </div>

			<div id="clearbottom">&nbsp;</div>

<div id="footer">
  <div id="copyright">Copyright © 2007 華夏計算機技術有限公司</div>
</div>
</div>
	
	
	
	<!--
	
	<div align="center">
	<table align=center border=0 cellpadding=1 cellspacing=1 width="50%">
		<tr> </br>
			<td width=300 align="left"><img src="/FlowBuilder/images/orgSelect.gif"></img></td>
		</tr>
	</table>
	<table align=center border=0 cellpadding=1 cellspacing=1 width="80%">
		<tr> 
			<td>
			
	<table bgcolor='#999999' align=center border=0 cellpadding=1 cellspacing=1 width='60%'>
		<tr bgcolor='#efefef' align='center' valign='middle'>
			<td height=22 width='100%' nowrap> 組織名称／役割名称 </td>	
		</tr>
		<logic:iterate id="orgSummary" name="orgSummaryList" type="flowbuilder.view.orglist.OrgDTO" indexId="index">
		<tr align='center' bgcolor='#ffffff' valign='middle' onMouseOut ="this.style.backgroundColor='#FFFFFF'">
			<td height=25 nowrap>
				<bean:define id="orgId" name="orgSummary" property="orgId" />
				<bean:define id="roleId" name="orgSummary" property="roleId" />
				<html:link page='<%="/do/flowbuilder/JobList?orgId=" + orgId + "&amp;roleId=" + roleId%>' styleClass="go">
					<bean:write name="orgSummary" property="orgName"/>／<bean:write name="orgSummary" property="roleName"/>
				</html:link>
			</td>
		</tr>
		</logic:iterate>

	</table>
	<p>&nbsp;</p>
	</div>
	-->
</BODY>
</html>
