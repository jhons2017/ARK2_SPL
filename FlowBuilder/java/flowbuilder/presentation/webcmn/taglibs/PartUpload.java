/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/19 BY. ZHANGXINFENG (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import fbcom.framework.dao.conf.ConfigReader;
import flowbuilder.application.util.JobOprater;
import flowbuilder.application.util.ParseXmlString;
import flowbuilder.dao.conf.FlowBuilderSystemConfig;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.presentation.webcmn.taglibs.common.PartCommon;
import flowbuilder.presentation.webcmn.taglibs.view.upload.FileInformation;

/**
 * アップロード部品の設定
 * 
 * @auther ZHANGXINFENG
 */
public final class PartUpload extends BodyTagSupport {

	// 組織の設定
	private String _orgId = "";

	// ユーザーIDの設定
	private String _userId = "";

	// 部品XMLの設定
	private String _partXml = "";

	// ジョブファイルの設定
	private Document _job = null;

	/**
	 * 組織の設定
	 * 
	 * @param orgId String  組織ID
	 */
	public void setOrgId(String orgId) {
		_orgId = orgId;
	}

	/**
	 * ユーザーIDの設定
	 * 
	 * @param userId String ユーザID
	 */
	public void setUserId(String userId) {
		_userId = userId;
	}

	/**
	 * 部品XMLの設定
	 * 
	 * @param partXml  String 部品XML
	 */
	public void setPartXml(String partXml) {
		_partXml = partXml;
	}

	/**
	 * ジョブファイルの設定
	 * 
	 * @param orgId Document  ジョブ
	 */
	public void setJob(Document job) {
		_job = job;
	}

	/**
	 * タグ初期処理
	 * 
	 * @return int 
	 */
	public int doStartTag() {
		try {
			pageContext.getOut().print(toHTML().toString());
		} catch (java.io.IOException e) {
			System.out.println("partOrgList:" + "doStartTag" + e.getMessage());
		}
		return SKIP_BODY;
	}

	/**
	 * HTMLの作成
	 * 
	 * @return StringBuffer
	 */
	private StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();

		try {
			html.append(partUploadHtml(_job, _orgId, _userId, _partXml));
		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	/**
	 * アップロード部品
	 * 
	 * @param job document 案件
	 * @param strOrgID  String  組織ID
	 * @param strUserID String ユーザID
	 * @param strPartXml String 部品XML
	 */
	String partUploadHtml(Document job, String strOrgID, String strUserID, String strPartXml) {

		// ログを出力
		Log logger = LogFactory.getLog(PartUpload.class);
		JobOprater jobOpr = new JobOprater();
		String strHtml = "";
		String strtagColspan = "";
		// ジョブIDの設定
		String strJobId = jobOpr.getJobID(job);

		try {

			// 品質保証
			logger.info("開始");

			// 部品ＸＭＬドキュメント取得する
			Document part = ParseXmlString.getParsedDocument(strPartXml);

			// 案件現在状態を取得
			String strCurState = jobOpr.getCurrentState(job);

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

			PartCheckCondition checkCondition = new PartCheckCondition();

			// 編集の場合、権限のチェックを行います。
			if (checkCondition.checkUserCondition(job, strCurState, streditionUser, strUserID)
					|| checkCondition.checkRoleCondition(strCurState, streditionRole, strOrgID,
							strUserID)) {

				// タグのノードを取得する
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "タグ"), 0);

				// タグの値取得する		
				String strtagUploadLable = XmlOperator.getAttrValue(tagElement, "uploadLable");

				strtagColspan = XmlOperator.getAttrValue(tagElement, "colspan");
				// 編集の場合、HTML作成
				strHtml = strHtml
						+ "<tr align='left' bgcolor='#ffffff' valign='middle'>\n"
						+ "<td>"
						+ strtagUploadLable
						+ "</td>\n"
						+ "<td height=25 colspan = "
						+ strtagColspan
						+ ">\n"
						+ "<table>\n"
						+ "<tr>\n"
						+ "<td>\n"
						+ "<table id='table1'>\n"
						+ "<tr>\n"
						+ "<td><input type='file' name='files[0]' id='fileId0' onpaste='return false' onkeydown='return false'></td>\n"
						+ "<td ><input type='button' name='1' value='削除'  onClick='deleteRow(0);'></td>\n"
						+ "</tr>\n" + "</table>\n"
						+ "<input type='button' name='Submit2' value='追加' onClick='insertRow()'>\n"
						+ "</td>\n" + "</tr>\n" + "</table>\n" + "</td>\n" + "</tr>\n";

				//　表示の場合、権限のチェックを行います。
			} else if (checkCondition.checkUserCondition(job, strCurState, strdisplayUser,
					strUserID)
					|| checkCondition.checkRoleCondition(strCurState, strdisplayRole, strOrgID,
							strUserID)) {

				List<FileInformation> fileList = new ArrayList<FileInformation>();

				FileInformation fileInfo = null;

				ConfigReader conf = FlowBuilderSystemConfig.getInstance();

				// タグのノードを取得する
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "タグ"), 0);

				// タグの値取得する
				String strtagDownLoadLable = XmlOperator.getAttrValue(tagElement, "downLoadLable");

				strtagColspan = XmlOperator.getAttrValue(tagElement, "colspan");

				// 案件状態を取得
				String strtagState = XmlOperator.getAttrValue(tagElement, "state");

				// 案件現在状態を取得
				int state = jobOpr.getStep(job, strtagState);

				String urlBase = conf.getValue("UrlBase");

				// ダウンロードパスを取得する
				String downloadPath = conf.getValue("loadPath");

				// ダウンロードURLパスを取得する
				String urlPath = urlBase + conf.getValue("urlPath");

				// imageパスを取得する
				String fileIcoPath = conf.getValue("fileIcoPath");

				String url = urlPath + strJobId + "/" + state + "/";

				//パスの設定
				String filePath = downloadPath + strJobId + "\\" + state + "\\";

				File[] file = (new File(filePath)).listFiles();

				// ファイルリストの長度を取得する
				int fileListLength;

				if (file == null) {
					fileListLength = 0;
				} else {
					fileListLength = file.length;
				}

				for (int i = 0; i < fileListLength; i++) {
					fileInfo = new FileInformation();

					// ファイル名前を取得する
					String fileName = file[i].getName().toString();

					// 拡張子を取得する
					String pix = this.postfix(fileName);

					String icopix = pix + ".gif";

					String realPath = pageContext.getServletContext().getRealPath("/");

					realPath += fileIcoPath + icopix;

					File imageFile = new File(realPath);

					if (!imageFile.exists()) {
						fileInfo.setIncoPath(urlBase + fileIcoPath + "pub.gif");
					} else {
						fileInfo.setIncoPath(urlBase + fileIcoPath + icopix);
					}

					// 必要なNodeListを取得するドキュメント
					NodeList Documents = XmlOperator.getNodeList(job, "Document");

					Element document = (Element) Documents.item(0);
					//　ファイル名前の設定
					fileInfo.setFileName(PartCommon.getTagId(document, fileName));

					//　パスのの設定
					fileInfo.setFileSrc(url + fileName);

					fileList.add(fileInfo);
				}

				// HTML作成
				strHtml = createDownLoadHtml(fileList, strtagDownLoadLable, strtagColspan);

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

	/**
	 * 拡張子取得する
	 * @param String fileName  ファイル名前
	 * @return　String
	 */
	private String postfix(String fileName) {
		if (fileName != null && !"".equals(fileName)) {
			return fileName.substring(fileName.indexOf(".") + 1, fileName.length());
		} else {

			// HTMLを戻る
			return null;
		}
	}

	/**
	 * 編集の場合、HTML作成
	 * @param List fileList ファイルリスト
	 * @return String
	 */
	private String createDownLoadHtml(List<FileInformation> fileList, String strtagDownLoadLable,
			String strtagColspan) {

		// HTML設定
		String strHtml = "<tr align='left' bgcolor='#ffffff' valign='middle'>\n" + "<TD>"
				+ strtagDownLoadLable + "</TD>" + "<TD width=500 colspan = " + strtagColspan
				+ " nowrap>\n" + "<TABLE cellpadding='0' cellspacing='0' width=500>\n" + "<TR>\n";

		FileInformation fileInfo = null;

		// ファイルの長度を取得する
		int length = fileList.size();
		for (int i = 0; i < length; i++) {

			if (i != 0 && i % 5 == 0) {
				strHtml = strHtml + "</TR>\n";
				strHtml = strHtml + "<TR>\n";
			}

			strHtml = strHtml + "<TD width=150>\n";

			fileInfo = fileList.get(i);

			// HTML作成
			strHtml = strHtml + "<img src='" + fileInfo.getIncoPath() + "'/><BR>\n"

			+ "<A target='_blank' href='" + fileInfo.getFileSrc() + "'/>\n"

			+ fileInfo.getFileName() + "</A>\n";

			strHtml = strHtml + "</TD>\n";

		}

		// HTML作成
		strHtml = strHtml + "</TR>\n";
		strHtml = strHtml + "</TABLE>\n";
		strHtml = strHtml + "</TD>\n";
		strHtml = strHtml + "</TR>\n";

		// HTMLを戻る
		return strHtml;
	}
}
