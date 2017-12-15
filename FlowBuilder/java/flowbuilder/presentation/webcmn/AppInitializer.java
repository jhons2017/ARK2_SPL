package flowbuilder.presentation.webcmn;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;


/**
 * Webアプリケーションが最初にロードされたときに、アプリケーションが <BR>
 * 共通に使うクラスを生成して、ServletContextにあらかじめ登録しておく。
 * 
 * Strutsのプラグインを利用してアプリケーションの初期化を行う。 <BR>
 * このクラスはstruts-config.xmlにplugin登録する必要。。
 *  
 */

public final class AppInitializer implements PlugIn
{
	/**
	 * ログ
	 */
	private static Log _log = LogFactory.getLog(AppInitializer.class);

	/**
	 * モジュールが起動する通知を受け取ります。 <BR>
	 * 共通情報がServletContextに登録する。
	 * 
	 * @param servlet このウェッブアプリケーションの全てのモジュールを処理するActionServlet
	 * @param config このプラグインに関連付けられたモジュールのModuleConfig
	 * @throws ServletException 
	 */
	public void init(ActionServlet servlet, ModuleConfig config) throws ServletException
	{
	ServletContext context = servlet.getServletConfig().getServletContext();

		try
		{
			ApplicationBeansCreator beansCreator = new ApplicationBeansCreator(context);
//			// 部品オブジェクト作成
//			qualityBean quality = new qualityBean();
//
//			beansCreator.makeConnXmlBean(context,quality);
//			beansCreator.makeFileXmlBean(context,quality);
//			beansCreator.makeUserXmlBean(context,quality);
//			beansCreator.makeJobListXmlBean(context,quality);
//			beansCreator.makeOprXmlBean(context,quality);
//			beansCreator.makeJobXmlBean(context,quality);
	}
		catch (Exception e)
		{
			_log.error(e.getMessage(), e);
			throw new ServletException(e.getMessage(), e);
		}
	}

	/**
	 * モジュールが終了する通知を受け取ります。
	 */
	public void destroy()
	{
	}
}