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

/**
 * ログアウト処理を行なう。
 */
public class LogoutAction extends Action
{
	/** 遷移目標画面 */
	private static final String FORWARD_SUCCESS = "success";

	/**
	 * ログアウト処理の実行
	 * 
	 * @param mapping：ActionMappingオブジェクト
	 * @param form：ActionFormオブジェクト
	 * @param request：HttpServletRequestオブジェクト
	 * @param response：HttpServletResponseオブジェクト
	 * @return ActionForward：ActionForwardオブジェクト
	 * @exception java.lang.Exception：一般的な例外発生時にthrowする
	 */
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		//ユーザーのセッションを無効にすることにより、ログアウト処理を行なう。
		doLogout(request);

		//ActionForwardを戻る
		return mapping.findForward(FORWARD_SUCCESS);
	}

	/**
	 * ユーザーのセッションを無効にすることにより、ログアウト処理を行なう。
	 * 
	 * @param request リクエストオブジェクト
	 */
	private final void doLogout(HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);

		if (session != null)
		{
			session.invalidate();
		}
	}
}