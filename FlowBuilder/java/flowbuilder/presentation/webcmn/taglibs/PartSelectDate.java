/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/05/31
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/05/31 BY. Xuxm (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.presentation.webcmn.taglibs.common.PartCommon;

public final class PartSelectDate extends PartParent
{
	/**
	 * HTMLの作成
	 * 
	 * @return StringBuffer HTML文字列
	 */
	protected StringBuffer toHTML()
	{
		StringBuffer html = new StringBuffer();

		try
		{
			html.append(partInputHtml(_job, _orgId, _userId, _partXml));
		}
		catch (java.lang.Exception e)
		{
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}


	/**
	 * INPUT部品
	 * 
	 * @param job
	 *            document 案件
	 * @param strOrgID
	 *            String 組織ID
	 * @param strUserID
	 *            String ユーザID
	 * @param strPartXml
	 *            String 部品XML
	 */
	private String partInputHtml(Document job, String strOrgID, String strUserID, String strPartXml)
	{
		// ログを出力
		Log logger = LogFactory.getLog(PartCheckCondition.class);
		logger.info("SelectDateの性能テスト(Start)：" + PartCommon.getCurTime());
		String strHtml = "";
		
		String configFlg = super.getShowCase();
			
		strHtml = "<table bgcolor='#999999' align=center border=0 cellpadding=0 cellspacing=0 width='100%'>\n"
			+"<tr align='left' bgcolor='#ffffff' valign='middle'>";
			
		// 編集
		Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "タグ"), 0);

		String strtagName = XmlOperator.getAttrValue(tagElement, "name");
		
		String strtagShow = XmlOperator.getAttrValue(tagElement, "value");
		
		String strtagCalendar = XmlOperator.getAttrValue(tagElement, "calendar");				

		String strtagStyle = XmlOperator.getAttrValue(tagElement, "style");

		String strTagValue = "";

		// 必要なNodeListを取得するドキュメント
		NodeList Documents = XmlOperator.getNodeList(job, "Document"); // ノッドリスト

		Element document = (Element) Documents.item(0);

		String[] strtagNameList = strtagName.split("/");
		
		String[] strtagShowList = strtagShow.split("/");
		
		String[] strtagCalendarList = strtagCalendar.split("/");

		int length = strtagNameList.length;
			
		if("edit".equals(configFlg) || "mustEdit".equals(configFlg)){

			for(int i=0;i<length;i++){
				boolean dateFlag = false;
				
				strTagValue = PartCommon.getTagValue(document, strtagNameList[i]);
				
				if("".equals(strTagValue)) {
					if(i == 0){
						strTagValue = PartCommon.getCurDate();
					}
				}
				
				strHtml = strHtml +"<td width='300' nowrap>" + strtagShowList[i] + ":\n";
				
				if("1".equals(strtagCalendarList[i])){
					strHtml = strHtml + "<script language='javascript' src='../../calendarJavascript.jsp'></script>\n";
					dateFlag = true;
				}
				strHtml = strHtml + "<input readonly " + " name='" + strtagNameList[i] + "' style='" + strtagStyle + "' " + " value='"
				+ strTagValue + "'";
					
				// 必須マック
				if ("mustEdit".equals(configFlg))
				{
					strHtml = strHtml + " vital='1'>";
					strHtml = strHtml + "<font color=red>*</font>";
				}
				else
				{
					strHtml = strHtml + " vital='0'>";
				}
					
				if(dateFlag)
				{
					strHtml = strHtml + "<span>\n";
					strHtml = strHtml + "<a href=javascript:show_calendar('" + strtagNameList[i] + "'); onMouseOver=\"window.status='Date Picker';return true;\" onMouseOut=\"window.status='';return true;\" border='0'><img src='/FlowBuilder/css/calender.gif' border='0'></a>\n";
					strHtml = strHtml + "</span>\n";
		
				}
					
					strHtml = strHtml + "</td>\n";
				}
				
				strHtml = strHtml + "</tr>\n"
				  + "</table>\n";

			}
			else if ("display".equals(configFlg))
			{
			
				for(int i=0;i<length;i++){
					// ドキュメントの値を取得する
					strTagValue = PartCommon.getTagValue(document, strtagNameList[i]);
					
					strHtml = strHtml +"<td width='300' nowrap>" + strtagShowList[i] + ":\n";
					
					strHtml = strHtml + strTagValue;
					
					strHtml = strHtml + "</td>\n";				
					
				}
			
				strHtml = strHtml + "</tr>\n"
				  + "</table>\n";
			}
			else if ("nodisplay".equals(configFlg))
			{
				// 非表示
				strHtml = "";
			}
		logger.info("SelectDateの性能テスト(End)：" + PartCommon.getCurTime());
		return (strHtml);
	}
}
