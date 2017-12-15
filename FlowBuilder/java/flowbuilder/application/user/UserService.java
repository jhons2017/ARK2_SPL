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
package flowbuilder.application.user;

import java.util.List;

import fbcom.framework.exceptions.DataAccessAppException;
import fbcom.framework.exceptions.DataAccessSysException;
import fbcom.framework.exceptions.RecordNotFoundAppException;
import fbcom.framework.exceptions.SysException;
import fbcom.framework.exceptions.XmlAccessSysException;
import flowbuilder.dao.user.UserQueryInfo;
import flowbuilder.domain.user.Section;
import flowbuilder.domain.user.User;
import flowbuilder.view.user.UserDTO;

/**
 *  ���[�U�[�Ǘ��T�[�r�X���`����C���^�[�t�F�C�X�B <br>
 */
public interface UserService
{
	/**
	 * ���[�U�[�̌���������ݒ肷��B 
	 * 
	 * @param query ���[�U�[�̌�������
	 */
	public void setQuery(UserQueryInfo query);
	
	/**
	 * ���������Ƀq�b�g�������[�U�[�̐����擾����B <BR> 
	 * ���O�����FsetQuery()�����s����Ă��邱�ƁB
	 * 
	 * @return int ���������Ƀq�b�g�������[�U�[�̐�
	 * @throws SysException �V�X�e���G���[�̏ꍇ�B
	 */
	public int getCountOfUser() throws SysException;
	
	/**
	 *  ���������𖞂������[�U�[�̊T�v�̈ꗗ���擾����B <BR> 
	 *	���������Ɉꌏ���q�b�g���Ȃ������ꍇ�A���List��Ԃ��B <BR> 
	 *	�������ʂ�count�Ŏw�肵�����ɖ����Ȃ��ꍇ�A�擾�\�ȕ�������List��Ԃ��B <BR>
	 *	�Ⴆ�΁A�������ʂ�50���ł���AgetUserSummaryList(41, 20)�Ƃ����ꍇ�A <BR> 41���`50���ڂ̃��[�U�[�̃��X�g��Ԃ��B <BR>
	 *	���O�����FsetQuery()�����s����Ă��邱�ƁB 
	 * 
	 * @param beginIndex �J�n�C���f�b�N�X(1�ȏ�)
	 * @param count �擾��������
	 * @return List ���g��UserDTO�B
	 * @throws SysException �V�X�e���G���[�̏ꍇ�B
	 */
	public List getUserSummaryList(int beginIndex,int count) throws SysException;
	
	/**
	 *  ���������𖞂������[�U�[��񃊃X�g���擾���� <BR>
	 *	���������Ɉꌏ���q�b�g���Ȃ������ꍇ�A���List��Ԃ��B <BR>
	 *	���O�����FsetQuery()�����s����Ă��邱�ƁB
	 * 
	 * @return List ���g��User�B
	 * @throws DataAccessSysException �w�肳�ꂽ���[�U�����݂��Ȃ��ꍇ�B
	 */
	public List getUserList() throws XmlAccessSysException;
	
	/**
	 * ���[�U�[�����擾����B
	 * 
	 * @return User ���[�U�[
	 * @param loginName    ���O�C����
	 * @throws NullPointerException loginName��null�̏ꍇ�B
	 * @throws DataAccessAppException �w�肳�ꂽ���[�U�����݂��Ȃ��ꍇ�B
	 * @throws SysException �V�X�e���G���[�̏ꍇ�B
	 */
	public User getUser(String loginName)
	  			throws SysException,RecordNotFoundAppException;
	
	/**
	 * ���[�U�[�����擾����B
	 * 
	 * @return User ���[�U�[
	 * @param loginName    ���O�C����
	 * @throws NullPointerException loginName��null�̏ꍇ�B
	 * @throws DataAccessAppException �w�肳�ꂽ���[�U�����݂��Ȃ��ꍇ�B
	 * @throws SysException �V�X�e���G���[�̏ꍇ�B
	 */
	public User getUser(String loginName,String orgId)
	  			throws SysException,RecordNotFoundAppException;
	
	
	/**
	 * ���[�U�[�����擾����B
	 * 
	 * @return User ���[�U�[
	 * @param loginName    ���O�C����
	 * @throws NullPointerException loginName��null�̏ꍇ�B
	 * @throws DataAccessAppException �w�肳�ꂽ���[�U�����݂��Ȃ��ꍇ�B
	 * @throws SysException �V�X�e���G���[�̏ꍇ�B
	 */
	public UserDTO getUserInfo(String loginName,String orgId,String roleId)
	  			throws SysException,RecordNotFoundAppException;
	
