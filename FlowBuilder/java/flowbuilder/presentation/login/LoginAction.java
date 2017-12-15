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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import flowbuilder.application.login.LoginService;
import flowbuilder.application.login.LoginServiceFactory;
import flowbuilder.application.user.UserService;
import flowbuilder.application.user.UserServiceFactory;
import flowbuilder.domain.user.User;
import flowbuilder.presentation.navigator.menu.BuilRolesPermissionsAdapter;
import flowbuilder.presentation.webcmn.UserInfo;
import fbcom.framework.exceptions.AppException;
import fbcom.framework.exceptions.SysException;

/**
 * ログイン画面処理を行なう。 <BR>
 */
public class LoginAction extends Action
{
	/** 遷移目標画面 */
	private static final String FORWARD_SUCCESS = "success";

	/**
	 * ログイン画面登録チェック処理の実行
	 * 
	 * @param mapping：ActionMappingオブジェクト
	 * @param form：ActionFormオブジェクト
	 * @param request：HttpServletRequestオブジェクト
	 * @param response：HttpServletResponseオブジェクト
	 * @return ActionForward：ActionForwardオブジェクト
	 * @throws SysException 
	 * @throws SysException 
	 * @throws  
	 * @exception java.lang.Exception：一般的な例外発生時にthrowする
	 */
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		String target = null;
		LoginForm loginForm = (LoginForm) form;
		LoginService service = LoginServiceFactory.getLoginServiceInstance();
		
		//ユーザのインフォがしたら、以下の
		if(service.isAccessible(loginForm.getUserId(), loginForm.getPassword()))
		{
			UserService userService = UserServiceFactory.getUserServiceInstance();
			User user = userService.getUser(loginForm.getUserId());
			
			HttpSession session = request.getSession();
			makeMenuPermission(session);
			UserInfo userInfo = new UserInfo();
			userInfo.setUserId(user.getLoginName());
			userInfo.setPassword(user.getPassword());
			userInfo.setUserRole(user.getUserRole());
			session.setAttribute(UserInfo.USER_KEY, userInfo);
			target = FORWARD_SUCCESS;
		}
		else
		{
			throw new AppException("ログイン名またはパスワードが間違っています");
		}

		return mapping.findForward(target);
	}
	
	/**
	 * Sturts Menuのメニュー表示権限判定
	 * オブジェクトをHTTPセッションに設定する。
	 * @param session HTTPセッション
	 */
	private void makeMenuPermission(HttpSession session)
	{
		BuilRolesPermissionsAdapter permAdapter = new BuilRolesPermissionsAdapter(session);
		session.setAttribute(BuilRolesPermissionsAdapter.PERMISSIONSADAPTER_KEY, permAdapter);
	}

}