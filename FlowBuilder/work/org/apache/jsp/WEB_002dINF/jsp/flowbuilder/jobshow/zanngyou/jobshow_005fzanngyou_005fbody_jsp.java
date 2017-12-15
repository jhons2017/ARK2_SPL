package org.apache.jsp.WEB_002dINF.jsp.flowbuilder.jobshow.zanngyou;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public final class jobshow_005fzanngyou_005fbody_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(3);
    _jspx_dependants.add("/WEB-INF/FlowBuilder.tld");
    _jspx_dependants.add("/WEB-INF/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/struts-bean.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_define_type_scope_property_name_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_write_property_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_FlowBuilder_partOperator_userId_partXml_orgId_job_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_FlowBuilder_partImage_userId_partXml_job_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_FlowBuilder_partJobName_userId_partXml_orgId_job_check_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_FlowBuilder_partInput_userId_partXml_orgId_job_check_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_FlowBuilder_partRadioBox_userId_partXml_orgId_job_check_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_FlowBuilder_partSelectDate_userId_partXml_orgId_job_check_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_FlowBuilder_partTextArea_userId_partXml_orgId_job_check_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_FlowBuilder_partDate_userId_partXml_orgId_job_check_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_FlowBuilder_partUpload_userId_partXml_orgId_job_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_FlowBuilder_partPrint_userId_partXml_orgId_job_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_FlowBuilder_partConfirmRoute_job_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_bean_define_scope_name_id_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_bean_define_type_scope_property_name_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_write_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_FlowBuilder_partOperator_userId_partXml_orgId_job_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_FlowBuilder_partImage_userId_partXml_job_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_FlowBuilder_partJobName_userId_partXml_orgId_job_check_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_FlowBuilder_partInput_userId_partXml_orgId_job_check_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_FlowBuilder_partRadioBox_userId_partXml_orgId_job_check_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_FlowBuilder_partSelectDate_userId_partXml_orgId_job_check_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_FlowBuilder_partTextArea_userId_partXml_orgId_job_check_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_FlowBuilder_partDate_userId_partXml_orgId_job_check_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_FlowBuilder_partUpload_userId_partXml_orgId_job_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_FlowBuilder_partPrint_userId_partXml_orgId_job_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_FlowBuilder_partConfirmRoute_job_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_define_scope_name_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_bean_define_type_scope_property_name_id_nobody.release();
    _jspx_tagPool_bean_write_property_name_nobody.release();
    _jspx_tagPool_FlowBuilder_partOperator_userId_partXml_orgId_job_nobody.release();
    _jspx_tagPool_FlowBuilder_partImage_userId_partXml_job_nobody.release();
    _jspx_tagPool_FlowBuilder_partJobName_userId_partXml_orgId_job_check_nobody.release();
    _jspx_tagPool_FlowBuilder_partInput_userId_partXml_orgId_job_check_nobody.release();
    _jspx_tagPool_FlowBuilder_partRadioBox_userId_partXml_orgId_job_check_nobody.release();
    _jspx_tagPool_FlowBuilder_partSelectDate_userId_partXml_orgId_job_check_nobody.release();
    _jspx_tagPool_FlowBuilder_partTextArea_userId_partXml_orgId_job_check_nobody.release();
    _jspx_tagPool_FlowBuilder_partDate_userId_partXml_orgId_job_check_nobody.release();
    _jspx_tagPool_FlowBuilder_partUpload_userId_partXml_orgId_job_nobody.release();
    _jspx_tagPool_FlowBuilder_partPrint_userId_partXml_orgId_job_nobody.release();
    _jspx_tagPool_FlowBuilder_partConfirmRoute_job_nobody.release();
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>ドキュメントXML管理システム</title>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<meta http-equiv=\"expires\" content=\"0\">\r\n");
      out.write("</head>\r\n");
      out.write("<SCRIPT type=\"text/javascript\" src=\"/FlowBuilder/scripts/flowbuilder.js\"></SCRIPT>\r\n");
      out.write("\r\n");
      out.write("<BODY BGCOLOR=\"#FFFFFF\" LEFTMARGIN=\"0\" TOPMARGIN=\"0\" MARGINWIDTH=\"0\" MARGINHEIGHT=\"0\">\r\n");
      out.write("\t<div id=\"container\">\r\n");
      out.write("\t<div id=\"content\">\r\n");
      out.write("\t");
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_0 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_scope_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_0.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_0.setParent(null);
      _jspx_th_bean_define_0.setId("orgId");
      _jspx_th_bean_define_0.setName("user");
      _jspx_th_bean_define_0.setProperty("orgId");
      _jspx_th_bean_define_0.setType("java.lang.String");
      _jspx_th_bean_define_0.setScope("session");
      int _jspx_eval_bean_define_0 = _jspx_th_bean_define_0.doStartTag();
      if (_jspx_th_bean_define_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_scope_property_name_id_nobody.reuse(_jspx_th_bean_define_0);
      java.lang.String orgId = null;
      orgId = (java.lang.String) _jspx_page_context.findAttribute("orgId");
      out.write('\r');
      out.write('\n');
      out.write('	');
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
      out.write('\r');
      out.write('\n');
      out.write('	');
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_2 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_scope_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_2.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_2.setParent(null);
      _jspx_th_bean_define_2.setId("jobId");
      _jspx_th_bean_define_2.setName("JobShow");
      _jspx_th_bean_define_2.setProperty("jobId");
      _jspx_th_bean_define_2.setType("java.lang.String");
      _jspx_th_bean_define_2.setScope("request");
      int _jspx_eval_bean_define_2 = _jspx_th_bean_define_2.doStartTag();
      if (_jspx_th_bean_define_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_scope_property_name_id_nobody.reuse(_jspx_th_bean_define_2);
      java.lang.String jobId = null;
      jobId = (java.lang.String) _jspx_page_context.findAttribute("jobId");
      out.write('\r');
      out.write('\n');
      out.write('	');
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_3 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_scope_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_3.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_3.setParent(null);
      _jspx_th_bean_define_3.setId("templateId");
      _jspx_th_bean_define_3.setName("JobShow");
      _jspx_th_bean_define_3.setProperty("templateId");
      _jspx_th_bean_define_3.setType("java.lang.String");
      _jspx_th_bean_define_3.setScope("request");
      int _jspx_eval_bean_define_3 = _jspx_th_bean_define_3.doStartTag();
      if (_jspx_th_bean_define_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_scope_property_name_id_nobody.reuse(_jspx_th_bean_define_3);
      java.lang.String templateId = null;
      templateId = (java.lang.String) _jspx_page_context.findAttribute("templateId");
      out.write('\r');
      out.write('\n');
      out.write('	');
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_4 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_scope_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_4.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_4.setParent(null);
      _jspx_th_bean_define_4.setId("view");
      _jspx_th_bean_define_4.setName("JobShow");
      _jspx_th_bean_define_4.setProperty("view");
      _jspx_th_bean_define_4.setType("java.lang.String");
      _jspx_th_bean_define_4.setScope("request");
      int _jspx_eval_bean_define_4 = _jspx_th_bean_define_4.doStartTag();
      if (_jspx_th_bean_define_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_scope_property_name_id_nobody.reuse(_jspx_th_bean_define_4);
      java.lang.String view = null;
      view = (java.lang.String) _jspx_page_context.findAttribute("view");
      out.write('\r');
      out.write('\n');
      out.write('	');
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_5 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_scope_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_5.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_5.setParent(null);
      _jspx_th_bean_define_5.setId("jobFileName");
      _jspx_th_bean_define_5.setName("JobShow");
      _jspx_th_bean_define_5.setProperty("jobFileName");
      _jspx_th_bean_define_5.setType("java.lang.String");
      _jspx_th_bean_define_5.setScope("request");
      int _jspx_eval_bean_define_5 = _jspx_th_bean_define_5.doStartTag();
      if (_jspx_th_bean_define_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_scope_property_name_id_nobody.reuse(_jspx_th_bean_define_5);
      java.lang.String jobFileName = null;
      jobFileName = (java.lang.String) _jspx_page_context.findAttribute("jobFileName");
      out.write('\r');
      out.write('\n');
      out.write('	');
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_6 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_scope_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_6.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_6.setParent(null);
      _jspx_th_bean_define_6.setId("job");
      _jspx_th_bean_define_6.setName("JobShow");
      _jspx_th_bean_define_6.setProperty("job");
      _jspx_th_bean_define_6.setType("org.w3c.dom.Document");
      _jspx_th_bean_define_6.setScope("request");
      int _jspx_eval_bean_define_6 = _jspx_th_bean_define_6.doStartTag();
      if (_jspx_th_bean_define_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_scope_property_name_id_nobody.reuse(_jspx_th_bean_define_6);
      org.w3c.dom.Document job = null;
      job = (org.w3c.dom.Document) _jspx_page_context.findAttribute("job");
      out.write('\r');
      out.write('\n');
      out.write('	');
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_7 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_type_scope_property_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_7.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_7.setParent(null);
      _jspx_th_bean_define_7.setId("userIp");
      _jspx_th_bean_define_7.setName("JobShow");
      _jspx_th_bean_define_7.setProperty("userIp");
      _jspx_th_bean_define_7.setType("java.lang.String");
      _jspx_th_bean_define_7.setScope("request");
      int _jspx_eval_bean_define_7 = _jspx_th_bean_define_7.doStartTag();
      if (_jspx_th_bean_define_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_type_scope_property_name_id_nobody.reuse(_jspx_th_bean_define_7);
      java.lang.String userIp = null;
      userIp = (java.lang.String) _jspx_page_context.findAttribute("userIp");
      out.write("\r\n");
      out.write("\t<div id=\"content\">\r\n");
      out.write("\t<table width=\"60%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t<tr> \r\n");
      out.write("\t\t\t<td></td>\r\n");
      out.write("\t\t\t<td width=\"400\" align=\"left\" valign=\"middle\" nowrap><img src=\"/FlowBuilder/images/zanngyouTrip.gif\"></img></td>\r\n");
      out.write("\t\t\t<td width=\"120\" nowrap>起案人：");
      if (_jspx_meth_bean_write_0(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("\t\t\t<td width=\"130\" nowrap>社員番号：");
      if (_jspx_meth_bean_write_1(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("\t\t\t<td width=\"160\" nowrap>IP：");
      if (_jspx_meth_bean_write_2(_jspx_page_context))
        return;
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<table bgcolor=\"#AABBDD\" align=\"center\" width=\"740\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t<tr bgcolor=\"#FFFFFF\"> \r\n");
      out.write("\t\t\t<td height=30 align=\"right\">\r\n");
      out.write("\t\t\t<!--動作制御部品-->\r\n");
      out.write("\t\t\t\t");
      //  FlowBuilder:partOperator
      flowbuilder.presentation.webcmn.taglibs.PartOperator _jspx_th_FlowBuilder_partOperator_0 = (flowbuilder.presentation.webcmn.taglibs.PartOperator) _jspx_tagPool_FlowBuilder_partOperator_userId_partXml_orgId_job_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartOperator.class);
      _jspx_th_FlowBuilder_partOperator_0.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partOperator_0.setParent(null);
      _jspx_th_FlowBuilder_partOperator_0.setJob(job);
      _jspx_th_FlowBuilder_partOperator_0.setOrgId(orgId);
      _jspx_th_FlowBuilder_partOperator_0.setUserId(userId);
      _jspx_th_FlowBuilder_partOperator_0.setPartXml(
			"<部品>" +
				"<step name='案件起案'>" +
					"<opr id='start' user='案件作成:作成者' role='' org='' vital_check='1'/>" +
					"<opr id='save' user='案件作成:作成者' role='' org='' vital_check='0'/>" +
					"<opr id='disposal' user='案件作成:作成者' role='' org='' vital_check='0'/>" +
				"</step>" +
				"<step name='部長承認'>" +
					"<opr id='returnSelf' user='案件作成:作成者' role=''  org='' vital_check='0'/>" +
					"<opr id='confirm' user='' role='部長'  org='*' vital_check='1'/>" +
					"<opr id='return' user='' role='部長'  org='*' vital_check='1'/>" +
				"</step>" +
				"<step name='総経理室長承認'>" +
					"<opr id='confirm' user='' role='室長'  org='' vital_check='1'/>" +
					"<opr id='save' user='' role='室長' org='' vital_check='1'/>" +
					"<opr id='return' user='' role='室長'  org='' vital_check='1'/>" +
				"</step>" +
				"<step name='総経理承認'>" +
					"<opr id='confirm' user='' role='総経理'  org='' vital_check='1'/>" +
					"<opr id='return' user='' role='総経理'  org='' vital_check='1'/>" +
				"</step>" +
				"<step name='開通状態'>" +
					"<opr id='confirm' user='総経理室長承認:承認者' role=''  org='' vital_check='0'/>" +
				"</step>" +
				"<step name='中止状態'>" +
					"<opr id='delete' user='' role='システム管理者'  org='' vital_check='0'/>" +
				"</step>" +
			"</部品>"
				);
      int _jspx_eval_FlowBuilder_partOperator_0 = _jspx_th_FlowBuilder_partOperator_0.doStartTag();
      if (_jspx_th_FlowBuilder_partOperator_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partOperator_userId_partXml_orgId_job_nobody.reuse(_jspx_th_FlowBuilder_partOperator_0);
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr bgcolor=\"#FFFFFF\"> \r\n");
      out.write("\t\t\t<td height=30 align=\"right\">\r\n");
      out.write("\t\t\t\t<table bgcolor=\"#999999\" align=center border=0 cellpadding=1 cellspacing=1 width=\"740\">\r\n");
      out.write("\t\t\t\t\t<form name=\"JobDetailForm\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t\t\t\t<tr bgcolor=\"#efefef\" align=\"center\" valign=\"middle\"> \r\n");
      out.write("\t\t\t\t\t\t<td height=30 colspan=2 >案　件　内　容</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td>起案者イメージ</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25 >\r\n");
      out.write("\t\t\t\t\t\t<!--影像部品-->\r\n");
      out.write("\t\t\t\t\t\t");
      //  FlowBuilder:partImage
      flowbuilder.presentation.webcmn.taglibs.PartImage _jspx_th_FlowBuilder_partImage_0 = (flowbuilder.presentation.webcmn.taglibs.PartImage) _jspx_tagPool_FlowBuilder_partImage_userId_partXml_job_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartImage.class);
      _jspx_th_FlowBuilder_partImage_0.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partImage_0.setParent(null);
      _jspx_th_FlowBuilder_partImage_0.setJob(job);
      _jspx_th_FlowBuilder_partImage_0.setUserId(userId);
      _jspx_th_FlowBuilder_partImage_0.setPartXml(
						"<部品>" +
							"<option path='/FlowBuilder/images/userImages/' height='70' width='70'/>" +
						"</部品>"
							);
      int _jspx_eval_FlowBuilder_partImage_0 = _jspx_th_FlowBuilder_partImage_0.doStartTag();
      if (_jspx_th_FlowBuilder_partImage_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partImage_userId_partXml_job_nobody.reuse(_jspx_th_FlowBuilder_partImage_0);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td height=25 width=150  nowrap>案　件　名</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25 width=400 >\r\n");
      out.write("\t\t\t\t\t\t\t<!--案件名部品-->\r\n");
      out.write("\t\t\t\t\t\t\t");
      //  FlowBuilder:partJobName
      flowbuilder.presentation.webcmn.taglibs.PartJobName _jspx_th_FlowBuilder_partJobName_0 = (flowbuilder.presentation.webcmn.taglibs.PartJobName) _jspx_tagPool_FlowBuilder_partJobName_userId_partXml_orgId_job_check_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartJobName.class);
      _jspx_th_FlowBuilder_partJobName_0.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partJobName_0.setParent(null);
      _jspx_th_FlowBuilder_partJobName_0.setJob(job);
      _jspx_th_FlowBuilder_partJobName_0.setOrgId(orgId);
      _jspx_th_FlowBuilder_partJobName_0.setUserId(userId);
      _jspx_th_FlowBuilder_partJobName_0.setPartXml(
							"<部品>" +
								"<タグ name='fb_jobname' style='HEIGHT: 22px; WIDTH: 300px' />" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"</部品>"
								);
      _jspx_th_FlowBuilder_partJobName_0.setCheck(
									"<Checks partName='案　件　名'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateLength' htmlId='fb_jobname' min='1' max='100'/>" +
											"<CheckItem type='ValidateNull' htmlId='fb_jobname'/>" +
										"</Condition>" +
									"</Checks>");
      int _jspx_eval_FlowBuilder_partJobName_0 = _jspx_th_FlowBuilder_partJobName_0.doStartTag();
      if (_jspx_th_FlowBuilder_partJobName_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partJobName_userId_partXml_orgId_job_check_nobody.reuse(_jspx_th_FlowBuilder_partJobName_0);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td  nowrap>申請者所属</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25 >\r\n");
      out.write("\t\t\t\t\t\t\t<!--入力部品-->\r\n");
      out.write("\t\t\t\t\t\t\t");
      //  FlowBuilder:partInput
      flowbuilder.presentation.webcmn.taglibs.PartInput _jspx_th_FlowBuilder_partInput_0 = (flowbuilder.presentation.webcmn.taglibs.PartInput) _jspx_tagPool_FlowBuilder_partInput_userId_partXml_orgId_job_check_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartInput.class);
      _jspx_th_FlowBuilder_partInput_0.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partInput_0.setParent(null);
      _jspx_th_FlowBuilder_partInput_0.setJob(job);
      _jspx_th_FlowBuilder_partInput_0.setOrgId(orgId);
      _jspx_th_FlowBuilder_partInput_0.setUserId(userId);
      _jspx_th_FlowBuilder_partInput_0.setPartXml(
							"<部品>" +
								"<タグ name='department' style='HEIGHT: 22px; WIDTH: 300px' />" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"</部品>"
								);
      _jspx_th_FlowBuilder_partInput_0.setCheck(
									"<Checks partName='申請者所属'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='department'/>" +
											"<CheckItem type='ValidateLength' htmlId='department' min='1' max='30'/>" +
										"</Condition>" +
									"</Checks>");
      int _jspx_eval_FlowBuilder_partInput_0 = _jspx_th_FlowBuilder_partInput_0.doStartTag();
      if (_jspx_th_FlowBuilder_partInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partInput_userId_partXml_orgId_job_check_nobody.reuse(_jspx_th_FlowBuilder_partInput_0);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td nowrap>残業項目</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25 >\r\n");
      out.write("\t\t\t\t\t\t\t<!--入力部品-->\r\n");
      out.write("\t\t\t\t\t\t\t");
      //  FlowBuilder:partInput
      flowbuilder.presentation.webcmn.taglibs.PartInput _jspx_th_FlowBuilder_partInput_1 = (flowbuilder.presentation.webcmn.taglibs.PartInput) _jspx_tagPool_FlowBuilder_partInput_userId_partXml_orgId_job_check_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartInput.class);
      _jspx_th_FlowBuilder_partInput_1.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partInput_1.setParent(null);
      _jspx_th_FlowBuilder_partInput_1.setJob(job);
      _jspx_th_FlowBuilder_partInput_1.setOrgId(orgId);
      _jspx_th_FlowBuilder_partInput_1.setUserId(userId);
      _jspx_th_FlowBuilder_partInput_1.setPartXml(
							"<部品>" +
								"<タグ name='objectAdress' style='HEIGHT: 22px; WIDTH: 300px' />" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"</部品>"
								);
      _jspx_th_FlowBuilder_partInput_1.setCheck( 
									"<Checks partName='残業項目'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='objectAdress'/>" +
											"<CheckItem type='ValidateLength' htmlId='objectAdress' min='1' max='30'/>" +
										"</Condition>" +
									"</Checks>");
      int _jspx_eval_FlowBuilder_partInput_1 = _jspx_th_FlowBuilder_partInput_1.doStartTag();
      if (_jspx_th_FlowBuilder_partInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partInput_userId_partXml_orgId_job_check_nobody.reuse(_jspx_th_FlowBuilder_partInput_1);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td nowrap>交通手段</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25>\r\n");
      out.write("\t\t\t\t\t\t\t<!--RADIOBOX選択部品-->\r\n");
      out.write("\t\t\t\t\t\t\t");
      //  FlowBuilder:partRadioBox
      flowbuilder.presentation.webcmn.taglibs.PartRadioBox _jspx_th_FlowBuilder_partRadioBox_0 = (flowbuilder.presentation.webcmn.taglibs.PartRadioBox) _jspx_tagPool_FlowBuilder_partRadioBox_userId_partXml_orgId_job_check_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartRadioBox.class);
      _jspx_th_FlowBuilder_partRadioBox_0.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partRadioBox_0.setParent(null);
      _jspx_th_FlowBuilder_partRadioBox_0.setJob(job);
      _jspx_th_FlowBuilder_partRadioBox_0.setOrgId(orgId);
      _jspx_th_FlowBuilder_partRadioBox_0.setUserId(userId);
      _jspx_th_FlowBuilder_partRadioBox_0.setPartXml(
							"<部品>" +
								"<タグ name='trafficTool' style='HEIGHT: 22px; WIDTH: 40px'/>" +
								"<非表示 user='' role=''/>" +
								"<表示 user='部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role=''/>" +
								"<content name='飛行機,タクシー,車,電車,船,その他' defalut='飛行機'/>" +
							"</部品>"
								);
      _jspx_th_FlowBuilder_partRadioBox_0.setCheck(
									"<Checks partName='交通手段'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateRadioNull' htmlId='trafficTool'/>" +
										"</Condition>" +
									"</Checks>");
      int _jspx_eval_FlowBuilder_partRadioBox_0 = _jspx_th_FlowBuilder_partRadioBox_0.doStartTag();
      if (_jspx_th_FlowBuilder_partRadioBox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partRadioBox_userId_partXml_orgId_job_check_nobody.reuse(_jspx_th_FlowBuilder_partRadioBox_0);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td height=25 width=150  nowrap>残業時間</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25 width=400 >\r\n");
      out.write("\t\t\t\t\t\t<!--COMBOX選択部品-->\r\n");
      out.write("\t\t\t\t\t\t");
      //  FlowBuilder:partSelectDate
      flowbuilder.presentation.webcmn.taglibs.PartSelectDate _jspx_th_FlowBuilder_partSelectDate_0 = (flowbuilder.presentation.webcmn.taglibs.PartSelectDate) _jspx_tagPool_FlowBuilder_partSelectDate_userId_partXml_orgId_job_check_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartSelectDate.class);
      _jspx_th_FlowBuilder_partSelectDate_0.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partSelectDate_0.setParent(null);
      _jspx_th_FlowBuilder_partSelectDate_0.setJob(job);
      _jspx_th_FlowBuilder_partSelectDate_0.setOrgId(orgId);
      _jspx_th_FlowBuilder_partSelectDate_0.setUserId(userId);
      _jspx_th_FlowBuilder_partSelectDate_0.setPartXml(
					"<部品>" +
						"<タグ name='startdate/enddate' value='開始日/結束日' calendar='1/1' style='HEIGHT: 22px; WIDTH: 120px' />" +
						"<非表示 user='' role='' org=''/>" +
						"<表示 user='部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
						"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
						"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
					"</部品>"
						);
      _jspx_th_FlowBuilder_partSelectDate_0.setCheck( 
						"<Checks partName='残業時間'>" +
							"<Condition value='案件起案'>" +
								"<CheckItem type='ValidateNull' htmlId='startdate'/>" +
								"<CheckItem type='ValidateNull' htmlId='enddate'/>" +
								"<CheckItem type='ValidateDateFromTo' startTime='startdate' endTime='enddate'/>" + 
							"</Condition>" +
							"</Checks>");
      int _jspx_eval_FlowBuilder_partSelectDate_0 = _jspx_th_FlowBuilder_partSelectDate_0.doStartTag();
      if (_jspx_th_FlowBuilder_partSelectDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partSelectDate_userId_partXml_orgId_job_check_nobody.reuse(_jspx_th_FlowBuilder_partSelectDate_0);
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td nowrap>残業管理責任者</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25 >\r\n");
      out.write("\t\t\t\t\t\t\t<!--入力部品-->\r\n");
      out.write("\t\t\t\t\t\t\t");
      //  FlowBuilder:partInput
      flowbuilder.presentation.webcmn.taglibs.PartInput _jspx_th_FlowBuilder_partInput_2 = (flowbuilder.presentation.webcmn.taglibs.PartInput) _jspx_tagPool_FlowBuilder_partInput_userId_partXml_orgId_job_check_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartInput.class);
      _jspx_th_FlowBuilder_partInput_2.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partInput_2.setParent(null);
      _jspx_th_FlowBuilder_partInput_2.setJob(job);
      _jspx_th_FlowBuilder_partInput_2.setOrgId(orgId);
      _jspx_th_FlowBuilder_partInput_2.setUserId(userId);
      _jspx_th_FlowBuilder_partInput_2.setPartXml(
							"<部品>" +
								"<タグ name='dutyer' style='HEIGHT: 22px; WIDTH: 300px' />" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"</部品>"
								);
      _jspx_th_FlowBuilder_partInput_2.setCheck( 
									"<Checks partName='残業管理責任者'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='dutyer'/>" +
											"<CheckItem type='ValidateLength' htmlId='dutyer' min='1' max='10'/>" +
										"</Condition>" +
									"</Checks>");
      int _jspx_eval_FlowBuilder_partInput_2 = _jspx_th_FlowBuilder_partInput_2.doStartTag();
      if (_jspx_th_FlowBuilder_partInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partInput_userId_partXml_orgId_job_check_nobody.reuse(_jspx_th_FlowBuilder_partInput_2);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td nowrap>責任者の連絡方法</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25 >\r\n");
      out.write("\t\t\t\t\t\t\t<!--入力部品-->\r\n");
      out.write("\t\t\t\t\t\t\t");
      //  FlowBuilder:partInput
      flowbuilder.presentation.webcmn.taglibs.PartInput _jspx_th_FlowBuilder_partInput_3 = (flowbuilder.presentation.webcmn.taglibs.PartInput) _jspx_tagPool_FlowBuilder_partInput_userId_partXml_orgId_job_check_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartInput.class);
      _jspx_th_FlowBuilder_partInput_3.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partInput_3.setParent(null);
      _jspx_th_FlowBuilder_partInput_3.setJob(job);
      _jspx_th_FlowBuilder_partInput_3.setOrgId(orgId);
      _jspx_th_FlowBuilder_partInput_3.setUserId(userId);
      _jspx_th_FlowBuilder_partInput_3.setPartXml(
							"<部品>" +
								"<タグ name='contract' style='HEIGHT: 22px; WIDTH: 300px' />" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"</部品>"
								);
      _jspx_th_FlowBuilder_partInput_3.setCheck( 
									"<Checks partName='責任者の連絡方法'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='contract'/>" +
											"<CheckItem type='ValidateLength' htmlId='contract' min='1' max='20'/>" +
										"</Condition>" +
									"</Checks>");
      int _jspx_eval_FlowBuilder_partInput_3 = _jspx_th_FlowBuilder_partInput_3.doStartTag();
      if (_jspx_th_FlowBuilder_partInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partInput_userId_partXml_orgId_job_check_nobody.reuse(_jspx_th_FlowBuilder_partInput_3);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td>残業理由</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25 >\r\n");
      out.write("\t\t\t\t\t\t<!--多行の輸入のわく部品-->\r\n");
      out.write("\t\t\t\t\t\t");
      //  FlowBuilder:partTextArea
      flowbuilder.presentation.webcmn.taglibs.PartTextArea _jspx_th_FlowBuilder_partTextArea_0 = (flowbuilder.presentation.webcmn.taglibs.PartTextArea) _jspx_tagPool_FlowBuilder_partTextArea_userId_partXml_orgId_job_check_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartTextArea.class);
      _jspx_th_FlowBuilder_partTextArea_0.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partTextArea_0.setParent(null);
      _jspx_th_FlowBuilder_partTextArea_0.setJob(job);
      _jspx_th_FlowBuilder_partTextArea_0.setOrgId(orgId);
      _jspx_th_FlowBuilder_partTextArea_0.setUserId(userId);
      _jspx_th_FlowBuilder_partTextArea_0.setPartXml(
						"<部品>" +
							"<タグ name='applyReason' style='HEIGHT: 22px; WIDTH: 400px' rows='5' cols='50'/>" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
							"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
						"</部品>"
							);
      _jspx_th_FlowBuilder_partTextArea_0.setCheck( 
									"<Checks partName='残業理由'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='applyReason'/>" +
											"<CheckItem type='ValidateLength' htmlId='applyReason' min='1' max='1000'/>" +
										"</Condition>" +
									"</Checks>");
      int _jspx_eval_FlowBuilder_partTextArea_0 = _jspx_th_FlowBuilder_partTextArea_0.doStartTag();
      if (_jspx_th_FlowBuilder_partTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partTextArea_userId_partXml_orgId_job_check_nobody.reuse(_jspx_th_FlowBuilder_partTextArea_0);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td>作業責任者</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25 >\r\n");
      out.write("\t\t\t\t\t\t<!--入力部品-->\r\n");
      out.write("\t\t\t\t\t\t");
      //  FlowBuilder:partInput
      flowbuilder.presentation.webcmn.taglibs.PartInput _jspx_th_FlowBuilder_partInput_4 = (flowbuilder.presentation.webcmn.taglibs.PartInput) _jspx_tagPool_FlowBuilder_partInput_userId_partXml_orgId_job_check_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartInput.class);
      _jspx_th_FlowBuilder_partInput_4.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partInput_4.setParent(null);
      _jspx_th_FlowBuilder_partInput_4.setJob(job);
      _jspx_th_FlowBuilder_partInput_4.setOrgId(orgId);
      _jspx_th_FlowBuilder_partInput_4.setUserId(userId);
      _jspx_th_FlowBuilder_partInput_4.setPartXml(
						"<部品>" +
							"<タグ name='recommendationer' style='HEIGHT: 22px; WIDTH: 400px' />" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
							"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
						"</部品>"
							);
      _jspx_th_FlowBuilder_partInput_4.setCheck( 
									"<Checks partName='作業責任者'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='recommendationer'/>" +
											"<CheckItem type='ValidateLength' htmlId='recommendationer' min='1' max='10'/>" +
										"</Condition>" +
									"</Checks>");
      int _jspx_eval_FlowBuilder_partInput_4 = _jspx_th_FlowBuilder_partInput_4.doStartTag();
      if (_jspx_th_FlowBuilder_partInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partInput_userId_partXml_orgId_job_check_nobody.reuse(_jspx_th_FlowBuilder_partInput_4);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td>作業日</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25 >\r\n");
      out.write("\t\t\t\t\t\t<!--入力部品-->\r\n");
      out.write("\t\t\t\t\t\t");
      //  FlowBuilder:partDate
      flowbuilder.presentation.webcmn.taglibs.PartDate _jspx_th_FlowBuilder_partDate_0 = (flowbuilder.presentation.webcmn.taglibs.PartDate) _jspx_tagPool_FlowBuilder_partDate_userId_partXml_orgId_job_check_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartDate.class);
      _jspx_th_FlowBuilder_partDate_0.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partDate_0.setParent(null);
      _jspx_th_FlowBuilder_partDate_0.setJob(job);
      _jspx_th_FlowBuilder_partDate_0.setOrgId(orgId);
      _jspx_th_FlowBuilder_partDate_0.setUserId(userId);
      _jspx_th_FlowBuilder_partDate_0.setPartXml(
						"<部品>" +
							"<タグ name='recommendationDate' style='HEIGHT: 22px; WIDTH: 100px' />" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
							"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
						"</部品>"
							);
      _jspx_th_FlowBuilder_partDate_0.setCheck( 
									"<Checks partName='作業日'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='recommendationDate'/>" +
										"</Condition>" +
									"</Checks>");
      int _jspx_eval_FlowBuilder_partDate_0 = _jspx_th_FlowBuilder_partDate_0.doStartTag();
      if (_jspx_th_FlowBuilder_partDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partDate_userId_partXml_orgId_job_check_nobody.reuse(_jspx_th_FlowBuilder_partDate_0);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<!--アップロード部品-->\r\n");
      out.write("\t\t\t\t\t\t");
      //  FlowBuilder:partUpload
      flowbuilder.presentation.webcmn.taglibs.PartUpload _jspx_th_FlowBuilder_partUpload_0 = (flowbuilder.presentation.webcmn.taglibs.PartUpload) _jspx_tagPool_FlowBuilder_partUpload_userId_partXml_orgId_job_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartUpload.class);
      _jspx_th_FlowBuilder_partUpload_0.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partUpload_0.setParent(null);
      _jspx_th_FlowBuilder_partUpload_0.setJob(job);
      _jspx_th_FlowBuilder_partUpload_0.setOrgId(orgId);
      _jspx_th_FlowBuilder_partUpload_0.setUserId(userId);
      _jspx_th_FlowBuilder_partUpload_0.setPartXml(
					"<部品>" +
						"<タグ name='upload' uploadLable='起案者添付資料 ' downLoadLable='起案者添付資料 ' state='案件起案' />" +
						"<非表示 user='' role='' org=''/>" +
						"<表示 user='部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
						"<編集 user='案件起案/案件作成:作成者' role=''/>" +
					"</部品>"
						);
      int _jspx_eval_FlowBuilder_partUpload_0 = _jspx_th_FlowBuilder_partUpload_0.doStartTag();
      if (_jspx_th_FlowBuilder_partUpload_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partUpload_userId_partXml_orgId_job_nobody.reuse(_jspx_th_FlowBuilder_partUpload_0);
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td>部長からのコメント</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25 >\r\n");
      out.write("\t\t\t\t\t\t<!--多行の輸入のわく部品-->\r\n");
      out.write("\t\t\t\t\t\t\t");
      //  FlowBuilder:partTextArea
      flowbuilder.presentation.webcmn.taglibs.PartTextArea _jspx_th_FlowBuilder_partTextArea_1 = (flowbuilder.presentation.webcmn.taglibs.PartTextArea) _jspx_tagPool_FlowBuilder_partTextArea_userId_partXml_orgId_job_check_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartTextArea.class);
      _jspx_th_FlowBuilder_partTextArea_1.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partTextArea_1.setParent(null);
      _jspx_th_FlowBuilder_partTextArea_1.setJob(job);
      _jspx_th_FlowBuilder_partTextArea_1.setOrgId(orgId);
      _jspx_th_FlowBuilder_partTextArea_1.setUserId(userId);
      _jspx_th_FlowBuilder_partTextArea_1.setPartXml(
						"<部品>" +
							"<タグ name='buchouComment'  rows='5' cols='50'/>" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='案件起案/案件作成:作成者,部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
							"<編集 user='' role='部長承認/部長' org='*'/>" +
							"<必須 user='' role='部長承認/部長' org='*'/>" +
						"</部品>"
							);
      _jspx_th_FlowBuilder_partTextArea_1.setCheck( 
									"<Checks partName='部長からのコメント'>" +
										"<Condition value='部長承認'>" +
											"<CheckItem type='ValidateNull' htmlId='buchouComment'/>" +
											"<CheckItem type='ValidateLength' htmlId='buchouComment' min='1' max='1000'/>" +
										"</Condition>" +
									"</Checks>");
      int _jspx_eval_FlowBuilder_partTextArea_1 = _jspx_th_FlowBuilder_partTextArea_1.doStartTag();
      if (_jspx_th_FlowBuilder_partTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partTextArea_userId_partXml_orgId_job_check_nobody.reuse(_jspx_th_FlowBuilder_partTextArea_1);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td>室長からのコメント</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25 >\r\n");
      out.write("\t\t\t\t\t\t<!--多行の輸入のわく部品-->\r\n");
      out.write("\t\t\t\t\t\t\t");
      //  FlowBuilder:partTextArea
      flowbuilder.presentation.webcmn.taglibs.PartTextArea _jspx_th_FlowBuilder_partTextArea_2 = (flowbuilder.presentation.webcmn.taglibs.PartTextArea) _jspx_tagPool_FlowBuilder_partTextArea_userId_partXml_orgId_job_check_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartTextArea.class);
      _jspx_th_FlowBuilder_partTextArea_2.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partTextArea_2.setParent(null);
      _jspx_th_FlowBuilder_partTextArea_2.setJob(job);
      _jspx_th_FlowBuilder_partTextArea_2.setOrgId(orgId);
      _jspx_th_FlowBuilder_partTextArea_2.setUserId(userId);
      _jspx_th_FlowBuilder_partTextArea_2.setPartXml(
							"<部品>" +
								"<タグ name='shiTuChouComment'  rows='5' cols='50'/>" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='案件起案/案件作成:作成者,部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='部長承認/部長|室長,総経理室長承認/部長|室長,関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
								"<編集 user='' role='総経理室長承認/室長' org=''/>" +
								"<必須 user='' role='総経理室長承認/室長' org=''/>" +
							"</部品>"
								);
      _jspx_th_FlowBuilder_partTextArea_2.setCheck( 
									"<Checks partName='室長からのコメント'>" +
										"<Condition value='総経理室長承認'>" +
											"<CheckItem type='ValidateNull' htmlId='shiTuChouComment'/>" +
											"<CheckItem type='ValidateLength' htmlId='shiTuChouComment' min='1' max='1000'/>" +
										"</Condition>" +
									"</Checks>");
      int _jspx_eval_FlowBuilder_partTextArea_2 = _jspx_th_FlowBuilder_partTextArea_2.doStartTag();
      if (_jspx_th_FlowBuilder_partTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partTextArea_userId_partXml_orgId_job_check_nobody.reuse(_jspx_th_FlowBuilder_partTextArea_2);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\t\r\n");
      out.write("\t\t\t\t\t<!--アップロード部品-->\r\n");
      out.write("\t\t\t\t\t");
      //  FlowBuilder:partUpload
      flowbuilder.presentation.webcmn.taglibs.PartUpload _jspx_th_FlowBuilder_partUpload_1 = (flowbuilder.presentation.webcmn.taglibs.PartUpload) _jspx_tagPool_FlowBuilder_partUpload_userId_partXml_orgId_job_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartUpload.class);
      _jspx_th_FlowBuilder_partUpload_1.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partUpload_1.setParent(null);
      _jspx_th_FlowBuilder_partUpload_1.setJob(job);
      _jspx_th_FlowBuilder_partUpload_1.setOrgId(orgId);
      _jspx_th_FlowBuilder_partUpload_1.setUserId(userId);
      _jspx_th_FlowBuilder_partUpload_1.setPartXml(
					"<部品>" +
						"<タグ name='uploadShitucyou' uploadLable='室長資料アップロード' downLoadLable='室長資料ダウンロード' state='総経理室長承認' />" +
						"<表示 user='関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|秘書|社員' org=''/>" +
						"<編集 user='' role='総経理室長承認/室長'/>" +
					"</部品>"
						);
      int _jspx_eval_FlowBuilder_partUpload_1 = _jspx_th_FlowBuilder_partUpload_1.doStartTag();
      if (_jspx_th_FlowBuilder_partUpload_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partUpload_userId_partXml_orgId_job_nobody.reuse(_jspx_th_FlowBuilder_partUpload_1);
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td>総経理からのコメント</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25 >\r\n");
      out.write("\t\t\t\t\t\t<!--多行の輸入のわく部品-->\r\n");
      out.write("\t\t\t\t\t\t");
      //  FlowBuilder:partTextArea
      flowbuilder.presentation.webcmn.taglibs.PartTextArea _jspx_th_FlowBuilder_partTextArea_3 = (flowbuilder.presentation.webcmn.taglibs.PartTextArea) _jspx_tagPool_FlowBuilder_partTextArea_userId_partXml_orgId_job_check_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartTextArea.class);
      _jspx_th_FlowBuilder_partTextArea_3.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partTextArea_3.setParent(null);
      _jspx_th_FlowBuilder_partTextArea_3.setJob(job);
      _jspx_th_FlowBuilder_partTextArea_3.setOrgId(orgId);
      _jspx_th_FlowBuilder_partTextArea_3.setUserId(userId);
      _jspx_th_FlowBuilder_partTextArea_3.setPartXml(
						"<部品>" +
							"<タグ name='ManagerComment'  rows='5' cols='50'/>" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='案件起案/案件作成:作成者,部長承認/案件作成:作成者,総経理室長承認/案件作成:作成者,関連者回覧中/案件作成:作成者,総経理承認/案件作成:作成者,開通状態/案件作成:作成者,中止状態/案件作成:作成者' role='関連者回覧中/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者,総経理承認/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者,開通状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者,中止状態/総経理|室長|事業部長|部長|副部長|部長助理|高級マネージャ|グループ長|主任|マネージャ|社員|システム管理者' org=''/>" +
							"<編集 user='' role='総経理承認/総経理' org=''/>" +
							"<必須 user='' role='総経理承認/総経理' org=''/>" +
						"</部品>"
							);
      _jspx_th_FlowBuilder_partTextArea_3.setCheck( 
								"<Checks partName='総経理からのコメント'>" +
									"<Condition value='総経理承認'>" +
										"<CheckItem type='ValidateNull' htmlId='ManagerComment'/>" +
										"<CheckItem type='ValidateLength' htmlId='ManagerComment' min='1' max='1000'/>" +
									"</Condition>" +
								"</Checks>");
      int _jspx_eval_FlowBuilder_partTextArea_3 = _jspx_th_FlowBuilder_partTextArea_3.doStartTag();
      if (_jspx_th_FlowBuilder_partTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partTextArea_userId_partXml_orgId_job_check_nobody.reuse(_jspx_th_FlowBuilder_partTextArea_3);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t\t<td>印刷</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td height=25 >\r\n");
      out.write("\t\t\t\t\t\t<!--入力部品-->\r\n");
      out.write("\t\t\t\t\t\t\t");
      //  FlowBuilder:partPrint
      flowbuilder.presentation.webcmn.taglibs.PartPrint _jspx_th_FlowBuilder_partPrint_0 = (flowbuilder.presentation.webcmn.taglibs.PartPrint) _jspx_tagPool_FlowBuilder_partPrint_userId_partXml_orgId_job_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartPrint.class);
      _jspx_th_FlowBuilder_partPrint_0.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partPrint_0.setParent(null);
      _jspx_th_FlowBuilder_partPrint_0.setJob(job);
      _jspx_th_FlowBuilder_partPrint_0.setOrgId(orgId);
      _jspx_th_FlowBuilder_partPrint_0.setUserId(userId);
      _jspx_th_FlowBuilder_partPrint_0.setPartXml(
						"<部品>" +
							"<タグ name='print'/>" +
							"<表示 user='開通状態/案件作成:作成者' role='中止状態/社員|部長|システム管理者,開通状態/部長|室長|总经理,総経理承認/総経理' org=''/>" +
						"</部品>"
							);
      int _jspx_eval_FlowBuilder_partPrint_0 = _jspx_th_FlowBuilder_partPrint_0.doStartTag();
      if (_jspx_th_FlowBuilder_partPrint_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partPrint_userId_partXml_orgId_job_nobody.reuse(_jspx_th_FlowBuilder_partPrint_0);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td>経過承認ルート</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25>\r\n");
      out.write("\t\t\t\t\t\t<!--通過承認ルート部品-->\r\n");
      out.write("\t\t\t\t\t\t\t");
      //  FlowBuilder:partConfirmRoute
      flowbuilder.presentation.webcmn.taglibs.PartConfirmRoute _jspx_th_FlowBuilder_partConfirmRoute_0 = (flowbuilder.presentation.webcmn.taglibs.PartConfirmRoute) _jspx_tagPool_FlowBuilder_partConfirmRoute_job_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartConfirmRoute.class);
      _jspx_th_FlowBuilder_partConfirmRoute_0.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partConfirmRoute_0.setParent(null);
      _jspx_th_FlowBuilder_partConfirmRoute_0.setJob(job);
      int _jspx_eval_FlowBuilder_partConfirmRoute_0 = _jspx_th_FlowBuilder_partConfirmRoute_0.doStartTag();
      if (_jspx_th_FlowBuilder_partConfirmRoute_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partConfirmRoute_job_nobody.reuse(_jspx_th_FlowBuilder_partConfirmRoute_0);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"userIp\" value=\"");
      out.print(userIp);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"jobId\" value=\"");
      out.print(jobId);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"userId\" value=\"");
      out.print(userId);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"orgId\" value=\"");
      out.print(orgId);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"templateId\" value=\"");
      out.print(templateId);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"view\" value=\"");
      out.print(view);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"operator\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"act\">\r\n");
      out.write("\t\t\t\t\t");
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_8 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_scope_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_8.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_8.setParent(null);
      _jspx_th_bean_define_8.setId("sessionNo");
      _jspx_th_bean_define_8.setName("sessionNo");
      _jspx_th_bean_define_8.setScope("request");
      int _jspx_eval_bean_define_8 = _jspx_th_bean_define_8.doStartTag();
      if (_jspx_th_bean_define_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_scope_name_id_nobody.reuse(_jspx_th_bean_define_8);
      java.lang.Object sessionNo = null;
      sessionNo = (java.lang.Object) _jspx_page_context.findAttribute("sessionNo");
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"fromview\" value=\"");
      out.print(sessionNo);
      out.write("\">\r\n");
      out.write("\t\t\t\t");
      //  bean:define
      org.apache.struts.taglib.bean.DefineTag _jspx_th_bean_define_9 = (org.apache.struts.taglib.bean.DefineTag) _jspx_tagPool_bean_define_scope_name_id_nobody.get(org.apache.struts.taglib.bean.DefineTag.class);
      _jspx_th_bean_define_9.setPageContext(_jspx_page_context);
      _jspx_th_bean_define_9.setParent(null);
      _jspx_th_bean_define_9.setId("sessionNo");
      _jspx_th_bean_define_9.setName("sessionNo");
      _jspx_th_bean_define_9.setScope("request");
      int _jspx_eval_bean_define_9 = _jspx_th_bean_define_9.doStartTag();
      if (_jspx_th_bean_define_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_bean_define_scope_name_id_nobody.reuse(_jspx_th_bean_define_9);
      sessionNo = (java.lang.Object) _jspx_page_context.findAttribute("sessionNo");
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"fromview\" value=\"");
      out.print(sessionNo);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("  </div>\r\n");
      out.write("<div id=\"clearbottom\">&nbsp;</div>\r\n");
      out.write("<div id=\"footer\">\r\n");
      out.write("<div id=\"copyright\">Copyright © 2007 華夏計算機技術有限公司</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_bean_write_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_0 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_0.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_0.setParent(null);
    _jspx_th_bean_write_0.setName("JobShow");
    _jspx_th_bean_write_0.setProperty("userName");
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
    _jspx_th_bean_write_1.setName("JobShow");
    _jspx_th_bean_write_1.setProperty("userId");
    int _jspx_eval_bean_write_1 = _jspx_th_bean_write_1.doStartTag();
    if (_jspx_th_bean_write_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_nobody.reuse(_jspx_th_bean_write_1);
    return false;
  }

  private boolean _jspx_meth_bean_write_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  bean:write
    org.apache.struts.taglib.bean.WriteTag _jspx_th_bean_write_2 = (org.apache.struts.taglib.bean.WriteTag) _jspx_tagPool_bean_write_property_name_nobody.get(org.apache.struts.taglib.bean.WriteTag.class);
    _jspx_th_bean_write_2.setPageContext(_jspx_page_context);
    _jspx_th_bean_write_2.setParent(null);
    _jspx_th_bean_write_2.setName("JobShow");
    _jspx_th_bean_write_2.setProperty("userIp");
    int _jspx_eval_bean_write_2 = _jspx_th_bean_write_2.doStartTag();
    if (_jspx_th_bean_write_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_bean_write_property_name_nobody.reuse(_jspx_th_bean_write_2);
    return false;
  }
}
