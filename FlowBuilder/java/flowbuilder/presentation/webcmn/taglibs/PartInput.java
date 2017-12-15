/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/05/31
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/05/31 BY. chenlei (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import flowbuilder.application.util.JobOprater;
import flowbuilder.application.util.ParseXmlString;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.presentation.webcmn.taglibs.common.PartCommon;

/**
 *  �e�L�X�g���i
 *  
 * @author hx0158
 */
public final class PartInput extends PartParent {
	/**
	 * HTML�̍쐬
	 * 
	 * @return StringBuffer
	 */
	protected StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();
		try {
			html.append(partInputHtml(_job, _orgId, _userId, _partXml));
		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}

	/**
	 * INPUT���i
	 * 
	 * @param job document �Č�
	 * @param strOrgID  String  �g�DID
	 * @param strUserID String ���[�UID
	 * @param strPartXml String ���iXML
	 */
	public StringBuffer partInputHtml(Document job, String strOrgID, String strUserID, String strPartXml) {
		
		//�@���[�O
		Log logger = LogFactory.getLog(PartCheckCondition.class);
		JobOprater jobOpr = new JobOprater();
		
		StringBuffer strHtml = new StringBuffer();
		
		try {
			
			// ���[�O���o�͂���
			logger.info("�J�n");

			// ���i�w�l�k�h�L�������g�擾����
			Document part = ParseXmlString.getParsedDocument(strPartXml);

			// �Č����ݏ�Ԃ��擾
			String strCurState = jobOpr.getCurrentState(job);

			// ======��\���̊m�F======
			// ��\���G�������g���擾����
			Element hiddenElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "��\��"), 0);

			// ����Ҏw������擾����
			String strhiddenUser = XmlOperator.getAttrValue(hiddenElement, "user");

			// �����w������擾����
			String strhiddenRole = XmlOperator.getAttrValue(hiddenElement, "role");

			// ======�\���̊m�F======
			// �\���G�������g���擾����
			Element displayElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�\��"), 0);

			// ����Ҏw������擾����
			String strdisplayUser = XmlOperator.getAttrValue(displayElement, "user");

			// �����w������擾����
			String strdisplayRole = XmlOperator.getAttrValue(displayElement, "role");

			// ======�ҏW�̊m�F======
			// ��\���G�������g���擾����
			Element editionElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�ҏW"), 0);
			// ����Ҏw������擾����
			String streditionUser = XmlOperator.getAttrValue(editionElement, "user");

			// �����w������擾����
			String streditionRole = XmlOperator.getAttrValue(editionElement, "role");

			// ======�K�{�̊m�F======
			// ��\���G�������g���擾����
			Element vitalElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�K�{"), 0);

			// ����Ҏw������擾����
			String strvitalUser = XmlOperator.getAttrValue(vitalElement, "user");

			// �����w������擾����
			String strvitalRole = XmlOperator.getAttrValue(vitalElement, "role");
			
			PartCheckCondition checkCondition = new PartCheckCondition();

			// �ҏW�̏ꍇ�A�����̃`�F�b�N���s���܂��B
			if (checkCondition.checkUserCondition(job, strCurState, streditionUser, strUserID)
					|| checkCondition.checkRoleCondition(strCurState, streditionRole, strOrgID, strUserID)) {
				
				// �^�O�̃m�[�h���擾����
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�^�O"), 0);

				//�@�^�O�̖��O�̎擾����
				String strtagName = XmlOperator.getAttrValue(tagElement, "name");

				//�@�^�O�̃X�^�C���̎擾����
				String strtagStyle = XmlOperator.getAttrValue(tagElement, "style");

				// �Y�����ڂ̒l
				String strtagValue = "";

				// �Y���Č��̏�Ԃ̃h�L�������g���擾����
				NodeList documents = XmlOperator.getNodeList(job, "Document"); 

				// ��s�ڃA�C�e�����擾����
				Element document = (Element) documents.item(0);
				
				//�@�Y�����ڂ̒l���擾����
				strtagValue = PartCommon.getTagValue(document, strtagName);
				
				// HTML���쐬����
				strHtml.append("<input" + " name='" + strtagName + "' style='" + strtagStyle + "'" + " value='"
						+ PartCommon.stringBrowseReturn(strtagValue) + "'");
				
				
				// �K�{���͂̏ꍇ�A�����̃`�F�b�N���s���܂��B
				if (checkCondition.checkUserCondition(job, strCurState, strvitalUser, strUserID)
						|| checkCondition.checkRoleCondition(strCurState, strvitalRole, strOrgID, strUserID)) {
					
					//�@�K�{�t���O�i���j���o�͂���
					strHtml.append(" vital='1'>");
					//strHtml = strHtml + ;
					strHtml.append("<font color=red>*</font>");
				} else {
					
					//�@�K�{�t���O�i���j���o�͂��Ȃ�
					strHtml.append( " vital='0'>");
				}
		
			//�@�\���̏ꍇ�A�����̃`�F�b�N���s���܂��B
			} else if (checkCondition.checkUserCondition(job, strCurState, strdisplayUser, strUserID)
					|| checkCondition.checkRoleCondition(strCurState, strdisplayRole, strOrgID, strUserID)) {
				
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
				logger.info("partInput");

				// �Y�����ڂ̒l���擾����
				strtagValue = PartCommon.getTagValue(docElement, strtagName);

				// �擾�����l����ł͂Ȃ��A�l����ʂɕ\�������
				if (strtagValue != null) {
					strHtml.append(PartCommon.stringBrowseReturn(strtagValue));
				}

			// ��\���̏ꍇ�A�������`�F�b�N���s���܂��B
			} else if (checkCondition.checkUserCondition(job, strCurState, strhiddenUser, strUserID)
					|| checkCondition.checkRoleCondition(strCurState, strhiddenRole, strOrgID, strUserID)) {
				
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