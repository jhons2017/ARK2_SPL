/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/05/31 BY. ZHANGXINFENG (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.presentation.webcmn.taglibs.common.PartCommon;

/**
 * テキストエリア部品の設定
 * 
 * @auther ZHANGXINFENG
 */
public final class PartTextArea extends PartParent {
	/**
	 * HTMLの作成
	 * 
	 * @return StringBuffer
	 */
	protected StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();

		try {
			html.append(partTextAreaHtml(_job, _orgId, _userId, _partXml));
		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}

	/**
	 * テキストエリア部品
	 * 
	 * @param Document　job　ジョブ
	 * @param String　strOrgID　組織ID
	 * @param　String strUserID　ユーザーID
	 * @param strPartXml　部品ｘｍｌ 
	 * 	
	 * @return string
	 */
	StringBuffer partTextAreaHtml(Document job, String strOrgID, String strUserID, String strPartXml) {
		StringBuffer strHtml = new StringBuffer();
		
		String configFlg = super.getShowCase();

		if("display".equals(configFlg) || "edit".equals(configFlg) || "mustEdit".equals(configFlg)){
			// タグを取得
			Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "タグ"), 0);

			// タグ名を取得する
			String strtagName = XmlOperator.getAttrValue(tagElement, "name");

			// 必要なNodeListを取得するドキュメント
			NodeList documents = XmlOperator.getNodeList(job, "Document"); 

			Element docElement = (Element) documents.item(0);

			// ドキュメントの値を取得する
			String strtagValue = PartCommon.getTagValue(docElement, strtagName);
			
			if("display".equals(configFlg)) {
				// HTMLタグへ変換します
				if (strtagValue != null) {
					strHtml.append("<label style='word-break:break-all;'>" + PartCommon.stringBrowseReturn(strtagValue,"\r\n") + "</label>");
				}
			}else if("edit".equals(configFlg) || "mustEdit".equals(configFlg)) {
				// 行数を取得
				String strtagRows = XmlOperator.getAttrValue(tagElement, "rows");

				// 列数を取得
				String strtagCols = XmlOperator.getAttrValue(tagElement, "cols");

				// HTML作成
				strHtml.append("<TEXTAREA name='" + strtagName + "' rows='" + strtagRows + "' cols='" + strtagCols + "'");
				
				if("mustEdit".equals(configFlg)) {
					strHtml.append(" vital='1'>");
					// テスト内容を入れる
					strHtml.append(PartCommon.stringBrowseReturn(strtagValue) + "</TEXTAREA>");
					// 必須フラグ(*)
					strHtml.append("<FONT color=red>*</FONT>");
				}else{
					strHtml.append(" vital='0'>");
					// テスト内容を入れる
					strHtml.append(PartCommon.stringBrowseReturn(strtagValue) + "</TEXTAREA>");
				}
			}
		} else if("nodisplay".equals(configFlg)){
			strHtml.append("");
		}

		//　HTMLを戻る
		return (strHtml);
	}
	
	
}
