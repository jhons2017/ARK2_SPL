/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/05/31
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/05/31 BY. hewj (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import flowbuilder.application.user.UserService;
import flowbuilder.application.user.UserServiceFactory;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.presentation.webcmn.taglibs.common.PartCommon;

/**
 * 回覧部品
 * 
 * @author hx0158
 */
public final class PartCircular extends PartParent {

	/**
	 * HTMLの作成
	 * 
	 * @return StringBuffer
	 */
	protected StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();
		try {
			html.append(partCircularHtml(_job, _orgId, _userId));
		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}

	/**
	 * INPUT部品
	 * 
	 * @param job
	 *            document 案件
	 * @param strOrgID
	 *            String 組織ID
	 * @param strUserID
	 *            String ユーザID
	 * @param strPartXml
	 *            String 部品XML
	 */
StringBuffer partCircularHtml(Document job, String strOrgID, String strUserID) {
		
		// ローグ

	Log logger = LogFactory.getLog(PartCheckCondition.class);
 		
 		// HTMLの作成
		StringBuffer strHtml = new StringBuffer();
		
		// 権限チェック
		String strCurrentState; 

		try {
			
			// ローグを出力する
			logger.info("開始");
			
			// 違いの場合権限チェック
			strCurrentState = getShowCase();
			
			// 編集場合権限チェック
			if ("edit".equals(strCurrentState)
					|| "mustEdit".equals(strCurrentState)) {

				this._partXml = this._partXml.replace("circular", "circularID");
				// 案件IDを取得
				Element jobInfo = XmlOperator.getElement(XmlOperator
						.getNodeList(job, "jobinfo"), 0);
				String jobId = jobInfo.getAttribute("jobid");
				// HTMLを作成する
				strHtml.append("<IFRAME name='inner' frameborder='0'  width='100%' height='350' src='CircularOperate?method=init");
				strHtml.append("&orgId="+_orgId+ "&jobId=" + jobId + "'></IFRAME>\n");
				strHtml.append("<INPUT type='hidden' name='circularID' value=''>");

				// 表示の場合、権限のチェックを行います。
			} else if("display".equals(strCurrentState)) {
				// 回覧人ユーザID
				String userId = "";
				
				// 回覧人ユーザ名前
				String username = "";
				
				// 操作フラグ
				String problemFlg = "";
				
				// 意見の情報を設定
				String addmission = "";
				
				// 確認の時間を設定
				String confirmDate = "";
				
				// HTML文を出力しない
				strHtml.append("<table align='center' border='0'  bgcolor='#999999' cellpadding='1' cellspacing='1' width='100%'>\n");
				strHtml.append("<tr bgcolor='#FFFFFF' height='30'>\n");
				strHtml.append("<td colspan='5' align='center'><h3>回覧状態</h3></td>\n");
				strHtml.append("</tr>\n");
				strHtml.append("<tr bgcolor='#ffffff' height='30' width='100%'>\n");
				strHtml.append("<td align='center' width='20%'><h4>回覧者</h4></td>\n");
				strHtml.append("<td align='center' width='40%'><h4>意見</h4></td>\n");
				strHtml.append("<td align='center' width='10%'><h4>状態</h4></td>\n");
				strHtml.append("<td align='center' width='10%'><h4>確認時間</h4></td>\n");
				strHtml.append("<td align='center' width='10%'><h4>操作</h4></td>\n");
				strHtml.append("</tr>\n");
		
				// ユーザー管理サービスのインスタンスを取得する
				UserService _userService = UserServiceFactory.getUserServiceInstance();

				// 該当案件の状態のドキュメントを取得する
				NodeList docList = XmlOperator.getNodeList(job, "Document");
				// 該当案件の回覧を取得する
				NodeList cirList = XmlOperator.getNodeList(job, "Circular");

				// 一行目アイテムを取得する
				Element docElm = (Element) docList.item(0);
				Element circularElm = (Element) cirList.item(0);
				NodeList controlEle = docElm.getElementsByTagName("control");
				
				// ユーザIDを取得する
				NodeList memberList= circularElm.getElementsByTagName("member");
			
				// ユーザリストを取得する
				int len = memberList.getLength();
				for (int i = 0; i < len; i++) {
					// ユーザの状態を取得する
					Element memberElm = (Element) memberList.item(i);
					userId = memberElm.getAttributeNode("id").getNodeValue();
					// 状態の取得
					problemFlg = memberElm.getAttributeNode("problemFlg").getNodeValue();
					confirmDate = memberElm.getAttributeNode("confirmDate").getNodeValue();

					username = (_userService.getUser(userId)).getUserName();
					
					if(userId.equals(strUserID)) {
						for (int j = 0; j < controlEle.getLength(); j++) {
							Element docElement = (Element) controlEle.item(j);
							if (docElement != null) {
								if (userId.equals(docElement.getAttributeNode("id").getNodeValue())) {
									if (docElement.hasChildNodes()) {
										addmission = docElement.getFirstChild().getNodeValue().trim();
										break;
									}
								}
							}
						}
						strHtml.append("<tr bgcolor='#ffffff' height='30'>\n");
						// 影像部品
						strHtml.append("<td align='center'><img width='60' height='60' src='/FlowBuilder/images/userImages/"
								+ userId + ".gif'></img><br>" + username + "</td>\n");
						//自分の回覧
						strHtml.append(loginUserSelfHtml(userId,problemFlg,addmission,confirmDate));
						strHtml.append("</tr>\n");
	
					}
				}
				for (int i = 0; i < len; i++) {
					// ユーザの状態を取得する
					Element memberElm = (Element) memberList.item(i);
					userId = memberElm.getAttributeNode("id").getNodeValue();
					if(!userId.equals(strUserID)) {
						username = (_userService.getUser(userId)).getUserName();
						// 状態の取得
						problemFlg = memberElm.getAttributeNode("problemFlg").getNodeValue();
						confirmDate = memberElm.getAttributeNode("confirmDate").getNodeValue();
						for (int j = 0; j < controlEle.getLength(); j++) {
							Element docElement = (Element) controlEle.item(j);
							if (docElement != null) {
								if (userId.equals(docElement.getAttributeNode("id").getNodeValue())) {
									if (docElement.hasChildNodes()) {
										addmission = docElement.getFirstChild().getNodeValue().trim();
										break;
									}
								}
							}
						}
							strHtml.append("<tr bgcolor='#ffffff' height='30'>\n");
							// 影像部品
							strHtml.append("<td align='center'><img width='60' height='60' src='/FlowBuilder/images/userImages/"
									+ userId + ".gif'></img><br>" + username + "</td>\n");
							strHtml.append(otherUsersHtml(userId,problemFlg,addmission,confirmDate));
							strHtml.append("</tr>\n");
					}
				}
				strHtml.append("</table>");
			// 非表示の場合、権限をチェックを行います。
			} else if ("".equals(strCurrentState)) {
				// HTML文を出力しない
				strHtml.append("");
			}
			// ローグを出力する
			logger.info("終了");
		} catch (Exception e) {

			// ローグを出力する
			logger.fatal("致命的なエラー");
		}
		
		// HTML文を返す
		return (strHtml);
	}

	/**
	 *  自分回覧
	 * @param useId
	 * @param problemFlg
	 * @param addmission
	 * @param　confirmDate
	 * @return
	 */
	private StringBuffer loginUserSelfHtml(String userId,String problemFlg,String addmission,String confirmDate) {
		
		StringBuffer strHtml = new StringBuffer("");
		
		String status=null;

		// 回覧待ち
		if ("0".equals(problemFlg)) {
			status = "回覧待ち";
			this._partXml = this._partXml.replace("circular",userId);
			this._checkXml = this._checkXml.replace("circular",userId);
			strHtml.append("<td align='left'><TextArea name='"+userId + "' rows='3' cols='32' vital='1'></TextArea><font color='red'>*</font></td>\n");
			strHtml.append("<td align='center'>" + status + "</td>\n");
			strHtml.append("<td align='center'>" + confirmDate + "</td>");
			strHtml.append(strBtnHtml());
			// 回覧済
		} else if ("3".equals(problemFlg)) {
			status = "処理済";
			strHtml.append("<td align='left'><label style='word-break:break-all;'>" + PartCommon.stringBrowseReturn(addmission,"\r\n") + "</label></td>\n");						
			strHtml.append("<td align='center'>" + status + "</td>\n");
			strHtml.append("<td align='center'>" + confirmDate + "</td>");
			strHtml.append("<td align='center'></td>\n");
		// 確認済
		} else if ("1".equals(problemFlg)) {
			// 延期
			status = "確認済";
			// 自分回覧
			this._partXml = this._partXml.replace("circular",userId);
			this._checkXml = this._checkXml.replace("circular",userId);
			strHtml.append("<td align='left'><TextArea name='"+userId + "' rows='3' cols='32' vital='1'>" + addmission + "</TextArea><font color='red'>*</font></td>\n");
			strHtml.append("<td align='center'>" + status + "</td>");
			strHtml.append("<td align='center'>" + confirmDate + "</td>");
			strHtml.append(strBtnHtml());
			
		// 問題あり
		} else {
			status = "<font color='red'>問題あり</font>";

			// 自分回覧
			this._partXml = this._partXml.replace("circular",userId);
			this._checkXml = this._checkXml.replace("circular",userId);
		 	strHtml.append("<td align='left'><TextArea name='"+userId + "' rows='3' cols='32' vital='1'>" + addmission + "</TextArea><font color='red'>*</font></td>\n");
			strHtml.append("<td align='center'>" + status + "</td>");
			strHtml.append("<td align='center'>" + confirmDate + "</td>");
			strHtml.append(strBtnHtml());
		}
		return strHtml;
	}
	
	/**
	 * 
	 */
	private StringBuffer otherUsersHtml(String userId,String problemFlg,String addmission,String confirmDate) {
		
		StringBuffer strHtml = new StringBuffer("");
		
		String status=null;
		if("0".equals(problemFlg)) {
			status = "回覧待ち";
		} else if("3".equals(problemFlg)) {
			status = "処理済";
		} else if("1".equals(problemFlg)) {
			status = "確認済";
		} else {
			status = "<font color='red'>問題あり</font>";
		}
		// 回覧待ち
		if ("0".equals(problemFlg)) {
			status = "回覧待ち";
			strHtml.append("<td align='left'></td>\n");
			strHtml.append("<td align='center'>" + status + "</td>\n");
			strHtml.append("<td align='center'>" + confirmDate + "</td>");
			strHtml.append("<td align='center'></td>\n");
			
		} else {
			// 自分のほかに回覧
			strHtml.append("<td align='left'><label style='word-break:break-all;'>" + PartCommon.stringBrowseReturn(addmission,"\r\n") + "</label></td>\n");						
			strHtml.append("<td align='center'>" + status + "</td>\n");
			strHtml.append("<td align='center'>" + confirmDate + "</td>");
			strHtml.append("<td align='center'></td>\n");
		}
		return strHtml;
	}
	
	/**
	 * ボタンのｈｔｍｌを作成
	 * 
	 * @return
	 */
	private StringBuffer strBtnHtml() {

		// ボタンのｈｔｍｌを作成
		StringBuffer btnHtml = new StringBuffer();

		// ボタン名前
		String btnName = "";

		// ボタンの表示
		String btnValue = "";

		// ボタングルプのエレメントを取得する
		Element btn_group = XmlOperator.getElement(XmlOperator.getNodeList(
				part, "ボタングルプ"), 0);
		// ボタンのノドレスト
		NodeList btn_node = btn_group.getElementsByTagName("button");

		btnHtml.append("<td><table><tr>");
		// ボタンのｈｔｍｌを動態作成
		int len = btn_node.getLength();
		for (int i = 0; i < len; i++) {
			Element btnEle = (Element) btn_node.item(i);
			// ボタン名前
			btnName = XmlOperator.getAttrValue(btnEle, "name");
			// ボタンの表示
			btnValue = XmlOperator.getAttrValue(btnEle, "value");
			btnHtml.append("<td bordercolor='#FFFFFF' align='center' nowrap>\n");
			btnHtml.append("<input name='" + btnName
					+ "' type='button' value='" + btnValue
					+ "' valign='center'  onclick=javascript:checkform('"
					+ btnName + "','save','1');>");
			btnHtml.append("</td>\n");
		}
		btnHtml.append("</tr></table></td>");
		return btnHtml;
	}
}