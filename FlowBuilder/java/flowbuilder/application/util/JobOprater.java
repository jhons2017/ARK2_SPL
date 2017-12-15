package flowbuilder.application.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fbcom.framework.exceptions.XmlAccessSysException;
import flowbuilder.application.user.UserService;
import flowbuilder.application.user.UserServiceFactory;
import flowbuilder.dao.joblist.JobListDAO;
import flowbuilder.dao.joblist.JobListDataAccessFactroy;
import flowbuilder.daoimpl.db.DBXmlFileConn;
import flowbuilder.daoimpl.db.XmlFileProperity;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.domain.jobctrl.JobControl;
import flowbuilder.domain.joblist.JobList;
import flowbuilder.domain.user.User;
import flowbuilder.presentation.webcmn.taglibs.common.PartCommon;

public class JobOprater {

	/** 
	 * ロギング
	 */
	private static final Log logger = LogFactory.getLog(JobOprater.class);
	
	private UserService userService = null;
	
	/** DAOファクトリの宣言 */
	private JobListDataAccessFactroy _jobListDaoFactory = null;

	private JobListDAO _jobListDAO = null;

	public JobOprater() {
		try {
			
			userService = UserServiceFactory.getUserServiceInstance();
			_jobListDaoFactory = JobListDataAccessFactroy
					.getFactory(SystemFactroyKey.JobListFactroyKey);
			_jobListDAO = _jobListDaoFactory.createJobListDAO();
		} catch (Exception e) {
			logger.error("ジョブリストの操作クラスを生成するのは失敗しました。");
		}
	}

	/**
	 * 初期状態の案件ファイルを作成する。
	 * 
	 * @param tempId　テンプレートID
	 * @param userID　ユーザID
	 * @param orgID　組織ID
	 * @return
	 * @throws XmlAccessSysException 
	 */
	public Document creatDoc(String tempId, String userID, String orgID)
			throws XmlAccessSysException {
		String nextStep = "";
		Document job = null;
		XmlFileProperity fileOpr = new XmlFileProperity("Path.Xml.File");

		try {
			//テンプレートのパース
			String filePath = fileOpr.getFileDirByID("template", tempId);
			// データXMLをロードする
			job = DBXmlFileConn.getDocument(filePath);

			// 必要なNodeListを取得する
			NodeList workFlowList = XmlOperator.getNodeList(job, "WorkFlow");

			Element workFlowElement = XmlOperator.getElement(workFlowList, 0);

			NodeList stepList = workFlowElement.getElementsByTagName("step");

			Element stepElement = XmlOperator.getElement(stepList, 0);

			NodeList stateList = stepElement.getElementsByTagName("state");

			Element stateElement = XmlOperator.getElement(stateList, 0);

			if (stateElement.getAttribute("active").equals("true")) {
				//
				NodeList operatorList = stepElement.getElementsByTagName("opr");

				// 操作エレメントを取得
				Element operatorElement = XmlOperator.getElement(operatorList,
						0);
				operatorElement.setAttribute("confirmTime", PartCommon.getCurTime());
				operatorElement.setAttribute("userid", userID);
				operatorElement.setAttribute("orgid", orgID);
				nextStep = operatorElement.getAttribute("go_step");
			}
			stateElement.setAttribute("active", Boolean.FALSE.toString());

			int stepListSize = stepList.getLength();
			for (int i = 0; i < stepListSize; i++) {
				//
				Element tempStepElement = XmlOperator.getElement(stepList, i);

				NodeList tempStateList = tempStepElement
						.getElementsByTagName("state");
				Element tempStateElement = XmlOperator.getElement(
						tempStateList, 0);

				if (tempStateElement.getAttribute("current").equals(nextStep)) {
					tempStateElement.setAttribute("active", Boolean.TRUE
							.toString());
					break;
				}
			}
		} catch (NullPointerException e) {
			throw new XmlAccessSysException("初期状態の案件ファイルを作成するエラー");
		}

		return job;
	}

	//============================================================
	//案件作成
	//============================================================
	public void createNewJob(Document flow, String strUserID, String userName,
			String strOrgID, String strRoleID, String strJobID, String userIp,
			String tempId) {
		try {
			if (flow != null) {

				//Jobエレメントを取得する
				Element jobinfoElement = XmlOperator.getElement(XmlOperator
						.getNodeList(flow, "jobinfo"), 0);

				//属性値を設定する
				XmlOperator.setAttrValue(jobinfoElement, "title", "");

				//属性値を設定する
				XmlOperator.setAttrValue(jobinfoElement, "name", userName);

				//属性値を設定する
				XmlOperator.setAttrValue(jobinfoElement, "userid", strUserID);

				//属性値を設定する
				XmlOperator.setAttrValue(jobinfoElement, "orgid", strOrgID);

				//属性値を設定する
				XmlOperator.setAttrValue(jobinfoElement, "roleid", strRoleID);

				//属性値を設定する
				XmlOperator.setAttrValue(jobinfoElement, "jobid", strJobID);

				//属性値を設定する
				XmlOperator.setAttrValue(jobinfoElement, "cur_org", strOrgID);

				//属性値を設定する
				XmlOperator.setAttrValue(jobinfoElement, "userip", userIp);

				//属性値を設定する
				XmlOperator.setAttrValue(jobinfoElement, "tempId", tempId);

			}
		}

		catch (Exception e) {
			logger.error("案件作成は失敗しました。");
		}

	}

