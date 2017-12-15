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
			<td width="400" align="left" valign="middle" nowrap><img src="/FlowBuilder/images/security.gif"></img></td>
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
	"<step name='案件作成'>" +
		"<opr id='create' user='' role='社員' org='' vital_check='1'/>" +
	"</step>" +
	"<step name='案件起案'>" +
		"<opr id='start' user='案件作成:作成者' role='' org='' vital_check='1'/>" +
		"<opr id='save' user='案件作成:作成者' role='' org='' vital_check='0'/>" +
		"<opr id='disposal' user='案件作成:作成者' role='' org='' vital_check='0'/>" +
	"</step>" +
	"<step name='マネージャ承認'>" +
		"<opr id='returnSelf' user='案件作成:作成者' role=''  org='' vital_check='0'/>" +
		"<opr id='confirm' user='' role='マネージャ'  org='' vital_check='1'/>" +
		"<opr id='return' user='' role='マネージャ'  org='' vital_check='1'/>" +
	"</step>" +
	"<step name='グループ長承認'>" +
		"<opr id='confirm' user='' role='グループ長'  org='' vital_check='1'/>" +
		"<opr id='return' user='' role='グループ長'  org='' vital_check='1'/>" +
	"</step>" +
	"<step name='部長承認'>" +
		"<opr id='confirm' user='' role='部長'  org='*' vital_check='1'/>" +
		"<opr id='return' user='' role='部長'  org='*' vital_check='1'/>" +
	"</step>" +
	"<step name='SI事業部長承認'>" +
		"<opr id='confirm' user='' role='部長'  org='SI事業部' vital_check='1'/>" +
		"<opr id='return' user='' role='部長'  org='SI事業部' vital_check='1'/>" +
	"</step>" +
	"<step name='開通状態'>" +
		"<opr id='stop' user='' role='部長'  org='SI事業部' vital_check='0'/>" +
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
				<table bgcolor="#999999" align="center" border="0" cellpadding="1" cellspacing="1" width="740">
					<form name="JobDetailForm" method="post" enctype="multipart/form-data">
					<tr bgcolor="#efefef" align="center" valign="middle"> 
						<td height=30 colspan=3 >案　件　内　容</td>
					</tr>

					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td height=25 width=150  nowrap>案件名</td>
						<td height=25 width=450>
							<!--案件名部品-->
							<FlowBuilder:partJobName job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
							"<部品>" +
								"<タグ name='fb_jobname' style='HEIGHT: 22px; WIDTH: 300px' />" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"</部品>"
								%>"
								check = "<%=
									"<Checks partName='案件名'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateLength' htmlId='fb_jobname' min='1' max='100'/>" +
											"<CheckItem type='ValidateNull' htmlId='fb_jobname'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>
						<td height=25 width=100 rowspan="3"  align="center">	<!--影像部品-->
							<FlowBuilder:partImage job="<%=job%>" userId="<%=userId%>" partXml="<%=
							"<部品>" +
								"<option path='/FlowBuilder/images/userImages/' height='100' width='100'/>" +
							"</部品>"
								%>" />
						</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td  nowrap>プロジェクト名</td>
						<td height=25 >
							<!--入力部品-->
							<FlowBuilder:partInput job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
							"<部品>" +
								"<タグ name='projectGroup' style='HEIGHT: 22px; WIDTH: 300px' />" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"</部品>"
								%>"
								check = "<%=
									"<Checks partName='プロジェクト名'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='projectGroup'/>" +
											"<CheckItem type='ValidateLength' htmlId='projectGroup' min='1' max='30'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td nowrap>役割担当</td>
						<td height=25>
							<!--RADIOBOX選択部品-->
							<FlowBuilder:partRadioBox job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
							"<部品>" +
								"<タグ name='jobSelectPM' style='HEIGHT: 22px; WIDTH: 40px'/>" +
								"<非表示 user='' role=''/>" +
								"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員'/>" +
								"<編集 user='案件起案/案件作成:作成者' role=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role=''/>" +
								"<content name='PG,PL,PM,その他' defalut='PG'/>" +
							"</部品>"
								%>"
								check = "<%=
									"<Checks partName='役割担当'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateRadioNull' htmlId='jobSelectPM'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>
					</tr>
					
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td height=25 width=150  nowrap>期間</td>
						<td height=25 width=400  colspan="2">
						<!--COMBOX選択部品-->
						<FlowBuilder:partSelectDate job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
					"<部品>" +
						"<タグ name='startdate/enddate' value='開始日/結束日' calendar='1/1' style='HEIGHT: 22px; WIDTH: 120px' />" +
						"<非表示 user='' role='' org=''/>" +
						"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
						"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
						"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
					"</部品>"
						%>" 
						check = "<%= 
						"<Checks partName='期間'>" +
							"<Condition value='案件起案'>" +
								"<CheckItem type='ValidateNull' htmlId='startdate'/>" +
								"<CheckItem type='ValidateNull' htmlId='enddate'/>" +
								"<CheckItem type='ValidateDateFromTo' startTime='startdate' endTime='enddate'/>" + 
							"</Condition>" +
							"</Checks>"%>"/>																
						</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td nowrap>目標URL指定</td>
						<td height=25  colspan="2">
							<!--入力部品-->
							<FlowBuilder:partInput job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
							"<部品>" +
								"<タグ name='address' style='HEIGHT: 22px; WIDTH: 300px' />" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<必須 user='' role='' org=''/>" +
							"</部品>"
								%>"
								check = "<%= 
									"<Checks partName='目標URL指定'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateLength' htmlId='address' min='1' max='100'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td nowrap>ポート指定</td>
						<td height=25 colspan="2">
							<!--入力部品-->
							<FlowBuilder:partInput job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
							"<部品>" +
								"<タグ name='port' style='HEIGHT: 22px; WIDTH: 300px' />" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<必須 user='' role='' org=''/>" +
							"</部品>"
								%>"
								check = "<%= 
									"<Checks partName='ポート指定'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateRegExp' htmlId='port' value='/^[0-9]{0,4}$/'/>" +
											"<CheckItem type='ValidateLength' htmlId='port' min='1' max='5'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td nowrap>社外メール</td>
						<td height=25 width=100 colspan="2">
						
								<!--EMAIL選択部品-->
								<FlowBuilder:partEmail job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
								"<部品>" +
									"<タグ name='email' style='HEIGHT: 22px; WIDTH: 300px'/>" +
									"<非表示 user='' role='' org=''/>" +
									"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
									"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
									"<必須 user='' role='' org=''/>" +
								"</部品>"
								%>"
								check = "<%= 
									"<Checks partName='社外メール'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateRegExp' htmlId='email' value = '/^\\\w+((-\\\w+)|(\\\.\\\w+))*\\\@[A-Za-z0-9]+((\\\.|-)[A-Za-z0-9]+)*\\\.[A-Za-z0-9]+$/'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td nowrap>申請項目指定</td>
						<td height=25  colspan="2">
						<!--CHECKBOX選択部品-->
						<FlowBuilder:partCheckBox job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
						"<部品>" +
							"<タグ name='USB/HD/FD/CDROM/MSN/SKYPE/EMAIL' style='HEIGHT: 22px; WIDTH: 40px'/>" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
							"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"<content name='USB,HD,FD,CD-ROM,MSN,SKYPE,電子カメラ' defalut=''/>" +
						"</部品>"
							%>"
							check = ""/>
						</td>
					</tr>
					
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td>その他の指定</td>
						<td height=25 colspan="2">
						<!--入力部品-->
						<FlowBuilder:partInput job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
						"<部品>" +
							"<タグ name='otherRequest' style='HEIGHT: 22px; WIDTH: 400px' />" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
							"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"<必須 user='' role='' org=''/>" +
						"</部品>"
							%>" 
							check = "<%= 
									"<Checks partName='その他の指定'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateLength' htmlId='otherRequest' min='1' max='100'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>						
					</tr>
					
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td valign="top">申請理由</td>
						<td height=25 colspan="2">
						<!--多行の輸入のわく部品-->
						<FlowBuilder:partTextArea job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
						"<部品>" +
							"<タグ name='comment' style='HEIGHT: 22px; WIDTH: 400px; word-break:break-all;' rows='5' cols='50'/>" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
							"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
						"</部品>"
							%>" 
							check = "<%= 
									"<Checks partName='申請理由'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='comment'/>" +
											"<CheckItem type='ValidateLength' htmlId='comment' min='1' max='1000'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>						
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td>重要度指定</td>
						<td colspan="2">
							<!--一覧表部品-->
							<FlowBuilder:partSelect job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
							"<部品>" +
								"<タグ name='select' style='HEIGHT: 22px; WIDTH: 300px' />" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<option value=',high,normal,low' name = ',高,中,低'/>" +
								"<content defalut='high'/>" +
							"</部品>"
								%>"
								check = "<%=
									"<Checks partName='重要度指定'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='select'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td>マネージャからのコメント</td>
						<td height=25 colspan="2">
						<!--多行の輸入のわく部品-->
							<FlowBuilder:partTextArea job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
							"<部品>" +
								"<タグ name='proManageChouComment'  rows='5' cols='50'/>" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
								"<編集 user='' role='マネージャ承認/マネージャ' org=''/>" +
								"<必須 user='' role='マネージャ承認/マネージャ' org=''/>" +
							"</部品>"
								%>"
								check = "<%= 
									"<Checks partName='マネージャからのコメント'>" +
										"<Condition value='マネージャ承認'>" +
											"<CheckItem type='ValidateNull' htmlId='proManageChouComment'/>" +
											"<CheckItem type='ValidateLength' htmlId='proManageChouComment' min='1' max='1000'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>
					</tr>	
					
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td>グループ長からのコメント</td>
						<td height=25 colspan="2">
							<!--多行の輸入のわく部品-->
								<FlowBuilder:partTextArea job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
							"<部品>" +
								"<タグ name='groupChouComment'  rows='5' cols='50'/>" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
								"<編集 user='' role='グループ長承認/グループ長' org=''/>" +
								"<必須 user='' role='グループ長承認/グループ長' org=''/>" +
							"</部品>"
								%>" 
								check = "<%= 
									"<Checks partName='グループ長からのコメント'>" +
										"<Condition value='グループ長承認'>" +
											"<CheckItem type='ValidateNull' htmlId='groupChouComment'/>" +
											"<CheckItem type='ValidateLength' htmlId='groupChouComment' min='1' max='1000'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>
					</tr>				
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td>部長からのコメント</td>
						<td height=25 colspan="2">
						<!--多行の輸入のわく部品-->
							<FlowBuilder:partTextArea job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
						"<部品>" +
							"<タグ name='buchouComment'  rows='5' cols='50'/>" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
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
						<td>SI事業部長からのコメント</td>
						<td height=25 colspan="2">
						<!--多行の輸入のわく部品-->
						<FlowBuilder:partTextArea job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
						"<部品>" +
							"<タグ name='SIComment'  rows='5' cols='50'/>" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
							"<編集 user='' role='SI事業部長承認/部長' org='SI事業部'/>" +
							"<必須 user='' role='SI事業部長承認/部長' org='SI事業部'/>" +
						"</部品>"
							%>"
							check = "<%= 
								"<Checks partName='SI事業部長からのコメント'>" +
									"<Condition value='SI事業部長承認'>" +
										"<CheckItem type='ValidateNull' htmlId='SIComment'/>" +
										"<CheckItem type='ValidateLength' htmlId='SIComment' min='1' max='1000'/>" +
									"</Condition>" +
								"</Checks>"%>"/>
						</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
							<td>印刷</td>
							<td height=25 colspan="2">
						<!--入力部品-->
							<FlowBuilder:partPrint job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
						"<部品>" +
							"<タグ name='print'/>" +
							"<表示 user='' role='中止状態/社員|部長|システム管理者,開通状態/社員|部長|SI事業部長' org=''/>" +
						"</部品>"
							%>" />
						</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td>経過承認ルート</td>
						<td height=25 colspan="2">
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
