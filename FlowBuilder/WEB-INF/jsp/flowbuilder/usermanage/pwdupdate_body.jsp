<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/FlowBuilder.tld" prefix="FlowBuilder" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html>
<head>
<title>パスワード変?</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="expires" content="0">


	<link href="/FlowBuilder/css/flowbuilder_global.css" rel="stylesheet" type="text/css" />
	<link href="/FlowBuilder/css/flowbuilder_internal.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="JavaScript">
  <!--
	function update()
	{
		if(confirm("パスワードの修正が成功したら、システムが再登録します，よろしですか？"))
		{
			document.forms[0].action="PasswordUpdate";
			document.forms[0].method.value="update";
			document.forms[0].submit();
		}
	}

	function check()
	{  
	   passwordOld=document.forms[0].oldPassword.value;
	   password=document.forms[0].password.value;
	   password1=document.forms[0].passwordAgain.value;
	   if(password=="" || password1=="" || passwordOld == "")
	   {
	   	alert("パスワードを入力してください");
	   	document.forms[0].password.focus();
	  	return;
	   }
	  
	   if(password == password1)
	   {
	       update();
	   }
	   else
	   {
	    alert("パスワード前後が違いました!");
	    document.forms[0].password.value="";
	    document.forms[0].passwordAgain.value="";
	    document.forms[0].password.focus();
		return;
	   
	   }

	}
  // -->
</script>

</head>

<html:form action="/flowbuilder/PasswordUpdate?method=view" >
<html:hidden property="method" value="error"/>
<html:hidden property="userId"/>
<BODY BGCOLOR="#FFFFFF" LEFTMARGIN="0" TOPMARGIN="0" MARGINWIDTH="0" MARGINHEIGHT="0">
		<div id="container">
	<table align=top border=0 cellpadding=1 cellspacing=1 width="50%">
		<tr> 
			<td width=300 height="67" align="center"><img src="/FlowBuilder/images/pwdChage.gif"></img></td>
		</tr>
	</table>
	
	<table align=top border=0 cellpadding=1 cellspacing=1 width="90%">
		<tr> 
			<td>
						
	<table width='75%' border=0.5 align=center cellpadding=0 cellspacing=0 bordercolor="#efefef" bgcolor='#FFFFFF'>
		<tr height="25px" >
		    <td width="24%" height="25" align=right >
		      <div align="right"></div></td>
			<td width="26%" height="30" align=right ><div align="left">ユーザ名 </div></td>
			<td width="50%" colspan="3" align=leftbordercolor="#FFFFFF"><bean:write name="PasswordForm" property="userId"/>&nbsp;&nbsp;</td>
		</tr>
		<tr height="25px" >
		    <td height="25"  align=right>
		      <div align="right"></div></td>
			<td height="30"  align=right><div align="left">古いパスワード </div></td>
			<td colspan="3"  align=left><html:password name="PasswordForm" property="oldPassword" redisplay="false"/></td>
		</tr>
		<tr height="25px" >
			<td height="25"  align=right>
			  <div align="right"></div></td>
			<td height="30"  align=right><div align="left">新しいパスワード入力</div></td>
			<td colspan="3"  align=left><html:password name="PasswordForm" property="password" redisplay="false"/></td>
		</tr>
		<tr height="25px" >
			<td height="25" align=right><div align="right"></div></td>
			<td height="30" align=right><div align="left">新しいパスワード再入力</div></td>
			<td colspan="3"  align=left><html:password name="PasswordForm" property="passwordAgain" redisplay="false"/></td>
		</tr>
	</table>
	</table>
	<table width="41%" height="66" border=0 align=center cellpadding=1 cellspacing=1>
		<tr bgcolor="#FFFFFF"> 
			<td height=27 align="right" bgcolor="#FFFFFF" width="50%">
			<a href="javascript:check();"><font size=1>更新</font></a> 
			&nbsp;&nbsp;</td>		
			<td height=27 align="left" bgcolor="#FFFFFF" width="50%">
			<a href="javascript:document.forms[0].reset();"><font size=1>クリア</font></a>			</td>
		</tr>
		<tr bgcolor="#FFFFFF">
			<logic:messagesPresent>
				<ul>
					<html:messages id="error">
						<BR>
						<font color="red" size="1">古いパスワード前後が違いました。確認してください！</font>
					</html:messages>
				</ul>
			</logic:messagesPresent>
		</tr>
	</table>
			
	<p>&nbsp;</p>
	<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
	</div>
</html:form>
	<div id="clearbottom">&nbsp;</div>
<div id="footer">
<div id="copyright">Copyright © 2007 華夏計算機技術有限公司</div>
</div>


</BODY>


</html>
	
