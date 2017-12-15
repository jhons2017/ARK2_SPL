package flowbuilder.application.user;

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


import java.util.List;

import fbcom.framework.exceptions.DataAccessAppException;
import fbcom.framework.exceptions.DataAccessSysException;
import fbcom.framework.exceptions.RecordNotFoundAppException;
import fbcom.framework.exceptions.SysException;
import fbcom.framework.exceptions.XmlAccessSysException;
import flowbuilder.dao.user.RoleDAO;
import flowbuilder.dao.user.SectionDAO;
import flowbuilder.dao.user.UserDAO;
import flowbuilder.dao.user.UserDataAccessFactroy;
import flowbuilder.dao.user.UserQueryInfo;
import flowbuilder.domain.user.Role;
import flowbuilder.domain.user.Section;
import flowbuilder.domain.user.User;
import flowbuilder.view.user.UserDTO;


/**
 *  ���[�U�[�Ǘ��T�[�r�X���`����C���^�[�t�F�C�X�B <br>
 */
final class UserServiceImpl implements UserService
{
	/** DAO�t�@�N�g�����擾 */
	private UserDataAccessFactroy _daoFactory = null;
	
	/** ���[�U�[DAO */
	private UserDAO _userDAO;
	
	/** �g�DDAO */
	private SectionDAO _orgDAO;
	
	/** ���[��DAO */
	private RoleDAO _roleDAO;
	
	
	/** ���[�U�[�����̂��߂̌���������DAO */
	private UserQueryInfo _userQueryInfo = null;
	
	/**
	 * �R���X�g���N�^
	 * 
	 * @throws SysException �V�X�e���G���[�̏ꍇ
	 */
	UserServiceImpl() throws SysException
	{
		_daoFactory = UserDataAccessFactroy.getFactory("UserDaoFactory");
		init();
	}
	
	/**
	 * ����������
	 */
	private void init()
	{
		_userDAO = _daoFactory.createUserDAO();
		_orgDAO = _daoFactory.createSectionDAO();
		_roleDAO = _daoFactory.createRoleDAO();
	}
	
	/**
	 * ���[�U�[�̌���������ݒ肷��B 
	 * 
	 * @param query ���[�U�[�̌�������
	 */
	public void setQuery(UserQueryInfo query)
	{
		if (query != null)
		{
			_userQueryInfo = _daoFactory.createUserQueryInfo();

			_userQueryInfo = query;
		}
		else
		{
			throw new NullPointerException("query is null");
		}
	}

	/**
	 * ���������Ƀq�b�g�������[�U�[�̐����擾����B <BR> 
	 * ���O�����FsetQuery()�����s����Ă��邱�ƁB
	 * 
	 * @return int ���������Ƀq�b�g�������[�U�[�̐�
	 * @throws SysException �V�X�e���G���[�̏ꍇ�B
	 */
	public int getCountOfUser() throws SysException
	{
		if (_userQueryInfo == null)
		{
			throw new IllegalStateException("setQuery() is not executed");
		}
		return _userDAO.getCount(_userQueryInfo);
	}

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
	public List getUserSummaryList(int beginIndex, int count) throws SysException
	{
		if (_userQueryInfo == null)
		{
			throw new IllegalStateException("setQuery() is not executed");
		}
		if (beginIndex < 1)
		{
			throw new IndexOutOfBoundsException("[beginIndex>0],but now beginIndex is:" + beginIndex);
		}
		if (count < 1)
		{
			throw new IndexOutOfBoundsException("[count>0],but now count is:" + count);
		}
		int countOfUser = getCountOfUser();
		if (beginIndex > countOfUser)
		{
			throw new IndexOutOfBoundsException("[beginIndex<=" + countOfUser + "],but now beginIndex is:" + beginIndex);
		}

		return _userDAO.getSummaryList(_userQueryInfo, beginIndex, count);
	}

