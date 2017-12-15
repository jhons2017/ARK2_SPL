/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/05/25
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/01 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs.common.validate;

import java.util.Map;

/**
 * 
 * 部品チェック機能のスーパークラス <BR>
 * 
 */
public abstract class ValidateParent implements IValidate {
	protected Map _params;

	/**
	 * 
	 * 
	 * @param params Map
	 */
	public void init(Map params) {
		_params = params;
	}

	/**
	 * 
	 */
	public String print() {
		StringBuffer result = new StringBuffer();
		onPrint(result);

		return result.toString();
	}

	/**
	 * スクリプトを出力する。
	 * @param partName 部品のHTML名前
	 * @param htmlId 部品の名前
	 * @return　部品に対応するスクリプト
	 */
	public abstract void onPrint(StringBuffer sbuf);
}
