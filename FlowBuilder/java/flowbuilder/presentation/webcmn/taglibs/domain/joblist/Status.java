package flowbuilder.presentation.webcmn.taglibs.domain.joblist;

import java.util.List;

public class Status {
	private String status;
	
	private List<UserCondition> userList;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<UserCondition> getUserList() {
		return userList;
	}

	public void setUserList(List<UserCondition> userList) {
		this.userList = userList;
	}
}
