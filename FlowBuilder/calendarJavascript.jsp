<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Shift_JIS" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%/*
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
*/%>
<%/*
 * カレンダー画面表示用JavaScriptが生成される。
 * <bean:message> タグを使って、リソースファイルの内容を取得可能。
 * カレンダー画面で、表示される文章も多国言語対応も可能になる。
 * このファイルは、カレンダーポップアップが必要なJSPのHTMLヘッダーでインポートされる。
 */%>
var weekend = [0,6];
var weekendColor = "#F4F7EA";
var fontface = "Verdana";
var fontsize = 2;

var gNow = new Date();
var ggWinCal;
isNav = (navigator.appName.indexOf("Netscape") != -1) ? true : false;
isIE = (navigator.appName.indexOf("Microsoft") != -1) ? true : false;
//リソースファイルから、月や週やタイトルの情報を取得する
var monthstr='1月,2月,3月,4月,5月,6月,7月,8月,9月,10月,11月,12月';
var weekstr='日,月,火,水,木,金,土';
var titlestr="カレンダー";
var yearstr="年";
var yearmonthorder="1";
//ディフォルト情報を設定する
if(monthstr=="")
  monthstr="January,February,March,April,May,June,July,August,September,October,November,December";
if(weekstr=="")
  weekstr="Sun,Mon,Tue,Wed,Thu,Fri,Sat"	;
if(titlestr=="")
  titlestr="calendar";
if(yearmonthorder=="")
  yearmonthorder="0";
//取得した情報を変数にセットする
Calendar.Months=monthstr.split(",");
Calendar.Weeks=weekstr.split(",");
Calendar.Title=titlestr;
Calendar.Year=yearstr;

// Non-Leap year Month days..
Calendar.DOMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
// Leap year Month days..
Calendar.lDOMonth = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

function Calendar(p_item, p_WinCal, p_month, p_year, p_format) {
if ((p_month == null) && (p_year == null)) return;

if (p_WinCal == null)
this.gWinCal = ggWinCal;
else
this.gWinCal = p_WinCal;

if (p_month == null) {
this.gMonthName = null;
this.gMonth = null;
this.gYearly = true;
} else {
this.gMonthName = Calendar.get_month(p_month);
this.gMonth = new Number(p_month);
this.gYearly = false;
}

this.gYear = p_year;
this.gFormat = p_format;
this.gBGColor = "white";
this.gFGColor = "black";
this.gTextColor = "black";
this.gHeaderColor = "black";
this.gReturnItem = p_item;
}

Calendar.get_month = Calendar_get_month;
Calendar.get_daysofmonth = Calendar_get_daysofmonth;
Calendar.calc_month_year = Calendar_calc_month_year;
Calendar.print = Calendar_print;

function Calendar_get_month(monthNo) {
return Calendar.Months[monthNo];
}

function Calendar_get_daysofmonth(monthNo, p_year) {
/* 
Check for leap year ..
1.Years evenly divisible by four are normally leap years, except for... 
2.Years also evenly divisible by 100 are not leap years, except for... 
3.Years also evenly divisible by 400 are leap years. 
*/
if ((p_year % 4) == 0) {
	if ((p_year % 100) == 0 && (p_year % 400) != 0)
	return Calendar.DOMonth[monthNo];

return Calendar.lDOMonth[monthNo];
} else
return Calendar.DOMonth[monthNo];
}

function Calendar_calc_month_year(p_Month, p_Year, incr) {
/* 
Will return an 1-D array with 1st element being the calculated month 
and second being the calculated year 
after applying the month increment/decrement as specified by 'incr' parameter.
'incr' will normally have 1/-1 to navigate thru the months.
*/
var ret_arr = new Array();

if (incr == -1) {
// B A C K W A R D
if (p_Month == 0) {
ret_arr[0] = 11;
ret_arr[1] = parseInt(p_Year) - 1;
}
else {
ret_arr[0] = parseInt(p_Month) - 1;
ret_arr[1] = parseInt(p_Year);
}
} else if (incr == 1) {
// F O R W A R D
if (p_Month == 11) {
ret_arr[0] = 0;
ret_arr[1] = parseInt(p_Year) + 1;
}
else {
ret_arr[0] = parseInt(p_Month) + 1;
ret_arr[1] = parseInt(p_Year);
}
}

return ret_arr;
}

