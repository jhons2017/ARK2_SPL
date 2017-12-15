package org.apache.jsp.WEB_002dINF.jsp.flowbuilder.jobshow.security;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public final class jobshow_005fsecurity_005fbody_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_FlowBuilder_partJobName_userId_partXml_orgId_job_check_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_FlowBuilder_partImage_userId_partXml_job_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_FlowBuilder_partInput_userId_partXml_orgId_job_check_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_FlowBuilder_partRadioBox_userId_partXml_orgId_job_check_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_FlowBuilder_partSelectDate_userId_partXml_orgId_job_check_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_FlowBuilder_partEmail_userId_partXml_orgId_job_check_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_FlowBuilder_partCheckBox_userId_partXml_orgId_job_check_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_FlowBuilder_partTextArea_userId_partXml_orgId_job_check_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_FlowBuilder_partSelect_userId_partXml_orgId_job_check_nobody;
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
    _jspx_tagPool_FlowBuilder_partJobName_userId_partXml_orgId_job_check_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_FlowBuilder_partImage_userId_partXml_job_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_FlowBuilder_partInput_userId_partXml_orgId_job_check_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_FlowBuilder_partRadioBox_userId_partXml_orgId_job_check_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_FlowBuilder_partSelectDate_userId_partXml_orgId_job_check_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_FlowBuilder_partEmail_userId_partXml_orgId_job_check_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_FlowBuilder_partCheckBox_userId_partXml_orgId_job_check_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_FlowBuilder_partTextArea_userId_partXml_orgId_job_check_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_FlowBuilder_partSelect_userId_partXml_orgId_job_check_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_FlowBuilder_partPrint_userId_partXml_orgId_job_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_FlowBuilder_partConfirmRoute_job_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_bean_define_scope_name_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_bean_define_type_scope_property_name_id_nobody.release();
    _jspx_tagPool_bean_write_property_name_nobody.release();
    _jspx_tagPool_FlowBuilder_partOperator_userId_partXml_orgId_job_nobody.release();
    _jspx_tagPool_FlowBuilder_partJobName_userId_partXml_orgId_job_check_nobody.release();
    _jspx_tagPool_FlowBuilder_partImage_userId_partXml_job_nobody.release();
    _jspx_tagPool_FlowBuilder_partInput_userId_partXml_orgId_job_check_nobody.release();
    _jspx_tagPool_FlowBuilder_partRadioBox_userId_partXml_orgId_job_check_nobody.release();
    _jspx_tagPool_FlowBuilder_partSelectDate_userId_partXml_orgId_job_check_nobody.release();
    _jspx_tagPool_FlowBuilder_partEmail_userId_partXml_orgId_job_check_nobody.release();
    _jspx_tagPool_FlowBuilder_partCheckBox_userId_partXml_orgId_job_check_nobody.release();
    _jspx_tagPool_FlowBuilder_partTextArea_userId_partXml_orgId_job_check_nobody.release();
    _jspx_tagPool_FlowBuilder_partSelect_userId_partXml_orgId_job_check_nobody.release();
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

      out.write("\r\n");
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
      out.write("\t\t\t<td width=\"400\" align=\"left\" valign=\"middle\" nowrap><img src=\"/FlowBuilder/images/security.gif\"></img></td>\r\n");
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
      out.write("\r\n");
      out.write("<!--動作制御部品-->\r\n");
      out.write("\t");
      //  FlowBuilder:partOperator
      flowbuilder.presentation.webcmn.taglibs.PartOperator _jspx_th_FlowBuilder_partOperator_0 = (flowbuilder.presentation.webcmn.taglibs.PartOperator) _jspx_tagPool_FlowBuilder_partOperator_userId_partXml_orgId_job_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartOperator.class);
      _jspx_th_FlowBuilder_partOperator_0.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partOperator_0.setParent(null);
      _jspx_th_FlowBuilder_partOperator_0.setJob(job);
      _jspx_th_FlowBuilder_partOperator_0.setOrgId(orgId);
      _jspx_th_FlowBuilder_partOperator_0.setUserId(userId);
      _jspx_th_FlowBuilder_partOperator_0.setPartXml(
"<部品>" +
	"<step name='案件作成'>" +
		"<opr id='create' user='' role='社員' org='' vital_check='1'/>" +
	"</step>" +
	"<step name='案件起案'>" +
		"<opr id='start' user='案件作成:作成者' role='' org='' vital_check='1'/>" +
		"<opr id='save' user='案件作成:作成者' role='' org='' vital_check='0'/>" +
		"<opr id='disposal' user='案件作成:作成者' role='' org='' vital_check='0'/>" +
	"</step>" +
	"<step name='マネージャ承認'>" +
		"<opr id='returnSelf' user='案件作成:作成者' role=''  org='' vital_check='0'/>" +
		"<opr id='confirm' user='' role='マネージャ'  org='' vital_check='1'/>" +
		"<opr id='return' user='' role='マネージャ'  org='' vital_check='1'/>" +
	"</step>" +
	"<step name='グループ長承認'>" +
		"<opr id='confirm' user='' role='グループ長'  org='' vital_check='1'/>" +
		"<opr id='return' user='' role='グループ長'  org='' vital_check='1'/>" +
	"</step>" +
	"<step name='部長承認'>" +
		"<opr id='confirm' user='' role='部長'  org='*' vital_check='1'/>" +
		"<opr id='return' user='' role='部長'  org='*' vital_check='1'/>" +
	"</step>" +
	"<step name='SI事業部長承認'>" +
		"<opr id='confirm' user='' role='部長'  org='SI事業部' vital_check='1'/>" +
		"<opr id='return' user='' role='部長'  org='SI事業部' vital_check='1'/>" +
	"</step>" +
	"<step name='開通状態'>" +
		"<opr id='stop' user='' role='部長'  org='SI事業部' vital_check='0'/>" +
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
      out.write("\t\t\t\t<table bgcolor=\"#999999\" align=\"center\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" width=\"740\">\r\n");
      out.write("\t\t\t\t\t<form name=\"JobDetailForm\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t\t\t\t<tr bgcolor=\"#efefef\" align=\"center\" valign=\"middle\"> \r\n");
      out.write("\t\t\t\t\t\t<td height=30 colspan=3 >案　件　内　容</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td height=25 width=150  nowrap>案件名</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25 width=450>\r\n");
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
								"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"</部品>"
								);
      _jspx_th_FlowBuilder_partJobName_0.setCheck(
									"<Checks partName='案件名'>" +
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
      out.write("\t\t\t\t\t\t<td height=25 width=100 rowspan=\"3\"  align=\"center\">\t<!--影像部品-->\r\n");
      out.write("\t\t\t\t\t\t\t");
      //  FlowBuilder:partImage
      flowbuilder.presentation.webcmn.taglibs.PartImage _jspx_th_FlowBuilder_partImage_0 = (flowbuilder.presentation.webcmn.taglibs.PartImage) _jspx_tagPool_FlowBuilder_partImage_userId_partXml_job_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartImage.class);
      _jspx_th_FlowBuilder_partImage_0.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partImage_0.setParent(null);
      _jspx_th_FlowBuilder_partImage_0.setJob(job);
      _jspx_th_FlowBuilder_partImage_0.setUserId(userId);
      _jspx_th_FlowBuilder_partImage_0.setPartXml(
							"<部品>" +
								"<option path='/FlowBuilder/images/userImages/' height='100' width='100'/>" +
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
      out.write("\t\t\t\t\t\t<td  nowrap>プロジェクト名</td>\r\n");
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
								"<タグ name='projectGroup' style='HEIGHT: 22px; WIDTH: 300px' />" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"</部品>"
								);
      _jspx_th_FlowBuilder_partInput_0.setCheck(
									"<Checks partName='プロジェクト名'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='projectGroup'/>" +
											"<CheckItem type='ValidateLength' htmlId='projectGroup' min='1' max='30'/>" +
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
      out.write("\t\t\t\t\t\t<td nowrap>役割担当</td>\r\n");
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
								"<タグ name='jobSelectPM' style='HEIGHT: 22px; WIDTH: 40px'/>" +
								"<非表示 user='' role=''/>" +
								"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員'/>" +
								"<編集 user='案件起案/案件作成:作成者' role=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role=''/>" +
								"<content name='PG,PL,PM,その他' defalut='PG'/>" +
							"</部品>"
								);
      _jspx_th_FlowBuilder_partRadioBox_0.setCheck(
									"<Checks partName='役割担当'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateRadioNull' htmlId='jobSelectPM'/>" +
										"</Condition>" +
									"</Checks>");
      int _jspx_eval_FlowBuilder_partRadioBox_0 = _jspx_th_FlowBuilder_partRadioBox_0.doStartTag();
      if (_jspx_th_FlowBuilder_partRadioBox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partRadioBox_userId_partXml_orgId_job_check_nobody.reuse(_jspx_th_FlowBuilder_partRadioBox_0);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td height=25 width=150  nowrap>期間</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25 width=400  colspan=\"2\">\r\n");
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
						"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
						"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
						"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
					"</部品>"
						);
      _jspx_th_FlowBuilder_partSelectDate_0.setCheck( 
						"<Checks partName='期間'>" +
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
      out.write("\t\t\t\t\t\t<td nowrap>目標URL指定</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25  colspan=\"2\">\r\n");
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
								"<タグ name='address' style='HEIGHT: 22px; WIDTH: 300px' />" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<必須 user='' role='' org=''/>" +
							"</部品>"
								);
      _jspx_th_FlowBuilder_partInput_1.setCheck( 
									"<Checks partName='目標URL指定'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateLength' htmlId='address' min='1' max='100'/>" +
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
      out.write("\t\t\t\t\t\t<td nowrap>ポート指定</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25 colspan=\"2\">\r\n");
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
								"<タグ name='port' style='HEIGHT: 22px; WIDTH: 300px' />" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<必須 user='' role='' org=''/>" +
							"</部品>"
								);
      _jspx_th_FlowBuilder_partInput_2.setCheck( 
									"<Checks partName='ポート指定'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateRegExp' htmlId='port' value='/^[0-9]{0,4}$/'/>" +
											"<CheckItem type='ValidateLength' htmlId='port' min='1' max='5'/>" +
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
      out.write("\t\t\t\t\t\t<td nowrap>社外メール</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25 width=100 colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<!--EMAIL選択部品-->\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      //  FlowBuilder:partEmail
      flowbuilder.presentation.webcmn.taglibs.PartEmail _jspx_th_FlowBuilder_partEmail_0 = (flowbuilder.presentation.webcmn.taglibs.PartEmail) _jspx_tagPool_FlowBuilder_partEmail_userId_partXml_orgId_job_check_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartEmail.class);
      _jspx_th_FlowBuilder_partEmail_0.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partEmail_0.setParent(null);
      _jspx_th_FlowBuilder_partEmail_0.setJob(job);
      _jspx_th_FlowBuilder_partEmail_0.setOrgId(orgId);
      _jspx_th_FlowBuilder_partEmail_0.setUserId(userId);
      _jspx_th_FlowBuilder_partEmail_0.setPartXml(
								"<部品>" +
									"<タグ name='email' style='HEIGHT: 22px; WIDTH: 300px'/>" +
									"<非表示 user='' role='' org=''/>" +
									"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
									"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
									"<必須 user='' role='' org=''/>" +
								"</部品>"
								);
      _jspx_th_FlowBuilder_partEmail_0.setCheck( 
									"<Checks partName='社外メール'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateRegExp' htmlId='email' value = '/^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$/'/>" +
										"</Condition>" +
									"</Checks>");
      int _jspx_eval_FlowBuilder_partEmail_0 = _jspx_th_FlowBuilder_partEmail_0.doStartTag();
      if (_jspx_th_FlowBuilder_partEmail_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partEmail_userId_partXml_orgId_job_check_nobody.reuse(_jspx_th_FlowBuilder_partEmail_0);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td nowrap>申請項目指定</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25  colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t<!--CHECKBOX選択部品-->\r\n");
      out.write("\t\t\t\t\t\t");
      //  FlowBuilder:partCheckBox
      flowbuilder.presentation.webcmn.taglibs.PartCheckBox _jspx_th_FlowBuilder_partCheckBox_0 = (flowbuilder.presentation.webcmn.taglibs.PartCheckBox) _jspx_tagPool_FlowBuilder_partCheckBox_userId_partXml_orgId_job_check_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartCheckBox.class);
      _jspx_th_FlowBuilder_partCheckBox_0.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partCheckBox_0.setParent(null);
      _jspx_th_FlowBuilder_partCheckBox_0.setJob(job);
      _jspx_th_FlowBuilder_partCheckBox_0.setOrgId(orgId);
      _jspx_th_FlowBuilder_partCheckBox_0.setUserId(userId);
      _jspx_th_FlowBuilder_partCheckBox_0.setPartXml(
						"<部品>" +
							"<タグ name='USB/HD/FD/CDROM/MSN/SKYPE/EMAIL' style='HEIGHT: 22px; WIDTH: 40px'/>" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
							"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"<content name='USB,HD,FD,CD-ROM,MSN,SKYPE,電子カメラ' defalut=''/>" +
						"</部品>"
							);
      _jspx_th_FlowBuilder_partCheckBox_0.setCheck("");
      int _jspx_eval_FlowBuilder_partCheckBox_0 = _jspx_th_FlowBuilder_partCheckBox_0.doStartTag();
      if (_jspx_th_FlowBuilder_partCheckBox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partCheckBox_userId_partXml_orgId_job_check_nobody.reuse(_jspx_th_FlowBuilder_partCheckBox_0);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td>その他の指定</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25 colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t<!--入力部品-->\r\n");
      out.write("\t\t\t\t\t\t");
      //  FlowBuilder:partInput
      flowbuilder.presentation.webcmn.taglibs.PartInput _jspx_th_FlowBuilder_partInput_3 = (flowbuilder.presentation.webcmn.taglibs.PartInput) _jspx_tagPool_FlowBuilder_partInput_userId_partXml_orgId_job_check_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartInput.class);
      _jspx_th_FlowBuilder_partInput_3.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partInput_3.setParent(null);
      _jspx_th_FlowBuilder_partInput_3.setJob(job);
      _jspx_th_FlowBuilder_partInput_3.setOrgId(orgId);
      _jspx_th_FlowBuilder_partInput_3.setUserId(userId);
      _jspx_th_FlowBuilder_partInput_3.setPartXml(
						"<部品>" +
							"<タグ name='otherRequest' style='HEIGHT: 22px; WIDTH: 400px' />" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
							"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"<必須 user='' role='' org=''/>" +
						"</部品>"
							);
      _jspx_th_FlowBuilder_partInput_3.setCheck( 
									"<Checks partName='その他の指定'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateLength' htmlId='otherRequest' min='1' max='100'/>" +
										"</Condition>" +
									"</Checks>");
      int _jspx_eval_FlowBuilder_partInput_3 = _jspx_th_FlowBuilder_partInput_3.doStartTag();
      if (_jspx_th_FlowBuilder_partInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partInput_userId_partXml_orgId_job_check_nobody.reuse(_jspx_th_FlowBuilder_partInput_3);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td valign=\"top\">申請理由</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25 colspan=\"2\">\r\n");
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
							"<タグ name='comment' style='HEIGHT: 22px; WIDTH: 400px; word-break:break-all;' rows='5' cols='50'/>" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
							"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
							"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
						"</部品>"
							);
      _jspx_th_FlowBuilder_partTextArea_0.setCheck( 
									"<Checks partName='申請理由'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='comment'/>" +
											"<CheckItem type='ValidateLength' htmlId='comment' min='1' max='1000'/>" +
										"</Condition>" +
									"</Checks>");
      int _jspx_eval_FlowBuilder_partTextArea_0 = _jspx_th_FlowBuilder_partTextArea_0.doStartTag();
      if (_jspx_th_FlowBuilder_partTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partTextArea_userId_partXml_orgId_job_check_nobody.reuse(_jspx_th_FlowBuilder_partTextArea_0);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td>重要度指定</td>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\t<!--一覧表部品-->\r\n");
      out.write("\t\t\t\t\t\t\t");
      //  FlowBuilder:partSelect
      flowbuilder.presentation.webcmn.taglibs.PartSelect _jspx_th_FlowBuilder_partSelect_0 = (flowbuilder.presentation.webcmn.taglibs.PartSelect) _jspx_tagPool_FlowBuilder_partSelect_userId_partXml_orgId_job_check_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartSelect.class);
      _jspx_th_FlowBuilder_partSelect_0.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partSelect_0.setParent(null);
      _jspx_th_FlowBuilder_partSelect_0.setJob(job);
      _jspx_th_FlowBuilder_partSelect_0.setOrgId(orgId);
      _jspx_th_FlowBuilder_partSelect_0.setUserId(userId);
      _jspx_th_FlowBuilder_partSelect_0.setPartXml(
							"<部品>" +
								"<タグ name='select' style='HEIGHT: 22px; WIDTH: 300px' />" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
								"<編集 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<必須 user='案件起案/案件作成:作成者' role='' org=''/>" +
								"<option value=',high,normal,low' name = ',高,中,低'/>" +
								"<content defalut='high'/>" +
							"</部品>"
								);
      _jspx_th_FlowBuilder_partSelect_0.setCheck(
									"<Checks partName='重要度指定'>" +
										"<Condition value='案件起案'>" +
											"<CheckItem type='ValidateNull' htmlId='select'/>" +
										"</Condition>" +
									"</Checks>");
      int _jspx_eval_FlowBuilder_partSelect_0 = _jspx_th_FlowBuilder_partSelect_0.doStartTag();
      if (_jspx_th_FlowBuilder_partSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partSelect_userId_partXml_orgId_job_check_nobody.reuse(_jspx_th_FlowBuilder_partSelect_0);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td>マネージャからのコメント</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25 colspan=\"2\">\r\n");
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
								"<タグ name='proManageChouComment'  rows='5' cols='50'/>" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
								"<編集 user='' role='マネージャ承認/マネージャ' org=''/>" +
								"<必須 user='' role='マネージャ承認/マネージャ' org=''/>" +
							"</部品>"
								);
      _jspx_th_FlowBuilder_partTextArea_1.setCheck( 
									"<Checks partName='マネージャからのコメント'>" +
										"<Condition value='マネージャ承認'>" +
											"<CheckItem type='ValidateNull' htmlId='proManageChouComment'/>" +
											"<CheckItem type='ValidateLength' htmlId='proManageChouComment' min='1' max='1000'/>" +
										"</Condition>" +
									"</Checks>");
      int _jspx_eval_FlowBuilder_partTextArea_1 = _jspx_th_FlowBuilder_partTextArea_1.doStartTag();
      if (_jspx_th_FlowBuilder_partTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partTextArea_userId_partXml_orgId_job_check_nobody.reuse(_jspx_th_FlowBuilder_partTextArea_1);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td>グループ長からのコメント</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25 colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\t<!--多行の輸入のわく部品-->\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      //  FlowBuilder:partTextArea
      flowbuilder.presentation.webcmn.taglibs.PartTextArea _jspx_th_FlowBuilder_partTextArea_2 = (flowbuilder.presentation.webcmn.taglibs.PartTextArea) _jspx_tagPool_FlowBuilder_partTextArea_userId_partXml_orgId_job_check_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartTextArea.class);
      _jspx_th_FlowBuilder_partTextArea_2.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partTextArea_2.setParent(null);
      _jspx_th_FlowBuilder_partTextArea_2.setJob(job);
      _jspx_th_FlowBuilder_partTextArea_2.setOrgId(orgId);
      _jspx_th_FlowBuilder_partTextArea_2.setUserId(userId);
      _jspx_th_FlowBuilder_partTextArea_2.setPartXml(
							"<部品>" +
								"<タグ name='groupChouComment'  rows='5' cols='50'/>" +
								"<非表示 user='' role='' org=''/>" +
								"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
								"<編集 user='' role='グループ長承認/グループ長' org=''/>" +
								"<必須 user='' role='グループ長承認/グループ長' org=''/>" +
							"</部品>"
								);
      _jspx_th_FlowBuilder_partTextArea_2.setCheck( 
									"<Checks partName='グループ長からのコメント'>" +
										"<Condition value='グループ長承認'>" +
											"<CheckItem type='ValidateNull' htmlId='groupChouComment'/>" +
											"<CheckItem type='ValidateLength' htmlId='groupChouComment' min='1' max='1000'/>" +
										"</Condition>" +
									"</Checks>");
      int _jspx_eval_FlowBuilder_partTextArea_2 = _jspx_th_FlowBuilder_partTextArea_2.doStartTag();
      if (_jspx_th_FlowBuilder_partTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partTextArea_userId_partXml_orgId_job_check_nobody.reuse(_jspx_th_FlowBuilder_partTextArea_2);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td>部長からのコメント</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25 colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t<!--多行の輸入のわく部品-->\r\n");
      out.write("\t\t\t\t\t\t\t");
      //  FlowBuilder:partTextArea
      flowbuilder.presentation.webcmn.taglibs.PartTextArea _jspx_th_FlowBuilder_partTextArea_3 = (flowbuilder.presentation.webcmn.taglibs.PartTextArea) _jspx_tagPool_FlowBuilder_partTextArea_userId_partXml_orgId_job_check_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartTextArea.class);
      _jspx_th_FlowBuilder_partTextArea_3.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partTextArea_3.setParent(null);
      _jspx_th_FlowBuilder_partTextArea_3.setJob(job);
      _jspx_th_FlowBuilder_partTextArea_3.setOrgId(orgId);
      _jspx_th_FlowBuilder_partTextArea_3.setUserId(userId);
      _jspx_th_FlowBuilder_partTextArea_3.setPartXml(
						"<部品>" +
							"<タグ name='buchouComment'  rows='5' cols='50'/>" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
							"<編集 user='' role='部長承認/部長' org='*'/>" +
							"<必須 user='' role='部長承認/部長' org='*'/>" +
						"</部品>"
							);
      _jspx_th_FlowBuilder_partTextArea_3.setCheck( 
									"<Checks partName='部長からのコメント'>" +
										"<Condition value='部長承認'>" +
											"<CheckItem type='ValidateNull' htmlId='buchouComment'/>" +
											"<CheckItem type='ValidateLength' htmlId='buchouComment' min='1' max='1000'/>" +
										"</Condition>" +
									"</Checks>");
      int _jspx_eval_FlowBuilder_partTextArea_3 = _jspx_th_FlowBuilder_partTextArea_3.doStartTag();
      if (_jspx_th_FlowBuilder_partTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partTextArea_userId_partXml_orgId_job_check_nobody.reuse(_jspx_th_FlowBuilder_partTextArea_3);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td>SI事業部長からのコメント</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25 colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t<!--多行の輸入のわく部品-->\r\n");
      out.write("\t\t\t\t\t\t");
      //  FlowBuilder:partTextArea
      flowbuilder.presentation.webcmn.taglibs.PartTextArea _jspx_th_FlowBuilder_partTextArea_4 = (flowbuilder.presentation.webcmn.taglibs.PartTextArea) _jspx_tagPool_FlowBuilder_partTextArea_userId_partXml_orgId_job_check_nobody.get(flowbuilder.presentation.webcmn.taglibs.PartTextArea.class);
      _jspx_th_FlowBuilder_partTextArea_4.setPageContext(_jspx_page_context);
      _jspx_th_FlowBuilder_partTextArea_4.setParent(null);
      _jspx_th_FlowBuilder_partTextArea_4.setJob(job);
      _jspx_th_FlowBuilder_partTextArea_4.setOrgId(orgId);
      _jspx_th_FlowBuilder_partTextArea_4.setUserId(userId);
      _jspx_th_FlowBuilder_partTextArea_4.setPartXml(
						"<部品>" +
							"<タグ name='SIComment'  rows='5' cols='50'/>" +
							"<非表示 user='' role='' org=''/>" +
							"<表示 user='' role='案件起案/社員,マネージャ承認/部長|マネージャ|社員,グループ長承認/部長|グループ長|社員,部長承認/部長|社員,SI事業部長承認/部長|社員,中止状態/社員|部長|システム管理者,開通状態/部長|社員' org=''/>" +
							"<編集 user='' role='SI事業部長承認/部長' org='SI事業部'/>" +
							"<必須 user='' role='SI事業部長承認/部長' org='SI事業部'/>" +
						"</部品>"
							);
      _jspx_th_FlowBuilder_partTextArea_4.setCheck( 
								"<Checks partName='SI事業部長からのコメント'>" +
									"<Condition value='SI事業部長承認'>" +
										"<CheckItem type='ValidateNull' htmlId='SIComment'/>" +
										"<CheckItem type='ValidateLength' htmlId='SIComment' min='1' max='1000'/>" +
									"</Condition>" +
								"</Checks>");
      int _jspx_eval_FlowBuilder_partTextArea_4 = _jspx_th_FlowBuilder_partTextArea_4.doStartTag();
      if (_jspx_th_FlowBuilder_partTextArea_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partTextArea_userId_partXml_orgId_job_check_nobody.reuse(_jspx_th_FlowBuilder_partTextArea_4);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t\t<td>印刷</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td height=25 colspan=\"2\">\r\n");
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
							"<表示 user='' role='中止状態/社員|部長|システム管理者,開通状態/社員|部長|SI事業部長' org=''/>" +
						"</部品>"
							);
      int _jspx_eval_FlowBuilder_partPrint_0 = _jspx_th_FlowBuilder_partPrint_0.doStartTag();
      if (_jspx_th_FlowBuilder_partPrint_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_FlowBuilder_partPrint_userId_partXml_orgId_job_nobody.reuse(_jspx_th_FlowBuilder_partPrint_0);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr align=\"left\" bgcolor=\"#ffffff\" valign=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t<td>経過承認ルート</td>\r\n");
      out.write("\t\t\t\t\t\t<td height=25 colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t<!--通過承認ルート部品-->\r\n");
      out.write("\t\t\t\t\t");
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
