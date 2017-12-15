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
 * 	案件詳細画面の引数	<br>
 */
public class JobShow {
	
	/** ユーザーID */
	private String _userId = "";
	
	/** ユーザー名 */
	private String _userName = "";

	/** 組織ID */
	private String _orgId = "";

	/** ジョブID */
	private String _jobId = "";

	/**　Template ID */
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
	 * ユーザＩＰの設定
	 * @param userIp　ユーザＩＰ
	 */
	public void setUserIp(String userIp)
	{
		_userIp = userIp;
	}

	/**
	 * userIpの取得 <br>
	 * 
	 * @return _userIp　ユーザＩＰ
	 */
	public String getUserIp()
	{
		return _userIp;
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
}
