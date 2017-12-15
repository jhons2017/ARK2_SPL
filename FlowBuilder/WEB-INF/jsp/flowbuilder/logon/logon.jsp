<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无锡华夏业务改善系统</title>
 <script>
 <!--
	function clickLoginButton()
	{
		
		window.open("","OrgSelect","toolbar=no,left=0,top=0,Width=1280,Height=930,location=no,directories=no,status=yes,scrollbars=yes,menubar=no,resizable=no");
		document.LoginForm.target = "OrgSelect";
		document.LoginForm.submit();
		if(window.name != "OrgSelect"){
			window.opener = null;
			window.close();
		}
	}
	
	function clickClearButton()
	{
		document.getElementById("userId").value = "";
		document.getElementById("password").value = "";
	}

	function makeUrl()
	{
		var url = location.href.toString();
		if(url.indexOf(";") > 0)
		{
			url = url.substring(0, url.indexOf(";"));
		}
		return url;
	}
	
	function keySubmit()
	{
		if(event.keyCode==13)
		{
			clickLoginButton();
		}		
	}
  // -->
</script>
</head>

<body>

<table width="1004" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="384" height="101">&nbsp;</td>
    <td width="563">&nbsp;</td>
    <td width="57">&nbsp;</td>
  </tr>
  <tr>
    <td height="426" align="right"><img src="/FlowBuilder/images/man.jpg" width="300" height="449" /></td>
    <td valign="top"><table width="489" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td colspan="2">&nbsp;</td>
      </tr>
      <tr>
        <td width="47" height="155" valign="bottom">&nbsp;</td>
        <td width="442" valign="bottom"><span class="regularText"><img src="/FlowBuilder/images/login_sign.jpg" width="326" height="95" /></span></td>
      </tr>
      <tr>
        <td height="120" colspan="2" valign="top">
		<html:form action="flowbuilder/Login" focus="userId">
          <table width="357" height="110" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td width="119" height="25"><img src="/FlowBuilder/images/name.gif" width="100" height="25" /></td>
              <td><span class="regularText">
                <input name="userId" type="text" size="23" maxlength="15" style="width:200px; border-top:1px solid #CCCCCC;border-bottom:1px solid #999999;border-left:1px solid #CCCCCC;border-right:1px solid #999999;ime-mode:disabled" />
              </span></td>
            </tr>
            <tr>
              <td height="24"><img src="/FlowBuilder/images/password.gif" width="100" height="25" /></td>
              <td><span class="regularText">
                <input name="password" type="password" size="25" maxlength="20" style="width:200px; border-top:1px solid #CCCCCC;border-bottom:1px solid #999999;border-left:1px solid #CCCCCC;border-right:1px solid #999999;" onKeyDown="javascript:keySubmit();"/>
              </span></td>
            </tr>
            <tr>
              <td height="61" colspan="2" align="right"><table width="331" height="38" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="75">&nbsp;</td>
                  <td width="120"><a href="javascript:clickLoginButton();" border=0><img src="/FlowBuilder/images/login.gif" width="120" height="37" border="0" /></a></td>
                  <td width="9">&nbsp;</td>
                  <td width="127"><a href="javascript:clickClearButton();"><img src="/FlowBuilder/images/cancel.gif" width="120" height="37" border="0" /></a><a href="javascript:clickLoginButton();" border=0></td>
                </tr>
              </table>                
                <div align="center"><a href="#"></a></div></td>
				
				<logic:messagesPresent>
						<ul>
							<html:messages id="error">
								<font color="blue" size="1"  align="left">ログイン名またはパスワードが間違っています!</font>
							</html:messages>
						</ul>
					</logic:messagesPresent>    
              </tr>
          </table>
                </html:form>        </td>
      </tr>
    </table></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>

</body>
</html>
