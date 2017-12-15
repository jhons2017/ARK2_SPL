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
 * AMOUNT部品の設定
 * 
 * @auther ZHANGXINFENG
 */
public final class PartAmount extends PartParent {
	/**
	 * HTMLの作成
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
	 * AMOUNT部品
	 * 
	 * 
	 * @param Document
	 *            job ジョブ
	 * @param String
	 *            strOrgID 組織ID
	 * @param String
	 *            strUserID ユーザーID
	 * @param strPartXml
	 *            部品ｘｍｌ
	 */
	StringBuffer partAmountHtml(Document job, String strOrgID, String strUserID, String strPartXml) {
		// 品質保証
		Log logger = LogFactory.getLog(PartCheckCondition.class);

		StringBuffer strHtml = new StringBuffer();
		
		String configFlg = super.getShowCase();

		try {

			// 品質保証
			logger.info("開始");

			// 部品ＸＭＬドキュメント取得する
			Document part = ParseXmlString.getParsedDocument(strPartXml);

			// 編集場合権限チェック
			if ("edit".equals(configFlg) || "mustEdit".equals(configFlg)) {

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
				strHtml.append("<INPUT" + " name='" + strtagName
						+ "' onBlur=\"csNumChk('"+ strtagName + "')\" style='"
						+ strtagStyle + "'" + " value='" + PartCommon.stringBrowseReturn(strtagValue) + "'");

				// 必須入力の場合、権限のチェックを行います。
				if ("mustEdit".equals(configFlg)) {

					// 必須フラグ（＊）を出力する
					strHtml.append(" vital='1'>");
					strHtml.append("<FONT color=red>*</FONT>");
				} else {

					// 必須フラグ（＊）を出力しない
					strHtml.append(" vital='0'>");
				}

				// 表示の場合、権限のチェックを行います。
			} else if ("display".equals(configFlg)) {

				// 表示
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "タグ"), 0);

				// タグ名を取得する
				String strtagName = XmlOperator.getAttrValue(tagElement, "name");

				String strtagValue = "";

				// 必要なNodeListを取得するドキュメント
				NodeList Documents = XmlOperator.getNodeList(job, "Document");

				// ドキュメントを取得する
				Element docElement = (Element) Documents.item(0);

				logger.info("partAmount");

				// ドキュメントの値を取得する
				strtagValue = PartCommon.getTagValue(docElement, strtagName);

				if (strtagValue != null) {
					
					strHtml.append(PartCommon.stringBrowseReturn(strtagValue));
				
				}
				// 非表示場合権限チェック
			} else if("nodisplay".equals(configFlg)) {
				// 非表示
				strHtml.append("");
			}

			// 品質保証
			logger.info("終了");
		}

		catch (Exception e) {

			// 品質保証
			logger.fatal("致命的なエラー");
		}

		return (strHtml);

	}
}
