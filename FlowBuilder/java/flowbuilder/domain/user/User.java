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

/**
 * ユーザー <BR>
 */
public final class User {
	/** ユーザー名前 */
	private String _userName;

	/** ログイン名 */
	private String _loginName;

	/** パスワード */
	private String _password;

	/** 組織ID */
	private String orgid;

	/** ユーザーロール */
	private UserRole _userRole;
	
	/** メール　*/
	private String _email = "";

	/**
	 * メールを取得する。
	 * 
	 * @return _email　メール
	 */
	public String getEmail() {
		return _email;
	}

	/**
	 * メールを設定する。
	 * 
	 * @param _email　メール
	 */
	public void setEmail(String _email) {
		this._email = _email;
	}


	/**
	 * コンストラクタ
	 */
	public User() {
	}


	/**
	 * ユーザー名前の取得 <br>
	 * 
	 * @return _userName ユーザー名前
	 */
	public String getUserName() {
		return _userName;
	}

	/**
	 * ユーザー名前の設定 <br>
	 * 
	 * @param _userName ユーザー名前
	 */
	public void setUserName(String name) {
		_userName = name;
	}

	/**
	 * ログイン名の設定 <br>
	 * 
	 * @param loginName ログイン名
	 */
	public void setLoginName(String loginName) {
		_loginName = loginName;
	}

	/**
	 * ログイン名の取得 <br>
	 * 
	 * @return String ログイン名
	 */
	public String getLoginName() {
		return _loginName;
	}

	/**
	 * パスワードの設定 <br>
	 * 
	 * @param password パスワード
	 */
	public void setPassword(String password) {
		_password = password;
	}

	/**
	 * パスワードの取得 <br>
	 * 
	 * @return String パスワード
	 */
	public String getPassword() {
		return _password;
	}

	/**
	 *　組織IDの取得 <br>
	 * @return String 組織ID
	 */
	public String getOrgid() {
		return orgid;
	}
	
	/**
	 * 組織IDの設定　<br>
	 * 
	 * @param orgid　組織ID
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * ユーザーロールの取得 <br>
	 * 
	 * @return UserRole ユーザロール
	 */
	public UserRole getUserRole() {
		return _userRole;
	}

	/**
	 * ユーザーロールの設定 <br>
	 * 
	 * @param userRole ユーザロール
	 */
	public void setUserRole(UserRole userRole) {
		_userRole = userRole;
	}


}