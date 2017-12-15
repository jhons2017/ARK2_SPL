package flowbuilder.presentation.webcmn.taglibs.view.joblist;

public class JobDTO
{

	/** �Č�No */
	private String _jobNo = "";

	/** ���� */
	private String _jobClassName = "";

	/** �Č��� */
	private String _jobTitle = "";

	/** �쐬�� */
	private String _jobCreateName = "";

	/** ��� */
	private String _jobState = "";

	/** �\������ */
	private String _jobTime = "";
	
	/** ��ʂ�ID */
	private String _jobJspFileName = "";
	
	/** �W���uID */
	private String _jobId = "";

	/**
	 * �W���uID�̎擾
	 * 
	 * @return�@_jobId�@�W���uID
	 */
	public String getJobId() {
		return _jobId;
	}

	/**
	 * �W���uID�̐ݒ�
	 * 
	 * @param id�@�W���uID
	 */
	public void setJobId(String id) {
		_jobId = id;
	}

	/**
	 * ��ʂ�ID���擾����
	 * 
	 * @return�@��ʂ�ID
	 */
	public String getJobJspFileName() {
		return _jobJspFileName;
	}

	/**
	 * ��ʂ�ID��ݒ肷��
	 * 
	 * @param jspFileName�@��ʂ�ID
	 */
	public void setJobJspFileName(String jspFileName) {
		_jobJspFileName = jspFileName;
	}

	/**
	 * ���ނ̐ݒ� <BR>
	 * 
	 * @param jobClassName ����
	 */
	public void setJobClassName(String jobClassName)
	{
		_jobClassName = jobClassName;
	}

	/**
	 * ���ނ̎擾 <BR>
	 * 
	 * @return String
	 */
	public String getJobClassName()
	{
		return _jobClassName;
	}

	/**
	 * �Č����̐ݒ� <BR>
	 * 
	 * @param jobTitle �Č���
	 */
	public void setJobTitle(String jobTitle)
	{
		_jobTitle = jobTitle;
	}

	/**
	 * �Č����̎擾 <BR>
	 * 
	 * @return String
	 */
	public String getJobTitle()
	{
		return _jobTitle;
	}

	/**
	 * �쐬�҂̐ݒ� <BR>
	 * 
	 * @param jobCreateName �쐬��
	 */
	public void setJobCreateName(String jobCreateName)
	{
		_jobCreateName = jobCreateName;
	}

	/**
	 * �쐬�҂̎擾 <BR>
	 * 
	 * @return String
	 */
	public String getJobCreateName()
	{
		return _jobCreateName;
	}

	/**
	 * ��Ԃ̐ݒ� <BR>
	 * 
	 * @param jobState ���
	 */
	public void setJobState(String jobState)
	{
		_jobState = jobState;
	}

	/**
	 * ��Ԃ̎擾 <BR>
	 * 
	 * @return String
	 */
	public String getJobState()
	{
		return _jobState;
	}

	/**
	 * �Č�No�̐ݒ� <BR>
	 * 
	 * @param jobNo �Č�No
	 */
	public void setJobNo(String jobNo)
	{
		_jobNo = jobNo;
	}

	/**
	 * �Č�No�̎擾 <BR>
	 * 
	 * @return String
	 */
	public String getJobNo()
	{
		return _jobNo;
	}

	/**
	 * �\�����Ԃ̎擾 <BR>
	 * 
	 * @return String
	 */
	public String getJobTime() {
		return _jobTime;
	}

	/**
	 * �\�����Ԃ̐ݒ� <BR>
	 * 
	 * @param time �\������
	 */
	public void setJobTime(String time) {
		_jobTime = time;
	}

}
