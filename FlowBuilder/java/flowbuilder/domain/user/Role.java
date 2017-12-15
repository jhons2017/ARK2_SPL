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
	 * ルールID
	 */
	private String _roleId;

	/**
	 * ルール名
	 */
	private String _roleName;
	
	/**
	 * ルールIDをセットする
	 * @param roleId ルールID
	 */
	public void setRoleID(String roleId){
		this._roleId = roleId;
	}
	
	/**
	 * ルール名をセットする
	 * @param roleName　ルール名
	 */
	public void setRoleName(String roleName){
		this._roleName = roleName;
	}
	
	/**
	 * ルールIDを取得する
	 * @return ルールID
	 */
	public String getRoleId(){
		return _roleId;
	}
	
	/**
	 * ルール名を取得する
	 * @return ルール名
	 */
	public String getRoleName(){
		return _roleName;
	}
}
