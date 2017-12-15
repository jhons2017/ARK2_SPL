/* =================================================================
 * NO.83XXXXXX
 * ITEM = 001 ; REV = 00 ; DATE 2005/07/23
 *
 * (c) 2005 Yamatake Corporation All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2005/07/23 BY. DHW(WXHX)
 * =================================================================
 */
package fbcom.framework.exceptions;

/**
 * (作業日 > 今日) AND (作業項目.作業状況 = 完了)である場合、または (作業日 < 今日) AND (作業項目.作業状況 =
 * 作業予定)である場合にスローされる例外。
 */
public class IlleagalStateAppException extends AppException
{
	/**
	 * コンストラクタ
	 * @param messageKey メッセージキー
	 */
	public IlleagalStateAppException(String messageKey)
	{
		super(messageKey);
	}
	
}
