/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/26
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/04/26 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.daoimpl.flowbuilder.joblist;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import fbcom.framework.exceptions.SysException;
import fbcom.framework.exceptions.XmlAccessSysException;
import flowbuilder.dao.joblist.JobListDAO;
import flowbuilder.dao.joblist.JobListQueryInfo;
import flowbuilder.daoimpl.db.DBXmlFileConn;
import flowbuilder.daoimpl.db.XmlFileProperity;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.domain.joblist.JobList;

/**
 * �W���u���X�g�t�@�C����DAO�������������B
 */
final class JobListDAOImpl implements JobListDAO {
	/**
	 * ���M���O
	 */
	private static Log _log = LogFactory.getLog(JobListDAOImpl.class);
	
	/**
	 * �t�@�C���̃p�[�X
	 */
	private String jobListXmlPath = "";

	/**
	 * �ujob.xml�v�t�@�C����ڑ����A�h�L�������g���擾����B
	 */
	public JobListDAOImpl() {
		// �t�@�C������̃N���X�𐶐�����B
		XmlFileProperity fileconn = new XmlFileProperity("Path.Xml.File");

		// �t�@�C���̃p�[�X���擾����B
		jobListXmlPath = fileconn.getFileDir("manage", "job_list.xml");
	}

	/**
	 * �����ɂ���āA�W���u���X�g�ŋL�^�̐��ʂ�߂�
	 * 
	 * @param query
	 *            ��������
	 * @return �W���u���X�g�ŋL�^�̐���
	 * @throws SysException
	 *             xml�t�@�C���ɑ���̂����ɁA�G���[����������
	 */
	public int getCount(JobListQueryInfo query) throws SysException {
		// �h�L�������g�̎擾
		Document filedoc = DBXmlFileConn.getDocument(jobListXmlPath);
		
		// �W���u���X�g�ŋL�^�̐���
		int jobCount = 0;

		// �����͂ł͂Ȃ�
		if (query == null) {
			_log.error("�uJobListQueryInfo�v�͂ł͂Ȃ��A�G���[���������܂����B");
			throw new SysException("�uJobListQueryInfo�v�͂ł͂Ȃ��A�G���[���������܂����B");
		}

		try {
			// �K�v��NodeList���擾����
			NodeList jobNodeList = XmlOperator.getNodeList(filedoc, "job");

			int jobListLength = jobNodeList.getLength();

			for (int i = 0; i < jobListLength; i++) {
				Element jobListElm = (Element) jobNodeList.item(i);

				// ���݂̑g�D���ׂ�B
				if (query.getCurOrg() != null) {
					// �������������Ȃ�
					if (!compareQuenInfo(jobListElm, query.getCurOrg(), "cur_org")) {
						continue;
					}
				}

				// ���݂̃��[�����ׂ�B
				if (query.getCurRole() != null) {
					// �������������Ȃ�
					if (!compareQuenInfo(jobListElm, query.getCurRole(), "cur_role")) {
						continue;
					}
				}

				// ���݂̏�Ԃ��ׂ�B
				if (query.getCurStatus() != null) {
					// �������������Ȃ�
					if (!compareQuenInfo(jobListElm, query.getCurStatus(), "cur_status")) {
						continue;
					}
				}

				// �Č��̋N�ē����ׂ�B
				if (query.getDate() != null) {
					// �������������Ȃ�
					if (!compareQuenInfo(jobListElm, query.getDate(), "date")) {
						continue;
					}
				}

				// �Č�ID���ׂ�B
				if (query.getJobId() != null) {
					// �������������Ȃ�
					if (!compareQuenInfo(jobListElm, query.getJobId(), "jobid")) {
						continue;
					}
				}

				// �Č����O���ׂ�B
				if (query.getJobName() != null) {
					// �������������Ȃ�
					if (!compareQuenInfo(jobListElm, query.getJobName(), "name")) {
						continue;
					}
				}

				// �N�Ďґg�DID���ׂ�B
				if (query.getOrgId() != null) {
					// �������������Ȃ�
					if (!compareQuenInfo(jobListElm, query.getOrgId(), "orgid")) {
						continue;
					}
				}

				// �N�Ď҃��[��ID���ׂ�B
				if (query.getRoleId() != null) {
					// �������������Ȃ�
					if (!compareQuenInfo(jobListElm, query.getRoleId(), "roleid")) {
						continue;
					}
				}

				// �e���v���[�gID���ׂ�B
				if (query.getTemplateId() != null) {
					// �������������Ȃ�
					if (!compareQuenInfo(jobListElm, query.getTemplateId(), "templateid")) {
						continue;
					}
				}

				// �N�Ď�ID���ׂ�B
				if (query.getUserId() != null) {
					// �������������Ȃ�
					if (!compareQuenInfo(jobListElm, query.getUserId(), "userid")) {
						continue;
					}
				}

				// �Č��ɑΉ�������ID���ׂ�B
				if (query.getView() != null) {
					// �������������Ȃ�
					if (!compareQuenInfo(jobListElm, query.getView(), "view")) {
						continue;
					}
				}

				jobCount++;
			}

		} catch (NullPointerException e) {
			_log.error(e.getMessage(), e);
			throw new XmlAccessSysException("Error.File.DataAccessFail");
		}

		//�L�^��߂�
		return jobCount;
	}

