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

	// �ő�\���Č������� 
	private static int MAX_JOBNAME_LEN = 30;
	/**
	 * HTML�̍쐬
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
	 * �Č��ꗗ�\�����i
	 * 
	 * @param strOrgID
	 * @param strUserID
	 * @param strPartXml
	 * @return
	 */
	private StringBuffer partJobListHtml(PageInfo pInfo, String strOrgID, String strUserID, UserRole userRole, String strPartXml ) {		
		
		// ���O
		Log logger = LogFactory.getLog(PartJobList.class);
		logger.info("�W���u���X�g�̐��\�e�X�g(Start)�F" + PartCommon.getCurTime());
		Condition cond = null;
		
		Status status = null;
		
		UserCondition usercond = null;
		
		List<JobDTO> joblistDTO = null;

		StringBuffer strHtml = new StringBuffer();
		
		Document joblistdoc = null;
		try {
			
			// �i���ۏ�
			logger.info( "�J�n" );
			
			JobListService service = JobListServiceFactory.getOrgListServiceInstance();
			
			strHtml.append("<table bgcolor='#999999' width=780px align=left border=0 cellpadding=1 cellspacing=1>\n");
			strHtml.append("<tr bgcolor='#efefef' align='center' valign='center'>\n"); 
			strHtml.append("<td height=25 width='10%'>�ԍ�</td>\n"); 
			strHtml.append("<td height=25 width='25%'>����</td>\n"); 
			strHtml.append("<td height=25 width='20%'>�Č���</td>\n"); 
			strHtml.append("<td height=25 width='15%'>�쐬��</td>\n"); 
			strHtml.append("<td height=25 width='15%'>���</td>\n"); 
			strHtml.append("<td height=25 width='10%'>�쐬����</td>\n"); 
			strHtml.append("</tr>\n"); 
	
			
			joblistdoc = ParseXmlString.getParsedDocument(strPartXml);
			
			// �e���v���[�g�i���[�N�t���[�j���X�g���擾����
			NodeList templateList = XmlOperator.getNodeList( joblistdoc, "template" );
	
			int templateSize = templateList.getLength();
			
			List<Condition> condList = new ArrayList<Condition>();
			// �쐬�\�Č�������
			for (int i = 0; i < templateSize; i ++ )
			{
				cond = new Condition();
				
				// �e���v���[�g�G�������g���擾
				Element templateElement = XmlOperator.getElement( templateList, i );
	
				String strTemplateID = XmlOperator.getAttrValue( templateElement, "id" );
				
				String strTemplateTitle = XmlOperator.getAttrValue( templateElement, "title" );
				
				// ���[�U�������X�g���擾
				NodeList conList = templateElement.getElementsByTagName("con");
	
				int conListSize = conList.getLength();
			
				List<Status> statusList = new ArrayList<Status>();
				for (int j = 0; j < conListSize; j ++ )
				{
					
					status = new Status();
					
					// �e���v���[�g�G�������g���擾
					Element statusElement = XmlOperator.getElement( conList, j );
					
					String sta = XmlOperator.getAttrValue( statusElement, "status" );
					
					// ���[�U�������X�g���擾
					NodeList userList = statusElement.getElementsByTagName("user");
					
					int userSize = userList.getLength();
					
					List<UserCondition> userCondList = new ArrayList<UserCondition>();
					
					for (int k = 0; k < userSize; k ++ ){					
						usercond = new UserCondition();
						
						// �e���v���[�g�G�������g���擾
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
				strHtml.append("<td height=25 colspan='6'><font color='red'>���R�[�h�������I</font></td>\n");
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
				
		logger.info("�W���u���X�g�̐��\�e�X�g(END)�F" + PartCommon.getCurTime());
		return( strHtml );
	}

	/**
	 * ���R�[�h���쐬����
	 * 
	 * @param joblistDTO�@�W���u���X�g
	 * @return�@StringBuffer�@strHtml�@���R�[�h��HTML��Ԃ�
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
			// ���R�[�h���쐬����
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
			
			// �`�b�v�w���v�@�\��ǉ�
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

		//�@���R�[�h��HTML��Ԃ�
		return strHtml;
	}

	/**
	 * �Ώە�����̐擪����A�w�肵���o�C�g���̕����𔲂��o���܂��B
	 * �I���ʒu��2�o�C�g������1�o�C�g�ڂ��w�肵�Ă����ꍇ�A���̕����͐؂�̂Ă�B 
	 * 
	 * @param str �Ώە�����, nByte �����o���o�C�g��
	 * @return�@String�@str�@�����o���ꂽ������
	 */
	private String getShortString(String str, int nByte) {
		if (str != null || "".equals(str)) {
			int nlByteCount = 0;
			int strlength = str.length();  
			for (int i = 0; i < strlength; i++){
				// ���p�̏ꍇ
				if (str.substring(i, i + 1).getBytes().length == 1) {
					// �o�C�g�����J�E���g����
					nlByteCount += 1;
				// ���p�̏ꍇ
				} else {
					// �o�C�g�����J�E���g����
					nlByteCount += 2;
				}
				
				//�����o���o�C�g���Ɣ�r
				if (nByte == nlByteCount){
					//�I���ʒu�ƈ�v
					return str.substring(0, i + 1);
				} else if (nByte < nlByteCount) {
					//�I���ʒu��2�o�C�g������1�o�C�g�ڂ̏ꍇ�A���̕����͐؂�̂�
					return str.substring(0, i);
				}
			}

			//�Ώە����񂪔����o���o�C�g���ȉ��������ꍇ
			return str;
		} else {
			return "";
		}
	}
}