package org.apache.jsp.WEB_002dINF.jsp.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public final class circular_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(4);
    _jspx_dependants.add("/WEB-INF/FlowBuilder.tld");
    _jspx_dependants.add("/WEB-INF/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/struts-logic.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_select_style_property_onchange_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_options_property_labelProperty_collection_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_select_style_size_property_name_multiple;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_hidden_value_property_name_nobody;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_html_select_style_property_onchange_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_options_property_labelProperty_collection_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_select_style_size_property_name_multiple = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_hidden_value_property_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_html_select_style_property_onchange_name.release();
    _jspx_tagPool_html_options_property_labelProperty_collection_nobody.release();
    _jspx_tagPool_html_select_style_size_property_name_multiple.release();
    _jspx_tagPool_html_hidden_value_property_name_nobody.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>ドキュメントXML管理システム</title>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<meta http-equiv=\"expires\" content=\"0\">\r\n");
      out.write("\r\n");
      out.write("<Script language='javascript'>\r\n");
      out.write("\t//追加の関数\r\n");
      out.write("\tfunction add() {\r\n");
      out.write("\t\tfor(var i = 0; i < document.all.leftUser.options.length; i++) {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t//leftUserのユーザが選択された場合\r\r\n");
      out.write("\r\n");
      out.write("\t\t\tif(document.all.leftUser.options[i].selected){ \r\n");
      out.write("\t\t\t\tvar obj = document.createElement('OPTION');\r\n");
      out.write("\t\t\t\tobj.value=document.all.leftUser.options[i].value;\r\n");
      out.write("\t\t\t\tobj.text=document.all.leftUser.options[i].text;\r\n");
      out.write("\t\t\t\tfor(var j = 0; j < document.all.rightUser.options.length;j++){\r\n");
      out.write("\t\t\t\t\tvar flg = false;\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t//leftUserの追加たいのユーザ　と　rightUserの追加されたユーザ同じの場合\r\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tif(document.all.leftUser.options[i].value == document.all.rightUser.options[j].value) {\r\n");
      out.write("\t\t\t\t\t\tflg = true;\r\n");
      out.write("\t\t\t\t\t\tbreak;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t//フラグがtrueの場合\r\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tif (!flg) {\r\n");
      out.write("\t\t\t\t\tdocument.all.rightUser.options.add(obj);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!--rightUserのユーザが追加します-->\r\n");
      out.write("\t\tcmnhozon();\r\n");
      out.write("\t\tparent.document.all.circularID.value = document.all.selectedUsers.value;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//削除の関数\r\n");
      out.write("\tfunction del() {\r\n");
      out.write("\t\tfor(var i = 0; i < document.all.rightUser.options.length; i++){\r\n");
      out.write("\t\t\tif(document.all.rightUser.options[i].selected) {\r\n");
      out.write("\t\t\t\tvar obj = document.createElement('OPTION');\r\n");
      out.write("\t\t\t\tobj.value=document.all.rightUser.options[i].value;\r\n");
      out.write("\t\t\t\tobj.text=document.all.rightUser.options[i].text;\r\n");
      out.write("\t\t\t\tdocument.all.rightUser.options.remove(i--);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//rightUserのユーザが追加します\r\r\n");
      out.write("\r\n");
      out.write("\t\tcmnhozon();\r\n");
      out.write("\t\tparent.document.all.circularID.value = document.all.selectedUsers.value;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//組織が変更されたの場合\r\r\n");
      out.write("\r\n");
      out.write("\tfunction orgChanged() {\r\n");
      out.write("\t\tvar orgId;\r\n");
      out.write(" \t\torgId = document.forms[0].orgId.value;\r\n");
      out.write("\t\tdocument.forms[0].action = \"CircularOperate?method=change&orgId=\" + orgId + \"\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//rightUserのユーザが追加します\r\r\n");
      out.write("\r\n");
      out.write("\t\tcmnhozon();\r\n");
      out.write("\t\tdocument.forms[0].submit();\r\n");
      out.write("\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//rightUserのユーザが追加します\r\r\n");
      out.write("\r\n");
      out.write("\tfunction cmnhozon(){\r\n");
      out.write("\t\tvar strSelectedUsers = \"\";\r\n");
      out.write("\t\t\tfor(var i = 0; i < document.all.rightUser.options.length; i++) {\r\n");
      out.write("\t\t\t\tstrSelectedUsers += document.all.rightUser.options[i].value + \",\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tdocument.all.selectedUsers.value = strSelectedUsers.substr(0, strSelectedUsers.length - 1);\r\n");
      out.write("\t}\t\t\t\r\n");
      out.write("</Script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<style type = \"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write("\ttr,td,th {font-size: 10pt;  color : black ; text-decoration : none ; } \r\n");
      out.write("\ta:link,a:visited {font-size: 12pt;  color : green ; text-decoration : none ;} \r\n");
      out.write("\ta:hover {font-size: 12pt;  color : #80FFFF ;}\r\n");
      out.write("\ta:hover,a:active {color : #6699FF; background-color :#FFFFFF;}\r\n");
      out.write("//-->\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<BODY BGCOLOR=\"#FFFFFF\">\r\n");
      out.write("\t<form name=\"CircularForm\" method=\"post\">\r\n");
      out.write("\t\t<table width=\"100%\" border =\"0\">\r\n");
      out.write("\t\t\t<tr height='50'>\r\n");
      out.write("\t\t\t\t<td colspan='4' align='center' >回  覧  人  員  選  択</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr bgcolor=\"#FFFFFF\">\r\n");
      out.write("\t\t\t\t<td width='6%'>組織:</td>\r\n");
      out.write("\t\t\t\t<td colspan='3'>\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_html_select_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"25\"><td colspan=\"4\"></td></tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td rowspan='2'>人員:</td>\r\n");
      out.write("\t\t\t\t<td rowspan='2'width='35%'>\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_html_select_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td align='center' width='24%'><input name='add_btn' type='button' value='追加＞＞' valign='center'  onclick='add()'/></td>\r\n");
      out.write("\t\t\t\t<td rowspan='2' width='35%'>\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_html_select_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\t\t\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align='center'><input name='del_btn' type='button' value='削除＜＜' valign='center' onclick='del()'/></td>\t\t\r\n");
      out.write("\t\t\t</tr>\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t");
      if (_jspx_meth_html_hidden_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("<script language='javascript'>\r\n");
      out.write("\tcmnhozon();\r\n");
      out.write("\tparent.document.all.circularID.value = document.all.selectedUsers.value;\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_html_select_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:select
    org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_0 = (org.apache.struts.taglib.html.SelectTag) _jspx_tagPool_html_select_style_property_onchange_name.get(org.apache.struts.taglib.html.SelectTag.class);
    _jspx_th_html_select_0.setPageContext(_jspx_page_context);
    _jspx_th_html_select_0.setParent(null);
    _jspx_th_html_select_0.setName("CircularForm");
    _jspx_th_html_select_0.setProperty("orgId");
    _jspx_th_html_select_0.setStyle("width:37%");
    _jspx_th_html_select_0.setOnchange("orgChanged();");
    int _jspx_eval_html_select_0 = _jspx_th_html_select_0.doStartTag();
    if (_jspx_eval_html_select_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_select_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_select_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_select_0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_html_options_0(_jspx_th_html_select_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t       \t\t\t");
        int evalDoAfterBody = _jspx_th_html_select_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_select_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_html_select_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_select_style_property_onchange_name.reuse(_jspx_th_html_select_0);
    return false;
  }

  private boolean _jspx_meth_html_options_0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_select_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:options
    org.apache.struts.taglib.html.OptionsTag _jspx_th_html_options_0 = (org.apache.struts.taglib.html.OptionsTag) _jspx_tagPool_html_options_property_labelProperty_collection_nobody.get(org.apache.struts.taglib.html.OptionsTag.class);
    _jspx_th_html_options_0.setPageContext(_jspx_page_context);
    _jspx_th_html_options_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_select_0);
    _jspx_th_html_options_0.setCollection("orglst");
    _jspx_th_html_options_0.setProperty("no");
    _jspx_th_html_options_0.setLabelProperty("name");
    int _jspx_eval_html_options_0 = _jspx_th_html_options_0.doStartTag();
    if (_jspx_th_html_options_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_options_property_labelProperty_collection_nobody.reuse(_jspx_th_html_options_0);
    return false;
  }

  private boolean _jspx_meth_html_select_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:select
    org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_1 = (org.apache.struts.taglib.html.SelectTag) _jspx_tagPool_html_select_style_size_property_name_multiple.get(org.apache.struts.taglib.html.SelectTag.class);
    _jspx_th_html_select_1.setPageContext(_jspx_page_context);
    _jspx_th_html_select_1.setParent(null);
    _jspx_th_html_select_1.setName("CircularForm");
    _jspx_th_html_select_1.setProperty("leftUser");
    _jspx_th_html_select_1.setSize("10");
    _jspx_th_html_select_1.setMultiple("true");
    _jspx_th_html_select_1.setStyle("width:100%");
    int _jspx_eval_html_select_1 = _jspx_th_html_select_1.doStartTag();
    if (_jspx_eval_html_select_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_select_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_select_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_select_1.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_html_options_1(_jspx_th_html_select_1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t       \t\t\t");
        int evalDoAfterBody = _jspx_th_html_select_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_select_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_html_select_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_select_style_size_property_name_multiple.reuse(_jspx_th_html_select_1);
    return false;
  }

  private boolean _jspx_meth_html_options_1(javax.servlet.jsp.tagext.JspTag _jspx_th_html_select_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:options
    org.apache.struts.taglib.html.OptionsTag _jspx_th_html_options_1 = (org.apache.struts.taglib.html.OptionsTag) _jspx_tagPool_html_options_property_labelProperty_collection_nobody.get(org.apache.struts.taglib.html.OptionsTag.class);
    _jspx_th_html_options_1.setPageContext(_jspx_page_context);
    _jspx_th_html_options_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_select_1);
    _jspx_th_html_options_1.setCollection("queryUserlst");
    _jspx_th_html_options_1.setProperty("loginName");
    _jspx_th_html_options_1.setLabelProperty("userName");
    int _jspx_eval_html_options_1 = _jspx_th_html_options_1.doStartTag();
    if (_jspx_th_html_options_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_options_property_labelProperty_collection_nobody.reuse(_jspx_th_html_options_1);
    return false;
  }

  private boolean _jspx_meth_html_select_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:select
    org.apache.struts.taglib.html.SelectTag _jspx_th_html_select_2 = (org.apache.struts.taglib.html.SelectTag) _jspx_tagPool_html_select_style_size_property_name_multiple.get(org.apache.struts.taglib.html.SelectTag.class);
    _jspx_th_html_select_2.setPageContext(_jspx_page_context);
    _jspx_th_html_select_2.setParent(null);
    _jspx_th_html_select_2.setName("CircularForm");
    _jspx_th_html_select_2.setProperty("rightUser");
    _jspx_th_html_select_2.setSize("10");
    _jspx_th_html_select_2.setMultiple("true");
    _jspx_th_html_select_2.setStyle("width:100%");
    int _jspx_eval_html_select_2 = _jspx_th_html_select_2.doStartTag();
    if (_jspx_eval_html_select_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_select_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_select_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_select_2.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_html_options_2(_jspx_th_html_select_2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t       \t\t\t");
        int evalDoAfterBody = _jspx_th_html_select_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_select_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_html_select_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_select_style_size_property_name_multiple.reuse(_jspx_th_html_select_2);
    return false;
  }

  private boolean _jspx_meth_html_options_2(javax.servlet.jsp.tagext.JspTag _jspx_th_html_select_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:options
    org.apache.struts.taglib.html.OptionsTag _jspx_th_html_options_2 = (org.apache.struts.taglib.html.OptionsTag) _jspx_tagPool_html_options_property_labelProperty_collection_nobody.get(org.apache.struts.taglib.html.OptionsTag.class);
    _jspx_th_html_options_2.setPageContext(_jspx_page_context);
    _jspx_th_html_options_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_select_2);
    _jspx_th_html_options_2.setCollection("selectedUserlst");
    _jspx_th_html_options_2.setProperty("loginName");
    _jspx_th_html_options_2.setLabelProperty("userName");
    int _jspx_eval_html_options_2 = _jspx_th_html_options_2.doStartTag();
    if (_jspx_th_html_options_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_options_property_labelProperty_collection_nobody.reuse(_jspx_th_html_options_2);
    return false;
  }

  private boolean _jspx_meth_html_hidden_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:hidden
    org.apache.struts.taglib.html.HiddenTag _jspx_th_html_hidden_0 = (org.apache.struts.taglib.html.HiddenTag) _jspx_tagPool_html_hidden_value_property_name_nobody.get(org.apache.struts.taglib.html.HiddenTag.class);
    _jspx_th_html_hidden_0.setPageContext(_jspx_page_context);
    _jspx_th_html_hidden_0.setParent(null);
    _jspx_th_html_hidden_0.setName("CircularForm");
    _jspx_th_html_hidden_0.setProperty("selectedUsers");
    _jspx_th_html_hidden_0.setValue("");
    int _jspx_eval_html_hidden_0 = _jspx_th_html_hidden_0.doStartTag();
    if (_jspx_th_html_hidden_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_html_hidden_value_property_name_nobody.reuse(_jspx_th_html_hidden_0);
    return false;
  }
}
