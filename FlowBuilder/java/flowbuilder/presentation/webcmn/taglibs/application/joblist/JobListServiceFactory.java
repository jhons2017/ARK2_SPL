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
package flowbuilder.presentation.webcmn.taglibs.application.joblist;

/**
 * ログ登録のstaticファクトリメソッドを提供する。 <BR>
 */
public class JobListServiceFactory {
	/**
	 * staticファクトリメソッドだけなので、インスタンス化させない。
	 */
	private JobListServiceFactory() {
	}

	/**
	 * ログ登録のインスタンスを取得する。
	 * 
	 * @return UserService
	 * @throws Exception 
	 */
	public static JobListService getOrgListServiceInstance() throws Exception {
		return new JobListServiceImpl();
	}
}