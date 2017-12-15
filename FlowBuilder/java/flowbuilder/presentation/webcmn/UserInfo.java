package flowbuilder.presentation.webcmn;

import java.io.Serializable;

import flowbuilder.domain.user.UserRole;


/**
 * ユーザー情報の作成処理 <BR>
 */
public final class UserInfo implements Serializable
{
	/** ユーザーキーの宣言 */
	public static final String USER_KEY = "user";

	/** ログインユーザーID */
	private String _userId;

	/** パスワード */
	private String _password;

	/** ユーザー権限 */
	private UserRole _userRole;

	/** ログインユーザーID */
	private String _orgId;

	/**
	 * ログインユーザーIDの設定 <br>
	 * 
	 * @param userId ログインユーザーID
	 */
	public void setUserId(String userId)
	{
		_userId = userId;
	}

	/**
	 * ログインユーザーIDの取得 <br>
	 * 
	 * @return String ログインユーザーID
	 */
	public String getUserId()
	{
		return _userId;
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

	/**
	 * ユーザー権限の設定 <br>
	 * 
	 * @param userRole ユーザー権限
	 */
	public void setUserRole(UserRole userRole)
	{
		_userRole = userRole;
	}

	/**
	 * ユーザー権限の取得 <br>
	 * 
	 * @return UserRole ユーザー権限
	 */
	public UserRole getUserRole()
	{
		return _userRole;
	}

	/**
	 * 組織IDの設定 <br>
	 * 
	 * @param orgId 組織ID
	 */
	public void setOrgId(String orgId)
	{
		_orgId = orgId;
	}

	/**
	 * 組織IDの取得 <br>
	 * 
	 * @return String
	 */
	public String getOrgId()
	{
		return _orgId;
	}

	/**
	 * ユーザーが指定されたロールを持っているかを判定する。 <br>
	 * ロール、およびビルロールの両方を判定する。
	 * 
	 * @param allowedRole ロール
	 * @return boolean ロールを持っている(true)／持っていない(false)
	 */
	public boolean isUserInRole(String allowedRole)
	{
		boolean result = false;
		if (isUserRole(allowedRole))
		{
			result = true;
		}
		return result;
	}

	/**
	 * ユーザーが指定されたロールを持っているかを判定する。 <br>
	 * 
	 * @param allowedRole ロール
	 * @return boolean ロールを持っている(true)／持っていない(false)
	 */
	private boolean isUserRole(String allowedRole)
	{
		boolean result = false;
		if (_userRole != null)
		{
			if (_userRole.toString().equals(allowedRole))
			{
				result = true;
			}
		}
		return result;
	}

}