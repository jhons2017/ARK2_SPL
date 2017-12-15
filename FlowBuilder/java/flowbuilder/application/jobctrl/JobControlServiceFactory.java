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

/**
 * 案件制御のstaticファクトリメソッドを提供する。 <BR>
 */
public class JobControlServiceFactory {
	/**
	 * staticファクトリメソッドだけなので、インスタンス化させない。
	 */
	private JobControlServiceFactory() {
	}

	/**
	 * 案件制御のインスタンスを取得する。
	 * 
	 * @return JobControlService　案件制御インスタンス
	 * @throws Exception 
	 */
	public static JobControlService getControlServiceInstance() throws SysException {
		return new JobControlServiceImpl();
	}
}