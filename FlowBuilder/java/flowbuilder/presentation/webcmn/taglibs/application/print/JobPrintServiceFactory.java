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
package flowbuilder.presentation.webcmn.taglibs.application.print;

import fbcom.framework.exceptions.SysException;

/**
 * 案件制御のstaticファクトリメソッドを提供する。 <BR>
 */
public class JobPrintServiceFactory {
	/**
	 * staticファクトリメソッドだけなので、インスタンス化させない。
	 */
	private JobPrintServiceFactory() {
	}

	/**
	 * 案件制御のインスタンスを取得する。
	 * 
	 * @return JobControlService　案件制御インスタンス
	 * @throws Exception 
	 */
	public static JobPrintService getControlServiceInstance() throws SysException {
		return new JobPrintServiceImpl();
	}
}