<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/FlowBuilder.tld" prefix="FlowBuilder"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ page import="javax.servlet.http.*" %>

<html>
<head>
<title>ドキュメントXML管理システム</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="expires" content="0">

<Script language='javascript'>
	//追加の関数
	function add() {
		for(var i = 0; i < document.all.leftUser.options.length; i++) {
		
			//leftUserのユーザが選択された場合

			if(document.all.leftUser.options[i].selected){ 
				var obj = document.createElement('OPTION');
				obj.value=document.all.leftUser.options[i].value;
				obj.text=document.all.leftUser.options[i].text;
				for(var j = 0; j < document.all.rightUser.options.length;j++){
					var flg = false;
					
					//leftUserの追加たいのユーザ　と　rightUserの追加されたユーザ同じの場合

					if(document.all.leftUser.options[i].value == document.all.rightUser.options[j].value) {
						flg = true;
						break;
					}
				}
				//フラグがtrueの場合

				if (!flg) {
					document.all.rightUser.options.add(obj);
				}
			}
		}
		
		<!--rightUserのユーザが追加します-->
		cmnhozon();
		parent.document.all.circularID.value = document.all.selectedUsers.value;
	}
	
	//削除の関数
	function del() {
		for(var i = 0; i < document.all.rightUser.options.length; i++){
			if(document.all.rightUser.options[i].selected) {
				var obj = document.createElement('OPTION');
				obj.value=document.all.rightUser.options[i].value;
				obj.text=document.all.rightUser.options[i].text;
				document.all.rightUser.options.remove(i--);
			}
		}
		
		//rightUserのユーザが追加します

		cmnhozon();
		parent.document.all.circularID.value = document.all.selectedUsers.value;
	}
	
	//組織が変更されたの場合

	function orgChanged() {
		var orgId;
 		orgId = document.forms[0].orgId.value;
		document.forms[0].action = "CircularOperate?method=change&orgId=" + orgId + "";
		
		//rightUserのユーザが追加します

		cmnhozon();
		document.forms[0].submit();
	
	}
	
	//rightUserのユーザが追加します

	function cmnhozon(){
		var strSelectedUsers = "";
			for(var i = 0; i < document.all.rightUser.options.length; i++) {
				strSelectedUsers += document.all.rightUser.options[i].value + ",";
			}
			document.all.selectedUsers.value = strSelectedUsers.substr(0, strSelectedUsers.length - 1);
	}			
</Script>

</head>

<style type = "text/css">
<!--
	tr,td,th {font-size: 10pt;  color : black ; text-decoration : none ; } 
	a:link,a:visited {font-size: 12pt;  color : green ; text-decoration : none ;} 
	a:hover {font-size: 12pt;  color : #80FFFF ;}
	a:hover,a:active {color : #6699FF; background-color :#FFFFFF;}
//-->
</style>

<BODY BGCOLOR="#FFFFFF">
	<form name="CircularForm" method="post">
		<table width="100%" border ="0">
			<tr height='50'>
				<td colspan='4' align='center' >回  覧  人  員  選  択</td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td width='6%'>組織:</td>
				<td colspan='3'>
					<html:select name="CircularForm" property="orgId" style="width:37%" onchange="orgChanged();">
						<html:options collection="orglst" property="no" labelProperty="name"/>
	       			</html:select>
				</td>
			</tr>
			<tr height="25"><td colspan="4"></td></tr>
			<tr>
				<td rowspan='2'>人員:</td>
				<td rowspan='2'width='35%'>
					<html:select name="CircularForm" property="leftUser" size="10" multiple="true" style="width:100%">
						<html:options collection="queryUserlst" property="loginName" labelProperty="userName"/>
	       			</html:select>
				</td>
				<td align='center' width='24%'><input name='add_btn' type='button' value='追加＞＞' valign='center'  onclick='add()'/></td>
				<td rowspan='2' width='35%'>
					<html:select name="CircularForm" property="rightUser" size="10" multiple="true" style="width:100%">
						<html:options collection="selectedUserlst" property="loginName" labelProperty="userName"/>
	       			</html:select>
				</td>
			</tr>					
			<tr>
				<td align='center'><input name='del_btn' type='button' value='削除＜＜' valign='center' onclick='del()'/></td>		
			</tr>	
	
		</table>
		<html:hidden name="CircularForm" property="selectedUsers" value=""/>
	</form>
</body>
<script language='javascript'>
	cmnhozon();
	parent.document.all.circularID.value = document.all.selectedUsers.value;
</script>
</html>

