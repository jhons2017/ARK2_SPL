package org.apache.jsp.WEB_002dINF.jsp.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class coolMenu4OrgSelect_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_menu_useMenuDisplayer_permissions_name_bundle;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_menu_displayMenu_name_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_menu_useMenuDisplayer_permissions_name_bundle = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_menu_displayMenu_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_menu_useMenuDisplayer_permissions_name_bundle.release();
    _jspx_tagPool_menu_displayMenu_name_nobody.release();
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

      out.write("\r\n");
      out.write("\r\n");
/*
 * ==================================================================
 * NO.83XXXXXX
 *
 * ITEM = 001 ; REV = 00 ; DATE '06/07/10
 *
 * (c) 2005 WXHX Corporation  All Rights Reserved
 *
 * ORIGINAL SOURCE INFORMATION
 *
 * REVISION HISTORY
 *			REV.00 '06/07/10 BY. DHW (WXHX)
 * ==================================================================
 */
      out.write("\r\n");
      out.write("<!-- Custom Configuration for this example, must come after body to work in IE -->    \r\n");
      out.write("<script type=\"text/javascript\" src=\"/FlowBuilder/scripts/coolmenu4-config.js\"></script>\r\n");
      if (_jspx_meth_menu_useMenuDisplayer_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<BR>\r\n");
      out.write("<BR>");
//この改行は、メニューがメインエリアと重複して表示されないようにするためのものである
      out.write('\r');
      out.write('\n');
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

  private boolean _jspx_meth_menu_useMenuDisplayer_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:useMenuDisplayer
    net.sf.navigator.taglib.UseMenuDisplayerTag _jspx_th_menu_useMenuDisplayer_0 = (net.sf.navigator.taglib.UseMenuDisplayerTag) _jspx_tagPool_menu_useMenuDisplayer_permissions_name_bundle.get(net.sf.navigator.taglib.UseMenuDisplayerTag.class);
    _jspx_th_menu_useMenuDisplayer_0.setPageContext(_jspx_page_context);
    _jspx_th_menu_useMenuDisplayer_0.setParent(null);
    _jspx_th_menu_useMenuDisplayer_0.setName("CoolMenu4");
    _jspx_th_menu_useMenuDisplayer_0.setBundle("org.apache.struts.action.MESSAGE");
    _jspx_th_menu_useMenuDisplayer_0.setPermissions("builRolesAdapter");
    int _jspx_eval_menu_useMenuDisplayer_0 = _jspx_th_menu_useMenuDisplayer_0.doStartTag();
    if (_jspx_eval_menu_useMenuDisplayer_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("    ");
        if (_jspx_meth_menu_displayMenu_0(_jspx_th_menu_useMenuDisplayer_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("    ");
        if (_jspx_meth_menu_displayMenu_1(_jspx_th_menu_useMenuDisplayer_0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        int evalDoAfterBody = _jspx_th_menu_useMenuDisplayer_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_menu_useMenuDisplayer_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_menu_useMenuDisplayer_permissions_name_bundle.reuse(_jspx_th_menu_useMenuDisplayer_0);
    return false;
  }

  private boolean _jspx_meth_menu_displayMenu_0(javax.servlet.jsp.tagext.JspTag _jspx_th_menu_useMenuDisplayer_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:displayMenu
    net.sf.navigator.taglib.DisplayMenuTag _jspx_th_menu_displayMenu_0 = (net.sf.navigator.taglib.DisplayMenuTag) _jspx_tagPool_menu_displayMenu_name_nobody.get(net.sf.navigator.taglib.DisplayMenuTag.class);
    _jspx_th_menu_displayMenu_0.setPageContext(_jspx_page_context);
    _jspx_th_menu_displayMenu_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_menu_useMenuDisplayer_0);
    _jspx_th_menu_displayMenu_0.setName("OrgSelect");
    int _jspx_eval_menu_displayMenu_0 = _jspx_th_menu_displayMenu_0.doStartTag();
    if (_jspx_th_menu_displayMenu_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_menu_displayMenu_name_nobody.reuse(_jspx_th_menu_displayMenu_0);
    return false;
  }

  private boolean _jspx_meth_menu_displayMenu_1(javax.servlet.jsp.tagext.JspTag _jspx_th_menu_useMenuDisplayer_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  menu:displayMenu
    net.sf.navigator.taglib.DisplayMenuTag _jspx_th_menu_displayMenu_1 = (net.sf.navigator.taglib.DisplayMenuTag) _jspx_tagPool_menu_displayMenu_name_nobody.get(net.sf.navigator.taglib.DisplayMenuTag.class);
    _jspx_th_menu_displayMenu_1.setPageContext(_jspx_page_context);
    _jspx_th_menu_displayMenu_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_menu_useMenuDisplayer_0);
    _jspx_th_menu_displayMenu_1.setName("Manage");
    int _jspx_eval_menu_displayMenu_1 = _jspx_th_menu_displayMenu_1.doStartTag();
    if (_jspx_th_menu_displayMenu_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_menu_displayMenu_name_nobody.reuse(_jspx_th_menu_displayMenu_1);
    return false;
  }
}
