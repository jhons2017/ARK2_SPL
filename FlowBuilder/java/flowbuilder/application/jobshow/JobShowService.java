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
package flowbuilder.application.jobshow;

import flowbuilder.domain.joblist.JobList;
import flowbuilder.domain.jobshow.JobShow;
import fbcom.framework.exceptions.SysException;

/**
 * ジョブ表示操作のインタフェース <BR>
 */
public interface JobShowService {

	/**
	 * 部品操作用の新しいジョブの取得して、JSP画面用のBEANを戻る。
	 * 
	 * @param joblist　論理操作用のパラメータ
	 * @param userIp　ユーザIP
	 * @return　JSP画面用のBEAN
	 * @throws SysException　
	 *  		システムのエラーが発生しました。<BR>
	 */
	public JobShow getNewJobShow(JobList joblist,String userIp) throws SysException;
	
	
	/**
	 * あった案件を取得して、JSP画面用のBEANを戻る。
	 * 
	 * @param joblist　論理操作用のパラメータ
	 * @return　JSP画面用のBEAN
	 * @throws SysException
	 *  		システムのエラーが発生しました。<BR>
	 */
	public JobShow getJobShow(JobList joblist) throws SysException;
}
