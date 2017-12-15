package flowbuilder.presentation.webcmn.taglibs;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import flowbuilder.application.util.ParseXmlString;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.domain.user.UserRole;
import flowbuilder.presentation.webcmn.taglibs.application.joblist.JobListService;
import flowbuilder.presentation.webcmn.taglibs.application.joblist.JobListServiceFactory;
import flowbuilder.presentation.webcmn.taglibs.common.PartCommon;
import flowbuilder.presentation.webcmn.taglibs.domain.joblist.Condition;
import flowbuilder.presentation.webcmn.taglibs.domain.joblist.Status;
import flowbuilder.presentation.webcmn.taglibs.domain.joblist.UserCondition;
import flowbuilder.presentation.webcmn.taglibs.view.joblist.JobDTO;
import flowbuilder.presentation.webcmn.taglibs.domain.page.PageInfo;

public final class PartJobList extends PartParent {

	// 最大表示案件名桁数 
	private static int MAX_JOBNAME_LEN = 30;
	/**
	 * HTMLの作成
	 * 
	 * @return StringBuffer
	 */
	protected StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();

		try {
			html.append(partJobListHtml(_pInfo, _orgId, _userId, _userRole,_partXml));

		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}

	/**
	 * 案件一覧表示部品
	 * 
	 * @param strOrgID
	 * @param strUserID
	 * @param strPartXml
	 * @return
	 */
	private StringBuffer partJobListHtml(PageInfo pInfo, String strOrgID, String strUserID, UserRole userRole, String strPartXml ) {		
		
		// ログ
		Log logger = LogFactory.getLog(PartJobList.class);
		logger.info("ジョブリストの性能テスト(Start)：" + PartCommon.getCurTime());
		Condition cond = null;
		
		Status status = null;
		
		UserCondition usercond = null;
		
		List<JobDTO> joblistDTO = null;

		StringBuffer strHtml = new StringBuffer();
		
		Document joblistdoc = null;
		try {
			
			// 品質保証
			logger.info( "開始" );
			
			JobListService service = JobListServiceFactory.getOrgListServiceInstance();
			
			strHtml.append("<table bgcolor='#999999' width=780px align=left border=0 cellpadding=1 cellspacing=1>\n");
			strHtml.append("<tr bgcolor='#efefef' align='center' valign='center'>\n"); 
			strHtml.append("<td height=25 width='10%'>番号</td>\n"); 
			strHtml.append("<td height=25 width='25%'>分類</td>\n"); 
			strHtml.append("<td height=25 width='20%'>案件名</td>\n"); 
			strHtml.append("<td height=25 width='15%'>作成者</td>\n"); 
			strHtml.append("<td height=25 width='15%'>状態</td>\n"); 
			strHtml.append("<td height=25 width='10%'>作成時間</td>\n"); 
			strHtml.append("</tr>\n"); 
	
			
			joblistdoc = ParseXmlString.getParsedDocument(strPartXml);
			
			// テンプレート（ワークフロー）リストを取得する
			NodeList templateList = XmlOperator.getNodeList( joblistdoc, "template" );
	
			int templateSize = templateList.getLength();
			
			List<Condition> condList = new ArrayList<Condition>();
			// 作成可能案件を検索
			for (int i = 0; i < templateSize; i ++ )
			{
				cond = new Condition();
				
				// テンプレートエレメントを取得
				Element templateElement = XmlOperator.getElement( templateList, i );
	
				String strTemplateID = XmlOperator.getAttrValue( templateElement, "id" );
				
				String strTemplateTitle = XmlOperator.getAttrValue( templateElement, "title" );
				
				// ユーザ条件リストを取得
				NodeList conList = templateElement.getElementsByTagName("con");
	
				int conListSize = conList.getLength();
			
				List<Status> statusList = new ArrayList<Status>();
				for (int j = 0; j < conListSize; j ++ )
				{
					
					status = new Status();
					
					// テンプレートエレメントを取得
					Element statusElement = XmlOperator.getElement( conList, j );
					
					String sta = XmlOperator.getAttrValue( statusElement, "status" );
					
					// ユーザ条件リストを取得
					NodeList userList = statusElement.getElementsByTagName("user");
					
					int userSize = userList.getLength();
					
					List<UserCondition> userCondList = new ArrayList<UserCondition>();
					
					for (int k = 0; k < userSize; k ++ ){					
						usercond = new UserCondition();
						
						// テンプレートエレメントを取得
						Element roleElement = XmlOperator.getElement( userList, k );
						
						String role = XmlOperator.getAttrValue( roleElement, "role" );
						
						String orgList =  XmlOperator.getAttrValue( roleElement, "org" );
						
						String useridList =  XmlOperator.getAttrValue( roleElement, "userid" );
						
						String[] orgArray = orgList.split(",");
						
						String[] useridArray = useridList.split(",");
	
						usercond.setRole(role);
						usercond.setOrgList(orgArray);
						usercond.setUserIdList(useridArray);
						
						userCondList.add(usercond);
					}
					
					status.setStatus(sta);
					status.setUserList(userCondList);
					
					statusList.add(status);
					
				}
					cond.setTempId(strTemplateID);
					cond.setTempTitle(strTemplateTitle);
					cond.setStatus(statusList);
					condList.add(cond);
			}
			
			joblistDTO =  service.getJobListDTO(condList,strUserID,strOrgID,userRole);
			
			if (joblistDTO.size() != 0) {
				strHtml.append(addHtml(joblistDTO, pInfo));
			} else {
				if (pInfo.getRecordCountNumber() == 0) {
					pInfo.setCurrentPage(0);
				}
				strHtml.append("<tr align='center' bgcolor='#ffffff' valign='middle'>\n");
				strHtml.append("<td height=25 colspan='6'><font color='red'>レコードが無し！</font></td>\n");
				strHtml.append("</tr>\n");
			}
			strHtml.append("</table>\n");
	
			strHtml.append("<SCRIPT LANGUAGE=javascript>\n");
			strHtml.append("<!--\n");
			strHtml.append("function partJobList_PostForm( strJspFileName, strJobNumber, strAct )\n");
			strHtml.append("{\n");
			strHtml.append("document.forms[0].jobId.value = strJobNumber;\n");
			strHtml.append("document.forms[0].view.value = strJspFileName;\n");
			strHtml.append("document.forms[0].act.value = strAct;\n");
			strHtml.append("document.forms[0].submit();\n");
			strHtml.append("}\n");
			strHtml.append("-->\n");
			strHtml.append("</SCRIPT>\n");
	
		}
		catch(Exception e){
			logger.fatal(e.getStackTrace());
		}
				
		logger.info("ジョブリストの性能テスト(END)：" + PartCommon.getCurTime());
		return( strHtml );
	}

