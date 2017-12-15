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
package flowbuilder.application.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.safehaus.uuid.UUID;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import flowbuilder.daoimpl.db.DBXmlFileConn;
import flowbuilder.daoimpl.db.XmlFileProperity;
import flowbuilder.daoimpl.db.XmlOperator;


/**
 * ユーザーのアクセスオブジェクト
 */
public final class CodeCreator {
	/**
	 * ロギング
	 */
	private static Log _log = LogFactory.getLog(CodeCreator.class);
	
	
	/**
	 * ファイルのパース
	 */
	private static String jobCtrlXmlPath = "";
	
	/**
	 * DOMのドキュメント
	 */
	private static Document filedoc = null;
	
	static{
		XmlFileProperity fileconn = new XmlFileProperity("Path.Xml.File");
		jobCtrlXmlPath = fileconn.getFileDir("manage","job_control.xml");
	}
	
	/**
	 *  最新のジョブファイル番号を取得する <br>
	 *  
	 * @return 最新のジョブファイル番号
	 */
	public static String getJobNo(){

		String strExc="";
		try
		{
			
			//ドキュメントの取得
			filedoc = DBXmlFileConn.getDocument(jobCtrlXmlPath);

			//品質保証
			_log.info( "開始" );

			if ( filedoc != null )
			{
				//Documentsエレメントを取得する
				Element jobnoElement = XmlOperator.getElement( XmlOperator.getNodeList( filedoc, "jobno" ), 0 );

				if ( jobnoElement != null )
				{
					String strNewNum1 = "00000" + XmlOperator.getAttrValue( jobnoElement, "num" );

					strExc = strNewNum1.substring( strNewNum1.length() - 5, strNewNum1.length() );

					//対応属性値を取得する
					int intNum=Integer.parseInt( XmlOperator.getAttrValue( jobnoElement, "num" ) );

					//レコード数にプラス１をする
					intNum += 1;

					strNewNum1 = "00000" + String.valueOf(intNum);

					String strNewNum2 = strNewNum1.substring( strNewNum1.length() - 5, strNewNum1.length() );

					//品質保証
					_log.info( "作成された新しいＩＤ番号：" + strNewNum2 );

					//新しいドキュメント数を設定する
					if( XmlOperator.setAttrValue( jobnoElement, "num", strNewNum2 ) )
					{
						//XMLファイルを保存する
						DBXmlFileConn.writeXml( filedoc, jobCtrlXmlPath );
					}
					else
					{

						//品質保証
						_log.info("num 属性設定に失敗しました。");
					}
				}
				else
				{

					//品質保証
					_log.info("jobno エレメントの取得に失敗しました。");
				}
			}
			else
			{
	
				//品質保証
				_log.info("案件ＩＤ管理ＸＭＬドキュメントの取得に失敗しました。");
			}

			//品質保証
			_log.info( "終了" );
		}
		catch(Exception e)
		{

			//品質保証
			_log.fatal( "致命的なエラー" );
			
			strExc = e.toString();
		}
		String jobId = new UUID().asByteArray().toString();
		jobId = jobId.replace("[","$");
		return jobId;
	}
	
	/**
	 *  最新のセッション番号を取得する <br>
	 *  
	 * @return 最新のセッション番号
	 */
	public static String getSessionNo(){

		String strExc="";
		try
		{

			//ドキュメントの取得
			filedoc = DBXmlFileConn.getDocument(jobCtrlXmlPath);
			//品質保証
			_log.info( "開始" );

			if ( filedoc != null )
			{
				//Documentsエレメントを取得する
				Element jobnoElement = XmlOperator.getElement( XmlOperator.getNodeList( filedoc, "sessionno" ), 0 );

				if ( jobnoElement != null )
				{
					String strNewNum1 = "00000" + XmlOperator.getAttrValue( jobnoElement, "num" );

					strExc = strNewNum1.substring( strNewNum1.length() - 5, strNewNum1.length() );

					//対応属性値を取得する
					int intNum=Integer.parseInt( XmlOperator.getAttrValue( jobnoElement, "num" ) );

					//レコード数にプラス１をする
					intNum += 1;

					strNewNum1 = "00000" + String.valueOf(intNum);

					String strNewNum2 = strNewNum1.substring( strNewNum1.length() - 5, strNewNum1.length() );

					//新しいドキュメント数を設定する
					if ( strNewNum2.equals("99999") )
					{
						
						if( XmlOperator.setAttrValue( jobnoElement, "num", "00000" ) )
						{

							//XMLファイルを保存する
							DBXmlFileConn.writeXml( filedoc, jobCtrlXmlPath );
						}
						else
						{

							//品質保証
							_log.info("num 属性設定に失敗しました。");
						}
					}
					else
					{
						
						if( XmlOperator.setAttrValue( jobnoElement, "num", strNewNum2 ) )
						{
							//XMLファイルを保存する
							DBXmlFileConn.writeXml( filedoc, jobCtrlXmlPath );
						}
						else
						{
							//品質保証
							_log.info("num 属性設定に失敗しました。");
						}
					}
				}
				else
				{
					//品質保証
					_log.info("sessionno エレメントの取得に失敗しました。");
				}
			}
			else
			{
				//品質保証
				_log.info("案件ＩＤ管理ＸＭＬドキュメントの取得に失敗しました。");
			}

			//品質保証
			_log.info( "終了" );
		}
		catch(Exception e)
		{

			//品質保証
			_log.fatal( "致命的なエラー" );
			
			strExc = e.toString();
		}

		return(strExc);
	}

}
