package flowbuilder.application.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fbcom.framework.exceptions.XmlAccessSysException;
import flowbuilder.application.user.UserService;
import flowbuilder.application.user.UserServiceFactory;
import flowbuilder.dao.joblist.JobListDAO;
import flowbuilder.dao.joblist.JobListDataAccessFactroy;
import flowbuilder.daoimpl.db.DBXmlFileConn;
import flowbuilder.daoimpl.db.XmlFileProperity;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.domain.jobctrl.JobControl;
import flowbuilder.domain.joblist.JobList;
import flowbuilder.domain.user.User;
import flowbuilder.presentation.webcmn.taglibs.common.PartCommon;

public class JobOprater {

	/** 
	 * ���M���O
	 */
	private static final Log logger = LogFactory.getLog(JobOprater.class);
	
	private UserService userService = null;
	
	/** DAO�t�@�N�g���̐錾 */
	private JobListDataAccessFactroy _jobListDaoFactory = null;

	private JobListDAO _jobListDAO = null;

	public JobOprater() {
		try {
			
			userService = UserServiceFactory.getUserServiceInstance();
			_jobListDaoFactory = JobListDataAccessFactroy
					.getFactory(SystemFactroyKey.JobListFactroyKey);
			_jobListDAO = _jobListDaoFactory.createJobListDAO();
		} catch (Exception e) {
			logger.error("�W���u���X�g�̑���N���X�𐶐�����͎̂��s���܂����B");
		}
	}

	/**
	 * ������Ԃ̈Č��t�@�C�����쐬����B
	 * 
	 * @param tempId�@�e���v���[�gID
	 * @param userID�@���[�UID
	 * @param orgID�@�g�DID
	 * @return
	 * @throws XmlAccessSysException 
	 */
	public Document creatDoc(String tempId, String userID, String orgID)
			throws XmlAccessSysException {
		String nextStep = "";
		Document job = null;
		XmlFileProperity fileOpr = new XmlFileProperity("Path.Xml.File");

		try {
			//�e���v���[�g�̃p�[�X
			String filePath = fileOpr.getFileDirByID("template", tempId);
			// �f�[�^XML�����[�h����
			job = DBXmlFileConn.getDocument(filePath);

			// �K�v��NodeList���擾����
			NodeList workFlowList = XmlOperator.getNodeList(job, "WorkFlow");

			Element workFlowElement = XmlOperator.getElement(workFlowList, 0);

			NodeList stepList = workFlowElement.getElementsByTagName("step");

			Element stepElement = XmlOperator.getElement(stepList, 0);

			NodeList stateList = stepElement.getElementsByTagName("state");

			Element stateElement = XmlOperator.getElement(stateList, 0);

			if (stateElement.getAttribute("active").equals("true")) {
				//
				NodeList operatorList = stepElement.getElementsByTagName("opr");

				// ����G�������g���擾
				Element operatorElement = XmlOperator.getElement(operatorList,
						0);
				operatorElement.setAttribute("confirmTime", PartCommon.getCurTime());
				operatorElement.setAttribute("userid", userID);
				operatorElement.setAttribute("orgid", orgID);
				nextStep = operatorElement.getAttribute("go_step");
			}
			stateElement.setAttribute("active", Boolean.FALSE.toString());

			int stepListSize = stepList.getLength();
			for (int i = 0; i < stepListSize; i++) {
				//
				Element tempStepElement = XmlOperator.getElement(stepList, i);

				NodeList tempStateList = tempStepElement
						.getElementsByTagName("state");
				Element tempStateElement = XmlOperator.getElement(
						tempStateList, 0);

				if (tempStateElement.getAttribute("current").equals(nextStep)) {
					tempStateElement.setAttribute("active", Boolean.TRUE
							.toString());
					break;
				}
			}
		} catch (NullPointerException e) {
			throw new XmlAccessSysException("������Ԃ̈Č��t�@�C�����쐬����G���[");
		}

		return job;
	}

	//============================================================
	//�Č��쐬
	//============================================================
	public void createNewJob(Document flow, String strUserID, String userName,
			String strOrgID, String strRoleID, String strJobID, String userIp,
			String tempId) {
		try {
			if (flow != null) {

				//Job�G�������g���擾����
				Element jobinfoElement = XmlOperator.getElement(XmlOperator
						.getNodeList(flow, "jobinfo"), 0);

				//�����l��ݒ肷��
				XmlOperator.setAttrValue(jobinfoElement, "title", "");

				//�����l��ݒ肷��
				XmlOperator.setAttrValue(jobinfoElement, "name", userName);

				//�����l��ݒ肷��
				XmlOperator.setAttrValue(jobinfoElement, "userid", strUserID);

				//�����l��ݒ肷��
				XmlOperator.setAttrValue(jobinfoElement, "orgid", strOrgID);

				//�����l��ݒ肷��
				XmlOperator.setAttrValue(jobinfoElement, "roleid", strRoleID);

				//�����l��ݒ肷��
				XmlOperator.setAttrValue(jobinfoElement, "jobid", strJobID);

				//�����l��ݒ肷��
				XmlOperator.setAttrValue(jobinfoElement, "cur_org", strOrgID);

				//�����l��ݒ肷��
				XmlOperator.setAttrValue(jobinfoElement, "userip", userIp);

				//�����l��ݒ肷��
				XmlOperator.setAttrValue(jobinfoElement, "tempId", tempId);

			}
		}

		catch (Exception e) {
			logger.error("�Č��쐬�͎��s���܂����B");
		}

	}

