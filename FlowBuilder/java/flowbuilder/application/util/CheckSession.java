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
package flowbuilder.application.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * セッションは無効になるかどうかのチェック
 */
public final class CheckSession
{

	/**
	 * ロギング
	 */
	//private static Log _log = LogFactory.getLog(CheckSession.class);
	
	/**
	 * セッションは無効になるかどうかのチェック
	 * 
	 * @param request リクエスト
	 * @param strSessionName　セッション名
	 * @param strCheckValue　セッション値
	 * @return boolean 　　true:有効	false:無効
	 */
	public static boolean chkSession(HttpServletRequest request, String strSessionName, String strCheckValue)
	{
		boolean bolCheckPass = false;
		
		HttpSession session = request.getSession();
		
		if (!(strSessionName == null || strCheckValue == null))
		{
			if (session != null && (String)session.getAttribute(strSessionName) != null)
			{			
				bolCheckPass = ((String)session.getAttribute(strSessionName)).equals(strCheckValue);

			}

		}
		return(bolCheckPass);
	}
}

