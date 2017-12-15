//package FlowBuilder.taglibs;
//
//import java.util.StringTokenizer;
//
//import javax.servlet.jsp.tagext.BodyTagSupport;
//
//import org.apache.log4j.Category;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.NodeList;
//
//import FlowBuilder.xmlOperate.*;
//import FlowBuilder.quality.*;
//import FlowBuilder.connOper.*;
//
//public final class PartJobCreator extends BodyTagSupport 
//{
//
//	private String _orgId = "";
//
//	private String _userId = "";
//
//	private String _partXml = "";
//
//	/**
//	 * �?織�?�設�?

//	 * 
//	 * @param orgId
//	 */
//	public void setOrgId(String orgId)
//	{
//		_orgId = orgId;
//	}
//
//	/**
//	 * ユーザーIDの設�?

//	 * 
//	 * @param userId
//	 */
//	public void setUserId(String userId)
//	{
//		_userId = userId;
//	}
//
//	/**
//	 * 部品XMLの設�?

//	 * 
//	 * @param partXml
//	 */
//	public void setPartXml(String partXml)
//	{
//		_partXml = partXml;
//	}
//
//	/**
//	 * タグ初期処�?

//	 * 
//	 * @return int
//	 */
//	public int doStartTag()
//	{
//		try
//		{
//			pageContext.getOut().print(toHTML().toString());
//		}
//		catch (java.io.IOException e)
//		{
//			System.out.println("partOrgList:" + "doStartTag" + e.getMessage());
//		}
//		return SKIP_BODY;
//	}
//
//	/**
//	 * HTMLの作�??
//	 * 
//	 * @return StringBuffer
//	 */
//	private StringBuffer toHTML()
//	{
//		StringBuffer html = new StringBuffer();
//
//		try
//		{
//			html.append(partJobCreatorHtml(_orgId, _userId, _partXml));
//		}
//		catch (java.lang.Exception e)
//		{
//			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
//		}
//		return html;
//	}
//
//	/**
//	 * 案件新規作�?��?�タン部�?

//	 * 
//	 * @param strOrgID �?織ID
//	 * @param strUserID ユーザーID
//	 * @param strPartXml 部品Xml
//	 * @return
//	 */
//	private String partJobCreatorHtml( String strOrgID, String strUserID, String strPartXml )
//	{
//		String strHtml = "";
//
//		// 部品オブジェクト作�??
//		qualityBean quality = new qualityBean();
//
//		// 品質保証
//		Category logger = quality.getCategory();
//
//		// ユーザ管�?用オブジェク�?

//		userXmlBean user = null;
//
//		// ?��?��?��接続用オブジェク�?

//		ConnXml conn = null;
//		
//		// ?��?��?��操作用オブジェク�?

//		sdfsdf opr = null;
//
//		try
//		{
//
//			// 品質保証
//			logger.info("開�?");
//			
//			// ユーザ管�?用オブジェク�?

//			user = new userXmlBean(quality);
//			
//			// ?��?��?��接続用オブジェク�?

//			conn = new StringXmlBean(strPartXml,quality);
//
//			// ?��?��?��操作用オブジェク�?

//			opr = new oprXmlOperate(quality);
//
//			strHtml = "<table bgcolor='#ffffff' align=right cellpadding='0' cellspacing='1' width='60%'>\n"
//					+ "<tr align='center' valign='middle'>\n";
//
//			// 役割名称を取�?

//			String roleName = user.getRoleNameByUserID(strOrgID, strUserID);
//
//			// 部品ドキュメント作�??
//			Document part = conn.getConnXml();
//
//			// �?ンプレート（ワークフロー?��リストを取得す�?

//			NodeList templateList = opr.getNodeList(part, "template");
//
//			int templateListSize = templateList.getLength();
//			// 作�?�可能案件を検索
//			for (int i = 0; i < templateListSize; i++)
//			{
//
//				// �?ンプレートエレメントを取�?

//				Element templateElement = opr.getElement(templateList, i);
//
//				// ユーザ条件リストを取�?

//				NodeList userList = templateElement.getElementsByTagName("user");
//
//				int userListSize = userList.getLength();
//				// ユーザ検索
//				for (int j = 0; j < userListSize; j++)
//				{
//
//					// ユーザエレメントを取得す�?

//					Element userElement = opr.getElement(userList, j);
//
//					// ユーザ役割条件を取得す�?

//					String userRole = opr.getAttrValue(userElement, "role");
//
//					// ユーザ役割条件を�??割
//					StringTokenizer strUserRoleToken = new StringTokenizer(userRole, ",");
//
//					// ユーザ役割条件によって操作�??チェ�?ク
//					while (strUserRoleToken.hasMoreTokens())
//					{
//
//						// �?つ役割条件を取得す�?

//						String strRole = strUserRoleToken.nextToken();
//
//						// 役割名称の比�?

//						if (roleName.equals(strRole))
//						{
//
//							// �?ンプレート（ワークフロー?��idを取得す�?

//							String strFileID = opr.getAttrValue(templateElement, "id");
//
//							// �?ンプレートタイトルを取得す�?

//							String strTitle = opr.getAttrValue(templateElement, "title");
//
//							// �?ンプレートビューを取得す�?

//							String strView = opr.getAttrValue(templateElement, "view");
//
//							//
//							strHtml = strHtml + "\n" + "<td>\n" + "<a href = javascript:PostFormforCreate('"
//									+ strFileID + "','" + strView + "','create')>" + strTitle + "</a>\n" + "</td>\n";
//						}
//					}
//				}
//			}
//
//			// 品質保証
//			logger.info("終�?");
//		}
//		catch (Exception e)
//		{
//
//			// 品質保証
//			logger.fatal("致命�?なエラー");
//
//			//
//			strHtml = e.toString();
//		}
//
//		strHtml = strHtml + "</tr>\n" + "</table>\n";
//
//		//
//		strHtml = strHtml + "\n" + 
//		"<SCRIPT LANGUAGE=javascript>\n" + 
//			"<!--\n"
//				+ "function PostFormforCreate( strFlowTemplateID, strViewJsp, strAct )\n" + 
//					"{\n"+ 
//						"document.forms[0].action = 'JobShow';\n" + 
//						"document.forms[0].method.value = 'create';\n"+ 
//						"document.forms[0].templateId.value = strFlowTemplateID;\n"+ 
//						"document.forms[0].view.value = strViewJsp;\n" + 
//						"document.forms[0].act.value = strAct;\n"+ 
//						"document.forms[0].submit();\n" + 
//					"}\n" + 
//				"-->\n" + 
//		"</SCRIPT>\n";
//
//		//
//		return (strHtml);
//	}
//
//}
