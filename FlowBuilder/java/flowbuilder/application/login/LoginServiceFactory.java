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
package flowbuilder.application.login;

/**
 * ���O�o�^��static�t�@�N�g�����\�b�h��񋟂���B <BR>
 */
public class LoginServiceFactory {
	/**
	 * static�t�@�N�g�����\�b�h�����Ȃ̂ŁA�C���X�^���X�������Ȃ��B
	 */
	private LoginServiceFactory() {
	}

	/**
	 * ���O�o�^�̃C���X�^���X���擾����B
	 * 
	 * @return UserService
	 * @throws Exception 
	 */
	public static LoginService getLoginServiceInstance() throws Exception {
		return new LoginServiceImpl();
	}
}