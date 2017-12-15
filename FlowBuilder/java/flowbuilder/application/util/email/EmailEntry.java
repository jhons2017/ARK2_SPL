/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/06/13
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/13 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.application.util.email;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import fbcom.framework.dao.conf.ConfigReader;
import flowbuilder.dao.conf.FlowBuilderSystemConfig;
import flowbuilder.daoimpl.db.DBXmlFileConn;
import flowbuilder.daoimpl.db.XmlOperator;

/**
 * ���[���̓��e�ɑ���p�̃N���X
 */
public class EmailEntry {

	// �񗗏�ԁi�h�P�h�j
	private String CIRCULAR = "1";
	
	private Document docEmail = null;
	
	/**
	 * ���[��BEAN�̍쐬
	 */
	EmailEntry() {
		ConfigReader configReader = FlowBuilderSystemConfig.getInstance();
		String emailConfigFilePath = configReader.getValue("Path.Email.Xml.File");

		//�f�[�^XML�����[�h����
		docEmail = DBXmlFileConn.getDocument(emailConfigFilePath);
	}
	
	/**
	 * ���[���̃^�C�g�[���擾
	 * @return
	 */
	public String getTitle() {
		// �K�v��NodeList���擾����h�L�������g
		Element titElement = XmlOperator.getElement(XmlOperator.getNodeList(docEmail, "emails"), 0);
		
		// �w������擾����
		String titleName = XmlOperator.getAttrValue(titElement, "title");
		
		return titleName;
	}
	
	/**
	 * ���[�����e���擾����B
	 * 
	 * @return
	 */
	public String getContent(String emailId,String state) {
		int contentLeng;
		String contentValue = "";
		// �h�L�������g����m�[�h���X�g���擾����
		NodeList emails = XmlOperator.getNodeList(docEmail, "email");
		for(int i = 0; i < emails.getLength(); i++) {
			Element email = XmlOperator.getElement(emails, i);
			if(emailId.equals(XmlOperator.getAttrValue(email, "id"))) {
				// �h�L�������g����m�[�h���X�g���擾����
				NodeList contents = XmlOperator.getNodeList(docEmail, "content");
				contentLeng = contents.getLength();
				for(int j = 0; j < contentLeng; j++) {
					Element content = XmlOperator.getElement(contents, j);
					if(state.equals(XmlOperator.getAttrValue(content, "state"))) {
						// �h�L�������g����m�[�h���X�g���擾����
						contentValue = content.getFirstChild().getNodeValue();
						break;
					}
				}
				break;
			}
		}
		return contentValue;
	}

	/**
	 * CC���X�g���擾����B
	 * 
	 * @param emailList
	 */
	public String getCCEmailAddres(String emailId,String state) {
		int contentsLeng;
		String ccContent = null;
		// �h�L�������g����m�[�h���X�g���擾����
		NodeList emails = XmlOperator.getNodeList(docEmail, "email");
		for (int i = 0; i < emails.getLength(); i++) {
			Element email = XmlOperator.getElement(emails, i);
			if (emailId.equals(XmlOperator.getAttrValue(email, "id"))) {
				// �h�L�������g����m�[�h���X�g���擾����
				NodeList contents = XmlOperator.getNodeList(docEmail, "content");
				contentsLeng = contents.getLength();
				for (int j = 0; j < contentsLeng; j++) {
					Element content = XmlOperator.getElement(contents, j);
					if (state.equals(XmlOperator.getAttrValue(content, "state"))) {
						// �h�L�������g����m�[�h���X�g���擾����
						ccContent = XmlOperator.getAttrValue(content, "cc");
						break;
					}
				}
				break;
			}
		}
		return ccContent;
	}
	
	/**
	 * �񗗃��X�g���擾����B
	 * return flg boolean : true(��),false(�񗗈ȊO).
	 */
	public boolean isCircular(String emailId, String state) {
		boolean flg = false;
		// �h�L�������g����m�[�h���X�g���擾����
		NodeList emails = XmlOperator.getNodeList(docEmail, "email");
		for (int i = 0; i < emails.getLength(); i++) {
			Element email = XmlOperator.getElement(emails, i);
			if (emailId.equals(XmlOperator.getAttrValue(email, "id"))) {
				// �h�L�������g����m�[�h���X�g���擾����
				NodeList contents = XmlOperator.getNodeList(docEmail, "content");
				for (int j = 0; j < contents.getLength(); j++) {
					Element content = XmlOperator.getElement(contents, j);
					if (state.equals(XmlOperator.getAttrValue(content, "state")) && 
							CIRCULAR.equals(XmlOperator.getAttrValue(content, "people"))) {
						// ��
						flg = true;
						break;
					}
				}
				break;
			}
		}
		return flg;
	}
}

