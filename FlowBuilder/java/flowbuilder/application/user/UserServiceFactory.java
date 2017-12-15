package flowbuilder.application.user;

/* =================================================================
 * NO.83XXXXXX
 * ITEM = 001 ; REV = 00 ; DATE 2005/12/16
 *
 * (c) 2005 Yamatake Corporation All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2005/12/16 BY. DINGZHI (WXHX)
 * =================================================================
 */

import flowbuilder.application.util.SystemFactroyKey;
import flowbuilder.dao.user.UserDataAccessFactroy;
import flowbuilder.dao.user.UserQueryInfo;
import fbcom.framework.exceptions.SysException;

/**
 * ユーザー管理のstaticファクトリメソッドを提供する<BR>
 */
public class UserServiceFactory
{
	/**
	 * staticファクトリメソッドだけなので、インスタンス化させない。
	 *
	 */
	private UserServiceFactory()
	{
	}
	
	/**
	 * ユーザー管理サービスのインスタンスを取得する。 
	 * 
	 * @return UserService
	 * @throws SysException
	 */
	public static UserService getUserServiceInstance() throws SysException
	{
		return new UserServiceImpl();
	}
	
	/**
	 * 検索条件のインスタンスを取得する。 
	 * 
	 * @return UserQueryInfoの実装クラスのインスタンス
	 * @throws SysException
	 */
	public static UserQueryInfo getUserQueryInstance() throws SysException
	{
		UserDataAccessFactroy daoFactory = UserDataAccessFactroy.getFactory(SystemFactroyKey.UserFactroyKey);
		return daoFactory.createUserQueryInfo();
	}
}
