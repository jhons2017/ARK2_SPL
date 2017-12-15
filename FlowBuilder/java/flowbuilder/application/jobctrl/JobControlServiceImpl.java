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
package flowbuilder.application.jobctrl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.upload.FormFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import fbcom.framework.dao.conf.ConfigReader;
import fbcom.framework.exceptions.SysException;
import flowbuilder.application.util.CodeCreator;
import flowbuilder.application.util.JobOprater;
import flowbuilder.application.util.SystemFactroyKey;
import flowbuilder.application.util.email.EmailSender;
import flowbuilder.dao.conf.FlowBuilderSystemConfig;
import flowbuilder.dao.joblist.JobListDAO;
import flowbuilder.dao.joblist.JobListDataAccessFactroy;
import flowbuilder.dao.joblist.JobListQueryInfo;
import flowbuilder.dao.user.UserDAO;
import flowbuilder.dao.user.UserDataAccessFactroy;
import flowbuilder.daoimpl.db.DBXmlFileConn;
import flowbuilder.daoimpl.db.XmlFileProperity;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.domain.jobctrl.JobControl;
import flowbuilder.domain.jobctrl.JobCtrlParameter;
import flowbuilder.domain.joblist.JobList;
import flowbuilder.domain.user.User;
import flowbuilder.presentation.webcmn.taglibs.common.PartCommon;

;
/**
 * ���O�C���T�[�r�X�ɋ��ʂ���A�v���P�[�V�����T�[�r�X�̎����N���X <BR>
 */
final class JobControlServiceImpl implements JobControlService {
	/** ���O */
	private Log logger = LogFactory.getLog(JobControlServiceImpl.class);

	/** �t�@�C���̃p�[�X */
	private String documentsXML = "";

	/** �h�L�������g */
	private Document docJob = null;

	/** DAO�t�@�N�g���̐錾 */
	private UserDataAccessFactroy _daoFactory = null;

	/** DAO�t�@�N�g���̐錾 */
	private JobListDataAccessFactroy _jobListDaoFactory = null;

	/** ���[�U�[DAO */
	private UserDAO _userDAO;

	/** �W���u���X�gDAO */
	private JobListDAO _jobListDAO;

	/** �t�@�C���C���t�H�̎擾 */
	private XmlFileProperity fileOpr = null;

	/** �W���u�̑��� */
	private JobOprater jobOpr = null;

	/**
	 * �R���X�g���N�^
	 * 
	 * @throws Exception
	 * 
	 * @throws SysException
	 *             �V�X�e���G���[�̏ꍇ
	 * 
	 */
	JobControlServiceImpl() throws SysException {
		// �t�@�C���C���t�H�̎擾
		fileOpr = new XmlFileProperity("Path.Xml.File");
		// �W���u�̑���
		jobOpr = new JobOprater();

		_daoFactory = UserDataAccessFactroy
				.getFactory(SystemFactroyKey.UserFactroyKey);
		_jobListDaoFactory = JobListDataAccessFactroy
				.getFactory(SystemFactroyKey.JobListFactroyKey);
		init();
	}

	/**
	 * ����������
	 */
	private void init() {
		_userDAO = _daoFactory.createUserDAO();
		_jobListDAO = _jobListDaoFactory.createJobListDAO();
	}

