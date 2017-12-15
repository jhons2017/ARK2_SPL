<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>FlowBuilder</title>
<style type=text/css>
body  { background:#39867B; margin:0px; font:9pt Simsun; FONT-SIZE: 9pt;text-decoration: none;
SCROLLBAR-FACE-COLOR: #C6EBDE;
SCROLLBAR-HIGHLIGHT-COLOR: #ffffff; SCROLLBAR-SHADOW-COLOR: #39867B; SCROLLBAR-3DLIGHT-COLOR: #39867B; SCROLLBAR-ARROW-COLOR: #330000; SCROLLBAR-TRACK-COLOR: #E2F3F1; SCROLLBAR-DARKSHADOW-COLOR: #ffffff;}
table  { border:0px; }
td  { font:normal 12px Simsun; }
img  { vertical-align:bottom; border:0px; }
a  { font:normal 12px Simsun; color:#000000; text-decoration:none; }
a:hover  { color:#cc0000;text-decoration:underline; }
.sec_menu  { border-left:1px solid white; border-right:1px solid white; border-bottom:1px solid white; overflow:hidden; background:#C6EBDE; }
.menu_title  { }
.menu_title span  { position:relative; top:2px; left:8px; color:#39867B; font-weight:bold; }
.menu_title2  { }
.menu_title2 span  { position:relative; top:2px; left:8px; color:#cc0000; font-weight:bold; }
</style>
<SCRIPT language=javascript1.2>
function showsubmenu(sid)
{
whichEl = eval("submenu" + sid);
if (whichEl.style.display == "none")
{
eval("submenu" + sid + ".style.display=\"\";");
}
else
{
eval("submenu" + sid + ".style.display=\"none\";");
}
}
</SCRIPT>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></head>
<BODY leftmargin="0" topmargin="0" marginheight="0" marginwidth="0">
<table width=100% cellpadding=0 cellspacing=0 border=0 align=left>
    <tr><td valign=top>
<table width=158 border="0" align=center cellpadding=0 cellspacing=0>
  <tr>
    <td height=42 valign=bottom>
	  <img src="/FlowBuilder/images/logo.gif" width=158 height=38>
    </td>
  </tr>
</table>
<table cellpadding=0 cellspacing=0 width=158 align=center>
  <tr>
        <td height=25 class=menu_title onmouseover=this.className='menu_title2'; onmouseout=this.className='menu_title'; background=/FlowBuilder/images/title_bg_quit.gif id=menuTitle0> 
          <span><a href="Admin_Index_Main.html" target=main><b>home page</b> </a> | <b>Logout</b></a></span> 
        </td>
  </tr>
  <tr>
    <td style="display:" id='submenu0'>
<div class=sec_menu style="width:158">
<table cellpadding=0 cellspacing=0 align=center width=130>
<tr>
  <td height=20>ユーザ名:徐暁明</td>
</tr>
<tr>
  <td height=20> IP:172.16.1.68</td>
</tr>
<tr>
  <td height=20>
<a href="javascript:;"onClick="javascript:window.open('mesage.html','','width=432,height=288,toolbar=no, status=no, menubar=no, resizable=yes, scrollbars=yes');'returnfalse;'"><strong><font color="#FF0000">2
	</font></strong></a>    </td>
</tr>
</table>
</div>
<div  style="width:158">
<table cellpadding=0 cellspacing=0 align=center width=130>
<tr><td height=20></td></tr>
</table>
</div>
	</td>
  </tr>
</table>
<table cellpadding=0 cellspacing=0 width=158 align=center>
  <tr>
        <td height=25 class=menu_title onmouseover=this.className='menu_title2'; onmouseout=this.className='menu_title'; background="/FlowBuilder/images/admin_left_3.gif" id=menuTitle1 onClick="showsubmenu(1)" style="cursor:hand;"> 
          <span>all</span> </td>
  </tr>
  <tr>
    <td style="display:" id='submenu1'>
<div class=sec_menu style="width:158">
<table cellpadding=0 cellspacing=0 align=center width=130>
<tr><td height=20></td>
</tr>
<tr><td height=20>&nbsp;</td>
</tr>
<tr><td height=20>&nbsp;</td>
</tr>
<tr><td height=20>&nbsp;</td>
</tr>
<tr><td height=20>&nbsp;</td>
</tr>
<tr><td height=20>&nbsp;</td>
</tr>


<tr><td height=20>&nbsp;</td>
</tr>
</table>
</div>
<div  style="width:158">
<table cellpadding=0 cellspacing=0 align=center width=130>
<tr><td height=20></td></tr>
</table>
</div>
	</td>
  </tr>
</table>

<table cellpadding=0 cellspacing=0 width=158 align=center>
  <tr>
        <td height=25 class=menu_title onmouseover=this.className='menu_title2'; onmouseout=this.className='menu_title'; background="/FlowBuilder/images/admin_left_3.gif" id=menuTitle1 onClick="showsubmenu(11)" style="cursor:hand;"> 
          <span>work flow</span> </td>
  </tr>
  <tr>
    <td style="display:" id='submenu11'>
<div class=sec_menu style="width:158">
<table cellpadding=0 cellspacing=0 align=center width=130>
<tr><td height=20><a href=" " target=main>システムの中に知らせる</a></td></tr>

<tr><td height=20><a href=" " target=main>知らせる</a>  | <a href=" " target=main>管理</a></td></tr>
<tr><td height=20><a href=" " target=main></a></td>
</tr>
<tr><td height=20>&nbsp;</td>
</tr>
<tr><td height=20>&nbsp;</td>
</tr>


</table>
</div>
<div  style="width:158">
<table cellpadding=0 cellspacing=0 align=center width=130>
<tr><td height=20></td></tr>
</table>
</div>
	</td>
  </tr>
</table>
<table cellpadding=0 cellspacing=0 width=158 align=center>
  <tr>
        <td height=25 class=menu_title onmouseover=this.className='menu_title2'; onmouseout=this.className='menu_title'; background="/FlowBuilder/images/admin_left_4.gif" id=menuTitle21 onClick="showsubmenu(21)" style="cursor:hand;"> 
          <span>社員管理</span> </td>
  </tr>
  <tr>
    <td height="125" id='submenu21' style="display:">
<div class=sec_menu style="width:158">
<table cellpadding=0 cellspacing=0 align=center width=130>
	<tr><td height=20>&nbsp;</td>
	</tr>
       <tr><td height=20>&nbsp;</td>
       </tr>
	<tr><td height=20>&nbsp;</td>
	</tr>
	<tr><td height=20>&nbsp;</td>
	</tr>
	<tr><td height=20>&nbsp;</td>
	</tr>



</table>
</div>
<div  style="width:158">
<table cellpadding=0 cellspacing=0 align=center width=130>
<tr><td height=20></td></tr>
</table>
</div>
	</td>
  </tr>
</table>

<table cellpadding=0 cellspacing=0 width=158 align=center>
  <tr>
  </tr>
  <tr>
    <td style="display:" id='submenu31'><div  style="width:158"></div>
	</td>
  </tr>
</table>

<table cellpadding=0 cellspacing=0 width=158 align=center>
  <tr>
        <td height=25 class=menu_title onmouseover=this.className='menu_title2'; onmouseout=this.className='menu_title'; background="/FlowBuilder/images/Admin_left_9.gif" id=menuTitle9> 
          <span>華夏工作流</span> </td>
  </tr>
  <tr>
    <td>
<div class=sec_menu style="width:158">
<table cellpadding=0 cellspacing=0 align=center width=130>
<tr><td height=20><br>
                  所有：&nbsp;華夏軟件<br>
                  設計：<a href=" ">&nbsp;華夏軟件</a><BR>
                  技術支援：&nbsp;<a href=" " target=_blank>華夏軟件</a><br>
                  <br>
</td></tr>
</table>
	  </div>
	</td>
  </tr>
</table>
</body>
</html>
