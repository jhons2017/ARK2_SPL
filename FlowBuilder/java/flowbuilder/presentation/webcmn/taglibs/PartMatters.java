/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/08/01 BY. ZHANGXINFENG (WXHX)
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
 *  ���X���i�̐ݒ�
 * 
 * @auther ZHANGXINFENG
 */
public final class PartMatters extends PartParent {

	/**
	 * HTML�̍쐬
	 * 
	 * @return StringBuffer
	 */
	protected StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();

		try {
			html.append(partMattersHtml(_job, _orgId, _userId, _partXml));
		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}

	/**
	 * ���X���i
	 * 
	 * @param job document �Č�
	 * @param strOrgID  String  �g�DID
	 * @param strUserID String ���[�UID
	 * @param strPartXml String ���iXML
	 */
	String partMattersHtml(Document job, String strOrgID, String strUserID,
			String strPartXml) {

		// ���O���o��
		Log logger = LogFactory.getLog(PartUpload.class);
		String strHtml = "";
		String strtagValue = "";
		
		try {

			// �i���ۏ�
			logger.info("�J�n");

			// ���i�w�l�k�h�L�������g�擾����
			Document part = ParseXmlString.getParsedDocument(strPartXml);
			String configFlg = super.getShowCase();

			// �ҏW�̏ꍇ�A�����̃`�F�b�N���s���܂��B
			if ("edit".equals(configFlg) || "mustEdit".equals(configFlg)) {
				
				
				// �ҏW�̏ꍇ�AHTML�쐬
				strHtml = strHtml + "<input name='button' type= button onClick='additem(\"tb\")' value='�ǉ�'>\n"
									+ " <table id=\"tb\">\n"
									+ "</table>\n";
									
				// �K�v��NodeList���擾����h�L�������g
			/*	NodeList documents = XmlOperator.getNodeList(job, "Document");

				// �h�L�������g���擾����
				Element document = (Element) documents.item(0);

				// �^�O���擾����
				Element tagElement = XmlOperator.getElement(XmlOperator
						.getNodeList(part, "�^�O"), 0);

				// �^�O�����擾����
				String strtagName = XmlOperator
						.getAttrValue(tagElement, "name");

				String[] tokens = strtagName.split("/");

				// �Y�����ڂ̒l���擾����
				for (int i = 0; i < tokens.length; i++) {

					strtagValue = PartCommon.getTagValue(document, tokens[i]);

					// �擾�����l����ł͂Ȃ��A�l����ʂɕ\�������
					if (!"".equals(strtagValue)) {

						strHtml = strHtml + "<input type='text' name='" + tokens[i] + "' value = '" + strtagValue + "'>"
						+ "<input type='button' value='�폜' onclick=\"deleteitem(this,'tb');\">\n"
						+ "<br>\n" ;
					}
				}*/

				//�@�\���̏ꍇ�A�����̃`�F�b�N���s���܂��B
				
			} else if ("display".equals(configFlg)) {

				// �K�v��NodeList���擾����h�L�������g
				NodeList documents = XmlOperator.getNodeList(job, "Document");

				// �h�L�������g���擾����
				Element document = (Element) documents.item(0);

				// �^�O���擾����
				Element tagElement = XmlOperator.getElement(XmlOperator
						.getNodeList(part, "�^�O"), 0);

				// �^�O�����擾����
				String strtagName = XmlOperator.getAttrValue(tagElement, "name");

				String[] tokens = strtagName.split("/");

				// �Y�����ڂ̒l���擾����
				for (int i = 0; i < tokens.length; i++) {
					
					

					strtagValue = PartCommon.stringBrowseReturn(PartCommon.getTagValue(document, tokens[i]));

					// �擾�����l����ł͂Ȃ��A�l����ʂɕ\�������
					if (!"".equals(strtagValue)) {

						strHtml = strHtml + "<label style='word-break:break-all;'>" + strtagValue + "</label><BR>";
					}
				}

			} else {

				// HTML�����o�͂��Ȃ�
				strHtml = "";
			}

			// �i���ۏ�
			logger.info("�I��");
		}

		catch (Exception e) {

			// �i���ۏ�
			logger.fatal("�v���I�ȃG���[");
			e.printStackTrace();
		}

		// HTML��߂�
		return (strHtml);
	}
}
