package flowbuilder.presentation.user;

import org.apache.struts.validator.ValidatorForm;

/**
 * ���O�C����ʗp�t�H�[�� <BR>
 */
public class PasswordForm extends ValidatorForm
{
	/** ���O�C�����[�U */
	private String _userId = "";
	
	/** �Â��p�X���[�h */
	private String _oldPassword = "";
	
	/** �p�X���[�h */
	private String _password = "";
	
	/** �ē��̓p�X���[�h */
	private String _passwordAgain = "";

	/**
	 * ���O�C�����[�U�̎�?? <br>
	 * 
	 * @return userID ���O�C�����[�U
	 */
	public String getUserId()
	{
		return _userId;
	}

	/**
	 * ���O�C�����[�U�̐ݒ� <br>
	 * 
	 * @param userID ���O�C�����[�U
	 */
	public void setUserId(String userID)
	{
		_userId = userID;
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
	 * �ē��̓p�X���[�h�̎擾 <br>
	 * 
	 * @return String �ē��̓p�X���[�h
	 */
	public String getPasswordAgain()
	{
		return _passwordAgain;
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
	 * �p�X���[�h�̐ݒ� <br>
	 * 
	 * @param password �p�X���[�h
	 */
	public void setPasswordAgain(String passwordAgain)
	{
		_passwordAgain = passwordAgain;
	}
	
	/**
	 * 
	 * @param oldPassword
	 */
	public void setOldPassword(String oldPassword){
		_oldPassword = oldPassword;
	}
	
	/**
	 * 
	 * @param oldPassword
	 */
	public String getOldPassword(){
		return _oldPassword;
	}
	
}