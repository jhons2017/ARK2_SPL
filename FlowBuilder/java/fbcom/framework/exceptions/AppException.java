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
package fbcom.framework.exceptions;

/**
 * アプリケーション例外。
 * java.lang.ExceptionのコンストラクタException(String message)にて、
 * リソースバンドルで定義されているメッセージキーを指定して使用する。
 * 
 * <定義>
 * 例えば、ユーザがアプリケーションにログインしようとして、パスワードを間違えた場合など、
 * ビジネスルールの侵害などで発生する例外のこと。
 * <取り扱い>
 * 制御を入力ページに戻して、エラーメッセージを表示し、ユーザが再入力などのアクションを
 * 取れるようにする。
 */
public class AppException extends BaseException
{
	/**
	 * コンストラクタ
	 * @param messageKey メッセージキー
	 */
	public AppException(String messageKey)
	{
		super(messageKey);
	}
	
	/**
	 * コンストラクタ
	 * @param messageKey メッセージキー
	 * @param rootCause　主原因
	 */
	public AppException(String messageKey, Throwable rootCause) 
	{
		super(messageKey, rootCause);
	}
}
