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
 * �Č��\����ʏ������s���R���g���[���B <BR>
 */
public class JobMakeAction extends DispatchAction
{
	/** �J�ږڕW��� */
	private final String FORWARD_SUCCESS = "success";

	/** �J�ڃ��O�A�E�g�ڕW��� */
	private final String FORWARD_LOGOUT = "logout";

	/**
	 * �u�Č��\���v�ŏ����\�������̎��s
	 * 
	 * @param mapping�FActionMapping�I�u�W�F�N�g
	 * @param form�FActionForm�I�u�W�F�N�g
	 * @param request�FHttpServletRequest�I�u�W�F�N�g
	 * @param response�FHttpServletResponse�I�u�W�F�N�g
	 * @return ActionForward�FActionForward�I�u�W�F�N�g
	 * @exception java.lang.Exception�F��ʓI�ȗ�O��������throw����
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

			// �W���uID
			joblist.setJobId(makeForm.getJobId());
			// �e���v���[�gID
			joblist.setTemplateId(makeForm.getTemplateId());
			// �V�����Č��̑���
			jobshow = jobService.getJobShow(joblist);

			// �R���g���[���I�u�W�F�N�g���擾����
			request.setAttribute("sessionNo", CodeCreator.getSessionNo());
			request.setAttribute("JobShow", jobshow);
			target = FORWARD_SUCCESS;

			// �p�[�X�̐ݒ�
			actionForward.setPath("/WEB-INF/jsp/flowbuilder/" + jobshow.getView());
			actionForward.setName(target);
		} else {
			target = FORWARD_LOGOUT;
			actionForward = mapping.findForward(target);
		}

		return actionForward;
	}

	/**
	 * �u�Č��\���v�ŏ����\�������̎��s
	 * 
	 * @param mapping�FActionMapping�I�u�W�F�N�g
	 * @param form�FActionForm�I�u�W�F�N�g
	 * @param request�FHttpServletRequest�I�u�W�F�N�g
	 * @param response�FHttpServletResponse�I�u�W�F�N�g
	 * @return ActionForward�FActionForward�I�u�W�F�N�g
	 * @exception java.lang.Exception�F��ʓI�ȗ�O��������throw����
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

			// ���[�U��IP
			String remoteAddr = request.getRemoteAddr();

			// �W���uID
			// joblist.setJobId(CodeCreator.getJobNo());
			// �N�Ďґg�DID
			joblist.setOrgId(userInfo.getOrgId());
			// �N�Ď҃��[��ID
			joblist.setRoleId(userInfo.getUserRole().toString());
			// �e���v���[�gID
			joblist.setTemplateId(makeForm.getTemplateId());
			// ���[�UID
			joblist.setUserId(userInfo.getUserId());
			// �V�����Č��̑���
			jobshow = jobService.getNewJobShow(joblist, remoteAddr);

			// �R���g���[���I�u�W�F�N�g���擾����
			request.setAttribute("sessionNo", CodeCreator.getSessionNo());
			request.setAttribute("JobShow", jobshow);
			target = FORWARD_SUCCESS;

			// �p�[�X�̐ݒ�
			actionForward.setPath("/WEB-INF/jsp/flowbuilder/" + jobshow.getView());
			actionForward.setName(target);
		} else {
			target = FORWARD_LOGOUT;
			actionForward = mapping.findForward(target);
		}

		return actionForward;
	}

	/**
	 * �u�G���[�v�̃A�N�V�����B(dispatch=error�̂Ƃ����s�����B) JavaScript��On�ɂȂ��Ă��Ȃ��ꍇ�ɌĂ΂��B
	 * 
	 * @param mapping�FActionMapping�I�u�W�F�N�g
	 * @param form�FActionForm�I�u�W�F�N�g
	 * @param request�FHttpServletRequest�I�u�W�F�N�g
	 * @param response�FHttpServletResponse�I�u�W�F�N�g
	 * @return ActionForward�FActionForward�I�u�W�F�N�g
	 * @exception java.lang.Exception�F��ʓI�ȗ�O��������throw����
	 */
	public ActionForward error(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		throw new fbcom.framework.exceptions.AppException("JavaScript�̐ݒ��L���ɂ��ĉ������B");
	}
}