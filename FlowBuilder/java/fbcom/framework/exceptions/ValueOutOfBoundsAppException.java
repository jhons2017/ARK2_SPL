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
 * 設定可能な値の範囲を超える場合にスローされる例外。
 */
public class ValueOutOfBoundsAppException extends DataAccessAppException
{
	/**
	 * コンストラクタ
	 * @param messageKey メッセージキー
	 */
	public ValueOutOfBoundsAppException(String messageKey)
	{
		super(messageKey);
	}
	
}
