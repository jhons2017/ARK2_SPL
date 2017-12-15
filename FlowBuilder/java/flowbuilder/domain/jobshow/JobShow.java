/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/03/06 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.domain.jobshow;

import org.w3c.dom.Document;

/**
 * 	�Č��ڍ׉�ʂ̈���	<br>
 */
public class JobShow {
	
	/** ���[�U�[ID */
	private String _userId = "";
	
	/** ���[�U�[�� */
	private String _userName = "";

	/** �g�DID */
	private String _orgId = "";

	/** �W���uID */
	private String _jobId = "";

	/**�@Template ID */
	private String _templateId = "";

	/** jobFileName */
	private String _jobFileName = "";

	/** job */
	private Document _job = null;

	/** name */
	private String _name = "";

	/** userIp */
	private String _userIp = "";
	
	/** view */
	private String _view = "";

	/**
	 * ���[�U�h�o�̐ݒ�
	 * @param userIp�@���[�U�h�o
	 */
	public void setUserIp(String userIp)
	{
		_userIp = userIp;
	}

	/**
	 * userIp�̎擾 <br>
	 * 
	 * @return _userIp�@���[�U�h�o
	 */
	public String getUserIp()
	{
		return _userIp;
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
}
