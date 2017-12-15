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
package flowbuilder.application.orglist;

/**
 * ログ登録のstaticファクトリメソッドを提供する。 <BR>
 */
public class OrgListServiceFactory {
	/**
	 * staticファクトリメソッドだけなので、インスタンス化させない。
	 */
	private OrgListServiceFactory() {
	}

	/**
	 * ログ登録のインスタンスを取得する。
	 * 
	 * @return UserService
	 * @throws Exception 
	 */
	public static OrgListService getOrgListServiceInstance() throws Exception {
		return new OrgListServiceImpl();
	}
}