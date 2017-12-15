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
package flowbuilder.application.login;

import fbcom.framework.exceptions.SysException;

/**
 * ログインサービスを定義するインターフェイス。 <BR>
 */
public interface LoginService {
	/**
	 * ログインするかどうかのチェック
	 * 
	 * @param loginUser ログインユーザー
	 * @param password パスワード
	 * @return boolean (ture:成功/false:失敗)
	 * @throws SysException 
	 * @throws SysException システムエラーの場合。
	 * @throws  
	 * @throws NullPointerException ログインユーザーまたはパスワードがnullの場合。
	 */
	public boolean isAccessible(String loginUser, String password) throws SysException;
}
