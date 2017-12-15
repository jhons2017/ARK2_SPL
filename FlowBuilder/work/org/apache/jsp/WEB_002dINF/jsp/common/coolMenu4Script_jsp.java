package org.apache.jsp.WEB_002dINF.jsp.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class coolMenu4Script_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
/*
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
*/
      out.write('\r');
      out.write('\n');
/**
 * デフォルトのJavascript宣言
 */
      out.write('\r');
      out.write('\n');
 //メニュー用 
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"/FlowBuilder/scripts/coolmenus4.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/FlowBuilder/scripts/cm_addins.js\"></script>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