	//============================================================
	//�Č��ۑ��h�L�������g�ۑ�
	//============================================================
	public boolean saveDocXml(Document doc, List<JobControl> parameters) {

		boolean bResult = false;

		try {
			String[] strDocName; //

			String[] strDocValue; //

			String strName = "StuName1/StuName2/StuName3/StuName4/StuName5/StuName6/StuName7/StuName8/StuName9/StuName10/StuName11/StuName12/StuName13/StuName14/StuName15/StuName16/StuName17/StuName18/StuName19/StuName20";

			int intCount = 0; //

			int intElementCount = 0; //

			int length = parameters.size();

			String[] tokens = strName.split("/");

			//���N�G�X�g���𐔂���
			for (int i = 0; i < length; i++) {

				//�G�������g�����擾����
				JobControl parameter = parameters.get(i);

				String parameterName = parameter.getParamName();

				//���e�Ȃ����ڂ�����
				if (parameterName == null || parameterName.equals("")) {
					break;
				} else {

					//�h�L�������g���ڂ𐔂���
					if ((!parameterName.equals("action"))
							&& (!parameterName.equals("recordId"))
							&& (!parameterName.equals("fb_jobname"))) {
						intElementCount++;
					}
				}
			}

			//�G�������g�^�u���ƒl��ۑ�����ϐ����쐬
			strDocName = new String[intElementCount];

			//�G�������g���e��ۑ�����ϐ����쐬
			strDocValue = new String[intElementCount];

			//�h�L�������g���e�͂��邩�ۂ��̔��f
			if (intElementCount > 0) {

				//�ϐ�������������
				for (int i = 0; i < intElementCount; i++) {
					//�G�������g���ϐ���������
					strDocName[i] = null;

					//�G�������g���e�ϐ���������
					strDocValue[i] = null;
				}

				//���N�G�X�g���𐔂���
				for (int i = 0; i < length; i++) {
					//�G�������g�����擾����
					JobControl parameter = parameters.get(i);

					//
					String parameterName = parameter.getParamName();

					//
					if (parameterName == null || parameterName.equals("")) {
						break;
					} else {
						String strJobName = "";

						//�Č����̓��菈��
						if ("fb_jobname".equals(parameterName)) {
							//Job�G�������g���擾����
							Element jobinfoElement = XmlOperator.getElement(
									XmlOperator.getNodeList(doc, "jobinfo"), 0);

							//�Č������擾����
							strJobName = parameter.getParamValue();

							//�Č������Č����֋L������
							XmlOperator.setAttrValue(jobinfoElement,"title", strJobName);
						}

						//���̑����̎擾
						else if ((!strJobName.equals("act"))
								&& (!strJobName.equals("jobfile"))) {
							//
							strDocName[intCount] = parameterName;

							strDocValue[intCount] = parameter.getParamValue();
							//
							intCount++;
						}
					}
				}
			}

			if ("�Č��N��".equals(getCurrentState(doc))){
				delCompositControl(doc,"on");
			}
			
			//�K�v��NodeList���擾����
			NodeList documents = XmlOperator.getNodeList(doc, "Document");
			Element eleDocument = XmlOperator.getElement(documents, 0);
			for (int k = 0; k < tokens.length; k++) {

			for (int i = 0; i < intCount; i++) {

				NodeList strDocList = eleDocument.getElementsByTagName("control");

				int strDocListLength = strDocList.getLength();

				for (int j = 0; j < strDocListLength; j++) {
					Element strDocElement = XmlOperator.getElement(strDocList,j);

					String docName = XmlOperator.getAttrValue(strDocElement,"id");

					// 
				if (docName != null && docName.equals(strDocName[i]) ||docName.equals(tokens[k])) {
						//�G�������g�m�[�h���폜����
						XmlOperator.removeElementNode(eleDocument,strDocElement);
						break;
					}
				}

				//�V�������̃G�������g���쐬����
				Element newElement = XmlOperator.createElement(doc, "control",strDocValue[i]);

				Attr newArrId = XmlOperator.createAttrbute(doc, "id",strDocName[i]);

				XmlOperator.setAttrNode(newElement, newArrId);

				if (newElement != null) {
					//�m�[�h�̎q�m�[�h�̃��X�g�̖����ɁA���̃m�[�h��ǉ����܂��B
					XmlOperator.appendElementNode(eleDocument, newElement);
				}
			}
			}
			//
			bResult = true;

			//�i���ۏ�
			logger.info("�I��");
		} catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			bResult = false;
		}

