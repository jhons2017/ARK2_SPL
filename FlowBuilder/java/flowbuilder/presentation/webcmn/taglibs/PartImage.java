/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/13 BY. YANGZHEN (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import flowbuilder.application.util.JobOprater;
import flowbuilder.application.util.ParseXmlString;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.presentation.webcmn.taglibs.common.PartCommon;

/**
 * IMAGE���i�̐ݒ�
 * 
 * @auther YANGZHEN
 */
public final class PartImage extends PartParent {
	/**
	 * HTML�̍쐬
	 * 
	 * @return StringBuffer
	 */
	protected StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();

		try {
			html.append(partImageHtml(_job, _userId, _partXml));
		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}


	/**
	 * IMAGE���i
	 * 
	 * @param job
	 * @param strUserID
	 * @param strPartXml
	 */
	protected String partImageHtml(Document job, String strUserID, String strPartXml) {
		// ���O���o��
		Log logger = LogFactory.getLog(PartCheckCondition.class);
		logger.info("�C���b�W�̐��\�e�X�g(Start)�F" + PartCommon.getCurTime());
		JobOprater jobOpr = new JobOprater();
		
		// ��������HTML���擾
		String strHtml = "";


		try {
			//���i�w�l�k�h�L�������g�擾����
			Document part = ParseXmlString.getParsedDocument(strPartXml);
			
			// ���O���o��
			logger.info("�J�n");

			// �Č����ݏ�Ԃ��擾
			String strCurState = jobOpr.getCurrentState(job);
	
			
			// ======���ۂ̊m�F======
			Element optElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "option"), 0);
			
			// �w��݂����擾����
			String stroptPath = XmlOperator.getAttrValue(optElement, "path");
			
			// �w��̍��x
			String stroptHeight = XmlOperator.getAttrValue(optElement, "height");
			
			// �w��̍L��
			String stroptwidth = XmlOperator.getAttrValue(optElement, "width");
			
			strHtml = strHtml + "<img width = '" + stroptwidth + "' height = '" + stroptHeight + "' src='" + stroptPath;
			
			// �Č��N�Ă̏��
			if("�Č��N��".equals(strCurState)) {
				strHtml = strHtml + strUserID ; 
			} else {
				strHtml = strHtml + jobOpr.getCreatorID(job) ; 
			}
			
			strHtml = strHtml + ".gif'></img>";
			
			logger.info("�C���b�W�̐��\�e�X�g(END)�F" + PartCommon.getCurTime());
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
