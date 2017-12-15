/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/26
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/04/26 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.dao.joblist;

import java.util.List;

import flowbuilder.domain.joblist.JobList;
import fbcom.framework.exceptions.SysException;

/**
 * ジョブリスト操作のインタフェース
 */
public interface JobListDAO {
	/**
	 * 条件によって、ジョブリストで記録の数量を戻る
	 * 
	 * @param query　検索条件
	 * @return ジョブリストで記録の数量
	 * @throws SysException xmlファイルに操作のうちに、エラーが発生する
	 */
	public int getCount(JobListQueryInfo query) throws SysException;

	/**
	 * ジョブリストを取得する
	 * 
	 * @param query 検索条件
	 * @return　ジョブ記録を格納したリスト
	 * @throws SysException xmlファイルに操作のうちに、エラーが発生する
	 */
	public List<JobList> getJobList(JobListQueryInfo query) throws SysException;

	/**
	 * ジョブリストを追加する
	 *
	 * @param joblist ジョブ記録
	 * @throws SysException xmlファイルに操作のうちに、エラーが発生する
	 */
	public void insert(JobList joblist) throws SysException;

	/**
	 * ジョブリストの更新
	 * 
	 * @param joblist　ジョブ記録
	 * @throws SysException xmlファイルに操作のうちに、エラーが発生する
	 */
	public void update(JobList joblist) throws SysException;

	/**
	 * リストより案件削除
	 * 
	 * @param strJobId　ジョブID
	 * @throws SysException xmlファイルに操作のうちに、エラーが発生する
	 */
	public void delete(String strJobId) throws SysException;
}
