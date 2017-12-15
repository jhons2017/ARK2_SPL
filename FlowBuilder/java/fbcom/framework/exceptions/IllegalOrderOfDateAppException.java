/* =================================================================
 * NO.83XXXXXX
 * ITEM = 001 ; REV = 00 ; DATE 2005/04/11
 *
 * (c) 2005 Yamatake Corporation All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2005/04/11 BY. Liu(WXHX)
 * =================================================================
 */
package fbcom.framework.exceptions;

/**
 * 指定された期間の順序が不正な場合にスローされる例外。
 */
public class IllegalOrderOfDateAppException extends AppException
{
	/**
	 * コンストラクタ
	 * @param messageKey メッセージキー
	 */
	public IllegalOrderOfDateAppException(String messageKey)
	{
		super(messageKey);
	}
	
}
