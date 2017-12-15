package flowbuilder.view.user;

import java.io.Serializable;

public final class UserDTO implements Serializable
{
	/** 組織名 */
	private String _orgName = null;

	/** 役割名 */
	private String _roleName = null;

	/**　ユーザ名　*/
	private String _userName = null;
	
	/**
	 * 組織名の設定 <BR>
	 * 
	 * @param orgName 組織名
	 */
	public void setOrgName(String orgName)
	{
		_orgName = orgName;
	}

	/**
	 * 組織名の取得 <BR>
	 * 
	 * @return String
	 */
	public String getOrgName()
	{
		return _orgName;
	}

	/**
	 * 役割名の設定 <BR>
	 * 
	 * @param roleName 役割名
	 */
	public void setRoleName(String roleName)
	{
		_roleName = roleName;
	}

	/**
	 * 役割名の取得 <BR>
	 * 
	 * @return String
	 */
	public String getRoleName()
	{
		return _roleName;
	}
	
	/**
	 * ユーザ名の設定 <BR>
	 * 
	 * @param _userName ユーザ名
	 */
	public String getUserName() {
		return _userName;
	}
	
	/**
	 * ユーザ名の取得 <BR>
	 * @param name　ユーザ名
	 */
	public void setUserName(String name) {
		_userName = name;
	}
}
