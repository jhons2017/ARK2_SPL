package flowbuilder.dao.joblist;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fbcom.framework.dao.conf.ConfigReader;
import fbcom.framework.exceptions.XmlAccessSysException;
import flowbuilder.dao.conf.FlowBuilderSystemConfig;


public abstract class JobListDataAccessFactroy {
	//ロギング
	private static final Log _log = LogFactory.getLog(JobListDataAccessFactroy.class);

	/**
	 * 実装Factoryクラスのインスタンスを取得する。
	 * 
	 * @return 実装Factoryクラスのインスタンス(インスタンスの生成に失敗したとき、nullを返す)
	 * 
	 * @param implClassRef 実装クラスの完全修飾名への参照。
	 * @exception DataAccessSysException データアクセスのシステムエラーの場合。
	 */
	public static JobListDataAccessFactroy getFactory(String implClassRef) throws XmlAccessSysException
	{
		JobListDataAccessFactroy result = null;

		try
		{
			ConfigReader conf = FlowBuilderSystemConfig.getInstance();
			String className = conf.getValue(implClassRef);
			result = (JobListDataAccessFactroy) Class.forName(className).newInstance();
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
	 * ジョブリストのデータアクセスオブジェクトを生成する。
	 * 
	 * @return ジョブリストのデータアクセスオブジェクト
	 */
	public abstract JobListDAO createJobListDAO();
	
	/**
	 * ジョブリストの検索条件オブジェクトを生成する。
	 * 
	 * @return ジョブリストの検索条件オブジェクト
	 */
	public abstract JobListQueryInfo createJobListQueryInfo();

}
