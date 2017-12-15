package flowbuilder.presentation.jobshow;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import flowbuilder.application.jobshow.JobShowService;
import flowbuilder.application.jobshow.JobShowServiceFactory;
import flowbuilder.application.util.CodeCreator;
import flowbuilder.domain.joblist.JobList;
import flowbuilder.domain.jobshow.JobShow;
import flowbuilder.presentation.webcmn.AuthorityChecker;
import flowbuilder.presentation.webcmn.UserInfo;


/**
 * 案件表示画面処理を行うコントローラ。 <BR>
 */
public class JobMakeAction extends DispatchAction
{
	/** 遷移目標画面 */
	private final String FORWARD_SUCCESS = "success";

	/** 遷移ログアウト目標画面 */
	private final String FORWARD_LOGOUT = "logout";

	/**
	 * 「案件表示」で初期表示処理の実行
	 * 
	 * @param mapping：ActionMappingオブジェクト
	 * @param form：ActionFormオブジェクト
	 * @param request：HttpServletRequestオブジェクト
	 * @param response：HttpServletResponseオブジェクト
	 * @return ActionForward：ActionForwardオブジェクト
	 * @exception java.lang.Exception：一般的な例外発生時にthrowする
	 */
	public ActionForward open(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionForward actionForward = new ActionForward();
		JobMakeForm makeForm = (JobMakeForm) form;

		JobList joblist = null;
		JobShow jobshow = new JobShow();

		String target = null;

		JobShowService jobService = JobShowServiceFactory.getOrgListServiceInstance();

		if (AuthorityChecker.isSessionValid(request)) {
			UserInfo userInfo = (UserInfo) request.getSession().getAttribute(UserInfo.USER_KEY);
			joblist = new JobList();

			// ジョブID
			joblist.setJobId(makeForm.getJobId());
			// テンプレートID
			joblist.setTemplateId(makeForm.getTemplateId());
			// 新しい案件の操作
			jobshow = jobService.getJobShow(joblist);

			// コントロールオブジェクトを取得する
			request.setAttribute("sessionNo", CodeCreator.getSessionNo());
			request.setAttribute("JobShow", jobshow);
			target = FORWARD_SUCCESS;

			// パースの設定
			actionForward.setPath("/WEB-INF/jsp/flowbuilder/" + jobshow.getView());
			actionForward.setName(target);
		} else {
			target = FORWARD_LOGOUT;
			actionForward = mapping.findForward(target);
		}

		return actionForward;
	}

	/**
	 * 「案件表示」で初期表示処理の実行
	 * 
	 * @param mapping：ActionMappingオブジェクト
	 * @param form：ActionFormオブジェクト
	 * @param request：HttpServletRequestオブジェクト
	 * @param response：HttpServletResponseオブジェクト
	 * @return ActionForward：ActionForwardオブジェクト
	 * @exception java.lang.Exception：一般的な例外発生時にthrowする
	 */
	public ActionForward create(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ActionForward actionForward = new ActionForward();
		JobMakeForm makeForm = (JobMakeForm) form;

		JobList joblist = null;
		JobShow jobshow = new JobShow();

		String target = null;

		JobShowService jobService = JobShowServiceFactory.getOrgListServiceInstance();

		if (AuthorityChecker.isSessionValid(request)) {
			UserInfo userInfo = (UserInfo) request.getSession().getAttribute(UserInfo.USER_KEY);
			joblist = new JobList();

			// ユーザのIP
			String remoteAddr = request.getRemoteAddr();

			// ジョブID
			// joblist.setJobId(CodeCreator.getJobNo());
			// 起案者組織ID
			joblist.setOrgId(userInfo.getOrgId());
			// 起案者ルールID
			joblist.setRoleId(userInfo.getUserRole().toString());
			// テンプレートID
			joblist.setTemplateId(makeForm.getTemplateId());
			// ユーザID
			joblist.setUserId(userInfo.getUserId());
			// 新しい案件の操作
			jobshow = jobService.getNewJobShow(joblist, remoteAddr);

			// コントロールオブジェクトを取得する
			request.setAttribute("sessionNo", CodeCreator.getSessionNo());
			request.setAttribute("JobShow", jobshow);
			target = FORWARD_SUCCESS;

			// パースの設定
			actionForward.setPath("/WEB-INF/jsp/flowbuilder/" + jobshow.getView());
			actionForward.setName(target);
		} else {
			target = FORWARD_LOGOUT;
			actionForward = mapping.findForward(target);
		}

		return actionForward;
	}

	/**
	 * 「エラー」のアクション。(dispatch=errorのとき実行される。) JavaScriptがOnになっていない場合に呼ばれる。
	 * 
	 * @param mapping：ActionMappingオブジェクト
	 * @param form：ActionFormオブジェクト
	 * @param request：HttpServletRequestオブジェクト
	 * @param response：HttpServletResponseオブジェクト
	 * @return ActionForward：ActionForwardオブジェクト
	 * @exception java.lang.Exception：一般的な例外発生時にthrowする
	 */
	public ActionForward error(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		throw new fbcom.framework.exceptions.AppException("JavaScriptの設定を有効にして下さい。");
	}
}