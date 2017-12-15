package flowbuilder.presentation.orglist;

import org.apache.struts.action.ActionForm;

/**
 * 案件??覧のForm <BR>
 */
public final class OrgSelectForm extends ActionForm
{
	/** ユーザーID */
	private String _userId = "";

	/** 組織ID */
	private String _orgId = "";

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
	 * ??織IDの設?? <br>
	 * 
	 * @param orgId ??織ID
	 */
	public void setOrgId(String orgId)
	{
		_orgId = orgId;
	}

	/**
	 * ??織IDの取?? <br>
	 * 
	 * @return String
	 */
	public String getOrgId()
	{
		return _orgId;
	}
}