package flowbuilder.presentation.webcmn.taglibs.domain.joblist;

public class UserCondition {

	private String role;
	
	private String[] orgList;
	
	private String[] userIdList;

	public String[] getOrgList() {
		return orgList;
	}

	public void setOrgList(String[] orgList) {
		this.orgList = orgList;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String[] getUserIdList() {
		return userIdList;
	}

	public void setUserIdList(String[] userIdList) {
		this.userIdList = userIdList;
	}
	
	
}
