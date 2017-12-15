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
 * ���O�C����ʏ������s���R���g���[���B <BR>
 */
public class PasswordUpdateAction extends DispatchAction {
	/** �J�ږڕW��� */
	private final String FORWARD_SUCCESS = "success";

	/** �J�ڃ��O�A�E�g�ڕW��� */
	private final String FORWARD_LOGOUT = "logout";

	/**
	 * �����G���R�[�f�B���O
	 */
	private  final String ENC_UNICODE = "UTF-8";
	
	/**
	 * �o�C�g��̋�؂蕶��
	 */
	private  final String DELIM = ":";
	
	/**
	 * �p�X���[�h�ύX��ʏ����\�������̎��s
	 * 
	 * @param mapping�FActionMapping�I�u�W�F�N�g
	 * @param form�FActionForm�I�u�W�F�N�g
	 * @param request�FHttpServletRequest�I�u�W�F�N�g
	 * @param response�FHttpServletResponse�I�u�W�F�N�g
	 * @return ActionForward�FActionForward�I�u�W�F�N�g
	 * @exception java.lang.Exception�F��ʓI�ȗ�O��������throw����
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
	 * �p�X���[�h�ύX��ʍX�V�����̎��s
	 * 
	 * @param mapping�FActionMapping�I�u�W�F�N�g
	 * @param form�FActionForm�I�u�W�F�N�g
	 * @param request�FHttpServletRequest�I�u�W�F�N�g
	 * @param response�FHttpServletResponse�I�u�W�F�N�g
	 * @return ActionForward�FActionForward�I�u�W�F�N�g
	 * @exception java.lang.Exception�F��ʓI�ȗ�O��������throw����
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
					throw new AppException("�Â��p�X���[�h�O�オ�Ⴂ�܂����B");
			}
		}

		return mapping.findForward(target);
	
	}
	
	/**
	 * <<���\�b�h�̐���>> <BR>
	 * �f�[�^���Í������A�Í����ʂ̃o�C�g��� <BR>
	 * ������ɕϊ�����
	 * 
	 * @param data ���f�[�^
	 * @param key �Í���
	 * @return String �Í��������f�[�^
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
	 * <<���\�b�h�̐���>> <BR>
	 * �����[�g���ł̈Í��^������ <BR>
	 * 
	 * @param data ���f�[�^
	 * @param key �Í���
	 * @return byte[] �Í��^�����������f�[�^
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
