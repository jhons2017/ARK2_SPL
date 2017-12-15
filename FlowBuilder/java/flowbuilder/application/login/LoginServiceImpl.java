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

import java.util.StringTokenizer;

import fbcom.framework.exceptions.SysException;
import flowbuilder.application.util.Crypter;
import flowbuilder.application.util.SystemFactroyKey;
import flowbuilder.dao.user.UserDAO;
import flowbuilder.dao.user.UserDataAccessFactroy;
import flowbuilder.domain.user.User;

;
/**
 * ログインサービスに共通するアプリケーションサービスの実装クラス <BR>
 */
final class LoginServiceImpl implements LoginService {
	/** 文字エンコーディング */
	private final String ENC_UNICODE = "UTF-8";

	/** バイト列の区切り文字 */
	private final String DELIM = ":";
	
	/** DAOファクトリの宣言 */
	private UserDataAccessFactroy _daoFactory = null;


	/**
	 * コンストラクタ
	 * 
	 * @throws Exception
	 * 
	 * @throws SysException システムエラーの場合
	 * 
	 */
	LoginServiceImpl() throws Exception {
		_daoFactory = UserDataAccessFactroy.getFactory(SystemFactroyKey.UserFactroyKey);
	}


	/**
	 * ログインするかどうかのチェック
	 * 
	 * @param loginUser ログインユーザー
	 * @param password パスワード
	 * @return boolean (ture:成功/false:失敗)
	 * @throws SysException システムエラーの場合。
	 * @throws  
	 * @throws  
	 * @throws  
	 * @throws NullPointerException ログインユーザーまたはパスワードがnullの場合。
	 */
	public boolean isAccessible(String loginUser, String password) throws SysException
	{
		boolean loginFlg = false;
		
		if (loginUser == null)
		{
			throw new NullPointerException("loginUser is null.");
		}
		if (password == null)
		{
			throw new NullPointerException("password is null.");
		}

		UserDAO userDAO = _daoFactory.createUserDAO();

		User user = userDAO.select(loginUser);

		//ログインユーザーとパスワードが正しいですか。
		if (user != null )
		{
			if(password.equals(decryptData(user.getPassword(),loginUser)) || password.equals(user.getPassword()))
			loginFlg = true;
		}

		return loginFlg;
	}

	/**
	 * <<メソッドの説明>> <BR>
	 * 受け取った文字列をバイト列に変換後 <BR>
	 * 複合化する <BR>
	 * 
	 * @param data 元データ
	 * @param key 暗号鍵
	 * @return String 複合化したデータ
	 */
	private final String decryptData(String data, String key) {
		byte[] source = null;
		byte[] dec = null;
		String decString = null;
		String tmp;

		StringTokenizer st = new StringTokenizer(data, DELIM);
		try {
			source = new byte[st.countTokens()];
			for (int i = 0; st.hasMoreTokens() == true; i++) {
				tmp = st.nextToken();
				source[i] = Byte.parseByte(tmp);
			}
			dec = Crypter.crypt(source, key.getBytes(ENC_UNICODE));
			decString = new String(dec, ENC_UNICODE);
		} catch (NumberFormatException ne) {
			System.out.println("parseByte() NumberFormatException");
			System.out.println(ne.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return decString;
	}
}