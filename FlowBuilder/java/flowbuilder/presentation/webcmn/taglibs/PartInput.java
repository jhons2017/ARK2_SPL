/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/05/31
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/05/31 BY. chenlei (WXHX)
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
 *  テキスト部品
 *  
 * @author hx0158
 */
public final class PartInput extends PartParent {
	/**
	 * HTMLの作成
	 * 
	 * @return StringBuffer
	 */
	protected StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();
		try {
			html.append(partInputHtml(_job, _orgId, _userId, _partXml));
		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}

	/**
	 * INPUT部品
	 * 
	 * @param job document 案件
	 * @param strOrgID  String  組織ID
	 * @param strUserID String ユーザID
	 * @param strPartXml String 部品XML
	 */
	public StringBuffer partInputHtml(Document job, String strOrgID, String strUserID, String strPartXml) {
		
		//　ローグ
		Log logger = LogFactory.getLog(PartCheckCondition.class);
		JobOprater jobOpr = new JobOprater();
		
		StringBuffer strHtml = new StringBuffer();
		
		try {
			
			// ローグを出力する
			logger.info("開始");

			// 部品ＸＭＬドキュメント取得する
			Document part = ParseXmlString.getParsedDocument(strPartXml);

			// 案件現在状態を取得
			String strCurState = jobOpr.getCurrentState(job);

			// ======非表示の確認======
			// 非表示エレメントを取得する
			Element hiddenElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "非表示"), 0);

			// 操作者指定情報を取得する
			String strhiddenUser = XmlOperator.getAttrValue(hiddenElement, "user");

			// 権限指定情報を取得する
			String strhiddenRole = XmlOperator.getAttrValue(hiddenElement, "role");

			// ======表示の確認======
			// 表示エレメントを取得する
			Element displayElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "表示"), 0);

			// 操作者指定情報を取得する
			String strdisplayUser = XmlOperator.getAttrValue(displayElement, "user");

			// 権限指定情報を取得する
			String strdisplayRole = XmlOperator.getAttrValue(displayElement, "role");

			// ======編集の確認======
			// 非表示エレメントを取得する
			Element editionElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "編集"), 0);
			// 操作者指定情報を取得する
			String streditionUser = XmlOperator.getAttrValue(editionElement, "user");

			// 権限指定情報を取得する
			String streditionRole = XmlOperator.getAttrValue(editionElement, "role");

			// ======必須の確認======
			// 非表示エレメントを取得する
			Element vitalElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "必須"), 0);

			// 操作者指定情報を取得する
			String strvitalUser = XmlOperator.getAttrValue(vitalElement, "user");

			// 権限指定情報を取得する
			String strvitalRole = XmlOperator.getAttrValue(vitalElement, "role");
			
			PartCheckCondition checkCondition = new PartCheckCondition();

			// 編集の場合、権限のチェックを行います。
			if (checkCondition.checkUserCondition(job, strCurState, streditionUser, strUserID)
					|| checkCondition.checkRoleCondition(strCurState, streditionRole, strOrgID, strUserID)) {
				
				// タグのノードを取得する
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "タグ"), 0);

				//　タグの名前の取得する
				String strtagName = XmlOperator.getAttrValue(tagElement, "name");

				//　タグのスタイルの取得する
				String strtagStyle = XmlOperator.getAttrValue(tagElement, "style");

				// 該当項目の値
				String strtagValue = "";

				// 該当案件の状態のドキュメントを取得する
				NodeList documents = XmlOperator.getNodeList(job, "Document"); 

				// 一行目アイテムを取得する
				Element document = (Element) documents.item(0);
				
				//　該当項目の値を取得する
				strtagValue = PartCommon.getTagValue(document, strtagName);
				
				// HTMLを作成する
				strHtml.append("<input" + " name='" + strtagName + "' style='" + strtagStyle + "'" + " value='"
						+ PartCommon.stringBrowseReturn(strtagValue) + "'");
				
				
				// 必須入力の場合、権限のチェックを行います。
				if (checkCondition.checkUserCondition(job, strCurState, strvitalUser, strUserID)
						|| checkCondition.checkRoleCondition(strCurState, strvitalRole, strOrgID, strUserID)) {
					
					//　必須フラグ（＊）を出力する
					strHtml.append(" vital='1'>");
					//strHtml = strHtml + ;
					strHtml.append("<font color=red>*</font>");
				} else {
					
					//　必須フラグ（＊）を出力しない
					strHtml.append( " vital='0'>");
				}
		
			//　表示の場合、権限のチェックを行います。
			} else if (checkCondition.checkUserCondition(job, strCurState, strdisplayUser, strUserID)
					|| checkCondition.checkRoleCondition(strCurState, strdisplayRole, strOrgID, strUserID)) {
				
				// タグのノードを取得する
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "タグ"), 0);

				// タグの名前の取得する
				String strtagName = XmlOperator.getAttrValue(tagElement, "name");
				
				// 該当項目の値
				String strtagValue = "";

				// 該当案件の状態のドキュメントを取得する
				NodeList documents = XmlOperator.getNodeList(job, "Document");

				// 一行目アイテムを取得する
				Element docElement = (Element) documents.item(0);

				// ローグを出力する
				logger.info("partInput");

				// 該当項目の値を取得する
				strtagValue = PartCommon.getTagValue(docElement, strtagName);

				// 取得した値が空ではない、値を画面に表示される
				if (strtagValue != null) {
					strHtml.append(PartCommon.stringBrowseReturn(strtagValue));
				}

			// 非表示の場合、権限をチェックを行います。
			} else if (checkCondition.checkUserCondition(job, strCurState, strhiddenUser, strUserID)
					|| checkCondition.checkRoleCondition(strCurState, strhiddenRole, strOrgID, strUserID)) {
				
				// HTML文を出力しない
				strHtml.append("");
			}

			// ローグを出力する
			logger.info("終了");
		} catch (Exception e) {

			// ローグを出力する
			logger.fatal("致命的なエラー");
		}
		
		// HTML文を返す
		return (strHtml);
	}
}