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

import fbcom.framework.exceptions.SysException;

/**
 * データのアクセス時に何らかの予期しないエラーが発生したことを表す。
 * 例えば､DBへの接続エラーやファイルI/Oエラーなど。
 */
public class XmlAccessSysException extends SysException
{
	/**
	 * コンストラクタ
	 * @param messageKey メッセージキー
	 */
	public XmlAccessSysException(String messageKey)
	{
		super(messageKey);
	}
}
