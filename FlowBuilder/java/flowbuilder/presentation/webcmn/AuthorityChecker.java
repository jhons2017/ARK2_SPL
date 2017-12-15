package flowbuilder.presentation.webcmn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import flowbuilder.presentation.navigator.menu.BuilRolesPermissionsAdapter;

/**
 * アクセス権チェックを行うクラス <BR>
 * ユーザ情報からアクセス権を取得して <BR>
 * セッションタイムアウトするか、アクセス権限あるかどうかチェックを行う。 <BR>
 */
public class AuthorityChecker
{
	/**
	 * コンストラクタ ユーティリティクラスのため、インスタンス化させない。
	 */
	private AuthorityChecker()
	{
	}

	/**
	 * アクセス権チェック セッションタイムアウトするかどうか
	 * 
	 * @param request HTTP要求情報
	 * @return boolean true:アクセス権あり/false:アクセス権無し
	 */
	public static boolean isSessionValid(HttpServletRequest request)
	{
		boolean result = false;

		HttpSession session = request.getSession(false);
		if (session != null)
		{
			if (session.getAttribute(UserInfo.USER_KEY) != null
					&& session.getAttribute(BuilRolesPermissionsAdapter.PERMISSIONSADAPTER_KEY) != null)
			{
				result = true;
			}
		}

		return result;
	}
//
//	/**
//	 * アクセス権チェック 参照ユーザー以上の権限があるかどうか
//	 * 
//	 * @param request HTTP要求情報
//	 * @return boolean true:アクセス権あり/false:アクセス権無し
//	 */
//	public static boolean isAccessibleViewer(HttpServletRequest request)
//	{
//		boolean result = false;
//
//		if (isSessionValid(request))
//		{
//			UserInfo userInfo = (UserInfo) request.getSession(false).getAttribute(UserInfo.USER_KEY);
//			if (userInfo.isViewer() || userInfo.isUser() || userInfo.isManager() || userInfo.isOperator()
//					|| userInfo.isAdmin())
//			{
//				result = true;
//			}
//		}
//
//		return result;
//	}
//
//	/**
//	 * アクセス権チェック 運用ユーザ以上の権限があるかどうか
//	 * 
//	 * @param request HTTP要求情報
//	 * @return boolean true:アクセス権あり/false:アクセス権無し
//	 */
//	public static boolean isAccessibleUser(HttpServletRequest request)
//	{
//		boolean result = false;
//
//		if (isSessionValid(request))
//		{
//			UserInfo userInfo = (UserInfo) request.getSession(false).getAttribute(UserInfo.USER_KEY);
//			if (userInfo.isUser() || userInfo.isManager() || userInfo.isOperator() || userInfo.isAdmin())
//			{
//				result = true;
//			}
//		}
//
//		return result;
//	}
//
//	/**
//	 * アクセス権チェック 高度運用ユーザー以上の権限があるかどうか
//	 * 
//	 * @param request HTTP要求情報
//	 * @return boolean true:アクセス権あり/false:アクセス権無し
//	 */
//	public static boolean isAccessibleManager(HttpServletRequest request)
//	{
//		boolean result = false;
//
//		if (isSessionValid(request))
//		{
//			UserInfo userInfo = (UserInfo) request.getSession(false).getAttribute(UserInfo.USER_KEY);
//			if (userInfo.isManager() || userInfo.isOperator() || userInfo.isAdmin())
//			{
//				result = true;
//			}
//		}
//
//		return result;
//	}
//
//	/**
//	 * アクセス権チェック オペレータ以上の権限があるかどうか
//	 * 
//	 * @param request HTTP要求情報
//	 * @return boolean true:アクセス権あり/false:アクセス権無し
//	 */
//	public static boolean isAccessibleOperator(HttpServletRequest request)
//	{
//		boolean result = false;
//
//		if (isSessionValid(request))
//		{
//			UserInfo userInfo = (UserInfo) request.getSession(false).getAttribute(UserInfo.USER_KEY);
//			if (userInfo.isOperator() || userInfo.isAdmin())
//			{
//				result = true;
//			}
//		}
//
//		return result;
//	}
//
//	/**
//	 * アクセス権チェック システム管理者の権限があるかどうか
//	 * 
//	 * @param request HTTP要求情報
//	 * @return boolean true:アクセス権あり/false:アクセス権無し
//	 */
//	public static boolean isAccessibleAdmin(HttpServletRequest request)
//	{
//		boolean result = false;
//
//		if (isSessionValid(request))
//		{
//			UserInfo userInfo = (UserInfo) request.getSession(false).getAttribute(UserInfo.USER_KEY);
//			if (userInfo.isAdmin())
//			{
//				result = true;
//			}
//		}
//
//		return result;
//	}
}