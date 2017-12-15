package flowbuilder.presentation.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import fbcom.framework.exceptions.AppException;
import flowbuilder.application.user.UserService;
import flowbuilder.application.user.UserServiceFactory;
import flowbuilder.application.util.Crypter;
import flowbuilder.domain.user.User;
import flowbuilder.presentation.webcmn.AuthorityChecker;
import flowbuilder.presentation.webcmn.UserInfo;

/**
 * ログイン画面処理を行うコントローラ。 <BR>
 */
public class PasswordUpdateAction extends DispatchAction {
	/** 遷移目標画面 */
	private final String FORWARD_SUCCESS = "success";

	/** 遷移ログアウト目標画面 */
	private final String FORWARD_LOGOUT = "logout";

	/**
	 * 文字エンコーディング
	 */
	private  final String ENC_UNICODE = "UTF-8";
	
	/**
	 * バイト列の区切り文字
	 */
	private  final String DELIM = ":";
	
	/**
	 * パスワード変更画面初期表示処理の実行
	 * 
	 * @param mapping：ActionMappingオブジェクト
	 * @param form：ActionFormオブジェクト
	 * @param request：HttpServletRequestオブジェクト
	 * @param response：HttpServletResponseオブジェクト
	 * @return ActionForward：ActionForwardオブジェクト
	 * @exception java.lang.Exception：一般的な例外発生時にthrowする
	 */
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String target = null;
		if (AuthorityChecker.isSessionValid(request)) 
		{
			PasswordForm passwordForm = (PasswordForm) form;
			UserInfo userInfo = (UserInfo)request.getSession().getAttribute(UserInfo.USER_KEY);
			passwordForm.setUserId(userInfo.getUserId());
			target = FORWARD_SUCCESS;
		}
		else 
		{
			target = FORWARD_LOGOUT;
		}

		return mapping.findForward(target);
	}
	/**
	 * パスワード変更画面更新処理の実行
	 * 
	 * @param mapping：ActionMappingオブジェクト
	 * @param form：ActionFormオブジェクト
	 * @param request：HttpServletRequestオブジェクト
	 * @param response：HttpServletResponseオブジェクト
	 * @return ActionForward：ActionForwardオブジェクト
	 * @exception java.lang.Exception：一般的な例外発生時にthrowする
	 */
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String target = FORWARD_LOGOUT;;
		
		UserService serive = UserServiceFactory.getUserServiceInstance();
		
		if (AuthorityChecker.isSessionValid(request)) 
		{
			PasswordForm userForm = (PasswordForm) form;
			UserInfo userInfo = (UserInfo)request.getSession().getAttribute(UserInfo.USER_KEY);
			String strUserID = userForm.getUserId();
			User user = serive.getUser(strUserID);
			
			
			if(userInfo.getPassword().equals(encryptData(userForm.getOldPassword(),strUserID)) 
					|| userInfo.getPassword().equals(userForm.getOldPassword()))
			{
				String encryptedPassword = this.encryptData(userForm.getPassword(),strUserID);
				user.setPassword(encryptedPassword);
				
				serive.updateUser(user);
				
			}
			else 
			{	
					throw new AppException("古いパスワード前後が違いました。");
			}
		}

		return mapping.findForward(target);
	
	}
	
	/**
	 * <<メソッドの説明>> <BR>
	 * データを暗号化し、暗号結果のバイト列を <BR>
	 * 文字列に変換する
	 * 
	 * @param data 元データ
	 * @param key 暗号鍵
	 * @return String 暗号化したデータ
	 */
	private final String encryptData(String data, String key)
	{
		StringBuffer buf = new StringBuffer();
		byte[] enc = crypt(data, key);
		for (int cnt = 0; cnt < enc.length; cnt++)
		{
			buf.append(DELIM + Byte.toString(enc[cnt]));
		}
		buf.append(DELIM);
		return buf.toString();
	}

	/**
	 * <<メソッドの説明>> <BR>
	 * リモート環境での暗号／複合化 <BR>
	 * 
	 * @param data 元データ
	 * @param key 暗号鍵
	 * @return byte[] 暗号／複合化したデータ
	 */
	private final byte[] crypt(String data, String key)
	{

		byte[] crypt_buf = null;
		try
		{
			crypt_buf = Crypter.crypt(data.getBytes(ENC_UNICODE), key.getBytes(ENC_UNICODE));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return crypt_buf;
	}
		
}