		//
		return bResult;
	}

	private void delCompositControl(Document doc, String flg) {
		
		NodeList documents = XmlOperator.getNodeList(doc, "Document");
		
		Element eleDocument = XmlOperator.getElement(documents, 0);
		
		NodeList strDocList = eleDocument.getElementsByTagName("control");
		
		int length = strDocList.getLength();

		for (int i = 0; i < length; i++) {
			Element conElm = XmlOperator.getElement(strDocList, i);
			
			if(conElm != null){
				Node docNode = conElm.getFirstChild();
				
				String docValue = docNode == null ? "" : docNode.getNodeValue();

				if (flg.equals(docValue)) {
					//�G�������g�m�[�h���폜����
					XmlOperator.removeElementNode(eleDocument,conElm);
					i--;
				}
			}
		}
	}

	public void delDocXml(Document doc, List<JobControl> parameters) {
		NodeList Documents = XmlOperator.getNodeList(doc, "Document");

		Element Document = (Element) Documents.item(0);

		NodeList controlList = Document.getElementsByTagName("control");

		int controlListLength = controlList.getLength();

		for (int i = 0; i < controlListLength; i++) {

			Element controlElm = (Element) controlList.item(i);

			String controlName = XmlOperator.getAttrValue(controlElm, "id");

			int parmLength = parameters.size();

			JobControl jobCon = null;

			for (int j = 0; j < parmLength; j++) {
				jobCon = parameters.get(j);

				String paramName = jobCon.getParamName();

				if (controlName.equals(paramName)) {
					Document.removeChild(controlElm);
				}
			}
		}

	}

	//============================================================
	//�t���[�̏�ԑJ��
	//�����F
	//	Document doc		�F	�Č��h�L�������g
	//	String strOpr		�F	����
	//	String strUserId	�F	����҂h�c
	//�߂�l	�F
	//	�V�������
	//============================================================
	public String changeFlowState(Document doc, String strOprId,
			String strUserId, String strOrgId, JobList jobRecord) {

		String strExc = "";

		try {
			//�i���ۏ�
			logger.info("�J�n");

			//WorkFlow��NodeList���擾����
			NodeList workFlowList = XmlOperator.getNodeList(doc, "WorkFlow");

			//WorkFlow�̃G�������g���擾����
			Element workFlowElement = XmlOperator.getElement(workFlowList, 0);

			//Step��NodeList���擾����
			NodeList stepList = workFlowElement.getElementsByTagName("step");

			int stepListSize = stepList.getLength();
			//���ݏ�Ԃ���肷��
			for (int i = 0; i < stepListSize; i++) {
				//Step�G�������g���擾����
				Element stepElement = XmlOperator.getElement(stepList, i);

				//��Ԃ�NodeList���擾����
				NodeList stateList = stepElement.getElementsByTagName("state");

				//��Ԃ̃G�������g���擾����
				Element stateElement = XmlOperator.getElement(stateList, 0);

				//���ݏ�Ԃ��ǂ����̃`�F�b�N
				if (stateElement.getAttribute("active").equals("true")) {

					//���ݏ�Ԃ̑��샊�X�g���擾����
					NodeList operatorList = stepElement.getElementsByTagName("opr");

					int operatorListSize = operatorList.getLength();

					//���ݑ������肷��
					for (int j = 0; j < operatorListSize; j++) {
						//����̃G�������g���擾����
						Element operatorElement = XmlOperator.getElement(
								operatorList, j);

						//���ݑ��삩�ǂ����̃`�F�b�N
						if (operatorElement.getAttribute("id").equals(strOprId)) {
							
							XmlOperator.setAttrValue(operatorElement, "confirmTime",
									PartCommon.getCurTime());

							//����҂h�c���L������
							XmlOperator.setAttrValue(operatorElement, "userid",
									strUserId);

							//����ґg�D�h�c���L������
							XmlOperator.setAttrValue(operatorElement, "orgid",
									strOrgId);

							//�V������Ԃ��擾
							String strNewState = operatorElement
									.getAttribute("go_step");

							//�V�����g�D���擾
							String strGoOrgId = operatorElement
									.getAttribute("go_org");

							//�V�����������擾
							String strGoRoleId = operatorElement
									.getAttribute("go_role");

							//��ԑJ�ڂ��s��
							setCurrentStep(doc, strNewState, strGoOrgId,
									strGoRoleId, jobRecord);

							//�V�������
							strExc = strNewState;
						} else {
							
							XmlOperator.setAttrValue(operatorElement, "confirmTime",
									PartCommon.getCurTime());
							
							//����҂��N���A����
							XmlOperator.setAttrValue(operatorElement, "userid",
									"");

							//����ґg�D���N���A����
							XmlOperator.setAttrValue(operatorElement, "orgid",
									"");
						}
					}
					break;
				}
			}

			//�i���ۏ�
			logger.info("�I��");
		}

		catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strExc = e.toString();
		}

		//
		return (strExc);
	}

	//============================================================
	//�t���[�̌��ݏ�Ԃ��擾����
	//============================================================
	public String getCurrentState(Document doc) {

		String strExc = "";
		try {

			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList workFlowList = XmlOperator.getNodeList(doc, "WorkFlow");

			if(workFlowList != null) {
				Element workFlowElement = XmlOperator.getElement(workFlowList, 0);
	
				if(workFlowElement != null){
					NodeList stepList = workFlowElement.getElementsByTagName("step");
		
					int size = stepList.getLength();
					//
					for (int i = 0; i < size; i++) {
						//
						Element stepElement = XmlOperator.getElement(stepList, i);
		
						//
						NodeList stateList = stepElement.getElementsByTagName("state");
		
						//
						Element stateElement = XmlOperator.getElement(stateList, 0);
		
						//
						if (stateElement.getAttribute("active").equals("true")) {
							//
							strExc = stateElement.getAttribute("current");
							break;
						}
					}
				}
			}
			//�i���ۏ�
			logger.info("�I��");
		} catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[" + e.getMessage());
		}

		return (strExc);

	}

	//============================================================
	//�쐬�҂h�c���擾����
	//============================================================
	public String getCreatorID(Document doc) {

		String strExc = "";
		try {
			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			//
			Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

			//
			strExc = jobInfoElement.getAttribute("userid");

			//�i���ۏ�
			logger.info("�I��");
		}

		catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strExc = e.toString();
		}

		return (strExc);
	}

	//============================================================
	//�Č������擾����
	//============================================================
	public String getJobName(Document doc) {

		String strExc = "";
		try {
			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			//
			Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

			//
			strExc = jobInfoElement.getAttribute("title");

			//�i���ۏ�
			logger.info("�I��");

		}

		catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strExc = e.toString();
		}

		return (strExc);
	}

	//============================================================
	//�J�n���Ԃ��擾����
	//============================================================
	public String getStartTime(Document doc) {

		String strExc = "";
		try {
			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList Documents = XmlOperator.getNodeList(doc, "Document"); // �m�b�h���X�g

			//
			Element docElement = (Element) Documents.item(0);

			// �h�L�������g�̒l���擾����
			strExc = XmlOperator.getElementValue(docElement, "startdate");

			//�i���ۏ�
			logger.info("�I��");

		}

		catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strExc = e.toString();
		}

		return (strExc);
	}

	//============================================================
	//�I����Ď��Ԃ��擾����
	//============================================================
	public String getEndTime(Document doc) {

		String strExc = "";
		try {
			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList Documents = XmlOperator.getNodeList(doc, "Document"); // �m�b�h���X�g

			//
			Element docElement = (Element) Documents.item(0);

			// �h�L�������g�̒l���擾����
			strExc = XmlOperator.getElementValue(docElement, "enddate");

			//�i���ۏ�
			logger.info("�I��");

		}

		catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strExc = e.toString();
		}

		return (strExc);
	}

	//============================================================
	//�Q�Ɖ\���������擾����
	//============================================================
	public String getSeeRole(Document doc) {

		String strExc = "";
		try {
			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			//
			Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

			//�Č����Q�Ɖ\�������
			strExc = jobInfoElement.getAttribute("see_role");

			//�i���ۏ�
			logger.info("�I��");

		}

		catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strExc = e.toString();
		}

		return (strExc);
	}

	//============================================================
	//�Q�Ɖ\�g�D�����擾����
	//============================================================
	public String getSeeOrg(Document doc) {

		String strExc = "";
		try {
			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			//
			Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

			//�Č����Q�Ɖ\�������
			strExc = XmlOperator.getAttrValue(jobInfoElement, "see_org");

			//�i���ۏ�
			logger.info("�I��");
		} catch (Exception e) {
			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strExc = e.toString();
		}

		return (strExc);
	}

	//============================================================
	//�t���[���ݑg�D�h�c���擾����
	//============================================================
	public String getCurOrgID(Document doc) {

		String strExc = "";
		try {
			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			//
			Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

			//�Č����Q�Ɖ\�������
			strExc = XmlOperator.getAttrValue(jobInfoElement, "cur_org");

			//�i���ۏ�
			logger.info("�I��");

		}

		catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strExc = e.toString();
		}

		return (strExc);
	}

	//============================================================
	//�t���[���ݑg�D�h�c���擾����
	//============================================================
	public String getOrgID(Document doc) {

		String strExc = "";
		try {
			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			//
			Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

			//�Č����Q�Ɖ\�������
			strExc = XmlOperator.getAttrValue(jobInfoElement, "orgid");

			//�i���ۏ�
			logger.info("�I��");

		}

		catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strExc = e.toString();
		}

		return (strExc);
	}

	//============================================================
	//�t���[���ݏ��������h�c���擾����
	//============================================================
	public String getCurRoleID(Document doc) {

		String strExc = "";
		try {
			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			//
			Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

			//�Č����Q�Ɖ\�������
			strExc = jobInfoElement.getAttribute("cur_role");

			//�i���ۏ�
			logger.info("�I��");

		}

		catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strExc = e.toString();
		}

		return (strExc);
	}

	//============================================================
	//�Č��h�c���擾����
	//============================================================
	public String getJobID(Document doc) {

		String strExc = "";
		try {
			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			if (jobInfoList != null) {
				//�Č����G�������g���擾����
				Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

				if (jobInfoElement != null) {
					//
					strExc = jobInfoElement.getAttribute("jobid");
				} else {
					//�i���ۏ�
					logger.info("�Č����G�������g�̎擾�Ɏ��s���܂����B");
				}
			} else {

				//�i���ۏ�
				logger.info("�Č����m�[�h���X�g�̎擾�Ɏ��s���܂����B");
			}

			//�i���ۏ�
			logger.info("�I��");

		}

		catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strExc = e.toString();
		}

		return (strExc);
	}

	//============================================================
	//�Č������擾����
	//============================================================
	public String getJobInfo(Document doc, String strInfoTagName) {

		String strExc = "";
		try {
			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			if (jobInfoList != null) {
				//�Č����G�������g���擾����
				Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

				if (jobInfoElement != null) {
					//�Ή������擾����
					strExc = jobInfoElement.getAttribute(strInfoTagName);
				} else {
					//�i���ۏ�
					logger.info("�Č����G�������g�̎擾�Ɏ��s���܂����B");
				}
			} else {

				//�i���ۏ�
				logger.info("�Č����m�[�h���X�g�̎擾�Ɏ��s���܂����B");
			}

			//�i���ۏ�
			logger.info("�I��");

		}

		catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strExc = e.toString();
		}

		return (strExc);
	}

	//============================================================
	//�t���[���ݑg�D�h�c��ݒ肷��
	//============================================================
	public void setCurOrgID(Document doc, String strCurOrgID) {

		String strExc = "";
		try {
			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			//
			Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

			//�Č����Q�Ɖ\�������
			XmlOperator.setAttrValue(jobInfoElement, "cur_org", strCurOrgID);

			//�i���ۏ�
			logger.info("�I��");

		}

		catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strExc = e.toString();
		}

	}

	//============================================================
	//�t���[���ݖ����h�c��ݒ肷��
	//============================================================
	public void setCurRoleID(Document doc, String strCurRoleID) {

		String strExc = "";
		try {
			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			//
			Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

			//�Č����Q�Ɖ\�������
			XmlOperator.setAttrValue(jobInfoElement, "cur_role", strCurRoleID);

			//�i���ۏ�
			logger.info("�I��");

		}

		catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strExc = e.toString();
		}

	}

	//============================================================
	//�쐬�Җ��̂��擾����
	//============================================================
	public String getCreatorName(Document doc) {

		String strExc = "";
		try {

			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			//
			Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

			//
			strExc = jobInfoElement.getAttribute("name");

			//�i���ۏ�
			logger.info("�I��");

		}

		catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			strExc = e.toString();

		}

		return (strExc);

	}

	//============================================================
	//�t���[�̌��݃^�C�g�����擾����
	//============================================================
	public String getCurrentStateName(Document doc) {

		String strExc = "";
		try {
			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList workFlowList = XmlOperator.getNodeList(doc, "WorkFlow");

			//
			Element workFlowElement = XmlOperator.getElement(workFlowList, 0);

			//
			NodeList stepList = workFlowElement.getElementsByTagName("step");

			//
			int size = stepList.getLength();
			for (int i = 0; i < size; i++) {

				//
				Element stepElement = XmlOperator.getElement(stepList, i);

				//
				NodeList stateList = stepElement.getElementsByTagName("state");

				//
				Element stateElement = XmlOperator.getElement(stateList, 0);

				//
				if (stateElement.getAttribute("active").equals("true")) {

					//
					strExc = stateElement.getAttribute("title");
				}
			}

			//�i���ۏ�
			logger.info("�I��");

		} catch (Exception e) {
			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strExc = e.toString();
		}

		//
		return (strExc);
	}

	//============================================================
	//���ݏ�Ԃ̑�������擾����
	//============================================================
	public int getCurrentOprInfo(Document doc, StringBuffer strOprIds,
			StringBuffer strActors, StringBuffer strOprNames) {

		//
		String strExc = "";

		//
		int intCount = 0;

		try {

			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList workFlowList = XmlOperator.getNodeList(doc, "WorkFlow");

			//
			Element workFlowElement = XmlOperator.getElement(workFlowList, 0);

			//
			NodeList stepList = workFlowElement.getElementsByTagName("step");

			int stepListSize = stepList.getLength();
			//
			for (int i = 0; i < stepListSize; i++) {

				//
				Element stepElement = XmlOperator.getElement(stepList, i);

				//
				NodeList stateList = stepElement.getElementsByTagName("state");

				//
				Element stateElement = XmlOperator.getElement(stateList, 0);

				//
				if (stateElement.getAttribute("active").equals("true")) {

					//
					NodeList operatorList = stepElement
							.getElementsByTagName("opr");

					int operatorListSize = operatorList.getLength();
					//
					for (int j = 0; j < operatorListSize; j++) {

						//����G�������g���擾
						Element operatorElement = XmlOperator.getElement(
								operatorList, j);

						if (intCount == 0) {
							//����q��ۑ�
							strOprIds
									.append(operatorElement.getAttribute("id"));

							//����q��ۑ�
							strActors.append(operatorElement
									.getAttribute("act"));

							//���얼��ۑ�
							strOprNames.append(operatorElement
									.getAttribute("name"));
						} else {
							//����q��ۑ�
							strOprIds.append(",").append(
									operatorElement.getAttribute("id"));

							//����q��ۑ�
							strActors.append(",").append(
									operatorElement.getAttribute("act"));

							//���얼��ۑ�
							strOprNames.append(",").append(
									operatorElement.getAttribute("name"));
						}

						//���𐔂���
						intCount++;
					}
				}
			}

			//�i���ۏ�
			logger.info("�I��");

		}

		catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strExc = e.toString();
		}

		//
		return (intCount);
	}

	//============================================================
	//���ݏ�Ԃ̑���q,���擾����
	//============================================================
	public int getCurrentOperator(Document doc, String[] strOprIds) {

		//
		String strExc = "";

		//
		int intCount = 0;

		try {

			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList workFlowList = XmlOperator.getNodeList(doc, "WorkFlow");

			//
			Element workFlowElement = XmlOperator.getElement(workFlowList, 0);

			//
			NodeList stepList = workFlowElement.getElementsByTagName("step");

			int stepListSize = stepList.getLength();
			//
			for (int i = 0; i < stepListSize; i++) {

				//
				Element stepElement = XmlOperator.getElement(stepList, i);

				//
				NodeList stateList = stepElement.getElementsByTagName("state");

				//
				Element stateElement = XmlOperator.getElement(stateList, 0);

				//
				if (stateElement.getAttribute("active").equals("true")) {
					//����q���X�g���擾����
					NodeList operatorList = stepElement
							.getElementsByTagName("opr");

					int operatorListSize = operatorList.getLength();

					//����q����
					for (int j = 0; j < operatorListSize; j++) {
						//����q�𐔂���
						intCount++;

						//����q�G�������g���擾����
						Element operatorElement = XmlOperator.getElement(
								operatorList, j);

						//����qID��ۑ�
						strOprIds[j] = operatorElement.getAttribute("id");
					}
				}
			}

			//�i���ۏ�
			logger.info("�I��");
		}

		catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strExc = e.toString();
		}

		//
		return (intCount);
	}

	//============================================================
	//���ݏ�ԓ���q���擾����
	//============================================================
	public int getCurrentActor(Document doc, String[] strActors) {

		String strExc = "";

		int intCount = 0;
		try {
			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList workFlowList = XmlOperator.getNodeList(doc, "WorkFlow");

			//
			Element workFlowElement = XmlOperator.getElement(workFlowList, 0);

			//
			NodeList stepList = workFlowElement.getElementsByTagName("step");

			int stepListSize = stepList.getLength();
			//
			for (int i = 0; i < stepListSize; i++) {
				//
				Element stepElement = XmlOperator.getElement(stepList, i);

				//
				NodeList stateList = stepElement.getElementsByTagName("state");

				//
				Element stateElement = XmlOperator.getElement(stateList, 0);

				//
				if (stateElement.getAttribute("active").equals("true")) {
					//
					NodeList operatorList = stepElement
							.getElementsByTagName("opr");

					int operatorListSize = operatorList.getLength();
					//
					for (int j = 0; j < operatorListSize; j++) {
						//
						intCount++;

						//
						Element operatorElement = XmlOperator.getElement(
								operatorList, j);

						//
						strActors[j] = operatorElement.getAttribute("act");
					}
				}
			}

			//�i���ۏ�
			logger.info("�I��");
		}

		catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strExc = e.toString();
		}

		//
		return (intCount);
	}

	//============================================================
	//���ݏ�Ԃ̑��얼���擾����
	//============================================================
	public int getCurrentOprName(Document doc, String[] strOprNames) {

		String strExc = "";
		int intCount = 0;
		try {

			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList workFlowList = XmlOperator.getNodeList(doc, "WorkFlow");

			//
			Element workFlowElement = XmlOperator.getElement(workFlowList, 0);

			//
			NodeList stepList = workFlowElement.getElementsByTagName("step");

			int stepListSize = stepList.getLength();
			//
			for (int i = 0; i < stepListSize; i++) {
				//
				Element stepElement = XmlOperator.getElement(stepList, i);

				//
				NodeList stateList = stepElement.getElementsByTagName("state");

				//
				Element stateElement = XmlOperator.getElement(stateList, 0);

				//
				if (stateElement.getAttribute("active").equals("true")) {
					//
					NodeList operatorList = stepElement
							.getElementsByTagName("opr");

					int operatorListSize = operatorList.getLength();
					//
					for (int j = 0; j < operatorListSize; j++) {
						//
						intCount++;

						//
						Element operatorElement = XmlOperator.getElement(
								operatorList, j);

						//
						strOprNames[j] = operatorElement.getAttribute("name");
					}
				}
			}

			//�i���ۏ�
			logger.info("�I��");
		}

		catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strExc = e.toString();
		}

		//
		return (intCount);
	}

	//============================================================
	//�t���[�̑J�ڐ�X�e�b�v���擾����
	//============================================================
	public String getNextStep(Document doc, String strOprId) {

		String strExc = "";

		int intCount = 0;
		try {
			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList workFlowList = XmlOperator.getNodeList(doc, "WorkFlow");

			//
			Element workFlowElement = XmlOperator.getElement(workFlowList, 0);

			//
			NodeList stepList = workFlowElement.getElementsByTagName("step");

			int stepListSize = stepList.getLength();
			//
			for (int i = 0; i < stepListSize; i++) {
				//
				Element stepElement = XmlOperator.getElement(stepList, i);

				//
				NodeList stateList = stepElement.getElementsByTagName("state");

				//
				Element stateElement = XmlOperator.getElement(stateList, 0);

				//
				if (stateElement.getAttribute("active").equals("true")) {
					//
					NodeList operatorList = stepElement
							.getElementsByTagName("opr");

					int operatorListSize = operatorList.getLength();
					//
					for (int j = 0; j < operatorListSize; j++) {
						//
						Element operatorElement = XmlOperator.getElement(
								operatorList, j);

						//����q�h�c���r����
						if (operatorElement.getAttribute("id").equals(strOprId)) {
							//�J�ڐ�X�e�b�v���擾����
							strExc = operatorElement.getAttribute("go_step");

							//�����I��
							break;
						}
					}
				}
			}

			//�i���ۏ�
			logger.info("�I��");

		}

		catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strExc = e.toString();
		}

		//
		return (strExc);

	}

	//============================================================
	//�t���[�̑J�ڐ�g�D���擾����
	//============================================================
	public String getNextOrg(Document doc, String strOprId) {
		String strExc = "";

		int intCount = 0;
		try {
			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList workFlowList = XmlOperator.getNodeList(doc, "WorkFlow");

			//
			Element workFlowElement = XmlOperator.getElement(workFlowList, 0);

			//
			NodeList stepList = workFlowElement.getElementsByTagName("step");

			int stepListSize = stepList.getLength();
			//
			for (int i = 0; i < stepListSize; i++) {
				//
				Element stepElement = XmlOperator.getElement(stepList, i);

				//
				NodeList stateList = stepElement.getElementsByTagName("state");

				//
				Element stateElement = XmlOperator.getElement(stateList, 0);

				//
				if (stateElement.getAttribute("active").equals("true")) {

					//����q���X�g���擾����
					NodeList operatorList = stepElement
							.getElementsByTagName("opr");

					int operatorListSize = operatorList.getLength();
					//�����J�n
					for (int j = 0; j < operatorListSize; j++) {

						//����q�G�������g���擾����
						Element operatorElement = XmlOperator.getElement(
								operatorList, j);

						//����q�h�c���r����
						if (operatorElement.getAttribute("id").equals(strOprId)) {

							//�J�ڐ�̑g�D�h�c���擾����
							strExc = operatorElement.getAttribute("go_org");

							//�����I��
							break;
						}
					}
				}
			}

			//�i���ۏ�
			logger.info("�I��");
		}

		catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strExc = e.toString();
		}

		//
		return (strExc);

	}

	//============================================================
	//���[�N�t���[��J�ڂ���
	//============================================================
	public void setCurrentStep(Document doc, String strCurrentStep,
			String strGoOrgId, String strGoRoleId, JobList joblist) {

		String strExc = "";

		try {

			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList workFlowList = XmlOperator.getNodeList(doc, "WorkFlow");

			//���[�N�t���[�G�������g���擾����
			Element workFlowElement = XmlOperator.getElement(workFlowList, 0);

			//�X�e�b�v���X�g���擾����
			NodeList stepList = workFlowElement.getElementsByTagName("step");

			int stepListSize = stepList.getLength();
			//�������J�n����
			for (int i = 0; i < stepListSize; i++) {

				//�X�e�b�v�G�������g���擾����
				Element stepElement = XmlOperator.getElement(stepList, i);

				//��ԃ��X�g���擾����
				NodeList stateList = stepElement.getElementsByTagName("state");

				//��ԃG�������g���擾����
				Element stateElement = XmlOperator.getElement(stateList, 0);

				//���ݏ�ԂƔ�r����
				if (stateElement.getAttribute("current").equals(strCurrentStep)) {

					//���ݏ�Ԃ͊�����ԂłȂ���΁A������Ԃɂ���
					if (!stateElement.getAttribute("active").equals("true")) {

						//�V�����h�L�������g����ݒ肷��
						XmlOperator
								.setAttrValue(stateElement, "active", "true");

						//�J�ڌ�̌��ݖ����ݒ�
						setCurRoleID(doc, strGoRoleId);

						//�J�ڌ�̌��ݑg�D�ݒ�
						setCurOrgID(doc, strGoOrgId);

						//�Č��h�c���擾����
						String strJobId = getJobID(doc);

						//�Č��ꗗ�̑g�D�����C������
						joblist.setCurOrg(strGoOrgId);
	
						//�Č��ꗗ�̖��������C������
						joblist.setCurRole(strGoRoleId);

						//�Č��ꗗ�̏�Ԃ��C������
						joblist.setCurStatus(strCurrentStep);

						//�Ή��ꗗ�Č������L������
						_jobListDAO.update(joblist);
					}
				} else {

					//�񌻍ݏ�Ԃ�񊈓��ɂ���
					if (stateElement.getAttribute("active").equals("true")) {

						//�V�����h�L�������g����ݒ肷��
						XmlOperator.setAttrValue(stateElement, "active",
								"false");
					}
				}
			}

			//�i���ۏ�
			logger.info("�I��");
		}

		catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strExc = e.toString();

		}
	}

	//============================================================
	//���[�N�t���[���̂��擾����
	//============================================================
	public String getWorkFlowName(Document doc) {

		String strExc = "";
		try {

			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList workFlowList = XmlOperator.getNodeList(doc, "WorkFlow");

			//
			Element workFlowElement = XmlOperator.getElement(workFlowList, 0);

			//
			NodeList nameList = workFlowElement.getElementsByTagName("name");

			//
			Element nameElement = XmlOperator.getElement(nameList, 0);

			//
			strExc = nameElement.getFirstChild().getNodeValue();

			//�i���ۏ�
			logger.info("�I��");

		}

		catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strExc = e.toString();
		}

		//
		return (strExc);
	}

	//============================================================
	//�쐬�҂hP���擾����
	//============================================================
	public String getCreatorIP(Document doc) {

		String strExc = "";
		try {
			//�i���ۏ�
			logger.info("�J�n");

			//�K�v��NodeList���擾����
			NodeList jobInfoList = XmlOperator.getNodeList(doc, "jobinfo");

			//
			Element jobInfoElement = XmlOperator.getElement(jobInfoList, 0);

			//
			strExc = jobInfoElement.getAttribute("userip");

			//�i���ۏ�
			logger.info("�I��");
		}

		catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strExc = e.toString();
		}

		return (strExc);
	}
	
	//============================================================
	//���F�҂hP���擾����
	//============================================================
	public List<User> getApprovalerList(Document doc) {
		
		List<User> strExc = null;
		//String str = "";
		try {
			//�i���ۏ�
			logger.info("�J�n");

			String curOrgId = this.getCurOrgID(doc);
			
			String curRoleId = this.getCurRoleID(doc);
			
			if("".equals(curOrgId)) {
				curOrgId = this.getOrgID(doc);
			}
			

			strExc = userService.getUpUsersId(curOrgId,curRoleId);
			
			//�i���ۏ�
			logger.info("�I��");
		}
		catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");
		}

		return strExc;
	}
	
	/**
	 * 
	 * @param docJob
	 * @param arrayUsers
	 */
	public void creatUserXml(Document docJob, String[] arrayUsers) {
		
		Node cirNode = docJob.getDocumentElement().getElementsByTagName("Circular").item(0);
		//�m�[�h���폜
		XmlOperator.removeElementNode(docJob.getDocumentElement(),cirNode);
		//���f���쐬����
		Element newCirNode = docJob.createElement("Circular");
		
		for (int i = 0;i < arrayUsers.length; i++){
			Element newMember = XmlOperator.createElement(docJob, "member", "");
			Attr newArrId = XmlOperator.createAttrbute(docJob, "id", arrayUsers[i]);
			XmlOperator.setAttrNode(newMember, newArrId);
			Attr newArrProblemFlg = XmlOperator.createAttrbute(docJob, "problemFlg", "0");
			XmlOperator.setAttrNode(newMember, newArrProblemFlg);
			Attr newConfirmTime = XmlOperator.createAttrbute(docJob, "confirmDate", "");
			XmlOperator.setAttrNode(newMember, newConfirmTime);
			XmlOperator.appendElementNode(newCirNode, newMember);
		}
		// newElement�m�[�h�̎q�m�[�h�̃��X�g�̖����ɁA�w�肵���������ǉ����܂��B
		XmlOperator.appendElementNode(docJob.getDocumentElement(), newCirNode);
		
	}
	
	
