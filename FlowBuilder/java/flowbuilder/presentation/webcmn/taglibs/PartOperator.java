package flowbuilder.presentation.webcmn.taglibs;

import java.util.StringTokenizer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import flowbuilder.application.util.JobOprater;
import flowbuilder.application.util.ParseXmlString;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.presentation.webcmn.taglibs.common.PartCommon;


public final class PartOperator extends BodyTagSupport
{
	private String _orgId = "";

	private String _userId = "";

	private String _partXml = "";

	private Document _job = null;

	/**
	 * �g�D�̐ݒ�
	 * 
	 * @param orgId
	 */
	public void setOrgId(String orgId)
	{
		_orgId = orgId;
	}

	/**
	 * ���[�U�[ID�̐ݒ�
	 * 
	 * @param userId
	 */
	public void setUserId(String userId)
	{
		_userId = userId;
	}

	/**
	 * ���iXML�̐ݒ�
	 * 
	 * @param partXml
	 */
	public void setPartXml(String partXml)
	{
		_partXml = partXml;
	}

	/**
	 * �W���u�t�@�C���̐ݒ�
	 * 
	 * @param orgId
	 */
	public void setJob(Document job)
	{
		_job = job;
	}

	/**
	 * �^�O��������
	 * 
	 * @return int
	 */
	public int doStartTag()
	{
		try
		{
			pageContext.getOut().print(toHTML().toString());
		}
		catch (java.io.IOException e)
		{
			System.out.println("partOrgList:" + "doStartTag" + e.getMessage());
		}
		return SKIP_BODY;
	}
	
    public int doEndTag() throws JspException
	{
		return EVAL_PAGE;
	}

