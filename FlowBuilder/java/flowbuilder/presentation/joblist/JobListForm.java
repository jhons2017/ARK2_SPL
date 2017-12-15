package flowbuilder.presentation.joblist;

import org.apache.struts.action.ActionForm;

/**
 * �Č��ꗗ��Form <BR>
 */
public final class JobListForm extends ActionForm
{
	/** ���[�U�[ID */
	private String _userId = "";

	/** �g�DID */
	private String _orgId = "";
	
	/** ����ID */
	private String _roleId = "";
	
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
	 * �g�DID�̐ݒ� <br>
	 * 
	 * @param orgId �g�DID
	 */
	public void setOrgId(String orgId)
	{
		_orgId = orgId;
	}

	/**
	 * �g�DID�̎擾 <br>
	 * 
	 * @return String
	 */
	public String getOrgId()
	{
		return _orgId;
	}
	
	/**
	 * ����ID�̐ݒ� <BR>
	 * 
	 * @param roleId ����ID
	 */
	public void setRoleId(String roleId)
	{
		_roleId = roleId;
	}

	/**
	 * ����ID�̎擾 <BR>
	 * 
	 * @return String
	 */
	public String getRoleId()
	{
		return _roleId;
	}
	
}