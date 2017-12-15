package flowbuilder.presentation.jobctrl;


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.safehaus.uuid.UUID;

import flowbuilder.application.jobctrl.JobControlService;
import flowbuilder.application.jobctrl.JobControlServiceFactory;
import flowbuilder.domain.jobctrl.JobControl;
import flowbuilder.domain.jobctrl.JobCtrlParameter;
import flowbuilder.presentation.webcmn.AuthorityChecker;
import flowbuilder.presentation.webcmn.UserInfo;

/**
 * �Č��\����ʏ������s�Ȃ��B <BR>
 */
public class JobControlAction extends Action
{
	/** �J�ږڕW��� */
	private final String FORWARD_SUCCESS = "success";

	/** �J�ڃ��O�A�E�g�ڕW��� */
	private final String FORWARD_LOGOUT = "logout";

	private String jobid;

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
			HttpServletResponse response) throws Exception
	{
		String target = null;
		
		JobControlService jobctrl = JobControlServiceFactory.getControlServiceInstance();
		
		if (AuthorityChecker.isSessionValid(request))
		{
			JobDetailForm detailForm = (JobDetailForm) form;
			
			FormFile[] files = detailForm.getFiles();

			JobCtrlParameter jobCtrlPar = new JobCtrlParameter();
			UserInfo userInfo = (UserInfo) request.getSession().getAttribute(UserInfo.USER_KEY);
			
			// �W���u���O���擾����
			jobCtrlPar.setJobName(getJobName(request));
			// �W���uID��ݒ肷��
			jobCtrlPar.setJobId(detailForm.getJobId());
			// ����t���O��ݒ肷��
			jobCtrlPar.setOprFlg(detailForm.getAct());
			// ���[�UID��ݒ肷��
			jobCtrlPar.setUserId(detailForm.getUserId());
			// ���[�U�g�D��ݒ肷��
			jobCtrlPar.setOrgId(detailForm.getOrgId());
			// ����q��ݒ肷��
			jobCtrlPar.setOprId(detailForm.getOperator());
			// �e���v���[�gID��ݒ肷��
			jobCtrlPar.setTempId(detailForm.getTemplateId());
			// ���[�UIP��ݒ肷��
			jobCtrlPar.setUserIp(request.getRemoteAddr());
			// ��ʂ��烊�N�G�X�g�̒l��ݒ肷��
			jobCtrlPar.setParameters(getParameters(request, files));
			// ���[��ID
			jobCtrlPar.setRoleId(userInfo.getUserRole().toString());
			// �A�b�v���[�h
			jobCtrlPar.setFiles(files);
			// �Ɩ��̑���
			jobctrl.jobControl(jobCtrlPar);

			target = FORWARD_SUCCESS;
		}
		else
		{
			target = FORWARD_LOGOUT;
		}

		return mapping.findForward(target);
	}
	
	/**
	 * ��ʂ��烊�N�G�X�g�̒l���擾����
	 * 
	 * @param request�@���N�G�X�g
	 * @return�@�p�����[�^���X�g
	 */
	private List<JobControl> getParameters(HttpServletRequest request,FormFile[] files){
		//�߂�̒l
		List<JobControl> list = null;
		
		//�p�����[�^BEAN
		JobControl jobCtrl = null;
		
		try{
			list =  new ArrayList<JobControl>();
			//�h�L�������g�̃G�������g�����擾
			Enumeration enmNam = request.getParameterNames();
			
			//���N�G�X�g���𐔂���
			while(enmNam.hasMoreElements())
			{
				jobCtrl = new JobControl();
				
				//�G�������g�����擾����
				String strNam=(String)(enmNam.nextElement());
				String strValue = (String)(request.getParameter(strNam).trim());
				
				//�p�����[�^����ݒ肷��
				jobCtrl.setParamName(strNam);
				//�p�����[�^�l��ݒ肷��
				jobCtrl.setParamValue(stringBrowse(strValue));
				
				//�߂�̃��X�g�֒ǉ�����
				list.add(jobCtrl);
			}
			
			// �A�b�v���[�h����t�@�C���̖��O���擾����
			int filesLength = files.length;
			
			for (int i = 0; i < filesLength; i++) {
				if(files[i] == null || "".equals(files[i].getFileName())) {
					continue;
				} else {
					String fileName = files[i].getFileName();
					String postfix = postfix(fileName);
					
					jobCtrl = new JobControl();
					
					jobCtrl.setParamName(new UUID().asByteArray().toString() + postfix);
					jobCtrl.setParamValue(fileName);

					list.add(jobCtrl);
				}
			}
			
		}catch(Exception e){
			
		}
		
		return list;

	}
	
	/**
	 * �W���u���O���擾����B
	 * 
	 * @param request
	 * @return
	 */
	private String getJobName(HttpServletRequest request) {
		String jobName = "";
		
		//�h�L�������g�̃G�������g�����擾
		Enumeration enmNam = request.getParameterNames();
		
		boolean isJobName = true;
		
		//���N�G�X�g���𐔂���
		while(isJobName && enmNam.hasMoreElements())
		{
			//�G�������g�����擾����
			String strNam=(String)(enmNam.nextElement());
			
			if("fb_jobname".equals(strNam)) {
				jobName = (String)(request.getParameter(strNam).trim());
				isJobName = false;
			}
		}
		
		return jobName;
	}
	
	 /**
     * �g���q�擾����
     * @param fileName
     * @return
     */
    private String postfix(String  fileName){
        if (fileName != null && !"".equals(fileName)) {
            return fileName.substring(fileName.indexOf("."), fileName.length());
        } else {
        	
        	// HTML��߂�
            return null;
        }
    }
	
    /**
     * XML���ꕶ����ϊ����܂��B 
     *             < �� &lt;
     *             > �� &gt;
     *             & �� &amp;
     *             " �� &quot;
     * @param strValue �Ώە�����
     * @return�@String strBrowsed �ϊ����ʕ�����
     */
    private String stringBrowse(String strValue) {
    	String strBrowsed = "";
    	strBrowsed = strValue.replace("<","&lt;");
    	strBrowsed = strBrowsed.replace(">","&gt;");
    	//strBrowsed = strBrowsed.replace("&","&amp;");
    	strBrowsed = strBrowsed.replace("\"","&quot;");
    	//strBrowsed = strBrowsed.replace("'","&apos;");
    	return strBrowsed;
    }
}