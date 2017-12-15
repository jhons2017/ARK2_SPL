package flowbuilder.presentation.webcmn.taglibs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import flowbuilder.application.user.UserService;
import flowbuilder.application.user.UserServiceFactory;
import flowbuilder.application.util.JobOprater;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.domain.user.User;

public final class PartConfirmRoute extends PartParent {

	/**
	 * HTML�̍쐬
	 * 
	 * @return StringBuffer
	 */
	protected StringBuffer toHTML()
	{
		StringBuffer html = new StringBuffer();

		try
		{
			html.append(partConfirmRouteHtml(_job));
		}
		catch (java.lang.Exception e)
		{
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}

	//**************************************************************************************************************
	//���F���[�g��\�����镔�i
	//**************************************************************************************************************
	private String partConfirmRouteHtml( Document job )
	{
		// �i���ۏ�
		Log logger = LogFactory.getLog(PartCheckCondition.class);

		JobOprater jobOpr = new JobOprater();
		
		User user = new User();

		//�N���C�A���g�g�s�l�k
		String strHtml = "";

		//���[�g��
		String strRouteName = "";

		//����Җ�
		String strOperatorName = "";
		
		//�m�F����
		String strTimeName = "";
	
		try
		{
			UserService serive = UserServiceFactory.getUserServiceInstance();
			
			strHtml = "<table bgcolor='#999999' align=center border=0 cellpadding=1 cellspacing=1 width='100%'>\n";

			strRouteName = "<tr bgcolor='#efefef' align='center' valign='middle'>\n";

			strOperatorName = "<tr>\n";
			
			strTimeName = "<tr>\n";

			//WorkFlow��NodeList���擾����
			NodeList workFlowList = XmlOperator.getNodeList(job, "WorkFlow" );

			//WorkFlow�̃G�������g���擾����
			Element workFlowElement = XmlOperator.getElement( workFlowList, 0 );

			//Step��NodeList���擾����
			NodeList stepList = workFlowElement.getElementsByTagName("step" );

			int strStateNum = 0;

			int stepListSize = stepList.getLength();
			//���ݏ�Ԃ���肷��
			for ( int i = 0; i < stepListSize; i++ )
			{
				strStateNum ++;

				//Step�G�������g���擾����
				Element stepElement = XmlOperator.getElement( stepList, i );

				//��Ԃ�NodeList���擾����
				NodeList stateList = stepElement.getElementsByTagName("state" );

				//��Ԃ̃G�������g���擾����
				Element stateElement = XmlOperator.getElement( stateList, 0 );

				//�^�C�g���g�s�l�k���쐬
				strRouteName = strRouteName + "<td width='100'>" + stateElement.getAttribute( "current" ) + "</td>";

				//����҂Ƒ�����e
				String strOperatorInfo = "";
				
				String strTimeInfo = "";

				if ( stateElement.getAttribute( "active" ).equals("true") )
				{

					//����҂Ƒ�����e
					strOperatorInfo = "<font color=red>��</font>";
				}
				else
				{

					//���샊�X�g���擾����
					NodeList OperatorList = stepElement.getElementsByTagName("opr" );

					//����ҏ����擾����
					String strGotOperator = "";

					//�s�������얼���擾����
					String strGotOprName = "";

					int operatorListSize = OperatorList.getLength();
					//�����������肷��
					for ( int j = 0; j < operatorListSize; j ++ )
					{
						//����̃G�������g���擾����
						Element OperatorElement = XmlOperator.getElement( OperatorList, j );

						//���[�U�[�h�c��񂪓����Ă���Βʉ߃��[�g�ƌ��Ȃ�
						if ( !OperatorElement.getAttribute( "userid" ).equals( "" ) )
						{
							
							user = serive.getUser(OperatorElement.getAttribute( "userid" ));
							//����҂h�c���擾����
							strGotOperator = user.getUserName();

							//������e
							strGotOprName = OperatorElement.getAttribute( "name" );

							//�\�����e
							strOperatorInfo = strGotOperator + ":" + strGotOprName;
							
							strTimeInfo = OperatorElement.getAttribute( "confirmTime" );
						}
					}
				}

				//����҂g�s�l�k���쐬
				strOperatorName = strOperatorName + "<td align='center' bgcolor='#ffffff' width='100'>" + strOperatorInfo + "</td>";
				
				strTimeName = strTimeName + "<td align='center' bgcolor='#ffffff' width='100'>" + strTimeInfo + "</td>";  
			}
			strRouteName = strRouteName + "</tr>\n";

			strOperatorName = strOperatorName + "</tr>\n";
			
			strTimeName = strTimeName + "</tr>\n";

			strHtml = strHtml + strRouteName + strOperatorName + strTimeName +
				"<tr><td  bgcolor='#ffffff' colspan=" + String.valueOf(strStateNum) + "><font color=red>��</font>�͌��ݏ�Ԃł��B</td></tr>\n" + 
				"</table>\n";
		
		}
		catch(Exception e)
		{

			//�i���ۏ�
			logger.fatal( "�v���I�ȃG���[" );

			//
			strHtml = e.toString();
		}

		//
		return( strHtml );
	}
}
