package flowbuilder.presentation.webcmn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import flowbuilder.presentation.navigator.menu.BuilRolesPermissionsAdapter;

/**
 * �A�N�Z�X���`�F�b�N���s���N���X <BR>
 * ���[�U��񂩂�A�N�Z�X�����擾���� <BR>
 * �Z�b�V�����^�C���A�E�g���邩�A�A�N�Z�X�������邩�ǂ����`�F�b�N���s���B <BR>
 */
public class AuthorityChecker
{
	/**
	 * �R���X�g���N�^ ���[�e�B���e�B�N���X�̂��߁A�C���X�^���X�������Ȃ��B
	 */
	private AuthorityChecker()
	{
	}

	/**
	 * �A�N�Z�X���`�F�b�N �Z�b�V�����^�C���A�E�g���邩�ǂ���
	 * 
	 * @param request HTTP�v�����
	 * @return boolean true:�A�N�Z�X������/false:�A�N�Z�X������
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
//	 * �A�N�Z�X���`�F�b�N �Q�ƃ��[�U�[�ȏ�̌��������邩�ǂ���
//	 * 
//	 * @param request HTTP�v�����
//	 * @return boolean true:�A�N�Z�X������/false:�A�N�Z�X������
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
//	 * �A�N�Z�X���`�F�b�N �^�p���[�U�ȏ�̌��������邩�ǂ���
//	 * 
//	 * @param request HTTP�v�����
//	 * @return boolean true:�A�N�Z�X������/false:�A�N�Z�X������
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
//	 * �A�N�Z�X���`�F�b�N ���x�^�p���[�U�[�ȏ�̌��������邩�ǂ���
//	 * 
//	 * @param request HTTP�v�����
//	 * @return boolean true:�A�N�Z�X������/false:�A�N�Z�X������
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
//	 * �A�N�Z�X���`�F�b�N �I�y���[�^�ȏ�̌��������邩�ǂ���
//	 * 
//	 * @param request HTTP�v�����
//	 * @return boolean true:�A�N�Z�X������/false:�A�N�Z�X������
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
//	 * �A�N�Z�X���`�F�b�N �V�X�e���Ǘ��҂̌��������邩�ǂ���
//	 * 
//	 * @param request HTTP�v�����
//	 * @return boolean true:�A�N�Z�X������/false:�A�N�Z�X������
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