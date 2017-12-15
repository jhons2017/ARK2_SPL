package flowbuilder.presentation.webcmn;

import javax.servlet.ServletContext;

import fbcom.framework.exceptions.BaseException;

/**
 * Webアプリケーションの共通情報をServletContextに登録する
 */
public final class ApplicationBeansCreator
{
	/** コンストラクタ */
	public ApplicationBeansCreator()
	{
	}

	/**
	 * コンストラクタ
	 * 
	 * @param context ServletContext
	 * @throws BaseException システム例外用の共通のスーパークラス。
	 */
	public ApplicationBeansCreator(
			ServletContext context) throws Exception
	{
		synchronized (context)
		{
		}
	}

	/**
	 * ユーザー情報Beansを生成する
	 * 
	 * @param context ServletContext
	 * @throws BaseException 共通例外
	 */
	public final void makeConnXmlBean(ServletContext context) throws BaseException
	{
		
		synchronized (context)
		{
			//connXmlBean xmlBean = new connXmlBean(quality);
			//context.setAttribute(AttributeKeys.CONTEXT_CONNXMLBEAN, xmlBean);
		}
	}

	/**
	 * ユーザー情報Beansを生成する
	 * 
	 * @param context ServletContext
	 * @throws BaseException 共通例外
	 */
	public final void makeFileXmlBean(ServletContext context) throws BaseException
	{
		
		synchronized (context)
		{
//			dddd bean = new xmlFileOperate(quality);
//
//			System.out.println("fileXmlBean");
//			context.setAttribute(AttributeKeys.CONTEXT_FILEXMLBEAN, bean);
		}
	}

	/**
	 * ユーザー情報Beansを生成する
	 * 
	 * @param context ServletContext
	 * @throws BaseException 共通例外
	 */
	public final void makeUserXmlBean(ServletContext context) throws BaseException
	{
		
		synchronized (context)
		{
//			userXmlBean xmlBean = new userXmlBean(quality);
//			context.setAttribute(AttributeKeys.CONTEXT_USERXMLBEAN, xmlBean);
		}
	}

	/**
	 * ユーザー情報Beansを生成する
	 * 
	 * @param context ServletContext
	 * @throws BaseException 共通例外
	 */
	public final void makeJobListXmlBean(ServletContext context) throws BaseException
	{
		
		synchronized (context)
		{
//			dsgggggg xmlBean = new joblistXmlBean(quality);
//			context.setAttribute(AttributeKeys.CONTEXT_USERXMLBEAN, xmlBean);
		}
	}

	/**
	 * ユーザー情報Beansを生成する
	 * 
	 * @param context ServletContext
	 * @throws BaseException 共通例外
	 */
	public final void makeOprXmlBean(ServletContext context) throws BaseException
	{
		
		synchronized (context)
		{
//			sdfsdf xmlBean = new oprXmlOperate(quality);
//			context.setAttribute(AttributeKeys.CONTEXT_OPRXMLBEAN, xmlBean);
		}
	}

	/**
	 * ユーザー情報Beansを生成する
	 * 
	 * @param context ServletContext
	 * @throws BaseException 共通例外
	 */
	public final void makeJobXmlBean(ServletContext context) throws BaseException
	{
		
		synchronized (context)
		{
//			sdfsdf xmlBean = new jobXmlBean(quality);
//			context.setAttribute(AttributeKeys.CONTEXT_JOBXMLBEAN, xmlBean);
		}
	}
}