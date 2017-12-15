<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/FlowBuilder.tld" prefix="FlowBuilder" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<html:html>
<head>
<title>Main</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="expires" content="0">
<html:base/>
</head>

<frameset rows="*" cols="181,*" framespacing="0" frameborder="1" border="false" id="frame" scrolling="yes">
  <html:frame scrolling="auto" marginwidth="0" marginheight="0" action="/flowbuilder/Left"></html:frame>
  <frameset framespacing="0" border="false" rows="35,*" frameborder="0" scrolling="yes">
    <html:frame  scrolling="no" action="/flowbuilder/Top"></html:frame>
    <html:frame  scrolling="auto" action="/flowbuilder/Main"></html:frame>
  </frameset>
</frameset>
<noframes>
  <body leftmargin="2" topmargin="0" marginwidth="0" marginheight="0">
  <p>sdfsdfdsfdfsdfsdfs</p>
  </body>
</noframes>
</html:html>
