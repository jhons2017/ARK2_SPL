/**
 * 
 */
package flowbuilder.domain.user;

/**
 * @author hx0163
 *
 */
public class Role {
	/**
	 * ���[��ID
	 */
	private String _roleId;

	/**
	 * ���[����
	 */
	private String _roleName;
	
	/**
	 * ���[��ID���Z�b�g����
	 * @param roleId ���[��ID
	 */
	public void setRoleID(String roleId){
		this._roleId = roleId;
	}
	
	/**
	 * ���[�������Z�b�g����
	 * @param roleName�@���[����
	 */
	public void setRoleName(String roleName){
		this._roleName = roleName;
	}
	
	/**
	 * ���[��ID���擾����
	 * @return ���[��ID
	 */
	public String getRoleId(){
		return _roleId;
	}
	
	/**
	 * ���[�������擾����
	 * @return ���[����
	 */
	public String getRoleName(){
		return _roleName;
	}
}
