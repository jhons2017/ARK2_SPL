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
package flowbuilder.daoimpl.flowbuilder.user;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import flowbuilder.dao.conf.FlowBuilderSystemConfig;

import fbcom.framework.dao.conf.ConfigReader;

/**
 * 契約データアクセスオブジェクトの抽象ファクトリクラス。
 */
public abstract class DataAccessFactory
{
	//ロギング
	private static final Log _log = LogFactory.getLog(DataAccessFactory.class);
	
	/**
	 * 実装Factoryクラスのインスタンスを取得する。
	 * 
	 * @param implClassRef 実装クラスの完全修飾名への参照。
	 * 
	 * @return ContractDataAccessFactory 実装Factoryクラスのインスタンス(インスタンスの生成に失敗したとき、nullを返す)
	 * @throws Exception 
	 * @exception DataAccessSysException データアクセスのシステムエラーの場合。
	 */
	public static DataAccessFactory getFactory(String implClassRef) throws Exception 
	{
		DataAccessFactory result = null;

		try
		{
			ConfigReader conf = FlowBuilderSystemConfig.getInstance();
			String className = conf.getValue(implClassRef);
			result = (DataAccessFactory) Class.forName(className).newInstance();
		}
		catch (ClassNotFoundException e)
		{
			_log.fatal(e.getMessage(), e);
			throw new Exception("XMLファイルのアクセスに失敗しました。");
		}
		catch (IllegalAccessException e)
		{
			_log.fatal(e.getMessage(), e);
			throw new Exception("XMLファイルのアクセスに失敗しました。");
		}
		catch (InstantiationException e)
		{
			_log.fatal(e.getMessage(), e);
			throw new Exception("XMLファイルのアクセスに失敗しました。");
		}
		return result;
	}

//	
//	
//	/**
//	 * ユーザーXML処理Accessのデータアクセスオブジェクトを生成する。
//	 * 
//	 * @return UserXMLAccess ユーザーXML処理Accessのデータアクセスオブジェクト
//	 */
//	public abstract UserXMLAccess createUserXMLAccess();

}