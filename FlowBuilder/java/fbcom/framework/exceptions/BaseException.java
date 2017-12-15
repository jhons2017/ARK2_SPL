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

import java.util.List;
import java.util.ArrayList;

/**
 * すべてのアプリケーション例外およびシステム例外用の共通のスーパークラス。
 * java.lang.ExceptionのコンストラクタException(String message)にて、
 * リソースバンドルで定義されているメッセージキーを指定して使用する。
 * 
 * また、_exceptionsフィールドで複数の例外もサポートしている。
 * 
 * jdk1.4以降では、Java標準APIで主原因がサポートされている。
 * 本クラスは、jdk1.4以降を対象として、主原因のサポートは、行なわない。
 */
public abstract class BaseException extends Exception
{
	/**
	 * 複数の例外。
	 * 例えば、最大値が決まっているフィールドが複数有り、いくつかのエラーが
	 * 発生した場合などに、複数の例外を保持できるようにする。
	 */
	private List _exceptions = new ArrayList();

	/**
	 * メッセージキーの引数。
	 */
	private Object[] _messageArgs;

	/**
	 * コンストラクタ
	 *
	 */
	public BaseException()
	{
		super();
	}
	
	/**
	 * コンストラクタ
	 * @param messageKey メッセージキー
	 */
	public BaseException(String messageKey)
	{
		super(messageKey);
	}
	
	/**
	 * コンストラクタ
	 * @param messageKey メッセージキー
	 * @param rootCause　主原因
	 */
	public BaseException(String messageKey, Throwable rootCause) 
	{
		super(messageKey, rootCause);
	}
	
	/**
	 * コンストラクタ
	 * @param rootCause　主原因
	 */
	public BaseException(Throwable rootCause)
	{
		super(rootCause);
	}
	
	/**
	 * 複数例外を取得する。
	 * @return 複数例外
	 */
	public List getExceptions()
	{
		return _exceptions;
	}
	
	/**
	 * 複数例外を追加する。
	 * @param ex 例外
	 */
	public void addException(BaseException ex)
	{
		_exceptions.add(ex);
	}
	
	/**
	 * メッセージキーの引数を取得する。
	 * @return メッセージキーの引数
	 */
	public Object[] getMessageArgs()
	{
		return _messageArgs;
	}
	
	/**
	 * メッセージキーの引数を設定する。
	 * @param messageArgs メッセージキーの引数
	 */
	public void setMessageArgs(Object[] messageArgs)
	{
		_messageArgs = messageArgs;
	}
	
// JDK1.4以降を対象とするため削除。
//	/**
//	 * 主原因の例外
//	 */
//	private Throwable _rootCause;
//
//	/**
//	 * メッセージキー。リソースバンドルで定義されているメッセージキー。
//	 */
//	private String _messageKey;
//

//	/**
//	 * メッセージキーを設定する。
//	 * @param key メッセージキー
//	 */
//	public void setMessageKey(String key)
//	{
//		_messageKey = key;
//	}
//	
//	/**
//	 * メッセージキーを取得する。
//	 * @return メッセージキー
//	 */
//	public String getMessageKey()
//	{
//		return _messageKey;
//	}
//	/**
//	 * 主原因の例外を取得する。
//	 * @return 主原因の例外
//	 */
//	public Throwable getRootCause()
//	{
//		return _rootCause;
//	}
//	/**
//	 * 主原因の例外を設定する。
//	 * @param 主原因の例外
//	 */
//	public void setRootCause(Throwable rootCause)
//	{
//		_rootCause = rootCause;
//	}
//	
//	
//	/**
//	 * スタックトレースを標準エラー出力に出力する。
//	 */
//	public void printStackTrace()
//	{
//		printStackTrace(System.err);
//	}
//	
//	/**
//	 * スタックトレースをoutStreamに出力する。
//	 * @param outStream
//	 */
//	public void printStackTrace(PrintStream outStream)
//	{
//		printStackTrace(new PrintWriter(outStream));
//	}
//	
//	
//	/**
//	 * スタックトレースをwriterに出力する。
//	 * @param writer
//	 */
//	public void printStackTrace(PrintWriter writer)
//	{
//		super.printStackTrace(writer);
//		if(getRootCause() != null)
//		{
//			getRootCause().printStackTrace(writer);
//		}
//		writer.flush();
//	}
	
}