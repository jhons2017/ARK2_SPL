<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="FlowBuilder" uri="/WEB-INF/FlowBuilder.tld" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<html>
<head>
<title>ワークフローシステム</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="expires" content="0">
</head>
<SCRIPT type="text/javascript" src="/FlowBuilder/scripts/chiphelp.js"></SCRIPT>
<BODY BGCOLOR="#FFFFFF" LEFTMARGIN="0" TOPMARGIN="0" MARGINWIDTH="0" MARGINHEIGHT="0">
	<div id="container">

<div id="content">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr> 
			<td></td>
			<td align="left" valign="middle"><img src="/FlowBuilder/images/list.gif"></img></td>
		</tr>
	</table>
	<table bgcolor="#AABBDD" align="center" width="80%" cellpadding="0" cellspacing="0">
		<tr bgcolor="#FFFFFF"> 
			<td height=30 align="right">
			<bean:define id="pInfo" name="pageinfo" type="flowbuilder.presentation.webcmn.taglibs.domain.page.PageInfo" scope="session"/>
			<bean:define id="userId" name="user" property="userId" type="java.lang.String" scope="session"/>
			<bean:define id="orgId" name="user" property="orgId" type="java.lang.String" scope="session"/>
			<bean:define id="userRole" name="user" property="userRole" type="flowbuilder.domain.user.UserRole" scope="session"/>
			</td>
		</tr>
		<tr bgcolor="#FFFFFF"> 
			<td>
			<!--案件一覧表示部品-->
				<FlowBuilder:partJobList pageInfo="<%=pInfo%>" orgId="<%=orgId%>" userId="<%=userId%>" userRole="<%=userRole%>" partXml="<%=
				"<部品>" +
					"<template id='0001' title='セキュリティ申込書'>" +
						"<con status='マネージャ承認'>" +
							"<user role='部長' org='*,SI事業部' userid=''/>"+
						"</con>"+
						"<con status='グループ長承認'>" +
							"<user role='部長' org='*,SI事業部' userid=''/>"+
						"</con>"+
						"<con status='部長承認'>" +
							"<user role='部長' org='SI事業部' userid=''/>"+
						"</con>"+
						"<con status='SI事業部長承認'>" +
							"<user role='部長' org='*' userid=''/>"+
						"</con>"+
						"<con status='開通状態'>" +
							"<user role='部長' org='*' userid=''/>"+
						"</con>"+
					"</template>" +
					"<template id='0002' title='設備申請'>" +
						"<con status='部長承認'>" +
							"<user role='部長' org='SI事業部' userid=''/>"+
						"</con>"+
						"<con status='SI事業部長承認'>" +
							"<user role='部長' org='*' userid=''/>"+
						"</con>"+
						"<con status='開通'>" +
							"<user role='部長' org='*' userid=''/>"+
							"<user role='部長' org='SI事業部' userid=''/>"+
						"</con>"+
						"<con status='中止'>" +
							"<user role='部長' org='*' userid=''/>"+
							"<user role='部長' org='SI事業部' userid=''/>"+
						"</con>"+
					"</template>" +
					"<template id='0003' title='回覧票'>" +
						"<con status='回覧中'>" +
							"<user role='部長' org='*' userid=''/>"+
						"</con>"+
						"<con status='回覧済'>" +
							"<user role='部長' org='*' userid=''/>"+
						"</con>"+
						"<con status='中止'>" +
							"<user role='部長' org='*' userid=''/>"+
						"</con>"+
					"</template>" +
					"<template id='0004' title='休暇申請'>" +
						"<con status='部長承認'>" +
							"<user role='部長' org='財務総務部' userid=''/>"+
						"</con>"+
						"<con status='総務部長承認'>" +
							"<user role='部長' org='*' userid=''/>"+
						"</con>"+
						"<con status='開通状態'>" +
							"<user role='部長' org='*' userid=''/>"+
							"<user role='部長' org='財務総務部' userid=''/>"+
						"</con>"+
						"<con status='中止'>" +
							"<user role='部長' org='*' userid=''/>"+
							"<user role='部長' org='財務総務部' userid=''/>"+
						"</con>"+
					"</template>" +
					"<template id='0005' title='出張申请'>" +
						"<con status='部長承認'>" +
							"<user role='室長' org='総経理室' userid=''/>"+
						"</con>"+
						"<con status='総経理室長承認'>" +
							"<user role='部長' org='*' userid=''/>"+
						"</con>"+
						"<con status='関連者回覧中'>" +
							"<user role='部長' org='*' userid=''/>"+
							"<user role='室長' org='総経理室' userid=''/>"+
						"</con>"+
						"<con status='総経理承認'>" +
							"<user role='部長' org='*' userid=''/>"+
							"<user role='室長' org='総経理室' userid=''/>"+
						"</con>"+
						"<con status='開通状態'>" +
							"<user role='部長' org='*' userid=''/>"+
							"<user role='室長' org='総経理室' userid=''/>"+
						"</con>"+
						"<con status='中止'>" +
							"<user role='部長' org='*' userid=''/>"+
							"<user role='室長' org='総経理室' userid=''/>"+
						"</con>"+
					"</template>" +
					"<template id='0006' title='残業申请'>" +
						"<con status='部長承認'>" +
							"<user role='室長' org='総経理室' userid=''/>"+
						"</con>"+
						"<con status='総経理室長承認'>" +
							"<user role='部長' org='*' userid=''/>"+
						"</con>"+
						"<con status='関連者回覧中'>" +
							"<user role='部長' org='*' userid=''/>"+
							"<user role='室長' org='総経理室' userid=''/>"+
						"</con>"+
						"<con status='総経理承認'>" +
							"<user role='部長' org='*' userid=''/>"+
							"<user role='室長' org='総経理室' userid=''/>"+
						"</con>"+
						"<con status='開通状態'>" +
							"<user role='部長' org='*' userid=''/>"+
							"<user role='室長' org='総経理室' userid=''/>"+
						"</con>"+
						"<con status='中止'>" +
							"<user role='部長' org='*' userid=''/>"+
							"<user role='室長' org='総経理室' userid=''/>"+
						"</con>"+
					"</template>" +
				"</部品>"
				%>" />
			</td>
		</tr>
		<tr bgcolor='#ffffff'>
			<td>
				<table width=100px align=right border=0 cellpadding=1 cellspacing=1>
					<tr height=15px></tr>
					<tr>
						<td width=25px>
							<html:link page='<%="/do/flowbuilder/JobList?method=showFirst"%>'> <img src='/FlowBuilder/images/arrow_left.gif' alt='firt'> </html:link>
						</td>
						<td width=25px>
							<html:link page='<%="/do/flowbuilder/JobList?method=showPrivious"%>'> <img src='/FlowBuilder/images/previous.gif' alt='previous'> </html:link>
						</td>
						<td>
							<bean:write name="pInfo" property="currentPage"/>/<bean:write name="pInfo" property="pageCountNumber"/>
						</td>
						<td width=25px>
							<html:link page='<%="/do/flowbuilder/JobList?method=showNext"%>'> <img src='/FlowBuilder/images/next.gif' alt='next'> </html:link>
						</td>
						<td width=25px>
							<html:link page='<%="/do/flowbuilder/JobList?method=showLast"%>'> <img src='/FlowBuilder/images/arrow_right.gif' alt='last'> </html:link>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

<!-- ポスト用フォーム -->
	<form name="JobMakeForm" action="JobShow?method=open" method="post" accept="utf-8">
		<input type="hidden" name="userId" value="<%=userId%>">
		<input type="hidden" name="orgId" value="<%=orgId%>">
		<input type="hidden" name="jobfile" >
		<input type="hidden" name="jobId" >
		<input type="hidden" name="templateId" >
		<input type="hidden" name="view" >
		<input type="hidden" name="act" >
		
	<html:hidden property="method" value="error"/>
		<bean:define id="sessionNo" name="sessionNo" scope="request"/>
		<input type="hidden" name="fromlist" value="<%=sessionNo%>">
	</form>	
	<p>&nbsp;</p>
		<h6 align="left"></h6><p><br />
		</p>
		<p><br />
		</p>
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
</body>
</html>