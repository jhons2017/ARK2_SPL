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



import flowbuilder.dao.conf.FlowBuilderSystemConfig;
import fbcom.framework.dao.conf.ConfigReader;
import fbcom.framework.exceptions.XmlAccessSysException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * データアクセスオブジェクトの抽象ファクトリクラス。
 */
public abstract class UserDataAccessFactroy
{
	//ロギング
	private static final Log _log = LogFactory.getLog(UserDataAccessFactroy.class);

	/**
	 * 実装Factoryクラスのインスタンスを取得する。
	 * 
	 * @return 実装Factoryクラスのインスタンス(インスタンスの生成に失敗したとき、nullを返す)
	 * 
	 * @param implClassRef 実装クラスの完全修飾名への参照。
	 * @exception DataAccessSysException データアクセスのシステムエラーの場合。
	 */
	public static UserDataAccessFactroy getFactory(String implClassRef) throws XmlAccessSysException
	{
		UserDataAccessFactroy result = null;

		try
		{
			ConfigReader conf = FlowBuilderSystemConfig.getInstance();
			String className = conf.getValue(implClassRef);
			result = (UserDataAccessFactroy) Class.forName(className).newInstance();
		}
		catch (ClassNotFoundException e)
		{
			_log.fatal(e.getMessage(), e);
			throw new XmlAccessSysException("Error.Db.DataAccessFail");
		}
		catch (IllegalAccessException e)
		{
			_log.fatal(e.getMessage(), e);
			throw new XmlAccessSysException("Error.Db.DataAccessFail");
		}
		catch (InstantiationException e)
		{
			_log.fatal(e.getMessage(), e);
			throw new XmlAccessSysException("Error.Db.DataAccessFail");
		}
		return result;
	}

	/**
	 * 所属のデータアクセスオブジェクトを生成する。
	 * 
	 * @return 所属のデータアクセスオブジェクト
	 */
	public abstract SectionDAO createSectionDAO();

	/**
	 * 権限のデータアクセスオブジェクトを生成する。
	 * 
	 * @return 所属のデータアクセスオブジェクト
	 */
	public abstract RoleDAO createRoleDAO();
	
	/**
	 * ユーザーのデータアクセスオブジェクトを生成する。
	 * 
	 * @return ユーザーのデータアクセスオブジェクト
	 */
	public abstract UserDAO createUserDAO();

	/**
	 * ユーザー検索のデータアクセスオブジェクトを生成する。
	 * 
	 * @return ユーザー検索のデータアクセスオブジェクト
	 */
	public abstract UserQueryInfo createUserQueryInfo();

}