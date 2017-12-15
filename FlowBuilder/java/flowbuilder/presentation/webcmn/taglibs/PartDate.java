/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/06/01
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/01 BY. CHENBIN (WXHX)
 * =================================================================
 */

package flowbuilder.presentation.webcmn.taglibs;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import flowbuilder.application.util.ParseXmlString;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.presentation.webcmn.taglibs.common.PartCommon;

/**
 * partDate�̐ݒ�
 * 
 * @author CHENBIN
 */
public final class PartDate extends PartParent {
	/**
	 * HTML�̍쐬
	 * 
	 * @return StringBuffer
	 */
	protected StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();

		try {
			html.append(partDateHtml(_job, _orgId, _userId, _partXml));
		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}

	/**
	 * �������i
	 * 
	 * @param Document job �W���u
	 * @param String strOrgID �g�DID
	 * @param String strUserID ���[�U�[ID
	 * @param String strPartXml ���iXML
	 * 
	 * @return String 
	 */
	public StringBuffer partDateHtml(Document job, String strOrgID, String strUserID, String strPartXml) {
		
		// ���O���o��
		Log logger = LogFactory.getLog(PartCheckCondition.class);
		
		StringBuffer strHtml = new StringBuffer();
		
		String configFlg = super.getShowCase();
	
		try {
			
			// ���O���o��
			logger.info("�J�n");
			
			// ���i�w�l�k�h�L�������g�擾����
			Document part = ParseXmlString.getParsedDocument(strPartXml);

			// �ҏW�ꍇ�����`�F�b�N
			if("edit".equals(configFlg) || "mustEdit".equals(configFlg)){
	
				// �^�O�G�������g���擾����
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�^�O"), 0);
				
				// name�����擾����
				String strtagName = XmlOperator.getAttrValue(tagElement, "name");
				
				// style�����擾����
				String strtagStyle = XmlOperator.getAttrValue(tagElement, "style");
				
				String strtagValue = "";
				
				// �K�v��NodeList���擾����h�L�������g
				NodeList documents = XmlOperator.getNodeList(job, "Document");
				
				Element document = (Element) documents.item(0);
				
				// �h�L�������g�̒l���擾����
				strtagValue = PartCommon.getTagValue(document, strtagName);
				
				strHtml.append("<SCRIPT language='javascript' src='../../calendarJavascript.jsp'></SCRIPT>\n");
				
				//�������鎞�A�e�L�X�g�{�b�N�X�Ɂ@�V�X�e�����Ԃ�\������
				if (strtagValue == null || strtagValue == ""){
					strHtml.append("<INPUT" + " name='" + strtagName + "' style='" + strtagStyle + "' readonly" + " value='"
					+ getCurTime() + "'");
					
				//��	�������鎞�A�e�L�X�g�{�b�N�X�Ɂ@�擾���鎞�Ԃ�\������
				} else {
					strHtml.append("<INPUT" + " name='" + strtagName + "' style='" + strtagStyle + "' readonly" + " value='"
					+ PartCommon.stringBrowseReturn(strtagValue) + "'");
				}

				// �K�{�ꍇ�����`�F�b�N
				if("mustEdit".equals(configFlg)){	
					
					// �K�{�t���O�i���j
					strHtml.append(" vital='1'>");
					strHtml.append("<FONT color=red>*</FONT>");
				} else {
					
					// �t���O�i���j�Ȃ�
					strHtml.append(" vital='0'>");
				}
				
				strHtml.append("<SPAN>\n");
				strHtml.append("<A href=javascript:show_calendar('" + strtagName + "'); " +
									"onMouseOver=\"window.status='Date Picker';return true;\" " +
									"onMouseOut=\"window.status='';return true;\" border='0'>" +
									"<IMG src='/FlowBuilder/css/calender.gif' border='0'></A>\n");
				strHtml.append("</SPAN>\n");
				
			//�\���ꍇ�����`�F�b�N	
			} else if ("display".equals(configFlg)){

				// �^�O�G�������g���擾����
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�^�O"), 0);
				
				// name�����擾����
				String strtagName = XmlOperator.getAttrValue(tagElement, "name");
				
				// �K�v��NodeList���擾����h�L�������g
				NodeList documents = XmlOperator.getNodeList(job, "Document");

				Element docElement = (Element) documents.item(0);
				
				// �h�L�������g�̒l���擾����
				String strtagValue = PartCommon.getTagValue(docElement, strtagName);
				
				// HTML�^�O�֕ϊ����܂�
				if (strtagValue != null) {
					strHtml.append(PartCommon.stringBrowseReturn(strtagValue));
				}
				
			//��\���ꍇ�����`�F�b�N	
			} else if ("nodisplay".equals(configFlg)) {
				strHtml.append("");
			}
			
			// ���O���o��
			logger.info("�I��");
		} catch (Exception e) {

			// ���O���o��
			logger.fatal("�v���I�ȃG���[");
		}
		
		//HTML��߂�
		return (strHtml);
	}
	
	/**
	 * �V�X�e�����Ԃ��擾����
	 * 
	 * @return�@String
	 */
	private String getCurTime() {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd"); 
		
		return f.format(c.getTime());
	}
}
