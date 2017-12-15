/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/09 BY. ZHANGXINFENG (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import flowbuilder.application.util.ParseXmlString;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.presentation.webcmn.taglibs.common.PartCommon;

/**
 * AMOUNT���i�̐ݒ�
 * 
 * @auther ZHANGXINFENG
 */
public final class PartAmount extends PartParent {
	/**
	 * HTML�̍쐬
	 * 
	 * @return StringBuffer
	 */
	protected StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();

		try {
			html.append(partAmountHtml(_job, _orgId, _userId, _partXml));
		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}

	/**
	 * AMOUNT���i
	 * 
	 * 
	 * @param Document
	 *            job �W���u
	 * @param String
	 *            strOrgID �g�DID
	 * @param String
	 *            strUserID ���[�U�[ID
	 * @param strPartXml
	 *            ���i������
	 */
	StringBuffer partAmountHtml(Document job, String strOrgID, String strUserID, String strPartXml) {
		// �i���ۏ�
		Log logger = LogFactory.getLog(PartCheckCondition.class);

		StringBuffer strHtml = new StringBuffer();
		
		String configFlg = super.getShowCase();

		try {

			// �i���ۏ�
			logger.info("�J�n");

			// ���i�w�l�k�h�L�������g�擾����
			Document part = ParseXmlString.getParsedDocument(strPartXml);

			// �ҏW�ꍇ�����`�F�b�N
			if ("edit".equals(configFlg) || "mustEdit".equals(configFlg)) {

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
				strHtml.append("<INPUT" + " name='" + strtagName
						+ "' onBlur=\"csNumChk('"+ strtagName + "')\" style='"
						+ strtagStyle + "'" + " value='" + PartCommon.stringBrowseReturn(strtagValue) + "'");

				// �K�{���͂̏ꍇ�A�����̃`�F�b�N���s���܂��B
				if ("mustEdit".equals(configFlg)) {

					// �K�{�t���O�i���j���o�͂���
					strHtml.append(" vital='1'>");
					strHtml.append("<FONT color=red>*</FONT>");
				} else {

					// �K�{�t���O�i���j���o�͂��Ȃ�
					strHtml.append(" vital='0'>");
				}

				// �\���̏ꍇ�A�����̃`�F�b�N���s���܂��B
			} else if ("display".equals(configFlg)) {

				// �\��
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�^�O"), 0);

				// �^�O�����擾����
				String strtagName = XmlOperator.getAttrValue(tagElement, "name");

				String strtagValue = "";

				// �K�v��NodeList���擾����h�L�������g
				NodeList Documents = XmlOperator.getNodeList(job, "Document");

				// �h�L�������g���擾����
				Element docElement = (Element) Documents.item(0);

				logger.info("partAmount");

				// �h�L�������g�̒l���擾����
				strtagValue = PartCommon.getTagValue(docElement, strtagName);

				if (strtagValue != null) {
					
					strHtml.append(PartCommon.stringBrowseReturn(strtagValue));
				
				}
				// ��\���ꍇ�����`�F�b�N
			} else if("nodisplay".equals(configFlg)) {
				// ��\��
				strHtml.append("");
			}

			// �i���ۏ�
			logger.info("�I��");
		}

		catch (Exception e) {

			// �i���ۏ�
			logger.fatal("�v���I�ȃG���[");
		}

		return (strHtml);

	}
}
