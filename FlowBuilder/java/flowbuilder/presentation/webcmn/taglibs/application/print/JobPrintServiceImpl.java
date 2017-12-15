/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/01 BY. CHENBIN (WXHX)
 * =================================================================
 */

package flowbuilder.presentation.webcmn.taglibs.application.print;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import fbcom.framework.dao.conf.ConfigReader;
import flowbuilder.application.user.UserService;
import flowbuilder.application.user.UserServiceFactory;
import flowbuilder.application.util.JobOprater;
import flowbuilder.dao.conf.FlowBuilderSystemConfig;
import flowbuilder.daoimpl.db.DBXmlFileConn;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.domain.user.User;
import flowbuilder.presentation.webcmn.taglibs.common.PartCommon;
import flowbuilder.presentation.webcmn.taglibs.domain.print.PrintInformation;

/**
 * �v�����b�^�T�[�r�X�ɋ��ʂ���A�v���P�[�V�����T�[�r�X�̎����N���X <BR>
 */
public class JobPrintServiceImpl implements JobPrintService {

	// ���O *
	private Log logger = LogFactory.getLog(JobPrintServiceImpl.class);

	// �W���u�̑��� 
	private JobOprater jobOpr = new JobOprater();
	
	// list�̐ݒ�
	private List<PrintInformation> infoList = new ArrayList<PrintInformation>();		

