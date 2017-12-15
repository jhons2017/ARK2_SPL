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
package flowbuilder.application.jobctrl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.upload.FormFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import fbcom.framework.dao.conf.ConfigReader;
import fbcom.framework.exceptions.SysException;
import flowbuilder.application.util.CodeCreator;
import flowbuilder.application.util.JobOprater;
import flowbuilder.application.util.SystemFactroyKey;
import flowbuilder.application.util.email.EmailSender;
import flowbuilder.dao.conf.FlowBuilderSystemConfig;
import flowbuilder.dao.joblist.JobListDAO;
import flowbuilder.dao.joblist.JobListDataAccessFactroy;
import flowbuilder.dao.joblist.JobListQueryInfo;
import flowbuilder.dao.user.UserDAO;
import flowbuilder.dao.user.UserDataAccessFactroy;
import flowbuilder.daoimpl.db.DBXmlFileConn;
import flowbuilder.daoimpl.db.XmlFileProperity;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.domain.jobctrl.JobControl;
import flowbuilder.domain.jobctrl.JobCtrlParameter;
import flowbuilder.domain.joblist.JobList;
import flowbuilder.domain.user.User;
import flowbuilder.presentation.webcmn.taglibs.common.PartCommon;

;
/**
 * ログインサービスに共通するアプリケーションサービスの実装クラス <BR>
 */
final class JobControlServiceImpl implements JobControlService {
	/** ログ */
	private Log logger = LogFactory.getLog(JobControlServiceImpl.class);

	/** ファイルのパース */
	private String documentsXML = "";

	/** ドキュメント */
	private Document docJob = null;

	/** DAOファクトリの宣言 */
	private UserDataAccessFactroy _daoFactory = null;

	/** DAOファクトリの宣言 */
	private JobListDataAccessFactroy _jobListDaoFactory = null;

	/** ユーザーDAO */
	private UserDAO _userDAO;

	/** ジョブリストDAO */
	private JobListDAO _jobListDAO;

	/** ファイルインフォの取得 */
	private XmlFileProperity fileOpr = null;

	/** ジョブの操作 */
	private JobOprater jobOpr = null;

	/**
	 * コンストラクタ
	 * 
	 * @throws Exception
	 * 
	 * @throws SysException
	 *             システムエラーの場合
	 * 
	 */
	JobControlServiceImpl() throws SysException {
		// ファイルインフォの取得
		fileOpr = new XmlFileProperity("Path.Xml.File");
		// ジョブの操作
		jobOpr = new JobOprater();

		_daoFactory = UserDataAccessFactroy
				.getFactory(SystemFactroyKey.UserFactroyKey);
		_jobListDaoFactory = JobListDataAccessFactroy
				.getFactory(SystemFactroyKey.JobListFactroyKey);
		init();
	}

	/**
	 * 初期化処理
	 */
	private void init() {
		_userDAO = _daoFactory.createUserDAO();
		_jobListDAO = _jobListDaoFactory.createJobListDAO();
	}

	/**
	 * 操作フラグによって、特定の操作を実行する。
	 * 
	 * @param jobParameters
	 *            論理操作用のパラメータ
	 *            
	 * @throws SysException
	 *             システムのエラーが発生しました。<BR>
	 */
	public synchronized void jobControl(JobCtrlParameter jobParameters) throws SysException {
		try {
			
			// 操作フラグを取得する
			String oprFlg = jobParameters.getOprFlg();
			// 操作フラグを取得する
			String oprId = jobParameters.getOprId();
			// ジョブIDを取得する
			String jobId = jobParameters.getJobId();

			// ジョブIDがあらない場合
			if ("".equals(jobId) && "save".equals(oprFlg)) {
				jobId = CodeCreator.getJobNo();
				initDocument(jobParameters,jobId);
			}
			
			// 案件ドキュメントへ接続する
			documentsXML = fileOpr.getJobFileDir(jobId);
			docJob = DBXmlFileConn.getDocument(documentsXML);

			// 保存の操作
			if ("save".equals(oprFlg)) {
				// アップロードには特別に処理する
				this.saveUpload(jobParameters, jobId, oprFlg);
				
				//回覧の操作
				cirOperater(jobParameters);
				this.saveOperater(jobId, jobParameters.getParameters());
			// 削除の操作
			} else if ("delete".equals(oprFlg)) {
				this.delOperater(jobId);
			} else if ("disposal".equals(oprFlg)) {
				this.dispoalOperater(jobId);
			}

			if (!("apply".equals(oprId))){
				// ジョブリスト操作
				this.creatORUpdateJobList(oprId,jobParameters,jobId);
				
				// 案件状態を変更する
				this.changeStatus(oprFlg, jobParameters.getOprId(), jobParameters
						.getUserId(), jobParameters.getOrgId(), jobId);
				
				this.updateStatus(jobId);
			} else {
				circolarStatus(oprFlg, jobParameters,jobId);
			}	


			// メールを送る
			this.sendEmail(docJob,jobParameters.getTempId());
		} catch (Exception e) {
			throw new SysException("操作が失敗しました。");
		}
	}