	/**
	 * �W���u���X�g���擾����
	 * 
	 * @param query
	 *            ��������
	 * @return �W���u�L�^���i�[�������X�g
	 * @throws SysException
	 *             xml�t�@�C���ɑ���̂����ɁA�G���[����������
	 */
	public List<JobList> getJobList(JobListQueryInfo query) throws SysException {
		// �h�L�������g�̎擾
		Document filedoc = DBXmlFileConn.getDocument(jobListXmlPath);
		
		// �W���u���X�g�ŋL�^���i�[����
		List<JobList> jobList = new ArrayList<JobList>();

		// �����͂ł͂Ȃ�
		if (query == null) {
			_log.error("�uJobListQueryInfo�v�͂ł͂Ȃ��A�G���[���������܂����B");
			throw new SysException("�uJobListQueryInfo�v�͂ł͂Ȃ��A�G���[���������܂����B");
		}

		try {
			// �K�v��NodeList���擾����
			NodeList jobNodeList = XmlOperator.getNodeList(filedoc, "job");

			int jobListLength = jobNodeList.getLength();

			for (int i = 0; i < jobListLength; i++) {
				Element jobListElm = (Element) jobNodeList.item(i);

				// ���݂̑g�D���ׂ�B
				if (query.getCurOrg() != null) {
					// �������������Ȃ�
					if (!compareQuenInfo(jobListElm, query.getCurOrg(), "cur_org")) {
						continue;
					}
				}

				// ���݂̃��[�����ׂ�B
				if (query.getCurRole() != null) {
					// �������������Ȃ�
					if (!compareQuenInfo(jobListElm, query.getCurRole(), "cur_role")) {
						continue;
					}
				}

				// ���݂̏�Ԃ��ׂ�B
				if (query.getCurStatus() != null) {
					// �������������Ȃ�
					if (!compareQuenInfo(jobListElm, query.getCurStatus(), "cur_status")) {
						continue;
					}
				}

				// �Č��̋N�ē����ׂ�B
				if (query.getDate() != null) {
					// �������������Ȃ�
					if (!compareQuenInfo(jobListElm, query.getDate(), "date")) {
						continue;
					}
				}

				// �Č�ID���ׂ�B
				if (query.getJobId() != null) {
					// �������������Ȃ�
					if (!compareQuenInfo(jobListElm, query.getJobId(), "jobid")) {
						continue;
					}
				}

				// �Č����O���ׂ�B
				if (query.getJobName() != null) {
					// �������������Ȃ�
					if (!compareQuenInfo(jobListElm, query.getJobName(), "name")) {
						continue;
					}
				}

				// �N�Ďґg�DID���ׂ�B
				if (query.getOrgId() != null) {
					// �������������Ȃ�
					if (!compareQuenInfo(jobListElm, query.getOrgId(), "orgid")) {
						continue;
					}
				}

				// �N�Ď҃��[��ID���ׂ�B
				if (query.getRoleId() != null) {
					// �������������Ȃ�
					if (!compareQuenInfo(jobListElm, query.getRoleId(), "roleid")) {
						continue;
					}
				}

				// �e���v���[�gID���ׂ�B
				if (query.getTemplateId() != null) {
					// �������������Ȃ�
					if (!compareQuenInfo(jobListElm, query.getTemplateId(), "templateid")) {
						continue;
					}
				}

				// �N�Ď�ID���ׂ�B
				if (query.getUserId() != null) {
					// �������������Ȃ�
					if (!compareQuenInfo(jobListElm, query.getUserId(), "userid")) {
						continue;
					}
				}

				// �Č��ɑΉ�������ID���ׂ�B
				if (query.getView() != null) {
					// �������������Ȃ�
					if (!compareQuenInfo(jobListElm, query.getView(), "view")) {
						continue;
					}
				}

				//�ۑ�����
				jobList.add(retJob(jobListElm));
			}

		} catch (NullPointerException e) {
			_log.error(e.getMessage(), e);
			throw new XmlAccessSysException("Error.File.DataAccessFail");
		}

		//�L�^��߂�
		return jobList;
	}