	/**
	 * excel�ɏ����o�͂���
	 * 
	 * @param�@String�@jobId�@�W���uID
	 * 
	 * @return File url
	 */
	public void jobPrint(String jobId, HttpServletResponse response) {
		
		// �ݒ�t�@�C���̓ǂݍ��݂��s�Ȃ�
		ConfigReader conf = FlowBuilderSystemConfig.getInstance();
		
		// �W���u�t�@�C���̃p�X���擾����
		String jobFilePath = conf.getValue("jobPath");
		
		//�@�v�����^�p�X���擾����
		String printPath = conf.getValue("printPath");
		
		// template�A�h���X
		String urlFrom = "";

		//�@�h�L�������g���擾����
		Document jobDoc = DBXmlFileConn.getDocument(jobFilePath + "job_" + jobId + ".xml");
		
		//�@�Č������擾����
		String tagJobNameValue = jobOpr.getWorkFlowName(jobDoc);
		
		//�@�h�L�������g���擾����
		Document printDoc = DBXmlFileConn.getDocument(printPath + "print.xml");
		
		// tyouhyouName�m�[�h���X�g���擾����
		NodeList printDocuments = XmlOperator.getNodeList(printDoc, "tyouhyouName");
	
		//�@�������擾����
		int tyouhyouListLength = printDocuments.getLength();
		
		for (int i = 0; i < tyouhyouListLength; i++) {
			
			//�@�G�������g���擾����
			Element tagElm = (Element) printDocuments.item(i);
			
			//�@id�����擾����
			String id = XmlOperator.getAttrValue(tagElm, "id");

			//�@�Č�����id�������ꍇ�́@����
			if (id.equals(tagJobNameValue)) {
				
				//�@URL�����擾����
				urlFrom = XmlOperator.getAttrValue(tagElm, "URL");

				//�@fixeditem�m�[�h���X�g���擾����
				NodeList fixeditemDocuments = tagElm.getElementsByTagName("fixeditem");
				
				//�@�G�������g���擾����
				Element fixeditemElm = (Element) fixeditemDocuments.item(0);
				
				//�@item�m�[�h���X�g���擾����				
				NodeList itemDocuments = fixeditemElm.getElementsByTagName("item");
				
				//�@�������擾����				
				int itemListLength = itemDocuments.getLength();
				
				//�@print.xml�����擾����
				for (int j = 0; j < itemListLength; j++) {
					Element itemElement = (Element) itemDocuments.item(j);
					
					NodeList tagId = itemElement.getElementsByTagName("id");
					
					Element idElement = (Element) tagId.item(0);
					
					// idName���擾����
					String idNameValue = idElement.getFirstChild().getNodeValue();
					
					NodeList tagRow = itemElement.getElementsByTagName("row");
					
					Element rowElement = (Element) tagRow.item(0);
					
					//�@row���擾����
					String rowNameValue = rowElement.getFirstChild().getNodeValue();
					
					NodeList tagCol = itemElement.getElementsByTagName("col");
					
					Element colElement = (Element) tagCol.item(0);
					
					//�@col���擾����
					String colNameValue = colElement.getFirstChild().getNodeValue();
					
					NodeList tagSheet = itemElement.getElementsByTagName("sheet");
					
					Element sheetElement = (Element) tagSheet.item(0);
					
					//�@sheet���擾����
					String sheetNameValue = sheetElement.getFirstChild().getNodeValue();

					//�@�K�v��NodeList���擾����h�L�������g
					NodeList jobDocuments = XmlOperator.getNodeList(jobDoc, "Document");

					Element jobElement = (Element) jobDocuments.item(0);
					
					//�@value�̐ݒ�
					String strtagValue = "";
					
					//�@List�Ɋ�{�����o�͂���
					if ("user".equals(idNameValue)) {
						strtagValue = stringBrowseReturn(jobOpr.getCreatorName(jobDoc));
						infoList.add(new PrintInformation(strtagValue, Integer.parseInt(rowNameValue), 
								Integer.parseInt(colNameValue), 0));
					} else if("ID".equals(idNameValue)) {
						strtagValue = stringBrowseReturn(jobOpr.getCreatorID(jobDoc));
						infoList.add(new PrintInformation(strtagValue, Integer.parseInt(rowNameValue),
								Integer.parseInt(colNameValue), 0));
					} else if("IP".equals(idNameValue)) {
						strtagValue = stringBrowseReturn(jobOpr.getCreatorIP(jobDoc));
						infoList.add(new PrintInformation(strtagValue, Integer.parseInt(rowNameValue),
								Integer.parseInt(colNameValue), 0));
					} else if("fb_JobName".equals(idNameValue)) {
						strtagValue = stringBrowseReturn(jobOpr.getJobName(jobDoc));
						infoList.add(new PrintInformation(strtagValue, Integer.parseInt(rowNameValue),
								Integer.parseInt(colNameValue), 0));
						
					//�@�o�ߏ��F�̏��́@List�Ɂ@�o�͂���
					} else if ("ConfirmRoute".equals(idNameValue)) {
						ConfirmRouteValueToList(jobDoc, Integer.parseInt(rowNameValue));
					
					// �񗗕[	List�쐬
					} else if ("Circular".equals(idNameValue)) {
						CircularToList(jobElement, jobDoc, Integer.parseInt(rowNameValue));
						
					} else if ("select".equals(idNameValue)) {
						strtagValue = stringBrowseReturn(PartCommon.getTagValue(jobElement, idNameValue));
						if ("high".equals(strtagValue)) {
							strtagValue = "��";
						} else if("low".equals(strtagValue)) {
							strtagValue = "��";
						} else {
							strtagValue = "��";
						}
						infoList.add(new PrintInformation(strtagValue, Integer.parseInt(rowNameValue),
								Integer.parseInt(colNameValue), 0));
					//�@���́@List�Ɂ@�o�͂���
					} else {
						
						// �����\���́@List�Ɂ@�o�͂��� 
						if ("1".equals(sheetNameValue)) {
							String[] value = idNameValue.split(",");
							for (int k = 0; k < value.length; k++) {
								String str = PartCommon.getTagValue(jobElement, value[k]);
								if ("on".equals(str)) {
									strtagValue = strtagValue + value[k] + ","; 									
								}
							}
							// ","���@�폜����
							if (!"".equals(strtagValue)) {
								strtagValue = strtagValue.substring(0,strtagValue.length()-1);
							}
							PrintInformation Info = new PrintInformation(strtagValue, Integer.parseInt(rowNameValue),
									Integer.parseInt(colNameValue), 1);
							infoList.add(Info);
						} else {
						
							//�@ �h�L�������g�̒l���擾����
							strtagValue = stringBrowseReturn(PartCommon.getTagValue(jobElement, idNameValue));
							PrintInformation Info = new PrintInformation(strtagValue, Integer.parseInt(rowNameValue),
									Integer.parseInt(colNameValue), 0);
							infoList.add(Info);
						}
					}
				}
				break;
			}
		}

		//�@excel�ɑ}������
		XmlToExcel(infoList, urlFrom, response);
		

	}

