/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/01 BY. YANGZHEN (WXHX)
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
 * CHECKBOX部品の設定
 * 
 * @auther YANGZHEN
 */
public final class PartCheckBox extends PartParent {
	/**
	 * HTMLの作成
	 * 
	 * @return StringBuffer
	 */
	protected StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();

		try {
			html.append(partCheckBoxHtml(_job, _orgId, _userId, _partXml));
		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}


	/**
	 * CHECKBOX部品
	 * 
	 * @param job
	 * @param strOrgID
	 * @param strUserID
	 * @param strPartXml
	 */
	protected StringBuffer partCheckBoxHtml(Document job, String strOrgID, String strUserID, String strPartXml) {
		// ログを出力
		Log logger = LogFactory.getLog(PartCheckCondition.class);

		logger.info("チェックボックスの性能テスト（Start）：" + PartCommon.getCurTime());
		
		JobOprater jobOpr = new JobOprater();
		
		// 初期処理HTMLを取得
		StringBuffer strHtml = new StringBuffer();

		// 起案の状態判定
		boolean flg = false;

		try {
			//部品ＸＭＬドキュメント取得する
			Document part = ParseXmlString.getParsedDocument(strPartXml);
			
			// ログを出力
			logger.info("開始");

			// 案件現在状態を取得
			String strCurState = jobOpr.getCurrentState(job);

			// ======タグの確認======
			// タグエレメントを取得する
			Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "タグ"), 0);

			// 指定情報を取得する
			String strtagName = XmlOperator.getAttrValue(tagElement, "name");
			
			// 指定様式を取得する
			String strtagStyle = XmlOperator.getAttrValue(tagElement, "style");
			
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
			
			// 非表示エレメントを取得する
			Element contentElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "content"), 0);

			// 情報の黙認した
			String contentName = XmlOperator.getAttrValue(contentElement, "name");

			// 黙認情報を取得する
			String contentDefalut = XmlOperator.getAttrValue(contentElement, "defalut");
			

			// 権限チェック
			PartCheckCondition checkCondition = new PartCheckCondition();
			
			// 項目名称を取得する
			String[] strtagContent = contentName.split(",");
			
			// タグ名称を取得する
			String[] strrName= strtagName.split("/");
			
			int length = strtagContent.length;

			// 必要なNodeListを取得するドキュメント
			NodeList documents = XmlOperator.getNodeList(job, "Document"); 

			// ドキュメントを取得する
			Element document = (Element) documents.item(0);
			
			// 部品操作を取得
			String strStatus = PartCommon.getTagValue(document, "operator");

			// 編集場合権限チェック
			if (checkCondition.checkUserCondition(job, strCurState, streditionUser, strUserID)
					|| checkCondition.checkRoleCondition(strCurState, streditionRole, strOrgID, strUserID)) {
				
				for (int k = 0; k < length; k++) {
					// 部品内容を取得する
					String strtagValue = PartCommon.getTagValue(document, strrName[k]);
					
					String createrId = jobOpr.getCreatorID(job);
					
					// 起案後 or 保存 HTMLを取得
					if (!"".equals(createrId)) {
						// 記録を取得する
						if ("on".equals(strtagValue)){
							strHtml.append("<INPUT type='checkbox' checked ");
						} else {
							strHtml.append("<INPUT type='checkbox'");
						}
					// 初期処理HTMLを取得
					} else {
						// 黙認を取得する
						if (strtagContent[k].equals(contentDefalut)) {
							strHtml.append("<INPUT type='checkbox' checked ");
						} else {
							strHtml.append("<INPUT type='checkbox'");
						}
					}
					strHtml.append(" name='").append(strrName[k]).append("' style='").append(strtagStyle).append("'").append(" vital='0'>").append(strtagContent[k]);
				}
			//表示
			} else if (checkCondition.checkUserCondition(job, strCurState, strdisplayUser, strUserID)
					|| checkCondition.checkRoleCondition(strCurState, strdisplayRole, strOrgID, strUserID)) {
			
				for (int k = 0; k < length; k++) {
					
					strHtml.append("<INPUT type='checkbox'").append(" name='").append(strrName[k]).append("' style='").append(strtagStyle).append("'");
					
					//　部品内容を取得する
					String strtagValue = PartCommon.getTagValue(document, strrName[k]);
					
					// ドキュメントの値を取得する
					if (!"".equals(strtagValue)) {
						strHtml.append("  checked disabled='true' vital='0'>").append(strtagContent[k]);
					} else {
						strHtml.append(" disabled='true' vital='0'>").append(strtagContent[k]);
					}
				}
			// 非表示
			} else if (checkCondition.checkUserCondition(job, strCurState, strhiddenUser, strUserID)
					|| checkCondition.checkRoleCondition(strCurState, strhiddenRole, strOrgID, strUserID)) {
				strHtml.append("");
			}
			
			logger.info("チェックボックスの性能テスト（END）：" + PartCommon.getCurTime());
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
