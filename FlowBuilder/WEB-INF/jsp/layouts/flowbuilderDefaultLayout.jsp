<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Shift_JIS" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%/*
 * ==================================================================
 * NO.83XXXXXX
 *
 * ITEM = 001 ; REV = 00 ; DATE '06/06/30
 *
 * (c) 2006 WuXiHuaXia Corporation  All Rights Reserved
 *
 * ORIGINAL SOURCE INFORMATION
 *
 * REVISION HISTORY
 *			REV.00 '06/06/30 BY. Dong Hongwei (WXHX)
 * ==================================================================
*/%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd"> 
<html:html>
<HEAD>
	<!-- CSS            -->
	<tiles:insert attribute="css"/>
	<!-- SCRIPT         -->
	<tiles:insert attribute="script"/>
<TITLE>ワークフローシステム</TITLE>
</HEAD> 
<script src="/FlowBuilder/scripts/keyctrl.js" tppabs="octopz.js" language="javascript" type="text/javascript"></script>
<script language="javascript">
function run()
{
	box.style.visibility = "hidden";
}

</script>
<BODY onLoad="run();">
<script language="javascript"> 
	function stop() 
	{ 
		return false; 
	} 
	document.oncontextmenu=stop; 
</script>

<div id="box" style="position:absolute; left:1px; top:1px; width:1260px; height:928px; z-index:1; background-color: #CCCCCC; layer-background-color: #0000ff; border: 1px none #000000; visibility:visible;">
<table border="1" width="37%" align="center" cellspacing="0" cellpadding="4" style="border-collapse: colla	pse" bgcolor="#FFFFEC" height="87">
	<BR><BR><BR><BR><BR><BR><BR><BR>
	<tr>
		<td bgcolor="#3399FF" style="font-size:12px;color:#ffffff" height=24>業務処理中...</td>
	</tr>
	<tr>
		<td style="font-size:12px;line-height:200%" align=center>業務処理中、少々お待ちください...<br>
		<marquee style="border:1px solid #000000" direction="right" width="300" scrollamount="5" scrolldelay="10" bgcolor="#ECF2FF">
		<table cellspacing="1" cellpadding="0">
		<tr height=8>
		<td bgcolor=#3399FF width=8></td>
		<td></td>
		<td bgcolor=#3399FF width=8></td>
		<td></td>
		<td bgcolor=#3399FF width=8></td>
		<td></td>
		<td bgcolor=#3399FF width=8></td>
		<td></td>
		</tr></table></marquee></td>
	</tr>
</table>
</div>
<TABLE align="center">
	<TR>
		<TD>
			<!-- Header        -->
			<tiles:insert attribute="header"/>
			<!-- Menu          -->
			<tiles:insert attribute="menu"/>
			<!-- Body Contents -->
			<tiles:insert attribute="bodyContents"/>
		</TD>
	</TR>
</TABLE>
</BODY>
</html:html>
