/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/26
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/04/26 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.daoimpl.flowbuilder.joblist;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import fbcom.framework.exceptions.SysException;
import fbcom.framework.exceptions.XmlAccessSysException;
import flowbuilder.dao.joblist.JobListDAO;
import flowbuilder.dao.joblist.JobListQueryInfo;
import flowbuilder.daoimpl.db.DBXmlFileConn;
import flowbuilder.daoimpl.db.XmlFileProperity;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.domain.joblist.JobList;

/**
 * ジョブリストファイルのDAO操作を実現する。
 */
final class JobListDAOImpl implements JobListDAO {
	/**
	 * ロギング
	 */
	private static Log _log = LogFactory.getLog(JobListDAOImpl.class);
	
	/**
	 * ファイルのパース
	 */
	private String jobListXmlPath = "";

	/**
	 * 「job.xml」ファイルを接続し、ドキュメントを取得する。
	 */
	public JobListDAOImpl() {
		// ファイル操作のクラスを生成する。
		XmlFileProperity fileconn = new XmlFileProperity("Path.Xml.File");

		// ファイルのパースを取得する。
		jobListXmlPath = fileconn.getFileDir("manage", "job_list.xml");
	}

	/**
	 * 条件によって、ジョブリストで記録の数量を戻る
	 * 
	 * @param query
	 *            検索条件
	 * @return ジョブリストで記録の数量
	 * @throws SysException
	 *             xmlファイルに操作のうちに、エラーが発生する
	 */
	public int getCount(JobListQueryInfo query) throws SysException {
		// ドキュメントの取得
		Document filedoc = DBXmlFileConn.getDocument(jobListXmlPath);
		
		// ジョブリストで記録の数量
		int jobCount = 0;

		// 条件はではない
		if (query == null) {
			_log.error("「JobListQueryInfo」はではない、エラーが発生しました。");
			throw new SysException("「JobListQueryInfo」はではない、エラーが発生しました。");
		}

		try {
			// 必要なNodeListを取得する
			NodeList jobNodeList = XmlOperator.getNodeList(filedoc, "job");

			int jobListLength = jobNodeList.getLength();

			for (int i = 0; i < jobListLength; i++) {
				Element jobListElm = (Element) jobNodeList.item(i);

				// 現在の組織を比べる。
				if (query.getCurOrg() != null) {
					// 条件が満足しない
					if (!compareQuenInfo(jobListElm, query.getCurOrg(), "cur_org")) {
						continue;
					}
				}

				// 現在のルールを比べる。
				if (query.getCurRole() != null) {
					// 条件が満足しない
					if (!compareQuenInfo(jobListElm, query.getCurRole(), "cur_role")) {
						continue;
					}
				}

				// 現在の状態を比べる。
				if (query.getCurStatus() != null) {
					// 条件が満足しない
					if (!compareQuenInfo(jobListElm, query.getCurStatus(), "cur_status")) {
						continue;
					}
				}

				// 案件の起案日を比べる。
				if (query.getDate() != null) {
					// 条件が満足しない
					if (!compareQuenInfo(jobListElm, query.getDate(), "date")) {
						continue;
					}
				}

				// 案件IDを比べる。
				if (query.getJobId() != null) {
					// 条件が満足しない
					if (!compareQuenInfo(jobListElm, query.getJobId(), "jobid")) {
						continue;
					}
				}

				// 案件名前を比べる。
				if (query.getJobName() != null) {
					// 条件が満足しない
					if (!compareQuenInfo(jobListElm, query.getJobName(), "name")) {
						continue;
					}
				}

				// 起案者組織IDを比べる。
				if (query.getOrgId() != null) {
					// 条件が満足しない
					if (!compareQuenInfo(jobListElm, query.getOrgId(), "orgid")) {
						continue;
					}
				}

				// 起案者ルールIDを比べる。
				if (query.getRoleId() != null) {
					// 条件が満足しない
					if (!compareQuenInfo(jobListElm, query.getRoleId(), "roleid")) {
						continue;
					}
				}

				// テンプレートIDを比べる。
				if (query.getTemplateId() != null) {
					// 条件が満足しない
					if (!compareQuenInfo(jobListElm, query.getTemplateId(), "templateid")) {
						continue;
					}
				}

				// 起案者IDを比べる。
				if (query.getUserId() != null) {
					// 条件が満足しない
					if (!compareQuenInfo(jobListElm, query.getUserId(), "userid")) {
						continue;
					}
				}

				// 案件に対応する画面IDを比べる。
				if (query.getView() != null) {
					// 条件が満足しない
					if (!compareQuenInfo(jobListElm, query.getView(), "view")) {
						continue;
					}
				}

				jobCount++;
			}

		} catch (NullPointerException e) {
			_log.error(e.getMessage(), e);
			throw new XmlAccessSysException("Error.File.DataAccessFail");
		}

		//記録を戻る
		return jobCount;
	}

