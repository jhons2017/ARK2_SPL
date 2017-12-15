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
			<td width="400" align="left" valign="middle" nowrap><img src="/FlowBuilder/images/equipment.gif"></img></td>
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
				"<step name='SI事業部長承認'>" +
					"<opr id='confirm' user='' role='部長'  org='SI事業部' vital_check='1'/>" +
					"<opr id='return' user='' role='部長'  org='SI事業部' vital_check='1'/>" +
				"</step>" +
				"<step name='開通状態'>" +
					"<opr id='stop' user='' role='部長' org='SI事業部' vital_check='0'/>" +
				"</step>" +
				"<step name='中止状態'>" +
					"<opr id='delete' user='' role='システム管理者' org='' vital_check='0'/>" +
				"</step>" +
			"</部品>"
				%>" />
			</td>
		</tr>
		<tr bgcolor="#FFFFFF"> 
			<td height=30 align="right">
				<table bgcolor="#999999" align=center border=0 cellpadding=1 cellspacing=1 width="740">
					<form name="JobDetailForm" method="post" accept="utf-8">
					<tr bgcolor="#efefef" align="center" valign="middle"> 
						<td height=30 colspan=3 >案　件　内　容</td>
					</tr>
								
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td height=25 width=150  nowrap>案　件　名</td>
						<td height=25 width=520 >
							<!--案件名部品-->
							<FlowBuilder:partJobName job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
							"<部品>" +
								"<タグ name='fb_jobname' style='HEIGHT: 22px; WIDTH: 300px' />" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='部長承認/案件作成:作成者,SI事業部長承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者,' role='部長承認/部長,SI事業部長承認/部長,中止状態/部長|システム管理者,開通状態/部長|社員' org=''/>" +
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
						<td height=25 width=100 rowspan="3" align="center">
									<!--影像部品-->
									<FlowBuilder:partImage job="<%=job%>" userId="<%=userId%>" partXml="<%=
									"<部品>" +
										"<option path='/FlowBuilder/images/userImages/' height='100' width='100'/>" +
									"</部品>"
										%>" />
						</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td  nowrap>部門名</td>
						<td height=25 >
							<!--入力部品-->
							<FlowBuilder:partInput job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
							"<部品>" +
								"<タグ name='department' style='HEIGHT: 22px; WIDTH: 300px' />" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='部長承認/案件作成:作成者,SI事業部長承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者,' role='部長承認/部長,SI事業部長承認/部長,中止状態/部長|システム管理者,開通状態/部長|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"</部品>"
								%>"
								check = "<%=
									"<Checks partName='部門名'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='department'/>" +
											"<CheckItem type='ValidateLength' htmlId='department' min='1' max='30'/>" +
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
								"<タグ name='roleSelect' style='HEIGHT: 22px; WIDTH: 40px'/>" +
								"<非表示 user='' role=''/>" +
								"<表示 user='部長承認/案件作成:作成者,SI事業部長承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者,' role='部長承認/部長,SI事業部長承認/部長,中止状態/部長|システム管理者,開通状態/部長|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role=''/>" +
								"<content name='PG,PL,PM,その他' defalut='PG'/>" +
							"</部品>"
								%>"
								check = "<%=
									"<Checks partName='役割担当'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateRadioNull' htmlId='roleSelect'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td>申請日</td>
						<td height=25 colspan="2">
						<!--入力部品-->
						<FlowBuilder:partDate job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
						"<部品>" +
							"<タグ name='applyDate' style='HEIGHT: 22px; WIDTH: 100px' />" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='部長承認/案件作成:作成者,SI事業部長承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者,' role='部長承認/部長,SI事業部長承認/部長,中止状態/部長|システム管理者,開通状態/部長|社員' org=''/>" +
							"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
						"</部品>"
							%>" 
							check = "<%= 
									"<Checks partName='申請日'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='applyDate'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>						
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td nowrap>設備名</td>
						<td height=25 colspan="2">
							<!--入力部品-->
							<FlowBuilder:partInput job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
							"<部品>" +
								"<タグ name='equimentName' style='HEIGHT: 22px; WIDTH: 300px' />" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='部長承認/案件作成:作成者,SI事業部長承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者,' role='部長承認/部長,SI事業部長承認/部長,中止状態/部長|システム管理者,開通状態/部長|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"</部品>"
								%>"
								check = "<%= 
									"<Checks partName='設備名'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='equimentName'/>" +
											"<CheckItem type='ValidateLength' htmlId='equimentName' min='1' max='50'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td nowrap>数 量</td>
						<td height=25 colspan="2">
							<!--入力部品-->
							<FlowBuilder:partInput job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
							"<部品>" +
								"<タグ name='number' style='HEIGHT: 22px; WIDTH: 300px' />" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='部長承認/案件作成:作成者,SI事業部長承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者,' role='部長承認/部長,SI事業部長承認/部長,中止状態/部長|システム管理者,開通状態/部長|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"</部品>"
								%>"
								check = "<%= 
									"<Checks partName='数量'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='number'/>" +
											"<CheckItem type='ValidateLength' htmlId='number' min='1' max='14'/>" +
											"<CheckItem type='ValidateRegExp' htmlId='number' value='/^[0-9]{0,15}$/'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td>用 途</td>
						<td height=25 colspan="2">
						<!--多行の輸入のわく部品-->
						<FlowBuilder:partTextArea job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
						"<部品>" +
							"<タグ name='usage' style='HEIGHT: 22px; WIDTH: 400px' rows='5' cols='50'/>" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='部長承認/案件作成:作成者,SI事業部長承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者,' role='部長承認/部長,SI事業部長承認/部長,中止状態/部長|システム管理者,開通状態/部長|社員' org=''/>" +
							"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
						"</部品>"
							%>" 
							check = "<%= 
									"<Checks partName='用  途'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='usage'/>" +
											"<CheckItem type='ValidateLength' htmlId='usage' min='1' max='1000'/>" +
										"</Condition>" +
									"</Checks>"%>"/>
						</td>						
					</tr>
					<tr align="left" bgcolor="#ffffff" valign="middle">
						<td>スペック</td>
						<td height=25 colspan="2">
						<!--多行の輸入のわく部品-->
						<FlowBuilder:partTextArea job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
						"<部品>" +
							"<タグ name='config' style='HEIGHT: 22px; WIDTH: 400px' rows='5' cols='50'/>" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='部長承認/案件作成:作成者,SI事業部長承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者,' role='部長承認/部長,SI事業部長承認/部長,中止状態/部長|システム管理者,開通状態/部長|社員' org=''/>" +
							"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
						"</部品>"
							%>" 
							check = "<%= 
									"<Checks partName='スペック'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='config'/>" +
											"<CheckItem type='ValidateLength' htmlId='config' min='1' max='1000'/>" +
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
								"<表示 user='部長承認/案件作成:作成者,SI事業部長承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者,' role='部長承認/部長,SI事業部長承認/部長,中止状態/部長|システム管理者,開通状態/部長|社員' org=''/>" +
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
						<td>部長からのコメント</td>
						<td height=25 colspan="2">
						<!--多行の輸入のわく部品-->
							<FlowBuilder:partTextArea job="<%=job%>" orgId="<%=orgId%>" userId="<%=userId%>" partXml="<%=
						"<部品>" +
							"<タグ name='buchouComment'  rows='5' cols='50'/>" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='案件起案/案件作成:作成者,部長承認/案件作成:作成者,SI事業部長承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者,' role='部長承認/部長,SI事業部長承認/部長,中止状態/部長|システム管理者,開通状態/部長|社員' org=''/>" +
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
							"<表示 user='案件起案/案件作成:作成者,部長承認/案件作成:作成者,SI事業部長承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者,' role='部長承認/部長,SI事業部長承認/部長,中止状態/部長|システム管理者,開通状態/部長|社員' org=''/>" +
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
							"<表示 user='中止状態/案件作成:作成者,開通状態/案件作成:作成者' role='中止状態/社員|部長|システム管理者,開通状態/社員|部長|SI事業部長' org=''/>" +
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