function Calendar_print() {
ggWinCal.print();
}

function Calendar_calc_month_year(p_Month, p_Year, incr) {
/* 
Will return an 1-D array with 1st element being the calculated month 
and second being the calculated year 
after applying the month increment/decrement as specified by 'incr' parameter.
'incr' will normally have 1/-1 to navigate thru the months.
*/
var ret_arr = new Array();

if (incr == -1) {
// B A C K W A R D
if (p_Month == 0) {
ret_arr[0] = 11;
ret_arr[1] = parseInt(p_Year) - 1;
}
else {
ret_arr[0] = parseInt(p_Month) - 1;
ret_arr[1] = parseInt(p_Year);
}
} else if (incr == 1) {
// F O R W A R D
if (p_Month == 11) {
ret_arr[0] = 0;
ret_arr[1] = parseInt(p_Year) + 1;
}
else {
ret_arr[0] = parseInt(p_Month) + 1;
ret_arr[1] = parseInt(p_Year);
}
}

return ret_arr;
}

// This is for compatibility with Navigator 3, we have to create and discard one object before the prototype object exists.
new Calendar();

Calendar.prototype.getMonthlyCalendarCode = function() {
var vCode = "";
var vHeader_Code = "";
var vData_Code = "";

// Begin Table Drawing code here..
//vCode = vCode + "<table width='100%' bordercolordark='#ffffff' bordercolorlight='#8EA525' bgcolor='#FAFCF1' border='1' cellspacing='0' cellpadding='0' >"
vCode = vCode + "<table width='100%' bordercolor='#191970' bgcolor='#FAFCF1' border='1' cellspacing='0' cellpadding='0' >"

vHeader_Code = this.cal_header();
vData_Code = this.cal_data();
vCode = vCode + vHeader_Code + vData_Code;

vCode = vCode + "</TABLE>";

return vCode;
}

