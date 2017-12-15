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
 * メニューを作成する。 コンテナ管理認証のロール、および、Jaguarのビルロールによりメニューを作成する。
 * ロールは、menu-config.xmlに設定されている。
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
				//エラー処理を追記する。UserがNullはもしかしてありえる。これからの実装次第だが・・。
				throw new NullPointerException("user is NULL!!!");
			}

			for (int i = 0; i < allowedRoles.length; i++) {
				if (userInfo.isUserInRole(allowedRoles[i])) {
					result = true;
				}
				/*
				 * Tomcatのロールは、もう見ないぞ！ そうしないと、各リクエストごとに、このクラスをNewしないといけない。
				 * 既存のRolesPermissionsAdapterは、タグライブラリの中で生成して、pageContextの
				 * 中に入れている。 でも、自作のPermissionAdapterは、自分で、Newしないといけない。
				 * そうなると、タグライブラリを改造するか、ServeltFilterなどをつかわないと いけない。めんどくさい。
				 * 
				 * ユーザ情報は、Sessionに入れているのだから、それでいいだろう。
				 * 
				 * else if (_request.isUserInRole(allowedRoles[i])) { return
				 * true; }
				 */
			}
		}

		return result;
	}
}