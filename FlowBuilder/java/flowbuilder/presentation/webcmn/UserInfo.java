package flowbuilder.presentation.webcmn;

import java.io.Serializable;

import flowbuilder.domain.user.UserRole;


/**
 * ���[�U�[���̍쐬���� <BR>
 */
public final class UserInfo implements Serializable
{
	/** ���[�U�[�L�[�̐錾 */
	public static final String USER_KEY = "user";

	/** ���O�C�����[�U�[ID */
	private String _userId;

	/** �p�X���[�h */
	private String _password;

	/** ���[�U�[���� */
	private UserRole _userRole;

	/** ���O�C�����[�U�[ID */
	private String _orgId;

	/**
	 * ���O�C�����[�U�[ID�̐ݒ� <br>
	 * 
	 * @param userId ���O�C�����[�U�[ID
	 */
	public void setUserId(String userId)
	{
		_userId = userId;
	}

	/**
	 * ���O�C�����[�U�[ID�̎擾 <br>
	 * 
	 * @return String ���O�C�����[�U�[ID
	 */
	public String getUserId()
	{
		return _userId;
	}

	/**
	 * �p�X���[�h�̎擾 <br>
	 * 
	 * @return String �p�X���[�h
	 */
	public String getPassword()
	{
		return _password;
	}

	/**
	 * �p�X���[�h�̐ݒ� <br>
	 * 
	 * @param password �p�X���[�h
	 */
	public void setPassword(String password)
	{
		_password = password;
	}

	/**
	 * ���[�U�[�����̐ݒ� <br>
	 * 
	 * @param userRole ���[�U�[����
	 */
	public void setUserRole(UserRole userRole)
	{
		_userRole = userRole;
	}

	/**
	 * ���[�U�[�����̎擾 <br>
	 * 
	 * @return UserRole ���[�U�[����
	 */
	public UserRole getUserRole()
	{
		return _userRole;
	}

	/**
	 * �g�DID�̐ݒ� <br>
	 * 
	 * @param orgId �g�DID
	 */
	public void setOrgId(String orgId)
	{
		_orgId = orgId;
	}

	/**
	 * �g�DID�̎擾 <br>
	 * 
	 * @return String
	 */
	public String getOrgId()
	{
		return _orgId;
	}

	/**
	 * ���[�U�[���w�肳�ꂽ���[���������Ă��邩�𔻒肷��B <br>
	 * ���[���A����уr�����[���̗����𔻒肷��B
	 * 
	 * @param allowedRole ���[��
	 * @return boolean ���[���������Ă���(true)�^�����Ă��Ȃ�(false)
	 */
	public boolean isUserInRole(String allowedRole)
	{
		boolean result = false;
		if (isUserRole(allowedRole))
		{
			result = true;
		}
		return result;
	}

	/**
	 * ���[�U�[���w�肳�ꂽ���[���������Ă��邩�𔻒肷��B <br>
	 * 
	 * @param allowedRole ���[��
	 * @return boolean ���[���������Ă���(true)�^�����Ă��Ȃ�(false)
	 */
	private boolean isUserRole(String allowedRole)
	{
		boolean result = false;
		if (_userRole != null)
		{
			if (_userRole.toString().equals(allowedRole))
			{
				result = true;
			}
		}
		return result;
	}

}