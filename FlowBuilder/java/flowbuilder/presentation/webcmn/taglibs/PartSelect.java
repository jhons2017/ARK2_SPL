/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/04 BY. YANGZHEN (WXHX)
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
 * せラクタ部品の設定
 * 
 * @auther YANGZHEN
 */
public final class PartSelect extends PartParent {
	/**
	 * HTMLの作成
	 * 
	 * @return StringBuffer
	 */
	protected StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();
		try {
			html.append(partSelectHtml(_job, _orgId, _userId, _partXml));
		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}

	/**
	 * 選択OPTION部品
	 * 
	 * @param Document　job　ジョブ
	 * @param String　strOrgID　組織ID
	 * @param　String strUserID　ユーザーID
	 * @param strPartXml　部品ｘｍｌ 
	 * @return string
	 */
	protected StringBuffer partSelectHtml(Document job, String strOrgID, String strUserID, String strPartXml) {		
		// ログを出力
		Log logger = LogFactory.getLog(PartCheckCondition.class);
		logger.info("Selectの性能テスト(Start)：" + PartCommon.getCurTime());
		JobOprater jobOpr = new JobOprater();
		
		// 初期処理HTMLを取得
		StringBuffer strHtml = new StringBuffer();

		try {
			// ログを出力
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

			// 権限情報を取得する
			String strvitalRole = XmlOperator.getAttrValue(vitalElement, "role");
			
			// ======選択する内容の作成======
			// 項目情報を取得する
			Element optionArray = XmlOperator.getElement(XmlOperator.getNodeList(part, "option"), 0);
			
			// 項目値を取得する
			String optionValue = XmlOperator.getAttrValue(optionArray, "value");
			
			// 項目値一覧を取得する
			String[] optionList = optionValue.split(",");

			// 項目名称を取得する
			String optionName = XmlOperator.getAttrValue(optionArray, "name");
			
			// 項目一覧を取得する
			String[] optionNameList = optionName.split(",");
			
			// ======固定の情報======
			// 情報の黙認した
			Element contentElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "content"), 0);
			// 情報の固定でした 
			String contentDefalut = XmlOperator.getAttrValue(contentElement, "defalut");

			PartCheckCondition checkCondition = new PartCheckCondition();

			// 編集場合権限チェック
			if (checkCondition.checkUserCondition(job, strCurState, streditionUser, strUserID)
					|| checkCondition.checkRoleCondition(strCurState, streditionRole, strOrgID, strUserID)) {
				// 編集
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "タグ"), 0);

				// 操作者指定情報を取得する
				String strtagName = XmlOperator.getAttrValue(tagElement, "name");

				// 必要なNodeListを取得するドキュメント
				NodeList documents = XmlOperator.getNodeList(job, "Document");

				// ドキュメントを取得する
				Element document = (Element) documents.item(0);
				
				// 部品操作を取得
				String strStatus = PartCommon.getTagValue(document, "operator");

				// 部品目の前にを取得
				String strtagValue = PartCommon.getTagValue(document, strtagName);

				// HTML文作成
				strHtml.append("<TABLE cellspacing='4' cellpadding='0' border='0'>\n<TD valign='top'>\n").append("<SELECT name='").append(strtagName).append("' size='1'");

				// 必須マック
				if (checkCondition.checkUserCondition(job, strCurState, strvitalUser, strUserID)
						|| checkCondition.checkRoleCondition(strCurState, strvitalRole, strOrgID, strUserID)) {
					// 必須の場合
					strHtml.append(" vital='1'>");
				} else {
					// 必須でない場合
					strHtml.append(" vital='0'>");
				}

				int size = optionList.length;
				for (int i = 0; i < size; i++) {
					// 再起案 or 保存 HTMLを取得
					if ("returnSelf".equals(strStatus) || "save".equals(strStatus) || "return".equals(strStatus)) {
						if (strtagValue.equals(optionList[i])) {
							strHtml.append("<OPTION value='").append(optionList[i]).append("' selected>").append(optionNameList[i]).append("</OPTION>\n");
						} else {
							strHtml.append("<OPTION value='").append(optionList[i]).append("'>").append(optionNameList[i]).append("</OPTION>\n");
						}
					// 初期起案
					} else {
						if(contentDefalut.equals(optionList[i])) {
							strHtml.append("<OPTION value='").append(optionList[i]).append("' selected>").append(optionNameList[i]).append("</OPTION>\n");
						} else {
							strHtml.append("<OPTION value='").append(optionList[i]).append("'>").append(optionNameList[i]).append("</OPTION>\n");
						}
					}
				}

				strHtml.append("</SELECT>\n</TD>\n");
				// 必須マック
				if (checkCondition.checkUserCondition(job, strCurState, strvitalUser, strUserID)
						|| checkCondition.checkRoleCondition(strCurState, strvitalRole, strOrgID, strUserID)) {
					strHtml.append("<TD><font color=red>*</font></TD>");
				}
				strHtml.append("</TR>\n</TABLE>");
			// 表示場合
			} else if (checkCondition.checkUserCondition(job, strCurState, strdisplayUser, strUserID)
					|| checkCondition.checkRoleCondition(strCurState, strdisplayRole, strOrgID, strUserID)) {
				// 表示
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "タグ"), 0);

				// 操作者指定情報を取得する
				String strtagName = XmlOperator.getAttrValue(tagElement, "name");

				// 必要なNodeListを取得するドキュメント
				NodeList Documents = XmlOperator.getNodeList(job, "Document"); // ノッドリスト

				
				// ログを出力
				logger.info("partSelect");

				// ドキュメントの値を取得する
				Element docElement = (Element) Documents.item(0);
				String strtagValue = PartCommon.getTagValue(docElement, strtagName);
				int size = optionList.length;
				for (int i = 0; i < size; i++) {
					if(optionList[i].equals(strtagValue)) {
						strHtml.append(optionNameList[i]);
					}
				}
			// 非表示場合
			} else if (checkCondition.checkUserCondition(job, strCurState, strhiddenUser, strUserID)
					|| checkCondition.checkRoleCondition(strCurState, strhiddenRole, strOrgID, strUserID)) {
				
				strHtml.append("");
			}
			logger.info("Selectの性能テスト(End)：" + PartCommon.getCurTime());
			// ログを出力
			logger.info("終了");
			
		} catch (Exception e) {
			
			// ログを出力
			logger.fatal("致命的なエラー");
			
		}
		
		// HTMLを戻る
		return (strHtml);

	}

}
