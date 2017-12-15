/* =================================================================
 * NO.83XXXXXX
 * ITEM = 001 ; REV = 00 ; DATE 2005/01/19
 *
 * (c) 2005 Yamatake Corporation All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2005/01/19 BY. LJW(WXHX)
 * =================================================================
 */
package fbcom.framework.exceptions;

import fbcom.framework.exceptions.AppException;

/**
 * データのアクセス時に何らかの予期できるエラーが発生したことを表す。<BR> 
 * 例えば､登録時Key重複など。
 */
public class DataAccessAppException extends AppException
{
	/**
	 * コンストラクタ
	 * 
	 * @param messageKey メッセージキー
	 */
	public DataAccessAppException(
			String messageKey)
	{
		super(messageKey);
	}
}