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

import fbcom.framework.exceptions.SysException;

/**
 * ジョブ表示のstaticファクトリメソッドを提供する。 <BR>
 */
public class JobShowServiceFactory {
	/**
	 * staticファクトリメソッドだけなので、インスタンス化させない。
	 */
	private JobShowServiceFactory() {
	}

	/**
	 * ジョブ表示のインスタンスを取得する。
	 * 
	 * @return UserService
	 * @throws Exception 
	 */
	public static JobShowService getOrgListServiceInstance() throws SysException {
		return new JobShowServiceImpl();
	}
}