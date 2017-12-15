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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;

/**
 * partDate�̐ݒ�
 * 
 * @author CHENBIN
 */
public final class PartPrint extends PartParent {
	


	/**
	 * HTML�̍쐬
	 * 
	 * @return StringBuffer
	 */
    protected StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();

		try {
			html.append(partPrintHtml(_job, _orgId, _userId, _partXml));
		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}

	/**
	 * ������i
	 * 
	 * @param Document job �W���u
	 * @param String strOrgID �g�DID
	 * @param String strUserID ���[�U�[ID
	 * @param String strPartXml ���iXML
	 * 
	 * @return String 
	 */
	public StringBuffer partPrintHtml(Document job, String strOrgID, String strUserID, String strPartXml) {
		
		// ���O���o��
		Log logger = LogFactory.getLog(PartCheckCondition.class);
		
		StringBuffer strHtml = new StringBuffer();
		
		String configFlg = super.getShowCase();
	
		try {
			
			// ���O���o��
			logger.info("�J�n");

			// �\���ꍇ�����`�F�b�N
			if("display".equals(configFlg)) {
				
				strHtml.append("<SCRIPT LANGUAGE=javascript>\n"); 
				strHtml.append("function changeAction() {\n"); 
				strHtml.append("document.forms[0].action = 'JobPrint';\n");
				strHtml.append("document.forms[0].submit();\n");
				strHtml.append("}\n"); 
				strHtml.append("</SCRIPT>\n");
				strHtml.append("<INPUT type='button' name='print' value='��@��' onclick='changeAction()'>\n");
				

			// ��\���ꍇ�����`�F�b�N	
			} else {
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
	
}