	/** 回覧案件状態を変更する */
	private void circolarStatus(String oprFlg,JobCtrlParameter jobParameters,String jobId) {
		// ドキュメントから回覧人読む
		NodeList membersList = XmlOperator.getNodeList(docJob, "member");
		// 取得ログインユーザの情報
		int len = membersList.getLength();
		//操作フラグ
		boolean flg = true;
		for(int i = 0; i < len; i++) {
			Element memberEle = (Element) membersList.item(i);
			if(!("3".equals(memberEle.getAttribute("problemFlg")))) {
				flg = false;
				break;
			}
		}
		//全部で回覧者の状態が処理済、案件状態を変更する
		if(flg){
			this.changeStatus(oprFlg, jobParameters.getOprId(), jobParameters
					.getUserId(), jobParameters.getOrgId(),jobId);
		}

	}
		
	/**
	 * 回覧部品の操作
	 * 
	 *  @param docElement
	 *            	ドキュメント
	 *  @param oprId
	 *            	回覧部品の操作ID
	 *	@param userId
	 *            	ログインユーザ                  
	 * @throws SysException 
	 */
	private void cirOperater(JobCtrlParameter parameters) throws SysException {
		// ジョブIDを取得する
		String strUserId = parameters.getUserId();
		
		// ジョブIDを取得する
		String tempId = parameters.getTempId();
		
		// ジョブIDを取得する
		String jobId = parameters.getJobId();
		
		//操作フラグを取得する
		String oprId = parameters.getOprId();
		
		//回覧の操作
		ConfigReader conf = FlowBuilderSystemConfig.getInstance();
		String className = conf.getValue("Circular");
		//模型されい選択
		if (className.indexOf(tempId) != -1){
			//起案と保存の操作
			if("start".equals(oprId) || "save".equals(oprId) || "confirm".equals(oprId)){
				saveCirOperater(jobId, parameters.getParameters());
			//回覧部品の操作
			} else {
				updateCirOperater(docJob, oprId, strUserId);
			}
		}
	}
	
	/**
	 * 回覧部品の操作
	 * 
	 *  @param docElement
	 *            	ドキュメント
	 *  @param oprId
	 *            	回覧部品の操作ID
	 *	@param userId
	 *            	ログインユーザ                  
	 * @throws SysException 
	 */
	private void updateCirOperater(Document docElement, String oprId, String userId) throws SysException {
		
		try {
			//ドキュメントから回覧人読む
			NodeList membersList = XmlOperator.getNodeList(docElement, "member");
			//取得ログインユーザの情報
			for(int i = 0; i < membersList.getLength(); i++) {
				Element memberEle = XmlOperator.getElement(membersList, i);
				if(XmlOperator.getAttrValue(memberEle,"id").equals(userId)){
					//回覧の操作より、problemFlgの値を修正
					if ("apply".equals(oprId)){
						XmlOperator.setAttrValue(memberEle,"problemFlg","3");
						XmlOperator.setAttrValue(memberEle,"confirmDate",PartCommon.getCurTime());
					}else if ("kakuninn".equals(oprId)) {
						XmlOperator.setAttrValue(memberEle,"problemFlg","1");
						XmlOperator.setAttrValue(memberEle,"confirmDate",PartCommon.getCurTime());
					}else if ("question".equals(oprId)) {
						XmlOperator.setAttrValue(memberEle,"problemFlg","2");
						XmlOperator.setAttrValue(memberEle,"confirmDate",PartCommon.getCurTime());
					}
					break;
				}
			}
		} catch (Exception e) {
			throw new SysException("操作が失敗しました。");
		}

	}
	