	/**
	 * ジョブリストを取得する
	 * 
	 * @param query
	 *            検索条件
	 * @return ジョブ記録を格納したリスト
	 * @throws SysException
	 *             xmlファイルに操作のうちに、エラーが発生する
	 */
	public List<JobList> getJobList(JobListQueryInfo query) throws SysException {
		// ドキュメントの取得
		Document filedoc = DBXmlFileConn.getDocument(jobListXmlPath);
		
		// ジョブリストで記録が格納する
		List<JobList> jobList = new ArrayList<JobList>();

		// 条件はではない
		if (query == null) {
			_log.error("「JobListQueryInfo」はではない、エラーが発生しました。");
			throw new SysException("「JobListQueryInfo」はではない、エラーが発生しました。");
		}

		try {
			// 必要なNodeListを取得する
			NodeList jobNodeList = XmlOperator.getNodeList(filedoc, "job");

			int jobListLength = jobNodeList.getLength();

			for (int i = 0; i < jobListLength; i++) {
				Element jobListElm = (Element) jobNodeList.item(i);

				// 現在の組織を比べる。
				if (query.getCurOrg() != null) {
					// 条件が満足しない
					if (!compareQuenInfo(jobListElm, query.getCurOrg(), "cur_org")) {
						continue;
					}
				}

				// 現在のルールを比べる。
				if (query.getCurRole() != null) {
					// 条件が満足しない
					if (!compareQuenInfo(jobListElm, query.getCurRole(), "cur_role")) {
						continue;
					}
				}

				// 現在の状態を比べる。
				if (query.getCurStatus() != null) {
					// 条件が満足しない
					if (!compareQuenInfo(jobListElm, query.getCurStatus(), "cur_status")) {
						continue;
					}
				}

				// 案件の起案日を比べる。
				if (query.getDate() != null) {
					// 条件が満足しない
					if (!compareQuenInfo(jobListElm, query.getDate(), "date")) {
						continue;
					}
				}

				// 案件IDを比べる。
				if (query.getJobId() != null) {
					// 条件が満足しない
					if (!compareQuenInfo(jobListElm, query.getJobId(), "jobid")) {
						continue;
					}
				}

				// 案件名前を比べる。
				if (query.getJobName() != null) {
					// 条件が満足しない
					if (!compareQuenInfo(jobListElm, query.getJobName(), "name")) {
						continue;
					}
				}

				// 起案者組織IDを比べる。
				if (query.getOrgId() != null) {
					// 条件が満足しない
					if (!compareQuenInfo(jobListElm, query.getOrgId(), "orgid")) {
						continue;
					}
				}

				// 起案者ルールIDを比べる。
				if (query.getRoleId() != null) {
					// 条件が満足しない
					if (!compareQuenInfo(jobListElm, query.getRoleId(), "roleid")) {
						continue;
					}
				}

				// テンプレートIDを比べる。
				if (query.getTemplateId() != null) {
					// 条件が満足しない
					if (!compareQuenInfo(jobListElm, query.getTemplateId(), "templateid")) {
						continue;
					}
				}

				// 起案者IDを比べる。
				if (query.getUserId() != null) {
					// 条件が満足しない
					if (!compareQuenInfo(jobListElm, query.getUserId(), "userid")) {
						continue;
					}
				}

				// 案件に対応する画面IDを比べる。
				if (query.getView() != null) {
					// 条件が満足しない
					if (!compareQuenInfo(jobListElm, query.getView(), "view")) {
						continue;
					}
				}

				//保存する
				jobList.add(retJob(jobListElm));
			}

		} catch (NullPointerException e) {
			_log.error(e.getMessage(), e);
			throw new XmlAccessSysException("Error.File.DataAccessFail");
		}

		//記録を戻る
		return jobList;
	}