	/**
	 * HTML�̍쐬
	 * 
	 * @return StringBuffer
	 */
	private StringBuffer toHTML()
	{
		StringBuffer html = new StringBuffer();
		try
		{
			html.append(partOperatorHtml(_job, _orgId, _userId, _partXml));
		}
		catch (java.lang.Exception e)
		{
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}

	/**
	 * ����{�^�����i
	 * 
	 * @param job
	 * @param strOrgID
	 * @param strUserID
	 * @param strPartXml
	 */
	private String partOperatorHtml(Document job, String strOrgID, String strUserID, String strPartXml)
	{
		// �i���ۏ�
		Log logger = LogFactory.getLog(PartCheckCondition.class);
		logger.info("Operate�̐��\�e�X�g(Start)�F" + PartCommon.getCurTime());
		// �N���C�A���g�g�s�l�k
		String strHtml = "";
		
		JobOprater jobOpr = new JobOprater();
		try
		{				

			strHtml = "<table bgcolor='#ffffff' align=right cellpadding='0' cellspacing='1' width='50%'>\n"
					+ "<tr align='center' valign='middle'>\n";

			// ���i�h�L�������g���擾����
			Document part = ParseXmlString.getParsedDocument(strPartXml);

			// �Č��̌��ݏ�Ԃ��擾����
			String strCurState = jobOpr.getCurrentState(job);

			// ����q�o�b�t�@
			StringBuffer strbufOperators = new StringBuffer();

			// ����q�o�b�t�@
			StringBuffer strbufActors = new StringBuffer();

			// ����q���̃o�b�t�@
			StringBuffer strbufOprNames = new StringBuffer();

			// ����q�A����q�A����q���̂��擾
			int intOprNum = jobOpr.getCurrentOprInfo(job, strbufOperators, strbufActors, strbufOprNames);

			// ���i�r���������X�g���擾����
			NodeList stepList = XmlOperator.getNodeList(part, "step");

			int size = stepList.getLength();
			// ���݂r����������������
			for (int i = 0; i < size; i++)
			{

				// �r�������G�������g���擾
				Element stepElement = XmlOperator.getElement(stepList, i);

				// �r���������̂��擾����
				String strState = XmlOperator.getAttrValue(stepElement, "name");

				// �r���������̂ƈČ���Ԃ��r����
				if (strState.equals(strCurState))
				{

					// ���i�̑���q���X�g���擾����
					NodeList oprList = stepElement.getElementsByTagName("opr");

					int oprListSize = oprList.getLength();
					// ����q����
					for (int j = 0; j < oprListSize; j++)
					{

						// ����q�G�������g���擾����
						Element oprElement = XmlOperator.getElement(oprList, j);

						// ����q�����擾����
						String oprName = XmlOperator.getAttrValue(oprElement, "id");

						// ����q�o�b�t�@���番��
						StringTokenizer strbufOperatorsToken = new StringTokenizer(strbufOperators.toString(), ",");

						// ����q�o�b�t�@���番��
						StringTokenizer strbufActorsToken = new StringTokenizer(strbufActors.toString(), ",");

						// ����q���̃o�b�t�@���番��
						StringTokenizer strbufOprNamesToken = new StringTokenizer(strbufOprNames.toString(), ",");

						// ����q����
						for (int k = 0; k < intOprNum; k++)
						{

							// ���[�N�t���[�Œ�`��������q
							String strflowOpr = strbufOperatorsToken.nextToken();

							// ���[�N�t���[�Œ�`��������q
							String strflowAct = strbufActorsToken.nextToken();

							// ���[�N�t���[�Œ�`��������q����
							String strflowOprName = strbufOprNamesToken.nextToken();

							// ����q�̔�r
							if (oprName.equals(strflowOpr))
							{

								String strUserCond = XmlOperator.getAttrValue(oprElement, "user");

								String strRoleCond = XmlOperator.getAttrValue(oprElement, "role");
								
								String strOrgCond = XmlOperator.getAttrValue(oprElement, "org");

								// �K�{�`�F�b�N����
								String strVitalCond = XmlOperator.getAttrValue(oprElement, "vital_check");

								boolean bCheckRsult = false;
								PartCheckCondition checkCondition = new PartCheckCondition();

								if ((strUserCond != null && !strUserCond.equals(""))
										&& (strRoleCond != null && !strRoleCond.equals("")))
								{

									// ���K�����쐬
									strUserCond = strState + "/" + strUserCond;
									strRoleCond = strState + "/" + strRoleCond;

									// �������
									if (checkCondition.checkUserCondition(job, strState, strUserCond, strUserID)
											&& checkCondition.checkRoleCondition(strState, strRoleCond, strOrgID,
													strUserID))
									{
										bCheckRsult = true;
									}
								}
								else if (strUserCond != null && !strUserCond.equals(""))
								{
									strUserCond = strState + "/" + strUserCond;
									if (checkCondition.checkUserCondition(job, strState, strUserCond, strUserID))
									{

										bCheckRsult = true;

									}
								}
								else if (strRoleCond != null && !strRoleCond.equals(""))
								{
									strRoleCond = strState + "/" + strRoleCond;
 									if (checkCondition.checkRoleCondition(strState, strRoleCond, strOrgID, strUserID)
 											 && checkCondition.checkOrgCondition(strOrgCond,strOrgID,jobOpr.getOrgID(job)))
									{

										bCheckRsult = true;

									}
								}

								if (bCheckRsult == true)
								{
									// �N���C�A���g�g�s�l�k�쐬
									strHtml = strHtml + "\n<td  nowrap><a href=javascript:checkform('" + strflowOpr + "','"
											+ strflowAct + "','" + strVitalCond + "')>" + strflowOprName
											+ "</a></td>\n";

									break;
								}
							}
						}
					}
				}
			}
			logger.info("Operate�̐��\�e�X�g(End)�F" + PartCommon.getCurTime());
			// �i���ۏ�
			logger.info("�I��");
		}
		catch (Exception e)
		{

			// �i���ۏ�
			logger.fatal("�v���I�ȃG���[");

			//
			strHtml = e.toString();
		}
		strHtml = strHtml + "</tr>\n" + "</table>\n";

		strHtml = strHtml + "\n" ;
		return (strHtml);

		
	}

}
