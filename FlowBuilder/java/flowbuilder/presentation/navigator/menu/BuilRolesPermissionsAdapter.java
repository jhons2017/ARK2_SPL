/* =================================================================
 * NO.83XXXXXX
 * ITEM = 001 ; REV = 00 ; DATE 2004/11/09
 *
 * (c) 2004 Yamatake Corporation All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2004/11/09 BY. T.Okuyama (BSC)
 * =================================================================
 */
package flowbuilder.presentation.navigator.menu;

import javax.servlet.http.HttpSession;

import net.sf.navigator.menu.MenuComponent;
import net.sf.navigator.menu.PermissionsAdapter;

import org.apache.commons.lang.StringUtils;

import flowbuilder.presentation.webcmn.*;

/**
 * ���j���[���쐬����B �R���e�i�Ǘ��F�؂̃��[���A����сAJaguar�̃r�����[���ɂ�胁�j���[���쐬����B
 * ���[���́Amenu-config.xml�ɐݒ肳��Ă���B
 */
public class BuilRolesPermissionsAdapter implements PermissionsAdapter {
	public static final String PERMISSIONSADAPTER_KEY = "builRolesAdapter";

	/**
	 * The current request for this user
	 */
	private HttpSession _session;

	/**
	 * Creates a new instance of BuilRolesPermissionsAdapter
	 */
	public BuilRolesPermissionsAdapter(HttpSession session) {
		_session = session;
	}

	/**
	 * If the menu is allowed, this should return true.
	 * 
	 * @return whether or not the menu is allowed.
	 */
	public boolean isAllowed(MenuComponent menu) {
		boolean result = false;

		if (menu.getRoles() == null) {
			result = true; // no roles define, allow everyone
		} else {
			// Get the list of roles this menu allows
			String[] allowedRoles = StringUtils.split(menu.getRoles(), ",");
			if (_session == null) {
				throw new NullPointerException("session is NULL!!!");
			}
			UserInfo userInfo = (UserInfo) _session
					.getAttribute(UserInfo.USER_KEY);
			if (userInfo == null) {
				//�G���[������ǋL����BUser��Null�͂��������Ă��肦��B���ꂩ��̎������悾���E�E�B
				throw new NullPointerException("user is NULL!!!");
			}

			for (int i = 0; i < allowedRoles.length; i++) {
				if (userInfo.isUserInRole(allowedRoles[i])) {
					result = true;
				}
				/*
				 * Tomcat�̃��[���́A�������Ȃ����I �������Ȃ��ƁA�e���N�G�X�g���ƂɁA���̃N���X��New���Ȃ��Ƃ����Ȃ��B
				 * ������RolesPermissionsAdapter�́A�^�O���C�u�����̒��Ő������āApageContext��
				 * ���ɓ���Ă���B �ł��A�����PermissionAdapter�́A�����ŁANew���Ȃ��Ƃ����Ȃ��B
				 * �����Ȃ�ƁA�^�O���C�u�������������邩�AServeltFilter�Ȃǂ�����Ȃ��� �����Ȃ��B�߂�ǂ������B
				 * 
				 * ���[�U���́ASession�ɓ���Ă���̂�����A����ł������낤�B
				 * 
				 * else if (_request.isUserInRole(allowedRoles[i])) { return
				 * true; }
				 */
			}
		}

		return result;
	}
}