Calendar.prototype.show = function() {
var vCode = "";

this.gWinCal.document.open();

// Setup the page...
this.wwrite("<html>");
this.wwrite("<head><title>Calendar</title>");
this.wwrite("</head>");
//this.wwrite("<meta http-equiv='Content-Type' content='text/html; charset=gb2312'>");
this.wwrite("<style type='text/css'>");
//this.wwrite(".table_dropshadow{FILTER:dropshadow(color=#000000,offx=3.3,offy=3.3,positive=1);}");
//this.wwrite(".font_dropshadow{FILTER: dropshadow(color=#F2F8DA,offx=1,offy=1);}");
this.wwrite("td { font-size: 10pt; color: #191970}");
this.wwrite("tr { height: 25px} .table_head_font{font-size: 14px; color: #7B7B00}");
this.wwrite("a:active { text-decoration: underline overline; color: #5F506D}");
this.wwrite(".table_dashed { border: 1px solid #191970; background-color: #F0F8FF}");
this.wwrite("</style>")
//this.wwrite("<link rel='stylesheet' href='css/green.css' type='text/css'>");

this.wwrite("<body " + "topmargin=\"0\"" +
"link=\"" + this.gLinkColor + "\" " + 
"vlink=\"" + this.gLinkColor + "\" " +
"alink=\"" + this.gLinkColor + "\" " +
"text=\"" + this.gTextColor + "\">");
this.wwriteA("<table><tr><td height=2></td></tr></table>");
this.wwriteA("<FONT FACE='" + fontface + "' SIZE=2><CENTER><B>");
if (yearmonthorder==0)
   this.wwriteA(this.gMonthName + " " + this.gYear+Calendar.Year);
else
   this.wwriteA(this.gYear+Calendar.Year+ " " +this.gMonthName);
   
this.wwriteA("</B></CENTER>");

// Show navigation buttons
var prevMMYYYY = Calendar.calc_month_year(this.gMonth, this.gYear, -1);
var prevMM = prevMMYYYY[0];
var prevYYYY = prevMMYYYY[1];

var nextMMYYYY = Calendar.calc_month_year(this.gMonth, this.gYear, 1);
var nextMM = nextMMYYYY[0];
var nextYYYY = nextMMYYYY[1];
this.wwrite("<table width='100%' border='0' cellspacing='0' cellpadding='0' class='table_dropshadow'><tr><td>");
this.wwrite("<table class='table_dashed' width='100%' align='center' height='20'><TR style='height: 22px'><TD ALIGN=center>");
this.wwrite("[<A HREF=\"" +
"javascript:window.opener.Build(" + 
"'" + this.gReturnItem + "', '" + this.gMonth + "', '" + (parseInt(this.gYear)-1) + "', '" + this.gFormat + "'" +
");" +
"\"><<<\/A>]</TD><TD ALIGN=center>");
this.wwrite("[<A HREF=\"" +
"javascript:window.opener.Build(" + 
"'" + this.gReturnItem + "', '" + prevMM + "', '" + prevYYYY + "', '" + this.gFormat + "'" +
");" +
"\"><<\/A>]</TD><TD ALIGN=center>");
this.wwrite("<b>["+Calendar.Title+"]</b>"+"</TD><TD ALIGN=center>");
this.wwrite("[<A HREF=\"" +
"javascript:window.opener.Build(" + 
"'" + this.gReturnItem + "', '" + nextMM + "', '" + nextYYYY + "', '" + this.gFormat + "'" +
");" +
"\">><\/A>]</TD><TD ALIGN=center>");
this.wwrite("[<A HREF=\"" +
"javascript:window.opener.Build(" + 
"'" + this.gReturnItem + "', '" + this.gMonth + "', '" + (parseInt(this.gYear)+1) + "', '" + this.gFormat + "'" +
");" +
"\">>><\/A>]</TD></TR></TABLE><table><tr><td height=5></td></tr></table>");

// Get the complete calendar code for the month..
vCode = this.getMonthlyCalendarCode();
this.wwrite(vCode);

this.wwrite("</font></body></html>");
this.gWinCal.document.close();
}

Calendar.prototype.showY = function() {
var vCode = "";
var i;
var vr, vc, vx, vy; // Row, Column, X-coord, Y-coord
var vxf = 285; // X-Factor
var vyf = 200; // Y-Factor
var vxm = 10; // X-margin
var vym; // Y-margin
if (isIE) vym = 75;
else if (isNav) vym = 25;

this.gWinCal.document.open();

this.wwrite("<html>");
this.wwrite("<head><title>Calendar</title>");
//this.wwrite("<meta http-equiv='Content-Type' content='text/html; charset=gb2312'>");
this.wwrite("<style type='text/css'>\n<!--");
for (i=0; i<12; i++) {
vc = i % 3;
if (i>=0 && i<= 2) vr = 0;
if (i>=3 && i<= 5) vr = 1;
if (i>=6 && i<= 8) vr = 2;
if (i>=9 && i<= 11) vr = 3;

vx = parseInt(vxf * vc) + vxm;
vy = parseInt(vyf * vr) + vym;

this.wwrite(".lclass" + i + " {position:absolute;top:" + vy + ";left:" + vx + ";}");
}
this.wwrite("");
this.wwrite("-->\n</style>");
this.wwrite("</head>");

this.wwrite("<body " + 
"link=\"" + this.gLinkColor + "\" " + 
"vlink=\"" + this.gLinkColor + "\" " +
"alink=\"" + this.gLinkColor + "\" " +
"text=\"" + this.gTextColor + "\">");
this.wwrite("<FONT FACE='" + fontface + "' SIZE=2><B>");
this.wwrite("Year : " + this.gYear);
this.wwrite("</B><BR>");

// Show navigation buttons
var prevYYYY = parseInt(this.gYear) - 1;
var nextYYYY = parseInt(this.gYear) + 1;

this.wwrite("<table class='table_dropshadow' width='100%' bordercolor='#191970' bgcolor='#FAFCF1' border='1' cellspacing='0' cellpadding='0' align='center'><TR><TD ALIGN=center>");
this.wwrite("[<A HREF=\"" +
"javascript:window.opener.Build(" + 
"'" + this.gReturnItem + "', null, '" + prevYYYY + "', '" + this.gFormat + "'" +
");" +
"\" alt='Prev Year'><<<\/A>]</TD><TD ALIGN=center>");
this.wwrite("[<A HREF=\"javascript:window.print();\">Print</A>]</TD><TD ALIGN=center>");
this.wwrite("[<A HREF=\"" +
"javascript:window.opener.Build(" + 
"'" + this.gReturnItem + "', null, '" + nextYYYY + "', '" + this.gFormat + "'" +
");" +
"\">>><\/A>]</TD></TR></TABLE><BR>");

// Get the complete calendar code for each month..
var j;
for (i=11; i>=0; i--) {
if (isIE)
this.wwrite("<DIV ID=\"layer" + i + "\" CLASS=\"lclass" + i + "\">");
else if (isNav)
this.wwrite("<LAYER ID=\"layer" + i + "\" CLASS=\"lclass" + i + "\">");

this.gMonth = i;
this.gMonthName = Calendar.get_month(this.gMonth);
vCode = this.getMonthlyCalendarCode();
if (yearmonthorder==0)
   this.wwriteA(this.gMonthName + "/" + this.gYear+Calendar.Year);
else
   this.wwriteA(this.gYear+Calendar.Year+ "/" +this.gMonthName);

this.wwrite(vCode);

if (isIE)
this.wwrite("</DIV>");
else if (isNav)
this.wwrite("</LAYER>");
}

this.wwrite("</font><BR></body></html>");
this.gWinCal.document.close();
}

