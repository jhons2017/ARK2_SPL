/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/03/06 BY. CHENBIN (WXHX)
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
 * jobname�̐ݒ�
 * 
 * @author CHENBIN
 */
public final class PartJobName extends PartParent {
	/**
	 * HTML�̍쐬
	 * 
	 * @return StringBuffer
	 */
	protected StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();

		try {
			html.append(partJobNameHtml(_job, _orgId, _userId, _partXml));
		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}

	/**
	 * �Č������i
	 * 
	 * @param Document job �W���u
	 * @param String strOrgID �g�DID
	 * @param String strUserID ���[�U�[ID
	 * @param String strPartXml ���iXML
	 * 
	 * @return String 
	 */
	public StringBuffer partJobNameHtml(Document job, String strOrgID, String strUserID, String strPartXml) {
		
		// ���O���o��
		Log logger = LogFactory.getLog(PartCheckCondition.class);

		JobOprater jobOpr = new JobOprater();
		
		StringBuffer strHtml = new StringBuffer();
		
		String configFlg = super.getShowCase();
	
		try {
			
			// ���O���o��
			logger.info("�J�n");

			// ���i�w�l�k�h�L�������g�擾����
			Document part = ParseXmlString.getParsedDocument(strPartXml);

			// �ҏW�ꍇ�����`�F�b�N
			if("edit".equals(configFlg) || "mustEdit".equals(configFlg)){
				String strJobName = jobOpr.getJobName(job);
				
				// �^�O�G�������g���擾����
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�^�O"), 0);
				
				// style�����擾����
				String strtagStyle = XmlOperator.getAttrValue(tagElement, "style");			

				// Html���o��
				strHtml.append("<INPUT name='fb_jobname' style='" + strtagStyle + "'" + " onBlur=\"chkChar(this.value,'forms[0]','fb_jobname');\" value='" + PartCommon.stringBrowseReturn(strJobName) + "'");

				// �K�{�ꍇ�����`�F�b�N
				if("mustEdit".equals(configFlg)){
					
					//�K�{�t���O�i���j
					strHtml.append(" vital='1'>");
					strHtml.append("<FONT color=red>*</FONT>");
				} else {
					
					//�t���O�i���j�Ȃ�
					strHtml.append(" vital='0'>");
				}
				
			// �\���ꍇ�����`�F�b�N	
			} else if ("display".equals(configFlg)){
				
				//�Č������擾����
				String strJobName = jobOpr.getJobName(job);

				strHtml.append("<label style='word-break:break-all;'>" + PartCommon.stringBrowseReturn(strJobName) + "</label>");
				
			// ��\���ꍇ�����`�F�b�N	
			} else if ("nodisplay".equals(configFlg)) {
				strHtml.append("");
			}
			
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
