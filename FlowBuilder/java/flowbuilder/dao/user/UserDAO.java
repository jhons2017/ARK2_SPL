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
package flowbuilder.dao.user;

import java.util.List;

import flowbuilder.domain.user.User;
import fbcom.framework.exceptions.XmlAccessSysException;


/**
 * ���[�U�[�̃A�N�Z�X�I�u�W�F�N�g
 */
public interface UserDAO
{
	/**
	 * ���[�U�[�����̎擾
	 * 
	 * @param query UserQueryInfo ��������
	 * @return int ���[�U�[����
	 * @throws DataAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public int getCount(UserQueryInfo query) throws XmlAccessSysException;

	/**
	 * ���[�U�[ SummaryList �̎擾
	 * ����������1�����Y�����Ȃ������ꍇ�́A���List��Ԃ��B <BR>
	 * 
	 * @param query UserQueryInfo ��������
	 * @param beginIndex �\���J�n�C���f�b�N�X
	 * @param count �\������
	 * @return List ���g�́AUserDTO
	 * @throws IndexOutOfBoundsException �z��̋��E�𒴂��ăA�N�Z�X�����̏ꍇ
	 * @throws DataAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public List getSummaryList(UserQueryInfo query, int beginIndex, int count) throws XmlAccessSysException;
	
	/**
	 * ���[�U�[��񃊃X�g�̎擾 
	 * ����������1�����Y�����Ȃ������ꍇ�́A���List��Ԃ��B <BR>
	 * 
	 * @param query UserQueryInfo ��������
	 * @return List ���g�� User 
	 * @throws DataAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public List<User> getList(UserQueryInfo query) throws XmlAccessSysException;
	
	/**
	 * ���[�U�[��񃊃X�g�̎擾 
	 * ����������1�����Y�����Ȃ������ꍇ�́A���List��Ԃ��B <BR>
	 * 
	 * @param query UserQueryInfo ��������
	 * @return List ���g�� User 
	 * @throws DataAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public List<User> getList(String loginName) throws XmlAccessSysException;

	/**
	 * ���[�U�[��񃊃X�g�̎擾 
	 * ����������1�����Y�����Ȃ������ꍇ�́A���List��Ԃ��B <BR>
	 * 
	 * @param String orgId �g�DID
	 * @return List ���g�� User 
	 * @throws DataAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public List<User> getListByOrgId(String orgId) throws XmlAccessSysException;
	
	/**
	 * ���[�U�[��񃊃X�g�̎擾 
	 * ����������1�����Y�����Ȃ������ꍇ�́A���List��Ԃ��B <BR>
	 * 
	 * @param String orgId �g�DID
	 * @return List ���g�� User 
	 * @throws DataAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public List<User> getUpUsersId(String orgId,String roleId) throws XmlAccessSysException;
	
	/**
	 * ���[�U�[�̎擾
	 * 
	 * @param loginName ���O�C������
	 * @return User ���[�U�[
	 * @throws DataAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public User select(String loginName) throws XmlAccessSysException;
	
	/**
	 * ���[�U�[�̎擾
	 * 
	 * @param loginName ���O�C������
	 * @param orgId �g�D����
	 * @return User ���[�U�[
	 * @throws DataAccessSysException �V�X�e���G���[�̏ꍇ
	 */
	public User select(String loginName,String orgId) throws XmlAccessSysException;

	/**
	 * ���[�U�[ �̓o�^
	 * 
	 * @param user ���[�U�[
	 * @throws DataAccessSysException �V�X�e���G���[�̏ꍇ
	 * @throws DataAccessAppException �A�v���P�[�V�����G���[�̏ꍇ�B
	 */
	public void insert(User user) throws XmlAccessSysException;

	/**
	 * ���[�U�[�̕ҏW
	 * 
	 * @param user ���[�U�[
	 * @throws DataAccessSysException �V�X�e���G���[�̏ꍇ
	 * @throws DataAccessAppException �A�v���P�[�V�����G���[�̏ꍇ�B
	 */
	public void update(User user) throws XmlAccessSysException;

	/**
	 * ���[�U�[�̍폜
	 * 
	 * @param userNo ���[�U�[No
	 * @throws DataAccessSysException �V�X�e���G���[�̏ꍇ
	 * @throws DataAccessAppException �A�v���P�[�V�����G���[�̏ꍇ�B
	 */
	public void delete(String userNo) throws XmlAccessSysException;
}