	/**
	 *  ���������𖞂������[�U�[��񃊃X�g���擾���� <BR>
	 *	���������Ɉꌏ���q�b�g���Ȃ������ꍇ�A���List��Ԃ��B <BR>
	 *	���O�����FsetQuery()�����s����Ă��邱�ƁB
	 * 
	 * @return List ���g��User�B
	 * @throws DataAccessSysException �w�肳�ꂽ���[�U�����݂��Ȃ��ꍇ�B
	 */
	public List<User> getUpUsersId(String orgId,String roleId) throws XmlAccessSysException;
	
	/**
	 * ���[�U�[��o�^����B
	 * 
	 * @param user ���[�U�[
	 * @throws NullPointerException equipment��null�̏ꍇ�B
	 * @throws DataAccessAppException ��L�[�A�܂��̓��j�[�N�����̒l���d���̏ꍇ�A <BR>
	 * 				�܂��͐ݒ�\�Ȓl�͈̔͂𒴂���ꍇ�A <BR>
	 * 			 	�܂��͕K�{���ڂ����͂���Ă��Ȃ��ꍇ
	 * @throws DataAccessSysException �V�X�e���G���[�̏ꍇ�B
	 */
	public void createUser(User user)
	  			throws XmlAccessSysException;
	
	/**
	 * ���[�U�[��ύX����B
	 * 
	 * @param user    :�X�V����郆�[�U�[���
	 * @throws NullPointerException oldUser�܂���newUser��null�̏ꍇ�B
	 * @throws DataAccessAppException ��L�[�A�܂��̓��j�[�N�����̒l���d���̏ꍇ�A <BR>
	 * 		 		�܂��͐ݒ�\�Ȓl�͈̔͂𒴂���ꍇ�A <BR>
	 * 		 		�܂��͕K�{���ڂ����͂���Ă��Ȃ��ꍇ�A <BR>
	 * 				�܂��͎w�肵���L�[�ɑΉ����郌�R�[�h�����݂��Ȃ��ꍇ
	 * @throws SysException �V�X�e���G���[�̏ꍇ�B
	 */
	public void updateUser(User user)
	  			throws SysException;
	
	/**
	 * ���[�U�[���폜����B
	 * 
	 * @param userNo    ���[�U�[No
	 * @throws NullPointerException userNo��null�̏ꍇ�B
	 * @throws DataAccessAppException �w�肵���L�[�ɑΉ����郌�R�[�h�����݂��Ȃ��ꍇ
	 * @throws SysException �V�X�e���G���[�̏ꍇ�B
	 */
	public void deleteUser(String userNo)
				throws SysException;
	
	/**
	 * �g�D�h�c�ɂ���đg�D�I�u�W�F�N�g���擾����B
	 * 
	 * @param sectionNo    �g�D�h�c
	 * @throws SysException �V�X�e���G���[�̏ꍇ�B
	 */
	public Section getSectionById(String sectionNo)
				throws SysException;
	
	/**
	 * �g�D���O�ɂ���đg�D�I�u�W�F�N�g���擾����B
	 * 
	 * @param sectionNo    �g�D���O
	 * @throws SysException �V�X�e���G���[�̏ꍇ�B
	 */
	public Section getSectionByName(String sectionName)
				throws SysException;
	
	/**
	 *  ���������𖞂������[�U�[��񃊃X�g���擾���� <BR>
	 *	���������Ɉꌏ���q�b�g���Ȃ������ꍇ�A���List��Ԃ��B <BR>
	 *	 
	 * @return List ���g��User�B
	 * @throws DataAccessSysException �w�肳�ꂽ���[�U�����݂��Ȃ��ꍇ�B
	 */
	public List getUsersByOrgId(String orgId) throws XmlAccessSysException;
}