	/**
	 * �W���u���X�g��ǉ�����
	 * 
	 * @param joblist
	 *            �W���u�L�^
	 * @throws SysException
	 *             xml�t�@�C���ɑ���̂����ɁA�G���[����������
	 */
	public void insert(JobList joblist) throws SysException {
		// �h�L�������g�̎擾
		Document filedoc = DBXmlFileConn.getDocument(jobListXmlPath);
		
		try {
			if (filedoc != null && joblist != null) {
				Attr newArrId;

				// Documents�G�������g���擾����
				Element JobListElement = XmlOperator.getElement(XmlOperator.getNodeList(filedoc,
						"joblist"), 0);

				if (JobListElement == null) {
					// �i���ۏ�
					_log.info("�V�����G�������g�̍쐬�Ɏ��s���܂����B");
				}

				// *****************************************************************************

				// �V�����h�L�������g�G�������g���쐬����
				Element newJobElement = XmlOperator.createElement(filedoc, "job", "");

				if (newJobElement == null) {
					// �i���ۏ�
					_log.info("�V�����G�������g�̍쐬�Ɏ��s���܂����B");
				}

				// =============================================================================

				// �����m�[�h���쐬����
				newArrId = XmlOperator.createAttrbute(filedoc, "name", joblist.getJobName());

				if (newArrId == null) {
					// �i���ۏ�
					_log.info("name �����m�[�h�̍쐬�Ɏ��s���܂����B");
				}

				// �V�����h�L�������g�G�������g�ɑ����m�[�h��ݒ肷��
				if (!XmlOperator.setAttrNode(newJobElement, newArrId)) {
					// �i���ۏ�
					_log.info("name �����̐ݒ�Ɏ��s���܂����B");
				}

				// �����m�[�h���쐬����
				newArrId = XmlOperator.createAttrbute(filedoc, "jobid", joblist.getJobId());

				if (newArrId == null) {
					// �i���ۏ�
					_log.info("jobid �����m�[�h�̍쐬�Ɏ��s���܂����B");
				}

				// �V�����h�L�������g�G�������g�ɑ����m�[�h��ݒ肷��
				if (!XmlOperator.setAttrNode(newJobElement, newArrId)) {
					// �i���ۏ�
					_log.info("jobid �����̐ݒ�Ɏ��s���܂����B");
				}

				// �����m�[�h���쐬����
				newArrId = XmlOperator.createAttrbute(filedoc, "view", joblist.getView());

				if (newArrId == null) {
					// �i���ۏ�
					_log.info("view �����m�[�h�̍쐬�Ɏ��s���܂����B");
				}

				// �V�����h�L�������g�G�������g�ɑ����m�[�h��ݒ肷��
				if (!XmlOperator.setAttrNode(newJobElement, newArrId)) {
					// �i���ۏ�
					_log.info("view �����̐ݒ�Ɏ��s���܂����B");
				}

				// �����m�[�h���쐬����
				newArrId = XmlOperator.createAttrbute(filedoc, "userid", joblist.getUserId());

				if (newArrId == null) {
					// �i���ۏ�
					_log.info("userid �����m�[�h�̍쐬�Ɏ��s���܂����B");
				}

				// �V�����h�L�������g�G�������g�ɑ����m�[�h��ݒ肷��
				if (!XmlOperator.setAttrNode(newJobElement, newArrId)) {
					// �i���ۏ�
					_log.info("userid �����̐ݒ�Ɏ��s���܂����B");
				}

				// �����m�[�h���쐬����
				newArrId = XmlOperator.createAttrbute(filedoc, "orgid", joblist.getOrgId());

				if (newArrId == null) {
					// �i���ۏ�
					_log.info("orgid �����m�[�h�̍쐬�Ɏ��s���܂����B");
				}

				// �V�����h�L�������g�G�������g�ɑ����m�[�h��ݒ肷��
				if (!XmlOperator.setAttrNode(newJobElement, newArrId)) {
					// �i���ۏ�
					_log.info("orgid �����̐ݒ�Ɏ��s���܂����B");
				}

				// �����m�[�h���쐬����
				newArrId = XmlOperator.createAttrbute(filedoc, "roleid", joblist.getRoleId());

				if (newArrId == null) {
					// �i���ۏ�
					_log.info("roleid �����m�[�h�̍쐬�Ɏ��s���܂����B");
				}

				// �V�����h�L�������g�G�������g�ɑ����m�[�h��ݒ肷��
				if (!XmlOperator.setAttrNode(newJobElement, newArrId)) {
					// �i���ۏ�
					_log.info("roleid �����̐ݒ�Ɏ��s���܂����B");
				}

				// �����m�[�h���쐬����
				newArrId = XmlOperator.createAttrbute(filedoc, "cur_org", "");

				if (newArrId == null) {
					// �i���ۏ�
					_log.info("cur_org �����m�[�h�̍쐬�Ɏ��s���܂����B");
				}

				// �V�����h�L�������g�G�������g�ɑ����m�[�h��ݒ肷��
				if (!XmlOperator.setAttrNode(newJobElement, newArrId)) {
					// �i���ۏ�
					_log.info("cur_org �����̐ݒ�Ɏ��s���܂����B");
				}

				// �����m�[�h���쐬����
				newArrId = XmlOperator.createAttrbute(filedoc, "cur_role", "");

				if (newArrId == null) {
					// �i���ۏ�
					_log.info("cur_role �����m�[�h�̍쐬�Ɏ��s���܂����B");
				}

				// �V�����h�L�������g�G�������g�ɑ����m�[�h��ݒ肷��
				if (!XmlOperator.setAttrNode(newJobElement, newArrId)) {
					// �i���ۏ�
					_log.info("cur_role �����̐ݒ�Ɏ��s���܂����B");
				}

				// �����m�[�h���쐬����
				newArrId = XmlOperator.createAttrbute(filedoc, "date", joblist.getDate());

				if (newArrId == null) {
					// �i���ۏ�
					_log.info("date �����m�[�h�̍쐬�Ɏ��s���܂����B");
				}

				// �V�����h�L�������g�G�������g�ɑ����m�[�h��ݒ肷��
				if (!XmlOperator.setAttrNode(newJobElement, newArrId)) {
					// �i���ۏ�
					_log.info("date �����̐ݒ�Ɏ��s���܂����B");
				}

				// �����m�[�h���쐬����
				newArrId = XmlOperator
						.createAttrbute(filedoc, "cur_status", joblist.getCurStatus());

				if (newArrId == null) {
					// �i���ۏ�
					_log.info("cur_status �����m�[�h�̍쐬�Ɏ��s���܂����B");
				}

				// �V�����h�L�������g�G�������g�ɑ����m�[�h��ݒ肷��
				if (!XmlOperator.setAttrNode(newJobElement, newArrId)) {
					// �i���ۏ�
					_log.info("cur_status �����̐ݒ�Ɏ��s���܂����B");
				}

				// �����m�[�h���쐬����
				newArrId = XmlOperator.createAttrbute(filedoc, "templateid", joblist
						.getTemplateId());

				if (newArrId == null) {
					// �i���ۏ�
					_log.info("templateid �����m�[�h�̍쐬�Ɏ��s���܂����B");
				}

				// �V�����h�L�������g�G�������g�ɑ����m�[�h��ݒ肷��
				if (XmlOperator.setAttrNode(newJobElement, newArrId)) {
					// *****************************************************************************
					// �m�[�h�̎q�m�[�h�̃��X�g�̖����ɁA�V�����h�L�������g�m�[�h��ǉ����܂��B
					if (XmlOperator.appendElementNode(JobListElement, newJobElement)) {
						// XML�t�@�C����ۑ�����

						// �i���ۏ�
						_log.info("�Č��ꗗ�w�l�k�t�@�C�����F" + jobListXmlPath);

						DBXmlFileConn.writeXml(filedoc, jobListXmlPath);
					}
				}
			} else {

				// �i���ۏ�
				_log.info("�Č��ꗗ�w�l�k�h�L�������g�����Ɏ��s���܂����B");
			}

			// �i���ۏ�
			_log.info("�I��");
		} catch (Exception e) {

			// �i���ۏ�
			_log.fatal("�v���I�ȃG���[");

		}
	}