Calendar.prototype.wwrite = function(wtext) {
this.gWinCal.document.writeln(wtext);
}

Calendar.prototype.wwriteA = function(wtext) {
this.gWinCal.document.write(wtext);
}

Calendar.prototype.cal_header = function() {
var vCode = "";

vCode = vCode + "<TR bgcolor='#191970' height=20 align='center'>";
for(iLoop=0;iLoop<7;iLoop++){
vCode =vCode+ "<TD align='center' WIDTH='14%'><b><FONT COLOR='#FFFFFF'>"+Calendar.Weeks[iLoop]+"</FONT></b></TD>";
}
/*
vCode = vCode + "<TD align='center' WIDTH='14%'><b>Sun</b></TD>";
vCode = vCode + "<TD align='center' WIDTH='14%'><b>Mon</b></TD>";
vCode = vCode + "<TD align='center' WIDTH='14%'><b>Tue</b></TD>";
vCode = vCode + "<TD align='center' WIDTH='14%'><b>Wed</b></TD>";
vCode = vCode + "<TD align='center' WIDTH='14%'><b>Thu</b></TD>";
vCode = vCode + "<TD align='center' WIDTH='14%'><b>Fri</b></TD>";
vCode = vCode + "<TD align='center' WIDTH='16%'><b>Sat</b></TD>";
*/
vCode = vCode + "</TR>";
return vCode;
}

