/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/13 BY. YANGZHEN (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import flowbuilder.application.util.JobOprater;
import flowbuilder.application.util.ParseXmlString;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.presentation.webcmn.taglibs.common.PartCommon;

/**
 * IMAGE部品の設定
 * 
 * @auther YANGZHEN
 */
public final class PartImage extends PartParent {
	/**
	 * HTMLの作成
	 * 
	 * @return StringBuffer
	 */
	protected StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();

		try {
			html.append(partImageHtml(_job, _userId, _partXml));
		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}


	/**
	 * IMAGE部品
	 * 
	 * @param job
	 * @param strUserID
	 * @param strPartXml
	 */
	protected String partImageHtml(Document job, String strUserID, String strPartXml) {
		// ログを出力
		Log logger = LogFactory.getLog(PartCheckCondition.class);
		logger.info("イメッジの性能テスト(Start)：" + PartCommon.getCurTime());
		JobOprater jobOpr = new JobOprater();
		
		// 初期処理HTMLを取得
		String strHtml = "";


		try {
			//部品ＸＭＬドキュメント取得する
			Document part = ParseXmlString.getParsedDocument(strPartXml);
			
			// ログを出力
			logger.info("開始");

			// 案件現在状態を取得
			String strCurState = jobOpr.getCurrentState(job);
	
			
			// ======頭象の確認======
			Element optElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "option"), 0);
			
			// 指定みちを取得する
			String stroptPath = XmlOperator.getAttrValue(optElement, "path");
			
			// 指定の高度
			String stroptHeight = XmlOperator.getAttrValue(optElement, "height");
			
			// 指定の広さ
			String stroptwidth = XmlOperator.getAttrValue(optElement, "width");
			
			strHtml = strHtml + "<img width = '" + stroptwidth + "' height = '" + stroptHeight + "' src='" + stroptPath;
			
			// 案件起案の状態
			if("案件起案".equals(strCurState)) {
				strHtml = strHtml + strUserID ; 
			} else {
				strHtml = strHtml + jobOpr.getCreatorID(job) ; 
			}
			
			strHtml = strHtml + ".gif'></img>";
			
			logger.info("イメッジの性能テスト(END)：" + PartCommon.getCurTime());
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
