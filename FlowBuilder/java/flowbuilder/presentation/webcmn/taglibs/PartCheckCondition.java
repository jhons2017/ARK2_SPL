package flowbuilder.presentation.webcmn.taglibs;

import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import fbcom.framework.exceptions.SysException;
import flowbuilder.application.user.UserService;
import flowbuilder.application.user.UserServiceFactory;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.domain.user.Section;
import flowbuilder.domain.user.User;

public final class PartCheckCondition {
	// �i���ۏ�
	private Log _logger = null;

	private UserService serive = null;

	public PartCheckCondition() {

		try {
			// �i���ۏ�
			_logger = LogFactory.getLog(PartCheckCondition.class);

			serive = UserServiceFactory.getUserServiceInstance();
		} catch (Exception e) {

			// �i���ۏ�
			_logger.fatal("�v���I�ȃG���[");

		}

	}

	/**
	 * ���i�̒��ɂ́A���[�U�Ƀ`�F�b�N
	 * 
	 * @param job �Č��h�L�������g
	 * @param strCurState �����
	 * @param strUserCondition ���[�U����
	 * @param strUserId ���݂̑���҂h�c
	 * @return
	 */
	boolean checkUserCondition(Document job, String strCurState, String strUserCondition,
			String strUserId)

	{

		boolean bRsult = false;

		try {

			// �i���ۏ�
			_logger.info("�J�n");

			if (strUserCondition != null && !strUserCondition.equals("")) {
				// **************** "�����/���:����,�����/���:����,�c" *******************
				// ��������
				StringTokenizer strUserConditionToken = new StringTokenizer(strUserCondition, ",");

				// �������
				while (strUserConditionToken.hasMoreTokens()) {

					String strCondition = strUserConditionToken.nextToken();

					// **************** "�����/���:����" *******************

					if (strCondition != null && !strCondition.equals("")) {
						// ����Ԃƃ��[�U����
						StringTokenizer strConditionToken = new StringTokenizer(strCondition, "/");

						String strStateCond = strConditionToken.nextToken();

						// **************** "�����" *******************

						if (strStateCond.equals(strCurState)) {

							String strUserCond = strConditionToken.nextToken();

							// **************** "���:����" *******************

							if (strUserCond != null && !strUserCond.equals("")) {
								// ����Ԃƃ��[�U����
								StringTokenizer strUserToken = new StringTokenizer(strUserCond, ":");

								// ���
								String strState = strUserToken.nextToken();

								// **************** "���" *******************

								String strOperator = strUserToken.nextToken();

								// **************** "����" *******************

								// WorkFlow��NodeList���擾����
								NodeList WorkFlowList = XmlOperator.getNodeList(job, "WorkFlow");

								// WorkFlow�̃G�������g���擾����
								Element WorkFlowElement = XmlOperator.getElement(WorkFlowList, 0);

								// Step��NodeList���擾����
								NodeList StepList = WorkFlowElement.getElementsByTagName("step");

								int stepListSize = StepList.getLength();
								// ���ݏ�Ԃ���肷��
								for (int i = 0; i < stepListSize; i++) {
									// Step�G�������g���擾����
									Element StepElement = XmlOperator.getElement(StepList, i);

									// ��Ԃ�NodeList���擾����
									NodeList StateList = StepElement.getElementsByTagName("state");

									// ��Ԃ̃G�������g���擾����
									Element StateElement = XmlOperator.getElement(StateList, 0);

									// �����̏�Ԃ��ǂ����̃`�F�b�N
									if (StateElement.getAttribute("current").equals(strState)) {

										// ���샊�X�g���擾����
										NodeList OperatorList = StepElement
												.getElementsByTagName("opr");

										int operatorListSize = OperatorList.getLength();
										// �����������肷��
										for (int j = 0; j < operatorListSize; j++) {
											// ����̃G�������g���擾����
											Element OperatorElement = XmlOperator.getElement(
													OperatorList, j);

											// �����̑��삩�ǂ����̃`�F�b�N
											if (OperatorElement.getAttribute("operator").equals(
													strOperator)) {

												if (OperatorElement.getAttribute("userid").equals(
														strUserId)) {
													bRsult = true;

													break;
												}
											}
										}
										break;
									}
								}
							}
						}
					}
				}
			}

			// �i���ۏ�
			_logger.info("�I��");
		} catch (Exception e) {

			// �i���ۏ�
			_logger.fatal("�v���I�ȃG���[");
		}

		return bRsult;

	}

