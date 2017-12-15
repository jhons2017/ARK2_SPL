/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/04/26
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/04/26 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.daoimpl.flowbuilder.joblist;

import flowbuilder.dao.joblist.JobListQueryInfo;

/**
 * �W���u���X�g�����̂��߂̌����������`���� <BR>
 */
public final class JobListQueryInfoImpl implements JobListQueryInfo {
	
	/**
	 *�@���݂̑g�D  
	 */
	private String _curOrg = null;
	
	/**
	 * ���݂̃��[��
	 */
	private String _curRole = null;
	
	/**
	 * ���݂̏��
	 */
	private String _curStatus = null;
	
	/**
	 * �W���uID
	 */
	private String _jobId = null;
	
	/**
	 * �Č����O
	 */
	private String _jobName = null;
	
	/**
	 * �N�Ď҂̑g�DID
	 */
	private String _orgId = null;
	
	/**
	 * �N�Ď҂̃��[��ID
	 */
	private String _roleId = null;
	
	/**
	 * �Č��e���v���[�gID
	 */
	private String _tempId = null;
	
	/**
	 * �N�Ď҂̃��[�UID
	 */
	private String _userId = null;
	
	/**
	 * �Č��ɑΉ�������ID
	 */
	private String _view = null;
	
	/**
	 * �Č��N�Ă̓��t	<br>
	 * �i�Ⴆ�΁F�@�u2007/04/26�v�Ə����j
	 */
	private String _date = null;
	

	/**
	 * ���ݑg�D�̎擾 <br>
	 * 
	 * @return _curOrg ���ݑg�D
	 */
	public String getCurOrg() {
		return this._curOrg;
	}

	/**
	 * ���ݑg�D�̐ݒ� <br>
	 * 
	 * @param curOrg ���ݑg�D
	 */
	public void setCurOrg(String curOrg) {
		this._curOrg = curOrg;
	}
	
	/**
	 * ���݃��[���̎擾 <br>
	 * 
	 * @return _curRole ���݃��[��
	 */
	public String getCurRole() {
		return this._curRole;
	}

	/**
	 * ���݃��[���̐ݒ� <br>
	 * 
	 * @param curRole ���݃��[��
	 */
	public void setCurRole(String curRole) {
		this._curRole = curRole;
	}
	
	/**
	 * ���ݏ�Ԃ̐ݒ� <br>
	 * 
	 * @param curRole ���ݏ��
	 */
	public void setCurStatus(String status) {
		this._curStatus = status;
	}

	/**
	 * ���ݏ�Ԃ̎擾 <br>
	 * 
	 * @return _curRole ���ݏ��
	 */
	public String getCurStatus() {
		return this._curStatus;
	}

	/**
	 * �W���uID�̎擾 <br>
	 * 
	 * @return _jobId �W���uID
	 */
	public String getJobId() {
		return this._jobId;
	}

	/**
	 * �W���uID�̐ݒ� <br>
	 * 
	 * @param jobId �W���uID
	 */
	public void setJobId(String jobId) {
		this._jobId = jobId;
	}

	/**
	 * �Č����O�̎擾 <br>
	 * 
	 * @return _jobName �Č����O
	 */
	public String getJobName() {
		return this._jobName;
	}
	
	/**
	 * �Č����O�̐ݒ� <br>
	 * 
	 * @param jobName �Č����O
	 */
	public void setJobName(String jobName) {
		this._jobName = jobName;
	}

	/**
	 * �N�Ďґg�DID�̎擾 <br>
	 * 
	 * @return _orgId �N�Ďґg�DID
	 */
	public String getOrgId() {
		return this._orgId;
	}

	/**
	 * �N�Ďґg�DID�̐ݒ� <br>
	 * 
	 * @param orgId �N�Ďґg�DID
	 */
	public void setOrgId(String orgId) {
		this._orgId = orgId;
	}

	/**
	 * �N�Ď҃��[��ID�̎擾 <br>
	 * 
	 * @return _roleId �N�Ď҃��[��ID
	 */
	public String getRoleId() {
		return this._roleId;
	}

	/**
	 * �N�Ď҃��[��ID�̐ݒ� <br>
	 * 
	 * @param roleId �N�Ď҃��[��ID
	 */
	public void setRoleId(String roleId) {
		this._roleId = roleId;
	}

	/**
	 * �Č��e���v���[�gID�̎擾 <br>
	 * 
	 * @return _tempId �Č��e���v���[�gID
	 */
	public String getTemplateId() {
		return this._tempId;
	}

	/**
	 * �Č��e���v���[�gID�̐ݒ� <br>
	 * 
	 * @param templateId �Č��e���v���[�gID
	 */
	public void setTemplateId(String templateId) {
		this._tempId = templateId;
	}

	/**
	 * �N�Ď�ID�̎擾 <br>
	 * 
	 * @return _userId �N�Ď�ID
	 */
	public String getUserId() {
		return this._userId;
	}

	/**
	 * �N�Ď�ID�̐ݒ� <br>
	 * 
	 * @param userId �N�Ď�ID
	 */
	public void setUserId(String userId) {
		this._userId = userId;
	}

	/**
	 * �Č��ɑΉ�������ID�̎擾 <br>
	 * 
	 * @return _view �Č��ɑΉ�������ID
	 */
	public String getView() {
		return this._view;
	}

	/**
	 * �Č��ɑΉ�������ID�̐ݒ� <br>
	 * 
	 * @param view �Č��ɑΉ�������ID
	 */
	public void setView(String view) {
		this._view = view;
	}

	/**
	 * �Č��N�Ă̓��t�̎擾 <br>
	 * 
	 * @return _date �Č��N�Ă̓��t
	 */	
	public String getDate() {
		return this._date;
	}
	
	/**
	 * �Č��N�Ă̓��t�̐ݒ� <br>
	 * 
	 * @param date �Č��N�Ă̓��t
	 */
	public void setDate(String date) {
		this._date = date;
	}

}