//	============================================================
	//�񗗎҂��擾����
	//============================================================
	public List<User> getCirculePeople(Document doc) {
		String vog = "0";
		String temp = "";
		
		User user = null;
		List<User> strExc = new ArrayList<User>();
		NodeList membersList = XmlOperator.getNodeList(doc, "member");
		for(int j = 0; j < membersList.getLength(); j++) {
			Element memerElemen = XmlOperator.getElement(membersList, j);
			if(!"0".equals(XmlOperator.getAttrValue(memerElemen, "problemFlg"))) {
				temp = "";
				vog = "1";
				break;
			}
		}
		if("0".equals(vog)) {
			Element circulars = (Element) XmlOperator.getNodeList(doc, "Document").item(0);
			temp = PartCommon.getTagValue(circulars, "circularID");
			//String str = "";
			try {
				//�i���ۏ�
				logger.info("�J�n");
				String[] userList = temp.split(",");
				int userListLength = userList.length;
				
				for(int i=0;i<userListLength;i++) {
					user = userService.getUser(userList[i]);
					strExc.add(user);
				}
								
				//�i���ۏ�
				logger.info("�I��");
			}
			catch (Exception e) {

				//�i���ۏ�
				logger.fatal("�v���I�ȃG���[");
			}
		} 
		return strExc;
	}
	

	/**
	 * �Č����?�X����
	 * @param Document doc �h�L�������g
	 * @param String status �Č����
	 * @return
	 */
	public int getStep(Document doc, String status) {
		int num = 0;

		// WorkFlow��NodeList���擾����
		NodeList workFlowList = XmlOperator.getNodeList(doc, "WorkFlow");
		
		// WorkFlow�̃G�������g���擾����
		Element workFlowElement = XmlOperator.getElement(workFlowList, 0);

		// Step��NodeList���擾����
		NodeList stepList = workFlowElement.getElementsByTagName("step");

		for (int i = 0; i < stepList.getLength(); i++) {

			// Step�G�������g���擾����
			Element stepElm = XmlOperator.getElement(stepList, i);
			
			// ��Ԃ�NodeList���擾����
			Element stepNode = (Element) stepElm.getElementsByTagName("state").item(0);
			
			// ��ԃ��X�g���擾����
			String memberList = XmlOperator.getAttrValue(stepNode, "current");

			// ���ݏ�ԂƔ�r����
			if (status.equals(memberList)) {
				num = i;
				break;
			}
		}
		return num;
	}

	/**
	 * �񗗎҃��X�g���擾����
	 * @param doc�@�Č��h�L�������g
	 * ��return userList List<User> �񗗎҃��X�g
	 */
	public List<User> getCircularList(Document doc) {

		List<User> userList = new ArrayList<User>();

		Element circulars = (Element) XmlOperator.getNodeList(doc, "Document").item(0);
		// �h�L�������g����m�[�h���X�g���擾����
		String circularUsrIds = PartCommon.getTagValue(circulars, "circularID");
		try {
			//�i���ۏ�
			logger.info("�J�n");
			User user = null;
			String[] userIds = circularUsrIds.split(",");
			int userListLength = userIds.length;
			for (int i = 0; i < userListLength; i++) {
				// ���[�U�[�����擾����
				user = userService.getUser(userIds[i]);
				userList.add(user);
			}			
			//�i���ۏ�
			logger.info("�I��");
		} catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");
		}
		// �񗗎҃��X�g��ԋp����
		return userList;
	}
	
	/**
	 * �N�Ď҂��擾����
	 * @param doc�@�Č��h�L�������g
	 * ��return userList List<User> �N�Ď҃��X�g
	 */
	public List<User> getCreater(Document doc) {

		List<User> userList = new ArrayList<User>();

		// �h�L�������g����m�[�h���X�g���擾����	
		Element creater = XmlOperator.getElement(XmlOperator.getNodeList(doc, "jobinfo"), 0);

		// �w������擾����
		String createrUsrId = XmlOperator.getAttrValue(creater, "userid");
		try {
			//�i���ۏ�
			logger.info("�J�n");
			User user = null;
			String[] userIds = createrUsrId.split(",");
			int userListLength = userIds.length;
			for (int i = 0; i < userListLength; i++) {
				// ���[�U�[�����擾����
				user = userService.getUser(userIds[i]);
				userList.add(user);
			}			
			//�i���ۏ�
			logger.info("�I��");
		} catch (Exception e) {

			//�i���ۏ�
			logger.fatal("�v���I�ȃG���[");
		}
		// �N�Ď҃��X�g��ԋp����
		return userList;
	}
}
