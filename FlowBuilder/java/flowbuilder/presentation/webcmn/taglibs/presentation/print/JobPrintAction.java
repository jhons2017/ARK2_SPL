/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/06/01
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/01 BY. CHENBIN (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs.presentation.print;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import flowbuilder.presentation.webcmn.AuthorityChecker;
import flowbuilder.presentation.webcmn.taglibs.application.print.JobPrintService;
import flowbuilder.presentation.webcmn.taglibs.application.print.JobPrintServiceImpl;

public class JobPrintAction extends Action {
	
	/** 遷移目標画面 */
	private final String FORWARD_SUCCESS = "success";

	/** 遷移ログアウト目標画面 */
	private final String FORWARD_LOGOUT = "logout";
	
	/**
	 * 案件処理の実行
	 * 
	 * @param mapping：ActionMappingオブジェクト
	 * @param form：ActionFormオブジェクト
	 * @param request：HttpServletRequestオブジェクト
	 * @param response：HttpServletResponseオブジェクト
	 * @return ActionForward：ActionForwardオブジェクト
	 * @exception java.lang.Exception：一般的な例外発生時にthrowする
	 */
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String target = null;
		JobPrintService printctrl = null;
			
		if (AuthorityChecker.isSessionValid(request)) {
			JobPrintForm printForm = (JobPrintForm) form;
			printctrl = new JobPrintServiceImpl();
			
			//　業務の操作,クライアントにexcelファイルを出力する
			printctrl.jobPrint(printForm.getjobId(), response);

			target = FORWARD_SUCCESS;
		} else {
			target = FORWARD_LOGOUT;
		}

		return mapping.findForward(target);
	}
}