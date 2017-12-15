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
	
	/** �J�ږڕW��� */
	private final String FORWARD_SUCCESS = "success";

	/** �J�ڃ��O�A�E�g�ڕW��� */
	private final String FORWARD_LOGOUT = "logout";
	
	/**
	 * �Č������̎��s
	 * 
	 * @param mapping�FActionMapping�I�u�W�F�N�g
	 * @param form�FActionForm�I�u�W�F�N�g
	 * @param request�FHttpServletRequest�I�u�W�F�N�g
	 * @param response�FHttpServletResponse�I�u�W�F�N�g
	 * @return ActionForward�FActionForward�I�u�W�F�N�g
	 * @exception java.lang.Exception�F��ʓI�ȗ�O��������throw����
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
			
			//�@�Ɩ��̑���,�N���C�A���g��excel�t�@�C�����o�͂���
			printctrl.jobPrint(printForm.getjobId(), response);

			target = FORWARD_SUCCESS;
		} else {
			target = FORWARD_LOGOUT;
		}

		return mapping.findForward(target);
	}
}