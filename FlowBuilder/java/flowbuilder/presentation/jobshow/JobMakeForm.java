package flowbuilder.presentation.jobshow;

import org.apache.struts.action.ActionForm;
import org.w3c.dom.Document;

/**
 * 案件表示のForm <BR>
 */
public final class JobMakeForm extends ActionForm
{
	/** ユーザーID */
	private String _method = "";
	
	/** ユーザーID */
	private String _userName = "";
	
	/** ユーザーID */
	private String _userId = "";

	/** 組織ID */
	private String _orgId = "";

	/** 案件ID */
	private String _jobId = "";

	/** 案件ID */
	private String _templateId = "";

	/** operator */
	private String _operator = "";

	/** act */
	private String _act = "";

	/** view */
	private String _view = "";

	/** jobFileName */
	private String _jobFileName = "";

	/** job */
	private Document _job = null;

	/** name */
	private String _name = "";

	/** userIp */
	private String _userIp = "";

	/** password */
	private String _password = "";

	
	public void setUserIp(String userIp)
	{
		_userIp = userIp;
	}

	/**
	 * userIpの取得 <br>
	 * 
	 * @return String
	 */
	public String getUserIp()
	{
		return _userIp;
	}
	
	/**
	 * ユーザーIDの設定 <br>
	 * 
	 * @param method ユーザーID
	 */
	public void setMethod(String method)
	{
		_method = method;
	}

	/**
	 * ユーザーIDの取得 <br>
	 * 
	 * @return String
	 */
	public String getMethod()
	{
		return _method;
	}

	/**
	 * ユーザーIDの設定 <br>
	 * 
	 * @param userId ユーザーID
	 */
	public void setUserName(String userName)
	{
		_userName = userName;
	}

	/**
	 * ユーザーIDの取得 <br>
	 * 
	 * @return String
	 */
	public String getUserName()
	{
		return _userName;
	}

	/**
	 * ユーザーIDの設定 <br>
	 * 
	 * @param userId ユーザーID
	 */
	public void setUserId(String userId)
	{
		_userId = userId;
	}

	/**
	 * ユーザーIDの取得 <br>
	 * 
	 * @return String
	 */
	public String getUserId()
	{
		return _userId;
	}

	/**
	 * 組織IDの設定 <br>
	 * 
	 * @param orgId 組織ID
	 */
	public void setOrgId(String orgId)
	{
		_orgId = orgId;
	}

	/**
	 * 組織IDの取得 <br>
	 * 
	 * @return String
	 */
	public String getOrgId()
	{
		return _orgId;
	}

	/**
	 * 案件IDの設定 <br>
	 * 
	 * @param jobId 案件ID
	 */
	public void setJobId(String jobId)
	{
		_jobId = jobId;
	}

	/**
	 * 案件IDの取得 <br>
	 * 
	 * @return String
	 */
	public String getJobId()
	{
		return _jobId;
	}

	/**
	 * TemplateIdの設定 <br>
	 * 
	 * @param templateId TemplateId
	 */
	public void setTemplateId(String templateId)
	{
		_templateId = templateId;
	}

	/**
	 * TemplateIdの取得 <br>
	 * 
	 * @return String
	 */
	public String getTemplateId()
	{
		return _templateId;
	}

	/**
	 * Operatorの設定 <br>
	 * 
	 * @param operator Operator
	 */
	public void setOperator(String operator)
	{
		_operator = operator;
	}

	/**
	 * Operatorの取得 <br>
	 * 
	 * @return String
	 */
	public String getOperator()
	{
		return _operator;
	}

	/**
	 * Actの設定 <br>
	 * 
	 * @param act Act
	 */
	public void setAct(String act)
	{
		_act = act;
	}

	/**
	 * Actの取得 <br>
	 * 
	 * @return String
	 */
	public String getAct()
	{
		return _act;
	}

	/**
	 * Viewの設定 <br>
	 * 
	 * @param view View
	 */
	public void setView(String view)
	{
		_view = view;
	}

	/**
	 * Viewの取得 <br>
	 * 
	 * @return String
	 */
	public String getView()
	{
		return _view;
	}

	/**
	 * JobFileNameの設定 <br>
	 * 
	 * @param jobFileName JobFileName
	 */
	public void setJobFileName(String jobFileName)
	{
		_jobFileName = jobFileName;
	}

	/**
	 * JobFileNameの取得 <br>
	 * 
	 * @return String
	 */
	public String getJobFileName()
	{
		return _jobFileName;
	}
	
	/**
	 * ユーザーIDの設定 <br>
	 * 
	 * @param method ユーザーID
	 */
	public void setJob(Document job)
	{
		_job = job;
	}

	/**
	 * ユーザーIDの取得 <br>
	 * 
	 * @return String
	 */
	public Document getJob()
	{
		return _job;
	}

	/**
	 * Nameの設定 <br>
	 * 
	 * @param name Name
	 */
	public void setName(String name)
	{
		_name = name;
	}

	/**
	 * Nameの取得 <br>
	 * 
	 * @return String
	 */
	public String getName()
	{
		return _name;
	}
	
	public void setPassword(String emailPassword)
	{
		_password = emailPassword;
	}

	/**
	 * emailの取得 <br>
	 * 
	 * @return String
	 */
	public String getPassword()
	{
		return _password;
	}
}