	/**
	 * excel�̏o��
	 * 
	 * @param List infoList
	 * @param String url
	 * @param HttpServletResponse response
	 */
	private void XmlToExcel(List infoList, String url, HttpServletResponse response) {

		File file = new File(url);
		Date date = new Date();
        try {
            	
            FileInputStream instream = new FileInputStream(url);

        	// excel���p���擾����
            HSSFWorkbook workbook = new HSSFWorkbook(instream);
            int listLength = infoList.size();
        	for (int i = 0; i < listLength; i++) {

	        	//�@sheet���擾����
	            HSSFSheet sheet = workbook.getSheetAt(((PrintInformation)infoList.get(i)).getSheetNo());
	
	            //�@row���擾����
	            HSSFRow row = sheet.getRow(((PrintInformation)infoList.get(i)).getRow());
	            
	            //�@�P���i���擾����
	            HSSFCell cell = row.getCell((short) ((PrintInformation)infoList.get(i)).getCol());
	            
	            //�@�P���i�ތ^���擾����
	            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	            
	            //�@�P���i���e���Z�b�g����
	            cell.setCellValue(((PrintInformation)infoList.get(i)).getVal());
        	} 

			response.reset();
			response.setContentType("application/msexcel");
			response.addHeader("Content-Disposition", "attachment;Filename ="+date.getTime()+file.getName());
			
			OutputStream outStream = response.getOutputStream();

            workbook.write(outStream);
			outStream.flush();
			outStream.close();
        } catch(Exception e) {
        	
			// ���O���o��
			logger.fatal( "�v���I�ȃG���[" );
        }     
    }

	/**
	 * �o�ߏ��F�̏��́@List�Ɂ@�o�͂���
	 * 
	 * @param Document job �W���u
	 * @param int rows
	 * @param String url
	 */
	private void ConfirmRouteValueToList(Document job, int rows) {

		try {
			
			User user = new User();

			UserService serive = UserServiceFactory.getUserServiceInstance();

			//�@WorkFlow��NodeList���擾����
			NodeList workFlowList = XmlOperator.getNodeList(job, "WorkFlow");
	
			//�@WorkFlow�̃G�������g���擾����
			Element workFlowElement = XmlOperator.getElement(workFlowList, 0);
	
			//�@Step��NodeList���擾����
			NodeList stepList = workFlowElement.getElementsByTagName("step");
	
			int strStateNum = 0;
	
			int stepListSize = stepList.getLength();
			
				//�@���ݏ�Ԃ���肷��
				for (int i = 0; i < stepListSize; i++) {
					strStateNum ++;
		
					//�@Step�G�������g���擾����
					Element stepElement = XmlOperator.getElement(stepList, i);
		
					//�@��Ԃ�NodeList���擾����
					NodeList stateList = stepElement.getElementsByTagName("state");
		
					//�@��Ԃ̃G�������g���擾����
					Element stateElement = XmlOperator.getElement(stateList, 0);
		
					//�@����҂Ƒ�����e
					String strOperatorInfo = "";
		
					if (stateElement.getAttribute("active").equals("true")) {
		
						//�@����҂Ƒ�����e
						strOperatorInfo = "��";
					} else {
		
						//�@���샊�X�g���擾����
						NodeList OperatorList = stepElement.getElementsByTagName("opr");
		
						//�@����ҏ����擾����
						String strGotOperator = "";
		
						//�@�s�������얼���擾����
						String strGotOprName = "";
		
						int operatorListSize = OperatorList.getLength();
						
						//�@�����������肷��
						for (int j = 0; j < operatorListSize; j++) {
							
							//�@����̃G�������g���擾����
							Element OperatorElement = XmlOperator.getElement(OperatorList, j);
		
							//�@���[�U�[�h�c��񂪓����Ă���Βʉ߃��[�g�ƌ��Ȃ�
							if (!OperatorElement.getAttribute("userid").equals("")) {
								
								user = serive.getUser(OperatorElement.getAttribute("userid"));
								//�@����҂h�c���擾����
								strGotOperator = user.getUserName();
		
								//�@������e
								strGotOprName = OperatorElement.getAttribute("name");
		
								//�@�\�����e
								strOperatorInfo = strGotOperator + ":" + strGotOprName;
							}
						}
					}
					
					infoList.add(new PrintInformation(strOperatorInfo, rows, i+1, 0));		
				}
			} catch(Exception e) {

				// ���O���o��
				logger.fatal( "�v���I�ȃG���[" );
			}
	}