	//============================================================
	//案件保存ドキュメント保存
	//============================================================
	public boolean saveDocXml(Document doc, List<JobControl> parameters) {

		boolean bResult = false;

		try {
			String[] strDocName; //

			String[] strDocValue; //

			String strName = "StuName1/StuName2/StuName3/StuName4/StuName5/StuName6/StuName7/StuName8/StuName9/StuName10/StuName11/StuName12/StuName13/StuName14/StuName15/StuName16/StuName17/StuName18/StuName19/StuName20";

			int intCount = 0; //

			int intElementCount = 0; //

			int length = parameters.size();

			String[] tokens = strName.split("/");

			//リクエスト数を数える
			for (int i = 0; i < length; i++) {

				//エレメント名を取得する
				JobControl parameter = parameters.get(i);

				String parameterName = parameter.getParamName();

				//内容ない項目を除く
				if (parameterName == null || parameterName.equals("")) {
					break;
				} else {

					//ドキュメント項目を数える
					if ((!parameterName.equals("action"))
							&& (!parameterName.equals("recordId"))
							&& (!parameterName.equals("fb_jobname"))) {
						intElementCount++;
					}
				}
			}

			//エレメントタブ名と値を保存する変数を作成
			strDocName = new String[intElementCount];

			//エレメント内容を保存する変数を作成
			strDocValue = new String[intElementCount];

			//ドキュメント内容はあるか否かの判断
			if (intElementCount > 0) {

				//変数を初期化する
				for (int i = 0; i < intElementCount; i++) {
					//エレメント名変数を初期化
					strDocName[i] = null;

					//エレメント内容変数を初期化
					strDocValue[i] = null;
				}

				//リクエスト数を数える
				for (int i = 0; i < length; i++) {
					//エレメント名を取得する
					JobControl parameter = parameters.get(i);

					//
					String parameterName = parameter.getParamName();

					//
					if (parameterName == null || parameterName.equals("")) {
						break;
					} else {
						String strJobName = "";

						//案件名の特定処理
						if ("fb_jobname".equals(parameterName)) {
							//Jobエレメントを取得する
							Element jobinfoElement = XmlOperator.getElement(
									XmlOperator.getNodeList(doc, "jobinfo"), 0);

							//案件名を取得する
							strJobName = parameter.getParamValue();

							//案件名を案件情報へ記入する
							XmlOperator.setAttrValue(jobinfoElement,"title", strJobName);
						}

						//其の他情報の取得
						else if ((!strJobName.equals("act"))
								&& (!strJobName.equals("jobfile"))) {
							//
							strDocName[intCount] = parameterName;

							strDocValue[intCount] = parameter.getParamValue();
							//
							intCount++;
						}
					}
				}
			}

			if ("案件起案".equals(getCurrentState(doc))){
				delCompositControl(doc,"on");
			}
			
			//必要なNodeListを取得する
			NodeList documents = XmlOperator.getNodeList(doc, "Document");
			Element eleDocument = XmlOperator.getElement(documents, 0);
			for (int k = 0; k < tokens.length; k++) {

			for (int i = 0; i < intCount; i++) {

				NodeList strDocList = eleDocument.getElementsByTagName("control");

				int strDocListLength = strDocList.getLength();

				for (int j = 0; j < strDocListLength; j++) {
					Element strDocElement = XmlOperator.getElement(strDocList,j);

					String docName = XmlOperator.getAttrValue(strDocElement,"id");

					// 
				if (docName != null && docName.equals(strDocName[i]) ||docName.equals(tokens[k])) {
						//エレメントノードを削除する
						XmlOperator.removeElementNode(eleDocument,strDocElement);
						break;
					}
				}

				//新しい名称エレメントを作成する
				Element newElement = XmlOperator.createElement(doc, "control",strDocValue[i]);

				Attr newArrId = XmlOperator.createAttrbute(doc, "id",strDocName[i]);

				XmlOperator.setAttrNode(newElement, newArrId);

				if (newElement != null) {
					//ノードの子ノードのリストの末尾に、名称ノードを追加します。
					XmlOperator.appendElementNode(eleDocument, newElement);
				}
			}
			}
			//
			bResult = true;

			//品質保証
			logger.info("終了");
		} catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");

			//
			bResult = false;
		}

