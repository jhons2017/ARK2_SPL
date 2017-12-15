/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/04/26 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.dao.joblist;

/**
 * �W���u���X�g�����̂��߂̌����������`����C���^�[�t�F�[�X�B <BR>
 */
public interface JobListQueryInfo {
	/**
	 * ���ݑg�D�̎擾 <br>
	 * 
	 * @return _curOrg ���ݑg�D
	 */
	public String getCurOrg();

	/**
	 * ���ݑg�D�̐ݒ� <br>
	 * 
	 * @param curOrg ���ݑg�D
	 */
	public void setCurOrg(String curOrg);
	
	/**
	 * ���݃��[���̎擾 <br>
	 * 
	 * @return _curRole ���݃��[��
	 */
	public String getCurRole();

	/**
	 * ���݃��[���̐ݒ� <br>
	 * 
	 * @param curRole ���݃��[��
	 */
	public void setCurRole(String curRole);
	
	/**
	 * ���ݏ�Ԃ̐ݒ� <br>
	 * 
	 * @param curRole ���ݏ��
	 */
	public void setCurStatus(String status);

	/**
	 * ���ݏ�Ԃ̎擾 <br>
	 * 
	 * @return _curRole ���ݏ��
	 */
	public String getCurStatus();

	/**
	 * �W���uID�̎擾 <br>
	 * 
	 * @return _jobId �W���uID
	 */
	public String getJobId();

	/**
	 * �W���uID�̐ݒ� <br>
	 * 
	 * @param jobId �W���uID
	 */
	public void setJobId(String jobId);

	/**
	 * �Č����O�̎擾 <br>
	 * 
	 * @return _jobName �Č����O
	 */
	public String getJobName();
	
	/**
	 * �Č����O�̐ݒ� <br>
	 * 
	 * @param jobName �Č����O
	 */
	public void setJobName(String jobName);

	/**
	 * �N�Ďґg�DID�̎擾 <br>
	 * 
	 * @return _orgId �N�Ďґg�DID
	 */
	public String getOrgId();

	/**
	 * �N�Ďґg�DID�̐ݒ� <br>
	 * 
	 * @param orgId �N�Ďґg�DID
	 */
	public void setOrgId(String orgId);

	/**
	 * �N�Ď҃��[��ID�̎擾 <br>
	 * 
	 * @return _roleId �N�Ď҃��[��ID
	 */
	public String getRoleId();

	/**
	 * �N�Ď҃��[��ID�̐ݒ� <br>
	 * 
	 * @param roleId �N�Ď҃��[��ID
	 */
	public void setRoleId(String roleId);

	/**
	 * �Č��e���v���[�gID�̎擾 <br>
	 * 
	 * @return _tempId �Č��e���v���[�gID
	 */
	public String getTemplateId();

	/**
	 * �Č��e���v���[�gID�̐ݒ� <br>
	 * 
	 * @param templateId �Č��e���v���[�gID
	 */
	public void setTemplateId(String templateId);

	/**
	 * �N�Ď�ID�̎擾 <br>
	 * 
	 * @return _userId �N�Ď�ID
	 */
	public String getUserId();

	/**
	 * �N�Ď�ID�̐ݒ� <br>
	 * 
	 * @param userId �N�Ď�ID
	 */
	public void setUserId(String userId);

	/**
	 * �Č��ɑΉ�������ID�̎擾 <br>
	 * 
	 * @return _view �Č��ɑΉ�������ID
	 */
	public String getView();

	/**
	 * �Č��ɑΉ�������ID�̐ݒ� <br>
	 * 
	 * @param view �Č��ɑΉ�������ID
	 */
	public void setView(String view);

	/**
	 * �Č��N�Ă̓��t�̎擾 <br>
	 * 
	 * @return _date �Č��N�Ă̓��t
	 */	
	public String getDate();
	
	/**
	 * �Č��N�Ă̓��t�̐ݒ� <br>
	 * 
	 * @param date �Č��N�Ă̓��t
	 */
	public void setDate(String date);

}