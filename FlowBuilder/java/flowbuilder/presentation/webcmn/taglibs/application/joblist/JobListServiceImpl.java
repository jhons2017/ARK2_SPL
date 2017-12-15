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
 * ���O�C���T�[�r�X�ɋ��ʂ���A�v���P�[�V�����T�[�r�X�̎����N���X <BR>
 */
final class JobListServiceImpl implements JobListService {
	/** ���O */
	private Log logger = LogFactory.getLog(JobListService.class);

	/** �t�@�C���̃p�[�X */
	private String joblistXML = "";

	/** DAO�t�@�N�g���̐錾 */
	private UserDataAccessFactroy _daoFactory = null;

	/** DAO�t�@�N�g���̐錾 */
	private JobListDataAccessFactroy _jobListDaoFactory = null;

	/** ���[�U�[DAO */
	private UserDAO _userDAO;
	
	/** �g�DDAO */
	private SectionDAO _sectionDAO; 

	/** �W���u���X�gDAO */
	private JobListDAO _jobListDAO;

	/** ��������DAO */
	private JobListQueryInfo _joblistQueryInfo = null;

	/** �t�@�C���C���t�H�̎擾 */
	private XmlFileProperity fileOpr = null;

	/** �W���u�̑��� */
	private JobOprater jobOpr = null;

	/**
	 * �R���X�g���N�^
	 * 
	 * @throws Exception
	 * 
	 * @throws SysException �V�X�e���G���[�̏ꍇ
	 * 
	 */
	JobListServiceImpl() throws Exception {
		// �t�@�C���C���t�H�̎擾
		fileOpr = new XmlFileProperity("Path.Xml.File");
		// �W���u�̑���
		jobOpr = new JobOprater();

		_daoFactory = UserDataAccessFactroy.getFactory(SystemFactroyKey.UserFactroyKey);
		_jobListDaoFactory = JobListDataAccessFactroy
				.getFactory(SystemFactroyKey.JobListFactroyKey);
		init();
	}

	/**
	 * ����������
	 */
	private void init() {
		_userDAO = _daoFactory.createUserDAO();
		_sectionDAO = _daoFactory.createSectionDAO();
		_jobListDAO = _jobListDaoFactory.createJobListDAO();
		_joblistQueryInfo = _jobListDaoFactory.createJobListQueryInfo();
	}

	/**
	 * �g�D�̒��Ƀ��[�U�̏����擾����
	 * 
	 * @param joblist �Č��ꗗ��ʂ֓`�������BEAN
	 * @return User ���[�UBEAN
	 * @throws SysException �V�X�e���G���[�̏ꍇ�B
	 */
	public List<JobDTO> getJobListDTO(List<Condition> condition, String userId, String orgId,UserRole userRole)
			throws SysException {		
		
		List<JobList> joblistTemp = new ArrayList<JobList>();
		
		List<JobDTO> jobDTOList = null;
		
		try{
			//�W���u���X�g�̎擾
			List<JobList> joblist = _jobListDAO.getJobList(_joblistQueryInfo);
			
			int length = joblist.size();
			
 			for(int i=length-1;i>=0;i--){
				JobList jobRecord = joblist.get(i);
				//�g�D���擾����
				String curOrgId = jobRecord.getCurOrg();
				
				//�����̈Č������߂�
				if(userId.equals(jobRecord.getUserId())){
					joblistTemp.add(jobRecord);
					continue;
				}
				
				//�t���[�͎����ɗ���܂���
				if("".equals(jobRecord.getCurOrg())){
					// �쐬�҂̏�i�����߂�
					if(jobRecord.getOrgId().indexOf(orgId) > -1 && jobRecord.getCurRole().equals(userRole.toString())){
						joblistTemp.add(jobRecord);
						continue;
					}
				}
				
				//�t���[�͎����ɗ���܂���
				if(orgId.equals(jobRecord.getCurOrg()) && jobRecord.getCurRole().equals(userRole.toString())){
					joblistTemp.add(jobRecord);
					continue;
				}
				
				//�񗗕��i�ɓ��ʂɑ���
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
			
			//��ʕ\���̃W���u���X�g���擾����
			jobDTOList = getJobDTOList(joblistTemp,condition);
			
			
		}catch(Exception e){
			
		}
		//����
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
			
			//�Č��̖��O���擾����
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
	 * @param�@job
	 * @return
	 */
	private	String circularprocess(String curStatus, int memberListSize,JobList job) {
		int finishmember = 0;
		if ("�񗗒�".equals(curStatus)) {
			// �ݒ�t�@�C���̓ǂݍ��݂��s�Ȃ�
			ConfigReader conf = FlowBuilderSystemConfig.getInstance();
			// �W���u�t�@�C���̃p�X���擾����
			String jobFilePath = conf.getValue("jobPath");
			// �h�L�������g���擾����
			Document jobDoc = DBXmlFileConn.getDocument(jobFilePath + "job_" + job.getJobId() + ".xml");
			//�@Circular��NodeList���擾����
			NodeList CircularList = XmlOperator.getNodeList(jobDoc, "Circular");
			//�@Circular�̃G�������g���擾����
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

		//�񗗂̑���
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

				// �h�L�������g�����݂��Ă���ꍇ����
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