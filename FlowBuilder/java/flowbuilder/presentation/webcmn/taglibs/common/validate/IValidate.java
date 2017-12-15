/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/06/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/06 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs.common.validate;

import java.util.Map;

/**
 * チェック機能インタフェース <BR>
 */
public interface IValidate 
{
	/**
	 * パラメータを保存したメップ
	 * @param params　メップ
	 */
	public void init(Map params);
	
	/**
	 * スクリプトを出力する。
	 * @return　String　スクリプト
	 */
	public String print();
}
