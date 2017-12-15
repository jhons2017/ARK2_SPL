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

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * プロパティーファイル形式の設定ファイルの読み込みを行なう。
 * このクラスを継承する場合、Singletonパターンで実装を行うこと。
 */
public abstract class PropertyConfigReader implements ConfigReader
{
	/**
	 * 設定を保持するクラス
	 */
	private Properties _properties = new Properties();

	/**
	 * ログ
	 */
	private static Log _log = LogFactory.getLog(PropertyConfigReader.class);

	/** 
	 * コンストラクタ
	 */
	public PropertyConfigReader()
	{
		try
		{
			_properties.load(loadFromClass());
		}
		catch(IOException e)
		{
			_log.fatal(e.getMessage(), e);
		}
	}
	
	/**
	 * keyに対する値を取得する。
	 * keyが存在しない場合は、nullを返す。
	 * @param key キー
	 * @return keyに対する値
	 */
	public String getValue(String key)
	{
		String result =_properties.getProperty(key);
		if(result == null)
		{
			_log.error("KEY[" + key + "] is not found in " + getResourceFile());
		}
		return result;
	}
	
	/**
	 * リソースファイルを読み込む。
	 * @return InputStream
	 */
	private InputStream loadFromClass()
	{
		return getClass().getResourceAsStream(getResourceFile());
	}

	/**
	 * 設定ファイル（プロパティーファイル形式)へのパスを取得する。
	 * パスは、クラスパスをルートとして、ルートからの絶対パス。
	 * @return 設定ファイルのパス
	 */
	public abstract String getResourceFile();
}
