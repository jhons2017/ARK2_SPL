package flowbuilder.presentation.webcmn.taglibs.presentation.print;

import org.apache.struts.action.ActionForm;

/**
 * 案件??覧のForm <BR>
 */
public final class JobPrintForm extends ActionForm
{
	/** ユーザーID */
	private String _userId = "";

	/** 組織ID */
	private String _orgId = "";
	
	/** jobID */
	private String _jobId = "";	

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
	
	/**
	 * ??jobIDの設?? <br>
	 * 
	 * @param orgId ??織ID
	 */
	public void setjobId(String jobId)
	{
		_jobId = jobId;
	}

	/**
	 * ??jobIDの取?? <br>
	 * 
	 * @return String
	 */
	public String getjobId()
	{
		return _jobId;
	}
}