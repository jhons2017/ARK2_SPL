/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/03/06 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs.application.joblist;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import flowbuilder.application.util.JobOprater;
import flowbuilder.application.util.SystemFactroyKey;
import flowbuilder.dao.conf.FlowBuilderSystemConfig;
import flowbuilder.dao.joblist.JobListDAO;
import flowbuilder.dao.joblist.JobListDataAccessFactroy;
import flowbuilder.dao.joblist.JobListQueryInfo;
import flowbuilder.dao.user.SectionDAO;
import flowbuilder.dao.user.UserDAO;
import flowbuilder.dao.user.UserDataAccessFactroy;
import flowbuilder.daoimpl.db.DBXmlFileConn;
import flowbuilder.daoimpl.db.XmlFileProperity;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.domain.joblist.JobList;
import flowbuilder.domain.user.Section;
import flowbuilder.domain.user.UserRole;
import flowbuilder.presentation.webcmn.taglibs.domain.joblist.Condition;
import flowbuilder.presentation.webcmn.taglibs.domain.joblist.Status;
import flowbuilder.presentation.webcmn.taglibs.domain.joblist.UserCondition;
import flowbuilder.presentation.webcmn.taglibs.view.joblist.JobDTO;
import fbcom.framework.dao.conf.ConfigReader;
import fbcom.framework.exceptions.SysException;
import fbcom.framework.exceptions.XmlAccessSysException;

;
/**
 * ログインサービスに共通するアプリケーションサービスの実装クラス <BR>
 */
final class JobListServiceImpl implements JobListService {
	/** ログ */
	private Log logger = LogFactory.getLog(JobListService.class);

	/** ファイルのパース */
	private String joblistXML = "";

	/** DAOファクトリの宣言 */
	private UserDataAccessFactroy _daoFactory = null;

	/** DAOファクトリの宣言 */
	private JobListDataAccessFactroy _jobListDaoFactory = null;

	/** ユーザーDAO */
	private UserDAO _userDAO;
	
	/** 組織DAO */
	private SectionDAO _sectionDAO; 

	/** ジョブリストDAO */
	private JobListDAO _jobListDAO;

	/** 検索条件DAO */
	private JobListQueryInfo _joblistQueryInfo = null;

	/** ファイルインフォの取得 */
	private XmlFileProperity fileOpr = null;

	/** ジョブの操作 */
	private JobOprater jobOpr = null;

	/**
	 * コンストラクタ
	 * 
	 * @throws Exception
	 * 
	 * @throws SysException システムエラーの場合
	 * 
	 */
	JobListServiceImpl() throws Exception {
		// ファイルインフォの取得
		fileOpr = new XmlFileProperity("Path.Xml.File");
		// ジョブの操作
		jobOpr = new JobOprater();

		_daoFactory = UserDataAccessFactroy.getFactory(SystemFactroyKey.UserFactroyKey);
		_jobListDaoFactory = JobListDataAccessFactroy
				.getFactory(SystemFactroyKey.JobListFactroyKey);
		init();
	}

	/**
	 * 初期化処理
	 */
	private void init() {
		_userDAO = _daoFactory.createUserDAO();
		_sectionDAO = _daoFactory.createSectionDAO();
		_jobListDAO = _jobListDaoFactory.createJobListDAO();
		_joblistQueryInfo = _jobListDaoFactory.createJobListQueryInfo();
	}