	/**
	 * ����t���O�ɂ���āA����̑�������s����B
	 * 
	 * @param jobParameters
	 *            �_������p�̃p�����[�^
	 *            
	 * @throws SysException
	 *             �V�X�e���̃G���[���������܂����B<BR>
	 */
	public synchronized void jobControl(JobCtrlParameter jobParameters) throws SysException {
		try {
			
			// ����t���O���擾����
			String oprFlg = jobParameters.getOprFlg();
			// ����t���O���擾����
			String oprId = jobParameters.getOprId();
			// �W���uID���擾����
			String jobId = jobParameters.getJobId();

			// �W���uID������Ȃ��ꍇ
			if ("".equals(jobId) && "save".equals(oprFlg)) {
				jobId = CodeCreator.getJobNo();
				initDocument(jobParameters,jobId);
			}
			
			// �Č��h�L�������g�֐ڑ�����
			documentsXML = fileOpr.getJobFileDir(jobId);
			docJob = DBXmlFileConn.getDocument(documentsXML);

			// �ۑ��̑���
			if ("save".equals(oprFlg)) {
				// �A�b�v���[�h�ɂ͓��ʂɏ�������
				this.saveUpload(jobParameters, jobId, oprFlg);
				
				//�񗗂̑���
				cirOperater(jobParameters);
				this.saveOperater(jobId, jobParameters.getParameters());
			// �폜�̑���
			} else if ("delete".equals(oprFlg)) {
				this.delOperater(jobId);
			} else if ("disposal".equals(oprFlg)) {
				this.dispoalOperater(jobId);
			}

			if (!("apply".equals(oprId))){
				// �W���u���X�g����
				this.creatORUpdateJobList(oprId,jobParameters,jobId);
				
				// �Č���Ԃ�ύX����
				this.changeStatus(oprFlg, jobParameters.getOprId(), jobParameters
						.getUserId(), jobParameters.getOrgId(), jobId);
				
				this.updateStatus(jobId);
			} else {
				circolarStatus(oprFlg, jobParameters,jobId);
			}	


			// ���[���𑗂�
			this.sendEmail(docJob,jobParameters.getTempId());
		} catch (Exception e) {
			throw new SysException("���삪���s���܂����B");
		}
	}


	/** �񗗈Č���Ԃ�ύX���� */
	private void circolarStatus(String oprFlg,JobCtrlParameter jobParameters,String jobId) {
		// �h�L�������g����񗗐l�ǂ�
		NodeList membersList = XmlOperator.getNodeList(docJob, "member");
		// �擾���O�C�����[�U�̏��
		int len = membersList.getLength();
		//����t���O
		boolean flg = true;
		for(int i = 0; i < len; i++) {
			Element memberEle = (Element) membersList.item(i);
			if(!("3".equals(memberEle.getAttribute("problemFlg")))) {
				flg = false;
				break;
			}
		}
		//�S���ŉ񗗎҂̏�Ԃ������ρA�Č���Ԃ�ύX����
		if(flg){
			this.changeStatus(oprFlg, jobParameters.getOprId(), jobParameters
					.getUserId(), jobParameters.getOrgId(),jobId);
		}

	}
		
	/**
	 * �񗗕��i�̑���
	 * 
	 *  @param docElement
	 *            	�h�L�������g
	 *  @param oprId
	 *            	�񗗕��i�̑���ID
	 *	@param userId
	 *            	���O�C�����[�U                  
	 * @throws SysException 
	 */
	private void cirOperater(JobCtrlParameter parameters) throws SysException {
		// �W���uID���擾����
		String strUserId = parameters.getUserId();
		
		// �W���uID���擾����
		String tempId = parameters.getTempId();
		
		// �W���uID���擾����
		String jobId = parameters.getJobId();
		
		//����t���O���擾����
		String oprId = parameters.getOprId();
		
		//�񗗂̑���
		ConfigReader conf = FlowBuilderSystemConfig.getInstance();
		String className = conf.getValue("Circular");
		//�͌^���ꂢ�I��
		if (className.indexOf(tempId) != -1){
			//�N�Ăƕۑ��̑���
			if("start".equals(oprId) || "save".equals(oprId) || "confirm".equals(oprId)){
				saveCirOperater(jobId, parameters.getParameters());
			//�񗗕��i�̑���
			} else {
				updateCirOperater(docJob, oprId, strUserId);
			}
		}
	}
	
