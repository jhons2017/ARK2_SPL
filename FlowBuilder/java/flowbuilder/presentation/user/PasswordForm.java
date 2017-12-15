package flowbuilder.presentation.user;

import org.apache.struts.validator.ValidatorForm;

/**
 * ログイン画面用フォーム <BR>
 */
public class PasswordForm extends ValidatorForm
{
	/** ログインユーザ */
	private String _userId = "";
	
	/** 古いパスワード */
	private String _oldPassword = "";
	
	/** パスワード */
	private String _password = "";
	
	/** 再入力パスワード */
	private String _passwordAgain = "";

	/**
	 * ログインユーザの取?? <br>
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
	 * 再入力パスワードの取得 <br>
	 * 
	 * @return String 再入力パスワード
	 */
	public String getPasswordAgain()
	{
		return _passwordAgain;
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
	 * パスワードの設定 <br>
	 * 
	 * @param password パスワード
	 */
	public void setPasswordAgain(String passwordAgain)
	{
		_passwordAgain = passwordAgain;
	}
	
	/**
	 * 
	 * @param oldPassword
	 */
	public void setOldPassword(String oldPassword){
		_oldPassword = oldPassword;
	}
	
	/**
	 * 
	 * @param oldPassword
	 */
	public String getOldPassword(){
		return _oldPassword;
	}
	
}