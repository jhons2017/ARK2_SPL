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
 *　メール内容の中に、交替する用のキー <br>
 */
public class EmailOperator {
	
	private List<EmaiReplacedBean> repBeanList = null;
	
	/**
	 * 承認者の名前
	 */
	//private String _approvalerName = "{approvalerName}";
	
	/**
	 * ジョブの種類
	 */
	private String _jobType = "{jobType}";
	
	/**
	 * ジョブの名前
	 */
	private String _jobName = "{jobName}";
	
	/**
	 * 今の状態
	 */
	private String _curState = "{curState}";
	
	/**
	 * 起案者名前
	 */
	private String _drafterName = "{DrafterName}";
	
	JobOprater jobOpr = new JobOprater();
	
	/**
	 * EmaiReplacedBeanを作成する。
	 * 
	 * @param doc　案件ドキュメント
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
	 * 承認者の名前
	 * @param doc　案件ドキュメント
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
	 * ジョブの種類
	 * @param doc　案件ドキュメント
	 * @return strJobType EmaiReplacedBean メール内容の中に、交替する用の種類
	 */
	private EmaiReplacedBean getJobType(Document doc) {
		EmaiReplacedBean strJobType = new EmaiReplacedBean();
		strJobType.setId(this._jobType);
		strJobType.setValue(jobOpr.getWorkFlowName(doc));
		return strJobType;
	}

	/**
	 * ジョブの名前
	 * @param doc　案件ドキュメント
	 * @return　strJobName EmaiReplacedBean メール内容の中に、交替する用の名前
	 */
	private EmaiReplacedBean getJobName(Document doc) {
		EmaiReplacedBean strJobName = new EmaiReplacedBean();
		strJobName.setId(this._jobName);
		strJobName.setValue(jobOpr.getJobName(doc));
		return strJobName;
	}

	/**
	 * 今の状態
	 * @param doc　案件ドキュメント
	 * @return　strCurrentState EmaiReplacedBean メール内容の中に、交替する用の状態
	 */
	private EmaiReplacedBean getCurState(Document doc) {
		 EmaiReplacedBean strCurrentState = new EmaiReplacedBean();
		 strCurrentState.setId(this._curState);
		 strCurrentState.setValue(jobOpr.getCurrentState(doc));
		 return strCurrentState;
	}

	/**
	 * 起案者名前
	 * @param doc
	 * @return　strCreator EmaiReplacedBean メール内容の中に、交替する用の名前
	 */
	private EmaiReplacedBean getDrafterName(Document doc) {
		 EmaiReplacedBean strCreator = new EmaiReplacedBean();
		 strCreator.setId(this._drafterName);
		 strCreator.setValue(jobOpr.getCreatorName(doc));
		 return strCreator;
	}
	
	/**
	 * 
	 * @return　repBeanList List<EmaiReplacedBean> 案件ドキュメント
	 */
	public List<EmaiReplacedBean> getRepBeanList() {
		return repBeanList;
	}
}
