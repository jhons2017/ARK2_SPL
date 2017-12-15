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
	 * 組織の設定
	 * 
	 * @param orgId
	 */
	public void setOrgId(String orgId)
	{
		_orgId = orgId;
	}

	/**
	 * ユーザーIDの設定
	 * 
	 * @param userId
	 */
	public void setUserId(String userId)
	{
		_userId = userId;
	}

	/**
	 * 部品XMLの設定
	 * 
	 * @param partXml
	 */
	public void setPartXml(String partXml)
	{
		_partXml = partXml;
	}

	/**
	 * ジョブファイルの設定
	 * 
	 * @param orgId
	 */
	public void setJob(Document job)
	{
		_job = job;
	}

	/**
	 * タグ初期処理
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
	 * HTMLの作成
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
	 * 操作ボタン部品
	 * 
	 * @param job
	 * @param strOrgID
	 * @param strUserID
	 * @param strPartXml
	 */
	private String partOperatorHtml(Document job, String strOrgID, String strUserID, String strPartXml)
	{
		// 品質保証
		Log logger = LogFactory.getLog(PartCheckCondition.class);
		logger.info("Operateの性能テスト(Start)：" + PartCommon.getCurTime());
		// クライアントＨＴＭＬ
		String strHtml = "";
		
		JobOprater jobOpr = new JobOprater();
		try
		{				

			strHtml = "<table bgcolor='#ffffff' align=right cellpadding='0' cellspacing='1' width='50%'>\n"
					+ "<tr align='center' valign='middle'>\n";

			// 部品ドキュメントを取得する
			Document part = ParseXmlString.getParsedDocument(strPartXml);

			// 案件の現在状態を取得する
			String strCurState = jobOpr.getCurrentState(job);

			// 操作子バッファ
			StringBuffer strbufOperators = new StringBuffer();

			// 動作子バッファ
			StringBuffer strbufActors = new StringBuffer();

			// 操作子名称バッファ
			StringBuffer strbufOprNames = new StringBuffer();

			// 操作子、動作子、操作子名称を取得
			int intOprNum = jobOpr.getCurrentOprInfo(job, strbufOperators, strbufActors, strbufOprNames);

			// 部品Ｓｔｅｐリストを取得する
			NodeList stepList = XmlOperator.getNodeList(part, "step");

			int size = stepList.getLength();
			// 現在Ｓｔｅｐを検索する
			for (int i = 0; i < size; i++)
			{

				// Ｓｔｅｐエレメントを取得
				Element stepElement = XmlOperator.getElement(stepList, i);

				// Ｓｔｅｐ名称を取得する
				String strState = XmlOperator.getAttrValue(stepElement, "name");

				// Ｓｔｅｐ名称と案件状態を比較する
				if (strState.equals(strCurState))
				{

					// 部品の操作子リストを取得する
					NodeList oprList = stepElement.getElementsByTagName("opr");

					int oprListSize = oprList.getLength();
					// 操作子検索
					for (int j = 0; j < oprListSize; j++)
					{

						// 操作子エレメントを取得する
						Element oprElement = XmlOperator.getElement(oprList, j);

						// 操作子名を取得する
						String oprName = XmlOperator.getAttrValue(oprElement, "id");

						// 操作子バッファから分割
						StringTokenizer strbufOperatorsToken = new StringTokenizer(strbufOperators.toString(), ",");

						// 動作子バッファから分割
						StringTokenizer strbufActorsToken = new StringTokenizer(strbufActors.toString(), ",");

						// 操作子名称バッファから分割
						StringTokenizer strbufOprNamesToken = new StringTokenizer(strbufOprNames.toString(), ",");

						// 操作子検索
						for (int k = 0; k < intOprNum; k++)
						{

							// ワークフローで定義した操作子
							String strflowOpr = strbufOperatorsToken.nextToken();

							// ワークフローで定義した動作子
							String strflowAct = strbufActorsToken.nextToken();

							// ワークフローで定義した操作子名称
							String strflowOprName = strbufOprNamesToken.nextToken();

							// 操作子の比較
							if (oprName.equals(strflowOpr))
							{

								String strUserCond = XmlOperator.getAttrValue(oprElement, "user");

								String strRoleCond = XmlOperator.getAttrValue(oprElement, "role");
								
								String strOrgCond = XmlOperator.getAttrValue(oprElement, "org");

								// 必須チェック条件
								String strVitalCond = XmlOperator.getAttrValue(oprElement, "vital_check");

								boolean bCheckRsult = false;
								PartCheckCondition checkCondition = new PartCheckCondition();

								if ((strUserCond != null && !strUserCond.equals(""))
										&& (strRoleCond != null && !strRoleCond.equals("")))
								{

									// 正規条件作成
									strUserCond = strState + "/" + strUserCond;
									strRoleCond = strState + "/" + strRoleCond;

									// 条件解析
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
									// クライアントＨＴＭＬ作成
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
			logger.info("Operateの性能テスト(End)：" + PartCommon.getCurTime());
			// 品質保証
			logger.info("終了");
		}
		catch (Exception e)
		{

			// 品質保証
			logger.fatal("致命的なエラー");

			//
			strHtml = e.toString();
		}
		strHtml = strHtml + "</tr>\n" + "</table>\n";

		strHtml = strHtml + "\n" ;
		return (strHtml);

		
	}

}