	/**
	 * �񗗕��i�̑���
	 * 
	 *  @param docElement
	 *            	�h�L�������g
	 *  @param oprId
	 *            	�񗗕��i�̑���ID
	 *	@param userId
	 *            	���O�C�����[�U                  
	 * @throws SysException 
	 */
	private void updateCirOperater(Document docElement, String oprId, String userId) throws SysException {
		
		try {
			//�h�L�������g����񗗐l�ǂ�
			NodeList membersList = XmlOperator.getNodeList(docElement, "member");
			//�擾���O�C�����[�U�̏��
			for(int i = 0; i < membersList.getLength(); i++) {
				Element memberEle = XmlOperator.getElement(membersList, i);
				if(XmlOperator.getAttrValue(memberEle,"id").equals(userId)){
					//�񗗂̑�����AproblemFlg�̒l���C��
					if ("apply".equals(oprId)){
						XmlOperator.setAttrValue(memberEle,"problemFlg","3");
						XmlOperator.setAttrValue(memberEle,"confirmDate",PartCommon.getCurTime());
					}else if ("kakuninn".equals(oprId)) {
						XmlOperator.setAttrValue(memberEle,"problemFlg","1");
						XmlOperator.setAttrValue(memberEle,"confirmDate",PartCommon.getCurTime());
					}else if ("question".equals(oprId)) {
						XmlOperator.setAttrValue(memberEle,"problemFlg","2");
						XmlOperator.setAttrValue(memberEle,"confirmDate",PartCommon.getCurTime());
					}
					break;
				}
			}
		} catch (Exception e) {
			throw new SysException("���삪���s���܂����B");
		}

	}
	
	/**
	 * �񗗏���ۑ�
	 *  @param jobId
	 *           �t�@�C��ID�擾 	
	 *  @param parameters
	 *            	�_������p�̃p�����[�^
	 */
	private void saveCirOperater(String jobId, List<JobControl> parameters) {
		
		//�@�񗗃��[�UID�擾
		String strUsersId = "";
		
		//�񗗃��[�UID���X�g
		String[] arrayUsers;
		
		//����
		JobOprater jobOprater = new JobOprater();
		
		try {
			int len = parameters.size();
			for(int i = 0; i < len; i++) {
				//circularID�̏��擾
				if("circularID".equals(((JobControl)parameters.get(i)).getParamName())) {
					
					//�@�񗗃��[�UID�擾
					strUsersId = ((JobControl)parameters.get(i)).getParamValue();
					break;
				}
			}
			
			//�񗗃��[�UID���X�g
			if(!"".equals(strUsersId)){
				arrayUsers = strUsersId.split(",");
				//�񗗂�������n��
				jobOprater.creatUserXml(docJob,arrayUsers);
			}
						
		} catch (Exception e) {
			// �i���ۏ�
			logger.info("�Č��ēx�ۑ��Ɏ��s���܂����B");
		}

	}
	
	/**
	 * �ۑ��̑���
	 */
	private void saveOperater(String jobId, List<JobControl> parameters) {

		// �Č��h�L�������g��ۑ�
		if (jobOpr.saveDocXml(docJob, parameters)) {

			// XML�t�@�C����ۑ�����
			DBXmlFileConn.writeXml(docJob, documentsXML);
		} else {
			// �i���ۏ�
			logger.info("�Č��ēx�ۑ��Ɏ��s���܂����B");
		}
	}

	/**
	 * �폜�̑���
	 * 
	 * @throws
	 */
	private void delOperater(String jobId) {
		try {
			if (jobId != null && !"".equals(jobId)) {
				// �Č����X�g����Č��폜
				_jobListDAO.delete(jobId);
			}
		} catch (Exception e) {
			logger.error("�Č��폜�͎��s���܂����B");
		}
	}

