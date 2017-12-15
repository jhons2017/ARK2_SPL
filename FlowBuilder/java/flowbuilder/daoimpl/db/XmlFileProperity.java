/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/03/06 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.daoimpl.db;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import flowbuilder.dao.conf.FlowBuilderSystemConfig;
import fbcom.framework.dao.conf.ConfigReader;

public final class XmlFileProperity {
	/**
	 * ログ
	 */
	Log logger = LogFactory.getLog(XmlFileProperity.class);

	//データXMLをロードする
	private Document filedoc = null;

	//ＸＭＬ操作用オブジェクト
	private XmlOperator opr = null;

	//******************************************************************************************************
	//コンストラクタ
	//******************************************************************************************************
	public XmlFileProperity(String implClassRef) {
		String filePath = "";
		try {
			ConfigReader conf = FlowBuilderSystemConfig.getInstance();
			filePath = conf.getValue(implClassRef);

			//データXMLをロードする
			filedoc = DBXmlFileConn.getDocument(filePath);

			//ＸＭＬ操作用オブジェクト
			opr = new XmlOperator();

			
		} catch (Exception e) {
			logger.fatal("致命的なエラー");
		}
	}

	//******************************************************************************************************
	//ファイル名を取得する
	//******************************************************************************************************
	public String getFileDir(String strManage, String strFileName) {

		String strExc = "";
		try {
			//エレメントを取得する
			Element manageElement = opr.getElement(opr.getNodeList(filedoc, strManage), 0);

			//管理範囲のファイルリストを取得する
			NodeList fileList = manageElement.getElementsByTagName("file");

			int size = fileList.getLength();

			for (int i = 0; i < size; i++) {
				Element fileElement = (Element) fileList.item(i);

				if (strFileName.equals(opr.getElementValue(fileElement, "name"))) {
					strExc = opr.getElementValue(fileElement, "dir") + strFileName;
					break;
				}
			}

			
		} catch (Exception e) {

			logger.fatal("致命的なエラー");

			//エラー情報
			strExc = e.toString();
		}

		//戻す
		return (strExc);
	}

	//******************************************************************************************************
	//ファイルＩＤにより、ファイル名を取得する
	//******************************************************************************************************
	public String getFileDirByID(String strManage, String strFileID) {

		String strExc = "";
		try {

			//エレメントを取得する
			Element manageElement = opr.getElement(opr.getNodeList(filedoc, strManage), 0);

			//管理範囲のファイルリストを取得する
			NodeList fileList = manageElement.getElementsByTagName("file");

			int size = fileList.getLength();

			for (int i = 0; i < size; i++) {
				Element fileElement = (Element) fileList.item(i);

				if (strFileID.equals(opr.getAttrValue(fileElement, "id"))) {
					strExc = opr.getElementValue(fileElement, "dir")
							+ opr.getElementValue(fileElement, "name");

				}
			}

			
		} catch (Exception e) {

			logger.fatal("致命的なエラー");

			//エラー情報
			strExc = e.toString();
		}

		//戻す
		return (strExc);
	}

	//******************************************************************************************************
	//ファイルＩＤにより、画面名を取得する
	//******************************************************************************************************
	public String getViewByID(String strManage, String strFileID) {

		String strExc = "";
		try {

			//エレメントを取得する
			Element manageElement = opr.getElement(opr.getNodeList(filedoc, strManage), 0);

			//管理範囲のファイルリストを取得する
			NodeList fileList = manageElement.getElementsByTagName("file");

			int size = fileList.getLength();

			for (int i = 0; i < size; i++) {
				Element fileElement = (Element) fileList.item(i);

				if (strFileID.equals(opr.getAttrValue(fileElement, "id"))) {
					strExc = opr.getElementValue(fileElement, "view");

				}
			}

			
		} catch (Exception e) {

			logger.fatal("致命的なエラー");

			//エラー情報
			strExc = e.toString();
		}

		//戻す
		return (strExc);

	}

	//******************************************************************************************************
	//ファイル情報を取得する
	//******************************************************************************************************
	public String getFileInfo(String strManage, String strFileName, String strTagName) {

		String strExc = "";
		try {

			//エレメントを取得する
			Element manageElement = opr.getElement(opr.getNodeList(filedoc, strManage), 0);

			//管理範囲のファイルリストを取得する
			NodeList fileList = manageElement.getElementsByTagName("file");
			int size = fileList.getLength();
			//検索開始
			for (int i = 0; i < size; i++) {

				//ファイルエレメントを取得
				Element fileElement = (Element) fileList.item(i);

				//ファイル名の比較
				if (strFileName.equals(opr.getElementValue(fileElement, "name"))) {

					//対応値を取得する
					strExc = opr.getElementValue(fileElement, strTagName);
				}
			}

			
		} catch (Exception e) {

			logger.fatal("致命的なエラー");

			//エラー情報
			strExc = e.toString();
		}

		//戻す
		return (strExc);

	}

	//******************************************************************************************************
	//案件ファイル名を作成
	//******************************************************************************************************
	public String createJobFileDir(String strJobId) {

		String strExc = "";
		try {

			//エレメントを取得する
			Element manageElement = opr.getElement(opr.getNodeList(filedoc, "job"), 0);

			//管理範囲のファイルリストを取得する
			NodeList fileList = manageElement.getElementsByTagName("file");

			//ファイルエレメントを取得
			Element fileElement = (Element) fileList.item(0);

			//新規案件ＸＭＬファイル名を取得
			strExc = opr.getElementValue(fileElement, "dir") + "job_" + strJobId + ".xml";

			
		} catch (Exception e) {

			logger.fatal("致命的なエラー");

			//エラー情報
			strExc = e.toString();
		}
		//戻す
		return (strExc);

	}

	//******************************************************************************************************
	//案件ファイル名を取得
	//******************************************************************************************************
	public String getJobFileDir(String strJobId) {

		String strExc = "";

		try {

			//エレメントを取得する
			Element manageElement = opr.getElement(opr.getNodeList(filedoc, "job"), 0);

			//管理範囲のファイルリストを取得する
			NodeList fileList = manageElement.getElementsByTagName("file");

			//ファイルエレメントを取得
			Element fileElement = (Element) fileList.item(0);

			//案件ＸＭＬファイル名を取得
			strExc = opr.getElementValue(fileElement, "dir") + "job_" + strJobId + ".xml";

		} catch (Exception e) {

			logger.fatal("致命的なエラー");

			//エラー情報
			strExc = e.toString();
		}
		//戻す
		return (strExc);

	}
}
