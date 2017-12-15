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
 * ���[�U�[�����F�񋓌^<BR>
 */
public final class UserRole implements Serializable {
	/**
	 * ���M���O
	 */
	private static Log _log = LogFactory.getLog(UserRole.class);

	/**
	 * �R�[�h���L�[�Ƃ����ARole�̃C���X�^���X�̏W��
	 */
	private static Map _instances = new HashMap();

	/**
	 * �R�[�h
	 */
	private final String _code;

	/**
	 * ���[���̖�
	 */
	private final String _name;
	
	private static Role role = null;

	private static List<Role> roleList = null;
	
	/** DAO�t�@�N�g���̐錾 */
	private static UserDataAccessFactroy _daoFactory = null;
	
	/**
	 * �R���X�g���N�^�B �C���X�^���X���ł��Ȃ��悤�ɁAprivate�ɂ���B �܂��A�R���X�g���N�^��private�ł���̂ŁA�q�N���X���쐬
	 * �o���Ȃ��悤�ɂ��Ă���B
	 * 
	 * @param code
	 *            �R�[�h
	 * @param messageKey
	 *            ���b�Z�[�W�L�[
	 */
	private UserRole(String code, String name) {
		_code = code;
		_name = name;
		_instances.put(code, this);
	}

	/**
	 * ���[�U�[�����̕�����\����Ԃ��B
	 * 
	 * @return String �R�[�h
	 */
	public String toString() {
		return _code;
	}

	/**
	 * ���b�Z�[�W�L�[��Ԃ��B
	 * 
	 * @return String ���b�Z�[�W�L�[
	 */
	public String getName() {
		return _name;
	}

	/**
	 * �R�[�h������C���X�^���X�𐶐�����B
	 * 
	 * @param code
	 *            �R�[�h
	 * @return UserRole ���[�U�[����
	 * @throws DataAccessSysException 
	 * @throws NullPointerException
	 *             �R�[�h(code)�ɊY������Role�����݂��Ȃ��ꍇ�B
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