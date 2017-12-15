package flowbuilder.view.user;

import java.io.Serializable;

public final class UserDTO implements Serializable
{
	/** �g�D�� */
	private String _orgName = null;

	/** ������ */
	private String _roleName = null;

	/**�@���[�U���@*/
	private String _userName = null;
	
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
	
	/**
	 * ���[�U���̐ݒ� <BR>
	 * 
	 * @param _userName ���[�U��
	 */
	public String getUserName() {
		return _userName;
	}
	
	/**
	 * ���[�U���̎擾 <BR>
	 * @param name�@���[�U��
	 */
	public void setUserName(String name) {
		_userName = name;
	}
}
