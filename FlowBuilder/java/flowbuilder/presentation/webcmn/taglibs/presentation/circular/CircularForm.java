package flowbuilder.presentation.webcmn.taglibs.presentation.circular;

import org.apache.struts.action.ActionForm;

/**
 * 案件表示のForm <BR>
 */
public final class CircularForm extends ActionForm
{

	/** ユーザリスト */
	private String _selectedUsers = "";
		
	/** 組織ID */
	private String _orgId = "";

	/** 左側のユーザ　*/
	private String _leftUser = "";
	
	/** 右側のユーザ　*/
	private String _rightUser = "";
	
	/**
	 * 選択したユーザリストの設定 <br>
	 * 
	 * @param users ユーザリスト
	 */
	
	public void setSelectedUsers(String selectedUsers)
	{
		_selectedUsers = selectedUsers;
	}

	/**
	 * 選択したユーザリストの取得 <br>
	 * 
	 * @return String
	 */
	public String getSelectedUsers()
	{
		return _selectedUsers;
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
	 * 左側のユーザの取得
	 * 
	 * @return Returns the _leftUser.
	 */
	public String getLeftUser() {
		return _leftUser;
	}

	/**
	 * 左側のユーザの設定
	 * 
	 * @param user The _leftUser to set.
	 */
	public void setLeftUser(String leftUser) {
		_leftUser = leftUser;
	}

	/**
	 * 右側のユーザの取得
	 * 
	 * @return Returns the _rightUser.
	 */
	public String getRightUser() {
		return _rightUser;
	}

	/**
	 * 右側のユーザの設定
	 * 
	 * @param user The _rightUser to set.
	 */
	public void setRightUser(String rightUser) {
		_rightUser = rightUser;
	}

}