	/**
	 * 回覧情報を保存
	 *  @param jobId
	 *           ファイルID取得 	
	 *  @param parameters
	 *            	論理操作用のパラメータ
	 */
	private void saveCirOperater(String jobId, List<JobControl> parameters) {
		
		//　回覧ユーザID取得
		String strUsersId = "";
		
		//回覧ユーザIDリスト
		String[] arrayUsers;
		
		//操作
		JobOprater jobOprater = new JobOprater();
		
		try {
			int len = parameters.size();
			for(int i = 0; i < len; i++) {
				//circularIDの情報取得
				if("circularID".equals(((JobControl)parameters.get(i)).getParamName())) {
					
					//　回覧ユーザID取得
					strUsersId = ((JobControl)parameters.get(i)).getParamValue();
					break;
				}
			}
			
			//回覧ユーザIDリスト
			if(!"".equals(strUsersId)){
				arrayUsers = strUsersId.split(",");
				//回覧ｘｍｌを創建
				jobOprater.creatUserXml(docJob,arrayUsers);
			}
						
		} catch (Exception e) {
			// 品質保証
			logger.info("案件再度保存に失敗しました。");
		}

	}
	
	/**
	 * 保存の操作
	 */
	private void saveOperater(String jobId, List<JobControl> parameters) {

		// 案件ドキュメントを保存
		if (jobOpr.saveDocXml(docJob, parameters)) {

			// XMLファイルを保存する
			DBXmlFileConn.writeXml(docJob, documentsXML);
		} else {
			// 品質保証
			logger.info("案件再度保存に失敗しました。");
		}
	}

	/**
	 * 削除の操作
	 * 
	 * @throws
	 */
	private void delOperater(String jobId) {
		try {
			if (jobId != null && !"".equals(jobId)) {
				// 案件リストから案件削除
				_jobListDAO.delete(jobId);
			}
		} catch (Exception e) {
			logger.error("案件削除は失敗しました。");
		}
	}

	/**
	 * 破棄の操作
	 */
	private void dispoalOperater(String jobId) {
		try {
			File delFile = new File(documentsXML);
			// ジョブリストの削除
			this.delOperater(jobId);
			// ジョブファイルを削除しました。
			delFile.delete();
			// 案件リストから案件削除
			_jobListDAO.delete(jobId);
		} catch (Exception e) {
			logger.error("案件破棄は失敗しました。");
		}
	}

	/** 案件状態を変更する */
	private void changeStatus(String oprflg, String strOperator,
			String strUserId, String orgId, String jobId) {
		
		JobListQueryInfo _joblistQueryInfo = _jobListDaoFactory.createJobListQueryInfo();
		
		// 更新のリスト
		List<JobList> joblist = null;
		JobList jobRecord  = null;
		try {
			// 検索条件の設定
			_joblistQueryInfo.setJobId(jobId);

			// 検索を実行する
			joblist = _jobListDAO.getJobList(_joblistQueryInfo);
			
			if(joblist.size() != 0) {
				jobRecord = joblist.get(0);
			} else {
				jobRecord = new JobList();
			}

			if (!oprflg.equals("disposal")) {
				// 案件フローの状態遷移
				jobOpr.changeFlowState(docJob, strOperator, strUserId, orgId,
						jobRecord);

				// 案件XMLファイルを保存する
				DBXmlFileConn.writeXml(docJob, documentsXML);
			}
		} catch (Exception e) {
			logger.error("案件状態を変更するのは失敗しました。");
		}
	}

	/**
	 * ドキュメントの初期化操作
	 * 
	 * @param jobParameters
	 * @throws SysException
	 */
	private void initDocument(JobCtrlParameter jobParameters,String jobId)
			throws SysException {
		// 初期状態の案件ファイルを作成する。
		Document newJob = jobOpr.creatDoc(jobParameters.getTempId(),
				jobParameters.getUserId(), jobParameters.getOrgId());
		
		// 新しい案件ファイルの保存場所
		String strJobFileName = fileOpr.createJobFileDir(jobId);

		User user = _userDAO.select(jobParameters.getUserId());

		// 新しい案件のジョブインフォの追加
		jobOpr.createNewJob(newJob, jobParameters.getUserId(), user
				.getUserName(), jobParameters.getOrgId(), jobParameters
				.getRoleId(), jobId, jobParameters.getUserIp(), jobParameters
				.getTempId());

		// XMLファイルを保存する
		DBXmlFileConn.writeXml(newJob, strJobFileName);
	}