	/**
	 * 組織の中にユーザの情報を取得する
	 * 
	 * @param joblist 案件一覧画面へ伝える情報のBEAN
	 * @return User ユーザBEAN
	 * @throws SysException システムエラーの場合。
	 */
	public List<JobDTO> getJobListDTO(List<Condition> condition, String userId, String orgId,UserRole userRole)
			throws SysException {		
		
		List<JobList> joblistTemp = new ArrayList<JobList>();
		
		List<JobDTO> jobDTOList = null;
		
		try{
			//ジョブリストの取得
			List<JobList> joblist = _jobListDAO.getJobList(_joblistQueryInfo);
			
			int length = joblist.size();
			
 			for(int i=length-1;i>=0;i--){
				JobList jobRecord = joblist.get(i);
				//組織を取得する
				String curOrgId = jobRecord.getCurOrg();
				
				//自分の案件を決める
				if(userId.equals(jobRecord.getUserId())){
					joblistTemp.add(jobRecord);
					continue;
				}
				
				//フローは自分に流れました
				if("".equals(jobRecord.getCurOrg())){
					// 作成者の上司を決める
					if(jobRecord.getOrgId().indexOf(orgId) > -1 && jobRecord.getCurRole().equals(userRole.toString())){
						joblistTemp.add(jobRecord);
						continue;
					}
				}
				
				//フローは自分に流れました
				if(orgId.equals(jobRecord.getCurOrg()) && jobRecord.getCurRole().equals(userRole.toString())){
					joblistTemp.add(jobRecord);
					continue;
				}
				
				//回覧部品に特別に操作
				if(this.iscircularPeople(jobRecord,userId)){
					joblistTemp.add(jobRecord);
					continue;
				}
				
				//
				if(getConfigJobList(condition,jobRecord,userId,orgId,userRole)){
					joblistTemp.add(jobRecord);
					continue;
				}
				
			}
			
			//画面表示のジョブリストを取得する
			jobDTOList = getJobDTOList(joblistTemp,condition);
			
			
		}catch(Exception e){
			
		}
		//自分
		return jobDTOList;
	}
	
	/**
	 * 
	 * @param condition
	 * @param jobRecord
	 * @param userId
	 * @param orgId
	 * @param userRole
	 * @return
	 * @throws XmlAccessSysException 
	 */
	private boolean getConfigJobList(List<Condition> condition,JobList jobRecord,String userId, String orgId,UserRole userRole) throws XmlAccessSysException{
		boolean bResult = false;
		
		Section orgBean = _sectionDAO.selectById(orgId);
		
		int conditionLength = condition.size();
		
		for(int i=0;i<conditionLength;i++){
			
			Condition cond = condition.get(i);
			
			if(cond.getTempId().equals(jobRecord.getTemplateId())){
				
				List<Status> status = cond.getStatus();
				
				int statusLength = status.size();
				
				for(int j=0;j<statusLength;j++){
					Status sta = status.get(j);
					
					if(sta.getStatus().equals(jobRecord.getCurStatus())){
						
						List<UserCondition> userCondList = sta.getUserList();
						
						int userCondLength = userCondList.size();
						
						for(int k=0;k<userCondLength;k++){
							
							UserCondition userCond =  userCondList.get(k);
							
							if(userCond.getRole().equals(userRole.getName())){
								
								String [] orgList = userCond.getOrgList();
								
								String [] userList = userCond.getUserIdList();
								
								int orgListLength = orgList.length;
								
								for(int t=0;t<orgListLength;t++){
									String orgID = orgList[t].replace("*",jobRecord.getOrgId());
									
									if(orgID.indexOf(orgBean.getNo()) != -1 || orgID.equals(orgBean.getName())){
										bResult = true;
										break;
									}
								}
							}
						}
					}
				}
			}
		}
		
		return bResult;
	}