	/**
	 * �W���u���X�g�̍X�V
	 * 
	 * @param joblist
	 *            �W���u�L�^
	 * @throws SysException
	 *             xml�t�@�C���ɑ���̂����ɁA�G���[����������
	 */
	public void update(JobList joblist) throws SysException {
		// �h�L�������g�̎擾
		Document filedoc = DBXmlFileConn.getDocument(jobListXmlPath);
		
		String strId = joblist.getJobId();

		try {

			if (filedoc != null) {
				// �K�v��NodeList���擾����
				NodeList jobNodeList = XmlOperator.getNodeList(filedoc, "job");

				int size = jobNodeList.getLength();

				// �����J�n
				for (int i = 0; i < size; i++) {
					// �Č��G�������g���擾����
					Element jobElement = (Element) jobNodeList.item(i);

					// �Č��h�c���擾���A��r
					if (strId.equals(jobElement.getAttribute("jobid"))) {
						// �����l��ݒ肷��
						if (this.updateElement(joblist, jobElement)) {
							// XML�t�@�C����ۑ�����
							DBXmlFileConn.writeXml(filedoc, jobListXmlPath);
						} else {
							// �i���ۏ�
							_log.info("�Č����X�g�h�L�������g�X�V�Ɏ��s���܂����B");
						}

						// �I����
						break;
					}
				}
			} else {
				// �i���ۏ�
				_log.info("�Č����X�g�h�L�������g�����Ɏ��s���܂����B");
			}
		} catch (Exception e) {
			// �i���ۏ�
			_log.fatal("�v���I�ȃG���[");
		}
	}
	
