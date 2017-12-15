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
	 * HTML�̍쐬
	 * 
	 * @return StringBuffer HTML������
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
	 * INPUT���i
	 * 
	 * @param job
	 *            document �Č�
	 * @param strOrgID
	 *            String �g�DID
	 * @param strUserID
	 *            String ���[�UID
	 * @param strPartXml
	 *            String ���iXML
	 */
	private String partInputHtml(Document job, String strOrgID, String strUserID, String strPartXml)
	{
		// ���O���o��
		Log logger = LogFactory.getLog(PartCheckCondition.class);
		logger.info("SelectDate�̐��\�e�X�g(Start)�F" + PartCommon.getCurTime());
		String strHtml = "";
		
		String configFlg = super.getShowCase();
			
		strHtml = "<table bgcolor='#999999' align=center border=0 cellpadding=0 cellspacing=0 width='100%'>\n"
			+"<tr align='left' bgcolor='#ffffff' valign='middle'>";
			
		// �ҏW
		Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�^�O"), 0);

		String strtagName = XmlOperator.getAttrValue(tagElement, "name");
		
		String strtagShow = XmlOperator.getAttrValue(tagElement, "value");
		
		String strtagCalendar = XmlOperator.getAttrValue(tagElement, "calendar");				

		String strtagStyle = XmlOperator.getAttrValue(tagElement, "style");

		String strTagValue = "";

		// �K�v��NodeList���擾����h�L�������g
		NodeList Documents = XmlOperator.getNodeList(job, "Document"); // �m�b�h���X�g

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
					
				// �K�{�}�b�N
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
					// �h�L�������g�̒l���擾����
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
				// ��\��
				strHtml = "";
			}
		logger.info("SelectDate�̐��\�e�X�g(End)�F" + PartCommon.getCurTime());
		return (strHtml);
	}
}