	/**
	 * 
	 * @param joblist
	 * @param condition
	 * @return
	 */
	private List<JobDTO> getJobDTOList(List<JobList> joblist,List<Condition> condition){
		List<JobDTO> jobDTOList = new ArrayList<JobDTO>();
		JobDTO jobDTO = null;
		int memberListSize = 0;
		
		int length = joblist.size();
		for(int i=0;i<length;i++){
			jobDTO = new JobDTO();
			JobList job	 = 	joblist.get(i);
			
			jobDTO.setJobNo(String.valueOf(i+1));
			jobDTO.setJobCreateName(job.getUserId());
			jobDTO.setJobState(circularprocess(job.getCurStatus(),memberListSize,job));
			jobDTO.setJobTime(job.getDate());
			jobDTO.setJobTitle(job.getJobName());
			jobDTO.setJobId(job.getJobId());
			jobDTO.setJobJspFileName(job.getView());
			
			//案件の名前を取得する
			int condLength = condition.size();
			for(int j=0;j<condLength;j++){
				Condition cond = condition.get(j);
				
				if(cond.getTempId().equals(job.getTemplateId())){
					jobDTO.setJobClassName(cond.getTempTitle());
					break;
				}
				
			}
			jobDTOList.add(jobDTO);
		}
		
		return jobDTOList;
		
	}
	
	/**
	 * 
	 * @param curStatus
	 * @param memberListSize
	 * @param　job
	 * @return
	 */
	private	String circularprocess(String curStatus, int memberListSize,JobList job) {
		int finishmember = 0;
		if ("回覧中".equals(curStatus)) {
			// 設定ファイルの読み込みを行なう
			ConfigReader conf = FlowBuilderSystemConfig.getInstance();
			// ジョブファイルのパスを取得する
			String jobFilePath = conf.getValue("jobPath");
			// ドキュメントを取得する
			Document jobDoc = DBXmlFileConn.getDocument(jobFilePath + "job_" + job.getJobId() + ".xml");
			//　CircularのNodeListを取得する
			NodeList CircularList = XmlOperator.getNodeList(jobDoc, "Circular");
			//　Circularのエレメントを取得する
			Element CircularElement = XmlOperator.getElement(CircularList, 0);
			NodeList memberList = CircularElement.getElementsByTagName("member");
			memberListSize = memberList.getLength();
			for (int j = 0; j < memberListSize; j++) {
				Element memberElement = XmlOperator.getElement(memberList, j);
				String problemFlg = memberElement.getAttribute("problemFlg");
				if ("3".equals(problemFlg)) {
					finishmember++;
				}
			}
			return curStatus + "("+String.valueOf(finishmember)+"/"+String.valueOf(memberListSize)+")";	
		} else {
			return curStatus;
		}
	}
	/**
	 * 
	 * @param jobRecord
	 * @param userId
	 * @return
	 */
	private boolean iscircularPeople(JobList jobRecord, String userId) {
		boolean bResult = false;

		//回覧の操作
		ConfigReader conf = FlowBuilderSystemConfig.getInstance();
		String configInfo[] = conf.getValue("Circular").split(",");

		int configInfoLength = configInfo.length;

		for (int index = 0; index < configInfoLength; index++) {
			String jobKindInfo[] = configInfo[index].split("/");
			String tempName = jobKindInfo[0];

			if (tempName.equals(jobRecord.getTemplateId())) {
				String status = jobKindInfo[1];
				String jobPath = fileOpr.getJobFileDir(jobRecord.getJobId());
				Document jobDoc = DBXmlFileConn.getDocument(jobPath);

				// ドキュメントが存在している場合処理
				if (jobDoc != null) {
					int step = jobOpr.getStep(jobDoc,jobOpr.getCurrentState(jobDoc));
					
					if (status.indexOf(String.valueOf(step)) != -1) {
						NodeList cirList = XmlOperator.getNodeList(jobDoc, "Circular");

						Element circularElm = (Element) cirList.item(0);

						if (circularElm != null) {
							NodeList memberList = circularElm.getElementsByTagName("member");

							int memberListLength = memberList.getLength();

							for (int i = 0; i < memberListLength; i++) {
								Element memberElm = (Element) memberList.item(i);

								String circularMember = memberElm.getAttributeNode("id")
										.getNodeValue();

								if (userId.equals(circularMember)) {
									bResult = true;
									break;
								}
							}
						}
					}
				}
			}
		}
		return bResult;
	}
}