	/**
	 * アップロードには特別に処理する
	 * @param jobParameters
	 * @return
	 */
	private void saveUpload(JobCtrlParameter jobParameters, String jobId,
			String oprFlg) {
		
		// 案件状態を取得
		String jobCurStatus = jobOpr.getCurrentState(docJob);		
		String documentsXML = fileOpr.getJobFileDir(jobId);
		Document doc= DBXmlFileConn.getDocument(documentsXML);
		
		// 案件状態更新後を取得
		int jobFileChild2 = jobOpr.getStep(doc, jobCurStatus);
		
		if (jobParameters == null || jobId == null) {
			new SysException("アップロードが失敗しました。");
		}
		
		//　アップロードがない
		int flag = 0;

		FormFile[] files = jobParameters.getFiles();
		
		// ファイルの長度を取得する
		int length = files.length;

		for( int i = 0; i < length; i++) {
			if(files[i] == null) {
				continue;
			} else if (!"".equals(files[i].getFileName())) {
					// ファイルが選ぶ
					flag = 1;
					break;
			}

			// ファイルが選ばない
			flag = 2;
		}
		
		
		if (flag != 0) {
			ConfigReader conf = FlowBuilderSystemConfig.getInstance();
			String jobFilePath = conf.getValue("loadPath");

			// 新しいフォルダの追加
			File file = new File(jobFilePath + jobId);

			String jobFileChild = jobFilePath + jobId;

			// まずジョブIDによって、フォルダの中には削除する
			deleteFile(jobId, file, jobCurStatus, jobFileChild, jobFileChild2);

			if (flag == 1) {
				uploadFile(files, file, jobParameters, jobFileChild, jobCurStatus, jobId, jobFileChild2);
			}
		}
	}
	
