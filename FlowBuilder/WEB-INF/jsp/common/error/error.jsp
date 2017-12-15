<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Shift_JIS" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%/*
 * NO.83XXXXXX
 *
 * ITEM = 001 ; REV = 00 ; DATE '05/12/17
 *
 * (c) 2005 Yamatake Corporation  All Rights Reserved
 *
 * ORIGINAL SOURCE INFORMATION
 *
 * REVISION HISTORY
 *			REV.00 '05/12/17 BY. DHW (WXHX)
 * ==================================================================
*/%>
<html:html>
<HEAD>
<META>
	<jsp:include page="../css.jsp"/>
</META>
<TITLE></TITLE>
</HEAD>
<BODY>
	<DIV class="error"><!-- クラス名は修正する必要がある -->
		<bean:message key="Error.Message"/>
		<html:errors/>

	</DIV>
	<P>
		<bean:write name="dateTime"/>
	</P>
	<HR>
	<P>
		<html:link forward="Obsam_Ent_Entrance" styleClass="detail"><bean:message key="Entrance.Title"/></html:link>
	</P>
</BODY>
</html:html>