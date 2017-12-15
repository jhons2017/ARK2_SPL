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
 * ���O�C����ʏ������s�Ȃ��B <BR>
 */
public class LoginAction extends Action
{
	/** �J�ږڕW��� */
	private static final String FORWARD_SUCCESS = "success";

	/**
	 * ���O�C����ʓo�^�`�F�b�N�����̎��s
	 * 
	 * @param mapping�FActionMapping�I�u�W�F�N�g
	 * @param form�FActionForm�I�u�W�F�N�g
	 * @param request�FHttpServletRequest�I�u�W�F�N�g
	 * @param response�FHttpServletResponse�I�u�W�F�N�g
	 * @return ActionForward�FActionForward�I�u�W�F�N�g
	 * @throws SysException 
	 * @throws SysException 
	 * @throws  
	 * @exception java.lang.Exception�F��ʓI�ȗ�O��������throw����
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
		
		//���[�U�̃C���t�H��������A�ȉ���
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
			throw new AppException("���O�C�����܂��̓p�X���[�h���Ԉ���Ă��܂�");
		}

		return mapping.findForward(target);
	}
	
	/**
	 * Sturts Menu�̃��j���[�\����������
	 * �I�u�W�F�N�g��HTTP�Z�b�V�����ɐݒ肷��B
	 * @param session HTTP�Z�b�V����
	 */
	private void makeMenuPermission(HttpSession session)
	{
		BuilRolesPermissionsAdapter permAdapter = new BuilRolesPermissionsAdapter(session);
		session.setAttribute(BuilRolesPermissionsAdapter.PERMISSIONSADAPTER_KEY, permAdapter);
	}

}