		//
		return bResult;
	}

	private void delCompositControl(Document doc, String flg) {
		
		NodeList documents = XmlOperator.getNodeList(doc, "Document");
		
		Element eleDocument = XmlOperator.getElement(documents, 0);
		
		NodeList strDocList = eleDocument.getElementsByTagName("control");
		
		int length = strDocList.getLength();

		for (int i = 0; i < length; i++) {
			Element conElm = XmlOperator.getElement(strDocList, i);
			
			if(conElm != null){
				Node docNode = conElm.getFirstChild();
				
				String docValue = docNode == null ? "" : docNode.getNodeValue();

				if (flg.equals(docValue)) {
					//エレメントノードを削除する
					XmlOperator.removeElementNode(eleDocument,conElm);
					i--;
				}
			}
		}
	}

	public void delDocXml(Document doc, List<JobControl> parameters) {
		NodeList Documents = XmlOperator.getNodeList(doc, "Document");

		Element Document = (Element) Documents.item(0);

		NodeList controlList = Document.getElementsByTagName("control");

		int controlListLength = controlList.getLength();

		for (int i = 0; i < controlListLength; i++) {

			Element controlElm = (Element) controlList.item(i);

			String controlName = XmlOperator.getAttrValue(controlElm, "id");

			int parmLength = parameters.size();

			JobControl jobCon = null;

			for (int j = 0; j < parmLength; j++) {
				jobCon = parameters.get(j);

				String paramName = jobCon.getParamName();

				if (controlName.equals(paramName)) {
					Document.removeChild(controlElm);
				}
			}
		}

	}

	//============================================================
	//フローの状態遷移
	//引数：
	//	Document doc		：	案件ドキュメント
	//	String strOpr		：	操作
	//	String strUserId	：	操作者ＩＤ
	//戻り値	：
	//	新しい状態
	//============================================================
	public String changeFlowState(Document doc, String strOprId,
			String strUserId, String strOrgId, JobList jobRecord) {

		String strExc = "";

		try {
			//品質保証
			logger.info("開始");

			//WorkFlowのNodeListを取得する
			NodeList workFlowList = XmlOperator.getNodeList(doc, "WorkFlow");

			//WorkFlowのエレメントを取得する
			Element workFlowElement = XmlOperator.getElement(workFlowList, 0);

			//StepのNodeListを取得する
			NodeList stepList = workFlowElement.getElementsByTagName("step");

			int stepListSize = stepList.getLength();
			//現在状態を特定する
			for (int i = 0; i < stepListSize; i++) {
				//Stepエレメントを取得する
				Element stepElement = XmlOperator.getElement(stepList, i);

				//状態のNodeListを取得する
				NodeList stateList = stepElement.getElementsByTagName("state");

				//状態のエレメントを取得する
				Element stateElement = XmlOperator.getElement(stateList, 0);

				//現在状態かどうかのチェック
				if (stateElement.getAttribute("active").equals("true")) {

					//現在状態の操作リストを取得する
					NodeList operatorList = stepElement.getElementsByTagName("opr");

					int operatorListSize = operatorList.getLength();

					//現在操作を特定する
					for (int j = 0; j < operatorListSize; j++) {
						//操作のエレメントを取得する
						Element operatorElement = XmlOperator.getElement(
								operatorList, j);

						//現在操作かどうかのチェック
						if (operatorElement.getAttribute("id").equals(strOprId)) {
							
							XmlOperator.setAttrValue(operatorElement, "confirmTime",
									PartCommon.getCurTime());

							//操作者ＩＤを記入する
							XmlOperator.setAttrValue(operatorElement, "userid",
									strUserId);

							//操作者組織ＩＤを記入する
							XmlOperator.setAttrValue(operatorElement, "orgid",
									strOrgId);

							//新しい状態を取得
							String strNewState = operatorElement
									.getAttribute("go_step");

							//新しい組織を取得
							String strGoOrgId = operatorElement
									.getAttribute("go_org");

							//新しい役割を取得
							String strGoRoleId = operatorElement
									.getAttribute("go_role");

							//状態遷移を行う
							setCurrentStep(doc, strNewState, strGoOrgId,
									strGoRoleId, jobRecord);

							//新しい状態
							strExc = strNewState;
						} else {
							
							XmlOperator.setAttrValue(operatorElement, "confirmTime",
									PartCommon.getCurTime());
							
							//操作者をクリアする
							XmlOperator.setAttrValue(operatorElement, "userid",
									"");

							//操作者組織をクリアする
							XmlOperator.setAttrValue(operatorElement, "orgid",
									"");
						}
					}
					break;
				}
			}

			//品質保証
			logger.info("終了");
		}

		catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");

			//
			strExc = e.toString();
		}

		//
		return (strExc);
	}

	//============================================================
	//フローの現在状態を取得する
	//============================================================
	public String getCurrentState(Document doc) {

		String strExc = "";
		try {

			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList workFlowList = XmlOperator.getNodeList(doc, "WorkFlow");

			if(workFlowList != null) {
				Element workFlowElement = XmlOperator.getElement(workFlowList, 0);
	
				if(workFlowElement != null){
					NodeList stepList = workFlowElement.getElementsByTagName("step");
		
					int size = stepList.getLength();
					//
					for (int i = 0; i < size; i++) {
						//
						Element stepElement = XmlOperator.getElement(stepList, i);
		
						//
						NodeList stateList = stepElement.getElementsByTagName("state");
		
						//
						Element stateElement = XmlOperator.getElement(stateList, 0);
		
						//
						if (stateElement.getAttribute("active").equals("true")) {
							//
							strExc = stateElement.getAttribute("current");
							break;
						}
					}
				}
			}
			//品質保証
			logger.info("終了");
		} catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー" + e.getMessage());
		}

		return (strExc);

	}

	//============================================================
	//作成者ＩＤを取得する
	//============================================================
	public String getCreatorID(Document doc) {

		String strExc = "";
		try {
			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			//
			Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

			//
			strExc = jobInfoElement.getAttribute("userid");

			//品質保証
			logger.info("終了");
		}

		catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");

			//
			strExc = e.toString();
		}

		return (strExc);
	}

	//============================================================
	//案件名を取得する
	//============================================================
	public String getJobName(Document doc) {

		String strExc = "";
		try {
			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			//
			Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

			//
			strExc = jobInfoElement.getAttribute("title");

			//品質保証
			logger.info("終了");

		}

		catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");

			//
			strExc = e.toString();
		}

		return (strExc);
	}

	//============================================================
	//開始時間を取得する
	//============================================================
	public String getStartTime(Document doc) {

		String strExc = "";
		try {
			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList Documents = XmlOperator.getNodeList(doc, "Document"); // ノッドリスト

			//
			Element docElement = (Element) Documents.item(0);

			// ドキュメントの値を取得する
			strExc = XmlOperator.getElementValue(docElement, "startdate");

			//品質保証
			logger.info("終了");

		}

		catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");

			//
			strExc = e.toString();
		}

		return (strExc);
	}

	//============================================================
	//終わって時間を取得する
	//============================================================
	public String getEndTime(Document doc) {

		String strExc = "";
		try {
			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList Documents = XmlOperator.getNodeList(doc, "Document"); // ノッドリスト

			//
			Element docElement = (Element) Documents.item(0);

			// ドキュメントの値を取得する
			strExc = XmlOperator.getElementValue(docElement, "enddate");

			//品質保証
			logger.info("終了");

		}

		catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");

			//
			strExc = e.toString();
		}

		return (strExc);
	}

	//============================================================
	//参照可能役割情報を取得する
	//============================================================
	public String getSeeRole(Document doc) {

		String strExc = "";
		try {
			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			//
			Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

			//案件を参照可能役割情報
			strExc = jobInfoElement.getAttribute("see_role");

			//品質保証
			logger.info("終了");

		}

		catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");

			//
			strExc = e.toString();
		}

		return (strExc);
	}

	//============================================================
	//参照可能組織情報を取得する
	//============================================================
	public String getSeeOrg(Document doc) {

		String strExc = "";
		try {
			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			//
			Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

			//案件を参照可能役割情報
			strExc = XmlOperator.getAttrValue(jobInfoElement, "see_org");

			//品質保証
			logger.info("終了");
		} catch (Exception e) {
			//品質保証
			logger.fatal("致命的なエラー");

			//
			strExc = e.toString();
		}

		return (strExc);
	}

	//============================================================
	//フロー現在組織ＩＤを取得する
	//============================================================
	public String getCurOrgID(Document doc) {

		String strExc = "";
		try {
			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			//
			Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

			//案件を参照可能役割情報
			strExc = XmlOperator.getAttrValue(jobInfoElement, "cur_org");

			//品質保証
			logger.info("終了");

		}

		catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");

			//
			strExc = e.toString();
		}

		return (strExc);
	}

	//============================================================
	//フロー現在組織ＩＤを取得する
	//============================================================
	public String getOrgID(Document doc) {

		String strExc = "";
		try {
			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			//
			Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

			//案件を参照可能役割情報
			strExc = XmlOperator.getAttrValue(jobInfoElement, "orgid");

			//品質保証
			logger.info("終了");

		}

		catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");

			//
			strExc = e.toString();
		}

		return (strExc);
	}

	//============================================================
	//フロー現在処理役割ＩＤを取得する
	//============================================================
	public String getCurRoleID(Document doc) {

		String strExc = "";
		try {
			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			//
			Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

			//案件を参照可能役割情報
			strExc = jobInfoElement.getAttribute("cur_role");

			//品質保証
			logger.info("終了");

		}

		catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");

			//
			strExc = e.toString();
		}

		return (strExc);
	}

	//============================================================
	//案件ＩＤを取得する
	//============================================================
	public String getJobID(Document doc) {

		String strExc = "";
		try {
			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			if (jobInfoList != null) {
				//案件情報エレメントを取得する
				Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

				if (jobInfoElement != null) {
					//
					strExc = jobInfoElement.getAttribute("jobid");
				} else {
					//品質保証
					logger.info("案件情報エレメントの取得に失敗しました。");
				}
			} else {

				//品質保証
				logger.info("案件情報ノードリストの取得に失敗しました。");
			}

			//品質保証
			logger.info("終了");

		}

		catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");

			//
			strExc = e.toString();
		}

		return (strExc);
	}

	//============================================================
	//案件情報を取得する
	//============================================================
	public String getJobInfo(Document doc, String strInfoTagName) {

		String strExc = "";
		try {
			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			if (jobInfoList != null) {
				//案件情報エレメントを取得する
				Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

				if (jobInfoElement != null) {
					//対応情報を取得する
					strExc = jobInfoElement.getAttribute(strInfoTagName);
				} else {
					//品質保証
					logger.info("案件情報エレメントの取得に失敗しました。");
				}
			} else {

				//品質保証
				logger.info("案件情報ノードリストの取得に失敗しました。");
			}

			//品質保証
			logger.info("終了");

		}

		catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");

			//
			strExc = e.toString();
		}

		return (strExc);
	}

	//============================================================
	//フロー現在組織ＩＤを設定する
	//============================================================
	public void setCurOrgID(Document doc, String strCurOrgID) {

		String strExc = "";
		try {
			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			//
			Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

			//案件を参照可能役割情報
			XmlOperator.setAttrValue(jobInfoElement, "cur_org", strCurOrgID);

			//品質保証
			logger.info("終了");

		}

		catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");

			//
			strExc = e.toString();
		}

	}

	//============================================================
	//フロー現在役割ＩＤを設定する
	//============================================================
	public void setCurRoleID(Document doc, String strCurRoleID) {

		String strExc = "";
		try {
			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			//
			Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

			//案件を参照可能役割情報
			XmlOperator.setAttrValue(jobInfoElement, "cur_role", strCurRoleID);

			//品質保証
			logger.info("終了");

		}

		catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");

			//
			strExc = e.toString();
		}

	}

	//============================================================
	//作成者名称を取得する
	//============================================================
	public String getCreatorName(Document doc) {

		String strExc = "";
		try {

			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			//
			Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

			//
			strExc = jobInfoElement.getAttribute("name");

			//品質保証
			logger.info("終了");

		}

		catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");

			strExc = e.toString();

		}

		return (strExc);

	}

	//============================================================
	//フローの現在タイトルを取得する
	//============================================================
	public String getCurrentStateName(Document doc) {

		String strExc = "";
		try {
			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList workFlowList = XmlOperator.getNodeList(doc, "WorkFlow");

			//
			Element workFlowElement = XmlOperator.getElement(workFlowList, 0);

			//
			NodeList stepList = workFlowElement.getElementsByTagName("step");

			//
			int size = stepList.getLength();
			for (int i = 0; i < size; i++) {

				//
				Element stepElement = XmlOperator.getElement(stepList, i);

				//
				NodeList stateList = stepElement.getElementsByTagName("state");

				//
				Element stateElement = XmlOperator.getElement(stateList, 0);

				//
				if (stateElement.getAttribute("active").equals("true")) {

					//
					strExc = stateElement.getAttribute("title");
				}
			}

			//品質保証
			logger.info("終了");

		} catch (Exception e) {
			//品質保証
			logger.fatal("致命的なエラー");

			//
			strExc = e.toString();
		}

		//
		return (strExc);
	}

	//============================================================
	//現在状態の操作情報を取得する
	//============================================================
	public int getCurrentOprInfo(Document doc, StringBuffer strOprIds,
			StringBuffer strActors, StringBuffer strOprNames) {

		//
		String strExc = "";

		//
		int intCount = 0;

		try {

			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList workFlowList = XmlOperator.getNodeList(doc, "WorkFlow");

			//
			Element workFlowElement = XmlOperator.getElement(workFlowList, 0);

			//
			NodeList stepList = workFlowElement.getElementsByTagName("step");

			int stepListSize = stepList.getLength();
			//
			for (int i = 0; i < stepListSize; i++) {

				//
				Element stepElement = XmlOperator.getElement(stepList, i);

				//
				NodeList stateList = stepElement.getElementsByTagName("state");

				//
				Element stateElement = XmlOperator.getElement(stateList, 0);

				//
				if (stateElement.getAttribute("active").equals("true")) {

					//
					NodeList operatorList = stepElement
							.getElementsByTagName("opr");

					int operatorListSize = operatorList.getLength();
					//
					for (int j = 0; j < operatorListSize; j++) {

						//操作エレメントを取得
						Element operatorElement = XmlOperator.getElement(
								operatorList, j);

						if (intCount == 0) {
							//操作子を保存
							strOprIds
									.append(operatorElement.getAttribute("id"));

							//動作子を保存
							strActors.append(operatorElement
									.getAttribute("act"));

							//操作名を保存
							strOprNames.append(operatorElement
									.getAttribute("name"));
						} else {
							//操作子を保存
							strOprIds.append(",").append(
									operatorElement.getAttribute("id"));

							//動作子を保存
							strActors.append(",").append(
									operatorElement.getAttribute("act"));

							//操作名を保存
							strOprNames.append(",").append(
									operatorElement.getAttribute("name"));
						}

						//個数を数える
						intCount++;
					}
				}
			}

			//品質保証
			logger.info("終了");

		}

		catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");

			//
			strExc = e.toString();
		}

		//
		return (intCount);
	}

	//============================================================
	//現在状態の操作子,を取得する
	//============================================================
	public int getCurrentOperator(Document doc, String[] strOprIds) {

		//
		String strExc = "";

		//
		int intCount = 0;

		try {

			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList workFlowList = XmlOperator.getNodeList(doc, "WorkFlow");

			//
			Element workFlowElement = XmlOperator.getElement(workFlowList, 0);

			//
			NodeList stepList = workFlowElement.getElementsByTagName("step");

			int stepListSize = stepList.getLength();
			//
			for (int i = 0; i < stepListSize; i++) {

				//
				Element stepElement = XmlOperator.getElement(stepList, i);

				//
				NodeList stateList = stepElement.getElementsByTagName("state");

				//
				Element stateElement = XmlOperator.getElement(stateList, 0);

				//
				if (stateElement.getAttribute("active").equals("true")) {
					//操作子リストを取得する
					NodeList operatorList = stepElement
							.getElementsByTagName("opr");

					int operatorListSize = operatorList.getLength();

					//操作子検索
					for (int j = 0; j < operatorListSize; j++) {
						//操作子を数える
						intCount++;

						//操作子エレメントを取得する
						Element operatorElement = XmlOperator.getElement(
								operatorList, j);

						//操作子IDを保存
						strOprIds[j] = operatorElement.getAttribute("id");
					}
				}
			}

			//品質保証
			logger.info("終了");
		}

		catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");

			//
			strExc = e.toString();
		}

		//
		return (intCount);
	}

	//============================================================
	//現在状態動作子を取得する
	//============================================================
	public int getCurrentActor(Document doc, String[] strActors) {

		String strExc = "";

		int intCount = 0;
		try {
			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList workFlowList = XmlOperator.getNodeList(doc, "WorkFlow");

			//
			Element workFlowElement = XmlOperator.getElement(workFlowList, 0);

			//
			NodeList stepList = workFlowElement.getElementsByTagName("step");

			int stepListSize = stepList.getLength();
			//
			for (int i = 0; i < stepListSize; i++) {
				//
				Element stepElement = XmlOperator.getElement(stepList, i);

				//
				NodeList stateList = stepElement.getElementsByTagName("state");

				//
				Element stateElement = XmlOperator.getElement(stateList, 0);

				//
				if (stateElement.getAttribute("active").equals("true")) {
					//
					NodeList operatorList = stepElement
							.getElementsByTagName("opr");

					int operatorListSize = operatorList.getLength();
					//
					for (int j = 0; j < operatorListSize; j++) {
						//
						intCount++;

						//
						Element operatorElement = XmlOperator.getElement(
								operatorList, j);

						//
						strActors[j] = operatorElement.getAttribute("act");
					}
				}
			}

			//品質保証
			logger.info("終了");
		}

		catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");

			//
			strExc = e.toString();
		}

		//
		return (intCount);
	}

	//============================================================
	//現在状態の操作名を取得する
	//============================================================
	public int getCurrentOprName(Document doc, String[] strOprNames) {

		String strExc = "";
		int intCount = 0;
		try {

			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList workFlowList = XmlOperator.getNodeList(doc, "WorkFlow");

			//
			Element workFlowElement = XmlOperator.getElement(workFlowList, 0);

			//
			NodeList stepList = workFlowElement.getElementsByTagName("step");

			int stepListSize = stepList.getLength();
			//
			for (int i = 0; i < stepListSize; i++) {
				//
				Element stepElement = XmlOperator.getElement(stepList, i);

				//
				NodeList stateList = stepElement.getElementsByTagName("state");

				//
				Element stateElement = XmlOperator.getElement(stateList, 0);

				//
				if (stateElement.getAttribute("active").equals("true")) {
					//
					NodeList operatorList = stepElement
							.getElementsByTagName("opr");

					int operatorListSize = operatorList.getLength();
					//
					for (int j = 0; j < operatorListSize; j++) {
						//
						intCount++;

						//
						Element operatorElement = XmlOperator.getElement(
								operatorList, j);

						//
						strOprNames[j] = operatorElement.getAttribute("name");
					}
				}
			}

			//品質保証
			logger.info("終了");
		}

		catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");

			//
			strExc = e.toString();
		}

		//
		return (intCount);
	}

	//============================================================
	//フローの遷移先ステップを取得する
	//============================================================
	public String getNextStep(Document doc, String strOprId) {

		String strExc = "";

		int intCount = 0;
		try {
			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList workFlowList = XmlOperator.getNodeList(doc, "WorkFlow");

			//
			Element workFlowElement = XmlOperator.getElement(workFlowList, 0);

			//
			NodeList stepList = workFlowElement.getElementsByTagName("step");

			int stepListSize = stepList.getLength();
			//
			for (int i = 0; i < stepListSize; i++) {
				//
				Element stepElement = XmlOperator.getElement(stepList, i);

				//
				NodeList stateList = stepElement.getElementsByTagName("state");

				//
				Element stateElement = XmlOperator.getElement(stateList, 0);

				//
				if (stateElement.getAttribute("active").equals("true")) {
					//
					NodeList operatorList = stepElement
							.getElementsByTagName("opr");

					int operatorListSize = operatorList.getLength();
					//
					for (int j = 0; j < operatorListSize; j++) {
						//
						Element operatorElement = XmlOperator.getElement(
								operatorList, j);

						//操作子ＩＤを比較する
						if (operatorElement.getAttribute("id").equals(strOprId)) {
							//遷移先ステップを取得する
							strExc = operatorElement.getAttribute("go_step");

							//検索終了
							break;
						}
					}
				}
			}

			//品質保証
			logger.info("終了");

		}

		catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");

			//
			strExc = e.toString();
		}

		//
		return (strExc);

	}

	//============================================================
	//フローの遷移先組織を取得する
	//============================================================
	public String getNextOrg(Document doc, String strOprId) {
		String strExc = "";

		int intCount = 0;
		try {
			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList workFlowList = XmlOperator.getNodeList(doc, "WorkFlow");

			//
			Element workFlowElement = XmlOperator.getElement(workFlowList, 0);

			//
			NodeList stepList = workFlowElement.getElementsByTagName("step");

			int stepListSize = stepList.getLength();
			//
			for (int i = 0; i < stepListSize; i++) {
				//
				Element stepElement = XmlOperator.getElement(stepList, i);

				//
				NodeList stateList = stepElement.getElementsByTagName("state");

				//
				Element stateElement = XmlOperator.getElement(stateList, 0);

				//
				if (stateElement.getAttribute("active").equals("true")) {

					//操作子リストを取得する
					NodeList operatorList = stepElement
							.getElementsByTagName("opr");

					int operatorListSize = operatorList.getLength();
					//検索開始
					for (int j = 0; j < operatorListSize; j++) {

						//操作子エレメントを取得する
						Element operatorElement = XmlOperator.getElement(
								operatorList, j);

						//操作子ＩＤを比較する
						if (operatorElement.getAttribute("id").equals(strOprId)) {

							//遷移先の組織ＩＤを取得する
							strExc = operatorElement.getAttribute("go_org");

							//検索終了
							break;
						}
					}
				}
			}

			//品質保証
			logger.info("終了");
		}

		catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");

			//
			strExc = e.toString();
		}

		//
		return (strExc);

	}

	//============================================================
	//ワークフローを遷移する
	//============================================================
	public void setCurrentStep(Document doc, String strCurrentStep,
			String strGoOrgId, String strGoRoleId, JobList joblist) {

		String strExc = "";

		try {

			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList workFlowList = XmlOperator.getNodeList(doc, "WorkFlow");

			//ワークフローエレメントを取得する
			Element workFlowElement = XmlOperator.getElement(workFlowList, 0);

			//ステップリストを取得する
			NodeList stepList = workFlowElement.getElementsByTagName("step");

			int stepListSize = stepList.getLength();
			//検索を開始する
			for (int i = 0; i < stepListSize; i++) {

				//ステップエレメントを取得する
				Element stepElement = XmlOperator.getElement(stepList, i);

				//状態リストを取得する
				NodeList stateList = stepElement.getElementsByTagName("state");

				//状態エレメントを取得する
				Element stateElement = XmlOperator.getElement(stateList, 0);

				//現在状態と比較する
				if (stateElement.getAttribute("current").equals(strCurrentStep)) {

					//現在状態は活動状態でなければ、活動状態にする
					if (!stateElement.getAttribute("active").equals("true")) {

						//新しいドキュメント数を設定する
						XmlOperator
								.setAttrValue(stateElement, "active", "true");

						//遷移後の現在役割設定
						setCurRoleID(doc, strGoRoleId);

						//遷移後の現在組織設定
						setCurOrgID(doc, strGoOrgId);

						//案件ＩＤを取得する
						String strJobId = getJobID(doc);

						//案件一覧の組織情報を修正する
						joblist.setCurOrg(strGoOrgId);
	
						//案件一覧の役割情報を修正する
						joblist.setCurRole(strGoRoleId);

						//案件一覧の状態を修正する
						joblist.setCurStatus(strCurrentStep);

						//対応一覧案件名を記入する
						_jobListDAO.update(joblist);
					}
				} else {

					//非現在状態を非活動にする
					if (stateElement.getAttribute("active").equals("true")) {

						//新しいドキュメント数を設定する
						XmlOperator.setAttrValue(stateElement, "active",
								"false");
					}
				}
			}

			//品質保証
			logger.info("終了");
		}

		catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");

			//
			strExc = e.toString();

		}
	}

	//============================================================
	//ワークフロー名称を取得する
	//============================================================
	public String getWorkFlowName(Document doc) {

		String strExc = "";
		try {

			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList workFlowList = XmlOperator.getNodeList(doc, "WorkFlow");

			//
			Element workFlowElement = XmlOperator.getElement(workFlowList, 0);

			//
			NodeList nameList = workFlowElement.getElementsByTagName("name");

			//
			Element nameElement = XmlOperator.getElement(nameList, 0);

			//
			strExc = nameElement.getFirstChild().getNodeValue();

			//品質保証
			logger.info("終了");

		}

		catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");

			//
			strExc = e.toString();
		}

		//
		return (strExc);
	}

	//============================================================
	//作成者ＩPを取得する
	//============================================================
	public String getCreatorIP(Document doc) {

		String strExc = "";
		try {
			//品質保証
			logger.info("開始");

			//必要なNodeListを取得する
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			//
			Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

			//
			strExc = jobInfoElement.getAttribute("userip");

			//品質保証
			logger.info("終了");
		}

		catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");

			//
			strExc = e.toString();
		}

		return (strExc);
	}
	
	//============================================================
	//承認者ＩPを取得する
	//============================================================
	public List<User> getApprovalerList(Document doc) {
		
		List<User> strExc = null;
		//String str = "";
		try {
			//品質保証
			logger.info("開始");

			String curOrgId = this.getCurOrgID(doc);
			
			String curRoleId = this.getCurRoleID(doc);
			
			if("".equals(curOrgId)) {
				curOrgId = this.getOrgID(doc);
			}
			

			strExc = userService.getUpUsersId(curOrgId,curRoleId);
			
			//品質保証
			logger.info("終了");
		}
		catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");
		}

		return strExc;
	}
	
	/**
	 * 
	 * @param docJob
	 * @param arrayUsers
	 */
	public void creatUserXml(Document docJob, String[] arrayUsers) {
		
		Node cirNode = docJob.getDocumentElement().getElementsByTagName("Circular").item(0);
		//ノードを削除
		XmlOperator.removeElementNode(docJob.getDocumentElement(),cirNode);
		//元素を作成する
		Element newCirNode = docJob.createElement("Circular");
		
		for (int i = 0;i < arrayUsers.length; i++){
			Element newMember = XmlOperator.createElement(docJob, "member", "");
			Attr newArrId = XmlOperator.createAttrbute(docJob, "id", arrayUsers[i]);
			XmlOperator.setAttrNode(newMember, newArrId);
			Attr newArrProblemFlg = XmlOperator.createAttrbute(docJob, "problemFlg", "0");
			XmlOperator.setAttrNode(newMember, newArrProblemFlg);
			Attr newConfirmTime = XmlOperator.createAttrbute(docJob, "confirmDate", "");
			XmlOperator.setAttrNode(newMember, newConfirmTime);
			XmlOperator.appendElementNode(newCirNode, newMember);
		}
		// newElementノードの子ノードのリストの末尾に、指定した文字列を追加します。
		XmlOperator.appendElementNode(docJob.getDocumentElement(), newCirNode);
		
	}
	
	
