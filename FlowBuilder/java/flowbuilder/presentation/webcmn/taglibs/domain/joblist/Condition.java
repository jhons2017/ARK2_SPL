package flowbuilder.presentation.webcmn.taglibs.domain.joblist;

import java.util.List;

public class Condition {
	private String tempId;
	
	private String tempTitle;
	
	private List<Status> status;

	public List<Status> getStatus() {
		return status;
	}

	public void setStatus(List<Status> status) {
		this.status = status;
	}

	public String getTempId() {
		return tempId;
	}

	public void setTempId(String tempId) {
		this.tempId = tempId;
	}

	public String getTempTitle() {
		return tempTitle;
	}

	public void setTempTitle(String tempTitle) {
		this.tempTitle = tempTitle;
	}
}
