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
package flowbuilder.application.jobshow;

import org.w3c.dom.Document;

import fbcom.framework.exceptions.SysException;
import flowbuilder.application.util.JobOprater;
import flowbuilder.application.util.SystemFactroyKey;
import flowbuilder.dao.user.UserDAO;
import flowbuilder.dao.user.UserDataAccessFactroy;
import flowbuilder.daoimpl.db.DBXmlFileConn;
import flowbuilder.daoimpl.db.XmlFileProperity;
import flowbuilder.domain.joblist.JobList;
import flowbuilder.domain.jobshow.JobShow;
import flowbuilder.domain.user.User;

;
/**
 * ���O�C���T�[�r�X�ɋ��ʂ���A�v���P�[�V�����T�[�r�X�̎����N���X <BR>
 */
final class JobShowServiceImpl implements JobShowService {

	/** DAO�t�@�N�g���̐錾 */
	private UserDataAccessFactroy _daoFactory = null;

//	/** DAO�t�@�N�g���̐錾 */
//	private JobListDataAccessFactroy _jobListDaoFactory = null;

	/** ���[�U�[DAO */
	private UserDAO _userDAO;

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
	JobShowServiceImpl() throws SysException {
		//�t�@�C���C���t�H�̎擾
		fileOpr = new XmlFileProperity("Path.Xml.File");
		//�W���u�̑���
		jobOpr = new JobOprater();

		_daoFactory = UserDataAccessFactroy.getFactory(SystemFactroyKey.UserFactroyKey);
//		_jobListDaoFactory = JobListDataAccessFactroy
//				.getFactory(SystemFactroyKey.JobListFactroyKey);
		init();
	}

	/**
	 * ����������
	 */
	private void init() {
		_userDAO = _daoFactory.createUserDAO();
	}

	
	/**
	 * ���i����p�̐V�����W���u�̎擾���āAJSP��ʗp��BEAN��߂�B
	 * 
	 * @param joblist�@�_������p�̃p�����[�^
	 * @param userIp�@���[�UIP
	 * @return�@JSP��ʗp��BEAN
	 * @throws SysException�@
	 *  		�V�X�e���̃G���[���������܂����B<BR>
	 */
	public JobShow getNewJobShow(JobList joblist,String userIp) throws SysException {

		// �Č��ڍ׉�ʃp�����[�^Bean
		JobShow jobshow = new JobShow();

		//�W���u���X�g�̒��ɂ́A�l���擾����
		String strUserID = joblist.getUserId();
		String strJobId = joblist.getJobId();
		String strOrgId = joblist.getOrgId();
		String strTempId = joblist.getTemplateId();

		//���[�U�C���t�H�̎擾
		User user = _userDAO.select(strUserID);
		//������Ԃ̈Č��t�@�C�����쐬����B
		Document newJob = jobOpr.creatDoc(strTempId, strUserID, strOrgId);

		if (newJob != null) {
			//�e���v���[�g�ɑΉ������ʂ��擾����
			String view = fileOpr.getViewByID("template", strTempId);
			//���[�U�̖��O
			String strUserName = user.getUserName();
					
			//�W���u���X�g�L�^�̍쐬
			joblist.setView(view);
			//���[�U�h�c�̐ݒ�
			jobshow.setUserId(strUserID);
			//�g�D�h�c�̐ݒ�
			jobshow.setOrgId(strOrgId);
			//Template ID�̐ݒ�
			jobshow.setTemplateId(strTempId);
			//���[�U���̐ݒ�
			jobshow.setUserName(strUserName);
			//�W���uID�̐ݒ�
			jobshow.setJobId(strJobId);
			//�W���u�h�L�������g�̐ݒ�
			jobshow.setJob(newJob);
			//���[�UIP�̐ݒ�
			jobshow.setUserIp(userIp);		
			//�e���v���[�g�ɑΉ������ʂ̐ݒ�
			jobshow.setView(view);	

		} else {
			new SysException("�e���v���[�g�h�L�������g�̎擾�Ɏ��s���܂����B");
		}
		
		return jobshow;
	}

	/**
	 * �������Č����擾���āAJSP��ʗp��BEAN��߂�B
	 * 
	 * @param joblist�@�_������p�̃p�����[�^
	 * @return�@JSP��ʗp��BEAN
	 * @throws SysException
	 *  		�V�X�e���̃G���[���������܂����B<BR>
	 */
	public JobShow getJobShow(JobList joblist) throws SysException {

		// �Č��ڍ׉�ʃp�����[�^Bean
		JobShow jobshow = new JobShow();

		//�W���u���X�g�̒��ɂ́A�l���擾����
		String strJobId = joblist.getJobId();
		String documentsXML = fileOpr.getJobFileDir(strJobId);
		
		//�Č��t�@�C�����擾����B
		Document doc= DBXmlFileConn.getDocument(documentsXML);
		
		String strTempId = jobOpr.getJobInfo(doc, "tempId");
		String strUserID = jobOpr.getCreatorID(doc);
		String strOrgId = jobOpr.getOrgID(doc);
		
		//���[�U�C���t�H�̎擾
		User user = _userDAO.select(strUserID);
		
		if (doc != null) {
			//�e���v���[�g�ɑΉ������ʂ��擾����
			String view = fileOpr.getViewByID("template", strTempId);
			//���[�U�̖��O
			String strUserName = user.getUserName();
			//�@���[�UIP���擾����
			String strUserIp  = jobOpr.getCreatorIP(doc);

			//���[�U�h�c�̐ݒ�
			jobshow.setUserId(strUserID);
			//�g�D�h�c�̐ݒ�
			jobshow.setOrgId(strOrgId);
			//Template ID�̐ݒ�
			jobshow.setTemplateId(strTempId);
			//���[�U���̐ݒ�
			jobshow.setUserName(strUserName);
			//�W���uID�̐ݒ�
			jobshow.setJobId(strJobId);
			//�W���u�h�L�������g�̐ݒ�
			jobshow.setJob(doc);
			//���[�UIP�̐ݒ�
			jobshow.setUserIp(strUserIp);
			//�e���v���[�g�ɑΉ������ʂ̐ݒ�
			jobshow.setView(view);	

		} else {
			new SysException("�e���v���[�g�h�L�������g�̎擾�Ɏ��s���܂����B");
		}
		
		return jobshow;
	}

}