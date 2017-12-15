/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/04/27
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/04/27 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.domain.jobctrl;

import java.util.List;

import org.apache.struts.upload.FormFile;

/**
 * ã∆ñ±ëÄçÏópÇÃBEAN
 */
public class JobCtrlParameter {
	private String jobName = "";
	
	private String oprFlg = "";
	
	private String oprId = "";
	
	private String jobId = "";
	
	private String userId = "";
	
	private String orgId = "";
	
	private String tempId = "";
	
	private String userIp = "";
	
	private String roleId = "";
	
	private FormFile[] files = null;
	
	private List<JobControl> parameters = null;

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getOprFlg() {
		return oprFlg;
	}

	public void setOprFlg(String oprFlg) {
		this.oprFlg = oprFlg;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public List<JobControl> getParameters() {
		return parameters;
	}

	public void setParameters(List<JobControl> parameters) {
		this.parameters = parameters;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOprId() {
		return oprId;
	}

	public void setOprId(String oprId) {
		this.oprId = oprId;
	}

	public String getTempId() {
		return tempId;
	}

	public void setTempId(String tempId) {
		this.tempId = tempId;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public void setFiles(FormFile[] file)
	{
		this.files = file;
	}
	
	public FormFile[] getFiles()
	{
		return files;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
}
