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

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import flowbuilder.application.util.ParseXmlString;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.presentation.webcmn.taglibs.common.PartCommon;

/**
 * partDateの設定
 * 
 * @author CHENBIN
 */
public final class PartDate extends PartParent {
	/**
	 * HTMLの作成
	 * 
	 * @return StringBuffer
	 */
	protected StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();

		try {
			html.append(partDateHtml(_job, _orgId, _userId, _partXml));
		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}

	/**
	 * 日期部品
	 * 
	 * @param Document job ジョブ
	 * @param String strOrgID 組織ID
	 * @param String strUserID ユーザーID
	 * @param String strPartXml 部品XML
	 * 
	 * @return String 
	 */
	public StringBuffer partDateHtml(Document job, String strOrgID, String strUserID, String strPartXml) {
		
		// ログを出力
		Log logger = LogFactory.getLog(PartCheckCondition.class);
		
		StringBuffer strHtml = new StringBuffer();
		
		String configFlg = super.getShowCase();
	
		try {
			
			// ログを出力
			logger.info("開始");
			
			// 部品ＸＭＬドキュメント取得する
			Document part = ParseXmlString.getParsedDocument(strPartXml);

			// 編集場合権限チェック
			if("edit".equals(configFlg) || "mustEdit".equals(configFlg)){
	
				// タグエレメントを取得する
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "タグ"), 0);
				
				// name情報を取得する
				String strtagName = XmlOperator.getAttrValue(tagElement, "name");
				
				// style情報を取得する
				String strtagStyle = XmlOperator.getAttrValue(tagElement, "style");
				
				String strtagValue = "";
				
				// 必要なNodeListを取得するドキュメント
				NodeList documents = XmlOperator.getNodeList(job, "Document");
				
				Element document = (Element) documents.item(0);
				
				// ドキュメントの値を取得する
				strtagValue = PartCommon.getTagValue(document, strtagName);
				
				strHtml.append("<SCRIPT language='javascript' src='../../calendarJavascript.jsp'></SCRIPT>\n");
				
				//初期入る時、テキストボックスに　システム時間を表示する
				if (strtagValue == null || strtagValue == ""){
					strHtml.append("<INPUT" + " name='" + strtagName + "' style='" + strtagStyle + "' readonly" + " value='"
					+ getCurTime() + "'");
					
				//非	初期入る時、テキストボックスに　取得する時間を表示する
				} else {
					strHtml.append("<INPUT" + " name='" + strtagName + "' style='" + strtagStyle + "' readonly" + " value='"
					+ PartCommon.stringBrowseReturn(strtagValue) + "'");
				}

				// 必須場合権限チェック
				if("mustEdit".equals(configFlg)){	
					
					// 必須フラグ（＊）
					strHtml.append(" vital='1'>");
					strHtml.append("<FONT color=red>*</FONT>");
				} else {
					
					// フラグ（＊）なし
					strHtml.append(" vital='0'>");
				}
				
				strHtml.append("<SPAN>\n");
				strHtml.append("<A href=javascript:show_calendar('" + strtagName + "'); " +
									"onMouseOver=\"window.status='Date Picker';return true;\" " +
									"onMouseOut=\"window.status='';return true;\" border='0'>" +
									"<IMG src='/FlowBuilder/css/calender.gif' border='0'></A>\n");
				strHtml.append("</SPAN>\n");
				
			//表示場合権限チェック	
			} else if ("display".equals(configFlg)){

				// タグエレメントを取得する
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "タグ"), 0);
				
				// name情報を取得する
				String strtagName = XmlOperator.getAttrValue(tagElement, "name");
				
				// 必要なNodeListを取得するドキュメント
				NodeList documents = XmlOperator.getNodeList(job, "Document");

				Element docElement = (Element) documents.item(0);
				
				// ドキュメントの値を取得する
				String strtagValue = PartCommon.getTagValue(docElement, strtagName);
				
				// HTMLタグへ変換します
				if (strtagValue != null) {
					strHtml.append(PartCommon.stringBrowseReturn(strtagValue));
				}
				
			//非表示場合権限チェック	
			} else if ("nodisplay".equals(configFlg)) {
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
	
	/**
	 * システム時間を取得する
	 * 
	 * @return　String
	 */
	private String getCurTime() {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd"); 
		
		return f.format(c.getTime());
	}
}
