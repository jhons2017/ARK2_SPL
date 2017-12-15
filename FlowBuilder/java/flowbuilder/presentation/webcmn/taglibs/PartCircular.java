/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/05/31
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/05/31 BY. hewj (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import flowbuilder.application.user.UserService;
import flowbuilder.application.user.UserServiceFactory;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.presentation.webcmn.taglibs.common.PartCommon;

/**
 * �񗗕��i
 * 
 * @author hx0158
 */
public final class PartCircular extends PartParent {

	/**
	 * HTML�̍쐬
	 * 
	 * @return StringBuffer
	 */
	protected StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();
		try {
			html.append(partCircularHtml(_job, _orgId, _userId));
		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}

	/**
	 * INPUT���i
	 * 
	 * @param job
	 *            document �Č�
	 * @param strOrgID
	 *            String �g�DID
	 * @param strUserID
	 *            String ���[�UID
	 * @param strPartXml
	 *            String ���iXML
	 */
StringBuffer partCircularHtml(Document job, String strOrgID, String strUserID) {
		
		// ���[�O

	Log logger = LogFactory.getLog(PartCheckCondition.class);
 		
 		// HTML�̍쐬
		StringBuffer strHtml = new StringBuffer();
		
		// �����`�F�b�N
		String strCurrentState; 

		try {
			
			// ���[�O���o�͂���
			logger.info("�J�n");
			
			// �Ⴂ�̏ꍇ�����`�F�b�N
			strCurrentState = getShowCase();
			
			// �ҏW�ꍇ�����`�F�b�N
			if ("edit".equals(strCurrentState)
					|| "mustEdit".equals(strCurrentState)) {

				this._partXml = this._partXml.replace("circular", "circularID");
				// �Č�ID���擾
				Element jobInfo = XmlOperator.getElement(XmlOperator
						.getNodeList(job, "jobinfo"), 0);
				String jobId = jobInfo.getAttribute("jobid");
				// HTML���쐬����
				strHtml.append("<IFRAME name='inner' frameborder='0'  width='100%' height='350' src='CircularOperate?method=init");
				strHtml.append("&orgId="+_orgId+ "&jobId=" + jobId + "'></IFRAME>\n");
				strHtml.append("<INPUT type='hidden' name='circularID' value=''>");

				// �\���̏ꍇ�A�����̃`�F�b�N���s���܂��B
			} else if("display".equals(strCurrentState)) {
				// �񗗐l���[�UID
				String userId = "";
				
				// �񗗐l���[�U���O
				String username = "";
				
				// ����t���O
				String problemFlg = "";
				
				// �ӌ��̏���ݒ�
				String addmission = "";
				
				// �m�F�̎��Ԃ�ݒ�
				String confirmDate = "";
				
				// HTML�����o�͂��Ȃ�
				strHtml.append("<table align='center' border='0'  bgcolor='#999999' cellpadding='1' cellspacing='1' width='100%'>\n");
				strHtml.append("<tr bgcolor='#FFFFFF' height='30'>\n");
				strHtml.append("<td colspan='5' align='center'><h3>�񗗏��</h3></td>\n");
				strHtml.append("</tr>\n");
				strHtml.append("<tr bgcolor='#ffffff' height='30' width='100%'>\n");
				strHtml.append("<td align='center' width='20%'><h4>�񗗎�</h4></td>\n");
				strHtml.append("<td align='center' width='40%'><h4>�ӌ�</h4></td>\n");
				strHtml.append("<td align='center' width='10%'><h4>���</h4></td>\n");
				strHtml.append("<td align='center' width='10%'><h4>�m�F����</h4></td>\n");
				strHtml.append("<td align='center' width='10%'><h4>����</h4></td>\n");
				strHtml.append("</tr>\n");
		
				// ���[�U�[�Ǘ��T�[�r�X�̃C���X�^���X���擾����
				UserService _userService = UserServiceFactory.getUserServiceInstance();

				// �Y���Č��̏�Ԃ̃h�L�������g���擾����
				NodeList docList = XmlOperator.getNodeList(job, "Document");
				// �Y���Č��̉񗗂��擾����
				NodeList cirList = XmlOperator.getNodeList(job, "Circular");

				// ��s�ڃA�C�e�����擾����
				Element docElm = (Element) docList.item(0);
				Element circularElm = (Element) cirList.item(0);
				NodeList controlEle = docElm.getElementsByTagName("control");
				
				// ���[�UID���擾����
				NodeList memberList= circularElm.getElementsByTagName("member");
			
				// ���[�U���X�g���擾����
				int len = memberList.getLength();
				for (int i = 0; i < len; i++) {
					// ���[�U�̏�Ԃ��擾����
					Element memberElm = (Element) memberList.item(i);
					userId = memberElm.getAttributeNode("id").getNodeValue();
					// ��Ԃ̎擾
					problemFlg = memberElm.getAttributeNode("problemFlg").getNodeValue();
					confirmDate = memberElm.getAttributeNode("confirmDate").getNodeValue();

					username = (_userService.getUser(userId)).getUserName();
					
					if(userId.equals(strUserID)) {
						for (int j = 0; j < controlEle.getLength(); j++) {
							Element docElement = (Element) controlEle.item(j);
							if (docElement != null) {
								if (userId.equals(docElement.getAttributeNode("id").getNodeValue())) {
									if (docElement.hasChildNodes()) {
										addmission = docElement.getFirstChild().getNodeValue().trim();
										break;
									}
								}
							}
						}
						strHtml.append("<tr bgcolor='#ffffff' height='30'>\n");
						// �e�����i
						strHtml.append("<td align='center'><img width='60' height='60' src='/FlowBuilder/images/userImages/"
								+ userId + ".gif'></img><br>" + username + "</td>\n");
						//�����̉�
						strHtml.append(loginUserSelfHtml(userId,problemFlg,addmission,confirmDate));
						strHtml.append("</tr>\n");
	
					}
				}
				for (int i = 0; i < len; i++) {
					// ���[�U�̏�Ԃ��擾����
					Element memberElm = (Element) memberList.item(i);
					userId = memberElm.getAttributeNode("id").getNodeValue();
					if(!userId.equals(strUserID)) {
						username = (_userService.getUser(userId)).getUserName();
						// ��Ԃ̎擾
						problemFlg = memberElm.getAttributeNode("problemFlg").getNodeValue();
						confirmDate = memberElm.getAttributeNode("confirmDate").getNodeValue();
						for (int j = 0; j < controlEle.getLength(); j++) {
							Element docElement = (Element) controlEle.item(j);
							if (docElement != null) {
								if (userId.equals(docElement.getAttributeNode("id").getNodeValue())) {
									if (docElement.hasChildNodes()) {
										addmission = docElement.getFirstChild().getNodeValue().trim();
										break;
									}
								}
							}
						}
							strHtml.append("<tr bgcolor='#ffffff' height='30'>\n");
							// �e�����i
							strHtml.append("<td align='center'><img width='60' height='60' src='/FlowBuilder/images/userImages/"
									+ userId + ".gif'></img><br>" + username + "</td>\n");
							strHtml.append(otherUsersHtml(userId,problemFlg,addmission,confirmDate));
							strHtml.append("</tr>\n");
					}
				}
				strHtml.append("</table>");
			// ��\���̏ꍇ�A�������`�F�b�N���s���܂��B
			} else if ("".equals(strCurrentState)) {
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

	/**
	 *  ������
	 * @param useId
	 * @param problemFlg
	 * @param addmission
	 * @param�@confirmDate
	 * @return
	 */
	private StringBuffer loginUserSelfHtml(String userId,String problemFlg,String addmission,String confirmDate) {
		
		StringBuffer strHtml = new StringBuffer("");
		
		String status=null;

		// �񗗑҂�
		if ("0".equals(problemFlg)) {
			status = "�񗗑҂�";
			this._partXml = this._partXml.replace("circular",userId);
			this._checkXml = this._checkXml.replace("circular",userId);
			strHtml.append("<td align='left'><TextArea name='"+userId + "' rows='3' cols='32' vital='1'></TextArea><font color='red'>*</font></td>\n");
			strHtml.append("<td align='center'>" + status + "</td>\n");
			strHtml.append("<td align='center'>" + confirmDate + "</td>");
			strHtml.append(strBtnHtml());
			// �񗗍�
		} else if ("3".equals(problemFlg)) {
			status = "������";
			strHtml.append("<td align='left'><label style='word-break:break-all;'>" + PartCommon.stringBrowseReturn(addmission,"\r\n") + "</label></td>\n");						
			strHtml.append("<td align='center'>" + status + "</td>\n");
			strHtml.append("<td align='center'>" + confirmDate + "</td>");
			strHtml.append("<td align='center'></td>\n");
		// �m�F��
		} else if ("1".equals(problemFlg)) {
			// ����
			status = "�m�F��";
			// ������
			this._partXml = this._partXml.replace("circular",userId);
			this._checkXml = this._checkXml.replace("circular",userId);
			strHtml.append("<td align='left'><TextArea name='"+userId + "' rows='3' cols='32' vital='1'>" + addmission + "</TextArea><font color='red'>*</font></td>\n");
			strHtml.append("<td align='center'>" + status + "</td>");
			strHtml.append("<td align='center'>" + confirmDate + "</td>");
			strHtml.append(strBtnHtml());
			
		// ��肠��
		} else {
			status = "<font color='red'>��肠��</font>";

			// ������
			this._partXml = this._partXml.replace("circular",userId);
			this._checkXml = this._checkXml.replace("circular",userId);
		 	strHtml.append("<td align='left'><TextArea name='"+userId + "' rows='3' cols='32' vital='1'>" + addmission + "</TextArea><font color='red'>*</font></td>\n");
			strHtml.append("<td align='center'>" + status + "</td>");
			strHtml.append("<td align='center'>" + confirmDate + "</td>");
			strHtml.append(strBtnHtml());
		}
		return strHtml;
	}
	
	/**
	 * 
	 */
	private StringBuffer otherUsersHtml(String userId,String problemFlg,String addmission,String confirmDate) {
		
		StringBuffer strHtml = new StringBuffer("");
		
		String status=null;
		if("0".equals(problemFlg)) {
			status = "�񗗑҂�";
		} else if("3".equals(problemFlg)) {
			status = "������";
		} else if("1".equals(problemFlg)) {
			status = "�m�F��";
		} else {
			status = "<font color='red'>��肠��</font>";
		}
		// �񗗑҂�
		if ("0".equals(problemFlg)) {
			status = "�񗗑҂�";
			strHtml.append("<td align='left'></td>\n");
			strHtml.append("<td align='center'>" + status + "</td>\n");
			strHtml.append("<td align='center'>" + confirmDate + "</td>");
			strHtml.append("<td align='center'></td>\n");
			
		} else {
			// �����̂ق��ɉ�
			strHtml.append("<td align='left'><label style='word-break:break-all;'>" + PartCommon.stringBrowseReturn(addmission,"\r\n") + "</label></td>\n");						
			strHtml.append("<td align='center'>" + status + "</td>\n");
			strHtml.append("<td align='center'>" + confirmDate + "</td>");
			strHtml.append("<td align='center'></td>\n");
		}
		return strHtml;
	}
	
	/**
	 * �{�^���̂����������쐬
	 * 
	 * @return
	 */
	private StringBuffer strBtnHtml() {

		// �{�^���̂����������쐬
		StringBuffer btnHtml = new StringBuffer();

		// �{�^�����O
		String btnName = "";

		// �{�^���̕\��
		String btnValue = "";

		// �{�^���O���v�̃G�������g���擾����
		Element btn_group = XmlOperator.getElement(XmlOperator.getNodeList(
				part, "�{�^���O���v"), 0);
		// �{�^���̃m�h���X�g
		NodeList btn_node = btn_group.getElementsByTagName("button");

		btnHtml.append("<td><table><tr>");
		// �{�^���̂��������𓮑ԍ쐬
		int len = btn_node.getLength();
		for (int i = 0; i < len; i++) {
			Element btnEle = (Element) btn_node.item(i);
			// �{�^�����O
			btnName = XmlOperator.getAttrValue(btnEle, "name");
			// �{�^���̕\��
			btnValue = XmlOperator.getAttrValue(btnEle, "value");
			btnHtml.append("<td bordercolor='#FFFFFF' align='center' nowrap>\n");
			btnHtml.append("<input name='" + btnName
					+ "' type='button' value='" + btnValue
					+ "' valign='center'  onclick=javascript:checkform('"
					+ btnName + "','save','1');>");
			btnHtml.append("</td>\n");
		}
		btnHtml.append("</tr></table></td>");
		return btnHtml;
	}
}