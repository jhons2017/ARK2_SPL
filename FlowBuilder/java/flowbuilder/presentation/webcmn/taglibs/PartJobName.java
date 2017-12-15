/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/03/06 BY. CHENBIN (WXHX)
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
 * jobnameの設定
 * 
 * @author CHENBIN
 */
public final class PartJobName extends PartParent {
	/**
	 * HTMLの作成
	 * 
	 * @return StringBuffer
	 */
	protected StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();

		try {
			html.append(partJobNameHtml(_job, _orgId, _userId, _partXml));
		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}

	/**
	 * 案件名部品
	 * 
	 * @param Document job ジョブ
	 * @param String strOrgID 組織ID
	 * @param String strUserID ユーザーID
	 * @param String strPartXml 部品XML
	 * 
	 * @return String 
	 */
	public StringBuffer partJobNameHtml(Document job, String strOrgID, String strUserID, String strPartXml) {
		
		// ログを出力
		Log logger = LogFactory.getLog(PartCheckCondition.class);

		JobOprater jobOpr = new JobOprater();
		
		StringBuffer strHtml = new StringBuffer();
		
		String configFlg = super.getShowCase();
	
		try {
			
			// ログを出力
			logger.info("開始");

			// 部品ＸＭＬドキュメント取得する
			Document part = ParseXmlString.getParsedDocument(strPartXml);

			// 編集場合権限チェック
			if("edit".equals(configFlg) || "mustEdit".equals(configFlg)){
				String strJobName = jobOpr.getJobName(job);
				
				// タグエレメントを取得する
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "タグ"), 0);
				
				// style情報を取得する
				String strtagStyle = XmlOperator.getAttrValue(tagElement, "style");			

				// Htmlを出力
				strHtml.append("<INPUT name='fb_jobname' style='" + strtagStyle + "'" + " onBlur=\"chkChar(this.value,'forms[0]','fb_jobname');\" value='" + PartCommon.stringBrowseReturn(strJobName) + "'");

				// 必須場合権限チェック
				if("mustEdit".equals(configFlg)){
					
					//必須フラグ（＊）
					strHtml.append(" vital='1'>");
					strHtml.append("<FONT color=red>*</FONT>");
				} else {
					
					//フラグ（＊）なし
					strHtml.append(" vital='0'>");
				}
				
			// 表示場合権限チェック	
			} else if ("display".equals(configFlg)){
				
				//案件名を取得する
				String strJobName = jobOpr.getJobName(job);

				strHtml.append("<label style='word-break:break-all;'>" + PartCommon.stringBrowseReturn(strJobName) + "</label>");
				
			// 非表示場合権限チェック	
			} else if ("nodisplay".equals(configFlg)) {
				strHtml.append("");
			}
			
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
