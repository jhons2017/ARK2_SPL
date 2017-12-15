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

import java.util.StringTokenizer;

import fbcom.framework.exceptions.SysException;
import flowbuilder.application.util.Crypter;
import flowbuilder.application.util.SystemFactroyKey;
import flowbuilder.dao.user.UserDAO;
import flowbuilder.dao.user.UserDataAccessFactroy;
import flowbuilder.domain.user.User;

;
/**
 * ���O�C���T�[�r�X�ɋ��ʂ���A�v���P�[�V�����T�[�r�X�̎����N���X <BR>
 */
final class LoginServiceImpl implements LoginService {
	/** �����G���R�[�f�B���O */
	private final String ENC_UNICODE = "UTF-8";

	/** �o�C�g��̋�؂蕶�� */
	private final String DELIM = ":";
	
	/** DAO�t�@�N�g���̐錾 */
	private UserDataAccessFactroy _daoFactory = null;


	/**
	 * �R���X�g���N�^
	 * 
	 * @throws Exception
	 * 
	 * @throws SysException �V�X�e���G���[�̏ꍇ
	 * 
	 */
	LoginServiceImpl() throws Exception {
		_daoFactory = UserDataAccessFactroy.getFactory(SystemFactroyKey.UserFactroyKey);
	}


	/**
	 * ���O�C�����邩�ǂ����̃`�F�b�N
	 * 
	 * @param loginUser ���O�C�����[�U�[
	 * @param password �p�X���[�h
	 * @return boolean (ture:����/false:���s)
	 * @throws SysException �V�X�e���G���[�̏ꍇ�B
	 * @throws  
	 * @throws  
	 * @throws  
	 * @throws NullPointerException ���O�C�����[�U�[�܂��̓p�X���[�h��null�̏ꍇ�B
	 */
	public boolean isAccessible(String loginUser, String password) throws SysException
	{
		boolean loginFlg = false;
		
		if (loginUser == null)
		{
			throw new NullPointerException("loginUser is null.");
		}
		if (password == null)
		{
			throw new NullPointerException("password is null.");
		}

		UserDAO userDAO = _daoFactory.createUserDAO();

		User user = userDAO.select(loginUser);

		//���O�C�����[�U�[�ƃp�X���[�h���������ł����B
		if (user != null )
		{
			if(password.equals(decryptData(user.getPassword(),loginUser)) || password.equals(user.getPassword()))
			loginFlg = true;
		}

		return loginFlg;
	}

	/**
	 * <<���\�b�h�̐���>> <BR>
	 * �󂯎������������o�C�g��ɕϊ��� <BR>
	 * ���������� <BR>
	 * 
	 * @param data ���f�[�^
	 * @param key �Í���
	 * @return String �����������f�[�^
	 */
	private final String decryptData(String data, String key) {
		byte[] source = null;
		byte[] dec = null;
		String decString = null;
		String tmp;

		StringTokenizer st = new StringTokenizer(data, DELIM);
		try {
			source = new byte[st.countTokens()];
			for (int i = 0; st.hasMoreTokens() == true; i++) {
				tmp = st.nextToken();
				source[i] = Byte.parseByte(tmp);
			}
			dec = Crypter.crypt(source, key.getBytes(ENC_UNICODE));
			decString = new String(dec, ENC_UNICODE);
		} catch (NumberFormatException ne) {
			System.out.println("parseByte() NumberFormatException");
			System.out.println(ne.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return decString;
	}
}