	/**
	 * ジョブリストを追加する
	 * 
	 * @param joblist
	 *            ジョブ記録
	 * @throws SysException
	 *             xmlファイルに操作のうちに、エラーが発生する
	 */
	public void insert(JobList joblist) throws SysException {
		// ドキュメントの取得
		Document filedoc = DBXmlFileConn.getDocument(jobListXmlPath);
		
		try {
			if (filedoc != null && joblist != null) {
				Attr newArrId;

				// Documentsエレメントを取得する
				Element JobListElement = XmlOperator.getElement(XmlOperator.getNodeList(filedoc,
						"joblist"), 0);

				if (JobListElement == null) {
					// 品質保証
					_log.info("新しいエレメントの作成に失敗しました。");
				}

				// *****************************************************************************

				// 新しいドキュメントエレメントを作成する
				Element newJobElement = XmlOperator.createElement(filedoc, "job", "");

				if (newJobElement == null) {
					// 品質保証
					_log.info("新しいエレメントの作成に失敗しました。");
				}

				// =============================================================================

				// 属性ノードを作成する
				newArrId = XmlOperator.createAttrbute(filedoc, "name", joblist.getJobName());

				if (newArrId == null) {
					// 品質保証
					_log.info("name 属性ノードの作成に失敗しました。");
				}

				// 新しいドキュメントエレメントに属性ノードを設定する
				if (!XmlOperator.setAttrNode(newJobElement, newArrId)) {
					// 品質保証
					_log.info("name 属性の設定に失敗しました。");
				}

				// 属性ノードを作成する
				newArrId = XmlOperator.createAttrbute(filedoc, "jobid", joblist.getJobId());

				if (newArrId == null) {
					// 品質保証
					_log.info("jobid 属性ノードの作成に失敗しました。");
				}

				// 新しいドキュメントエレメントに属性ノードを設定する
				if (!XmlOperator.setAttrNode(newJobElement, newArrId)) {
					// 品質保証
					_log.info("jobid 属性の設定に失敗しました。");
				}

				// 属性ノードを作成する
				newArrId = XmlOperator.createAttrbute(filedoc, "view", joblist.getView());

				if (newArrId == null) {
					// 品質保証
					_log.info("view 属性ノードの作成に失敗しました。");
				}

				// 新しいドキュメントエレメントに属性ノードを設定する
				if (!XmlOperator.setAttrNode(newJobElement, newArrId)) {
					// 品質保証
					_log.info("view 属性の設定に失敗しました。");
				}

				// 属性ノードを作成する
				newArrId = XmlOperator.createAttrbute(filedoc, "userid", joblist.getUserId());

				if (newArrId == null) {
					// 品質保証
					_log.info("userid 属性ノードの作成に失敗しました。");
				}

				// 新しいドキュメントエレメントに属性ノードを設定する
				if (!XmlOperator.setAttrNode(newJobElement, newArrId)) {
					// 品質保証
					_log.info("userid 属性の設定に失敗しました。");
				}

				// 属性ノードを作成する
				newArrId = XmlOperator.createAttrbute(filedoc, "orgid", joblist.getOrgId());

				if (newArrId == null) {
					// 品質保証
					_log.info("orgid 属性ノードの作成に失敗しました。");
				}

				// 新しいドキュメントエレメントに属性ノードを設定する
				if (!XmlOperator.setAttrNode(newJobElement, newArrId)) {
					// 品質保証
					_log.info("orgid 属性の設定に失敗しました。");
				}

				// 属性ノードを作成する
				newArrId = XmlOperator.createAttrbute(filedoc, "roleid", joblist.getRoleId());

				if (newArrId == null) {
					// 品質保証
					_log.info("roleid 属性ノードの作成に失敗しました。");
				}

				// 新しいドキュメントエレメントに属性ノードを設定する
				if (!XmlOperator.setAttrNode(newJobElement, newArrId)) {
					// 品質保証
					_log.info("roleid 属性の設定に失敗しました。");
				}

				// 属性ノードを作成する
				newArrId = XmlOperator.createAttrbute(filedoc, "cur_org", "");

				if (newArrId == null) {
					// 品質保証
					_log.info("cur_org 属性ノードの作成に失敗しました。");
				}

				// 新しいドキュメントエレメントに属性ノードを設定する
				if (!XmlOperator.setAttrNode(newJobElement, newArrId)) {
					// 品質保証
					_log.info("cur_org 属性の設定に失敗しました。");
				}

				// 属性ノードを作成する
				newArrId = XmlOperator.createAttrbute(filedoc, "cur_role", "");

				if (newArrId == null) {
					// 品質保証
					_log.info("cur_role 属性ノードの作成に失敗しました。");
				}

				// 新しいドキュメントエレメントに属性ノードを設定する
				if (!XmlOperator.setAttrNode(newJobElement, newArrId)) {
					// 品質保証
					_log.info("cur_role 属性の設定に失敗しました。");
				}

				// 属性ノードを作成する
				newArrId = XmlOperator.createAttrbute(filedoc, "date", joblist.getDate());

				if (newArrId == null) {
					// 品質保証
					_log.info("date 属性ノードの作成に失敗しました。");
				}

				// 新しいドキュメントエレメントに属性ノードを設定する
				if (!XmlOperator.setAttrNode(newJobElement, newArrId)) {
					// 品質保証
					_log.info("date 属性の設定に失敗しました。");
				}

				// 属性ノードを作成する
				newArrId = XmlOperator
						.createAttrbute(filedoc, "cur_status", joblist.getCurStatus());

				if (newArrId == null) {
					// 品質保証
					_log.info("cur_status 属性ノードの作成に失敗しました。");
				}

				// 新しいドキュメントエレメントに属性ノードを設定する
				if (!XmlOperator.setAttrNode(newJobElement, newArrId)) {
					// 品質保証
					_log.info("cur_status 属性の設定に失敗しました。");
				}

				// 属性ノードを作成する
				newArrId = XmlOperator.createAttrbute(filedoc, "templateid", joblist
						.getTemplateId());

				if (newArrId == null) {
					// 品質保証
					_log.info("templateid 属性ノードの作成に失敗しました。");
				}

				// 新しいドキュメントエレメントに属性ノードを設定する
				if (XmlOperator.setAttrNode(newJobElement, newArrId)) {
					// *****************************************************************************
					// ノードの子ノードのリストの末尾に、新しいドキュメントノードを追加します。
					if (XmlOperator.appendElementNode(JobListElement, newJobElement)) {
						// XMLファイルを保存する

						// 品質保証
						_log.info("案件一覧ＸＭＬファイル名：" + jobListXmlPath);

						DBXmlFileConn.writeXml(filedoc, jobListXmlPath);
					}
				}
			} else {

				// 品質保証
				_log.info("案件一覧ＸＭＬドキュメント生成に失敗しました。");
			}

			// 品質保証
			_log.info("終了");
		} catch (Exception e) {

			// 品質保証
			_log.fatal("致命的なエラー");

		}
	}

