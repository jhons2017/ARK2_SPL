package org.apache.jsp.WEB_002dINF.jsp.flowbuilder.joblist;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class joblist_005fbody_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(4);
    _jspx_dependants.add("/WEB-INF/FlowBuilder.tld");
    _jspx_dependants.add("/WEB-INF/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/struts-logic.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_define_type_scope_name_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_define_type_scope_property_name_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_FlowBuilder_partJobList_userRole_userId_partXml_pageInfo_orgId_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_link_page;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_write_property_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_hidden_value_property_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_define_scope_name_id_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_bean_define_type_scope_name_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_define_type_scope_property_name_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_FlowBuilder_partJobList_userRole_userId_partXml_pageInfo_orgId_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_link_page = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_write_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_hidden_value_property_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_define_scope_name_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_bean_define_type_scope_name_id_nobody.release();
    _jspx_tagPool_bean_define_type_scope_property_name_id_nobody.release();
    _jspx_tagPool_FlowBuilder_partJobList_userRole_userId_partXml_pageInfo_orgId_nobody.release();
    _jspx_tagPool_html_link_page.release();
    _jspx_tagPool_bean_write_property_name_nobody.release();
    _jspx_tagPool_html_hidden_value_property_nobody.release();
    _jspx_tagPool_bean_define_scope_name_id_nobody.release();
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>ワークフローシステム</title>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<meta http-equiv=\"expires\" content=\"0\">\r\n");
      out.write("</head>\r\n");
      out.write("<SCRIPT type=\"text/javascript\" src=\"/FlowBuilder/scripts/chiphelp.js\"></SCRIPT>\r\n");
      out.write("<BODY BGCOLOR=\"#FFFFFF\" LEFTMARGIN=\"0\" TOPMARGIN=\"0\" MARGINWIDTH=\"0\" MARGINHEIGHT=\"0\">\r\n");
      out.write("\t<div id=\"container\">\r\n");
      out.write("\r\n");
      out.write("<div id=\"content\">\r\n");
      out.write("\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t<tr> \r\n");
      out.write("\t\t\t<td></td>\r\n");
      out.write("\t\t\t<td align=\"left\" valign=\"middle\"><img src=\"/FlowBuilder/images/list.gif\"></img></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<table bgcolor=\"#AABBDD\" align=\"center\" width=\"80%\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t<tr bgcolor=\"#FFFFFF\"> \r\n");
      out.write("\t\t\t<td height=30 align=\"right\">\r\n");
      out.write("\t\t\t");
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_0 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_scope_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_0.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_0.setParent(null);
      _jspx_th_bean_define_0.setId("pInfo");
      _jspx_th_bean_define_0.setName("pageinfo");
      _jspx_th_bean_define_0.setType("flowbuilder.presentation.webcmn.taglibs.domain.page.PageInfo");
      _jspx_th_bean_define_0.setScope("session");
      int _jspx_eval_bean_define_0 = _jspx_th_bean_define_0.doStartTag();
      if (_jspx_th_bean_define_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_scope_name_id_nobody.reuse(_jspx_th_bean_define_0);
      flowbuilder.presentation.webcmn.taglibs.domain.page.PageInfo pInfo = null;
      pInfo = (flowbuilder.presentation.webcmn.taglibs.domain.page.PageInfo) _jspx_page_context.findAttribute("pInfo");
      out.write("\r\n");
      out.write("\t\t\t");
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_1 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_scope_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_1.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_1.setParent(null);
      _jspx_th_bean_define_1.setId("userId");
      _jspx_th_bean_define_1.setName("user");
      _jspx_th_bean_define_1.setProperty("userId");
      _jspx_th_bean_define_1.setType("java.lang.String");
      _jspx_th_bean_define_1.setScope("session");
      int _jspx_eval_bean_define_1 = _jspx_th_bean_define_1.doStartTag();
      if (_jspx_th_bean_define_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_scope_property_name_id_nobody.reuse(_jspx_th_bean_define_1);
      java.lang.String userId = null;
      userId = (java.lang.String) _jspx_page_context.findAttribute("userId");
      out.write("\r\n");
      out.write("\t\t\t");
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_2 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_scope_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_2.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_2.setParent(null);
      _jspx_th_bean_define_2.setId("orgId");
      _jspx_th_bean_define_2.setName("user");
      _jspx_th_bean_define_2.setProperty("orgId");
      _jspx_th_bean_define_2.setType("java.lang.String");
      _jspx_th_bean_define_2.setScope("session");
      int _jspx_eval_bean_define_2 = _jspx_th_bean_define_2.doStartTag();
      if (_jspx_th_bean_define_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_scope_property_name_id_nobody.reuse(_jspx_th_bean_define_2);
      java.lang.String orgId = null;
      orgId = (java.lang.String) _jspx_page_context.findAttribute("orgId");
      out.write("\r\n");
      out.write("\t\t\t");
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_3 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_scope_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_3.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_3.setParent(null);
      _jspx_th_bean_define_3.setId("userRole");
      _jspx_th_bean_define_3.setName("user");
      _jspx_th_bean_define_3.setProperty("userRole");
      _jspx_th_bean_define_3.setType("flowbuilder.domain.user.UserRole");
      _jspx_th_bean_define_3.setScope("session");
      int _jspx_eval_bean_define_3 = _jspx_th_bean_define_3.doStartTag();
      if (_jspx_th_bean_define_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_scope_property_name_id_nobody.reuse(_jspx_th_bean_define_3);
      flowbuilder.domain.user.UserRole userRole = null;
      userRole = (flowbuilder.domain.user.UserRole) _jspx_page_context.findAttribute("userRole");
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr bgcolor=\"#FFFFFF\"> \r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t<!--案件一覧表示部品-->\r\n");
      out.write("\t\t\t\t");
      //  FlowBuilder:partJobList
      flowbuilder.presentation.webcmn.taglibs.PartJobList _jspx_th_FlowBuilder_partJobList_0 = (flowbuilder.presentation.webcmn.taglibs.PartJobList) _jspx_tagPool_FlowBuilder_partJobList_userRole_userId_partXml_pageInfo_orgId_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartJobList.class);
      _jspx_th_FlowBuilder_partJobList_0.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partJobList_0.setParent(null);
      _jspx_th_FlowBuilder_partJobList_0.setPageInfo(pInfo);
      _jspx_th_FlowBuilder_partJobList_0.setOrgId(orgId);
      _jspx_th_FlowBuilder_partJobList_0.setUserId(userId);
      _jspx_th_FlowBuilder_partJobList_0.setUserRole(userRole);
      _jspx_th_FlowBuilder_partJobList_0.setPartXml(
				"<部品>" +
					"<template id='0001' title='セキュリティ申込書'>" +
						"<con status='マネージャ承認'>" +
							"<user role='部長' org='*,SI事業部' userid=''/>"+
						"</con>"+
						"<con status='グループ長承認'>" +
							"<user role='部長' org='*,SI事業部' userid=''/>"+
						"</con>"+
						"<con status='部長承認'>" +
							"<user role='部長' org='SI事業部' userid=''/>"+
						"</con>"+
						"<con status='SI事業部長承認'>" +
							"<user role='部長' org='*' userid=''/>"+
						"</con>"+
						"<con status='開通状態'>" +
							"<user role='部長' org='*' userid=''/>"+
						"</con>"+
					"</template>" +
					"<template id='0002' title='設備申請'>" +
						"<con status='部長承認'>" +
							"<user role='部長' org='SI事業部' userid=''/>"+
						"</con>"+
						"<con status='SI事業部長承認'>" +
							"<user role='部長' org='*' userid=''/>"+
						"</con>"+
						"<con status='開通'>" +
							"<user role='部長' org='*' userid=''/>"+
							"<user role='部長' org='SI事業部' userid=''/>"+
						"</con>"+
						"<con status='中止'>" +
							"<user role='部長' org='*' userid=''/>"+
							"<user role='部長' org='SI事業部' userid=''/>"+
						"</con>"+
					"</template>" +
					"<template id='0003' title='回覧票'>" +
						"<con status='回覧中'>" +
							"<user role='部長' org='*' userid=''/>"+
						"</con>"+
						"<con status='回覧済'>" +
							"<user role='部長' org='*' userid=''/>"+
						"</con>"+
						"<con status='中止'>" +
							"<user role='部長' org='*' userid=''/>"+
						"</con>"+
					"</template>" +
					"<template id='0004' title='休暇申請'>" +
						"<con status='部長承認'>" +
							"<user role='部長' org='財務総務部' userid=''/>"+
						"</con>"+
						"<con status='総務部長承認'>" +
							"<user role='部長' org='*' userid=''/>"+
						"</con>"+
						"<con status='開通状態'>" +
							"<user role='部長' org='*' userid=''/>"+
							"<user role='部長' org='財務総務部' userid=''/>"+
						"</con>"+
						"<con status='中止'>" +
							"<user role='部長' org='*' userid=''/>"+
							"<user role='部長' org='財務総務部' userid=''/>"+
						"</con>"+
					"</template>" +
					"<template id='0005' title='出張申请'>" +
						"<con status='部長承認'>" +
							"<user role='室長' org='総経理室' userid=''/>"+
						"</con>"+
						"<con status='総経理室長承認'>" +
							"<user role='部長' org='*' userid=''/>"+
						"</con>"+
						"<con status='関連者回覧中'>" +
							"<user role='部長' org='*' userid=''/>"+
							"<user role='室長' org='総経理室' userid=''/>"+
						"</con>"+
						"<con status='総経理承認'>" +
							"<user role='部長' org='*' userid=''/>"+
							"<user role='室長' org='総経理室' userid=''/>"+
						"</con>"+
						"<con status='開通状態'>" +
							"<user role='部長' org='*' userid=''/>"+
							"<user role='室長' org='総経理室' userid=''/>"+
						"</con>"+
						"<con status='中止'>" +
							"<user role='部長' org='*' userid=''/>"+
							"<user role='室長' org='総経理室' userid=''/>"+
						"</con>"+
					"</template>" +
					"<template id='0006' title='残業申请'>" +
						"<con status='部長承認'>" +
							"<user role='室長' org='総経理室' userid=''/>"+
						"</con>"+
						"<con status='総経理室長承認'>" +
							"<user role='部長' org='*' userid=''/>"+
						"</con>"+
						"<con status='関連者回覧中'>" +
							"<user role='部長' org='*' userid=''/>"+
							"<user role='室長' org='総経理室' userid=''/>"+
						"</con>"+
						"<con status='総経理承認'>" +
							"<user role='部長' org='*' userid=''/>"+
							"<user role='室長' org='総経理室' userid=''/>"+
						"</con>"+
						"<con status='開通状態'>" +
							"<user role='部長' org='*' userid=''/>"+
							"<user role='室長' org='総経理室' userid=''/>"+
						"</con>"+
						"<con status='中止'>" +
							"<user role='部長' org='*' userid=''/>"+
							"<user role='室長' org='総経理室' userid=''/>"+
						"</con>"+
					"</template>" +
				"</部品>"
				);
      int _jspx_eval_FlowBuilder_partJobList_0 = _jspx_th_FlowBuilder_partJobList_0.doStartTag();
      if (_jspx_th_FlowBuilder_partJobList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partJobList_userRole_userId_partXml_pageInfo_orgId_nobody.reuse(_jspx_th_FlowBuilder_partJobList_0);
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr bgcolor='#ffffff'>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<table width=100px align=right border=0 cellpadding=1 cellspacing=1>\r\n");
      out.write("\t\t\t\t\t<tr height=15px></tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td width=25px>\r\n");
      out.write("\t\t\t\t\t\t\t");
      //  html:link
      org.apache.struts.taglib.html.LinkTag _jspx_th_html_link_0 = (org.apache.struts.taglib.html.LinkTag) _jspx_tagPool_html_link_page.get(org.apache.struts.taglib.html.LinkTag.class);
      _jspx_th_html_link_0.setPageContext(_jspx_page_context);
      _jspx_th_html_link_0.setParent(null);
      _jspx_th_html_link_0.setPage("/do/flowbuilder/JobList?method=showFirst");
      int _jspx_eval_html_link_0 = _jspx_th_html_link_0.doStartTag();
      if (_jspx_eval_html_link_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_html_link_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_html_link_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_html_link_0.doInitBody();
        }
        do {
          out.write(" <img src='/FlowBuilder/images/arrow_left.gif' alt='firt'> ");
          int evalDoAfterBody = _jspx_th_html_link_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_html_link_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
      }
      if (_jspx_th_html_link_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_html_link_page.reuse(_jspx_th_html_link_0);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td width=25px>\r\n");
      out.write("\t\t\t\t\t\t\t");
      //  html:link
      org.apache.struts.taglib.html.LinkTag _jspx_th_html_link_1 = (org.apache.struts.taglib.html.LinkTag) _jspx_tagPool_html_link_page.get(org.apache.struts.taglib.html.LinkTag.class);
      _jspx_th_html_link_1.setPageContext(_jspx_page_context);
      _jspx_th_html_link_1.setParent(null);
      _jspx_th_html_link_1.setPage("/do/flowbuilder/JobList?method=showPrivious");
      int _jspx_eval_html_link_1 = _jspx_th_html_link_1.doStartTag();
      if (_jspx_eval_html_link_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_html_link_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_html_link_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_html_link_1.doInitBody();
        }
        do {
          out.write(" <img src='/FlowBuilder/images/previous.gif' alt='previous'> ");
          int evalDoAfterBody = _jspx_th_html_link_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_html_link_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
      }
      if (_jspx_th_html_link_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_html_link_page.reuse(_jspx_th_html_link_1);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t");
      if (_jspx_meth_bean_write_0(_jspx_page_context))
        return;
      out.write('/');
      if (_jspx_meth_bean_write_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td width=25px>\r\n");
      out.write("\t\t\t\t\t\t\t");
      //  html:link
      org.apache.struts.taglib.html.LinkTag _jspx_th_html_link_2 = (org.apache.struts.taglib.html.LinkTag) _jspx_tagPool_html_link_page.get(org.apache.struts.taglib.html.LinkTag.class);
      _jspx_th_html_link_2.setPageContext(_jspx_page_context);
      _jspx_th_html_link_2.setParent(null);
      _jspx_th_html_link_2.setPage("/do/flowbuilder/JobList?method=showNext");
      int _jspx_eval_html_link_2 = _jspx_th_html_link_2.doStartTag();
      if (_jspx_eval_html_link_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_html_link_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_html_link_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_html_link_2.doInitBody();
        }
        do {
          out.write(" <img src='/FlowBuilder/images/next.gif' alt='next'> ");
          int evalDoAfterBody = _jspx_th_html_link_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_html_link_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
      }
      if (_jspx_th_html_link_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_html_link_page.reuse(_jspx_th_html_link_2);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td width=25px>\r\n");
      out.write("\t\t\t\t\t\t\t");
      //  html:link
      org.apache.struts.taglib.html.LinkTag _jspx_th_html_link_3 = (org.apache.struts.taglib.html.LinkTag) _jspx_tagPool_html_link_page.get(org.apache.struts.taglib.html.LinkTag.class);
      _jspx_th_html_link_3.setPageContext(_jspx_page_context);
      _jspx_th_html_link_3.setParent(null);
      _jspx_th_html_link_3.setPage("/do/flowbuilder/JobList?method=showLast");
      int _jspx_eval_html_link_3 = _jspx_th_html_link_3.doStartTag();
      if (_jspx_eval_html_link_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_html_link_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_html_link_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_html_link_3.doInitBody();
        }
        do {
          out.write(" <img src='/FlowBuilder/images/arrow_right.gif' alt='last'> ");
          int evalDoAfterBody = _jspx_th_html_link_3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_html_link_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
      }
      if (_jspx_th_html_link_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_html_link_page.reuse(_jspx_th_html_link_3);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\r\n");
      out.write("<!-- ポスト用フォーム -->\r\n");
      out.write("\t<form name=\"JobMakeForm\" action=\"JobShow?method=open\" method=\"post\" accept=\"utf-8\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"userId\" value=\"");
      out.print(userId);
      out.write("\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"orgId\" value=\"");
      out.print(orgId);
      out.write("\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"jobfile\" >\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"jobId\" >\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"templateId\" >\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"view\" >\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"act\" >\r\n");
      out.write("\t\t\r\n");
      out.write("\t");
      if (_jspx_meth_html_hidden_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t");
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_4 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_scope_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_4.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_4.setParent(null);
      _jspx_th_bean_define_4.setId("sessionNo");
      _jspx_th_bean_define_4.setName("sessionNo");
      _jspx_th_bean_define_4.setScope("request");
      int _jspx_eval_bean_define_4 = _jspx_th_bean_define_4.doStartTag();
      if (_jspx_th_bean_define_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_scope_name_id_nobody.reuse(_jspx_th_bean_define_4);
      java.lang.Object sessionNo = null;
      sessionNo = (java.lang.Object) _jspx_page_context.findAttribute("sessionNo");
      out.write("\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"fromlist\" value=\"");
      out.print(sessionNo);
      out.write("\">\r\n");
      out.write("\t</form>\t\r\n");
      out.write("\t<p>&nbsp;</p>\r\n");
      out.write("\t\t<h6 align=\"left\"></h6><p><br />\r\n");
      out.write("\t\t</p>\r\n");
      out.write("\t\t<p><br />\r\n");
      out.write("\t\t</p>\r\n");
      out.write("<BR>\r\n");
      out.write("<BR>\r\n");
      out.write("<BR>\r\n");
      out.write("<BR>\r\n");
      out.write("<BR>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"clearbottom\">&nbsp;</div>\r\n");
      out.write("<div id=\"footer\">\r\n");
      out.write("<div id=\"copyright\">Copyright © 2007 華夏計算機技術有限公司</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_bean_write_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_0 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_0.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_0.setParent(null);
    _jspx_th_bean_write_0.setName("pInfo");
    _jspx_th_bean_write_0.setProperty("currentPage");
    int _jspx_eval_bean_write_0 = _jspx_th_bean_write_0.doStartTag();
    if (_jspx_th_bean_write_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_nobody.reuse(_jspx_th_bean_write_0);
    return false;
  }

  private boolean _jspx_meth_bean_write_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_1 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_1.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_1.setParent(null);
    _jspx_th_bean_write_1.setName("pInfo");
    _jspx_th_bean_write_1.setProperty("pageCountNumber");
    int _jspx_eval_bean_write_1 = _jspx_th_bean_write_1.doStartTag();
    if (_jspx_th_bean_write_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_nobody.reuse(_jspx_th_bean_write_1);
    return false;
  }

  private boolean _jspx_meth_html_hidden_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_0 = (org.apache.struts.taglib.html.HiddenTag) _jspx_tagPool_html_hidden_value_property_nobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_hidden_0.setPageContext(_jspx_page_context);
    _jspx_th_html_hidden_0.setParent(null);
    _jspx_th_html_hidden_0.setProperty("method");
    _jspx_th_html_hidden_0.setValue("error");
    int _jspx_eval_html_hidden_0 = _jspx_th_html_hidden_0.doStartTag();
    if (_jspx_th_html_hidden_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_hidden_value_property_nobody.reuse(_jspx_th_html_hidden_0);
    return false;
  }
}
