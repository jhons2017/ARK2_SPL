package flowbuilder.presentation.jobshow;

import org.apache.struts.action.ActionForm;
import org.w3c.dom.Document;

/**
 * �Č��\����Form <BR>
 */
public final class JobMakeForm extends ActionForm
{
	/** ���[�U�[ID */
	private String _method = "";
	
	/** ���[�U�[ID */
	private String _userName = "";
	
	/** ���[�U�[ID */
	private String _userId = "";

	/** �g�DID */
	private String _orgId = "";

	/** �Č�ID */
	private String _jobId = "";

	/** �Č�ID */
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
	 * userIp�̎擾 <br>
	 * 
	 * @return String
	 */
	public String getUserIp()
	{
		return _userIp;
	}
	
	/**
	 * ���[�U�[ID�̐ݒ� <br>
	 * 
	 * @param method ���[�U�[ID
	 */
	public void setMethod(String method)
	{
		_method = method;
	}

	/**
	 * ���[�U�[ID�̎擾 <br>
	 * 
	 * @return String
	 */
	public String getMethod()
	{
		return _method;
	}

	/**
	 * ���[�U�[ID�̐ݒ� <br>
	 * 
	 * @param userId ���[�U�[ID
	 */
	public void setUserName(String userName)
	{
		_userName = userName;
	}

	/**
	 * ���[�U�[ID�̎擾 <br>
	 * 
	 * @return String
	 */
	public String getUserName()
	{
		return _userName;
	}

	/**
	 * ���[�U�[ID�̐ݒ� <br>
	 * 
	 * @param userId ���[�U�[ID
	 */
	public void setUserId(String userId)
	{
		_userId = userId;
	}

	/**
	 * ���[�U�[ID�̎擾 <br>
	 * 
	 * @return String
	 */
	public String getUserId()
	{
		return _userId;
	}

	/**
	 * �g�DID�̐ݒ� <br>
	 * 
	 * @param orgId �g�DID
	 */
	public void setOrgId(String orgId)
	{
		_orgId = orgId;
	}

	/**
	 * �g�DID�̎擾 <br>
	 * 
	 * @return String
	 */
	public String getOrgId()
	{
		return _orgId;
	}

	/**
	 * �Č�ID�̐ݒ� <br>
	 * 
	 * @param jobId �Č�ID
	 */
	public void setJobId(String jobId)
	{
		_jobId = jobId;
	}

	/**
	 * �Č�ID�̎擾 <br>
	 * 
	 * @return String
	 */
	public String getJobId()
	{
		return _jobId;
	}

	/**
	 * TemplateId�̐ݒ� <br>
	 * 
	 * @param templateId TemplateId
	 */
	public void setTemplateId(String templateId)
	{
		_templateId = templateId;
	}

	/**
	 * TemplateId�̎擾 <br>
	 * 
	 * @return String
	 */
	public String getTemplateId()
	{
		return _templateId;
	}

	/**
	 * Operator�̐ݒ� <br>
	 * 
	 * @param operator Operator
	 */
	public void setOperator(String operator)
	{
		_operator = operator;
	}

	/**
	 * Operator�̎擾 <br>
	 * 
	 * @return String
	 */
	public String getOperator()
	{
		return _operator;
	}

	/**
	 * Act�̐ݒ� <br>
	 * 
	 * @param act Act
	 */
	public void setAct(String act)
	{
		_act = act;
	}

	/**
	 * Act�̎擾 <br>
	 * 
	 * @return String
	 */
	public String getAct()
	{
		return _act;
	}

	/**
	 * View�̐ݒ� <br>
	 * 
	 * @param view View
	 */
	public void setView(String view)
	{
		_view = view;
	}

	/**
	 * View�̎擾 <br>
	 * 
	 * @return String
	 */
	public String getView()
	{
		return _view;
	}

	/**
	 * JobFileName�̐ݒ� <br>
	 * 
	 * @param jobFileName JobFileName
	 */
	public void setJobFileName(String jobFileName)
	{
		_jobFileName = jobFileName;
	}

	/**
	 * JobFileName�̎擾 <br>
	 * 
	 * @return String
	 */
	public String getJobFileName()
	{
		return _jobFileName;
	}
	
	/**
	 * ���[�U�[ID�̐ݒ� <br>
	 * 
	 * @param method ���[�U�[ID
	 */
	public void setJob(Document job)
	{
		_job = job;
	}

	/**
	 * ���[�U�[ID�̎擾 <br>
	 * 
	 * @return String
	 */
	public Document getJob()
	{
		return _job;
	}

	/**
	 * Name�̐ݒ� <br>
	 * 
	 * @param name Name
	 */
	public void setName(String name)
	{
		_name = name;
	}

	/**
	 * Name�̎擾 <br>
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
	 * email�̎擾 <br>
	 * 
	 * @return String
	 */
	public String getPassword()
	{
		return _password;
	}
}