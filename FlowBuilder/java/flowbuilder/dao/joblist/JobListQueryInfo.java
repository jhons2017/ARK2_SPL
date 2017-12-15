/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/04/26 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.dao.joblist;

/**
 * ジョブリスト検索のための検索条件を定義するインターフェース。 <BR>
 */
public interface JobListQueryInfo {
	/**
	 * 現在組織の取得 <br>
	 * 
	 * @return _curOrg 現在組織
	 */
	public String getCurOrg();

	/**
	 * 現在組織の設定 <br>
	 * 
	 * @param curOrg 現在組織
	 */
	public void setCurOrg(String curOrg);
	
	/**
	 * 現在ルールの取得 <br>
	 * 
	 * @return _curRole 現在ルール
	 */
	public String getCurRole();

	/**
	 * 現在ルールの設定 <br>
	 * 
	 * @param curRole 現在ルール
	 */
	public void setCurRole(String curRole);
	
	/**
	 * 現在状態の設定 <br>
	 * 
	 * @param curRole 現在状態
	 */
	public void setCurStatus(String status);

	/**
	 * 現在状態の取得 <br>
	 * 
	 * @return _curRole 現在状態
	 */
	public String getCurStatus();

	/**
	 * ジョブIDの取得 <br>
	 * 
	 * @return _jobId ジョブID
	 */
	public String getJobId();

	/**
	 * ジョブIDの設定 <br>
	 * 
	 * @param jobId ジョブID
	 */
	public void setJobId(String jobId);

	/**
	 * 案件名前の取得 <br>
	 * 
	 * @return _jobName 案件名前
	 */
	public String getJobName();
	
	/**
	 * 案件名前の設定 <br>
	 * 
	 * @param jobName 案件名前
	 */
	public void setJobName(String jobName);

	/**
	 * 起案者組織IDの取得 <br>
	 * 
	 * @return _orgId 起案者組織ID
	 */
	public String getOrgId();

	/**
	 * 起案者組織IDの設定 <br>
	 * 
	 * @param orgId 起案者組織ID
	 */
	public void setOrgId(String orgId);

	/**
	 * 起案者ルールIDの取得 <br>
	 * 
	 * @return _roleId 起案者ルールID
	 */
	public String getRoleId();

	/**
	 * 起案者ルールIDの設定 <br>
	 * 
	 * @param roleId 起案者ルールID
	 */
	public void setRoleId(String roleId);

	/**
	 * 案件テンプレートIDの取得 <br>
	 * 
	 * @return _tempId 案件テンプレートID
	 */
	public String getTemplateId();

	/**
	 * 案件テンプレートIDの設定 <br>
	 * 
	 * @param templateId 案件テンプレートID
	 */
	public void setTemplateId(String templateId);

	/**
	 * 起案者IDの取得 <br>
	 * 
	 * @return _userId 起案者ID
	 */
	public String getUserId();

	/**
	 * 起案者IDの設定 <br>
	 * 
	 * @param userId 起案者ID
	 */
	public void setUserId(String userId);

	/**
	 * 案件に対応する画面IDの取得 <br>
	 * 
	 * @return _view 案件に対応する画面ID
	 */
	public String getView();

	/**
	 * 案件に対応する画面IDの設定 <br>
	 * 
	 * @param view 案件に対応する画面ID
	 */
	public void setView(String view);

	/**
	 * 案件起案の日付の取得 <br>
	 * 
	 * @return _date 案件起案の日付
	 */	
	public String getDate();
	
	/**
	 * 案件起案の日付の設定 <br>
	 * 
	 * @param date 案件起案の日付
	 */
	public void setDate(String date);

}