/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/05/31 BY. ZHANGXINFENG (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.presentation.webcmn.taglibs.common.PartCommon;

/**
 * �e�L�X�g�G���A���i�̐ݒ�
 * 
 * @auther ZHANGXINFENG
 */
public final class PartTextArea extends PartParent {
	/**
	 * HTML�̍쐬
	 * 
	 * @return StringBuffer
	 */
	protected StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();

		try {
			html.append(partTextAreaHtml(_job, _orgId, _userId, _partXml));
		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}

	/**
	 * �e�L�X�g�G���A���i
	 * 
	 * @param Document�@job�@�W���u
	 * @param String�@strOrgID�@�g�DID
	 * @param�@String strUserID�@���[�U�[ID
	 * @param strPartXml�@���i������ 
	 * 	
	 * @return string
	 */
	StringBuffer partTextAreaHtml(Document job, String strOrgID, String strUserID, String strPartXml) {
		StringBuffer strHtml = new StringBuffer();
		
		String configFlg = super.getShowCase();

		if("display".equals(configFlg) || "edit".equals(configFlg) || "mustEdit".equals(configFlg)){
			// �^�O���擾
			Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�^�O"), 0);

			// �^�O�����擾����
			String strtagName = XmlOperator.getAttrValue(tagElement, "name");

			// �K�v��NodeList���擾����h�L�������g
			NodeList documents = XmlOperator.getNodeList(job, "Document"); 

			Element docElement = (Element) documents.item(0);

			// �h�L�������g�̒l���擾����
			String strtagValue = PartCommon.getTagValue(docElement, strtagName);
			
			if("display".equals(configFlg)) {
				// HTML�^�O�֕ϊ����܂�
				if (strtagValue != null) {
					strHtml.append("<label style='word-break:break-all;'>" + PartCommon.stringBrowseReturn(strtagValue,"\r\n") + "</label>");
				}
			}else if("edit".equals(configFlg) || "mustEdit".equals(configFlg)) {
				// �s�����擾
				String strtagRows = XmlOperator.getAttrValue(tagElement, "rows");

				// �񐔂��擾
				String strtagCols = XmlOperator.getAttrValue(tagElement, "cols");

				// HTML�쐬
				strHtml.append("<TEXTAREA name='" + strtagName + "' rows='" + strtagRows + "' cols='" + strtagCols + "'");
				
				if("mustEdit".equals(configFlg)) {
					strHtml.append(" vital='1'>");
					// �e�X�g���e������
					strHtml.append(PartCommon.stringBrowseReturn(strtagValue) + "</TEXTAREA>");
					// �K�{�t���O(*)
					strHtml.append("<FONT color=red>*</FONT>");
				}else{
					strHtml.append(" vital='0'>");
					// �e�X�g���e������
					strHtml.append(PartCommon.stringBrowseReturn(strtagValue) + "</TEXTAREA>");
				}
			}
		} else if("nodisplay".equals(configFlg)){
			strHtml.append("");
		}

		//�@HTML��߂�
		return (strHtml);
	}
	
	
}
