package flowbuilder.presentation.joblist;

import org.apache.struts.action.ActionForm;

/**
 * 案件一覧のForm <BR>
 */
public final class JobListForm extends ActionForm
{
	/** ユーザーID */
	private String _userId = "";

	/** 組織ID */
	private String _orgId = "";
	
	/** 役割ID */
	private String _roleId = "";
	
	/**
	 * ユーザーIDの設定 <br>
	 * 
	 * @param userId ユーザーID
	 */
	public void setUserId(String userId)
	{
		_userId = userId;
	}

	/**
	 * ユーザーIDの取得 <br>
	 * 
	 * @return String
	 */
	public String getUserId()
	{
		return _userId;
	}

	/**
	 * 組織IDの設定 <br>
	 * 
	 * @param orgId 組織ID
	 */
	public void setOrgId(String orgId)
	{
		_orgId = orgId;
	}

	/**
	 * 組織IDの取得 <br>
	 * 
	 * @return String
	 */
	public String getOrgId()
	{
		return _orgId;
	}
	
	/**
	 * 役割IDの設定 <BR>
	 * 
	 * @param roleId 役割ID
	 */
	public void setRoleId(String roleId)
	{
		_roleId = roleId;
	}

	/**
	 * 役割IDの取得 <BR>
	 * 
	 * @return String
	 */
	public String getRoleId()
	{
		return _roleId;
	}
	
}