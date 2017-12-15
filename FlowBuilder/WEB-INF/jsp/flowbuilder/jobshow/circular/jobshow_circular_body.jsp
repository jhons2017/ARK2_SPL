<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/FlowBuilder.tld" prefix="FlowBuilder"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="javax.servlet.http.*" %>

<html>
<head>
<title>ドキュメントXML管理システム</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="expires" content="0">
</head>
<SCRIPT type="text/javascript" src="/FlowBuilder/scripts/flowbuilder.js"></SCRIPT>
<BODY BGCOLOR="#FFFFFF" LEFTMARGIN="0" TOPMARGIN="0" MARGINWIDTH="0" MARGINHEIGHT="0">
	<div id="container">
	<div id="content">
	<bean:define id="orgId" name="user" property="orgId" type="java.lang.String" scope="session"/>
	<bean:define id="userId" name="user" property="userId" type="java.lang.String" scope="session"/>
	<bean:define id="jobId" name="JobShow" property="jobId" type="java.lang.String" scope="request"/>
	<bean:define id="templateId" name="JobShow" property="templateId" type="java.lang.String" scope="request"/>
	<bean:define id="view" name="JobShow" property="view" type="java.lang.String" scope="request"/>
	<bean:define id="jobFileName" name="JobShow" property="jobFileName" type="java.lang.String" scope="request"/>
	<bean:define id="job" name="JobShow" property="job" type="org.w3c.dom.Document" scope="request"/>
	<bean:define  id="userIp" name="JobShow" property="userIp" type="java.lang.String" scope="request"/>
	<div id="content">
	<table width="60%" border="0" cellspacing="0" cellpadding="0">
		<tr> 
			<td></td>
			<td width="400" align="left" valign="middle" nowrap><img src="/FlowBuilder/images/circular.gif"></img></td>
			<td width="120" nowrap>起案人：<bean:write name="JobShow" property="userName"/></td>
			<td width="130" nowrap>社員番号：<bean:write name="JobShow" property="userId"/></td>
			<td width="160" nowrap>IP：<bean:write name="JobShow" property="userIp"/></td>
		</tr>
	</table>
	<table bgcolor="#AABBDD" align="center" width="740" cellpadding="0" cellspacing="0">
		<tr bgcolor="#FFFFFF"> 
			<td height=30 align="right">
				<!--動作制御部品-->
				<FlowBuilder:partOperator job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
			"<部品>" +
				"<step name='案件起案'>" +
					"<opr id='start' user='案件作成:作成者' role='' vital_check='1'/>" +
					"<opr id='save' user='案件作成:作成者' role='' vital_check='0'/>" +
					"<opr id='disposal' user='案件作成:作成者' role='' vital_check='0'/>" +
				"</step>" +
				"<step name='回覧中'>" +
					"<opr id='returnSelf' user='案件作成:作成者' role=''  org='' vital_check='0'/>" +
				"</step>" +
				"<step name='回覧済'>" +
					"<opr id='stop' user='案件作成:作成者' role='' vital_check='0'/>" +
				"</step>" +
				"<step name='中止状態'>" +
					"<opr id='delete' user='' role='システム管理者' vital_check='0'/>" +
				"</step>" +
			"</部品>"
				%>" />
			</td>
		</tr>
		<tr bgcolor="#FFFFFF"> 
			<td height=30 align="right">
				<table bgcolor="#999999" align="center" border="0" cellpadding="1" cellspacing="1" width="740">
					<form name="JobDetailForm" method="post" enctype="multipart/form-data">
					<tr bgcolor="#efefef" align="center" valign="middle"> 
						<td height=30 colspan=2 ><font color="blue">回　覧　票</font></td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td height=25 width=80  nowrap>回覧タイトル</td>
						<td height=25 width=400 >
							<!--案件名部品-->
							<FlowBuilder:partJobName job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
							"<部品>" +
								"<タグ name='fb_jobname' style='HEIGHT: 22px; WIDTH: 300px' />" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='案件起案/案件作成:作成者,中止状態/案件作成:作成者' role='回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者,回覧済/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"</部品>"
								%>"
								check = "<%=
									"<Checks partName='回覧タイトル'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateLength' htmlId='fb_jobname' min='1' max='100'/>" +
											"<CheckItem type='ValidateNull' htmlId='fb_jobname'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
				</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td>回覧内容</td>
						<td height=25 >
						<!--多行の輸入のわく部品-->
						<FlowBuilder:partTextArea job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
						"<部品>" +
							"<タグ name='comment' style='HEIGHT: 22px; WIDTH: 400px' rows='5' cols='50'/>" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='案件起案/案件作成:作成者,中止状態/案件作成:作成者' role='回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者,回覧済/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者' org=''/>" +
							"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
						"</部品>"
							%>" 
							check = "<%= 
									"<Checks partName='回覧内容'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='comment'/>" +
											"<CheckItem type='ValidateLength' htmlId='comment' min='1' max='1000'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>						
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td height=25 width=70  nowrap>回覧期間</td>
						<td height=25 width=400 >
						<!--COMBOX選択部品-->
						<FlowBuilder:partSelectDate job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
					"<部品>" +
						"<タグ name='startdate/enddate' value='開始日/結束日' calendar='1/1' style='HEIGHT: 22px; WIDTH: 120px' />" +
						"<非表示 user='' role='' org=''/>" +
						"<表示 user='案件起案/案件作成:作成者,中止状態/案件作成:作成者' role='回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者,回覧済/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者' org=''/>" +
						"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
						"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
					"</部品>"
						%>" 
						check = "<%= 
						"<Checks partName='回覧期間'>" +
							"<Condition value='案件起案'>" +
								"<CheckItem type='ValidateNull' htmlId='startdate'/>" +
								"<CheckItem type='ValidateNull' htmlId='enddate'/>" +
								"<CheckItem type='ValidateDateFromTo' startTime='startdate' endTime='enddate'/>" + 
							"</Condition>" +
							"</Checks>"%>"/>																
						</td>
					</tr>
					<!--アップロード部品-->
					<FlowBuilder:partUpload job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
					"<部品>" +
						"<タグ name='upload' uploadLable='起案者添付資料' downLoadLable='起案者添付資料' state='案件起案' />" +
						"<非表示 user='' role='' org=''/>" +
						"<表示 user='案件起案/案件作成:作成者' role='回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者,回覧済/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者' org=''/>" +
						"<編集 user='案件起案/案件作成:作成者' role=''/>" +
					"</部品>"
						%>" />
					<tr align="left" bgcolor="#ffffff" valign="middle">
							<td>印刷</td>
							<td height=25 >
						<!--入力部品-->
							<FlowBuilder:partPrint job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
						"<部品>" +
							"<タグ name='print'/>" +
							"<表示 user='回覧済/案件作成:作成者' role='回覧済/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者' org=''/>" +
						"</部品>"
							%>" />
						</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td colspan="2">
						<!--テストエリア部品-->
							<FlowBuilder:partCircular job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
								"<部品>" +
									"<タグ name='circular'/>" +
									"<表示 user='案件起案/案件作成:作成者,中止状態/案件作成:作成者' role='回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者,回覧済/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者' org=''/>" +
									"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
									"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
									"<非表示 user='' role='' org=''/>" +
									"<ボタングルプ name='buttonGrp'>" +
										"<button name='question' value='問題あり'/>" +
										"<button name='kakuninn' value=' 確認済 '/>" +
										"<button name='apply' value=' 処理済 '/>" +
									"</ボタングルプ>" +
								"</部品>"
							%>" 						
							check = "<%= 
								"<Checks partName='回覧意見'>" +
									"<Condition value='案件起案'>" +
										"<CheckItem type='ValidateNull' htmlId='circularID'/>" +
									"</Condition>" +
									"<Condition value='回覧中'>" +
										"<CheckItem type='ValidateNull' htmlId='circular'/>" +
									"</Condition>" +
									"</Checks>"%>"/>																
						</td>
					</tr>
					<input type="hidden" name="userIp" value="<%=userIp%>"/>
					<input type="hidden" name="jobId" value="<%=jobId%>">
					<input type="hidden" name="userId" value="<%=userId%>">
					<input type="hidden" name="orgId" value="<%=orgId%>">
					<input type="hidden" name="templateId" value="<%=templateId%>">
					<input type="hidden" name="view" value="<%=view%>">
					<input type="hidden" name="operator">
					<input type="hidden" name="act">
					<bean:define id="sessionNo" name="sessionNo" scope="request"/>
					<input type="hidden" name="fromview" value="<%=sessionNo%>">
					<bean:define id="sessionNo" name="sessionNo" scope="request"/>
					<input type="hidden" name="fromview" value="<%=sessionNo%>">
					</form>
				</table>
			</td>
		</tr>
	</table>
	</div>
  </div>
<div id="clearbottom">&nbsp;</div>
<div id="footer">
<div id="copyright">Copyright © 2007 華夏計算機技術有限公司</div>
</div>
</div>
</body>
</html>