	/**
	 * ���i�̒��ɂ́A���[���Ƀ`�F�b�N
	 * 
	 * @param strCurState �����
	 * @param strUserCondition ���[�U����
	 * @param strOrgID ����ґg�D�h�c
	 * @param strUserID ���݂̑���҂h�c
	 * @return
	 */
	boolean checkRoleCondition(String strCurState, String strUserCondition, String strOrgID,
			String strUserID) {

		boolean bRsult = false;

		User user = new User();

		try {
			// �i���ۏ�
			_logger.info("�J�n");

			if (strUserCondition != null && !strUserCondition.equals("")) {
				if (strUserCondition != null && !strUserCondition.equals("")) {
					// ��������
					StringTokenizer strUserConditionToken = new StringTokenizer(strUserCondition,
							",");

					// �������
					while (strUserConditionToken.hasMoreTokens()) {

						String strCondition = strUserConditionToken.nextToken();

						// **************** "�����/����|����|�c" *******************

						if (strCondition != null && !strCondition.equals("")) {
							// ����Ԃƃ��[�U����
							StringTokenizer strConditionToken = new StringTokenizer(strCondition,
									"/");

							String strStateCond = strConditionToken.nextToken();

							// **************** "�����" *******************

							if (strStateCond != null && strCurState.equals(strStateCond)) {

								String strUserCond = strConditionToken.nextToken();

								// ����Ԃƃ��[�U����
								StringTokenizer strRolesToken = new StringTokenizer(strUserCond,
										"|");

								user = serive.getUser(strUserID,strOrgID);

								String roleName = user.getUserRole().getName();

								while (strRolesToken.hasMoreTokens()) {
									String strRoleName = strRolesToken.nextToken();

									if (roleName.equals(strRoleName)) {

										bRsult = true;

										break;

									}
								}
							}
						}
					}
				}
			}
			// �i���ۏ�
			_logger.info("�I��");
		} catch (Exception e) {
			// �i���ۏ�
			_logger.fatal("�v���I�ȃG���[");

			bRsult = false;
		}

		return bRsult;
	}
	
	

	/**
	 * ���i�̒��ɂ́A�g�D�Ƀ`�F�b�N
	 * 
	 * @param strCurState �����
	 * @param strUserCondition ���[�U����
	 * @param strOrgID ����ґg�D�h�c
	 * @param strUserID ���݂̑���҂h�c
	 * @return
	 */
	boolean checkOrgCondition(String strOrgCondition, String strOrgID,String strCreaterOrg) {

		boolean bResult = false;
		
		if (strOrgCondition != null && !strOrgCondition.equals("")) {
			try {
				Section section = serive.getSectionById(strCreaterOrg);
				String[] orgList = strOrgCondition.replace("*",section.getName()).split(",");
				int orgListLength = orgList.length;
				
				for(int index = 0; index < orgListLength; index++) {
					
						section = serive.getSectionByName(orgList[index]);
					
						if(section.getNo().indexOf(strOrgID) != -1 || strOrgID.indexOf(section.getNo()) != -1){
							bResult = true;
							break;
						}
					}
			}catch(SysException e) {
				// �i���ۏ�
				_logger.fatal("�v���I�ȃG���[");
			}
	}else {
			bResult = true;
		}
		
	 return bResult;
	}
}