Calendar.prototype.cal_data = function() {
var vDate = new Date();
vDate.setDate(1);
vDate.setMonth(this.gMonth);
vDate.setFullYear(this.gYear);

var vFirstDay=vDate.getDay();
var vDay=1;
var vLastDay=Calendar.get_daysofmonth(this.gMonth, this.gYear);
var vOnLastDay=0;
var vCode = "";

/*
Get day for the 1st of the requested month/year..
Place as many blank cells before the 1st day of the month as necessary. 
*/

vCode = vCode + "<TR>";
for (i=0; i<vFirstDay; i++) {
vCode = vCode + "<TD WIDTH='14%'" + this.write_weekend_string(i) + "><FONT SIZE='2' FACE='" + fontface + "'>"+"<table width='100%' border='0' cellspacing='0' cellpadding='0' height='16'><tr ><td class='font_dropshadow'><div align='center' class='table_head_font'>&nbsp;</div></td></tr></table>"+"</FONT></TD>";
}

// Write rest of the 1st week
for (j=vFirstDay; j<7; j++) {
vCode = vCode + "<TD WIDTH='14%'" + this.write_weekend_string(j) + ">"+"<table width='100%' border='0' cellspacing='0' cellpadding='0' height='16'><tr ><td class='font_dropshadow'><div align='center' class='table_head_font'>" + "<FONT SIZE='2' FACE='" + fontface + "'>" +"<A HREF='#' " + 
"onClick=\"self.opener.document.forms[0]." +"elements[\'" + this.gReturnItem + "\']" + ".value='" + 
this.format_data(vDay) + 
"';window.close();\">" + 
this.format_day(vDay) + 
"</A>" + 
"</FONT>"+"</div></td></tr></table>"+"</TD>";
vDay=vDay + 1;
}
vCode = vCode + "</TR>";

// Write the rest of the weeks
for (k=2; k<7; k++) {
vCode = vCode + "<TR>";

for (j=0; j<7; j++) {
vCode = vCode + "<TD WIDTH='14%'" + this.write_weekend_string(j) + ">"+"<table width='100%' border='0' cellspacing='0' cellpadding='0' height='16'><tr ><td class='font_dropshadow'><div align='center' class='table_head_font'>"+"<FONT SIZE='2' FACE='" + fontface + "'>" + 
"<A HREF='#' " + 
"onClick=\"self.opener.document.forms[0]." +"elements[\'" + this.gReturnItem + "\']" + ".value='" + 
this.format_data(vDay) + 
"';window.close();\">" + 
this.format_day(vDay) + 
"</A>" + 
"</FONT>"+"</div></td></tr></table>"+"</TD>";
vDay=vDay + 1;

if (vDay > vLastDay) {
vOnLastDay = 1;
break;
}
}

if (j == 6)
vCode = vCode + "</TR>";
if (vOnLastDay == 1)
break;
}

// Fill up the rest of last week with proper blanks, so that we get proper square blocks
for (m=1; m<(7-j); m++) {
if (this.gYearly)
vCode = vCode + "<TD WIDTH='14%'" + this.write_weekend_string(j+m) + 
">"+"<table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td class='font_dropshadow'>&nbsp;</td></tr></table>"+"</TD>";
else
vCode = vCode + "<TD WIDTH='14%'" + this.write_weekend_string(j+m) + 
">"+"<table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td class='font_dropshadow'>"+m+"</td></tr></table>"+"</TD>";
}

return vCode;
}

Calendar.prototype.format_day = function(vday) {
var vNowDay = gNow.getDate();
var vNowMonth = gNow.getMonth();
var vNowYear = gNow.getFullYear();

if (vday == vNowDay && this.gMonth == vNowMonth && this.gYear == vNowYear)
return ("<FONT COLOR=\"RED\"><B>" +"<table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td class='font_dropshadow'><div align='center'>"+vday+"</div></td></tr></table>"+ "</B></FONT>");
else
return (vday);
}

Calendar.prototype.write_weekend_string = function(vday) {
var i;

// Return special formatting for the weekend day.
for (i=0; i<weekend.length; i++) {
if (vday == weekend)
return (" BGCOLOR=\"" + weekendColor + "\"");
}

return "";
}

