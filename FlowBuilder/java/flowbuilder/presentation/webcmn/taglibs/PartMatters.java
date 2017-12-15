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
 *  事宜部品の設定
 * 
 * @auther ZHANGXINFENG
 */
public final class PartMatters extends PartParent {

	/**
	 * HTMLの作成
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
	 * 事宜部品
	 * 
	 * @param job document 案件
	 * @param strOrgID  String  組織ID
	 * @param strUserID String ユーザID
	 * @param strPartXml String 部品XML
	 */
	String partMattersHtml(Document job, String strOrgID, String strUserID,
			String strPartXml) {

		// ログを出力
		Log logger = LogFactory.getLog(PartUpload.class);
		String strHtml = "";
		String strtagValue = "";
		
		try {

			// 品質保証
			logger.info("開始");

			// 部品ＸＭＬドキュメント取得する
			Document part = ParseXmlString.getParsedDocument(strPartXml);
			String configFlg = super.getShowCase();

			// 編集の場合、権限のチェックを行います。
			if ("edit".equals(configFlg) || "mustEdit".equals(configFlg)) {
				
				
				// 編集の場合、HTML作成
				strHtml = strHtml + "<input name='button' type= button onClick='additem(\"tb\")' value='追加'>\n"
									+ " <table id=\"tb\">\n"
									+ "</table>\n";
									
				// 必要なNodeListを取得するドキュメント
			/*	NodeList documents = XmlOperator.getNodeList(job, "Document");

				// ドキュメントを取得する
				Element document = (Element) documents.item(0);

				// タグを取得する
				Element tagElement = XmlOperator.getElement(XmlOperator
						.getNodeList(part, "タグ"), 0);

				// タグ名を取得する
				String strtagName = XmlOperator
						.getAttrValue(tagElement, "name");

				String[] tokens = strtagName.split("/");

				// 該当項目の値を取得する
				for (int i = 0; i < tokens.length; i++) {

					strtagValue = PartCommon.getTagValue(document, tokens[i]);

					// 取得した値が空ではない、値を画面に表示される
					if (!"".equals(strtagValue)) {

						strHtml = strHtml + "<input type='text' name='" + tokens[i] + "' value = '" + strtagValue + "'>"
						+ "<input type='button' value='削除' onclick=\"deleteitem(this,'tb');\">\n"
						+ "<br>\n" ;
					}
				}*/

				//　表示の場合、権限のチェックを行います。
				
			} else if ("display".equals(configFlg)) {

				// 必要なNodeListを取得するドキュメント
				NodeList documents = XmlOperator.getNodeList(job, "Document");

				// ドキュメントを取得する
				Element document = (Element) documents.item(0);

				// タグを取得する
				Element tagElement = XmlOperator.getElement(XmlOperator
						.getNodeList(part, "タグ"), 0);

				// タグ名を取得する
				String strtagName = XmlOperator.getAttrValue(tagElement, "name");

				String[] tokens = strtagName.split("/");

				// 該当項目の値を取得する
				for (int i = 0; i < tokens.length; i++) {
					
					

					strtagValue = PartCommon.stringBrowseReturn(PartCommon.getTagValue(document, tokens[i]));

					// 取得した値が空ではない、値を画面に表示される
					if (!"".equals(strtagValue)) {

						strHtml = strHtml + "<label style='word-break:break-all;'>" + strtagValue + "</label><BR>";
					}
				}

			} else {

				// HTML文を出力しない
				strHtml = "";
			}

			// 品質保証
			logger.info("終了");
		}

		catch (Exception e) {

			// 品質保証
			logger.fatal("致命的なエラー");
			e.printStackTrace();
		}

		// HTMLを戻る
		return (strHtml);
	}
}
