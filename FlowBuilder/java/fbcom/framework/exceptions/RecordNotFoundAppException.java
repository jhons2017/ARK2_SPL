/* =================================================================
 * NO.83XXXXXX
 * ITEM = 001 ; REV = 00 ; DATE 2005/04/21
 *
 * (c) 2005 Yamatake Corporation All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2005/04/21 BY. DHW(WXHX)
 * =================================================================
 */
package fbcom.framework.exceptions;

/**
 * 指定したキーに対応するレコードが存在しない場合にスローされる例外。
 */
public class RecordNotFoundAppException extends DataAccessAppException
{
	/**
	 * コンストラクタ
	 * @param messageKey メッセージキー
	 */
	public RecordNotFoundAppException(String messageKey)
	{
		super(messageKey);
	}
	
}
