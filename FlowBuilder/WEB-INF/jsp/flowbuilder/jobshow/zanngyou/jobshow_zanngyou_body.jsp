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
			<td width="400" align="left" valign="middle" nowrap><img src="/FlowBuilder/images/zanngyouTrip.gif"></img></td>
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
					"<opr id='start' user='案件作成:作成者' role='' org='' vital_check='1'/>" +
					"<opr id='save' user='案件作成:作成者' role='' org='' vital_check='0'/>" +
					"<opr id='disposal' user='案件作成:作成者' role='' org='' vital_check='0'/>" +
				"</step>" +
				"<step name='部長承認'>" +
					"<opr id='returnSelf' user='案件作成:作成者' role=''  org='' vital_check='0'/>" +
					"<opr id='confirm' user='' role='部長'  org='*' vital_check='1'/>" +
					"<opr id='return' user='' role='部長'  org='*' vital_check='1'/>" +
				"</step>" +
				"<step name='総経理室長承認'>" +
					"<opr id='confirm' user='' role='室長'  org='' vital_check='1'/>" +
					"<opr id='save' user='' role='室長' org='' vital_check='1'/>" +
					"<opr id='return' user='' role='室長'  org='' vital_check='1'/>" +
				"</step>" +
				"<step name='総経理承認'>" +
					"<opr id='confirm' user='' role='総経理'  org='' vital_check='1'/>" +
					"<opr id='return' user='' role='総経理'  org='' vital_check='1'/>" +
				"</step>" +
				"<step name='開通状態'>" +
					"<opr id='confirm' user='総経理室長承認:承認者' role=''  org='' vital_check='0'/>" +
				"</step>" +
				"<step name='中止状態'>" +
					"<opr id='delete' user='' role='システム管理者'  org='' vital_check='0'/>" +
				"</step>" +
			"</部品>"
				%>" />
			</td>
		</tr>
		<tr bgcolor="#FFFFFF"> 
			<td height=30 align="right">
				<table bgcolor="#999999" align=center border=0 cellpadding=1 cellspacing=1 width="740">
					<form name="JobDetailForm" method="post" enctype="multipart/form-data">
					<tr bgcolor="#efefef" align="center" valign="middle"> 
						<td height=30 colspan=2 >案　件　内　容</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td>起案者イメージ</td>
						<td height=25 >
						<!--影像部品-->
						<FlowBuilder:partImage job="<%=job%>" userId="<%=userId%>" partXml="<%=
						"<部品>" +
							"<option path='/FlowBuilder/images/userImages/' height='70' width='70'/>" +
						"</部品>"
							%>" />
						</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td height=25 width=150  nowrap>案　件　名</td>
						<td height=25 width=400 >
							<!--案件名部品-->
							<FlowBuilder:partJobName job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
							"<部品>" +
								"<タグ name='fb_jobname' style='HEIGHT: 22px; WIDTH: 300px' />" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"</部品>"
								%>"
								check = "<%=
									"<Checks partName='案　件　名'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateLength' htmlId='fb_jobname' min='1' max='100'/>" +
											"<CheckItem type='ValidateNull' htmlId='fb_jobname'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td  nowrap>申請者所属</td>
						<td height=25 >
							<!--入力部品-->
							<FlowBuilder:partInput job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
							"<部品>" +
								"<タグ name='department' style='HEIGHT: 22px; WIDTH: 300px' />" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"</部品>"
								%>"
								check = "<%=
									"<Checks partName='申請者所属'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='department'/>" +
											"<CheckItem type='ValidateLength' htmlId='department' min='1' max='30'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td nowrap>残業項目</td>
						<td height=25 >
							<!--入力部品-->
							<FlowBuilder:partInput job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
							"<部品>" +
								"<タグ name='objectAdress' style='HEIGHT: 22px; WIDTH: 300px' />" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"</部品>"
								%>"
								check = "<%= 
									"<Checks partName='残業項目'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='objectAdress'/>" +
											"<CheckItem type='ValidateLength' htmlId='objectAdress' min='1' max='30'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td nowrap>交通手段</td>
						<td height=25>
							<!--RADIOBOX選択部品-->
							<FlowBuilder:partRadioBox job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
							"<部品>" +
								"<タグ name='trafficTool' style='HEIGHT: 22px; WIDTH: 40px'/>" +
								"<非表示 user='' role=''/>" +
								"<表示 user='部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role=''/>" +
								"<content name='飛行機,タクシー,車,電車,船,その他' defalut='飛行機'/>" +
							"</部品>"
								%>"
								check = "<%=
									"<Checks partName='交通手段'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateRadioNull' htmlId='trafficTool'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td height=25 width=150  nowrap>残業時間</td>
						<td height=25 width=400 >
						<!--COMBOX選択部品-->
						<FlowBuilder:partSelectDate job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
					"<部品>" +
						"<タグ name='startdate/enddate' value='開始日/結束日' calendar='1/1' style='HEIGHT: 22px; WIDTH: 120px' />" +
						"<非表示 user='' role='' org=''/>" +
						"<表示 user='部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
						"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
						"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
					"</部品>"
						%>" 
						check = "<%= 
						"<Checks partName='残業時間'>" +
							"<Condition value='案件起案'>" +
								"<CheckItem type='ValidateNull' htmlId='startdate'/>" +
								"<CheckItem type='ValidateNull' htmlId='enddate'/>" +
								"<CheckItem type='ValidateDateFromTo' startTime='startdate' endTime='enddate'/>" + 
							"</Condition>" +
							"</Checks>"%>"/>																
						</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td nowrap>残業管理責任者</td>
						<td height=25 >
							<!--入力部品-->
							<FlowBuilder:partInput job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
							"<部品>" +
								"<タグ name='dutyer' style='HEIGHT: 22px; WIDTH: 300px' />" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"</部品>"
								%>"
								check = "<%= 
									"<Checks partName='残業管理責任者'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='dutyer'/>" +
											"<CheckItem type='ValidateLength' htmlId='dutyer' min='1' max='10'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td nowrap>責任者の連絡方法</td>
						<td height=25 >
							<!--入力部品-->
							<FlowBuilder:partInput job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
							"<部品>" +
								"<タグ name='contract' style='HEIGHT: 22px; WIDTH: 300px' />" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"</部品>"
								%>"
								check = "<%= 
									"<Checks partName='責任者の連絡方法'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='contract'/>" +
											"<CheckItem type='ValidateLength' htmlId='contract' min='1' max='20'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td>残業理由</td>
						<td height=25 >
						<!--多行の輸入のわく部品-->
						<FlowBuilder:partTextArea job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
						"<部品>" +
							"<タグ name='applyReason' style='HEIGHT: 22px; WIDTH: 400px' rows='5' cols='50'/>" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
							"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
						"</部品>"
							%>" 
							check = "<%= 
									"<Checks partName='残業理由'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='applyReason'/>" +
											"<CheckItem type='ValidateLength' htmlId='applyReason' min='1' max='1000'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>						
					</tr>
										<tr align="left" bgcolor="#ffffff" valign="middle">
						<td>作業責任者</td>
						<td height=25 >
						<!--入力部品-->
						<FlowBuilder:partInput job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
						"<部品>" +
							"<タグ name='recommendationer' style='HEIGHT: 22px; WIDTH: 400px' />" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
							"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
						"</部品>"
							%>" 
							check = "<%= 
									"<Checks partName='作業責任者'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='recommendationer'/>" +
											"<CheckItem type='ValidateLength' htmlId='recommendationer' min='1' max='10'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>						
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td>作業日</td>
						<td height=25 >
						<!--入力部品-->
						<FlowBuilder:partDate job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
						"<部品>" +
							"<タグ name='recommendationDate' style='HEIGHT: 22px; WIDTH: 100px' />" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
							"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
						"</部品>"
							%>" 
							check = "<%= 
									"<Checks partName='作業日'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='recommendationDate'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>						
					</tr>
					<!--アップロード部品-->
						<FlowBuilder:partUpload job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
					"<部品>" +
						"<タグ name='upload' uploadLable='起案者添付資料 ' downLoadLable='起案者添付資料 ' state='案件起案' />" +
						"<非表示 user='' role='' org=''/>" +
						"<表示 user='部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
						"<編集 user='案件起案/案件作成:作成者' role=''/>" +
					"</部品>"
						%>" />
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td>部長からのコメント</td>
						<td height=25 >
						<!--多行の輸入のわく部品-->
							<FlowBuilder:partTextArea job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
						"<部品>" +
							"<タグ name='buchouComment'  rows='5' cols='50'/>" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='案件起案/案件作成:作成者,部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
							"<編集 user='' role='部長承認/部長' org='*'/>" +
							"<必須 user='' role='部長承認/部長' org='*'/>" +
						"</部品>"
							%>"
							check = "<%= 
									"<Checks partName='部長からのコメント'>" +
										"<Condition value='部長承認'>" +
											"<CheckItem type='ValidateNull' htmlId='buchouComment'/>" +
											"<CheckItem type='ValidateLength' htmlId='buchouComment' min='1' max='1000'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td>室長からのコメント</td>
						<td height=25 >
						<!--多行の輸入のわく部品-->
							<FlowBuilder:partTextArea job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
							"<部品>" +
								"<タグ name='shiTuChouComment'  rows='5' cols='50'/>" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='案件起案/案件作成:作成者,部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
								"<編集 user='' role='総経理室長承認/室長' org=''/>" +
								"<必須 user='' role='総経理室長承認/室長' org=''/>" +
							"</部品>"
								%>"
								check = "<%= 
									"<Checks partName='室長からのコメント'>" +
										"<Condition value='総経理室長承認'>" +
											"<CheckItem type='ValidateNull' htmlId='shiTuChouComment'/>" +
											"<CheckItem type='ValidateLength' htmlId='shiTuChouComment' min='1' max='1000'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>
					</tr>	
					<!--アップロード部品-->
					<FlowBuilder:partUpload job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
					"<部品>" +
						"<タグ name='uploadShitucyou' uploadLable='室長資料アップロード' downLoadLable='室長資料ダウンロード' state='総経理室長承認' />" +
						"<表示 user='関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
						"<編集 user='' role='総経理室長承認/室長'/>" +
					"</部品>"
						%>" />
					
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td>総経理からのコメント</td>
						<td height=25 >
						<!--多行の輸入のわく部品-->
						<FlowBuilder:partTextArea job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
						"<部品>" +
							"<タグ name='ManagerComment'  rows='5' cols='50'/>" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='案件起案/案件作成:作成者,部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者' org=''/>" +
							"<編集 user='' role='総経理承認/総経理' org=''/>" +
							"<必須 user='' role='総経理承認/総経理' org=''/>" +
						"</部品>"
							%>"
							check = "<%= 
								"<Checks partName='総経理からのコメント'>" +
									"<Condition value='総経理承認'>" +
										"<CheckItem type='ValidateNull' htmlId='ManagerComment'/>" +
										"<CheckItem type='ValidateLength' htmlId='ManagerComment' min='1' max='1000'/>" +
									"</Condition>" +
								"</Checks>"%>"/>
						</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
							<td>印刷</td>
							<td height=25 >
						<!--入力部品-->
							<FlowBuilder:partPrint job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
						"<部品>" +
							"<タグ name='print'/>" +
							"<表示 user='開通状態/案件作成:作成者' role='中止状態/社員|部長|システム管理者,開通状態/部長|室長|总经理,総経理承認/総経理' org=''/>" +
						"</部品>"
							%>" />
						</td>
					</tr>

					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td>経過承認ルート</td>
						<td height=25>
						<!--通過承認ルート部品-->
							<FlowBuilder:partConfirmRoute job="<%=job%>" />
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
