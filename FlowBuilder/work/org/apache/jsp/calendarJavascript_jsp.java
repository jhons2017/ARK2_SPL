package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class calendarJavascript_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/WEB-INF/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/struts-bean.tld");
  }

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
 *			REV.00 '04/11/22 BY. X.XXXXXX (XXX)
 * ==================================================================
*/
      out.write('\r');
      out.write('\n');
/*
 * カレンダー画面表示用JavaScriptが生成される。
 * <bean:message> タグを使って、リソースファイルの内容を取得可能。
 * カレンダー画面で、表示される文章も多国言語対応も可能になる。
 * このファイルは、カレンダーポップアップが必要なJSPのHTMLヘッダーでインポートされる。
 */
      out.write("\r\n");
      out.write("var weekend = [0,6];\r\n");
      out.write("var weekendColor = \"#F4F7EA\";\r\n");
      out.write("var fontface = \"Verdana\";\r\n");
      out.write("var fontsize = 2;\r\n");
      out.write("\r\n");
      out.write("var gNow = new Date();\r\n");
      out.write("var ggWinCal;\r\n");
      out.write("isNav = (navigator.appName.indexOf(\"Netscape\") != -1) ? true : false;\r\n");
      out.write("isIE = (navigator.appName.indexOf(\"Microsoft\") != -1) ? true : false;\r\n");
      out.write("//リソースファイルから、月や週やタイトルの情報を取得する\r\n");
      out.write("var monthstr='1月,2月,3月,4月,5月,6月,7月,8月,9月,10月,11月,12月';\r\n");
      out.write("var weekstr='日,月,火,水,木,金,土';\r\n");
      out.write("var titlestr=\"カレンダー\";\r\n");
      out.write("var yearstr=\"年\";\r\n");
      out.write("var yearmonthorder=\"1\";\r\n");
      out.write("//ディフォルト情報を設定する\r\n");
      out.write("if(monthstr==\"\")\r\n");
      out.write("  monthstr=\"January,February,March,April,May,June,July,August,September,October,November,December\";\r\n");
      out.write("if(weekstr==\"\")\r\n");
      out.write("  weekstr=\"Sun,Mon,Tue,Wed,Thu,Fri,Sat\"\t;\r\n");
      out.write("if(titlestr==\"\")\r\n");
      out.write("  titlestr=\"calendar\";\r\n");
      out.write("if(yearmonthorder==\"\")\r\n");
      out.write("  yearmonthorder=\"0\";\r\n");
      out.write("//取得した情報を変数にセットする\r\n");
      out.write("Calendar.Months=monthstr.split(\",\");\r\n");
      out.write("Calendar.Weeks=weekstr.split(\",\");\r\n");
      out.write("Calendar.Title=titlestr;\r\n");
      out.write("Calendar.Year=yearstr;\r\n");
      out.write("\r\n");
      out.write("// Non-Leap year Month days..\r\n");
      out.write("Calendar.DOMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];\r\n");
      out.write("// Leap year Month days..\r\n");
      out.write("Calendar.lDOMonth = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];\r\n");
      out.write("\r\n");
      out.write("function Calendar(p_item, p_WinCal, p_month, p_year, p_format) {\r\n");
      out.write("if ((p_month == null) && (p_year == null)) return;\r\n");
      out.write("\r\n");
      out.write("if (p_WinCal == null)\r\n");
      out.write("this.gWinCal = ggWinCal;\r\n");
      out.write("else\r\n");
      out.write("this.gWinCal = p_WinCal;\r\n");
      out.write("\r\n");
      out.write("if (p_month == null) {\r\n");
      out.write("this.gMonthName = null;\r\n");
      out.write("this.gMonth = null;\r\n");
      out.write("this.gYearly = true;\r\n");
      out.write("} else {\r\n");
      out.write("this.gMonthName = Calendar.get_month(p_month);\r\n");
      out.write("this.gMonth = new Number(p_month);\r\n");
      out.write("this.gYearly = false;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("this.gYear = p_year;\r\n");
      out.write("this.gFormat = p_format;\r\n");
      out.write("this.gBGColor = \"white\";\r\n");
      out.write("this.gFGColor = \"black\";\r\n");
      out.write("this.gTextColor = \"black\";\r\n");
      out.write("this.gHeaderColor = \"black\";\r\n");
      out.write("this.gReturnItem = p_item;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("Calendar.get_month = Calendar_get_month;\r\n");
      out.write("Calendar.get_daysofmonth = Calendar_get_daysofmonth;\r\n");
      out.write("Calendar.calc_month_year = Calendar_calc_month_year;\r\n");
      out.write("Calendar.print = Calendar_print;\r\n");
      out.write("\r\n");
      out.write("function Calendar_get_month(monthNo) {\r\n");
      out.write("return Calendar.Months[monthNo];\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function Calendar_get_daysofmonth(monthNo, p_year) {\r\n");
      out.write("/* \r\n");
      out.write("Check for leap year ..\r\n");
      out.write("1.Years evenly divisible by four are normally leap years, except for... \r\n");
      out.write("2.Years also evenly divisible by 100 are not leap years, except for... \r\n");
      out.write("3.Years also evenly divisible by 400 are leap years. \r\n");
      out.write("*/\r\n");
      out.write("if ((p_year % 4) == 0) {\r\n");
      out.write("\tif ((p_year % 100) == 0 && (p_year % 400) != 0)\r\n");
      out.write("\treturn Calendar.DOMonth[monthNo];\r\n");
      out.write("\r\n");
      out.write("return Calendar.lDOMonth[monthNo];\r\n");
      out.write("} else\r\n");
      out.write("return Calendar.DOMonth[monthNo];\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function Calendar_calc_month_year(p_Month, p_Year, incr) {\r\n");
      out.write("/* \r\n");
      out.write("Will return an 1-D array with 1st element being the calculated month \r\n");
      out.write("and second being the calculated year \r\n");
      out.write("after applying the month increment/decrement as specified by 'incr' parameter.\r\n");
      out.write("'incr' will normally have 1/-1 to navigate thru the months.\r\n");
      out.write("*/\r\n");
      out.write("var ret_arr = new Array();\r\n");
      out.write("\r\n");
      out.write("if (incr == -1) {\r\n");
      out.write("// B A C K W A R D\r\n");
      out.write("if (p_Month == 0) {\r\n");
      out.write("ret_arr[0] = 11;\r\n");
      out.write("ret_arr[1] = parseInt(p_Year) - 1;\r\n");
      out.write("}\r\n");
      out.write("else {\r\n");
      out.write("ret_arr[0] = parseInt(p_Month) - 1;\r\n");
      out.write("ret_arr[1] = parseInt(p_Year);\r\n");
      out.write("}\r\n");
      out.write("} else if (incr == 1) {\r\n");
      out.write("// F O R W A R D\r\n");
      out.write("if (p_Month == 11) {\r\n");
      out.write("ret_arr[0] = 0;\r\n");
      out.write("ret_arr[1] = parseInt(p_Year) + 1;\r\n");
      out.write("}\r\n");
      out.write("else {\r\n");
      out.write("ret_arr[0] = parseInt(p_Month) + 1;\r\n");
      out.write("ret_arr[1] = parseInt(p_Year);\r\n");
      out.write("}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("return ret_arr;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function Calendar_print() {\r\n");
      out.write("ggWinCal.print();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function Calendar_calc_month_year(p_Month, p_Year, incr) {\r\n");
      out.write("/* \r\n");
      out.write("Will return an 1-D array with 1st element being the calculated month \r\n");
      out.write("and second being the calculated year \r\n");
      out.write("after applying the month increment/decrement as specified by 'incr' parameter.\r\n");
      out.write("'incr' will normally have 1/-1 to navigate thru the months.\r\n");
      out.write("*/\r\n");
      out.write("var ret_arr = new Array();\r\n");
      out.write("\r\n");
      out.write("if (incr == -1) {\r\n");
      out.write("// B A C K W A R D\r\n");
      out.write("if (p_Month == 0) {\r\n");
      out.write("ret_arr[0] = 11;\r\n");
      out.write("ret_arr[1] = parseInt(p_Year) - 1;\r\n");
      out.write("}\r\n");
      out.write("else {\r\n");
      out.write("ret_arr[0] = parseInt(p_Month) - 1;\r\n");
      out.write("ret_arr[1] = parseInt(p_Year);\r\n");
      out.write("}\r\n");
      out.write("} else if (incr == 1) {\r\n");
      out.write("// F O R W A R D\r\n");
      out.write("if (p_Month == 11) {\r\n");
      out.write("ret_arr[0] = 0;\r\n");
      out.write("ret_arr[1] = parseInt(p_Year) + 1;\r\n");
      out.write("}\r\n");
      out.write("else {\r\n");
      out.write("ret_arr[0] = parseInt(p_Month) + 1;\r\n");
      out.write("ret_arr[1] = parseInt(p_Year);\r\n");
      out.write("}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("return ret_arr;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// This is for compatibility with Navigator 3, we have to create and discard one object before the prototype object exists.\r\n");
      out.write("new Calendar();\r\n");
      out.write("\r\n");
      out.write("Calendar.prototype.getMonthlyCalendarCode = function() {\r\n");
      out.write("var vCode = \"\";\r\n");
      out.write("var vHeader_Code = \"\";\r\n");
      out.write("var vData_Code = \"\";\r\n");
      out.write("\r\n");
      out.write("// Begin Table Drawing code here..\r\n");
      out.write("//vCode = vCode + \"<table width='100%' bordercolordark='#ffffff' bordercolorlight='#8EA525' bgcolor='#FAFCF1' border='1' cellspacing='0' cellpadding='0' >\"\r\n");
      out.write("vCode = vCode + \"<table width='100%' bordercolor='#191970' bgcolor='#FAFCF1' border='1' cellspacing='0' cellpadding='0' >\"\r\n");
      out.write("\r\n");
      out.write("vHeader_Code = this.cal_header();\r\n");
      out.write("vData_Code = this.cal_data();\r\n");
      out.write("vCode = vCode + vHeader_Code + vData_Code;\r\n");
      out.write("\r\n");
      out.write("vCode = vCode + \"</TABLE>\";\r\n");
      out.write("\r\n");
      out.write("return vCode;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("Calendar.prototype.show = function() {\r\n");
      out.write("var vCode = \"\";\r\n");
      out.write("\r\n");
      out.write("this.gWinCal.document.open();\r\n");
      out.write("\r\n");
      out.write("// Setup the page...\r\n");
      out.write("this.wwrite(\"<html>\");\r\n");
      out.write("this.wwrite(\"<head><title>Calendar</title>\");\r\n");
      out.write("this.wwrite(\"</head>\");\r\n");
      out.write("//this.wwrite(\"<meta http-equiv='Content-Type' content='text/html; charset=gb2312'>\");\r\n");
      out.write("this.wwrite(\"<style type='text/css'>\");\r\n");
      out.write("//this.wwrite(\".table_dropshadow{FILTER:dropshadow(color=#000000,offx=3.3,offy=3.3,positive=1);}\");\r\n");
      out.write("//this.wwrite(\".font_dropshadow{FILTER: dropshadow(color=#F2F8DA,offx=1,offy=1);}\");\r\n");
      out.write("this.wwrite(\"td { font-size: 10pt; color: #191970}\");\r\n");
      out.write("this.wwrite(\"tr { height: 25px} .table_head_font{font-size: 14px; color: #7B7B00}\");\r\n");
      out.write("this.wwrite(\"a:active { text-decoration: underline overline; color: #5F506D}\");\r\n");
      out.write("this.wwrite(\".table_dashed { border: 1px solid #191970; background-color: #F0F8FF}\");\r\n");
      out.write("this.wwrite(\"</style>\")\r\n");
      out.write("//this.wwrite(\"<link rel='stylesheet' href='css/green.css' type='text/css'>\");\r\n");
      out.write("\r\n");
      out.write("this.wwrite(\"<body \" + \"topmargin=\\\"0\\\"\" +\r\n");
      out.write("\"link=\\\"\" + this.gLinkColor + \"\\\" \" + \r\n");
      out.write("\"vlink=\\\"\" + this.gLinkColor + \"\\\" \" +\r\n");
      out.write("\"alink=\\\"\" + this.gLinkColor + \"\\\" \" +\r\n");
      out.write("\"text=\\\"\" + this.gTextColor + \"\\\">\");\r\n");
      out.write("this.wwriteA(\"<table><tr><td height=2></td></tr></table>\");\r\n");
      out.write("this.wwriteA(\"<FONT FACE='\" + fontface + \"' SIZE=2><CENTER><B>\");\r\n");
      out.write("if (yearmonthorder==0)\r\n");
      out.write("   this.wwriteA(this.gMonthName + \" \" + this.gYear+Calendar.Year);\r\n");
      out.write("else\r\n");
      out.write("   this.wwriteA(this.gYear+Calendar.Year+ \" \" +this.gMonthName);\r\n");
      out.write("   \r\n");
      out.write("this.wwriteA(\"</B></CENTER>\");\r\n");
      out.write("\r\n");
      out.write("// Show navigation buttons\r\n");
      out.write("var prevMMYYYY = Calendar.calc_month_year(this.gMonth, this.gYear, -1);\r\n");
      out.write("var prevMM = prevMMYYYY[0];\r\n");
      out.write("var prevYYYY = prevMMYYYY[1];\r\n");
      out.write("\r\n");
      out.write("var nextMMYYYY = Calendar.calc_month_year(this.gMonth, this.gYear, 1);\r\n");
      out.write("var nextMM = nextMMYYYY[0];\r\n");
      out.write("var nextYYYY = nextMMYYYY[1];\r\n");
      out.write("this.wwrite(\"<table width='100%' border='0' cellspacing='0' cellpadding='0' class='table_dropshadow'><tr><td>\");\r\n");
      out.write("this.wwrite(\"<table class='table_dashed' width='100%' align='center' height='20'><TR style='height: 22px'><TD ALIGN=center>\");\r\n");
      out.write("this.wwrite(\"[<A HREF=\\\"\" +\r\n");
      out.write("\"javascript:window.opener.Build(\" + \r\n");
      out.write("\"'\" + this.gReturnItem + \"', '\" + this.gMonth + \"', '\" + (parseInt(this.gYear)-1) + \"', '\" + this.gFormat + \"'\" +\r\n");
      out.write("\");\" +\r\n");
      out.write("\"\\\"><<<\\/A>]</TD><TD ALIGN=center>\");\r\n");
      out.write("this.wwrite(\"[<A HREF=\\\"\" +\r\n");
      out.write("\"javascript:window.opener.Build(\" + \r\n");
      out.write("\"'\" + this.gReturnItem + \"', '\" + prevMM + \"', '\" + prevYYYY + \"', '\" + this.gFormat + \"'\" +\r\n");
      out.write("\");\" +\r\n");
      out.write("\"\\\"><<\\/A>]</TD><TD ALIGN=center>\");\r\n");
      out.write("this.wwrite(\"<b>[\"+Calendar.Title+\"]</b>\"+\"</TD><TD ALIGN=center>\");\r\n");
      out.write("this.wwrite(\"[<A HREF=\\\"\" +\r\n");
      out.write("\"javascript:window.opener.Build(\" + \r\n");
      out.write("\"'\" + this.gReturnItem + \"', '\" + nextMM + \"', '\" + nextYYYY + \"', '\" + this.gFormat + \"'\" +\r\n");
      out.write("\");\" +\r\n");
      out.write("\"\\\">><\\/A>]</TD><TD ALIGN=center>\");\r\n");
      out.write("this.wwrite(\"[<A HREF=\\\"\" +\r\n");
      out.write("\"javascript:window.opener.Build(\" + \r\n");
      out.write("\"'\" + this.gReturnItem + \"', '\" + this.gMonth + \"', '\" + (parseInt(this.gYear)+1) + \"', '\" + this.gFormat + \"'\" +\r\n");
      out.write("\");\" +\r\n");
      out.write("\"\\\">>><\\/A>]</TD></TR></TABLE><table><tr><td height=5></td></tr></table>\");\r\n");
      out.write("\r\n");
      out.write("// Get the complete calendar code for the month..\r\n");
      out.write("vCode = this.getMonthlyCalendarCode();\r\n");
      out.write("this.wwrite(vCode);\r\n");
      out.write("\r\n");
      out.write("this.wwrite(\"</font></body></html>\");\r\n");
      out.write("this.gWinCal.document.close();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("Calendar.prototype.showY = function() {\r\n");
      out.write("var vCode = \"\";\r\n");
      out.write("var i;\r\n");
      out.write("var vr, vc, vx, vy; // Row, Column, X-coord, Y-coord\r\n");
      out.write("var vxf = 285; // X-Factor\r\n");
      out.write("var vyf = 200; // Y-Factor\r\n");
      out.write("var vxm = 10; // X-margin\r\n");
      out.write("var vym; // Y-margin\r\n");
      out.write("if (isIE) vym = 75;\r\n");
      out.write("else if (isNav) vym = 25;\r\n");
      out.write("\r\n");
      out.write("this.gWinCal.document.open();\r\n");
      out.write("\r\n");
      out.write("this.wwrite(\"<html>\");\r\n");
      out.write("this.wwrite(\"<head><title>Calendar</title>\");\r\n");
      out.write("//this.wwrite(\"<meta http-equiv='Content-Type' content='text/html; charset=gb2312'>\");\r\n");
      out.write("this.wwrite(\"<style type='text/css'>\\n<!--\");\r\n");
      out.write("for (i=0; i<12; i++) {\r\n");
      out.write("vc = i % 3;\r\n");
      out.write("if (i>=0 && i<= 2) vr = 0;\r\n");
      out.write("if (i>=3 && i<= 5) vr = 1;\r\n");
      out.write("if (i>=6 && i<= 8) vr = 2;\r\n");
      out.write("if (i>=9 && i<= 11) vr = 3;\r\n");
      out.write("\r\n");
      out.write("vx = parseInt(vxf * vc) + vxm;\r\n");
      out.write("vy = parseInt(vyf * vr) + vym;\r\n");
      out.write("\r\n");
      out.write("this.wwrite(\".lclass\" + i + \" {position:absolute;top:\" + vy + \";left:\" + vx + \";}\");\r\n");
      out.write("}\r\n");
      out.write("this.wwrite(\"\");\r\n");
      out.write("this.wwrite(\"-->\\n</style>\");\r\n");
      out.write("this.wwrite(\"</head>\");\r\n");
      out.write("\r\n");
      out.write("this.wwrite(\"<body \" + \r\n");
      out.write("\"link=\\\"\" + this.gLinkColor + \"\\\" \" + \r\n");
      out.write("\"vlink=\\\"\" + this.gLinkColor + \"\\\" \" +\r\n");
      out.write("\"alink=\\\"\" + this.gLinkColor + \"\\\" \" +\r\n");
      out.write("\"text=\\\"\" + this.gTextColor + \"\\\">\");\r\n");
      out.write("this.wwrite(\"<FONT FACE='\" + fontface + \"' SIZE=2><B>\");\r\n");
      out.write("this.wwrite(\"Year : \" + this.gYear);\r\n");
      out.write("this.wwrite(\"</B><BR>\");\r\n");
      out.write("\r\n");
      out.write("// Show navigation buttons\r\n");
      out.write("var prevYYYY = parseInt(this.gYear) - 1;\r\n");
      out.write("var nextYYYY = parseInt(this.gYear) + 1;\r\n");
      out.write("\r\n");
      out.write("this.wwrite(\"<table class='table_dropshadow' width='100%' bordercolor='#191970' bgcolor='#FAFCF1' border='1' cellspacing='0' cellpadding='0' align='center'><TR><TD ALIGN=center>\");\r\n");
      out.write("this.wwrite(\"[<A HREF=\\\"\" +\r\n");
      out.write("\"javascript:window.opener.Build(\" + \r\n");
      out.write("\"'\" + this.gReturnItem + \"', null, '\" + prevYYYY + \"', '\" + this.gFormat + \"'\" +\r\n");
      out.write("\");\" +\r\n");
      out.write("\"\\\" alt='Prev Year'><<<\\/A>]</TD><TD ALIGN=center>\");\r\n");
      out.write("this.wwrite(\"[<A HREF=\\\"javascript:window.print();\\\">Print</A>]</TD><TD ALIGN=center>\");\r\n");
      out.write("this.wwrite(\"[<A HREF=\\\"\" +\r\n");
      out.write("\"javascript:window.opener.Build(\" + \r\n");
      out.write("\"'\" + this.gReturnItem + \"', null, '\" + nextYYYY + \"', '\" + this.gFormat + \"'\" +\r\n");
      out.write("\");\" +\r\n");
      out.write("\"\\\">>><\\/A>]</TD></TR></TABLE><BR>\");\r\n");
      out.write("\r\n");
      out.write("// Get the complete calendar code for each month..\r\n");
      out.write("var j;\r\n");
      out.write("for (i=11; i>=0; i--) {\r\n");
      out.write("if (isIE)\r\n");
      out.write("this.wwrite(\"<DIV ID=\\\"layer\" + i + \"\\\" CLASS=\\\"lclass\" + i + \"\\\">\");\r\n");
      out.write("else if (isNav)\r\n");
      out.write("this.wwrite(\"<LAYER ID=\\\"layer\" + i + \"\\\" CLASS=\\\"lclass\" + i + \"\\\">\");\r\n");
      out.write("\r\n");
      out.write("this.gMonth = i;\r\n");
      out.write("this.gMonthName = Calendar.get_month(this.gMonth);\r\n");
      out.write("vCode = this.getMonthlyCalendarCode();\r\n");
      out.write("if (yearmonthorder==0)\r\n");
      out.write("   this.wwriteA(this.gMonthName + \"/\" + this.gYear+Calendar.Year);\r\n");
      out.write("else\r\n");
      out.write("   this.wwriteA(this.gYear+Calendar.Year+ \"/\" +this.gMonthName);\r\n");
      out.write("\r\n");
      out.write("this.wwrite(vCode);\r\n");
      out.write("\r\n");
      out.write("if (isIE)\r\n");
      out.write("this.wwrite(\"</DIV>\");\r\n");
      out.write("else if (isNav)\r\n");
      out.write("this.wwrite(\"</LAYER>\");\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("this.wwrite(\"</font><BR></body></html>\");\r\n");
      out.write("this.gWinCal.document.close();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("Calendar.prototype.wwrite = function(wtext) {\r\n");
      out.write("this.gWinCal.document.writeln(wtext);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("Calendar.prototype.wwriteA = function(wtext) {\r\n");
      out.write("this.gWinCal.document.write(wtext);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("Calendar.prototype.cal_header = function() {\r\n");
      out.write("var vCode = \"\";\r\n");
      out.write("\r\n");
      out.write("vCode = vCode + \"<TR bgcolor='#191970' height=20 align='center'>\";\r\n");
      out.write("for(iLoop=0;iLoop<7;iLoop++){\r\n");
      out.write("vCode =vCode+ \"<TD align='center' WIDTH='14%'><b><FONT COLOR='#FFFFFF'>\"+Calendar.Weeks[iLoop]+\"</FONT></b></TD>\";\r\n");
      out.write("}\r\n");
      out.write("/*\r\n");
      out.write("vCode = vCode + \"<TD align='center' WIDTH='14%'><b>Sun</b></TD>\";\r\n");
      out.write("vCode = vCode + \"<TD align='center' WIDTH='14%'><b>Mon</b></TD>\";\r\n");
      out.write("vCode = vCode + \"<TD align='center' WIDTH='14%'><b>Tue</b></TD>\";\r\n");
      out.write("vCode = vCode + \"<TD align='center' WIDTH='14%'><b>Wed</b></TD>\";\r\n");
      out.write("vCode = vCode + \"<TD align='center' WIDTH='14%'><b>Thu</b></TD>\";\r\n");
      out.write("vCode = vCode + \"<TD align='center' WIDTH='14%'><b>Fri</b></TD>\";\r\n");
      out.write("vCode = vCode + \"<TD align='center' WIDTH='16%'><b>Sat</b></TD>\";\r\n");
      out.write("*/\r\n");
      out.write("vCode = vCode + \"</TR>\";\r\n");
      out.write("return vCode;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("Calendar.prototype.cal_data = function() {\r\n");
      out.write("var vDate = new Date();\r\n");
      out.write("vDate.setDate(1);\r\n");
      out.write("vDate.setMonth(this.gMonth);\r\n");
      out.write("vDate.setFullYear(this.gYear);\r\n");
      out.write("\r\n");
      out.write("var vFirstDay=vDate.getDay();\r\n");
      out.write("var vDay=1;\r\n");
      out.write("var vLastDay=Calendar.get_daysofmonth(this.gMonth, this.gYear);\r\n");
      out.write("var vOnLastDay=0;\r\n");
      out.write("var vCode = \"\";\r\n");
      out.write("\r\n");
      out.write("/*\r\n");
      out.write("Get day for the 1st of the requested month/year..\r\n");
      out.write("Place as many blank cells before the 1st day of the month as necessary. \r\n");
      out.write("*/\r\n");
      out.write("\r\n");
      out.write("vCode = vCode + \"<TR>\";\r\n");
      out.write("for (i=0; i<vFirstDay; i++) {\r\n");
      out.write("vCode = vCode + \"<TD WIDTH='14%'\" + this.write_weekend_string(i) + \"><FONT SIZE='2' FACE='\" + fontface + \"'>\"+\"<table width='100%' border='0' cellspacing='0' cellpadding='0' height='16'><tr ><td class='font_dropshadow'><div align='center' class='table_head_font'>&nbsp;</div></td></tr></table>\"+\"</FONT></TD>\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// Write rest of the 1st week\r\n");
      out.write("for (j=vFirstDay; j<7; j++) {\r\n");
      out.write("vCode = vCode + \"<TD WIDTH='14%'\" + this.write_weekend_string(j) + \">\"+\"<table width='100%' border='0' cellspacing='0' cellpadding='0' height='16'><tr ><td class='font_dropshadow'><div align='center' class='table_head_font'>\" + \"<FONT SIZE='2' FACE='\" + fontface + \"'>\" +\"<A HREF='#' \" + \r\n");
      out.write("\"onClick=\\\"self.opener.document.forms[0].\" +\"elements[\\'\" + this.gReturnItem + \"\\']\" + \".value='\" + \r\n");
      out.write("this.format_data(vDay) + \r\n");
      out.write("\"';window.close();\\\">\" + \r\n");
      out.write("this.format_day(vDay) + \r\n");
      out.write("\"</A>\" + \r\n");
      out.write("\"</FONT>\"+\"</div></td></tr></table>\"+\"</TD>\";\r\n");
      out.write("vDay=vDay + 1;\r\n");
      out.write("}\r\n");
      out.write("vCode = vCode + \"</TR>\";\r\n");
      out.write("\r\n");
      out.write("// Write the rest of the weeks\r\n");
      out.write("for (k=2; k<7; k++) {\r\n");
      out.write("vCode = vCode + \"<TR>\";\r\n");
      out.write("\r\n");
      out.write("for (j=0; j<7; j++) {\r\n");
      out.write("vCode = vCode + \"<TD WIDTH='14%'\" + this.write_weekend_string(j) + \">\"+\"<table width='100%' border='0' cellspacing='0' cellpadding='0' height='16'><tr ><td class='font_dropshadow'><div align='center' class='table_head_font'>\"+\"<FONT SIZE='2' FACE='\" + fontface + \"'>\" + \r\n");
      out.write("\"<A HREF='#' \" + \r\n");
      out.write("\"onClick=\\\"self.opener.document.forms[0].\" +\"elements[\\'\" + this.gReturnItem + \"\\']\" + \".value='\" + \r\n");
      out.write("this.format_data(vDay) + \r\n");
      out.write("\"';window.close();\\\">\" + \r\n");
      out.write("this.format_day(vDay) + \r\n");
      out.write("\"</A>\" + \r\n");
      out.write("\"</FONT>\"+\"</div></td></tr></table>\"+\"</TD>\";\r\n");
      out.write("vDay=vDay + 1;\r\n");
      out.write("\r\n");
      out.write("if (vDay > vLastDay) {\r\n");
      out.write("vOnLastDay = 1;\r\n");
      out.write("break;\r\n");
      out.write("}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("if (j == 6)\r\n");
      out.write("vCode = vCode + \"</TR>\";\r\n");
      out.write("if (vOnLastDay == 1)\r\n");
      out.write("break;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// Fill up the rest of last week with proper blanks, so that we get proper square blocks\r\n");
      out.write("for (m=1; m<(7-j); m++) {\r\n");
      out.write("if (this.gYearly)\r\n");
      out.write("vCode = vCode + \"<TD WIDTH='14%'\" + this.write_weekend_string(j+m) + \r\n");
      out.write("\">\"+\"<table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td class='font_dropshadow'>&nbsp;</td></tr></table>\"+\"</TD>\";\r\n");
      out.write("else\r\n");
      out.write("vCode = vCode + \"<TD WIDTH='14%'\" + this.write_weekend_string(j+m) + \r\n");
      out.write("\">\"+\"<table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td class='font_dropshadow'>\"+m+\"</td></tr></table>\"+\"</TD>\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("return vCode;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("Calendar.prototype.format_day = function(vday) {\r\n");
      out.write("var vNowDay = gNow.getDate();\r\n");
      out.write("var vNowMonth = gNow.getMonth();\r\n");
      out.write("var vNowYear = gNow.getFullYear();\r\n");
      out.write("\r\n");
      out.write("if (vday == vNowDay && this.gMonth == vNowMonth && this.gYear == vNowYear)\r\n");
      out.write("return (\"<FONT COLOR=\\\"RED\\\"><B>\" +\"<table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td class='font_dropshadow'><div align='center'>\"+vday+\"</div></td></tr></table>\"+ \"</B></FONT>\");\r\n");
      out.write("else\r\n");
      out.write("return (vday);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("Calendar.prototype.write_weekend_string = function(vday) {\r\n");
      out.write("var i;\r\n");
      out.write("\r\n");
      out.write("// Return special formatting for the weekend day.\r\n");
      out.write("for (i=0; i<weekend.length; i++) {\r\n");
      out.write("if (vday == weekend)\r\n");
      out.write("return (\" BGCOLOR=\\\"\" + weekendColor + \"\\\"\");\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("return \"\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("Calendar.prototype.format_data = function(p_day) {\r\n");
      out.write("var vData;\r\n");
      out.write("var vMonth = 1 + this.gMonth;\r\n");
      out.write("vMonth = (vMonth.toString().length < 2) ? \"0\" + vMonth : vMonth;\r\n");
      out.write("var vMon = Calendar.get_month(this.gMonth).substr(0,3).toUpperCase();\r\n");
      out.write("var vFMon = Calendar.get_month(this.gMonth).toUpperCase();\r\n");
      out.write("var vY4 = new String(this.gYear);\r\n");
      out.write("var vY2 = new String(this.gYear.substr(2,2));\r\n");
      out.write("var vDD = (p_day.toString().length < 2) ? \"0\" + p_day : p_day;\r\n");
      out.write("\r\n");
      out.write("switch (this.gFormat) {\r\n");
      out.write("case \"MM\\/DD\\/YYYY\" :\r\n");
      out.write("//vData = vMonth + \"\\/\" + vDD + \"\\/\" + vY4;\r\n");
      out.write("vData = vY4+\"/\"+vMonth + \"/\" + vDD;\r\n");
      out.write("            break;\r\n");
      out.write("case \"MM\\/DD\\/YY\" :\r\n");
      out.write("//vData = vMonth + \"\\/\" + vDD + \"\\/\" + vY2;\r\n");
      out.write("            vData = vY2+\"/\"+vMonth + \"/\" + vDD;\r\n");
      out.write("break;\r\n");
      out.write("case \"MM-DD-YYYY\" :\r\n");
      out.write("//vData = vMonth + \"-\" + vDD + \"-\" + vY4;\r\n");
      out.write("vData = vY4+\"/\"+vMonth + \"/\" + vDD ;\r\n");
      out.write("            break;\r\n");
      out.write("case \"MM-DD-YY\" :\r\n");
      out.write("vData = vMonth + \"/\" + vDD + \"/\" + vY2;\r\n");
      out.write("            vData = vY2+\"/\"+vMonth + \"/\" + vDD ;\r\n");
      out.write("break;\r\n");
      out.write("\r\n");
      out.write("case \"DD\\/MON\\/YYYY\" :\r\n");
      out.write("vData = vDD + \"\\/\" + vMon + \"\\/\" + vY4;\r\n");
      out.write("break;\r\n");
      out.write("case \"DD\\/MON\\/YY\" :\r\n");
      out.write("vData = vDD + \"\\/\" + vMon + \"\\/\" + vY2;\r\n");
      out.write("break;\r\n");
      out.write("case \"DD-MON-YYYY\" :\r\n");
      out.write("vData = vDD + \"/\" + vMon + \"/\" + vY4;\r\n");
      out.write("break;\r\n");
      out.write("case \"DD-MON-YY\" :\r\n");
      out.write("vData = vDD + \"/\" + vMon + \"/\" + vY2;\r\n");
      out.write("break;\r\n");
      out.write("\r\n");
      out.write("case \"DD\\/MONTH\\/YYYY\" :\r\n");
      out.write("vData = vDD + \"\\/\" + vFMon + \"\\/\" + vY4;\r\n");
      out.write("break;\r\n");
      out.write("case \"DD\\/MONTH\\/YY\" :\r\n");
      out.write("vData = vDD + \"\\/\" + vFMon + \"\\/\" + vY2;\r\n");
      out.write("break;\r\n");
      out.write("case \"DD-MONTH-YYYY\" :\r\n");
      out.write("vData = vDD + \"/\" + vFMon + \"/\" + vY4;\r\n");
      out.write("break;\r\n");
      out.write("case \"DD-MONTH-YY\" :\r\n");
      out.write("vData = vDD + \"/\" + vFMon + \"/\" + vY2;\r\n");
      out.write("break;\r\n");
      out.write("\r\n");
      out.write("case \"DD\\/MM\\/YYYY\" :\r\n");
      out.write("vData = vDD + \"\\/\" + vMonth + \"\\/\" + vY4;\r\n");
      out.write("break;\r\n");
      out.write("case \"DD\\/MM\\/YY\" :\r\n");
      out.write("vData = vDD + \"\\/\" + vMonth + \"\\/\" + vY2;\r\n");
      out.write("break;\r\n");
      out.write("case \"DD-MM-YYYY\" :\r\n");
      out.write("vData = vDD + \"/\" + vMonth + \"/\" + vY4;\r\n");
      out.write("break;\r\n");
      out.write("case \"DD-MM-YY\" :\r\n");
      out.write("vData = vDD + \"/\" + vMonth + \"/\" + vY2;\r\n");
      out.write("break;\r\n");
      out.write("\r\n");
      out.write("default :\r\n");
      out.write("vData = vMonth + \"\\/\" + vDD + \"\\/\" + vY4;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("return vData;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function Build(p_item, p_month, p_year, p_format) {\r\n");
      out.write("var p_WinCal = ggWinCal;\r\n");
      out.write("gCal = new Calendar(p_item, p_WinCal, p_month, p_year, p_format);\r\n");
      out.write("\r\n");
      out.write("// Customize your Calendar here..\r\n");
      out.write("gCal.gBGColor=\"white\";\r\n");
      out.write("gCal.gLinkColor=\"black\";\r\n");
      out.write("gCal.gTextColor=\"black\";\r\n");
      out.write("gCal.gHeaderColor=\"#191970\";\r\n");
      out.write("\r\n");
      out.write("// Choose appropriate show function\r\n");
      out.write("if (gCal.gYearly) gCal.showY();\r\n");
      out.write("else gCal.show();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function show_calendar() {\r\n");
      out.write("/* \r\n");
      out.write("p_month : 0-11 for Jan-Dec; 12 for All Months.\r\n");
      out.write("p_year : 4-digit year\r\n");
      out.write("p_format: Date format (mm/dd/yyyy, dd/mm/yy, ...)\r\n");
      out.write("p_item : Return Item.\r\n");
      out.write("*/\r\n");
      out.write("p_item = arguments[0];\r\n");
      out.write("if (arguments[1] == null)\r\n");
      out.write("p_month = new String(gNow.getMonth());\r\n");
      out.write("else\r\n");
      out.write("p_month = arguments[1];\r\n");
      out.write("if (arguments[2] == \"\" || arguments[2] == null)\r\n");
      out.write("p_year = new String(gNow.getFullYear().toString());\r\n");
      out.write("else\r\n");
      out.write("p_year = arguments[2];\r\n");
      out.write("if (arguments[3] == null)\r\n");
      out.write("p_format = \"MM/DD/YYYY\";\r\n");
      out.write("else\r\n");
      out.write("p_format = arguments[3];\r\n");
      out.write("\r\n");
      out.write("if (p_year == null || p_year == \"\")\r\n");
      out.write("p_year = new String(gNow.getFullYear().toString());\r\n");
      out.write("if (p_format == null || p_format == \"\")\r\n");
      out.write("// p_format = \"MM/DD/YYYY\";\r\n");
      out.write("p_format = \"YYYY-MM-DD\";\r\n");
      out.write("\r\n");
      out.write("vWinCal = window.open(\"\", \"Calendar\", \r\n");
      out.write("\"width=250,height=253,status=no,resizable=no,top=200,left=200\");\r\n");
      out.write("vWinCal.opener = self;\r\n");
      out.write("ggWinCal = vWinCal;\r\n");
      out.write("\r\n");
      out.write("Build(p_item, p_month, p_year, p_format);\r\n");
      out.write("}\r\n");
      out.write("/*\r\n");
      out.write("Yearly Calendar Code Starts here\r\n");
      out.write("*/\r\n");
      out.write("function show_yearly_calendar(p_item, p_year, p_format) {\r\n");
      out.write("// Load the defaults..\r\n");
      out.write("if (p_year == null || p_year == \"\")\r\n");
      out.write("p_year = new String(gNow.getFullYear().toString());\r\n");
      out.write("if (p_format == null || p_format == \"\")\r\n");
      out.write("// p_format = \"MM/DD/YYYY\";\r\n");
      out.write("p_format = \"YYYY-MM-DD\";\r\n");
      out.write("\r\n");
      out.write("var vWinCal = window.open(\"\", \"Calendar\", \"scrollbars=yes\");\r\n");
      out.write("vWinCal.opener = self;\r\n");
      out.write("ggWinCal = vWinCal;\r\n");
      out.write("\r\n");
      out.write("Build(p_item, null, p_year, p_format);\r\n");
      out.write("}");
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
