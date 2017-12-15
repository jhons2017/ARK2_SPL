package org.apache.jsp.WEB_002dINF.jsp.flowbuilder.logon;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class logon_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(3);
    _jspx_dependants.add("/WEB-INF/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/struts-logic.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_form_focus_action;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_logic_messagesPresent;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_messages_id;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_html_form_focus_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_logic_messagesPresent = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_messages_id = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_html_form_focus_action.release();
    _jspx_tagPool_logic_messagesPresent.release();
    _jspx_tagPool_html_messages_id.release();
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<title>无锡华夏业务改善系统</title>\r\n");
      out.write(" <script>\r\n");
      out.write(" <!--\r\n");
      out.write("\tfunction clickLoginButton()\r\n");
      out.write("\t{\r\n");
      out.write("\t\t\r\n");
      out.write("\t\twindow.open(\"\",\"OrgSelect\",\"toolbar=no,left=0,top=0,Width=1280,Height=930,location=no,directories=no,status=yes,scrollbars=yes,menubar=no,resizable=no\");\r\n");
      out.write("\t\tdocument.LoginForm.target = \"OrgSelect\";\r\n");
      out.write("\t\tdocument.LoginForm.submit();\r\n");
      out.write("\t\tif(window.name != \"OrgSelect\"){\r\n");
      out.write("\t\t\twindow.opener = null;\r\n");
      out.write("\t\t\twindow.close();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction clickClearButton()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tdocument.getElementById(\"userId\").value = \"\";\r\n");
      out.write("\t\tdocument.getElementById(\"password\").value = \"\";\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction makeUrl()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar url = location.href.toString();\r\n");
      out.write("\t\tif(url.indexOf(\";\") > 0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\turl = url.substring(0, url.indexOf(\";\"));\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn url;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction keySubmit()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tif(event.keyCode==13)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tclickLoginButton();\r\n");
      out.write("\t\t}\t\t\r\n");
      out.write("\t}\r\n");
      out.write("  // -->\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<table width=\"1004\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td width=\"384\" height=\"101\">&nbsp;</td>\r\n");
      out.write("    <td width=\"563\">&nbsp;</td>\r\n");
      out.write("    <td width=\"57\">&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td height=\"426\" align=\"right\"><img src=\"/FlowBuilder/images/man.jpg\" width=\"300\" height=\"449\" /></td>\r\n");
      out.write("    <td valign=\"top\"><table width=\"489\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td colspan=\"2\">&nbsp;</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td width=\"47\" height=\"155\" valign=\"bottom\">&nbsp;</td>\r\n");
      out.write("        <td width=\"442\" valign=\"bottom\"><span class=\"regularText\"><img src=\"/FlowBuilder/images/login_sign.jpg\" width=\"326\" height=\"95\" /></span></td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td height=\"120\" colspan=\"2\" valign=\"top\">\r\n");
      out.write("\t\t");
      //  html:form
      org.apache.struts.taglib.html.FormTag _jspx_th_html_form_0 = (org.apache.struts.taglib.html.FormTag) _jspx_tagPool_html_form_focus_action.get(org.apache.struts.taglib.html.FormTag.class);
      _jspx_th_html_form_0.setPageContext(_jspx_page_context);
      _jspx_th_html_form_0.setParent(null);
      _jspx_th_html_form_0.setAction("flowbuilder/Login");
      _jspx_th_html_form_0.setFocus("userId");
      int _jspx_eval_html_form_0 = _jspx_th_html_form_0.doStartTag();
      if (_jspx_eval_html_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("          <table width=\"357\" height=\"110\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
          out.write("            <tr>\r\n");
          out.write("              <td width=\"119\" height=\"25\"><img src=\"/FlowBuilder/images/name.gif\" width=\"100\" height=\"25\" /></td>\r\n");
          out.write("              <td><span class=\"regularText\">\r\n");
          out.write("                <input name=\"userId\" type=\"text\" size=\"23\" maxlength=\"15\" style=\"width:200px; border-top:1px solid #CCCCCC;border-bottom:1px solid #999999;border-left:1px solid #CCCCCC;border-right:1px solid #999999;ime-mode:disabled\" />\r\n");
          out.write("              </span></td>\r\n");
          out.write("            </tr>\r\n");
          out.write("            <tr>\r\n");
          out.write("              <td height=\"24\"><img src=\"/FlowBuilder/images/password.gif\" width=\"100\" height=\"25\" /></td>\r\n");
          out.write("              <td><span class=\"regularText\">\r\n");
          out.write("                <input name=\"password\" type=\"password\" size=\"25\" maxlength=\"20\" style=\"width:200px; border-top:1px solid #CCCCCC;border-bottom:1px solid #999999;border-left:1px solid #CCCCCC;border-right:1px solid #999999;\" onKeyDown=\"javascript:keySubmit();\"/>\r\n");
          out.write("              </span></td>\r\n");
          out.write("            </tr>\r\n");
          out.write("            <tr>\r\n");
          out.write("              <td height=\"61\" colspan=\"2\" align=\"right\"><table width=\"331\" height=\"38\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
          out.write("                <tr>\r\n");
          out.write("                  <td width=\"75\">&nbsp;</td>\r\n");
          out.write("                  <td width=\"120\"><a href=\"javascript:clickLoginButton();\" border=0><img src=\"/FlowBuilder/images/login.gif\" width=\"120\" height=\"37\" border=\"0\" /></a></td>\r\n");
          out.write("                  <td width=\"9\">&nbsp;</td>\r\n");
          out.write("                  <td width=\"127\"><a href=\"javascript:clickClearButton();\"><img src=\"/FlowBuilder/images/cancel.gif\" width=\"120\" height=\"37\" border=\"0\" /></a><a href=\"javascript:clickLoginButton();\" border=0></td>\r\n");
          out.write("                </tr>\r\n");
          out.write("              </table>                \r\n");
          out.write("                <div align=\"center\"><a href=\"#\"></a></div></td>\r\n");
          out.write("\t\t\t\t\r\n");
          out.write("\t\t\t\t");
          //  logic:messagesPresent
          org.apache.struts.taglib.logic.MessagesPresentTag _jspx_th_logic_messagesPresent_0 = (org.apache.struts.taglib.logic.MessagesPresentTag) _jspx_tagPool_logic_messagesPresent.get(org.apache.struts.taglib.logic.MessagesPresentTag.class);
          _jspx_th_logic_messagesPresent_0.setPageContext(_jspx_page_context);
          _jspx_th_logic_messagesPresent_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_form_0);
          int _jspx_eval_logic_messagesPresent_0 = _jspx_th_logic_messagesPresent_0.doStartTag();
          if (_jspx_eval_logic_messagesPresent_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n");
              out.write("\t\t\t\t\t\t<ul>\r\n");
              out.write("\t\t\t\t\t\t\t");
              //  html:messages
              org.apache.struts.taglib.html.MessagesTag _jspx_th_html_messages_0 = (org.apache.struts.taglib.html.MessagesTag) _jspx_tagPool_html_messages_id.get(org.apache.struts.taglib.html.MessagesTag.class);
              _jspx_th_html_messages_0.setPageContext(_jspx_page_context);
              _jspx_th_html_messages_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_logic_messagesPresent_0);
              _jspx_th_html_messages_0.setId("error");
              int _jspx_eval_html_messages_0 = _jspx_th_html_messages_0.doStartTag();
              if (_jspx_eval_html_messages_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                java.lang.String error = null;
                if (_jspx_eval_html_messages_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_html_messages_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_html_messages_0.doInitBody();
                }
                error = (java.lang.String) _jspx_page_context.findAttribute("error");
                do {
                  out.write("\r\n");
                  out.write("\t\t\t\t\t\t\t\t<font color=\"blue\" size=\"1\"  align=\"left\">ログイン名またはパスワードが間違っています!</font>\r\n");
                  out.write("\t\t\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_html_messages_0.doAfterBody();
                  error = (java.lang.String) _jspx_page_context.findAttribute("error");
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_html_messages_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_html_messages_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              _jspx_tagPool_html_messages_id.reuse(_jspx_th_html_messages_0);
              out.write("\r\n");
              out.write("\t\t\t\t\t\t</ul>\r\n");
              out.write("\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_logic_messagesPresent_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_logic_messagesPresent_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          _jspx_tagPool_logic_messagesPresent.reuse(_jspx_th_logic_messagesPresent_0);
          out.write("    \r\n");
          out.write("              </tr>\r\n");
          out.write("          </table>\r\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_html_form_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_html_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      _jspx_tagPool_html_form_focus_action.reuse(_jspx_th_html_form_0);
      out.write("        </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table></td>\r\n");
      out.write("    <td>&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>&nbsp;</td>\r\n");
      out.write("    <td>&nbsp;</td>\r\n");
      out.write("    <td>&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
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
}
