package flowbuilder.view.orglist;

import java.io.Serializable;

public final class OrgDTO implements Serializable
{
	/** �g�DID */
	private String _orgId = null;
	
	/** �g�D�� */
	private String _orgName = null;

	/** ����ID */
	private String _roleId = null;
	
	/** ������ */
	private String _roleName = null;

	/**
	 * �g�DID�̐ݒ� <BR>
	 * 
	 * @param orgId �g�DID
	 */
	public void setOrgId(String orgId)
	{
		_orgId = orgId;
	}

	/**
	 * �g�DID�̎擾 <BR>
	 * 
	 * @return String
	 */
	public String getOrgId()
	{
		return _orgId;
	}
	
	
	/**
	 * �g�D���̐ݒ� <BR>
	 * 
	 * @param orgName �g�D��
	 */
	public void setOrgName(String orgName)
	{
		_orgName = orgName;
	}

	/**
	 * �g�D���̎擾 <BR>
	 * 
	 * @return String
	 */
	public String getOrgName()
	{
		return _orgName;
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
	
	
	/**
	 * �������̐ݒ� <BR>
	 * 
	 * @param roleName ������
	 */
	public void setRoleName(String roleName)
	{
		_roleName = roleName;
	}

	/**
	 * �������̎擾 <BR>
	 * 
	 * @return String
	 */
	public String getRoleName()
	{
		return _roleName;
	}
}
