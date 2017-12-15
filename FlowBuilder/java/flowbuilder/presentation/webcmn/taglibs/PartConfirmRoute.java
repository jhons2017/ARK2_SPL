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
	 * HTMLの作成
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
	//承認ルートを表示する部品
	//**************************************************************************************************************
	private String partConfirmRouteHtml( Document job )
	{
		// 品質保証
		Log logger = LogFactory.getLog(PartCheckCondition.class);

		JobOprater jobOpr = new JobOprater();
		
		User user = new User();

		//クライアントＨＴＭＬ
		String strHtml = "";

		//ルート名
		String strRouteName = "";

		//操作者名
		String strOperatorName = "";
		
		//確認時間
		String strTimeName = "";
	
		try
		{
			UserService serive = UserServiceFactory.getUserServiceInstance();
			
			strHtml = "<table bgcolor='#999999' align=center border=0 cellpadding=1 cellspacing=1 width='100%'>\n";

			strRouteName = "<tr bgcolor='#efefef' align='center' valign='middle'>\n";

			strOperatorName = "<tr>\n";
			
			strTimeName = "<tr>\n";

			//WorkFlowのNodeListを取得する
			NodeList workFlowList = XmlOperator.getNodeList(job, "WorkFlow" );

			//WorkFlowのエレメントを取得する
			Element workFlowElement = XmlOperator.getElement( workFlowList, 0 );

			//StepのNodeListを取得する
			NodeList stepList = workFlowElement.getElementsByTagName("step" );

			int strStateNum = 0;

			int stepListSize = stepList.getLength();
			//現在状態を特定する
			for ( int i = 0; i < stepListSize; i++ )
			{
				strStateNum ++;

				//Stepエレメントを取得する
				Element stepElement = XmlOperator.getElement( stepList, i );

				//状態のNodeListを取得する
				NodeList stateList = stepElement.getElementsByTagName("state" );

				//状態のエレメントを取得する
				Element stateElement = XmlOperator.getElement( stateList, 0 );

				//タイトルＨＴＭＬ文作成
				strRouteName = strRouteName + "<td width='100'>" + stateElement.getAttribute( "current" ) + "</td>";

				//操作者と操作内容
				String strOperatorInfo = "";
				
				String strTimeInfo = "";

				if ( stateElement.getAttribute( "active" ).equals("true") )
				{

					//操作者と操作内容
					strOperatorInfo = "<font color=red>○</font>";
				}
				else
				{

					//操作リストを取得する
					NodeList OperatorList = stepElement.getElementsByTagName("opr" );

					//操作者情報を取得する
					String strGotOperator = "";

					//行った操作名を取得する
					String strGotOprName = "";

					int operatorListSize = OperatorList.getLength();
					//条件操作を特定する
					for ( int j = 0; j < operatorListSize; j ++ )
					{
						//操作のエレメントを取得する
						Element OperatorElement = XmlOperator.getElement( OperatorList, j );

						//ユーザーＩＤ情報が入っていれば通過ルートと見なす
						if ( !OperatorElement.getAttribute( "userid" ).equals( "" ) )
						{
							
							user = serive.getUser(OperatorElement.getAttribute( "userid" ));
							//操作者ＩＤを取得する
							strGotOperator = user.getUserName();

							//操作内容
							strGotOprName = OperatorElement.getAttribute( "name" );

							//表示内容
							strOperatorInfo = strGotOperator + ":" + strGotOprName;
							
							strTimeInfo = OperatorElement.getAttribute( "confirmTime" );
						}
					}
				}

				//操作者ＨＴＭＬ文作成
				strOperatorName = strOperatorName + "<td align='center' bgcolor='#ffffff' width='100'>" + strOperatorInfo + "</td>";
				
				strTimeName = strTimeName + "<td align='center' bgcolor='#ffffff' width='100'>" + strTimeInfo + "</td>";  
			}
			strRouteName = strRouteName + "</tr>\n";

			strOperatorName = strOperatorName + "</tr>\n";
			
			strTimeName = strTimeName + "</tr>\n";

			strHtml = strHtml + strRouteName + strOperatorName + strTimeName +
				"<tr><td  bgcolor='#ffffff' colspan=" + String.valueOf(strStateNum) + "><font color=red>○</font>は現在状態です。</td></tr>\n" + 
				"</table>\n";
		
		}
		catch(Exception e)
		{

			//品質保証
			logger.fatal( "致命的なエラー" );

			//
			strHtml = e.toString();
		}

		//
		return( strHtml );
	}
}