	/**
	 * �j���̑���
	 */
	private void dispoalOperater(String jobId) {
		try {
			File delFile = new File(documentsXML);
			// �W���u���X�g�̍폜
			this.delOperater(jobId);
			// �W���u�t�@�C�����폜���܂����B
			delFile.delete();
			// �Č����X�g����Č��폜
			_jobListDAO.delete(jobId);
		} catch (Exception e) {
			logger.error("�Č��j���͎��s���܂����B");
		}
	}

	/** �Č���Ԃ�ύX���� */
	private void changeStatus(String oprflg, String strOperator,
			String strUserId, String orgId, String jobId) {
		
		JobListQueryInfo _joblistQueryInfo = _jobListDaoFactory.createJobListQueryInfo();
		
		// �X�V�̃��X�g
		List<JobList> joblist = null;
		JobList jobRecord  = null;
		try {
			// ���������̐ݒ�
			_joblistQueryInfo.setJobId(jobId);

			// ���������s����
			joblist = _jobListDAO.getJobList(_joblistQueryInfo);
			
			if(joblist.size() != 0) {
				jobRecord = joblist.get(0);
			} else {
				jobRecord = new JobList();
			}

			if (!oprflg.equals("disposal")) {
				// �Č��t���[�̏�ԑJ��
				jobOpr.changeFlowState(docJob, strOperator, strUserId, orgId,
						jobRecord);

				// �Č�XML�t�@�C����ۑ�����
				DBXmlFileConn.writeXml(docJob, documentsXML);
			}
		} catch (Exception e) {
			logger.error("�Č���Ԃ�ύX����͎̂��s���܂����B");
		}
	}

	/**
	 * �h�L�������g�̏���������
	 * 
	 * @param jobParameters
	 * @throws SysException
	 */
	private void initDocument(JobCtrlParameter jobParameters,String jobId)
			throws SysException {
		// ������Ԃ̈Č��t�@�C�����쐬����B
		Document newJob = jobOpr.creatDoc(jobParameters.getTempId(),
				jobParameters.getUserId(), jobParameters.getOrgId());
		
		// �V�����Č��t�@�C���̕ۑ��ꏊ
		String strJobFileName = fileOpr.createJobFileDir(jobId);

		User user = _userDAO.select(jobParameters.getUserId());

		// �V�����Č��̃W���u�C���t�H�̒ǉ�
		jobOpr.createNewJob(newJob, jobParameters.getUserId(), user
				.getUserName(), jobParameters.getOrgId(), jobParameters
				.getRoleId(), jobId, jobParameters.getUserIp(), jobParameters
				.getTempId());

		// XML�t�@�C����ۑ�����
		DBXmlFileConn.writeXml(newJob, strJobFileName);
	}

	/**
	 * �A�b�v���[�h�ɂ͓��ʂɏ�������
	 * @param jobParameters
	 * @return
	 */
	private void saveUpload(JobCtrlParameter jobParameters, String jobId,
			String oprFlg) {
		
		// �Č���Ԃ��擾
		String jobCurStatus = jobOpr.getCurrentState(docJob);		
		String documentsXML = fileOpr.getJobFileDir(jobId);
		Document doc= DBXmlFileConn.getDocument(documentsXML);
		
		// �Č���ԍX�V����擾
		int jobFileChild2 = jobOpr.getStep(doc, jobCurStatus);
		
		if (jobParameters == null || jobId == null) {
			new SysException("�A�b�v���[�h�����s���܂����B");
		}
		
		//�@�A�b�v���[�h���Ȃ�
		int flag = 0;

		FormFile[] files = jobParameters.getFiles();
		
		// �t�@�C���̒��x���擾����
		int length = files.length;

		for( int i = 0; i < length; i++) {
			if(files[i] == null) {
				continue;
			} else if (!"".equals(files[i].getFileName())) {
					// �t�@�C�����I��
					flag = 1;
					break;
			}

			// �t�@�C�����I�΂Ȃ�
			flag = 2;
		}
		
		
		if (flag != 0) {
			ConfigReader conf = FlowBuilderSystemConfig.getInstance();
			String jobFilePath = conf.getValue("loadPath");

			// �V�����t�H���_�̒ǉ�
			File file = new File(jobFilePath + jobId);

			String jobFileChild = jobFilePath + jobId;

			// �܂��W���uID�ɂ���āA�t�H���_�̒��ɂ͍폜����
			deleteFile(jobId, file, jobCurStatus, jobFileChild, jobFileChild2);

			if (flag == 1) {
				uploadFile(files, file, jobParameters, jobFileChild, jobCurStatus, jobId, jobFileChild2);
			}
		}
	}
	
