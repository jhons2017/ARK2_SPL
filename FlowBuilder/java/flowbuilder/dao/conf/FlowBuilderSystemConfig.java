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
package flowbuilder.dao.conf;

import fbcom.framework.dao.conf.ConfigReader;
import fbcom.framework.dao.conf.PropertyConfigReader;

/**
 * システム設定ファイルの読み込みを行なう。
 * Singletonパターンで実装する。
 */
public final class FlowBuilderSystemConfig extends PropertyConfigReader
{
	/**
	 * 設定ファイル（プロパティーファイル形式)へのパス。
	 * パスは、クラスパスをルートとして、ルートからの絶対パス。
	 */
	private static final String RESOURCE_FILE = "/conf/fbuilder/SystemConfig.properties";
	
	/**
	 * インスタンス
	 */
	private static final ConfigReader INSTANCE = new FlowBuilderSystemConfig();
	
	/**
	 * インスタンスを取得する。
	 * @return ConfigReaderのインスタンス
	 */
	public static ConfigReader getInstance()
	{
		return INSTANCE;
	}

	/**
	 * privateのコンストラクタ。
	 * インスタンスは、getInstance()によって取得してもらう。
	 */
	private FlowBuilderSystemConfig()
	{
		super();
	}

	/**
	 * 設定ファイル（プロパティーファイル形式)へのパスを取得する。
	 * パスは、クラスパスをルートとして、ルートからの絶対パス。
	 * @return 設定ファイルのパス
	 */
	public String getResourceFile()
	{
		return RESOURCE_FILE;
	}
}
