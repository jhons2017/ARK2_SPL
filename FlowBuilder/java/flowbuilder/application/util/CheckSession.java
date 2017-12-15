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
 * �Z�b�V�����͖����ɂȂ邩�ǂ����̃`�F�b�N
 */
public final class CheckSession
{

	/**
	 * ���M���O
	 */
	//private static Log _log = LogFactory.getLog(CheckSession.class);
	
	/**
	 * �Z�b�V�����͖����ɂȂ邩�ǂ����̃`�F�b�N
	 * 
	 * @param request ���N�G�X�g
	 * @param strSessionName�@�Z�b�V������
	 * @param strCheckValue�@�Z�b�V�����l
	 * @return boolean �@�@true:�L��	false:����
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

