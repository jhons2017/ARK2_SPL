/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/03/06 BY. XUXM (WXHX)
 * =================================================================
 */
package fbcom.framework.dao.conf;

/**
 * 設定ファイルの読み込みを行なう。
 */
public interface ConfigReader
{
	/**
	 * keyに対する値を取得する。
	 * keyが存在しない場合は、nullを返す。
	 * @param key キー
	 * @return keyに対する値
	 */
	public String getValue(String key);
}
