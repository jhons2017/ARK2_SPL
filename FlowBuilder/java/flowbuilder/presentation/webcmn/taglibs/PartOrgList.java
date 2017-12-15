//package FlowBuilder.taglibs;
//
//import java.util.StringTokenizer;
//
//import javax.servlet.jsp.tagext.BodyTagSupport;
//
//import org.apache.log4j.Category;
//
//import FlowBuilder.xmlOperate.*;
//import FlowBuilder.quality.*;
//
//public final class partOrgList extends BodyTagSupport
//{
//
//	private String _userId = "";
//
//	private String _password = "";
//
//	/**
//	 * ユーザーIDの設定
//	 * 
//	 * @param userId
//	 */
//	public void setUserId(String userId)
//	{
//		_userId = userId;
//	}
//
//	/**
//	 * パスワードの設定
//	 * 
//	 * @param password
//	 */
//	public void setPassword(String password)
//	{
//		_password = password;
//	}
//
//	/**
//	 * タグ初期処理
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
//	 * HTMLの作成
//	 * 
//	 * @return StringBuffer
//	 */
//	private StringBuffer toHTML()
//	{
//		StringBuffer html = new StringBuffer();
//
//		try
//		{
//			html.append(partOrgListHtml(_userId, _password));
//
//		}
//		catch (java.lang.Exception e)
//		{
//			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
//		}
//		return html;
//	}
//
//	/**
//	 * ログオンユーザーに対応する組織一覧を表示する部品
//	 * 
//	 * @param strUserId ユーザーID
//	 * @param strPassword パスワード
//	 * 
//	 * @return String クライアントＨＴＭＬ
//	 */
//	private String partOrgListHtml(String strUserId, String strPassword)
//	{
//
//		// クライアントＨＴＭＬ
//		String strHtml = "";
//		// 部品オブジェクト作成
//		qualityBean quality = new qualityBean();
//
//		// 品質保証
//		Category logger = quality.getCategory();
//
//		// ユーザ管理用オブジェクト
//		userXmlBean user = null;
//
//		try
//		{
//			// ユーザ管理用オブジェクト
//			user = new userXmlBean(quality);
//
//			// 組織ＩＤバッファー
//			StringBuffer strBufOrgId = new StringBuffer();
//
//			// 組織名バッファー
//			StringBuffer strBufOrgName = new StringBuffer();
//
//			// 組織個数
//			int intOrgNum = 0;
//
//			// ユーザの組織情報を取得する
//			intOrgNum = user.getUserOrgInfo(strUserId, strPassword, strBufOrgId, strBufOrgName);
//
//			strHtml = strHtml + "<table bgcolor='#999999' align=center border=0 cellpadding=1 cellspacing=1 width='60%'>\n" +
//					"<tr bgcolor='#efefef' align='center' valign='middle'>\n" + 
//					"<td height=22 width='400'> 組織名称／役割名称 </td>\n" +
//					"<td height=22 width='200'> 組織ＩＤ／役割ＩＤ </td>\n" +
//					"</tr>\n";
//
//			// 所属組織ＩＤを取得
//			StringTokenizer strOrgIdToken = new StringTokenizer(strBufOrgId.toString(), ",");
//
//			// 組織名を取得
//			StringTokenizer strOrgNameToken = new StringTokenizer(strBufOrgName.toString(), ",");
//
//			// ＨＴＭＬ文作成
//			for (int i = 0; i < intOrgNum; i++)
//			{
//
//				// 一つのＩＤを取得する
//				String strOrgId = strOrgIdToken.nextToken();
//
//				// 一つの組織名を取得する
//				String strOrgName = strOrgNameToken.nextToken();
//
//				// 役割名を取得する
//				String strRoleName = user.getRoleNameByUserID(strOrgId, strUserId);
//
//				// 役割ＩＤを取得する
//				String strRoleId = user.getUserRole(strUserId, strOrgId);
//
//				// ＨＴＭＬ文作成
//				strHtml = strHtml + "<tr align='center' bgcolor='#ffffff' valign='middle'>\n"
//						+ "<td height=25><a href=javascript:postform('" + strOrgId + "')>" + strOrgName + "／"
//						+ strRoleName + "</a></td>\n" + "<td height=25>" + strOrgId + "／" + strRoleId + "</td>\n"
//						+ "</tr>\n";
//			}
//
//			strHtml = strHtml + "</table>\n";
//
//			strHtml = strHtml + "<SCRIPT LANGUAGE=javascript>\n" + 
//					"<!--\n" + 
//						"function postform( strOrgId )\n" + 
//						"{\n" +
//							"document.forms[0].orgId.value = strOrgId;\n" + 
//							"document.forms[0].submit();\n" + 
//						"}\n" + 
//					"-->\n" + 
//					"</SCRIPT>\n";
//
//		}
//		catch (Exception e)
//		{
//
//			// 品質保証
//			logger.fatal("致命的なエラー");
//
//			//
//			strHtml = e.toString();
//		}
//
//		return strHtml;
//	}
//
//}
