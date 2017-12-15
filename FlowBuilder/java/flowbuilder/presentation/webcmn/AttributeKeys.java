package flowbuilder.presentation.webcmn;

/**
 * このインターフェースは、ServletContext, Session, ServletRequestへオブジェクトを格納するときのキーを定義する。
 * 
 * ServletContextへオブジェクトを格納するときのキーの定数名は CONTEXT_ で始まるものとする。
 * Sessionへオブジェクトを格納するときのキーの定数名は SESSION_ で始まるものとする。
 * ServletRequestへオブジェクトを格納するときのキーの定数名は REQUEST_ で始まるものとする。
 */
public interface AttributeKeys
{
	/**
	 * ユーザー情報beanのID
	 */
	public static final String CONTEXT_CONNXMLBEAN = "connXmlBean";
	/**
	 * ユーザー情報beanのID
	 */
	public static final String CONTEXT_FILEXMLBEAN = "fileXmlBean";
	/**
	 * ユーザー情報beanのID
	 */
	public static final String CONTEXT_USERXMLBEAN = "userXmlBean";

	/**
	 * jobListXml情報beanのID
	 */
	public static final String CONTEXT_JOBLISTXMLBEAN = "jobListXmlBean";

	/**
	 * ユーザー情報beanのID
	 */
	public static final String CONTEXT_OPRXMLBEAN = "oprXmlBean";

	/**
	 * ユーザー情報beanのID
	 */
	public static final String CONTEXT_JOBXMLBEAN = "jobXmlBean";
}