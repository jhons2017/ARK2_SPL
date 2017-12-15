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
 * 案件表示画面処理を行なう。 <BR>
 */
public class JobControlAction extends Action
{
	/** 遷移目標画面 */
	private final String FORWARD_SUCCESS = "success";

	/** 遷移ログアウト目標画面 */
	private final String FORWARD_LOGOUT = "logout";

	private String jobid;

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
			
			// ジョブ名前を取得する
			jobCtrlPar.setJobName(getJobName(request));
			// ジョブIDを設定する
			jobCtrlPar.setJobId(detailForm.getJobId());
			// 操作フラグを設定する
			jobCtrlPar.setOprFlg(detailForm.getAct());
			// ユーザIDを設定する
			jobCtrlPar.setUserId(detailForm.getUserId());
			// ユーザ組織を設定する
			jobCtrlPar.setOrgId(detailForm.getOrgId());
			// 操作子を設定する
			jobCtrlPar.setOprId(detailForm.getOperator());
			// テンプレートIDを設定する
			jobCtrlPar.setTempId(detailForm.getTemplateId());
			// ユーザIPを設定する
			jobCtrlPar.setUserIp(request.getRemoteAddr());
			// 画面からリクエストの値を設定する
			jobCtrlPar.setParameters(getParameters(request, files));
			// ルールID
			jobCtrlPar.setRoleId(userInfo.getUserRole().toString());
			// アップロード
			jobCtrlPar.setFiles(files);
			// 業務の操作
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
	 * 画面からリクエストの値を取得する
	 * 
	 * @param request　リクエスト
	 * @return　パラメータリスト
	 */
	private List<JobControl> getParameters(HttpServletRequest request,FormFile[] files){
		//戻りの値
		List<JobControl> list = null;
		
		//パラメータBEAN
		JobControl jobCtrl = null;
		
		try{
			list =  new ArrayList<JobControl>();
			//ドキュメントのエレメント個数を取得
			Enumeration enmNam = request.getParameterNames();
			
			//リクエスト数を数える
			while(enmNam.hasMoreElements())
			{
				jobCtrl = new JobControl();
				
				//エレメント名を取得する
				String strNam=(String)(enmNam.nextElement());
				String strValue = (String)(request.getParameter(strNam).trim());
				
				//パラメータ名を設定する
				jobCtrl.setParamName(strNam);
				//パラメータ値を設定する
				jobCtrl.setParamValue(stringBrowse(strValue));
				
				//戻りのリストへ追加する
				list.add(jobCtrl);
			}
			
			// アップロードするファイルの名前を取得する
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
	 * ジョブ名前を取得する。
	 * 
	 * @param request
	 * @return
	 */
	private String getJobName(HttpServletRequest request) {
		String jobName = "";
		
		//ドキュメントのエレメント個数を取得
		Enumeration enmNam = request.getParameterNames();
		
		boolean isJobName = true;
		
		//リクエスト数を数える
		while(isJobName && enmNam.hasMoreElements())
		{
			//エレメント名を取得する
			String strNam=(String)(enmNam.nextElement());
			
			if("fb_jobname".equals(strNam)) {
				jobName = (String)(request.getParameter(strNam).trim());
				isJobName = false;
			}
		}
		
		return jobName;
	}
	
	 /**
     * 拡張子取得する
     * @param fileName
     * @return
     */
    private String postfix(String  fileName){
        if (fileName != null && !"".equals(fileName)) {
            return fileName.substring(fileName.indexOf("."), fileName.length());
        } else {
        	
        	// HTMLを戻る
            return null;
        }
    }
	
    /**
     * XML特殊文字を変換します。 
     *             < → &lt;
     *             > → &gt;
     *             & → &amp;
     *             " → &quot;
     * @param strValue 対象文字列
     * @return　String strBrowsed 変換結果文字列
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