package flowbuilder.presentation.webcmn.taglibs.view.joblist;

public class JobDTO
{

	/** 案件No */
	private String _jobNo = "";

	/** 分類 */
	private String _jobClassName = "";

	/** 案件名 */
	private String _jobTitle = "";

	/** 作成者 */
	private String _jobCreateName = "";

	/** 状態 */
	private String _jobState = "";

	/** 申請時間 */
	private String _jobTime = "";
	
	/** 画面のID */
	private String _jobJspFileName = "";
	
	/** ジョブID */
	private String _jobId = "";

	/**
	 * ジョブIDの取得
	 * 
	 * @return　_jobId　ジョブID
	 */
	public String getJobId() {
		return _jobId;
	}

	/**
	 * ジョブIDの設定
	 * 
	 * @param id　ジョブID
	 */
	public void setJobId(String id) {
		_jobId = id;
	}

	/**
	 * 画面のIDを取得する
	 * 
	 * @return　画面のID
	 */
	public String getJobJspFileName() {
		return _jobJspFileName;
	}

	/**
	 * 画面のIDを設定する
	 * 
	 * @param jspFileName　画面のID
	 */
	public void setJobJspFileName(String jspFileName) {
		_jobJspFileName = jspFileName;
	}

	/**
	 * 分類の設定 <BR>
	 * 
	 * @param jobClassName 分類
	 */
	public void setJobClassName(String jobClassName)
	{
		_jobClassName = jobClassName;
	}

	/**
	 * 分類の取得 <BR>
	 * 
	 * @return String
	 */
	public String getJobClassName()
	{
		return _jobClassName;
	}

	/**
	 * 案件名の設定 <BR>
	 * 
	 * @param jobTitle 案件名
	 */
	public void setJobTitle(String jobTitle)
	{
		_jobTitle = jobTitle;
	}

	/**
	 * 案件名の取得 <BR>
	 * 
	 * @return String
	 */
	public String getJobTitle()
	{
		return _jobTitle;
	}

	/**
	 * 作成者の設定 <BR>
	 * 
	 * @param jobCreateName 作成者
	 */
	public void setJobCreateName(String jobCreateName)
	{
		_jobCreateName = jobCreateName;
	}

	/**
	 * 作成者の取得 <BR>
	 * 
	 * @return String
	 */
	public String getJobCreateName()
	{
		return _jobCreateName;
	}

	/**
	 * 状態の設定 <BR>
	 * 
	 * @param jobState 状態
	 */
	public void setJobState(String jobState)
	{
		_jobState = jobState;
	}

	/**
	 * 状態の取得 <BR>
	 * 
	 * @return String
	 */
	public String getJobState()
	{
		return _jobState;
	}

	/**
	 * 案件Noの設定 <BR>
	 * 
	 * @param jobNo 案件No
	 */
	public void setJobNo(String jobNo)
	{
		_jobNo = jobNo;
	}

	/**
	 * 案件Noの取得 <BR>
	 * 
	 * @return String
	 */
	public String getJobNo()
	{
		return _jobNo;
	}

	/**
	 * 申請時間の取得 <BR>
	 * 
	 * @return String
	 */
	public String getJobTime() {
		return _jobTime;
	}

	/**
	 * 申請時間の設定 <BR>
	 * 
	 * @param time 申請時間
	 */
	public void setJobTime(String time) {
		_jobTime = time;
	}

}