	/**
	 * ジョブリストの更新
	 * 
	 * @param joblist
	 *            ジョブ記録
	 * @throws SysException
	 *             xmlファイルに操作のうちに、エラーが発生する
	 */
	public void update(JobList joblist) throws SysException {
		// ドキュメントの取得
		Document filedoc = DBXmlFileConn.getDocument(jobListXmlPath);
		
		String strId = joblist.getJobId();

		try {

			if (filedoc != null) {
				// 必要なNodeListを取得する
				NodeList jobNodeList = XmlOperator.getNodeList(filedoc, "job");

				int size = jobNodeList.getLength();

				// 検索開始
				for (int i = 0; i < size; i++) {
					// 案件エレメントを取得する
					Element jobElement = (Element) jobNodeList.item(i);

					// 案件ＩＤを取得し、比較
					if (strId.equals(jobElement.getAttribute("jobid"))) {
						// 属性値を設定する
						if (this.updateElement(joblist, jobElement)) {
							// XMLファイルを保存する
							DBXmlFileConn.writeXml(filedoc, jobListXmlPath);
						} else {
							// 品質保証
							_log.info("案件リストドキュメント更新に失敗しました。");
						}

						// 終了へ
						break;
					}
				}
			} else {
				// 品質保証
				_log.info("案件リストドキュメント生成に失敗しました。");
			}
		} catch (Exception e) {
			// 品質保証
			_log.fatal("致命的なエラー");
		}
	}
	
