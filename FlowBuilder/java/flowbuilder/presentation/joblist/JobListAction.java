package flowbuilder.presentation.joblist;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import flowbuilder.application.user.UserService;
import flowbuilder.application.user.UserServiceFactory;
import flowbuilder.application.util.CodeCreator;
import flowbuilder.dao.conf.FlowBuilderSystemConfig;
import flowbuilder.domain.user.UserRole;
import flowbuilder.presentation.navigator.menu.BuilRolesPermissionsAdapter;
import flowbuilder.presentation.webcmn.AuthorityChecker;
import flowbuilder.presentation.webcmn.UserInfo;
import flowbuilder.presentation.webcmn.taglibs.domain.page.PageInfo;
import flowbuilder.view.user.UserDTO;

import fbcom.framework.dao.conf.ConfigReader;

/**
 * �Č��ꗗ�\����ʏ������s�Ȃ��B <BR>
 */
public class JobListAction extends DispatchAction {
	/** �J�ږڕW��� */
	private final String FORWARD_SUCCESS = "success";

	/** �J�ڃ��O�A�E�g�ڕW��� */
	private final String FORWARD_LOGOUT = "logout";
	
	ConfigReader conf = FlowBuilderSystemConfig.getInstance();
	private final int recordPerPage = Integer.parseInt(conf.getValue("recordPerPage"));

	/**
	 * �Č��ꗗ�����̎��s
	 * 
	 * @param mapping�FActionMapping�I�u�W�F�N�g
	 * @param form�FActionForm�I�u�W�F�N�g
	 * @param request�FHttpServletRequest�I�u�W�F�N�g
	 * @param response�FHttpServletResponse�I�u�W�F�N�g
	 * @return ActionForward�FActionForward�I�u�W�F�N�g
	 * @exception java.lang.Exception�F��ʓI�ȗ�O��������throw����
	 */
	public ActionForward jobDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String target = null;
		if (AuthorityChecker.isSessionValid(request))
		{

			UserInfo userInfo = null;
			UserDTO userDTO = null;
			HttpSession session = request.getSession();
			JobListForm listForm = (JobListForm) form;
			
			//�g�D��I�ԉ�ʂ���Č��ꗗ
			if(!"".equals(listForm.getOrgId()) && !"".equals(listForm.getRoleId())){
				this.saveToken(request);
				userInfo = (UserInfo) session.getAttribute(UserInfo.USER_KEY);
			
				UserService userService = UserServiceFactory.getUserServiceInstance();
				userDTO = userService.getUserInfo(userInfo.getUserId(),listForm.getOrgId(),listForm.getRoleId());
				
				userInfo.setOrgId(listForm.getOrgId());
				userInfo.setUserRole(UserRole.getInstance(listForm.getRoleId()));
				session.setAttribute("sessionMap", userDTO);

			}else{
				userInfo = (UserInfo) session.getAttribute(UserInfo.USER_KEY);
				userDTO = (UserDTO)session.getAttribute("sessionMap");
			}
			//***
			PageInfo pInfo = (PageInfo)session.getAttribute("pageinfo");
			
			if(pInfo == null) {
				pInfo = new PageInfo();
				pInfo.setRecordPerPage(recordPerPage);
			}

			pInfo.setCurrentPage(1);
			session.setAttribute("pageinfo", pInfo);
			pInfo.setMethod("jobDetail");
			//****
			session.setAttribute(UserInfo.USER_KEY, userInfo);

			makeMenuPermission(session);

			// �R���g���[���I�u�W�F�N�g
			request.setAttribute("sessionNo", CodeCreator.getSessionNo());

			target = FORWARD_SUCCESS;
		}
		else
		{
			target = FORWARD_LOGOUT;
		}
		return mapping.findForward(target);
	}

	public ActionForward showFirst(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, HttpServletResponse response) {
		String target = null;
        HttpSession session=request.getSession();
        PageInfo pInfo=(PageInfo)session.getAttribute("pageinfo"); 
        if(pInfo==null) {
	        pInfo=new PageInfo();
	        pInfo.setRecordPerPage(recordPerPage);
        }
        pInfo.setCurrentPage(1);
        pInfo.setMethod("showFirst");
        session.setAttribute("pageinfo", pInfo);
        makeMenuPermission(session);

		// �R���g���[���I�u�W�F�N�g
		request.setAttribute("sessionNo", CodeCreator.getSessionNo());
        target = FORWARD_SUCCESS;
        return mapping.findForward(target);
    }
	
	public ActionForward showPrivious(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
		String target = null;
	    HttpSession session=request.getSession();
	    PageInfo pInfo=(PageInfo)session.getAttribute("pageinfo"); 
	
	    pInfo.setCurrentPage(pInfo.getPreviousPageNumber());
	    pInfo.setMethod("showPrivious");
	    session.setAttribute("pageinfo", pInfo);
	    makeMenuPermission(session);
	
		// �R���g���[���I�u�W�F�N�g
		request.setAttribute("sessionNo", CodeCreator.getSessionNo());
	    target = FORWARD_SUCCESS;
	    return mapping.findForward(target);
	}
	
	public ActionForward showNext(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
		String target = null;
	    HttpSession session=request.getSession();
	    PageInfo pInfo=(PageInfo)session.getAttribute("pageinfo"); 
	
	    pInfo.setCurrentPage(pInfo.getNextPageNumber());
	    pInfo.setMethod("showNext");
	    session.setAttribute("pageinfo", pInfo);
	    makeMenuPermission(session);
	
		// �R���g���[���I�u�W�F�N�g
		request.setAttribute("sessionNo", CodeCreator.getSessionNo());
	    target = FORWARD_SUCCESS;
	    return mapping.findForward(target);
	}
	
	public ActionForward showLast(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
		String target = null;
	    HttpSession session=request.getSession();
	    PageInfo pInfo=(PageInfo)session.getAttribute("pageinfo"); 
	    pInfo.setMethod("showLast");
	    session.setAttribute("pageinfo", pInfo);
	    makeMenuPermission(session);
	
		// �R���g���[���I�u�W�F�N�g
		request.setAttribute("sessionNo", CodeCreator.getSessionNo());
	    target = FORWARD_SUCCESS;
	    return mapping.findForward(target);
	}

	/**
	 * Sturts Menu�̃��j���[�\���������� �I�u�W�F�N�g��HTTP�Z�b�V�����ɐݒ肷��B
	 * 
	 * @param session
	 *            HTTP�Z�b�V����
	 */
	private void makeMenuPermission(HttpSession session) {
		BuilRolesPermissionsAdapter permAdapter = new BuilRolesPermissionsAdapter(
				session);
		session
				.setAttribute(
						BuilRolesPermissionsAdapter.PERMISSIONSADAPTER_KEY,
						permAdapter);
	}
}