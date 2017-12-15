package flowbuilder.view.orglist;

import java.io.Serializable;

public final class OrgDTO implements Serializable
{
	/** ‘gDID */
	private String _orgId = null;
	
	/** ‘gD–¼ */
	private String _orgName = null;

	/** –ğŠ„ID */
	private String _roleId = null;
	
	/** –ğŠ„–¼ */
	private String _roleName = null;

	/**
	 * ‘gDID‚Ìİ’è <BR>
	 * 
	 * @param orgId ‘gDID
	 */
	public void setOrgId(String orgId)
	{
		_orgId = orgId;
	}

	/**
	 * ‘gDID‚Ìæ“¾ <BR>
	 * 
	 * @return String
	 */
	public String getOrgId()
	{
		return _orgId;
	}
	
	
	/**
	 * ‘gD–¼‚Ìİ’è <BR>
	 * 
	 * @param orgName ‘gD–¼
	 */
	public void setOrgName(String orgName)
	{
		_orgName = orgName;
	}

	/**
	 * ‘gD–¼‚Ìæ“¾ <BR>
	 * 
	 * @return String
	 */
	public String getOrgName()
	{
		return _orgName;
	}

	/**
	 * –ğŠ„ID‚Ìİ’è <BR>
	 * 
	 * @param roleId –ğŠ„ID
	 */
	public void setRoleId(String roleId)
	{
		_roleId = roleId;
	}

	/**
	 * –ğŠ„ID‚Ìæ“¾ <BR>
	 * 
	 * @return String
	 */
	public String getRoleId()
	{
		return _roleId;
	}
	
	
	/**
	 * –ğŠ„–¼‚Ìİ’è <BR>
	 * 
	 * @param roleName –ğŠ„–¼
	 */
	public void setRoleName(String roleName)
	{
		_roleName = roleName;
	}

	/**
	 * –ğŠ„–¼‚Ìæ“¾ <BR>
	 * 
	 * @return String
	 */
	public String getRoleName()
	{
		return _roleName;
	}
}
