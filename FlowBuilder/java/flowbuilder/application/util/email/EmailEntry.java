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
 * メールの内容に操作用のクラス
 */
public class EmailEntry {

	// 回覧状態（”１”）
	private String CIRCULAR = "1";
	
	private Document docEmail = null;
	
	/**
	 * メールBEANの作成
	 */
	EmailEntry() {
		ConfigReader configReader = FlowBuilderSystemConfig.getInstance();
		String emailConfigFilePath = configReader.getValue("Path.Email.Xml.File");

		//データXMLをロードする
		docEmail = DBXmlFileConn.getDocument(emailConfigFilePath);
	}
	
	/**
	 * メールのタイトーを取得
	 * @return
	 */
	public String getTitle() {
		// 必要なNodeListを取得するドキュメント
		Element titElement = XmlOperator.getElement(XmlOperator.getNodeList(docEmail, "emails"), 0);
		
		// 指定情報を取得する
		String titleName = XmlOperator.getAttrValue(titElement, "title");
		
		return titleName;
	}
	
	/**
	 * メール内容を取得する。
	 * 
	 * @return
	 */
	public String getContent(String emailId,String state) {
		int contentLeng;
		String contentValue = "";
		// ドキュメントからノードリストを取得する
		NodeList emails = XmlOperator.getNodeList(docEmail, "email");
		for(int i = 0; i < emails.getLength(); i++) {
			Element email = XmlOperator.getElement(emails, i);
			if(emailId.equals(XmlOperator.getAttrValue(email, "id"))) {
				// ドキュメントからノードリストを取得する
				NodeList contents = XmlOperator.getNodeList(docEmail, "content");
				contentLeng = contents.getLength();
				for(int j = 0; j < contentLeng; j++) {
					Element content = XmlOperator.getElement(contents, j);
					if(state.equals(XmlOperator.getAttrValue(content, "state"))) {
						// ドキュメントからノードリストを取得する
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
	 * CCリストを取得する。
	 * 
	 * @param emailList
	 */
	public String getCCEmailAddres(String emailId,String state) {
		int contentsLeng;
		String ccContent = null;
		// ドキュメントからノードリストを取得する
		NodeList emails = XmlOperator.getNodeList(docEmail, "email");
		for (int i = 0; i < emails.getLength(); i++) {
			Element email = XmlOperator.getElement(emails, i);
			if (emailId.equals(XmlOperator.getAttrValue(email, "id"))) {
				// ドキュメントからノードリストを取得する
				NodeList contents = XmlOperator.getNodeList(docEmail, "content");
				contentsLeng = contents.getLength();
				for (int j = 0; j < contentsLeng; j++) {
					Element content = XmlOperator.getElement(contents, j);
					if (state.equals(XmlOperator.getAttrValue(content, "state"))) {
						// ドキュメントからノードリストを取得する
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
	 * 回覧リストを取得する。
	 * return flg boolean : true(回覧),false(回覧以外).
	 */
	public boolean isCircular(String emailId, String state) {
		boolean flg = false;
		// ドキュメントからノードリストを取得する
		NodeList emails = XmlOperator.getNodeList(docEmail, "email");
		for (int i = 0; i < emails.getLength(); i++) {
			Element email = XmlOperator.getElement(emails, i);
			if (emailId.equals(XmlOperator.getAttrValue(email, "id"))) {
				// ドキュメントからノードリストを取得する
				NodeList contents = XmlOperator.getNodeList(docEmail, "content");
				for (int j = 0; j < contents.getLength(); j++) {
					Element content = XmlOperator.getElement(contents, j);
					if (state.equals(XmlOperator.getAttrValue(content, "state")) && 
							CIRCULAR.equals(XmlOperator.getAttrValue(content, "people"))) {
						// 回覧
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

