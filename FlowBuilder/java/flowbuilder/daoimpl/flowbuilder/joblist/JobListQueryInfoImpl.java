/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/04/26
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

import flowbuilder.dao.joblist.JobListQueryInfo;

/**
 * ジョブリスト検索のための検索条件を定義する <BR>
 */
public final class JobListQueryInfoImpl implements JobListQueryInfo {
	
	/**
	 *　現在の組織  
	 */
	private String _curOrg = null;
	
	/**
	 * 現在のルール
	 */
	private String _curRole = null;
	
	/**
	 * 現在の状態
	 */
	private String _curStatus = null;
	
	/**
	 * ジョブID
	 */
	private String _jobId = null;
	
	/**
	 * 案件名前
	 */
	private String _jobName = null;
	
	/**
	 * 起案者の組織ID
	 */
	private String _orgId = null;
	
	/**
	 * 起案者のルールID
	 */
	private String _roleId = null;
	
	/**
	 * 案件テンプレートID
	 */
	private String _tempId = null;
	
	/**
	 * 起案者のユーザID
	 */
	private String _userId = null;
	
	/**
	 * 案件に対応する画面ID
	 */
	private String _view = null;
	
	/**
	 * 案件起案の日付	<br>
	 * （例えば：　「2007/04/26」と書く）
	 */
	private String _date = null;
	

	/**
	 * 現在組織の取得 <br>
	 * 
	 * @return _curOrg 現在組織
	 */
	public String getCurOrg() {
		return this._curOrg;
	}

	/**
	 * 現在組織の設定 <br>
	 * 
	 * @param curOrg 現在組織
	 */
	public void setCurOrg(String curOrg) {
		this._curOrg = curOrg;
	}
	
	/**
	 * 現在ルールの取得 <br>
	 * 
	 * @return _curRole 現在ルール
	 */
	public String getCurRole() {
		return this._curRole;
	}

	/**
	 * 現在ルールの設定 <br>
	 * 
	 * @param curRole 現在ルール
	 */
	public void setCurRole(String curRole) {
		this._curRole = curRole;
	}
	
	/**
	 * 現在状態の設定 <br>
	 * 
	 * @param curRole 現在状態
	 */
	public void setCurStatus(String status) {
		this._curStatus = status;
	}

	/**
	 * 現在状態の取得 <br>
	 * 
	 * @return _curRole 現在状態
	 */
	public String getCurStatus() {
		return this._curStatus;
	}

	/**
	 * ジョブIDの取得 <br>
	 * 
	 * @return _jobId ジョブID
	 */
	public String getJobId() {
		return this._jobId;
	}

	/**
	 * ジョブIDの設定 <br>
	 * 
	 * @param jobId ジョブID
	 */
	public void setJobId(String jobId) {
		this._jobId = jobId;
	}

	/**
	 * 案件名前の取得 <br>
	 * 
	 * @return _jobName 案件名前
	 */
	public String getJobName() {
		return this._jobName;
	}
	
	/**
	 * 案件名前の設定 <br>
	 * 
	 * @param jobName 案件名前
	 */
	public void setJobName(String jobName) {
		this._jobName = jobName;
	}

	/**
	 * 起案者組織IDの取得 <br>
	 * 
	 * @return _orgId 起案者組織ID
	 */
	public String getOrgId() {
		return this._orgId;
	}

	/**
	 * 起案者組織IDの設定 <br>
	 * 
	 * @param orgId 起案者組織ID
	 */
	public void setOrgId(String orgId) {
		this._orgId = orgId;
	}

	/**
	 * 起案者ルールIDの取得 <br>
	 * 
	 * @return _roleId 起案者ルールID
	 */
	public String getRoleId() {
		return this._roleId;
	}

	/**
	 * 起案者ルールIDの設定 <br>
	 * 
	 * @param roleId 起案者ルールID
	 */
	public void setRoleId(String roleId) {
		this._roleId = roleId;
	}

	/**
	 * 案件テンプレートIDの取得 <br>
	 * 
	 * @return _tempId 案件テンプレートID
	 */
	public String getTemplateId() {
		return this._tempId;
	}

	/**
	 * 案件テンプレートIDの設定 <br>
	 * 
	 * @param templateId 案件テンプレートID
	 */
	public void setTemplateId(String templateId) {
		this._tempId = templateId;
	}

	/**
	 * 起案者IDの取得 <br>
	 * 
	 * @return _userId 起案者ID
	 */
	public String getUserId() {
		return this._userId;
	}

	/**
	 * 起案者IDの設定 <br>
	 * 
	 * @param userId 起案者ID
	 */
	public void setUserId(String userId) {
		this._userId = userId;
	}

	/**
	 * 案件に対応する画面IDの取得 <br>
	 * 
	 * @return _view 案件に対応する画面ID
	 */
	public String getView() {
		return this._view;
	}

	/**
	 * 案件に対応する画面IDの設定 <br>
	 * 
	 * @param view 案件に対応する画面ID
	 */
	public void setView(String view) {
		this._view = view;
	}

	/**
	 * 案件起案の日付の取得 <br>
	 * 
	 * @return _date 案件起案の日付
	 */	
	public String getDate() {
		return this._date;
	}
	
	/**
	 * 案件起案の日付の設定 <br>
	 * 
	 * @param date 案件起案の日付
	 */
	public void setDate(String date) {
		this._date = date;
	}

}