Calendar.prototype.format_data = function(p_day) {
var vData;
var vMonth = 1 + this.gMonth;
vMonth = (vMonth.toString().length < 2) ? "0" + vMonth : vMonth;
var vMon = Calendar.get_month(this.gMonth).substr(0,3).toUpperCase();
var vFMon = Calendar.get_month(this.gMonth).toUpperCase();
var vY4 = new String(this.gYear);
var vY2 = new String(this.gYear.substr(2,2));
var vDD = (p_day.toString().length < 2) ? "0" + p_day : p_day;

switch (this.gFormat) {
case "MM\/DD\/YYYY" :
//vData = vMonth + "\/" + vDD + "\/" + vY4;
vData = vY4+"/"+vMonth + "/" + vDD;
            break;
case "MM\/DD\/YY" :
//vData = vMonth + "\/" + vDD + "\/" + vY2;
            vData = vY2+"/"+vMonth + "/" + vDD;
break;
case "MM-DD-YYYY" :
//vData = vMonth + "-" + vDD + "-" + vY4;
vData = vY4+"/"+vMonth + "/" + vDD ;
            break;
case "MM-DD-YY" :
vData = vMonth + "/" + vDD + "/" + vY2;
            vData = vY2+"/"+vMonth + "/" + vDD ;
break;

case "DD\/MON\/YYYY" :
vData = vDD + "\/" + vMon + "\/" + vY4;
break;
case "DD\/MON\/YY" :
vData = vDD + "\/" + vMon + "\/" + vY2;
break;
case "DD-MON-YYYY" :
vData = vDD + "/" + vMon + "/" + vY4;
break;
case "DD-MON-YY" :
vData = vDD + "/" + vMon + "/" + vY2;
break;

case "DD\/MONTH\/YYYY" :
vData = vDD + "\/" + vFMon + "\/" + vY4;
break;
case "DD\/MONTH\/YY" :
vData = vDD + "\/" + vFMon + "\/" + vY2;
break;
case "DD-MONTH-YYYY" :
vData = vDD + "/" + vFMon + "/" + vY4;
break;
case "DD-MONTH-YY" :
vData = vDD + "/" + vFMon + "/" + vY2;
break;

case "DD\/MM\/YYYY" :
vData = vDD + "\/" + vMonth + "\/" + vY4;
break;
case "DD\/MM\/YY" :
vData = vDD + "\/" + vMonth + "\/" + vY2;
break;
case "DD-MM-YYYY" :
vData = vDD + "/" + vMonth + "/" + vY4;
break;
case "DD-MM-YY" :
vData = vDD + "/" + vMonth + "/" + vY2;
break;

default :
vData = vMonth + "\/" + vDD + "\/" + vY4;
}

return vData;
}

function Build(p_item, p_month, p_year, p_format) {
var p_WinCal = ggWinCal;
gCal = new Calendar(p_item, p_WinCal, p_month, p_year, p_format);

// Customize your Calendar here..
gCal.gBGColor="white";
gCal.gLinkColor="black";
gCal.gTextColor="black";
gCal.gHeaderColor="#191970";

// Choose appropriate show function
if (gCal.gYearly) gCal.showY();
else gCal.show();
}

function show_calendar() {
/* 
p_month : 0-11 for Jan-Dec; 12 for All Months.
p_year : 4-digit year
p_format: Date format (mm/dd/yyyy, dd/mm/yy, ...)
p_item : Return Item.
*/
p_item = arguments[0];
if (arguments[1] == null)
p_month = new String(gNow.getMonth());
else
p_month = arguments[1];
if (arguments[2] == "" || arguments[2] == null)
p_year = new String(gNow.getFullYear().toString());
else
p_year = arguments[2];
if (arguments[3] == null)
p_format = "MM/DD/YYYY";
else
p_format = arguments[3];

if (p_year == null || p_year == "")
p_year = new String(gNow.getFullYear().toString());
if (p_format == null || p_format == "")
// p_format = "MM/DD/YYYY";
p_format = "YYYY-MM-DD";

vWinCal = window.open("", "Calendar", 
"width=250,height=253,status=no,resizable=no,top=200,left=200");
vWinCal.opener = self;
ggWinCal = vWinCal;

Build(p_item, p_month, p_year, p_format);
}
/*
Yearly Calendar Code Starts here
*/
function show_yearly_calendar(p_item, p_year, p_format) {
// Load the defaults..
if (p_year == null || p_year == "")
p_year = new String(gNow.getFullYear().toString());
if (p_format == null || p_format == "")
// p_format = "MM/DD/YYYY";
p_format = "YYYY-MM-DD";

var vWinCal = window.open("", "Calendar", "scrollbars=yes");
vWinCal.opener = self;
ggWinCal = vWinCal;

Build(p_item, null, p_year, p_format);
}