	/**
	 * リストより案件削除
	 * 
	 * @param strJobId
	 *            ジョブID
	 * @throws SysException
	 *             xmlファイルに操作のうちに、エラーが発生する
	 */
	public void delete(String strJobId) throws SysException {
		// ドキュメントの取得
		Document filedoc = DBXmlFileConn.getDocument(jobListXmlPath);
		
		try {

			// ドキュメントが存在している場合処理
			if (filedoc != null) {
				// 必要なNodeListを取得する
				NodeList jobList = XmlOperator.getNodeList(filedoc, "job");
				int size = jobList.getLength();

				// 検索開始
				for (int i = 0; i < size; i++) {

					// 案件エレメントを取得する
					Element jobElement = (Element) jobList.item(i);

					// 案件ＩＤを取得する
					if (strJobId.equals(jobElement.getAttribute("jobid"))) {

						// Topエレメントを取得する
						Element topDoc = XmlOperator.getElement(XmlOperator.getNodeList(filedoc,
								"joblist"), 0);

						// エレメントノードを削除する
						XmlOperator.removeElementNode(topDoc, jobElement);

						// 案件一覧を保存する
						DBXmlFileConn.writeXml(filedoc, jobListXmlPath);

						break;
					}
				}
			} else {

				// 品質保証
				_log.info("案件リストドキュメントがありません。");
			}

			// 品質保証
			_log.info("終了");
		}

		catch (Exception e) {

			// 品質保証
			_log.fatal("致命的なエラー");

		}
	}

	/**
	 * 更新ジョブエレメント
	 * 
	 * @param joblist
	 *            更新用のジョブリスト
	 * @param jobElement
	 *            ジョブエレメント
	 * @return 更新を成功するかどうか
	 */
	protected boolean updateElement(JobList joblist, Element jobElement) {
		boolean result = false;

		if (joblist != null && jobElement != null) {

			XmlOperator.setAttrValue(jobElement, "cur_org", joblist.getCurOrg());

			XmlOperator.setAttrValue(jobElement, "cur_role", joblist.getCurRole());

			XmlOperator.setAttrValue(jobElement, "cur_status", joblist.getCurStatus());

			XmlOperator.setAttrValue(jobElement, "jobid", joblist.getJobId());

			XmlOperator.setAttrValue(jobElement, "name", joblist.getJobName());

			XmlOperator.setAttrValue(jobElement, "orgid", joblist.getOrgId());

			XmlOperator.setAttrValue(jobElement, "roleid", joblist.getRoleId());

			XmlOperator.setAttrValue(jobElement, "templateid", joblist.getTemplateId());

			XmlOperator.setAttrValue(jobElement, "userid", joblist.getUserId());

			XmlOperator.setAttrValue(jobElement, "view", joblist.getView());

			XmlOperator.setAttrValue(jobElement, "date", joblist.getDate());

			result = true;
		}

		return result;
	}

	/**
	 * 条件の値とプロパティを比べる
	 * 
	 * @param jobElm
	 *            ジョブリストのエレメント
	 * @param quenInfo
	 *            条件の値
	 * @param attId
	 *            ｘｍｌファイルでノードのプロパティ
	 */
	private boolean compareQuenInfo(Element jobElm, String quenInfo, String attId) {
		String strValue = XmlOperator.getAttrValue(jobElm, attId);

		if (quenInfo.equals(strValue)) {
			return true;
		}

		return false;
	}

	/**
	 * ジョブリストのBEANへ格納する
	 * 
	 * @param jobElm
	 *            ジョブリストのエレメント
	 * @return ジョブリストのBEAN
	 */
	private JobList retJob(Element jobElm) {
		JobList joblist = null;

		if (jobElm != null) {
			joblist = new JobList();

			//保存する
			joblist.setCurOrg(XmlOperator.getAttrValue(jobElm, "cur_org"));
			joblist.setCurRole(XmlOperator.getAttrValue(jobElm, "cur_role"));
			joblist.setCurStatus(XmlOperator.getAttrValue(jobElm, "cur_status"));
			joblist.setDate(XmlOperator.getAttrValue(jobElm, "date"));
			joblist.setJobId(XmlOperator.getAttrValue(jobElm, "jobid"));
			joblist.setJobName(XmlOperator.getAttrValue(jobElm, "name"));
			joblist.setOrgId(XmlOperator.getAttrValue(jobElm, "orgid"));
			joblist.setRoleId(XmlOperator.getAttrValue(jobElm, "roleid"));
			joblist.setTemplateId(XmlOperator.getAttrValue(jobElm, "templateid"));
			joblist.setUserId(XmlOperator.getAttrValue(jobElm, "userid"));
			joblist.setView(XmlOperator.getAttrValue(jobElm, "view"));

		}

		return joblist;
	}

}