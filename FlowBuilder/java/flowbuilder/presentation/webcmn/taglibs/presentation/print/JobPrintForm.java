package flowbuilder.presentation.webcmn.taglibs.presentation.print;

import org.apache.struts.action.ActionForm;

/**
 * �Č�??����Form <BR>
 */
public final class JobPrintForm extends ActionForm
{
	/** ���[�U�[ID */
	private String _userId = "";

	/** �g�DID */
	private String _orgId = "";
	
	/** jobID */
	private String _jobId = "";	

	/**
	 * ���[�U�[ID�̐ݒ� <br>
	 * 
	 * @param userId ���[�U�[ID
	 */
	public void setUserId(String userId)
	{
		_userId = userId;
	}

	/**
	 * ���[�U�[ID�̎擾 <br>
	 * 
	 * @return String
	 */
	public String getUserId()
	{
		return _userId;
	}

	/**
	 * ??�DID�̐�?? <br>
	 * 
	 * @param orgId ??�DID
	 */
	public void setOrgId(String orgId)
	{
		_orgId = orgId;
	}

	/**
	 * ??�DID�̎�?? <br>
	 * 
	 * @return String
	 */
	public String getOrgId()
	{
		return _orgId;
	}
	
	/**
	 * ??jobID�̐�?? <br>
	 * 
	 * @param orgId ??�DID
	 */
	public void setjobId(String jobId)
	{
		_jobId = jobId;
	}

	/**
	 * ??jobID�̎�?? <br>
	 * 
	 * @return String
	 */
	public String getjobId()
	{
		return _jobId;
	}
}