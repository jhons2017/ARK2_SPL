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
package flowbuilder.application.jobshow;

import org.w3c.dom.Document;

import fbcom.framework.exceptions.SysException;
import flowbuilder.application.util.JobOprater;
import flowbuilder.application.util.SystemFactroyKey;
import flowbuilder.dao.user.UserDAO;
import flowbuilder.dao.user.UserDataAccessFactroy;
import flowbuilder.daoimpl.db.DBXmlFileConn;
import flowbuilder.daoimpl.db.XmlFileProperity;
import flowbuilder.domain.joblist.JobList;
import flowbuilder.domain.jobshow.JobShow;
import flowbuilder.domain.user.User;

;
/**
 * ログインサービスに共通するアプリケーションサービスの実装クラス <BR>
 */
final class JobShowServiceImpl implements JobShowService {

	/** DAOファクトリの宣言 */
	private UserDataAccessFactroy _daoFactory = null;

//	/** DAOファクトリの宣言 */
//	private JobListDataAccessFactroy _jobListDaoFactory = null;

	/** ユーザーDAO */
	private UserDAO _userDAO;

	/** ファイルインフォの取得 */
	private XmlFileProperity fileOpr = null;

	/** ジョブの操作 */
	private JobOprater jobOpr = null;

	/**
	 * コンストラクタ
	 * 
	 * @throws Exception
	 * 
	 * @throws SysException システムエラーの場合
	 * 
	 */
	JobShowServiceImpl() throws SysException {
		//ファイルインフォの取得
		fileOpr = new XmlFileProperity("Path.Xml.File");
		//ジョブの操作
		jobOpr = new JobOprater();

		_daoFactory = UserDataAccessFactroy.getFactory(SystemFactroyKey.UserFactroyKey);
//		_jobListDaoFactory = JobListDataAccessFactroy
//				.getFactory(SystemFactroyKey.JobListFactroyKey);
		init();
	}

	/**
	 * 初期化処理
	 */
	private void init() {
		_userDAO = _daoFactory.createUserDAO();
	}

	
	/**
	 * 部品操作用の新しいジョブの取得して、JSP画面用のBEANを戻る。
	 * 
	 * @param joblist　論理操作用のパラメータ
	 * @param userIp　ユーザIP
	 * @return　JSP画面用のBEAN
	 * @throws SysException　
	 *  		システムのエラーが発生しました。<BR>
	 */
	public JobShow getNewJobShow(JobList joblist,String userIp) throws SysException {

		// 案件詳細画面パラメータBean
		JobShow jobshow = new JobShow();

		//ジョブリストの中には、値を取得する
		String strUserID = joblist.getUserId();
		String strJobId = joblist.getJobId();
		String strOrgId = joblist.getOrgId();
		String strTempId = joblist.getTemplateId();

		//ユーザインフォの取得
		User user = _userDAO.select(strUserID);
		//初期状態の案件ファイルを作成する。
		Document newJob = jobOpr.creatDoc(strTempId, strUserID, strOrgId);

		if (newJob != null) {
			//テンプレートに対応する画面を取得する
			String view = fileOpr.getViewByID("template", strTempId);
			//ユーザの名前
			String strUserName = user.getUserName();
					
			//ジョブリスト記録の作成
			joblist.setView(view);
			//ユーザＩＤの設定
			jobshow.setUserId(strUserID);
			//組織ＩＤの設定
			jobshow.setOrgId(strOrgId);
			//Template IDの設定
			jobshow.setTemplateId(strTempId);
			//ユーザ名の設定
			jobshow.setUserName(strUserName);
			//ジョブIDの設定
			jobshow.setJobId(strJobId);
			//ジョブドキュメントの設定
			jobshow.setJob(newJob);
			//ユーザIPの設定
			jobshow.setUserIp(userIp);		
			//テンプレートに対応する画面の設定
			jobshow.setView(view);	

		} else {
			new SysException("テンプレートドキュメントの取得に失敗しました。");
		}
		
		return jobshow;
	}

	/**
	 * あった案件を取得して、JSP画面用のBEANを戻る。
	 * 
	 * @param joblist　論理操作用のパラメータ
	 * @return　JSP画面用のBEAN
	 * @throws SysException
	 *  		システムのエラーが発生しました。<BR>
	 */
	public JobShow getJobShow(JobList joblist) throws SysException {

		// 案件詳細画面パラメータBean
		JobShow jobshow = new JobShow();

		//ジョブリストの中には、値を取得する
		String strJobId = joblist.getJobId();
		String documentsXML = fileOpr.getJobFileDir(strJobId);
		
		//案件ファイルを取得する。
		Document doc= DBXmlFileConn.getDocument(documentsXML);
		
		String strTempId = jobOpr.getJobInfo(doc, "tempId");
		String strUserID = jobOpr.getCreatorID(doc);
		String strOrgId = jobOpr.getOrgID(doc);
		
		//ユーザインフォの取得
		User user = _userDAO.select(strUserID);
		
		if (doc != null) {
			//テンプレートに対応する画面を取得する
			String view = fileOpr.getViewByID("template", strTempId);
			//ユーザの名前
			String strUserName = user.getUserName();
			//　ユーザIPを取得する
			String strUserIp  = jobOpr.getCreatorIP(doc);

			//ユーザＩＤの設定
			jobshow.setUserId(strUserID);
			//組織ＩＤの設定
			jobshow.setOrgId(strOrgId);
			//Template IDの設定
			jobshow.setTemplateId(strTempId);
			//ユーザ名の設定
			jobshow.setUserName(strUserName);
			//ジョブIDの設定
			jobshow.setJobId(strJobId);
			//ジョブドキュメントの設定
			jobshow.setJob(doc);
			//ユーザIPの設定
			jobshow.setUserIp(strUserIp);
			//テンプレートに対応する画面の設定
			jobshow.setView(view);	

		} else {
			new SysException("テンプレートドキュメントの取得に失敗しました。");
		}
		
		return jobshow;
	}

}