<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Shift_JIS" %>
<%@ taglib uri="http://struts-menu.sf.net/tag" prefix="menu" %>
<%/*
 * ==================================================================
 * NO.83XXXXXX
 *
 * ITEM = 001 ; REV = 00 ; DATE '04/11/22
 *
 * (c) 2004 Yamatake Corporation  All Rights Reserved
 *
 * ORIGINAL SOURCE INFORMATION
 *
 * REVISION HISTORY
 *			REV.00 '04/11/22 BY. T.Okuyama (BSC)
 * ==================================================================
*/%>
<menu:useMenuDisplayer name="TabbedMenu" bundle="org.apache.struts.action.MESSAGE"
	permissions="builRolesAdapter">
    <menu:displayMenu name="Entrance"/>
    <menu:displayMenu name="Alarm"/>
    <menu:displayMenu name="Trouble"/>
    <menu:displayMenu name="BuilInfo"/>
    <menu:displayMenu name="Schedule"/>
    <menu:displayMenu name="Report"/>
    <menu:displayMenu name="Map"/>
    <menu:displayMenu name="Manage"/>
</menu:useMenuDisplayer>
