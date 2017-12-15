/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/06/13
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/13 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.application.util.email;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;

import flowbuilder.application.util.JobOprater;

/**
 *�@���[�����e�̒��ɁA��ւ���p�̃L�[ <br>
 */
public class EmailOperator {
	
	private List<EmaiReplacedBean> repBeanList = null;
	
	/**
	 * ���F�҂̖��O
	 */
	//private String _approvalerName = "{approvalerName}";
	
	/**
	 * �W���u�̎��
	 */
	private String _jobType = "{jobType}";
	
	/**
	 * �W���u�̖��O
	 */
	private String _jobName = "{jobName}";
	
	/**
	 * ���̏��
	 */
	private String _curState = "{curState}";
	
	/**
	 * �N�ĎҖ��O
	 */
	private String _drafterName = "{DrafterName}";
	
	JobOprater jobOpr = new JobOprater();
	
	/**
	 * EmaiReplacedBean���쐬����B
	 * 
	 * @param doc�@�Č��h�L�������g
	 */
	EmailOperator(Document doc) {
		repBeanList = new ArrayList<EmaiReplacedBean>();
		
		//repBeanList.add(getApprovalerName(doc));
		repBeanList.add(getJobType(doc));
		repBeanList.add(getJobName(doc));
		repBeanList.add(getCurState(doc));
		repBeanList.add(getDrafterName(doc));
	}

	/**
	 * ���F�҂̖��O
	 * @param doc�@�Č��h�L�������g
	 * @return
	 */
	/*private EmaiReplacedBean[] getApprovalerName(Document doc) {
		List<User> userList = jobOpr.getApprovalerList(doc);
		int length = userList.size();
		EmaiReplacedBean[] strUpUser = new EmaiReplacedBean[length];
		
		for(int index = 0; index < length; index++) {
			strUpUser[index].setId(this._approvalerName);
			strUpUser[index].setValue(userList.get(index).getUserName());
		}
		
		return strUpUser;
	}*/

	/**
	 * �W���u�̎��
	 * @param doc�@�Č��h�L�������g
	 * @return strJobType EmaiReplacedBean ���[�����e�̒��ɁA��ւ���p�̎��
	 */
	private EmaiReplacedBean getJobType(Document doc) {
		EmaiReplacedBean strJobType = new EmaiReplacedBean();
		strJobType.setId(this._jobType);
		strJobType.setValue(jobOpr.getWorkFlowName(doc));
		return strJobType;
	}

	/**
	 * �W���u�̖��O
	 * @param doc�@�Č��h�L�������g
	 * @return�@strJobName EmaiReplacedBean ���[�����e�̒��ɁA��ւ���p�̖��O
	 */
	private EmaiReplacedBean getJobName(Document doc) {
		EmaiReplacedBean strJobName = new EmaiReplacedBean();
		strJobName.setId(this._jobName);
		strJobName.setValue(jobOpr.getJobName(doc));
		return strJobName;
	}

	/**
	 * ���̏��
	 * @param doc�@�Č��h�L�������g
	 * @return�@strCurrentState EmaiReplacedBean ���[�����e�̒��ɁA��ւ���p�̏��
	 */
	private EmaiReplacedBean getCurState(Document doc) {
		 EmaiReplacedBean strCurrentState = new EmaiReplacedBean();
		 strCurrentState.setId(this._curState);
		 strCurrentState.setValue(jobOpr.getCurrentState(doc));
		 return strCurrentState;
	}

	/**
	 * �N�ĎҖ��O
	 * @param doc
	 * @return�@strCreator EmaiReplacedBean ���[�����e�̒��ɁA��ւ���p�̖��O
	 */
	private EmaiReplacedBean getDrafterName(Document doc) {
		 EmaiReplacedBean strCreator = new EmaiReplacedBean();
		 strCreator.setId(this._drafterName);
		 strCreator.setValue(jobOpr.getCreatorName(doc));
		 return strCreator;
	}
	
	/**
	 * 
	 * @return�@repBeanList List<EmaiReplacedBean> �Č��h�L�������g
	 */
	public List<EmaiReplacedBean> getRepBeanList() {
		return repBeanList;
	}
}
