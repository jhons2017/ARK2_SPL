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

import fbcom.framework.exceptions.SysException;

/**
 * ���O�C���T�[�r�X���`����C���^�[�t�F�C�X�B <BR>
 */
public interface LoginService {
	/**
	 * ���O�C�����邩�ǂ����̃`�F�b�N
	 * 
	 * @param loginUser ���O�C�����[�U�[
	 * @param password �p�X���[�h
	 * @return boolean (ture:����/false:���s)
	 * @throws SysException 
	 * @throws SysException �V�X�e���G���[�̏ꍇ�B
	 * @throws  
	 * @throws NullPointerException ���O�C�����[�U�[�܂��̓p�X���[�h��null�̏ꍇ�B
	 */
	public boolean isAccessible(String loginUser, String password) throws SysException;
}
