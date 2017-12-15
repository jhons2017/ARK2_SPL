/* =================================================================
 * NO.83XXXXXX
 * ITEM = 001 ; REV = 00 ; DATE 2005/01/18
 *
 * (c) 2005 Yamatake Corporation All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2005/01/18 BY. LJW(WXHX)
 * =================================================================
 */
package fbcom.framework.exceptions;

/**
 * システム例外。
 * java.lang.ExceptionのコンストラクタException(String message)にて、
 * リソースバンドルで定義されているメッセージキーを指定して使用する。
 * 
 * <定義>
 * 例えば、プログラミング上のエラーの場合や、ネットワーク上の問題など、
 * アプリケーションロジックとは関係しないローレベルの問題で、エンドユーザは、
 * そこから回復することが出来ない例外のこと。
 * <取り扱い>
 * システムエラーページを表示する。
 * （場合によっては、システム管理者に連絡すべきだと伝える。)
 * エンドユーザの信頼を損ねないために、例外のスタックとレースは表示すべきでない。
 * システムエラーページには、以下の項目を表示する。
 * 	例外が発生した時刻(原因分析の際、ログの調査を容易にするため）
 * 	ユーザが理解できるエラーメッセージ
 */
public class SysException extends BaseException
{
	/**
	 * コンストラクタ
	 * @param messageKey メッセージキー
	 */
	public SysException(String messageKey)
	{
		super(messageKey);
	}
	
	/**
	 * コンストラクタ
	 * @param messageKey メッセージキー
	 * @param rootCause　主原因
	 */
	public SysException(String messageKey, Throwable rootCause) 
	{
		super(messageKey, rootCause);
	}
}
