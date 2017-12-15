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
 * 案件組織の選択一覧画面処理を行うコントローラ。 <BR>
 */
public class OrgSelectAction extends Action
{
	/** 遷移目標画面 */
	private static final String FORWARD_SUCCESS = "success";

	/** 遷移ログアウト目標画面 */
	private final String FORWARD_LOGOUT = "logout";

	/**
	 * 組織選択画面処理の実行
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