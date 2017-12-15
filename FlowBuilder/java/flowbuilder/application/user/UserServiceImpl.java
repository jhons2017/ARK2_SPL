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
 *  ユーザー管理サービスを定義するインターフェイス。 <br>
 */
final class UserServiceImpl implements UserService
{
	/** DAOファクトリを取得 */
	private UserDataAccessFactroy _daoFactory = null;
	
	/** ユーザーDAO */
	private UserDAO _userDAO;
	
	/** 組織DAO */
	private SectionDAO _orgDAO;
	
	/** ルールDAO */
	private RoleDAO _roleDAO;
	
	
	/** ユーザー検索のための検索条件のDAO */
	private UserQueryInfo _userQueryInfo = null;
	
	/**
	 * コンストラクタ
	 * 
	 * @throws SysException システムエラーの場合
	 */
	UserServiceImpl() throws SysException
	{
		_daoFactory = UserDataAccessFactroy.getFactory("UserDaoFactory");
		init();
	}
	
	/**
	 * 初期化処理
	 */
	private void init()
	{
		_userDAO = _daoFactory.createUserDAO();
		_orgDAO = _daoFactory.createSectionDAO();
		_roleDAO = _daoFactory.createRoleDAO();
	}
	
	/**
	 * ユーザーの検索条件を設定する。 
	 * 
	 * @param query ユーザーの検索条件
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
	 * 検索条件にヒットしたユーザーの数を取得する。 <BR> 
	 * 事前条件：setQuery()が実行されていること。
	 * 
	 * @return int 検索条件にヒットしたユーザーの数
	 * @throws SysException システムエラーの場合。
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
	 *  検索条件を満たすユーザーの概要の一覧を取得する。 <BR> 
	 *	検索条件に一件もヒットしなかった場合、空のListを返す。 <BR> 
	 *	検索結果がcountで指定した数に満たない場合、取得可能な分だけのListを返す。 <BR>
	 *	例えば、検索結果が50件であり、getUserSummaryList(41, 20)とした場合、 <BR> 41件～50件目のユーザーのリストを返す。 <BR>
	 *	事前条件：setQuery()が実行されていること。 
	 * 
	 * @param beginIndex 開始インデックス(1以上)
	 * @param count 取得したい数
	 * @return List 中身はUserDTO。
	 * @throws SysException システムエラーの場合。
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
	 *  検索条件を満たすユーザー情報リストを取得する <BR>
	 *	検索条件に一件もヒットしなかった場合、空のListを返す。 <BR>
	 *	事前条件：setQuery()が実行されていること。
	 * 
	 * @return List 中身はUser。
	 * @throws DataAccessSysException 指定されたユーザが存在しない場合。
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
	 * ユーザー情報を取得する。
	 * 
	 * @return User ユーザー
	 * @param loginName    ログイン名
	 * @throws NullPointerException loginNameがnullの場合。
	 * @throws DataAccessAppException 指定されたユーザが存在しない場合。
	 * @throws SysException システムエラーの場合。
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
	 * ユーザー情報を取得する。
	 * 
	 * @return User ユーザー
	 * @param loginName    ログイン名
	 * @throws NullPointerException loginNameがnullの場合。
	 * @throws DataAccessAppException 指定されたユーザが存在しない場合。
	 * @throws SysException システムエラーの場合。
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
	 * ユーザー情報を取得する。
	 * 
	 * @return User ユーザー
	 * @param loginName    ログイン名
	 * @throws NullPointerException loginNameがnullの場合。
	 * @throws DataAccessAppException 指定されたユーザが存在しない場合。
	 * @throws SysException システムエラーの場合。
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
	 *  検索条件を満たすユーザー情報リストを取得する <BR>
	 *	検索条件に一件もヒットしなかった場合、空のListを返す。 <BR>
	 * 
	 * @return List 中身はUser。
	 * @throws DataAccessSysException 指定されたユーザが存在しない場合。
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
	 * ユーザーを登録する。
	 * 
	 * @param user ユーザー
	 * @throws NullPointerException equipmentがnullの場合。
	 * @throws DataAccessAppException 主キー、またはユニーク属性の値が重複の場合、 <BR>
	 * 				または設定可能な値の範囲を超える場合、 <BR>
	 * 			 	または必須項目が入力されていない場合
	 * @throws DataAccessSysException システムエラーの場合。
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
	 * ユーザーを変更する。
	 * 
	 * @param user    :更新されるユーザー情報
	 * @throws NullPointerException oldUserまたはnewUserがnullの場合。
	 * @throws DataAccessAppException 主キー、またはユニーク属性の値が重複の場合、 <BR>
	 * 		 		または設定可能な値の範囲を超える場合、 <BR>
	 * 		 		または必須項目が入力されていない場合、 <BR>
	 * 				または指定したキーに対応するレコードが存在しない場合
	 * @throws SysException システムエラーの場合。
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
	 * ユーザーを削除する。
	 * 
	 * @param userNo    ユーザーNo
	 * @throws NullPointerException userNoがnullの場合。
	 * @throws DataAccessAppException 指定したキーに対応するレコードが存在しない場合
	 * @throws SysException システムエラーの場合。
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
	 * 組織ＩＤによって組織オブジェクトを取得する。
	 * 
	 * @param sectionNo    組織ＩＤ
	 * @throws SysException システムエラーの場合。
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
	 * 組織名前によって組織オブジェクトを取得する。
	 * 
	 * @param sectionNo    組織名前
	 * @throws SysException システムエラーの場合。
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
	 *  検索条件を満たすユーザー情報リストを取得する <BR>
	 *	検索条件に一件もヒットしなかった場合、空のListを返す。 <BR>
	 * 
	 * @return List 中身はUser。
	 * @param orgId    組織ID
	 * @throws DataAccessSysException 指定されたユーザが存在しない場合。
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