//	============================================================
	//回覧者を取得する
	//============================================================
	public List<User> getCirculePeople(Document doc) {
		String vog = "0";
		String temp = "";
		
		User user = null;
		List<User> strExc = new ArrayList<User>();
		NodeList membersList = XmlOperator.getNodeList(doc, "member");
		for(int j = 0; j < membersList.getLength(); j++) {
			Element memerElemen = XmlOperator.getElement(membersList, j);
			if(!"0".equals(XmlOperator.getAttrValue(memerElemen, "problemFlg"))) {
				temp = "";
				vog = "1";
				break;
			}
		}
		if("0".equals(vog)) {
			Element circulars = (Element) XmlOperator.getNodeList(doc, "Document").item(0);
			temp = PartCommon.getTagValue(circulars, "circularID");
			//String str = "";
			try {
				//品質保証
				logger.info("開始");
				String[] userList = temp.split(",");
				int userListLength = userList.length;
				
				for(int i=0;i<userListLength;i++) {
					user = userService.getUser(userList[i]);
					strExc.add(user);
				}
								
				//品質保証
				logger.info("終了");
			}
			catch (Exception e) {

				//品質保証
				logger.fatal("致命的なエラー");
			}
		} 
		return strExc;
	}
	

	/**
	 * 案件状態?更する
	 * @param Document doc ドキュメント
	 * @param String status 案件状態
	 * @return
	 */
	public int getStep(Document doc, String status) {
		int num = 0;

		// WorkFlowのNodeListを取得する
		NodeList workFlowList = XmlOperator.getNodeList(doc, "WorkFlow");
		
		// WorkFlowのエレメントを取得する
		Element workFlowElement = XmlOperator.getElement(workFlowList, 0);

		// StepのNodeListを取得する
		NodeList stepList = workFlowElement.getElementsByTagName("step");

		for (int i = 0; i < stepList.getLength(); i++) {

			// Stepエレメントを取得する
			Element stepElm = XmlOperator.getElement(stepList, i);
			
			// 状態のNodeListを取得する
			Element stepNode = (Element) stepElm.getElementsByTagName("state").item(0);
			
			// 状態リストを取得する
			String memberList = XmlOperator.getAttrValue(stepNode, "current");

			// 現在状態と比較する
			if (status.equals(memberList)) {
				num = i;
				break;
			}
		}
		return num;
	}

	/**
	 * 回覧者リストを取得する
	 * @param doc　案件ドキュメント
	 * ＠return userList List<User> 回覧者リスト
	 */
	public List<User> getCircularList(Document doc) {

		List<User> userList = new ArrayList<User>();

		Element circulars = (Element) XmlOperator.getNodeList(doc, "Document").item(0);
		// ドキュメントからノードリストを取得する
		String circularUsrIds = PartCommon.getTagValue(circulars, "circularID");
		try {
			//品質保証
			logger.info("開始");
			User user = null;
			String[] userIds = circularUsrIds.split(",");
			int userListLength = userIds.length;
			for (int i = 0; i < userListLength; i++) {
				// ユーザー情報を取得する
				user = userService.getUser(userIds[i]);
				userList.add(user);
			}			
			//品質保証
			logger.info("終了");
		} catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");
		}
		// 回覧者リストを返却する
		return userList;
	}
	
	/**
	 * 起案者を取得する
	 * @param doc　案件ドキュメント
	 * ＠return userList List<User> 起案者リスト
	 */
	public List<User> getCreater(Document doc) {

		List<User> userList = new ArrayList<User>();

		// ドキュメントからノードリストを取得する	
		Element creater = XmlOperator.getElement(XmlOperator.getNodeList(doc, "jobinfo"), 0);

		// 指定情報を取得する
		String createrUsrId = XmlOperator.getAttrValue(creater, "userid");
		try {
			//品質保証
			logger.info("開始");
			User user = null;
			String[] userIds = createrUsrId.split(",");
			int userListLength = userIds.length;
			for (int i = 0; i < userListLength; i++) {
				// ユーザー情報を取得する
				user = userService.getUser(userIds[i]);
				userList.add(user);
			}			
			//品質保証
			logger.info("終了");
		} catch (Exception e) {

			//品質保証
			logger.fatal("致命的なエラー");
		}
		// 起案者リストを返却する
		return userList;
	}
}
