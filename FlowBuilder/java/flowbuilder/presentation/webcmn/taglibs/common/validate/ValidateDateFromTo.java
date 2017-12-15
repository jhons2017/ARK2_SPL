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
 * 前後の日付を比較チェック
 * 
 * @auther YANGZHEN
 */
public class ValidateDateFromTo extends ValidateParent {

	/**
	 * スクリプトを出力する。
	 * @param partName 部品のHTML名前
	 * @param startTime 開始日付
	 * @param endTime 結束日付
	 * @return　htmlId 部品の名前
	 * @return　部品に対応するスクリプト
	 */
	public void onPrint(StringBuffer sbuf) {
		String js = "csDatetoCompare('" + _params.get("startTime") + "','" + _params.get("endTime") + "','" + _params.get("partName") + "')";
		sbuf.append(js);
	}
}
