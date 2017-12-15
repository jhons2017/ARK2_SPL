/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/04 BY. YANGZHEN (WXHX)
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
 * �����N�^���i�̐ݒ�
 * 
 * @auther YANGZHEN
 */
public final class PartSelect extends PartParent {
	/**
	 * HTML�̍쐬
	 * 
	 * @return StringBuffer
	 */
	protected StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();
		try {
			html.append(partSelectHtml(_job, _orgId, _userId, _partXml));
		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}

	/**
	 * �I��OPTION���i
	 * 
	 * @param Document�@job�@�W���u
	 * @param String�@strOrgID�@�g�DID
	 * @param�@String strUserID�@���[�U�[ID
	 * @param strPartXml�@���i������ 
	 * @return string
	 */
	protected StringBuffer partSelectHtml(Document job, String strOrgID, String strUserID, String strPartXml) {		
		// ���O���o��
		Log logger = LogFactory.getLog(PartCheckCondition.class);
		logger.info("Select�̐��\�e�X�g(Start)�F" + PartCommon.getCurTime());
		JobOprater jobOpr = new JobOprater();
		
		// ��������HTML���擾
		StringBuffer strHtml = new StringBuffer();

		try {
			// ���O���o��
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

			// ���������擾����
			String strvitalRole = XmlOperator.getAttrValue(vitalElement, "role");
			
			// ======�I��������e�̍쐬======
			// ���ڏ����擾����
			Element optionArray = XmlOperator.getElement(XmlOperator.getNodeList(part, "option"), 0);
			
			// ���ڒl���擾����
			String optionValue = XmlOperator.getAttrValue(optionArray, "value");
			
			// ���ڒl�ꗗ���擾����
			String[] optionList = optionValue.split(",");

			// ���ږ��̂��擾����
			String optionName = XmlOperator.getAttrValue(optionArray, "name");
			
			// ���ڈꗗ���擾����
			String[] optionNameList = optionName.split(",");
			
			// ======�Œ�̏��======
			// ���̖ٔF����
			Element contentElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "content"), 0);
			// ���̌Œ�ł��� 
			String contentDefalut = XmlOperator.getAttrValue(contentElement, "defalut");

			PartCheckCondition checkCondition = new PartCheckCondition();

			// �ҏW�ꍇ�����`�F�b�N
			if (checkCondition.checkUserCondition(job, strCurState, streditionUser, strUserID)
					|| checkCondition.checkRoleCondition(strCurState, streditionRole, strOrgID, strUserID)) {
				// �ҏW
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�^�O"), 0);

				// ����Ҏw������擾����
				String strtagName = XmlOperator.getAttrValue(tagElement, "name");

				// �K�v��NodeList���擾����h�L�������g
				NodeList documents = XmlOperator.getNodeList(job, "Document");

				// �h�L�������g���擾����
				Element document = (Element) documents.item(0);
				
				// ���i������擾
				String strStatus = PartCommon.getTagValue(document, "operator");

				// ���i�ڂ̑O�ɂ��擾
				String strtagValue = PartCommon.getTagValue(document, strtagName);

				// HTML���쐬
				strHtml.append("<TABLE cellspacing='4' cellpadding='0' border='0'>\n<TD valign='top'>\n").append("<SELECT name='").append(strtagName).append("' size='1'");

				// �K�{�}�b�N
				if (checkCondition.checkUserCondition(job, strCurState, strvitalUser, strUserID)
						|| checkCondition.checkRoleCondition(strCurState, strvitalRole, strOrgID, strUserID)) {
					// �K�{�̏ꍇ
					strHtml.append(" vital='1'>");
				} else {
					// �K�{�łȂ��ꍇ
					strHtml.append(" vital='0'>");
				}

				int size = optionList.length;
				for (int i = 0; i < size; i++) {
					// �ċN�� or �ۑ� HTML���擾
					if ("returnSelf".equals(strStatus) || "save".equals(strStatus) || "return".equals(strStatus)) {
						if (strtagValue.equals(optionList[i])) {
							strHtml.append("<OPTION value='").append(optionList[i]).append("' selected>").append(optionNameList[i]).append("</OPTION>\n");
						} else {
							strHtml.append("<OPTION value='").append(optionList[i]).append("'>").append(optionNameList[i]).append("</OPTION>\n");
						}
					// �����N��
					} else {
						if(contentDefalut.equals(optionList[i])) {
							strHtml.append("<OPTION value='").append(optionList[i]).append("' selected>").append(optionNameList[i]).append("</OPTION>\n");
						} else {
							strHtml.append("<OPTION value='").append(optionList[i]).append("'>").append(optionNameList[i]).append("</OPTION>\n");
						}
					}
				}

				strHtml.append("</SELECT>\n</TD>\n");
				// �K�{�}�b�N
				if (checkCondition.checkUserCondition(job, strCurState, strvitalUser, strUserID)
						|| checkCondition.checkRoleCondition(strCurState, strvitalRole, strOrgID, strUserID)) {
					strHtml.append("<TD><font color=red>*</font></TD>");
				}
				strHtml.append("</TR>\n</TABLE>");
			// �\���ꍇ
			} else if (checkCondition.checkUserCondition(job, strCurState, strdisplayUser, strUserID)
					|| checkCondition.checkRoleCondition(strCurState, strdisplayRole, strOrgID, strUserID)) {
				// �\��
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�^�O"), 0);

				// ����Ҏw������擾����
				String strtagName = XmlOperator.getAttrValue(tagElement, "name");

				// �K�v��NodeList���擾����h�L�������g
				NodeList Documents = XmlOperator.getNodeList(job, "Document"); // �m�b�h���X�g

				
				// ���O���o��
				logger.info("partSelect");

				// �h�L�������g�̒l���擾����
				Element docElement = (Element) Documents.item(0);
				String strtagValue = PartCommon.getTagValue(docElement, strtagName);
				int size = optionList.length;
				for (int i = 0; i < size; i++) {
					if(optionList[i].equals(strtagValue)) {
						strHtml.append(optionNameList[i]);
					}
				}
			// ��\���ꍇ
			} else if (checkCondition.checkUserCondition(job, strCurState, strhiddenUser, strUserID)
					|| checkCondition.checkRoleCondition(strCurState, strhiddenRole, strOrgID, strUserID)) {
				
				strHtml.append("");
			}
			logger.info("Select�̐��\�e�X�g(End)�F" + PartCommon.getCurTime());
			// ���O���o��
			logger.info("�I��");
			
		} catch (Exception e) {
			
			// ���O���o��
			logger.fatal("�v���I�ȃG���[");
			
		}
		
		// HTML��߂�
		return (strHtml);

	}

}
