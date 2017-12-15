package org.apache.jsp.WEB_002dINF.jsp.layouts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class flowbuilderDefaultLayout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(3);
    _jspx_dependants.add("/WEB-INF/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/struts-tiles.tld");
    _jspx_dependants.add("/WEB-INF/struts-bean.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_html;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_tiles_insert_attribute_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_html_html = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_tiles_insert_attribute_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_html_html.release();
    _jspx_tagPool_tiles_insert_attribute_nobody.release();
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
      out.write("\r\n");
      out.write("\r\n");
/*
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
*/
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> \r\n");
      if (_jspx_meth_html_html_0(_jspx_page_context))
        return;
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

  private boolean _jspx_meth_html_html_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:html
    org.apache.struts.taglib.html.HtmlTag _jspx_th_html_html_0 = (org.apache.struts.taglib.html.HtmlTag) _jspx_tagPool_html_html.get(org.apache.struts.taglib.html.HtmlTag.class);
    _jspx_th_html_html_0.setPageContext(_jspx_page_context);
    _jspx_th_html_html_0.setParent(null);
    int _jspx_eval_html_html_0 = _jspx_th_html_html_0.doStartTag();
    if (_jspx_eval_html_html_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("<HEAD>\r\n");
        out.write("\t<!-- CSS            -->\r\n");
        out.write("\t");
        if (_jspx_meth_tiles_insert_0(_jspx_th_html_html_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t<!-- SCRIPT         -->\r\n");
        out.write("\t");
        if (_jspx_meth_tiles_insert_1(_jspx_th_html_html_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("<TITLE>ワークフローシステム</TITLE>\r\n");
        out.write("</HEAD> \r\n");
        out.write("<script src=\"/FlowBuilder/scripts/keyctrl.js\" tppabs=\"octopz.js\" language=\"javascript\" type=\"text/javascript\"></script>\r\n");
        out.write("<script language=\"javascript\">\r\n");
        out.write("function run()\r\n");
        out.write("{\r\n");
        out.write("\tbox.style.visibility = \"hidden\";\r\n");
        out.write("}\r\n");
        out.write("\r\n");
        out.write("</script>\r\n");
        out.write("<BODY onLoad=\"run();\">\r\n");
        out.write("<script language=\"javascript\"> \r\n");
        out.write("\tfunction stop() \r\n");
        out.write("\t{ \r\n");
        out.write("\t\treturn false; \r\n");
        out.write("\t} \r\n");
        out.write("\tdocument.oncontextmenu=stop; \r\n");
        out.write("</script>\r\n");
        out.write("\r\n");
        out.write("<div id=\"box\" style=\"position:absolute; left:1px; top:1px; width:1260px; height:928px; z-index:1; background-color: #CCCCCC; layer-background-color: #0000ff; border: 1px none #000000; visibility:visible;\">\r\n");
        out.write("<table border=\"1\" width=\"37%\" align=\"center\" cellspacing=\"0\" cellpadding=\"4\" style=\"border-collapse: colla\tpse\" bgcolor=\"#FFFFEC\" height=\"87\">\r\n");
        out.write("\t<BR><BR><BR><BR><BR><BR><BR><BR>\r\n");
        out.write("\t<tr>\r\n");
        out.write("\t\t<td bgcolor=\"#3399FF\" style=\"font-size:12px;color:#ffffff\" height=24>業務処理中...</td>\r\n");
        out.write("\t</tr>\r\n");
        out.write("\t<tr>\r\n");
        out.write("\t\t<td style=\"font-size:12px;line-height:200%\" align=center>業務処理中、少々お待ちください...<br>\r\n");
        out.write("\t\t<marquee style=\"border:1px solid #000000\" direction=\"right\" width=\"300\" scrollamount=\"5\" scrolldelay=\"10\" bgcolor=\"#ECF2FF\">\r\n");
        out.write("\t\t<table cellspacing=\"1\" cellpadding=\"0\">\r\n");
        out.write("\t\t<tr height=8>\r\n");
        out.write("\t\t<td bgcolor=#3399FF width=8></td>\r\n");
        out.write("\t\t<td></td>\r\n");
        out.write("\t\t<td bgcolor=#3399FF width=8></td>\r\n");
        out.write("\t\t<td></td>\r\n");
        out.write("\t\t<td bgcolor=#3399FF width=8></td>\r\n");
        out.write("\t\t<td></td>\r\n");
        out.write("\t\t<td bgcolor=#3399FF width=8></td>\r\n");
        out.write("\t\t<td></td>\r\n");
        out.write("\t\t</tr></table></marquee></td>\r\n");
        out.write("\t</tr>\r\n");
        out.write("</table>\r\n");
        out.write("</div>\r\n");
        out.write("<TABLE align=\"center\">\r\n");
        out.write("\t<TR>\r\n");
        out.write("\t\t<TD>\r\n");
        out.write("\t\t\t<!-- Header        -->\r\n");
        out.write("\t\t\t");
        if (_jspx_meth_tiles_insert_2(_jspx_th_html_html_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t<!-- Menu          -->\r\n");
        out.write("\t\t\t");
        if (_jspx_meth_tiles_insert_3(_jspx_th_html_html_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t<!-- Body Contents -->\r\n");
        out.write("\t\t\t");
        if (_jspx_meth_tiles_insert_4(_jspx_th_html_html_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t</TD>\r\n");
        out.write("\t</TR>\r\n");
        out.write("</TABLE>\r\n");
        out.write("</BODY>\r\n");
        int evalDoAfterBody = _jspx_th_html_html_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_html_html_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_html.reuse(_jspx_th_html_html_0);
    return false;
  }

  private boolean _jspx_meth_tiles_insert_0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_html_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insert
    org.apache.struts.taglib.tiles.InsertTag _jspx_th_tiles_insert_0 = (org.apache.struts.taglib.tiles.InsertTag) _jspx_tagPool_tiles_insert_attribute_nobody.get(org.apache.struts.taglib.tiles.InsertTag.class);
    _jspx_th_tiles_insert_0.setPageContext(_jspx_page_context);
    _jspx_th_tiles_insert_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_html_0);
    _jspx_th_tiles_insert_0.setAttribute("css");
    int _jspx_eval_tiles_insert_0 = _jspx_th_tiles_insert_0.doStartTag();
    if (_jspx_th_tiles_insert_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_tiles_insert_attribute_nobody.reuse(_jspx_th_tiles_insert_0);
    return false;
  }

  private boolean _jspx_meth_tiles_insert_1(javax.servlet.jsp.tagext.JspTag _jspx_th_html_html_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insert
    org.apache.struts.taglib.tiles.InsertTag _jspx_th_tiles_insert_1 = (org.apache.struts.taglib.tiles.InsertTag) _jspx_tagPool_tiles_insert_attribute_nobody.get(org.apache.struts.taglib.tiles.InsertTag.class);
    _jspx_th_tiles_insert_1.setPageContext(_jspx_page_context);
    _jspx_th_tiles_insert_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_html_0);
    _jspx_th_tiles_insert_1.setAttribute("script");
    int _jspx_eval_tiles_insert_1 = _jspx_th_tiles_insert_1.doStartTag();
    if (_jspx_th_tiles_insert_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_tiles_insert_attribute_nobody.reuse(_jspx_th_tiles_insert_1);
    return false;
  }

  private boolean _jspx_meth_tiles_insert_2(javax.servlet.jsp.tagext.JspTag _jspx_th_html_html_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insert
    org.apache.struts.taglib.tiles.InsertTag _jspx_th_tiles_insert_2 = (org.apache.struts.taglib.tiles.InsertTag) _jspx_tagPool_tiles_insert_attribute_nobody.get(org.apache.struts.taglib.tiles.InsertTag.class);
    _jspx_th_tiles_insert_2.setPageContext(_jspx_page_context);
    _jspx_th_tiles_insert_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_html_0);
    _jspx_th_tiles_insert_2.setAttribute("header");
    int _jspx_eval_tiles_insert_2 = _jspx_th_tiles_insert_2.doStartTag();
    if (_jspx_th_tiles_insert_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_tiles_insert_attribute_nobody.reuse(_jspx_th_tiles_insert_2);
    return false;
  }

  private boolean _jspx_meth_tiles_insert_3(javax.servlet.jsp.tagext.JspTag _jspx_th_html_html_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insert
    org.apache.struts.taglib.tiles.InsertTag _jspx_th_tiles_insert_3 = (org.apache.struts.taglib.tiles.InsertTag) _jspx_tagPool_tiles_insert_attribute_nobody.get(org.apache.struts.taglib.tiles.InsertTag.class);
    _jspx_th_tiles_insert_3.setPageContext(_jspx_page_context);
    _jspx_th_tiles_insert_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_html_0);
    _jspx_th_tiles_insert_3.setAttribute("menu");
    int _jspx_eval_tiles_insert_3 = _jspx_th_tiles_insert_3.doStartTag();
    if (_jspx_th_tiles_insert_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_tiles_insert_attribute_nobody.reuse(_jspx_th_tiles_insert_3);
    return false;
  }

  private boolean _jspx_meth_tiles_insert_4(javax.servlet.jsp.tagext.JspTag _jspx_th_html_html_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insert
    org.apache.struts.taglib.tiles.InsertTag _jspx_th_tiles_insert_4 = (org.apache.struts.taglib.tiles.InsertTag) _jspx_tagPool_tiles_insert_attribute_nobody.get(org.apache.struts.taglib.tiles.InsertTag.class);
    _jspx_th_tiles_insert_4.setPageContext(_jspx_page_context);
    _jspx_th_tiles_insert_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_html_0);
    _jspx_th_tiles_insert_4.setAttribute("bodyContents");
    int _jspx_eval_tiles_insert_4 = _jspx_th_tiles_insert_4.doStartTag();
    if (_jspx_th_tiles_insert_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_tiles_insert_attribute_nobody.reuse(_jspx_th_tiles_insert_4);
    return false;
  }
}
