/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/06/01
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/01 BY. CHENBIN (WXHX)
 * =================================================================
 */

package flowbuilder.presentation.webcmn.taglibs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;

/**
 * partDateの設定
 * 
 * @author CHENBIN
 */
public final class PartPrint extends PartParent {
	


	/**
	 * HTMLの作成
	 * 
	 * @return StringBuffer
	 */
    protected StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();

		try {
			html.append(partPrintHtml(_job, _orgId, _userId, _partXml));
		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}

	/**
	 * 印刷部品
	 * 
	 * @param Document job ジョブ
	 * @param String strOrgID 組織ID
	 * @param String strUserID ユーザーID
	 * @param String strPartXml 部品XML
	 * 
	 * @return String 
	 */
	public StringBuffer partPrintHtml(Document job, String strOrgID, String strUserID, String strPartXml) {
		
		// ログを出力
		Log logger = LogFactory.getLog(PartCheckCondition.class);
		
		StringBuffer strHtml = new StringBuffer();
		
		String configFlg = super.getShowCase();
	
		try {
			
			// ログを出力
			logger.info("開始");

			// 表示場合権限チェック
			if("display".equals(configFlg)) {
				
				strHtml.append("<SCRIPT LANGUAGE=javascript>\n"); 
				strHtml.append("function changeAction() {\n"); 
				strHtml.append("document.forms[0].action = 'JobPrint';\n");
				strHtml.append("document.forms[0].submit();\n");
				strHtml.append("}\n"); 
				strHtml.append("</SCRIPT>\n");
				strHtml.append("<INPUT type='button' name='print' value='印　刷' onclick='changeAction()'>\n");
				

			// 非表示場合権限チェック	
			} else {
				strHtml.append("");
			}
			
			// ログを出力
			logger.info("終了");
		} catch (Exception e) {

			// ログを出力
			logger.fatal("致命的なエラー");
		}
		
		//HTMLを戻る
		return (strHtml);
	}
	
}
