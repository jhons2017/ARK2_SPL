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
package fbcom.framework.struts;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;

import fbcom.framework.exceptions.AppException;
import fbcom.framework.exceptions.BaseException;

/**
 * Strutsの宣言による例外処理で使用する例外ハンドラ。
 * fbcom.framework.exceptions.BaseExceptionをハンドリングし、
 * メッセージキーから、ActionErrorを作成する。
 * また、BaseException以外の例外は、ロギングを行なう。
 *
 * ただし、複数例外はサポートしていない。必要になったら実装する。
 *
 * Struts1.2からActionErrorより、ActionMessageを使用すべきとなっている。
 * 本実装では、Struts1.1をベースにActionErrorを使用している。
 */
public class BscExceptionHandler extends ExceptionHandler
{

	/**
	 * ログ
	 */
	private static final Log _log = LogFactory.getLog(BscExceptionHandler.class);

	/**
	 * <p>
	 * Handle the <code>Exception</code>. Return the
	 * <code>ActionForward</code> instance (if any) returned by the called
	 * <code>ExceptionHandler</code>.
	 * 
	 * @param ex
	 *            The exception to handle
	 * @param ae
	 *            The ExceptionConfig corresponding to the exception
	 * @param mapping
	 *            The ActionMapping we are processing
	 * @param formInstance
	 *            The ActionForm we are processing
	 * @param request
	 *            The servlet request we are processing
	 * @param response
	 *            The servlet response we are creating
	 * @return ActionForward
	 * 
	 * @exception ServletException
	 *                if a servlet exception occurs
	 * 
	 * @since Struts 1.1
	 */
	public ActionForward execute(Exception ex, ExceptionConfig ae,
			ActionMapping mapping, ActionForm formInstance,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException
	{

		ActionForward forward = null;
//for Struts1.2.4		ActionMessage error = null;
		ActionError error = null;
		String property = null;

		// 存在すれば<exception>要素から転送先を取得する。
		// 存在しなければ、input属性から転送先を取得する。
		if(ae.getPath() != null)
		{
			forward = new ActionForward(ae.getPath());
		}
		else
		{
			forward = mapping.getInputForward();
		}

		if(ex instanceof BaseException)
		{
			BaseException baseException = (BaseException)ex;
			String messageKey = baseException.getMessage();
			Object[] exArgs = baseException.getMessageArgs();
			if(exArgs != null && exArgs.length > 0)
			{
//for Struts1.2.4				error = new ActionMessage(messageKey, exArgs);
				error = new ActionError(messageKey, exArgs);
			}
			else
			{
//for Struts1.2.4				error = new ActionMessage(messageKey);
				error = new ActionError(messageKey);
			}
		}
		else
		{
//for Struts1.2.4			error = new ActionMessage(ae.getKey(), ex.getMessage());
			String exArg = ex.getMessage();
			if(exArg == null)
			{
				exArg = ex.toString();
			}
			error = new ActionError(ae.getKey(), exArg);
			_log.error(ex.getMessage(), ex);
		}
		property = error.getKey();
		
		if(!(ex instanceof AppException))
		{
			storeDateTime(request);
		}
		
		// Store the exception
		request.setAttribute(Globals.EXCEPTION_KEY, ex);
		storeException(request, property, error, forward, ae.getScope());

		return forward;

	}

	/**
	 * 例外発生時刻を記録する。
	 * @param request
	 */
	private void storeDateTime(HttpServletRequest request)
	{
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		request.setAttribute("dateTime", sf.format(date));
	}
	
//for Struts1.2.4 --->
    /**
     * <p>Default implementation for handling an <code>ActionError</code> generated
     * from an <code>Exception</code> during <code>Action</code> delegation. The default
     * implementation is to set an attribute of the request or session, as
     * defined by the scope provided (the scope from the exception mapping). An
     * <code>ActionErrors</code> instance is created, the error is added to the collection
     * and the collection is set under the <code>Globals.ERROR_KEY</code>.</p>
     *
     * @param request The request we are handling
     * @param property The property name to use for this error
     * @param error The error generated from the exception mapping
     * @param forward The forward generated from the input path (from the form or exception mapping)
     * @param scope The scope of the exception mapping.
     * @deprecated Use storeException(HttpServletRequest, String, ActionMessage, ActionForward, String)
     * instead. This will be removed after Struts 1.2.
     */
//    protected void storeException(
//        HttpServletRequest request,
//        String property,
//        ActionError error,
//        ActionForward forward,
//        String scope) {
//
//        this.storeException(request, property, (ActionMessage) error, forward, scope);
//        // :TODO: Remove after Struts 1.2
//
//    }


    /**
     * <p>Default implementation for handling an <code>ActionMessage</code> generated
     * from an <code>Exception</code> during <code>Action</code> delegation. The default
     * implementation is to set an attribute of the request or session, as
     * defined by the scope provided (the scope from the exception mapping). An
     * <code>ActionMessages</code> instance is created, the error is added to the
     * collection and the collection is set under the <code>Globals.ERROR_KEY</code>.</p>
     *
     * @param request The request we are handling
     * @param property The property name to use for this error
     * @param error The error generated from the exception mapping
     * @param forward The forward generated from the input path (from the form or exception mapping)
     * @param scope The scope of the exception mapping.
     * @since Struts 1.2
     */
//    protected void storeException(
//        HttpServletRequest request,
//        String property,
//        ActionMessage error,
//        ActionForward forward,
//        String scope) {
//
//        ActionMessages errors = new ActionMessages();
//        errors.add(property, error);
//
//        if ("request".equals(scope)) {
//            request.setAttribute(Globals.ERROR_KEY, errors);
//        } else {
//            request.getSession().setAttribute(Globals.ERROR_KEY, errors);
//        }
//    }
//<--- for Struts1.2.4
}