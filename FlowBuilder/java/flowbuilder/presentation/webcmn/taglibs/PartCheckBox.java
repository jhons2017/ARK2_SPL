/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/01 BY. YANGZHEN (WXHX)
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
 * CHECKBOX���i�̐ݒ�
 * 
 * @auther YANGZHEN
 */
public final class PartCheckBox extends PartParent {
	/**
	 * HTML�̍쐬
	 * 
	 * @return StringBuffer
	 */
	protected StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();

		try {
			html.append(partCheckBoxHtml(_job, _orgId, _userId, _partXml));
		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}


	/**
	 * CHECKBOX���i
	 * 
	 * @param job
	 * @param strOrgID
	 * @param strUserID
	 * @param strPartXml
	 */
	protected StringBuffer partCheckBoxHtml(Document job, String strOrgID, String strUserID, String strPartXml) {
		// ���O���o��
		Log logger = LogFactory.getLog(PartCheckCondition.class);

		logger.info("�`�F�b�N�{�b�N�X�̐��\�e�X�g�iStart�j�F" + PartCommon.getCurTime());
		
		JobOprater jobOpr = new JobOprater();
		
		// ��������HTML���擾
		StringBuffer strHtml = new StringBuffer();

		// �N�Ă̏�Ԕ���
		boolean flg = false;

		try {
			//���i�w�l�k�h�L�������g�擾����
			Document part = ParseXmlString.getParsedDocument(strPartXml);
			
			// ���O���o��
			logger.info("�J�n");

			// �Č����ݏ�Ԃ��擾
			String strCurState = jobOpr.getCurrentState(job);

			// ======�^�O�̊m�F======
			// �^�O�G�������g���擾����
			Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�^�O"), 0);

			// �w������擾����
			String strtagName = XmlOperator.getAttrValue(tagElement, "name");
			
			// �w��l�����擾����
			String strtagStyle = XmlOperator.getAttrValue(tagElement, "style");
			
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
			
			// ��\���G�������g���擾����
			Element contentElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "content"), 0);

			// ���̖ٔF����
			String contentName = XmlOperator.getAttrValue(contentElement, "name");

			// �ٔF�����擾����
			String contentDefalut = XmlOperator.getAttrValue(contentElement, "defalut");
			

			// �����`�F�b�N
			PartCheckCondition checkCondition = new PartCheckCondition();
			
			// ���ږ��̂��擾����
			String[] strtagContent = contentName.split(",");
			
			// �^�O���̂��擾����
			String[] strrName= strtagName.split("/");
			
			int length = strtagContent.length;

			// �K�v��NodeList���擾����h�L�������g
			NodeList documents = XmlOperator.getNodeList(job, "Document"); 

			// �h�L�������g���擾����
			Element document = (Element) documents.item(0);
			
			// ���i������擾
			String strStatus = PartCommon.getTagValue(document, "operator");

			// �ҏW�ꍇ�����`�F�b�N
			if (checkCondition.checkUserCondition(job, strCurState, streditionUser, strUserID)
					|| checkCondition.checkRoleCondition(strCurState, streditionRole, strOrgID, strUserID)) {
				
				for (int k = 0; k < length; k++) {
					// ���i���e���擾����
					String strtagValue = PartCommon.getTagValue(document, strrName[k]);
					
					String createrId = jobOpr.getCreatorID(job);
					
					// �N�Č� or �ۑ� HTML���擾
					if (!"".equals(createrId)) {
						// �L�^���擾����
						if ("on".equals(strtagValue)){
							strHtml.append("<INPUT type='checkbox' checked ");
						} else {
							strHtml.append("<INPUT type='checkbox'");
						}
					// ��������HTML���擾
					} else {
						// �ٔF���擾����
						if (strtagContent[k].equals(contentDefalut)) {
							strHtml.append("<INPUT type='checkbox' checked ");
						} else {
							strHtml.append("<INPUT type='checkbox'");
						}
					}
					strHtml.append(" name='").append(strrName[k]).append("' style='").append(strtagStyle).append("'").append(" vital='0'>").append(strtagContent[k]);
				}
			//�\��
			} else if (checkCondition.checkUserCondition(job, strCurState, strdisplayUser, strUserID)
					|| checkCondition.checkRoleCondition(strCurState, strdisplayRole, strOrgID, strUserID)) {
			
				for (int k = 0; k < length; k++) {
					
					strHtml.append("<INPUT type='checkbox'").append(" name='").append(strrName[k]).append("' style='").append(strtagStyle).append("'");
					
					//�@���i���e���擾����
					String strtagValue = PartCommon.getTagValue(document, strrName[k]);
					
					// �h�L�������g�̒l���擾����
					if (!"".equals(strtagValue)) {
						strHtml.append("  checked disabled='true' vital='0'>").append(strtagContent[k]);
					} else {
						strHtml.append(" disabled='true' vital='0'>").append(strtagContent[k]);
					}
				}
			// ��\��
			} else if (checkCondition.checkUserCondition(job, strCurState, strhiddenUser, strUserID)
					|| checkCondition.checkRoleCondition(strCurState, strhiddenRole, strOrgID, strUserID)) {
				strHtml.append("");
			}
			
			logger.info("�`�F�b�N�{�b�N�X�̐��\�e�X�g�iEND�j�F" + PartCommon.getCurTime());
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
