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
//	 * çµ?ç¹ã?®è¨­å®?

//	 * 
//	 * @param orgId
//	 */
//	public void setOrgId(String orgId)
//	{
//		_orgId = orgId;
//	}
//
//	/**
//	 * ã¦ã¼ã¶ã¼IDã®è¨­å®?

//	 * 
//	 * @param userId
//	 */
//	public void setUserId(String userId)
//	{
//		_userId = userId;
//	}
//
//	/**
//	 * é¨åXMLã®è¨­å®?

//	 * 
//	 * @param partXml
//	 */
//	public void setPartXml(String partXml)
//	{
//		_partXml = partXml;
//	}
//
//	/**
//	 * ã¿ã°åæå¦ç?

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
//	 * HTMLã®ä½æ??
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
//	 * æ¡ä»¶æ°è¦ä½æ?ã?ã¿ã³é¨å?

//	 * 
//	 * @param strOrgID çµ?ç¹ID
//	 * @param strUserID ã¦ã¼ã¶ã¼ID
//	 * @param strPartXml é¨åXml
//	 * @return
//	 */
//	private String partJobCreatorHtml( String strOrgID, String strUserID, String strPartXml )
//	{
//		String strHtml = "";
//
//		// é¨åãªãã¸ã§ã¯ãä½æ??
//		qualityBean quality = new qualityBean();
//
//		// åè³ªä¿è¨¼
//		Category logger = quality.getCategory();
//
//		// ã¦ã¼ã¶ç®¡ç?ç¨ãªãã¸ã§ã¯ã?

//		userXmlBean user = null;
//
//		// ?¼¸?¼­?¼¬æ¥ç¶ç¨ãªãã¸ã§ã¯ã?

//		ConnXml conn = null;
//		
//		// ?¼¸?¼­?¼¬æä½ç¨ãªãã¸ã§ã¯ã?

//		sdfsdf opr = null;
//
//		try
//		{
//
//			// åè³ªä¿è¨¼
//			logger.info("éå§?");
//			
//			// ã¦ã¼ã¶ç®¡ç?ç¨ãªãã¸ã§ã¯ã?

//			user = new userXmlBean(quality);
//			
//			// ?¼¸?¼­?¼¬æ¥ç¶ç¨ãªãã¸ã§ã¯ã?

//			conn = new StringXmlBean(strPartXml,quality);
//
//			// ?¼¸?¼­?¼¬æä½ç¨ãªãã¸ã§ã¯ã?

//			opr = new oprXmlOperate(quality);
//
//			strHtml = "<table bgcolor='#ffffff' align=right cellpadding='0' cellspacing='1' width='60%'>\n"
//					+ "<tr align='center' valign='middle'>\n";
//
//			// å½¹å²åç§°ãåå¾?

//			String roleName = user.getRoleNameByUserID(strOrgID, strUserID);
//
//			// é¨åãã­ã¥ã¡ã³ãä½æ??
//			Document part = conn.getConnXml();
//
//			// ã?ã³ãã¬ã¼ãï¼ã¯ã¼ã¯ãã­ã¼?¼ãªã¹ããåå¾ãã?

//			NodeList templateList = opr.getNodeList(part, "template");
//
//			int templateListSize = templateList.getLength();
//			// ä½æ?å¯è½æ¡ä»¶ãæ¤ç´¢
//			for (int i = 0; i < templateListSize; i++)
//			{
//
//				// ã?ã³ãã¬ã¼ãã¨ã¬ã¡ã³ããåå¾?

//				Element templateElement = opr.getElement(templateList, i);
//
//				// ã¦ã¼ã¶æ¡ä»¶ãªã¹ããåå¾?

//				NodeList userList = templateElement.getElementsByTagName("user");
//
//				int userListSize = userList.getLength();
//				// ã¦ã¼ã¶æ¤ç´¢
//				for (int j = 0; j < userListSize; j++)
//				{
//
//					// ã¦ã¼ã¶ã¨ã¬ã¡ã³ããåå¾ãã?

//					Element userElement = opr.getElement(userList, j);
//
//					// ã¦ã¼ã¶å½¹å²æ¡ä»¶ãåå¾ãã?

//					String userRole = opr.getAttrValue(userElement, "role");
//
//					// ã¦ã¼ã¶å½¹å²æ¡ä»¶ãå??å²
//					StringTokenizer strUserRoleToken = new StringTokenizer(userRole, ",");
//
//					// ã¦ã¼ã¶å½¹å²æ¡ä»¶ã«ãã£ã¦æä½è??ãã§ã?ã¯
//					while (strUserRoleToken.hasMoreTokens())
//					{
//
//						// ä¸?ã¤å½¹å²æ¡ä»¶ãåå¾ãã?

//						String strRole = strUserRoleToken.nextToken();
//
//						// å½¹å²åç§°ã®æ¯è¼?

//						if (roleName.equals(strRole))
//						{
//
//							// ã?ã³ãã¬ã¼ãï¼ã¯ã¼ã¯ãã­ã¼?¼idãåå¾ãã?

//							String strFileID = opr.getAttrValue(templateElement, "id");
//
//							// ã?ã³ãã¬ã¼ãã¿ã¤ãã«ãåå¾ãã?

//							String strTitle = opr.getAttrValue(templateElement, "title");
//
//							// ã?ã³ãã¬ã¼ããã¥ã¼ãåå¾ãã?

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
//			// åè³ªä¿è¨¼
//			logger.info("çµäº?");
//		}
//		catch (Exception e)
//		{
//
//			// åè³ªä¿è¨¼
//			logger.fatal("è´å½ç?ãªã¨ã©ã¼");
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
