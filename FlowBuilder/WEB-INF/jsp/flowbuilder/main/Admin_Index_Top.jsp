<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>FlowBulder </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
a:link { color:#000000;text-decoration:none}
a:hover {color:#666666;}
a:visited {color:#000000;text-decoration:none}

td {FONT-SIZE: 9pt; FILTER: dropshadow(color=#FFFFFF,offx=1,offy=1); COLOR: #000000; FONT-FAMILY: "Simsun"}
img {filter:Alpha(opacity:100); chroma(color=#FFFFFF)}
.style1 {color: #FF0000}
</style>
<base target="main">
<script>
function preloadImg(src)
{
	var img=new Image();
	img.src=src
}
preloadImg("/FlowBuilder/images/admin_top_open.gif");

var displayBar=true;
function switchBar(obj)
{
	if (displayBar)
	{
		parent.frame.cols="0,*";
		displayBar=false;
		obj.src="/FlowBuilder/images/admin_top_open.gif";
		obj.title="打開左側管理メニュー";
	}
	else{
		parent.frame.cols="180,*";
		displayBar=true;
		obj.src="/FlowBuilder/images/admin_top_close.gif";
		obj.title="関閉左側管理メニュー";
	}
}
</script>
</head>

<body background="/FlowBuilder/images/admin_top_bg.gif" leftmargin="0" topmargin="0">
<table height="100%" width="100%" border=0 cellpadding=0 cellspacing=0>
<tr valign=middle>
	<td width=50>
	<img onClick="switchBar(this)" src="/FlowBuilder/images/admin_top_close.gif" title="関閉左側管理メニュー" style="cursor:hand">
	</td>


	<td width=35>
		<img src="/FlowBuilder/images/admin_top_icon_6.gif">
	</td>
	<td width=60>
		<a href="#">事務デスクトップ</a>
	</td>
	<td width=35>
		<img src="/FlowBuilder/images/admin_top_icon_1.gif">
	</td>
	<td width=60>
		<a href="#">パスワ-ドを修正</a>
	</td>

	<td width=35>
		<img src="/FlowBuilder/images/admin_top_icon_4.gif">
	</td>
	<td width=60>
		<a href="#" class="style1" >ϵͳ系統援助</a>
	</td>
	<td width=35>
		<img src="/FlowBuilder/images/admin_top_icon_2.gif">
	</td>
	<td width=60>
		<a href="#" target=_top>系統退出</a>
	</td>
	<td width="140"><!--#include file="#"-->
	</td>

	<td align="right">FlowBulder 仕事流&nbsp;&nbsp;&nbsp;&nbsp;</td>
</tr>
</table>
</body>
</html>
