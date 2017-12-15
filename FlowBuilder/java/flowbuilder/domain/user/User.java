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
package flowbuilder.domain.user;

/**
 * ���[�U�[ <BR>
 */
public final class User {
	/** ���[�U�[���O */
	private String _userName;

	/** ���O�C���� */
	private String _loginName;

	/** �p�X���[�h */
	private String _password;

	/** �g�DID */
	private String orgid;

	/** ���[�U�[���[�� */
	private UserRole _userRole;
	
	/** ���[���@*/
	private String _email = "";

	/**
	 * ���[�����擾����B
	 * 
	 * @return _email�@���[��
	 */
	public String getEmail() {
		return _email;
	}

	/**
	 * ���[����ݒ肷��B
	 * 
	 * @param _email�@���[��
	 */
	public void setEmail(String _email) {
		this._email = _email;
	}


	/**
	 * �R���X�g���N�^
	 */
	public User() {
	}


	/**
	 * ���[�U�[���O�̎擾 <br>
	 * 
	 * @return _userName ���[�U�[���O
	 */
	public String getUserName() {
		return _userName;
	}

	/**
	 * ���[�U�[���O�̐ݒ� <br>
	 * 
	 * @param _userName ���[�U�[���O
	 */
	public void setUserName(String name) {
		_userName = name;
	}

	/**
	 * ���O�C�����̐ݒ� <br>
	 * 
	 * @param loginName ���O�C����
	 */
	public void setLoginName(String loginName) {
		_loginName = loginName;
	}

	/**
	 * ���O�C�����̎擾 <br>
	 * 
	 * @return String ���O�C����
	 */
	public String getLoginName() {
		return _loginName;
	}

	/**
	 * �p�X���[�h�̐ݒ� <br>
	 * 
	 * @param password �p�X���[�h
	 */
	public void setPassword(String password) {
		_password = password;
	}

	/**
	 * �p�X���[�h�̎擾 <br>
	 * 
	 * @return String �p�X���[�h
	 */
	public String getPassword() {
		return _password;
	}

	/**
	 *�@�g�DID�̎擾 <br>
	 * @return String �g�DID
	 */
	public String getOrgid() {
		return orgid;
	}
	
	/**
	 * �g�DID�̐ݒ�@<br>
	 * 
	 * @param orgid�@�g�DID
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * ���[�U�[���[���̎擾 <br>
	 * 
	 * @return UserRole ���[�U���[��
	 */
	public UserRole getUserRole() {
		return _userRole;
	}

	/**
	 * ���[�U�[���[���̐ݒ� <br>
	 * 
	 * @param userRole ���[�U���[��
	 */
	public void setUserRole(UserRole userRole) {
		_userRole = userRole;
	}


}