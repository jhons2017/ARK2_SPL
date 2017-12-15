package flowbuilder.presentation.orglist;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import flowbuilder.application.orglist.OrgListService;
import flowbuilder.application.orglist.OrgListServiceFactory;
import flowbuilder.presentation.webcmn.AuthorityChecker;
import flowbuilder.presentation.webcmn.UserInfo;


/**
 * �Č��g�D�̑I���ꗗ��ʏ������s���R���g���[���B <BR>
 */
public class OrgSelectAction extends Action
{
	/** �J�ږڕW��� */
	private static final String FORWARD_SUCCESS = "success";

	/** �J�ڃ��O�A�E�g�ڕW��� */
	private final String FORWARD_LOGOUT = "logout";

	/**
	 * �g�D�I����ʏ����̎��s
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
			HttpServletResponse response) throws Exception
	{
		String target = null;		
		OrgListService orglist = OrgListServiceFactory.getOrgListServiceInstance();
		
		if (AuthorityChecker.isSessionValid(request))
		{
			UserInfo userInfo = (UserInfo) request.getSession().getAttribute(UserInfo.USER_KEY);
			request.setAttribute("orgSummaryList", orglist.getOrgList(userInfo.getUserId()));
			HttpSession session = request.getSession();
			session.setAttribute("sessionMap", null);
			target = FORWARD_SUCCESS;
		}
		else
		{
			target = FORWARD_LOGOUT;
		}
	
		return mapping.findForward(target);
	}
}