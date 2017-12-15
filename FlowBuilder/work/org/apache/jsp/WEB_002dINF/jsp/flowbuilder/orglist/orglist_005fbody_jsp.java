package org.apache.jsp.WEB_002dINF.jsp.flowbuilder.orglist;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class orglist_005fbody_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(4);
    _jspx_dependants.add("/WEB-INF/FlowBuilder.tld");
    _jspx_dependants.add("/WEB-INF/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/struts-logic.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_iterate_type_name_indexId_id;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_define_property_name_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_link_styleClass_page;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_write_property_name_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_logic_iterate_type_name_indexId_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_define_property_name_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_link_styleClass_page = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_write_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_logic_iterate_type_name_indexId_id.release();
    _jspx_tagPool_bean_define_property_name_id_nobody.release();
    _jspx_tagPool_html_link_styleClass_page.release();
    _jspx_tagPool_bean_write_property_name_nobody.release();
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("﻿\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>FlowBuilder</title>\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("\t<link href=\"/FlowBuilder/css/flowbuilder_global.css\" tppabs=\"octopz_global.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"/FlowBuilder/css/flowbuilder_internal.css\" tppabs=\"octopz_internal.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<script src=\"/FlowBuilder/css/flowbuilder.js\" tppabs=\"octopz.js\" language=\"javascript\" type=\"text/javascript\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<br/><br/><br/><br/><br/>\r\n");
      out.write("<BODY BGCOLOR=\"#FFFFFF\" LEFTMARGIN=\"0\" TOPMARGIN=\"0\" MARGINWIDTH=\"0\" MARGINHEIGHT=\"0\">\r\n");
      out.write("\t<div id=\"container\">\r\n");
      out.write("\t\t\t<div id=\"left\">\r\n");
      out.write("\t\t\t<div id=\"topleft\">\r\n");
      out.write("\t\t\t\t<div id=\"buttons\">\r\n");
      out.write("\t\t    \t\t<ul>\r\n");
      out.write("\t\t\t\t\t</ul>\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t\t\t<div id=\"bottomleft\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t<div id=\"content\">\r\n");
      out.write("\t<table bgcolor='#999999' align=center border=0 cellpadding=1 cellspacing=1 width='100%'>\r\n");
      out.write("\t\t<tr bgcolor='#efefef' align='center' valign='middle'>\r\n");
      out.write("\t\t\t<td height=\"30\" width='100%' nowrap> 組織名称／役割名称 </td>\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");
      //  logic:iterate
      org.apache.struts.taglib.logic.IterateTag _jspx_th_logic_iterate_0 = (org.apache.struts.taglib.logic.IterateTag) _jspx_tagPool_logic_iterate_type_name_indexId_id.get(org.apache.struts.taglib.logic.IterateTag.class);
      _jspx_th_logic_iterate_0.setPageContext(_jspx_page_context);
      _jspx_th_logic_iterate_0.setParent(null);
      _jspx_th_logic_iterate_0.setId("orgSummary");
      _jspx_th_logic_iterate_0.setName("orgSummaryList");
      _jspx_th_logic_iterate_0.setType("flowbuilder.view.orglist.OrgDTO");
      _jspx_th_logic_iterate_0.setIndexId("index");
      int _jspx_eval_logic_iterate_0 = _jspx_th_logic_iterate_0.doStartTag();
      if (_jspx_eval_logic_iterate_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        flowbuilder.view.orglist.OrgDTO orgSummary = null;
        java.lang.Integer index = null;
        if (_jspx_eval_logic_iterate_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_logic_iterate_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_logic_iterate_0.doInitBody();
        }
        orgSummary = (flowbuilder.view.orglist.OrgDTO) _jspx_page_context.findAttribute("orgSummary");
        index = (java.lang.Integer) _jspx_page_context.findAttribute("index");
        do {
          out.write("\r\n");
          out.write("\t\t<tr align='center' bgcolor='#ffffff' valign='middle' onMouseOut =\"this.style.backgroundColor='#FFFFFF'\">\r\n");
          out.write("\t\t\t<td height=25 nowrap>\r\n");
          out.write("\t\t\t\t");
          //  bean:define
          org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_0 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
          _jspx_th_bean_define_0.setPageContext(_jspx_page_context);
          _jspx_th_bean_define_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_iterate_0);
          _jspx_th_bean_define_0.setId("orgId");
          _jspx_th_bean_define_0.setName("orgSummary");
          _jspx_th_bean_define_0.setProperty("orgId");
          int _jspx_eval_bean_define_0 = _jspx_th_bean_define_0.doStartTag();
          if (_jspx_th_bean_define_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_bean_define_property_name_id_nobody.reuse(_jspx_th_bean_define_0);
          java.lang.Object orgId = null;
          orgId = (java.lang.Object) _jspx_page_context.findAttribute("orgId");
          out.write("\r\n");
          out.write("\t\t\t\t");
          //  bean:define
          org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_1 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
          _jspx_th_bean_define_1.setPageContext(_jspx_page_context);
          _jspx_th_bean_define_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_iterate_0);
          _jspx_th_bean_define_1.setId("roleId");
          _jspx_th_bean_define_1.setName("orgSummary");
          _jspx_th_bean_define_1.setProperty("roleId");
          int _jspx_eval_bean_define_1 = _jspx_th_bean_define_1.doStartTag();
          if (_jspx_th_bean_define_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_bean_define_property_name_id_nobody.reuse(_jspx_th_bean_define_1);
          java.lang.Object roleId = null;
          roleId = (java.lang.Object) _jspx_page_context.findAttribute("roleId");
          out.write("\r\n");
          out.write("\t\t\t\t");
          //  html:link
          org.apache.struts.taglib.html.LinkTag _jspx_th_html_link_0 = (org.apache.struts.taglib.html.LinkTag) _jspx_tagPool_html_link_styleClass_page.get(org.apache.struts.taglib.html.LinkTag.class);
          _jspx_th_html_link_0.setPageContext(_jspx_page_context);
          _jspx_th_html_link_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_iterate_0);
          _jspx_th_html_link_0.setPage("/do/flowbuilder/JobList?method=jobDetail&amp;orgId=" + orgId + "&amp;roleId=" + roleId);
          _jspx_th_html_link_0.setStyleClass("go");
          int _jspx_eval_html_link_0 = _jspx_th_html_link_0.doStartTag();
          if (_jspx_eval_html_link_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_html_link_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_html_link_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_html_link_0.doInitBody();
            }
            do {
              out.write("\r\n");
              out.write("\t\t\t\t\t");
              if (_jspx_meth_bean_write_0(_jspx_th_html_link_0, _jspx_page_context))
                return;
              out.write('／');
              if (_jspx_meth_bean_write_1(_jspx_th_html_link_0, _jspx_page_context))
                return;
              out.write("\r\n");
              out.write("\t\t\t\t");
              int evalDoAfterBody = _jspx_th_html_link_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_html_link_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_html_link_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_html_link_styleClass_page.reuse(_jspx_th_html_link_0);
          out.write("\r\n");
          out.write("\t\t\t</td>\r\n");
          out.write("\t\t</tr>\r\n");
          out.write("\t\t");
          int evalDoAfterBody = _jspx_th_logic_iterate_0.doAfterBody();
          orgSummary = (flowbuilder.view.orglist.OrgDTO) _jspx_page_context.findAttribute("orgSummary");
          index = (java.lang.Integer) _jspx_page_context.findAttribute("index");
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_logic_iterate_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
      }
      if (_jspx_th_logic_iterate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_logic_iterate_type_name_indexId_id.reuse(_jspx_th_logic_iterate_0);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\t<h6 align=\"left\"></h6><p><br />\r\n");
      out.write("\t\t</p>\r\n");
      out.write("\t\t<p><br />\r\n");
      out.write("\t\t</p>\r\n");
      out.write("<BR>\r\n");
      out.write("<BR>\r\n");
      out.write("<BR>\r\n");
      out.write("<BR>\r\n");
      out.write("<BR>\r\n");
      out.write("<BR>\r\n");
      out.write("<BR>\r\n");
      out.write("<BR>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div id=\"clearbottom\">&nbsp;</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"footer\">\r\n");
      out.write("  <div id=\"copyright\">Copyright © 2007 華夏計算機技術有限公司</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<!--\r\n");
      out.write("\t\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t<table align=center border=0 cellpadding=1 cellspacing=1 width=\"50%\">\r\n");
      out.write("\t\t<tr> </br>\r\n");
      out.write("\t\t\t<td width=300 align=\"left\"><img src=\"/FlowBuilder/images/orgSelect.gif\"></img></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<table align=center border=0 cellpadding=1 cellspacing=1 width=\"80%\">\r\n");
      out.write("\t\t<tr> \r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t<table bgcolor='#999999' align=center border=0 cellpadding=1 cellspacing=1 width='60%'>\r\n");
      out.write("\t\t<tr bgcolor='#efefef' align='center' valign='middle'>\r\n");
      out.write("\t\t\t<td height=22 width='100%' nowrap> 組織名称／役割名称 </td>\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");
      //  logic:iterate
      org.apache.struts.taglib.logic.IterateTag _jspx_th_logic_iterate_1 = (org.apache.struts.taglib.logic.IterateTag) _jspx_tagPool_logic_iterate_type_name_indexId_id.get(org.apache.struts.taglib.logic.IterateTag.class);
      _jspx_th_logic_iterate_1.setPageContext(_jspx_page_context);
      _jspx_th_logic_iterate_1.setParent(null);
      _jspx_th_logic_iterate_1.setId("orgSummary");
      _jspx_th_logic_iterate_1.setName("orgSummaryList");
      _jspx_th_logic_iterate_1.setType("flowbuilder.view.orglist.OrgDTO");
      _jspx_th_logic_iterate_1.setIndexId("index");
      int _jspx_eval_logic_iterate_1 = _jspx_th_logic_iterate_1.doStartTag();
      if (_jspx_eval_logic_iterate_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        flowbuilder.view.orglist.OrgDTO orgSummary = null;
        java.lang.Integer index = null;
        if (_jspx_eval_logic_iterate_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_logic_iterate_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_logic_iterate_1.doInitBody();
        }
        orgSummary = (flowbuilder.view.orglist.OrgDTO) _jspx_page_context.findAttribute("orgSummary");
        index = (java.lang.Integer) _jspx_page_context.findAttribute("index");
        do {
          out.write("\r\n");
          out.write("\t\t<tr align='center' bgcolor='#ffffff' valign='middle' onMouseOut =\"this.style.backgroundColor='#FFFFFF'\">\r\n");
          out.write("\t\t\t<td height=25 nowrap>\r\n");
          out.write("\t\t\t\t");
          //  bean:define
          org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_2 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
          _jspx_th_bean_define_2.setPageContext(_jspx_page_context);
          _jspx_th_bean_define_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_iterate_1);
          _jspx_th_bean_define_2.setId("orgId");
          _jspx_th_bean_define_2.setName("orgSummary");
          _jspx_th_bean_define_2.setProperty("orgId");
          int _jspx_eval_bean_define_2 = _jspx_th_bean_define_2.doStartTag();
          if (_jspx_th_bean_define_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_bean_define_property_name_id_nobody.reuse(_jspx_th_bean_define_2);
          java.lang.Object orgId = null;
          orgId = (java.lang.Object) _jspx_page_context.findAttribute("orgId");
          out.write("\r\n");
          out.write("\t\t\t\t");
          //  bean:define
          org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_3 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
          _jspx_th_bean_define_3.setPageContext(_jspx_page_context);
          _jspx_th_bean_define_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_iterate_1);
          _jspx_th_bean_define_3.setId("roleId");
          _jspx_th_bean_define_3.setName("orgSummary");
          _jspx_th_bean_define_3.setProperty("roleId");
          int _jspx_eval_bean_define_3 = _jspx_th_bean_define_3.doStartTag();
          if (_jspx_th_bean_define_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_bean_define_property_name_id_nobody.reuse(_jspx_th_bean_define_3);
          java.lang.Object roleId = null;
          roleId = (java.lang.Object) _jspx_page_context.findAttribute("roleId");
          out.write("\r\n");
          out.write("\t\t\t\t");
          //  html:link
          org.apache.struts.taglib.html.LinkTag _jspx_th_html_link_1 = (org.apache.struts.taglib.html.LinkTag) _jspx_tagPool_html_link_styleClass_page.get(org.apache.struts.taglib.html.LinkTag.class);
          _jspx_th_html_link_1.setPageContext(_jspx_page_context);
          _jspx_th_html_link_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_iterate_1);
          _jspx_th_html_link_1.setPage("/do/flowbuilder/JobList?orgId=" + orgId + "&amp;roleId=" + roleId);
          _jspx_th_html_link_1.setStyleClass("go");
          int _jspx_eval_html_link_1 = _jspx_th_html_link_1.doStartTag();
          if (_jspx_eval_html_link_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_html_link_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_html_link_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_html_link_1.doInitBody();
            }
            do {
              out.write("\r\n");
              out.write("\t\t\t\t\t");
              if (_jspx_meth_bean_write_2(_jspx_th_html_link_1, _jspx_page_context))
                return;
              out.write('／');
              if (_jspx_meth_bean_write_3(_jspx_th_html_link_1, _jspx_page_context))
                return;
              out.write("\r\n");
              out.write("\t\t\t\t");
              int evalDoAfterBody = _jspx_th_html_link_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_html_link_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_html_link_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_html_link_styleClass_page.reuse(_jspx_th_html_link_1);
          out.write("\r\n");
          out.write("\t\t\t</td>\r\n");
          out.write("\t\t</tr>\r\n");
          out.write("\t\t");
          int evalDoAfterBody = _jspx_th_logic_iterate_1.doAfterBody();
          orgSummary = (flowbuilder.view.orglist.OrgDTO) _jspx_page_context.findAttribute("orgSummary");
          index = (java.lang.Integer) _jspx_page_context.findAttribute("index");
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_logic_iterate_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
      }
      if (_jspx_th_logic_iterate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_logic_iterate_type_name_indexId_id.reuse(_jspx_th_logic_iterate_1);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<p>&nbsp;</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t-->\r\n");
      out.write("</BODY>\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_bean_write_0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_link_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_0 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_0.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_link_0);
    _jspx_th_bean_write_0.setName("orgSummary");
    _jspx_th_bean_write_0.setProperty("orgName");
    int _jspx_eval_bean_write_0 = _jspx_th_bean_write_0.doStartTag();
    if (_jspx_th_bean_write_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_nobody.reuse(_jspx_th_bean_write_0);
    return false;
  }

  private boolean _jspx_meth_bean_write_1(javax.servlet.jsp.tagext.JspTag _jspx_th_html_link_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_1 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_1.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_link_0);
    _jspx_th_bean_write_1.setName("orgSummary");
    _jspx_th_bean_write_1.setProperty("roleName");
    int _jspx_eval_bean_write_1 = _jspx_th_bean_write_1.doStartTag();
    if (_jspx_th_bean_write_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_nobody.reuse(_jspx_th_bean_write_1);
    return false;
  }

  private boolean _jspx_meth_bean_write_2(javax.servlet.jsp.tagext.JspTag _jspx_th_html_link_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_2 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_2.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_link_1);
    _jspx_th_bean_write_2.setName("orgSummary");
    _jspx_th_bean_write_2.setProperty("orgName");
    int _jspx_eval_bean_write_2 = _jspx_th_bean_write_2.doStartTag();
    if (_jspx_th_bean_write_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_nobody.reuse(_jspx_th_bean_write_2);
    return false;
  }

  private boolean _jspx_meth_bean_write_3(javax.servlet.jsp.tagext.JspTag _jspx_th_html_link_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_3 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_3.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_link_1);
    _jspx_th_bean_write_3.setName("orgSummary");
    _jspx_th_bean_write_3.setProperty("roleName");
    int _jspx_eval_bean_write_3 = _jspx_th_bean_write_3.doStartTag();
    if (_jspx_th_bean_write_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_nobody.reuse(_jspx_th_bean_write_3);
    return false;
  }
}
