/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/03/06 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.domain.user;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import flowbuilder.application.util.SystemFactroyKey;
import flowbuilder.dao.user.RoleDAO;
import flowbuilder.dao.user.UserDataAccessFactroy;
import flowbuilder.domain.user.Role;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fbcom.framework.exceptions.XmlAccessSysException;

/**
 * ユーザー権限：列挙型<BR>
 */
public final class UserRole implements Serializable {
	/**
	 * ロギング
	 */
	private static Log _log = LogFactory.getLog(UserRole.class);

	/**
	 * コードをキーとした、Roleのインスタンスの集合
	 */
	private static Map _instances = new HashMap();

	/**
	 * コード
	 */
	private final String _code;

	/**
	 * ルールの名
	 */
	private final String _name;
	
	private static Role role = null;

	private static List<Role> roleList = null;
	
	/** DAOファクトリの宣言 */
	private static UserDataAccessFactroy _daoFactory = null;
	
	/**
	 * コンストラクタ。 インスタンス化できないように、privateにする。 また、コンストラクタがprivateであるので、子クラスも作成
	 * 出来ないようにしている。
	 * 
	 * @param code
	 *            コード
	 * @param messageKey
	 *            メッセージキー
	 */
	private UserRole(String code, String name) {
		_code = code;
		_name = name;
		_instances.put(code, this);
	}

	/**
	 * ユーザー権限の文字列表現を返す。
	 * 
	 * @return String コード
	 */
	public String toString() {
		return _code;
	}

	/**
	 * メッセージキーを返す。
	 * 
	 * @return String メッセージキー
	 */
	public String getName() {
		return _name;
	}

	/**
	 * コード名からインスタンスを生成する。
	 * 
	 * @param code
	 *            コード
	 * @return UserRole ユーザー権限
	 * @throws DataAccessSysException 
	 * @throws NullPointerException
	 *             コード(code)に該当するRoleが存在しない場合。
	 */
	public static UserRole getInstance(String code) throws XmlAccessSysException {
		UserRole result = null;
		initUserRole();
		result = (UserRole) _instances.get(code);
		if (result == null) {
			_log.fatal("Null UserRole. code[" + code + "] not defined.");
			throw new NullPointerException("Null UserRole");
		}
		return result;
	}
	
	private static void initUserRole() throws XmlAccessSysException{
		_daoFactory = UserDataAccessFactroy.getFactory(SystemFactroyKey.UserFactroyKey);
		RoleDAO roleDAO =  _daoFactory.createRoleDAO();
		roleList = roleDAO.getList();
		int length = roleList.size();
		
		for(int i=0;i<length;i++){
			role = roleList.get(i);
			new UserRole(role.getRoleId(),role.getRoleName());
		}		
	}
}