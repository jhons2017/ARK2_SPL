package flowbuilder.daoimpl.naming;

/* =================================================================
 * NO.83XXXXXX
 * ITEM = 001 ; REV = 00 ; DATE 2005/11/03
 *
 * (c) 2005 Yamatake Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2005/11/03 BY. T.Okuyama (BSC)
 *=================================================================
 */


import javax.naming.spi.InitialContextFactory;
import javax.naming.Context;
import java.util.Hashtable;

/**
 * InitialContextFactoryの簡易実装。
 * <<動機>>
 * DBアクセスクラスをTomcatが実行されているJavaVM以外で使用するために、
 * データソースをJNDIに登録したい。
 * そこで、簡易的な実装を作成した。これを用いることで、JNDIからデータソースを
 * 取得するDBアクセスクラスをそのまま利用できる。
 */
public class SimpleContextFactory implements InitialContextFactory
{
	private static SimpleContext INSTANCE = new SimpleContext();

	/**
	 * Method getInitialContext Returns the SimpleContext for use.
	 * 
	 * @param environment
	 * @return Context
	 */
	public Context getInitialContext(Hashtable environment)
	{
		return INSTANCE;
	}
}