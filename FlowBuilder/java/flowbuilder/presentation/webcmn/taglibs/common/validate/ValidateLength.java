/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/05/25
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/08 BY. YANGZHEN (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs.common.validate;

/**
 * 文字列が長のチェック
 * 
 * @auther YANGZHEN
 */
public class ValidateLength extends ValidateParent{

	/**
	 * スクリプトを出力する。 
	 * @param partName 部品のHTML名前
	 * @param min 一番少ない値
	 * @param max 一番大きい値
	 * @param htmlId 部品の名前
	 * @return　部品に対応するスクリプト
	 */
	public void onPrint(StringBuffer sbuf) {
		String js = "csLength('" + _params.get("htmlId") + "','" + _params.get("min") + "','" + _params.get("max") + "','" + _params.get("partName") + "');";
		sbuf.append(js);
	}


}