	/**
	 * List�ɉ񗗂̏����o�͂���
	 * 
	 * @param jobElement
	 * @param job
	 * @param rows
	 * @param url
	 */
	private void CircularToList(Element jobElement, Document job, int rows) {

		try {
			
			User user = new User();

			UserService serive = UserServiceFactory.getUserServiceInstance();

			//�@Circular��NodeList���擾����
			NodeList CircularList = XmlOperator.getNodeList(job, "Circular");
	
			//�@Circular�̃G�������g���擾����
			Element CircularElement = XmlOperator.getElement(CircularList, 0);
			
			NodeList memberList = CircularElement.getElementsByTagName("member");
			
			int memberListSize = memberList.getLength();

			infoList.add(new PrintInformation(String.valueOf(memberListSize), 0, 0, 1));
			
			infoList.add(new PrintInformation(String.valueOf(rows), 0, 2, 1));
			
			for (int i = 0; i < memberListSize; i++) {
					Element memberElement = XmlOperator.getElement(memberList, i);
					
					String memberId = memberElement.getAttribute("id");
					
					user = serive.getUser(memberId);
					
					//�@����҂h�c���擾����
					String memberName = user.getUserName();
					
					infoList.add(new PrintInformation(memberName, i+1, 0, 1));
					
					//  �h�L�������g�̒l���擾����
					String suggest = stringBrowseReturn(PartCommon.getTagValue(jobElement, memberId));
					infoList.add(new PrintInformation(suggest, i+1, 2, 1));
					
					String problemFlg = memberElement.getAttribute("problemFlg");
					
					String jyoutai = "";
					if ("0".equals(problemFlg)) {
						jyoutai = "�񗗑҂�";
					} else if ("1".equals(problemFlg)) {
						jyoutai = "�m�F��";
					} else if ("3".equals(problemFlg)) {
						jyoutai = "������";
					} else {
						jyoutai = "��肠��";
					}
					
					infoList.add(new PrintInformation(jyoutai, i+1, 6, 1));
			}	
		} catch(Exception e) {

			// ���O���o��
			logger.fatal( "�v���I�ȃG���[" );
		}
	}
	
	/**
	 * HTML�^�O�֕ϊ����܂��B
	 * �Ⴆ�΁F�@\r\n�@--> <BR>
	 * 
	 * @param slTgStr �h�L�������g�̒��ɁA�^�O�̒l
	 * @return�@�V����HTML�^�O
	 */
	private String stringBrowseReturn(String slTgStr) {
		String repalacedString = "";		
		if (!(slTgStr == null || "".equals(slTgStr))) {
			repalacedString = slTgStr.replace("&#39;","'");
			repalacedString = repalacedString.replace("&lt;","<");
			repalacedString = repalacedString.replace("&gt;",">");
			repalacedString = repalacedString.replace("&amp;","&");
			repalacedString = repalacedString.replace("&quot;","\"");
		}
		return repalacedString;
	}
}