	/**
	 *  ���������𖞂������[�U�[��񃊃X�g���擾���� <BR>
	 *	���������Ɉꌏ���q�b�g���Ȃ������ꍇ�A���List��Ԃ��B <BR>
	 *	���O�����FsetQuery()�����s����Ă��邱�ƁB
	 * 
	 * @return List ���g��User�B
	 * @throws DataAccessSysException �w�肳�ꂽ���[�U�����݂��Ȃ��ꍇ�B
	 */
	public List getUserList() throws XmlAccessSysException
	{
		if (_userQueryInfo == null)
		{
			throw new IllegalStateException("setQuery() is not executed");
		}
		return _userDAO.getList(_userQueryInfo);
	}

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
	  			throws SysException,RecordNotFoundAppException
	{
		if (loginName == null)
		{
			throw new NullPointerException("loginId is null.");
		}

		User user = _userDAO.select(loginName);

		if (user == null)
		{
			throw new RecordNotFoundAppException("User.Error.NotFound");
		}

		return user;
	}
	
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
	  			throws SysException,RecordNotFoundAppException{
		if (loginName == null || orgId == null)
		{
			throw new NullPointerException("loginId is null.");
		}

		User user = _userDAO.select(loginName,orgId);

		if (user == null)
		{
			throw new RecordNotFoundAppException("User.Error.NotFound");
		}

		return user;
		
	}
	
	
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
	  			throws SysException,RecordNotFoundAppException{
		if (loginName == null || orgId == null || roleId == null)
		{
			throw new NullPointerException("loginId or orgId is null.");
		}		
		
		UserDTO userDTO = new UserDTO();
		
		User user = getUser(loginName);
		Section org = _orgDAO.selectById(orgId);
		Role role = _roleDAO.select(roleId);
		
		if (user == null || org == null || role == null)
		{
			throw new RecordNotFoundAppException("User.Error.NotFound");
		}
		
		userDTO.setUserName(user.getUserName());
		userDTO.setOrgName(org.getName());
		userDTO.setRoleName(role.getRoleName());

		return userDTO;	
	}
	
	
	/**
	 *  ���������𖞂������[�U�[��񃊃X�g���擾���� <BR>
	 *	���������Ɉꌏ���q�b�g���Ȃ������ꍇ�A���List��Ԃ��B <BR>
	 * 
	 * @return List ���g��User�B
	 * @throws DataAccessSysException �w�肳�ꂽ���[�U�����݂��Ȃ��ꍇ�B
	 */
	public List<User> getUpUsersId(String orgId,String roleId) throws XmlAccessSysException
	{
		if (orgId == null)
		{
			throw new IllegalStateException("orgId is null");
		}
		if (roleId == null)
		{
			throw new IllegalStateException("roleId is null");
		}
		return _userDAO.getUpUsersId(orgId,roleId);
	}
	
	
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
	public void createUser(User user) throws XmlAccessSysException
	{
		if (user == null)
		{
			throw new NullPointerException("user is null");
		}
		try
		{
			_userDAO.insert(user);
		}
		catch(XmlAccessSysException e)
		{
			throw new XmlAccessSysException("User.Error.UserDuplicate");
		}
	}
	
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
	  			throws SysException
	{
		if (user == null)
		{
			throw new NullPointerException("User is null");
		}

		UserDAO userDAO = _daoFactory.createUserDAO();

		try
		{
			userDAO.update(user);
		}
		catch(XmlAccessSysException e)
		{
			throw new XmlAccessSysException("User.Error.UserDuplicate");
		}
	}

	/**
	 * ���[�U�[���폜����B
	 * 
	 * @param userNo    ���[�U�[No
	 * @throws NullPointerException userNo��null�̏ꍇ�B
	 * @throws DataAccessAppException �w�肵���L�[�ɑΉ����郌�R�[�h�����݂��Ȃ��ꍇ
	 * @throws SysException �V�X�e���G���[�̏ꍇ�B
	 */
	public void deleteUser(String userNo)
				throws XmlAccessSysException
	{
		if (userNo == null)
		{
			throw new NullPointerException("userNo <= 0");
		}

		_userDAO.delete(userNo);
	}
	
	/**
	 * �g�D�h�c�ɂ���đg�D�I�u�W�F�N�g���擾����B
	 * 
	 * @param sectionNo    �g�D�h�c
	 * @throws SysException �V�X�e���G���[�̏ꍇ�B
	 */
	public Section getSectionById(String sectionNo)
				throws SysException{
		Section section = null;
		
		if (sectionNo != null || "".equals(sectionNo))
		{
			section = _orgDAO.selectById(sectionNo);
		}
		else
		{
			throw new SysException("Sys error!");
		}
		
		return section;
	}
	
	/**
	 * �g�D���O�ɂ���đg�D�I�u�W�F�N�g���擾����B
	 * 
	 * @param sectionNo    �g�D���O
	 * @throws SysException �V�X�e���G���[�̏ꍇ�B
	 */
	public Section getSectionByName(String sectionName)
				throws SysException{
		Section section = null;
		
		if (sectionName != null || "".equals(sectionName))
		{
			section = _orgDAO.selectByName(sectionName);
		}
		else
		{
			throw new SysException("Sys error!");
		}
		
		return section;
	}
	
	/**
	 *  ���������𖞂������[�U�[��񃊃X�g���擾���� <BR>
	 *	���������Ɉꌏ���q�b�g���Ȃ������ꍇ�A���List��Ԃ��B <BR>
	 * 
	 * @return List ���g��User�B
	 * @param orgId    �g�DID
	 * @throws DataAccessSysException �w�肳�ꂽ���[�U�����݂��Ȃ��ꍇ�B
	 */
	public List getUsersByOrgId(String orgId) throws XmlAccessSysException
	{
		if (orgId == null)
		{
			throw new IllegalStateException("orgId is null");
		}
		return _userDAO.getListByOrgId(orgId);
	}
}
