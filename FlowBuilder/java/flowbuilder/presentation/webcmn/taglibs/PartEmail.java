/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/05/31
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/05 BY. hewj (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.presentation.webcmn.taglibs.common.PartCommon;

/**
 * メール部品
 * 
 * @author hx0158
 */
public final class PartEmail extends PartParent {
	/**
	 * HTMLの作成
	 * 
	 * @return StringBuffer
	 */
	protected StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();
		try {
			html.append(partEmailHtml(_job, _orgId, _userId, _partXml));
		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}

	/**
	 * INPUT部品
	 * 
	 * @param job
	 *            document 案件
	 * @param strOrgID
	 *            String 組織ID
	 * @param strUserID
	 *            String ユーザID
	 * @param strPartXml
	 *            String 部品XML
	 */
protected StringBuffer partEmailHtml(Document job, String strOrgID, String strUserID, String strPartXml) {
		                           
		// ローグ
		Log logger = LogFactory.getLog(PartCheckCondition.class);
		StringBuffer strHtml = new StringBuffer();
		String strCurrentState = "";

		try {
			
			// ローグを出力する
			logger.info("開始");
			//違いの場合権限チェック
			strCurrentState = getShowCase();
			
			
			// 編集の場合、権限のチェックを行います。
			if ("edit".equals(strCurrentState) || "mustEdit".equals(strCurrentState)) {
				
				// タグのノードを取得する
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "タグ"), 0);

				// タグの名前の取得する
				String strtagName = XmlOperator.getAttrValue(tagElement, "name");

				// タグのスタイルの取得する
				String strtagStyle = XmlOperator.getAttrValue(tagElement, "style");

				// 該当項目の値
				String strtagValue = "";

				// 該当案件の状態のドキュメントを取得する
				NodeList documents = XmlOperator.getNodeList(job, "Document"); 

				// 一行目アイテムを取得する
				Element document = (Element) documents.item(0);
				
				// 該当項目の値を取得する
				strtagValue = PartCommon.getTagValue(document, strtagName);
				
				// HTMLを作成する
				strHtml.append("<input" + " name='" + strtagName + "' style='" + strtagStyle + "'" + " value='"
				+ PartCommon.stringBrowseReturn(strtagValue) + "'");
				
				// 必須入力の場合、権限のチェックを行います。
				if ("mustEdit".equals(strCurrentState)) {
					
					// 必須フラグ（＊）を出力する
					strHtml.append(" vital='1'>");
					strHtml.append("<font color=red>*</font>");
				} else {
					
					// 必須フラグ（＊）を出力しない
					strHtml.append(" vital='0'>");
				}
				
			// 表示の場合、権限のチェックを行います。
			} else if ("display".equals(strCurrentState)) {
				
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
				logger.info("partEmail");

				// 該当項目の値を取得する
				strtagValue = PartCommon.getTagValue(docElement, strtagName);

				// 取得した値が空ではない、値を画面に表示される
				if (strtagValue != null) {
					strHtml.append(PartCommon.stringBrowseReturn(strtagValue));
				}

			// 非表示の場合、権限をチェックを行います。
			} else if ("".equals(strCurrentState)) {
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