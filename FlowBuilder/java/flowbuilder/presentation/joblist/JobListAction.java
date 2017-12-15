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
 * 案件一覧表示画面処理を行なう。 <BR>
 */
public class JobListAction extends DispatchAction {
	/** 遷移目標画面 */
	private final String FORWARD_SUCCESS = "success";

	/** 遷移ログアウト目標画面 */
	private final String FORWARD_LOGOUT = "logout";
	
	ConfigReader conf = FlowBuilderSystemConfig.getInstance();
	private final int recordPerPage = Integer.parseInt(conf.getValue("recordPerPage"));

	/**
	 * 案件一覧処理の実行
	 * 
	 * @param mapping：ActionMappingオブジェクト
	 * @param form：ActionFormオブジェクト
	 * @param request：HttpServletRequestオブジェクト
	 * @param response：HttpServletResponseオブジェクト
	 * @return ActionForward：ActionForwardオブジェクト
	 * @exception java.lang.Exception：一般的な例外発生時にthrowする
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
			
			//組織を選ぶ画面から案件一覧
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

			// コントロールオブジェクト
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

		// コントロールオブジェクト
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
	
		// コントロールオブジェクト
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
	
		// コントロールオブジェクト
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
	
		// コントロールオブジェクト
		request.setAttribute("sessionNo", CodeCreator.getSessionNo());
	    target = FORWARD_SUCCESS;
	    return mapping.findForward(target);
	}

	/**
	 * Sturts Menuのメニュー表示権限判定 オブジェクトをHTTPセッションに設定する。
	 * 
	 * @param session
	 *            HTTPセッション
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