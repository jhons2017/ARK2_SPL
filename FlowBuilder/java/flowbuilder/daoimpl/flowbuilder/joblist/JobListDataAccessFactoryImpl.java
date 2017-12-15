package flowbuilder.daoimpl.flowbuilder.joblist;

import flowbuilder.dao.joblist.*;
public final class JobListDataAccessFactoryImpl extends JobListDataAccessFactroy {

	/**
	 * ジョブリストのデータアクセスオブジェクトを生成する。
	 * 
	 * @return ジョブリストのデータアクセスオブジェクト
	 */
	public JobListDAO createJobListDAO() {
		return new JobListDAOImpl();
	}
	
	/**
	 * ジョブリストの検索条件オブジェクトを生成する。
	 * 
	 * @return ジョブリストの検索条件オブジェクト
	 */
	public JobListQueryInfo createJobListQueryInfo(){
		return new JobListQueryInfoImpl();
	}
}
