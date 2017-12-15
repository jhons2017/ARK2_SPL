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

import org.apache.struts.validator.ValidatorForm;

/**
 * ���O�C����ʗp�t�H�[�� <BR>
 */
public class LoginForm extends ValidatorForm
{
	/** ���O�C�����[�U */
	private String _userId = "";

	/** �p�X���[�h */
	private String _password = "";

	/**
	 * ���O�C�����[�U�̎擾 <br>
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
	 * �p�X���[�h�̐ݒ� <br>
	 * 
	 * @param password �p�X���[�h
	 */
	public void setPassword(String password)
	{
		_password = password;
	}
}