package flowbuilder.presentation.webcmn.taglibs.presentation.circular;

import org.apache.struts.action.ActionForm;

/**
 * �Č��\����Form <BR>
 */
public final class CircularForm extends ActionForm
{

	/** ���[�U���X�g */
	private String _selectedUsers = "";
		
	/** �g�DID */
	private String _orgId = "";

	/** �����̃��[�U�@*/
	private String _leftUser = "";
	
	/** �E���̃��[�U�@*/
	private String _rightUser = "";
	
	/**
	 * �I���������[�U���X�g�̐ݒ� <br>
	 * 
	 * @param users ���[�U���X�g
	 */
	
	public void setSelectedUsers(String selectedUsers)
	{
		_selectedUsers = selectedUsers;
	}

	/**
	 * �I���������[�U���X�g�̎擾 <br>
	 * 
	 * @return String
	 */
	public String getSelectedUsers()
	{
		return _selectedUsers;
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
	 * �����̃��[�U�̎擾
	 * 
	 * @return Returns the _leftUser.
	 */
	public String getLeftUser() {
		return _leftUser;
	}

	/**
	 * �����̃��[�U�̐ݒ�
	 * 
	 * @param user The _leftUser to set.
	 */
	public void setLeftUser(String leftUser) {
		_leftUser = leftUser;
	}

	/**
	 * �E���̃��[�U�̎擾
	 * 
	 * @return Returns the _rightUser.
	 */
	public String getRightUser() {
		return _rightUser;
	}

	/**
	 * �E���̃��[�U�̐ݒ�
	 * 
	 * @param user The _rightUser to set.
	 */
	public void setRightUser(String rightUser) {
		_rightUser = rightUser;
	}

}