	/**
	 * ファイルのアップロード
	 * @param FormFile[]　files　ファイル
	 * @param file　File　ファイル
	 * @param jobParameters
	 */
	private void uploadFile(FormFile[] files, File file,
			JobCtrlParameter jobParameters, String jobFileChild,
			String jobCurStatus, String jobId, int jobFileChild2) {
	
		List<JobControl> jobControls = new ArrayList<JobControl>();
		JobControl jobCtrl = null;
		int length = jobParameters.getParameters().size();
		
		for(int i=0; i < length; i++){
			jobCtrl = new JobControl();
			jobCtrl.setParamName(jobParameters.getParameters().get(i).getParamName());
			jobCtrl.setParamValue(jobParameters.getParameters().get(i).getParamValue());
			jobControls.add(jobCtrl);
		}


		try {

			// 新しいフォルダの追加
			file.mkdir();
			File file2 = new File(jobFileChild + "//" + jobFileChild2);
			file2.mkdir();

			// アップロード
			for (int i = 0; i < files.length; i++) {
				if (files[i] != null && !"".equals(files[i].getFileName())) {

					// ファイルを取得する
					InputStream stream = files[i].getInputStream();

					// 新しいファイルの取得する
					OutputStream bos = new FileOutputStream(file2.getPath()
							+ "/"
							+ getUUidFileName(files[i].getFileName(),
									jobControls));
					int bytesRead = 0;
					byte[] buffer = new byte[8192];

					// ファイルを入力
					while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
						bos.write(buffer, 0, bytesRead);
					}
					bos.close();
					stream.close();
					
					//　ファイル名前を削除する
					
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
	
	/**
	 * UUIDファイル名前を取得する
	 * 
	 * @param fileName ファイル名前
	 * @param jobParameters パラメータ
	 * @return String uuidFileName uuidファイル名前
	 */
	private String getUUidFileName(String fileName,
			List<JobControl> jobControls) {
		String uuidFileName = "";

		int length = jobControls.size();

		boolean controlFlg = true;

		for (int index = 0; controlFlg && index < length; index++) {
			String paramValue = jobControls.get(index).getParamValue();
			if (fileName.equals(paramValue)) {
				uuidFileName = jobControls.get(index).getParamName();
				jobControls.get(index).setParamValue("");
				controlFlg = false;
			}
		}
		return uuidFileName;
	}
	
	
	/**
	 * フォルダの中には削除する
	 * 
	 * @param String jobId ジョブパID
	 * @param file  File ファイル
	 */
	private void deleteFile(String jobId, File file, String jobCurStatus,
			String jobFileChild, int jobFileChild2) {

		// まずジョブIDによって、フォルダの中には削除する
		try {
			ConfigReader conf = FlowBuilderSystemConfig.getInstance();

			File fileAll = new File(jobFileChild + "//" + jobFileChild2);

			String jobFilePath = conf.getValue("loadPath");
			// ファイル削除します
			if (!fileAll.isDirectory()) {
				fileAll.delete();
				file.delete();

				// ファイル削除します
			} else if (fileAll.isDirectory()) {
				String[] filelist = fileAll.list();
				int filelistlength = filelist.length;
				for (int i = 0; i < filelistlength; i++) {
					File delFile = new File(jobFilePath + jobId + "\\" + jobFileChild2 + "\\" + filelist[i]);

					// フォルダ削除します
					if (!delFile.isDirectory())
						delFile.delete();

					// フォルダ削除します
					else if (delFile.isDirectory())
						deleteFile(jobFilePath + jobId + "\\" + jobFileChild2 + "\\" + filelist[i], file, jobCurStatus,
								jobFileChild, jobFileChild2);
				}
				fileAll.delete();
				file.delete();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 
	 * @param doc
	 * @param jobId
	 */
	private void sendEmail(Document doc,String templateId){
		
		if(doc != null){
			String curState = jobOpr.getCurrentState(doc);
			EmailSender emailSender = new EmailSender(templateId,curState,doc);
			Thread thread = new Thread(emailSender);
			thread.start();
		}
	}
	
	
	private void creatORUpdateJobList(String oprFlg,JobCtrlParameter jobParameters,String jobId){
		JobListQueryInfo _joblistQueryInfo = _jobListDaoFactory.createJobListQueryInfo();
		
		// 更新のリスト
		List<JobList> joblist = null;
		JobList jobRecord = null;
		
		if("save".equals(oprFlg) || "confirm".equals(oprFlg) || "start".equals(oprFlg)) {
			try{
				// 検索条件の設定
				_joblistQueryInfo.setJobId(jobId);
		
				// 検索を実行する
				joblist = _jobListDAO.getJobList(_joblistQueryInfo);
				
				// 新規状態
				if(joblist.size() == 0) {
					jobRecord = new JobList();
					
					// テンプレートに対応する画面を取得する
					String view = fileOpr.getViewByID("template", jobParameters.getTempId());
	
					// ジョブID
					jobRecord.setJobId(jobId);
					// ジョブ名前
					jobRecord.setJobName(jobParameters.getJobName());
					// 起案者組織ID
					jobRecord.setOrgId(jobParameters.getOrgId());
					// 起案者ルールID
					jobRecord.setRoleId(jobParameters.getRoleId());
					// テンプレートID
					jobRecord.setTemplateId(jobParameters.getTempId());
					// ユーザID
					jobRecord.setUserId(jobParameters.getUserId());

					jobRecord.setView(view);
	
					// ジョブリスト記録の追加
					_jobListDAO.insert(jobRecord);
				//　更新状態
				}else {
					jobRecord = joblist.get(0);
					
					String jobName = jobParameters.getJobName();
					if(!"".equals(jobName)) {
						jobRecord.setJobName(jobName);
					}
					
					//対応一覧案件名を記入する
					_jobListDAO.update(jobRecord);
				}
			} catch(Exception e){
				logger.fatal("JobControlService: CreatORUpdateJobList エラー");
				logger.fatal(e.getMessage());
			}
		}
	}
	
	// 更新ジョブリスト状態
	private void updateStatus(String jobId) {
		JobListQueryInfo _joblistQueryInfo = _jobListDaoFactory.createJobListQueryInfo();
		
		// 検索条件の設定
		_joblistQueryInfo.setJobId(jobId);
		
		// 検索を実行する
		try {
			List<JobList> joblist = _jobListDAO.getJobList(_joblistQueryInfo);
			// 新規状態
			if(joblist.size() != 0) {
				JobList jobRecord = joblist.get(0);
				//　今状態
				jobRecord.setCurStatus(jobOpr.getCurrentState(docJob));
				
				_jobListDAO.update(jobRecord);
			}
		} catch (SysException e) {
			logger.fatal("JobControlService: updateStatus エラー");
			logger.fatal(e.getMessage());
		}
	}
}