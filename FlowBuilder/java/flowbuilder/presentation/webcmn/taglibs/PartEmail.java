/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/05/31
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/05 BY. hewj (WXHX)
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

/**
 * ���[�����i
 * 
 * @author hx0158
 */
public final class PartEmail extends PartParent {
	/**
	 * HTML�̍쐬
	 * 
	 * @return StringBuffer
	 */
	protected StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();
		try {
			html.append(partEmailHtml(_job, _orgId, _userId, _partXml));
		} catch (java.lang.Exception e) {
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
protected StringBuffer partEmailHtml(Document job, String strOrgID, String strUserID, String strPartXml) {
		                           
		// ���[�O
		Log logger = LogFactory.getLog(PartCheckCondition.class);
		StringBuffer strHtml = new StringBuffer();
		String strCurrentState = "";

		try {
			
			// ���[�O���o�͂���
			logger.info("�J�n");
			//�Ⴂ�̏ꍇ�����`�F�b�N
			strCurrentState = getShowCase();
			
			
			// �ҏW�̏ꍇ�A�����̃`�F�b�N���s���܂��B
			if ("edit".equals(strCurrentState) || "mustEdit".equals(strCurrentState)) {
				
				// �^�O�̃m�[�h���擾����
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�^�O"), 0);

				// �^�O�̖��O�̎擾����
				String strtagName = XmlOperator.getAttrValue(tagElement, "name");

				// �^�O�̃X�^�C���̎擾����
				String strtagStyle = XmlOperator.getAttrValue(tagElement, "style");

				// �Y�����ڂ̒l
				String strtagValue = "";

				// �Y���Č��̏�Ԃ̃h�L�������g���擾����
				NodeList documents = XmlOperator.getNodeList(job, "Document"); 

				// ��s�ڃA�C�e�����擾����
				Element document = (Element) documents.item(0);
				
				// �Y�����ڂ̒l���擾����
				strtagValue = PartCommon.getTagValue(document, strtagName);
				
				// HTML���쐬����
				strHtml.append("<input" + " name='" + strtagName + "' style='" + strtagStyle + "'" + " value='"
				+ PartCommon.stringBrowseReturn(strtagValue) + "'");
				
				// �K�{���͂̏ꍇ�A�����̃`�F�b�N���s���܂��B
				if ("mustEdit".equals(strCurrentState)) {
					
					// �K�{�t���O�i���j���o�͂���
					strHtml.append(" vital='1'>");
					strHtml.append("<font color=red>*</font>");
				} else {
					
					// �K�{�t���O�i���j���o�͂��Ȃ�
					strHtml.append(" vital='0'>");
				}
				
			// �\���̏ꍇ�A�����̃`�F�b�N���s���܂��B
			} else if ("display".equals(strCurrentState)) {
				
				// �^�O�̃m�[�h���擾����
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�^�O"), 0);

				// �^�O�̖��O�̎擾����
				String strtagName = XmlOperator.getAttrValue(tagElement, "name");
				
				// �Y�����ڂ̒l
				String strtagValue = "";

				// �Y���Č��̏�Ԃ̃h�L�������g���擾����
				NodeList documents = XmlOperator.getNodeList(job, "Document");

				// ��s�ڃA�C�e�����擾����
				Element docElement = (Element) documents.item(0);

				// ���[�O���o�͂���
				logger.info("partEmail");

				// �Y�����ڂ̒l���擾����
				strtagValue = PartCommon.getTagValue(docElement, strtagName);

				// �擾�����l����ł͂Ȃ��A�l����ʂɕ\�������
				if (strtagValue != null) {
					strHtml.append(PartCommon.stringBrowseReturn(strtagValue));
				}

			// ��\���̏ꍇ�A�������`�F�b�N���s���܂��B
			} else if ("".equals(strCurrentState)) {
				// HTML�����o�͂��Ȃ�
				strHtml.append("");
			}
			// ���[�O���o�͂���
			logger.info("�I��");
		} catch (Exception e) {

			// ���[�O���o�͂���
			logger.fatal("�v���I�ȃG���[");
		}
		
		// HTML����Ԃ�
		return (strHtml);
	}
}