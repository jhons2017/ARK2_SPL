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
package flowbuilder.presentation.login;

import org.apache.struts.validator.ValidatorForm;

/**
 * ログイン画面用フォーム <BR>
 */
public class LoginForm extends ValidatorForm
{
	/** ログインユーザ */
	private String _userId = "";

	/** パスワード */
	private String _password = "";

	/**
	 * ログインユーザの取得 <br>
	 * 
	 * @return userID ログインユーザ
	 */
	public String getUserId()
	{
		return _userId;
	}

	/**
	 * ログインユーザの設定 <br>
	 * 
	 * @param userID ログインユーザ
	 */
	public void setUserId(String userID)
	{
		_userId = userID;
	}

	/**
	 * パスワードの取得 <br>
	 * 
	 * @return String パスワード
	 */
	public String getPassword()
	{
		return _password;
	}

	/**
	 * パスワードの設定 <br>
	 * 
	 * @param password パスワード
	 */
	public void setPassword(String password)
	{
		_password = password;
	}
}