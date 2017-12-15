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
	// 品質保証
	private Log _logger = null;

	private UserService serive = null;

	public PartCheckCondition() {

		try {
			// 品質保証
			_logger = LogFactory.getLog(PartCheckCondition.class);

			serive = UserServiceFactory.getUserServiceInstance();
		} catch (Exception e) {

			// 品質保証
			_logger.fatal("致命的なエラー");

		}

	}

	/**
	 * 部品の中には、ユーザにチェック
	 * 
	 * @param job 案件ドキュメント
	 * @param strCurState 現状態
	 * @param strUserCondition ユーザ条件
	 * @param strUserId 現在の操作者ＩＤ
	 * @return
	 */
	boolean checkUserCondition(Document job, String strCurState, String strUserCondition,
			String strUserId)

	{

		boolean bRsult = false;

		try {

			// 品質保証
			_logger.info("開始");

			if (strUserCondition != null && !strUserCondition.equals("")) {
				// **************** "現状態/状態:操作,現状態/状態:操作,…" *******************
				// 条件分離
				StringTokenizer strUserConditionToken = new StringTokenizer(strUserCondition, ",");

				// 条件解析
				while (strUserConditionToken.hasMoreTokens()) {

					String strCondition = strUserConditionToken.nextToken();

					// **************** "現状態/状態:操作" *******************

					if (strCondition != null && !strCondition.equals("")) {
						// 現状態とユーザ分離
						StringTokenizer strConditionToken = new StringTokenizer(strCondition, "/");

						String strStateCond = strConditionToken.nextToken();

						// **************** "現状態" *******************

						if (strStateCond.equals(strCurState)) {

							String strUserCond = strConditionToken.nextToken();

							// **************** "状態:操作" *******************

							if (strUserCond != null && !strUserCond.equals("")) {
								// 現状態とユーザ分離
								StringTokenizer strUserToken = new StringTokenizer(strUserCond, ":");

								// 状態
								String strState = strUserToken.nextToken();

								// **************** "状態" *******************

								String strOperator = strUserToken.nextToken();

								// **************** "操作" *******************

								// WorkFlowのNodeListを取得する
								NodeList WorkFlowList = XmlOperator.getNodeList(job, "WorkFlow");

								// WorkFlowのエレメントを取得する
								Element WorkFlowElement = XmlOperator.getElement(WorkFlowList, 0);

								// StepのNodeListを取得する
								NodeList StepList = WorkFlowElement.getElementsByTagName("step");

								int stepListSize = StepList.getLength();
								// 現在状態を特定する
								for (int i = 0; i < stepListSize; i++) {
									// Stepエレメントを取得する
									Element StepElement = XmlOperator.getElement(StepList, i);

									// 状態のNodeListを取得する
									NodeList StateList = StepElement.getElementsByTagName("state");

									// 状態のエレメントを取得する
									Element StateElement = XmlOperator.getElement(StateList, 0);

									// 条件の状態かどうかのチェック
									if (StateElement.getAttribute("current").equals(strState)) {

										// 操作リストを取得する
										NodeList OperatorList = StepElement
												.getElementsByTagName("opr");

										int operatorListSize = OperatorList.getLength();
										// 条件操作を特定する
										for (int j = 0; j < operatorListSize; j++) {
											// 操作のエレメントを取得する
											Element OperatorElement = XmlOperator.getElement(
													OperatorList, j);

											// 条件の操作かどうかのチェック
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

			// 品質保証
			_logger.info("終了");
		} catch (Exception e) {

			// 品質保証
			_logger.fatal("致命的なエラー");
		}

		return bRsult;

	}

	/**
	 * 部品の中には、ルールにチェック
	 * 
	 * @param strCurState 現状態
	 * @param strUserCondition ユーザ条件
	 * @param strOrgID 操作者組織ＩＤ
	 * @param strUserID 現在の操作者ＩＤ
	 * @return
	 */
	boolean checkRoleCondition(String strCurState, String strUserCondition, String strOrgID,
			String strUserID) {

		boolean bRsult = false;

		User user = new User();

		try {
			// 品質保証
			_logger.info("開始");

			if (strUserCondition != null && !strUserCondition.equals("")) {
				if (strUserCondition != null && !strUserCondition.equals("")) {
					// 条件分離
					StringTokenizer strUserConditionToken = new StringTokenizer(strUserCondition,
							",");

					// 条件解析
					while (strUserConditionToken.hasMoreTokens()) {

						String strCondition = strUserConditionToken.nextToken();

						// **************** "現状態/役割|役割|…" *******************

						if (strCondition != null && !strCondition.equals("")) {
							// 現状態とユーザ分離
							StringTokenizer strConditionToken = new StringTokenizer(strCondition,
									"/");

							String strStateCond = strConditionToken.nextToken();

							// **************** "現状態" *******************

							if (strStateCond != null && strCurState.equals(strStateCond)) {

								String strUserCond = strConditionToken.nextToken();

								// 現状態とユーザ分離
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
			// 品質保証
			_logger.info("終了");
		} catch (Exception e) {
			// 品質保証
			_logger.fatal("致命的なエラー");

			bRsult = false;
		}

		return bRsult;
	}
	
	

	/**
	 * 部品の中には、組織にチェック
	 * 
	 * @param strCurState 現状態
	 * @param strUserCondition ユーザ条件
	 * @param strOrgID 操作者組織ＩＤ
	 * @param strUserID 現在の操作者ＩＤ
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
				// 品質保証
				_logger.fatal("致命的なエラー");
			}
	}else {
			bResult = true;
		}
		
	 return bResult;
	}
}