	/**
	 * ���X�g���Č��폜
	 * 
	 * @param strJobId
	 *            �W���uID
	 * @throws SysException
	 *             xml�t�@�C���ɑ���̂����ɁA�G���[����������
	 */
	public void delete(String strJobId) throws SysException {
		// �h�L�������g�̎擾
		Document filedoc = DBXmlFileConn.getDocument(jobListXmlPath);
		
		try {

			// �h�L�������g�����݂��Ă���ꍇ����
			if (filedoc != null) {
				// �K�v��NodeList���擾����
				NodeList jobList = XmlOperator.getNodeList(filedoc, "job");
				int size = jobList.getLength();

				// �����J�n
				for (int i = 0; i < size; i++) {

					// �Č��G�������g���擾����
					Element jobElement = (Element) jobList.item(i);

					// �Č��h�c���擾����
					if (strJobId.equals(jobElement.getAttribute("jobid"))) {

						// Top�G�������g���擾����
						Element topDoc = XmlOperator.getElement(XmlOperator.getNodeList(filedoc,
								"joblist"), 0);

						// �G�������g�m�[�h���폜����
						XmlOperator.removeElementNode(topDoc, jobElement);

						// �Č��ꗗ��ۑ�����
						DBXmlFileConn.writeXml(filedoc, jobListXmlPath);

						break;
					}
				}
			} else {

				// �i���ۏ�
				_log.info("�Č����X�g�h�L�������g������܂���B");
			}

			// �i���ۏ�
			_log.info("�I��");
		}

		catch (Exception e) {

			// �i���ۏ�
			_log.fatal("�v���I�ȃG���[");

		}
	}

