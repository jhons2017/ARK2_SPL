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
 * ���O�A�E�g�������s�Ȃ��B
 */
public class LogoutAction extends Action
{
	/** �J�ږڕW��� */
	private static final String FORWARD_SUCCESS = "success";

	/**
	 * ���O�A�E�g�����̎��s
	 * 
	 * @param mapping�FActionMapping�I�u�W�F�N�g
	 * @param form�FActionForm�I�u�W�F�N�g
	 * @param request�FHttpServletRequest�I�u�W�F�N�g
	 * @param response�FHttpServletResponse�I�u�W�F�N�g
	 * @return ActionForward�FActionForward�I�u�W�F�N�g
	 * @exception java.lang.Exception�F��ʓI�ȗ�O��������throw����
	 */
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		//���[�U�[�̃Z�b�V�����𖳌��ɂ��邱�Ƃɂ��A���O�A�E�g�������s�Ȃ��B
		doLogout(request);

		//ActionForward��߂�
		return mapping.findForward(FORWARD_SUCCESS);
	}

	/**
	 * ���[�U�[�̃Z�b�V�����𖳌��ɂ��邱�Ƃɂ��A���O�A�E�g�������s�Ȃ��B
	 * 
	 * @param request ���N�G�X�g�I�u�W�F�N�g
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