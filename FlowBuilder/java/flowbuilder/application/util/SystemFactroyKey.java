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
package flowbuilder.application.util;

/**
 * 
 * SystemConfig.propertiesこのファイルで、キーの定義　<br>
 * 例えば：　DaoFactory=FlowBuilder.middimpl.DataAccessFactoryImpl <br>
 *		　「DaoFactory」この値はFactroyのキーです。
 *
 */
public final class SystemFactroyKey {
	/**
	 * ユーザFactoryの定義
	 */
	public static final String UserFactroyKey = "UserDaoFactory";
	
	/**
	 * ジョブリストFactoryの定義
	 */
	public static final String JobListFactroyKey = "JobListDaoFactory";
}