	/**
	 * �X�V�W���u�G�������g
	 * 
	 * @param joblist
	 *            �X�V�p�̃W���u���X�g
	 * @param jobElement
	 *            �W���u�G�������g
	 * @return �X�V�𐬌����邩�ǂ���
	 */
	protected boolean updateElement(JobList joblist, Element jobElement) {
		boolean result = false;

		if (joblist != null && jobElement != null) {

			XmlOperator.setAttrValue(jobElement, "cur_org", joblist.getCurOrg());

			XmlOperator.setAttrValue(jobElement, "cur_role", joblist.getCurRole());

			XmlOperator.setAttrValue(jobElement, "cur_status", joblist.getCurStatus());

			XmlOperator.setAttrValue(jobElement, "jobid", joblist.getJobId());

			XmlOperator.setAttrValue(jobElement, "name", joblist.getJobName());

			XmlOperator.setAttrValue(jobElement, "orgid", joblist.getOrgId());

			XmlOperator.setAttrValue(jobElement, "roleid", joblist.getRoleId());

			XmlOperator.setAttrValue(jobElement, "templateid", joblist.getTemplateId());

			XmlOperator.setAttrValue(jobElement, "userid", joblist.getUserId());

			XmlOperator.setAttrValue(jobElement, "view", joblist.getView());

			XmlOperator.setAttrValue(jobElement, "date", joblist.getDate());

			result = true;
		}

		return result;
	}

	/**
	 * �����̒l�ƃv���p�e�B���ׂ�
	 * 
	 * @param jobElm
	 *            �W���u���X�g�̃G�������g
	 * @param quenInfo
	 *            �����̒l
	 * @param attId
	 *            �������t�@�C���Ńm�[�h�̃v���p�e�B
	 */
	private boolean compareQuenInfo(Element jobElm, String quenInfo, String attId) {
		String strValue = XmlOperator.getAttrValue(jobElm, attId);

		if (quenInfo.equals(strValue)) {
			return true;
		}

		return false;
	}

	/**
	 * �W���u���X�g��BEAN�֊i�[����
	 * 
	 * @param jobElm
	 *            �W���u���X�g�̃G�������g
	 * @return �W���u���X�g��BEAN
	 */
	private JobList retJob(Element jobElm) {
		JobList joblist = null;

		if (jobElm != null) {
			joblist = new JobList();

			//�ۑ�����
			joblist.setCurOrg(XmlOperator.getAttrValue(jobElm, "cur_org"));
			joblist.setCurRole(XmlOperator.getAttrValue(jobElm, "cur_role"));
			joblist.setCurStatus(XmlOperator.getAttrValue(jobElm, "cur_status"));
			joblist.setDate(XmlOperator.getAttrValue(jobElm, "date"));
			joblist.setJobId(XmlOperator.getAttrValue(jobElm, "jobid"));
			joblist.setJobName(XmlOperator.getAttrValue(jobElm, "name"));
			joblist.setOrgId(XmlOperator.getAttrValue(jobElm, "orgid"));
			joblist.setRoleId(XmlOperator.getAttrValue(jobElm, "roleid"));
			joblist.setTemplateId(XmlOperator.getAttrValue(jobElm, "templateid"));
			joblist.setUserId(XmlOperator.getAttrValue(jobElm, "userid"));
			joblist.setView(XmlOperator.getAttrValue(jobElm, "view"));

		}

		return joblist;
	}

}