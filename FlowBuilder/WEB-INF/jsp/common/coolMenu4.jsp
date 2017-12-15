<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Shift_JIS" %>
<%@ taglib uri="http://struts-menu.sf.net/tag" prefix="menu" %>
<%/*
 * ==================================================================
 * NO.83XXXXXX
 *
 * ITEM = 001 ; REV = 00 ; DATE '06/07/10
 *
 * (c) 2006 WXHX Corporation  All Rights Reserved
 *
 * ORIGINAL SOURCE INFORMATION
 *
 * REVISION HISTORY
 *			REV.00 '06/07/10 BY. DHW (WXHX)
 * ==================================================================
*/%>
<!-- Custom Configuration for this example, must come after body to work in IE -->    
<script type="text/javascript" src="/FlowBuilder/scripts/coolmenu4-config.js"></script>

<menu:useMenuDisplayer name="CoolMenu4" bundle="org.apache.struts.action.MESSAGE"
	permissions="builRolesAdapter">
	<menu:displayMenu name="OrgSelect"/>
    <menu:displayMenu name="JobList"/>
    <menu:displayMenu name="JobApplication"/>
    <menu:displayMenu name="UserManage"/>
</menu:useMenuDisplayer>
<BR>
<BR><%//この改行は、メニューがメインエリアと重複して表示されないようにするためのものである%>
