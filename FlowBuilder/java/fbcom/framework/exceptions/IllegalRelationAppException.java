/* =================================================================
 * NO.83XXXXXX
 * ITEM = 001 ; REV = 00 ; DATE 2005/06/07
 *
 * (c) 2005 Yamatake Corporation All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2005/06/07 BY. ZYJ (WXHX)
 * =================================================================
 */
package fbcom.framework.exceptions;

/**
 * ステートメントは制約の外部キーと矛盾している場合にスローされる例外。
 */
public class IllegalRelationAppException extends DataAccessAppException
{
	/**
	 * コンストラクタ
	 * @param messageKey メッセージキー
	 */
	public IllegalRelationAppException(String messageKey)
	{
		super(messageKey);
	}
	
}