	/**
	 * レコードを作成する
	 * 
	 * @param joblistDTO　ジョブリスト
	 * @return　StringBuffer　strHtml　レコードのHTMLを返す
	 */
	private StringBuffer addHtml(List<JobDTO> joblistDTO, PageInfo pInfo) {
		StringBuffer strHtml = new StringBuffer();
		String sbColor = "";
		int joblistDTOLength = joblistDTO.size();
		int firtNumber = 0;
		if(pInfo.getMethod() == "showFirst" || pInfo.getMethod() == "jobDetail") {
			int recordPerPage = pInfo.getRecordPerPage();
			pInfo.setRecordCountNumber(joblistDTOLength);
			if(recordPerPage <= joblistDTOLength) {
				joblistDTOLength = recordPerPage;
			}
		} else if (pInfo.getMethod() == "showPrivious") {
			int temp;
			if(pInfo.getPreviousPageNumber() < 0) {
				pInfo.setCurrentPage(1);
				temp = 0;
			} else {
				temp = pInfo.getPreviousPageNumber();
			}
			firtNumber = temp * pInfo.getRecordPerPage();
			joblistDTOLength = firtNumber + pInfo.getRecordPerPage();
			if(joblistDTOLength > joblistDTO.size()) {
				joblistDTOLength = joblistDTO.size();
			}
		} else if (pInfo.getMethod() == "showNext") {
			int temp; 
	
			if(pInfo.getCurrentPage() >= pInfo.getPageCountNumber()) {
				pInfo.setCurrentPage(pInfo.getPageCountNumber());
				temp = pInfo.getPreviousPageNumber();
				firtNumber = temp * pInfo.getRecordPerPage();
			} else { 
				temp = pInfo.getPreviousPageNumber();
				firtNumber = temp * pInfo.getRecordPerPage();
				joblistDTOLength = firtNumber + pInfo.getRecordPerPage();
			}
		} else if (pInfo.getMethod() == "showLast") {
			int temp;
			pInfo.setCurrentPage(pInfo.getPageCountNumber());
			temp = pInfo.getPreviousPageNumber();
			pInfo.getLastPageNumber();
			firtNumber = temp * pInfo.getRecordPerPage();
		}
		for(int i=firtNumber;i<joblistDTOLength;i++){
			JobDTO job = joblistDTO.get(i);
			if (i%2 == 0) {
				sbColor = "#ffffff";
			} else {
				sbColor = "#ffff99";
			}
			// レコードを作成する
			strHtml.append("<tr align='center' bgcolor='"+sbColor+"' valign='middle'>\n");
			strHtml.append("<td height=25><input type='hidden' name='recordId'>");
			strHtml.append(job.getJobNo());
			strHtml.append("</td>\n");
			strHtml.append("<td height=25>");
			strHtml.append(job.getJobClassName());
			strHtml.append("</td>\n");
			strHtml.append("<td height=25>\n");
			strHtml.append("<a href=javascript:partJobList_PostForm('");
			strHtml.append(job.getJobJspFileName());
			strHtml.append("','");
			strHtml.append(job.getJobId());
			strHtml.append("','open')>");
			
			// チップヘルプ機能を追加
			strHtml.append("<SPAN onMouseover=\"sDomChipHelp('divChip',event.x,event.y,'"
							+ PartCommon.stringBrowseReturn(job.getJobTitle())
							+ "',2)\" onMouseout=\"hChipHelp('divChip')\">"
							+ PartCommon.stringBrowseReturn(getShortString(job.getJobTitle(), MAX_JOBNAME_LEN))
							+ "</SPAN>");
			strHtml.append("</a>\n");
			strHtml.append("</td>\n");
			strHtml.append("<td height=25>");
			strHtml.append(job.getJobCreateName());
			strHtml.append("</td>\n");
			strHtml.append("<td height=25><font color='black'>");
			strHtml.append(job.getJobState());
			strHtml.append("</font></td>\n");
			strHtml.append("<td height=25>");
			strHtml.append(job.getJobTime());
			strHtml.append("</td></tr>\n");
		}

		//　レコードのHTMLを返す
		return strHtml;
	}

	/**
	 * 対象文字列の先頭から、指定したバイト数の文字を抜き出します。
	 * 終了位置が2バイト文字の1バイト目を指定していた場合、その文字は切り捨てる。 
	 * 
	 * @param str 対象文字列, nByte 抜き出すバイト数
	 * @return　String　str　抜き出された文字列
	 */
	private String getShortString(String str, int nByte) {
		if (str != null || "".equals(str)) {
			int nlByteCount = 0;
			int strlength = str.length();  
			for (int i = 0; i < strlength; i++){
				// 半角の場合
				if (str.substring(i, i + 1).getBytes().length == 1) {
					// バイト数をカウントする
					nlByteCount += 1;
				// 半角の場合
				} else {
					// バイト数をカウントする
					nlByteCount += 2;
				}
				
				//抜き出すバイト数と比較
				if (nByte == nlByteCount){
					//終了位置と一致
					return str.substring(0, i + 1);
				} else if (nByte < nlByteCount) {
					//終了位置が2バイト文字の1バイト目の場合、その文字は切り捨て
					return str.substring(0, i);
				}
			}

			//対象文字列が抜き出すバイト数以下だった場合
			return str;
		} else {
			return "";
		}
	}
}