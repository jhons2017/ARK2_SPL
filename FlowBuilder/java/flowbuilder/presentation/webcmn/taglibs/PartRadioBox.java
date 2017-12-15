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
 * ラジオボックス部品の設定
 * 
 * @auther ZHANGXINFENG
 */
public final class PartRadioBox extends PartParent {

	/**
	 * HTMLの作成
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
	 * ラジオボックス部品
	 * 
	 * @param Document　job　ジョブ
	 * @param String　strOrgID　組織ID
	 * @param　String strUserID　ユーザーID
	 * @param strPartXml　部品ｘｍｌ 
	 */
	protected StringBuffer partRadioBoxHtml(Document job, String strOrgID, String strUserID, String strPartXml) {
		
		// ログを出力
		Log logger = LogFactory.getLog(PartCheckCondition.class);

		// 初期処理HTMLを取得
		StringBuffer strHtmlFirst = new StringBuffer();
		String configFlg = super.getShowCase();
		try {
			// 部品ＸＭＬドキュメント取得する
			Document part = ParseXmlString.getParsedDocument(strPartXml);
			
			// ログを出力
			logger.info("開始");

			// contentエレメントを取得する
			Element contentElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "content"), 0);

			// 操作者指定情報を取得する
			String strcontentName = XmlOperator.getAttrValue(contentElement, "name");

			// 黙認情報を取得する
			String strcontentDefalut = XmlOperator.getAttrValue(contentElement, "defalut");

			
			// 編集場合権限チェック
			if ("edit".equals(configFlg) || "mustEdit".equals(configFlg)) {
				
				// タグを取得
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "タグ"), 0);

				// タグ名を取得
				String strtagName = XmlOperator.getAttrValue(tagElement, "name");
				
				String strtagStyle = XmlOperator.getAttrValue(tagElement, "style");
				
				//　項目値一覧を取得する
				String[] strtagContent = strcontentName.split(",");
				
				// 長度を取得する
				int length = strtagContent.length;

				// 必要なNodeListを取得するドキュメント
				NodeList documents = XmlOperator.getNodeList(job, "Document"); 

				// ドキュメントを取得する
				Element document = (Element) documents.item(0);
				
				// タグ内容を取得
				String strtagValue = PartCommon.getTagValue(document, strtagName);
								
				for (int k = 0; k < length; k++) {
					// 非初期入る時
					if (!"".equals(strtagValue)) {
						if(strtagValue.equals(strtagContent[k])) {
							strHtmlFirst.append("<INPUT type='radio' checked" + " name='" + strtagName + "' style='" + strtagStyle + "'" + "' value ='" + strtagContent[k] + "'>");
						} else {
							strHtmlFirst.append("<INPUT type='radio'" + " name='" + strtagName + "' style='" + strtagStyle + "'" + "' value ='" + strtagContent[k] + "'>");
					    }
					// 初期入る時
					} else {				
						if (strcontentDefalut.equals(strtagContent[k])) {
							strHtmlFirst.append("<INPUT type='radio' checked" + " name='" + strtagName + "' style='" + strtagStyle + "'" + "' value ='" + strtagContent[k] + "'>");
						} else {
							strHtmlFirst.append("<INPUT type='radio'" + " name='" + strtagName + "' style='" + strtagStyle + "'" + "' value ='" + strtagContent[k] + "'>");							
						} 
					}
					// 必須マック
					if ("mustEdit".equals(configFlg)) {
						strHtmlFirst.append(strtagContent[k]);											
					} else {
						strHtmlFirst.append(strtagContent[k]);
					}
				}
				
			// 表示場合権限チェック
			} else if("display".equals(configFlg)) {
		
				// 必要なNodeListを取得するドキュメント
				NodeList documents = XmlOperator.getNodeList(job, "Document"); 

				// ドキュメントを取得する
				Element document = (Element) documents.item(0);
				
				// タグを取得する
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "タグ"), 0);

				// タグ名を取得する
				String strtagName = XmlOperator.getAttrValue(tagElement, "name");			

					//　部品内容を取得する
				String strtagValue = PartCommon.getTagValue(document, strtagName);
					
				strHtmlFirst.append(strtagValue);
				
			
			// 非表示場合権限チェック
			} else  if ("nodisplay".equals(configFlg)) {
				// 非表示
				strHtmlFirst.append("");
			}

			// logger終了
			logger.info("終了");
		} catch (Exception e) {
			
			// ログエラ
			logger.fatal("致命的なエラー");
		}

		// HTMLを戻る
		return strHtmlFirst;
	}
}