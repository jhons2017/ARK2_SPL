package flowbuilder.view.orglist;

import java.io.Serializable;

public final class OrgDTO implements Serializable
{
	/** 組織ID */
	private String _orgId = null;
	
	/** 組織名 */
	private String _orgName = null;

	/** 役割ID */
	private String _roleId = null;
	
	/** 役割名 */
	private String _roleName = null;

	/**
	 * 組織IDの設定 <BR>
	 * 
	 * @param orgId 組織ID
	 */
	public void setOrgId(String orgId)
	{
		_orgId = orgId;
	}

	/**
	 * 組織IDの取得 <BR>
	 * 
	 * @return String
	 */
	public String getOrgId()
	{
		return _orgId;
	}
	
	
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
}
