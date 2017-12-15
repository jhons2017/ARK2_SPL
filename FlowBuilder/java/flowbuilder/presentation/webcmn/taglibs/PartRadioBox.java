/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/01 BY. ZHANGXINFENG (WXHX)
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
 * ���W�I�{�b�N�X���i�̐ݒ�
 * 
 * @auther ZHANGXINFENG
 */
public final class PartRadioBox extends PartParent {

	/**
	 * HTML�̍쐬
	 * 
	 * @return StringBuffer
	 */
	protected StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();

		try {
			html.append(partRadioBoxHtml(_job, _orgId, _userId, _partXml));
		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}

	/**
	 * ���W�I�{�b�N�X���i
	 * 
	 * @param Document�@job�@�W���u
	 * @param String�@strOrgID�@�g�DID
	 * @param�@String strUserID�@���[�U�[ID
	 * @param strPartXml�@���i������ 
	 */
	protected StringBuffer partRadioBoxHtml(Document job, String strOrgID, String strUserID, String strPartXml) {
		
		// ���O���o��
		Log logger = LogFactory.getLog(PartCheckCondition.class);

		// ��������HTML���擾
		StringBuffer strHtmlFirst = new StringBuffer();
		String configFlg = super.getShowCase();
		try {
			// ���i�w�l�k�h�L�������g�擾����
			Document part = ParseXmlString.getParsedDocument(strPartXml);
			
			// ���O���o��
			logger.info("�J�n");

			// content�G�������g���擾����
			Element contentElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "content"), 0);

			// ����Ҏw������擾����
			String strcontentName = XmlOperator.getAttrValue(contentElement, "name");

			// �ٔF�����擾����
			String strcontentDefalut = XmlOperator.getAttrValue(contentElement, "defalut");

			
			// �ҏW�ꍇ�����`�F�b�N
			if ("edit".equals(configFlg) || "mustEdit".equals(configFlg)) {
				
				// �^�O���擾
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�^�O"), 0);

				// �^�O�����擾
				String strtagName = XmlOperator.getAttrValue(tagElement, "name");
				
				String strtagStyle = XmlOperator.getAttrValue(tagElement, "style");
				
				//�@���ڒl�ꗗ���擾����
				String[] strtagContent = strcontentName.split(",");
				
				// ���x���擾����
				int length = strtagContent.length;

				// �K�v��NodeList���擾����h�L�������g
				NodeList documents = XmlOperator.getNodeList(job, "Document"); 

				// �h�L�������g���擾����
				Element document = (Element) documents.item(0);
				
				// �^�O���e���擾
				String strtagValue = PartCommon.getTagValue(document, strtagName);
								
				for (int k = 0; k < length; k++) {
					// �񏉊����鎞
					if (!"".equals(strtagValue)) {
						if(strtagValue.equals(strtagContent[k])) {
							strHtmlFirst.append("<INPUT type='radio' checked" + " name='" + strtagName + "' style='" + strtagStyle + "'" + "' value ='" + strtagContent[k] + "'>");
						} else {
							strHtmlFirst.append("<INPUT type='radio'" + " name='" + strtagName + "' style='" + strtagStyle + "'" + "' value ='" + strtagContent[k] + "'>");
					    }
					// �������鎞
					} else {				
						if (strcontentDefalut.equals(strtagContent[k])) {
							strHtmlFirst.append("<INPUT type='radio' checked" + " name='" + strtagName + "' style='" + strtagStyle + "'" + "' value ='" + strtagContent[k] + "'>");
						} else {
							strHtmlFirst.append("<INPUT type='radio'" + " name='" + strtagName + "' style='" + strtagStyle + "'" + "' value ='" + strtagContent[k] + "'>");							
						} 
					}
					// �K�{�}�b�N
					if ("mustEdit".equals(configFlg)) {
						strHtmlFirst.append(strtagContent[k]);											
					} else {
						strHtmlFirst.append(strtagContent[k]);
					}
				}
				
			// �\���ꍇ�����`�F�b�N
			} else if("display".equals(configFlg)) {
		
				// �K�v��NodeList���擾����h�L�������g
				NodeList documents = XmlOperator.getNodeList(job, "Document"); 

				// �h�L�������g���擾����
				Element document = (Element) documents.item(0);
				
				// �^�O���擾����
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�^�O"), 0);

				// �^�O�����擾����
				String strtagName = XmlOperator.getAttrValue(tagElement, "name");			

					//�@���i���e���擾����
				String strtagValue = PartCommon.getTagValue(document, strtagName);
					
				strHtmlFirst.append(strtagValue);
				
			
			// ��\���ꍇ�����`�F�b�N
			} else  if ("nodisplay".equals(configFlg)) {
				// ��\��
				strHtmlFirst.append("");
			}

			// logger�I��
			logger.info("�I��");
		} catch (Exception e) {
			
			// ���O�G��
			logger.fatal("�v���I�ȃG���[");
		}

		// HTML��߂�
		return strHtmlFirst;
	}
}