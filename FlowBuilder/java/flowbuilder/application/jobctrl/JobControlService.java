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
package flowbuilder.application.jobctrl;

import fbcom.framework.exceptions.SysException;
import flowbuilder.domain.jobctrl.JobCtrlParameter;

/**
 * 操作フラグによって、特定の操作を実行する。<BR>
 */
public interface JobControlService {

	/**
	 * 操作フラグによって、特定の操作を実行する。
	 * 
	 * @param jobParameters
	 *            論理操作用のパラメータ
	 *            
	 * @throws SysException
	 *             システムのエラーが発生しました。<BR>
	 */
	public void jobControl(JobCtrlParameter jobParameters) throws SysException;

}