	/**
	 * �t�@�C���̃A�b�v���[�h
	 * @param FormFile[]�@files�@�t�@�C��
	 * @param file�@File�@�t�@�C��
	 * @param jobParameters
	 */
	private void uploadFile(FormFile[] files, File file,
			JobCtrlParameter jobParameters, String jobFileChild,
			String jobCurStatus, String jobId, int jobFileChild2) {
	
		List<JobControl> jobControls = new ArrayList<JobControl>();
		JobControl jobCtrl = null;
		int length = jobParameters.getParameters().size();
		
		for(int i=0; i < length; i++){
			jobCtrl = new JobControl();
			jobCtrl.setParamName(jobParameters.getParameters().get(i).getParamName());
			jobCtrl.setParamValue(jobParameters.getParameters().get(i).getParamValue());
			jobControls.add(jobCtrl);
		}


		try {

			// �V�����t�H���_�̒ǉ�
			file.mkdir();
			File file2 = new File(jobFileChild + "//" + jobFileChild2);
			file2.mkdir();

			// �A�b�v���[�h
			for (int i = 0; i < files.length; i++) {
				if (files[i] != null && !"".equals(files[i].getFileName())) {

					// �t�@�C�����擾����
					InputStream stream = files[i].getInputStream();

					// �V�����t�@�C���̎擾����
					OutputStream bos = new FileOutputStream(file2.getPath()
							+ "/"
							+ getUUidFileName(files[i].getFileName(),
									jobControls));
					int bytesRead = 0;
					byte[] buffer = new byte[8192];

					// �t�@�C�������
					while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
						bos.write(buffer, 0, bytesRead);
					}
					bos.close();
					stream.close();
					
					//�@�t�@�C�����O���폜����
					
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
	
	/**
	 * UUID�t�@�C�����O���擾����
	 * 
	 * @param fileName �t�@�C�����O
	 * @param jobParameters �p�����[�^
	 * @return String uuidFileName uuid�t�@�C�����O
	 */
	private String getUUidFileName(String fileName,
			List<JobControl> jobControls) {
		String uuidFileName = "";

		int length = jobControls.size();

		boolean controlFlg = true;

		for (int index = 0; controlFlg && index < length; index++) {
			String paramValue = jobControls.get(index).getParamValue();
			if (fileName.equals(paramValue)) {
				uuidFileName = jobControls.get(index).getParamName();
				jobControls.get(index).setParamValue("");
				controlFlg = false;
			}
		}
		return uuidFileName;
	}
	
	
	/**
	 * �t�H���_�̒��ɂ͍폜����
	 * 
	 * @param String jobId �W���u�pID
	 * @param file  File �t�@�C��
	 */
	private void deleteFile(String jobId, File file, String jobCurStatus,
			String jobFileChild, int jobFileChild2) {

		// �܂��W���uID�ɂ���āA�t�H���_�̒��ɂ͍폜����
		try {
			ConfigReader conf = FlowBuilderSystemConfig.getInstance();

			File fileAll = new File(jobFileChild + "//" + jobFileChild2);

			String jobFilePath = conf.getValue("loadPath");
			// �t�@�C���폜���܂�
			if (!fileAll.isDirectory()) {
				fileAll.delete();
				file.delete();

				// �t�@�C���폜���܂�
			} else if (fileAll.isDirectory()) {
				String[] filelist = fileAll.list();
				int filelistlength = filelist.length;
				for (int i = 0; i < filelistlength; i++) {
					File delFile = new File(jobFilePath + jobId + "\\" + jobFileChild2 + "\\" + filelist[i]);

					// �t�H���_�폜���܂�
					if (!delFile.isDirectory())
						delFile.delete();

					// �t�H���_�폜���܂�
					else if (delFile.isDirectory())
						deleteFile(jobFilePath + jobId + "\\" + jobFileChild2 + "\\" + filelist[i], file, jobCurStatus,
								jobFileChild, jobFileChild2);
				}
				fileAll.delete();
				file.delete();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 
	 * @param doc
	 * @param jobId
	 */
	private void sendEmail(Document doc,String templateId){
		
		if(doc != null){
			String curState = jobOpr.getCurrentState(doc);
			EmailSender emailSender = new EmailSender(templateId,curState,doc);
			Thread thread = new Thread(emailSender);
			thread.start();
		}
	}
	
	
	private void creatORUpdateJobList(String oprFlg,JobCtrlParameter jobParameters,String jobId){
		JobListQueryInfo _joblistQueryInfo = _jobListDaoFactory.createJobListQueryInfo();
		
		// �X�V�̃��X�g
		List<JobList> joblist = null;
		JobList jobRecord = null;
		
		if("save".equals(oprFlg) || "confirm".equals(oprFlg) || "start".equals(oprFlg)) {
			try{
				// ���������̐ݒ�
				_joblistQueryInfo.setJobId(jobId);
		
				// ���������s����
				joblist = _jobListDAO.getJobList(_joblistQueryInfo);
				
				// �V�K���
				if(joblist.size() == 0) {
					jobRecord = new JobList();
					
					// �e���v���[�g�ɑΉ������ʂ��擾����
					String view = fileOpr.getViewByID("template", jobParameters.getTempId());
	
					// �W���uID
					jobRecord.setJobId(jobId);
					// �W���u���O
					jobRecord.setJobName(jobParameters.getJobName());
					// �N�Ďґg�DID
					jobRecord.setOrgId(jobParameters.getOrgId());
					// �N�Ď҃��[��ID
					jobRecord.setRoleId(jobParameters.getRoleId());
					// �e���v���[�gID
					jobRecord.setTemplateId(jobParameters.getTempId());
					// ���[�UID
					jobRecord.setUserId(jobParameters.getUserId());

					jobRecord.setView(view);
	
					// �W���u���X�g�L�^�̒ǉ�
					_jobListDAO.insert(jobRecord);
				//�@�X�V���
				}else {
					jobRecord = joblist.get(0);
					
					String jobName = jobParameters.getJobName();
					if(!"".equals(jobName)) {
						jobRecord.setJobName(jobName);
					}
					
					//�Ή��ꗗ�Č������L������
					_jobListDAO.update(jobRecord);
				}
			} catch(Exception e){
				logger.fatal("JobControlService: CreatORUpdateJobList �G���[");
				logger.fatal(e.getMessage());
			}
		}
	}
	
	// �X�V�W���u���X�g���
	private void updateStatus(String jobId) {
		JobListQueryInfo _joblistQueryInfo = _jobListDaoFactory.createJobListQueryInfo();
		
		// ���������̐ݒ�
		_joblistQueryInfo.setJobId(jobId);
		
		// ���������s����
		try {
			List<JobList> joblist = _jobListDAO.getJobList(_joblistQueryInfo);
			// �V�K���
			if(joblist.size() != 0) {
				JobList jobRecord = joblist.get(0);
				//�@�����
				jobRecord.setCurStatus(jobOpr.getCurrentState(docJob));
				
				_jobListDAO.update(jobRecord);
			}
		} catch (SysException e) {
			logger.fatal("JobControlService: updateStatus �G���[");
			logger.fatal(e.getMessage());
		}
	}
}