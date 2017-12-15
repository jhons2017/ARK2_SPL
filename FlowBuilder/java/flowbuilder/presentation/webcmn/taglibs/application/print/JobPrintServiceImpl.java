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
 * プリンッタサービスに共通するアプリケーションサービスの実装クラス <BR>
 */
public class JobPrintServiceImpl implements JobPrintService {

	// ログ *
	private Log logger = LogFactory.getLog(JobPrintServiceImpl.class);

	// ジョブの操作 
	private JobOprater jobOpr = new JobOprater();
	
	// listの設定
	private List<PrintInformation> infoList = new ArrayList<PrintInformation>();		

	/**
	 * excelに情報を出力する
	 * 
	 * @param　String　jobId　ジョブID
	 * 
	 * @return File url
	 */
	public void jobPrint(String jobId, HttpServletResponse response) {
		
		// 設定ファイルの読み込みを行なう
		ConfigReader conf = FlowBuilderSystemConfig.getInstance();
		
		// ジョブファイルのパスを取得する
		String jobFilePath = conf.getValue("jobPath");
		
		//　プリンタパスを取得する
		String printPath = conf.getValue("printPath");
		
		// templateアドレス
		String urlFrom = "";

		//　ドキュメントを取得する
		Document jobDoc = DBXmlFileConn.getDocument(jobFilePath + "job_" + jobId + ".xml");
		
		//　案件名を取得する
		String tagJobNameValue = jobOpr.getWorkFlowName(jobDoc);
		
		//　ドキュメントを取得する
		Document printDoc = DBXmlFileConn.getDocument(printPath + "print.xml");
		
		// tyouhyouNameノードリストを取得する
		NodeList printDocuments = XmlOperator.getNodeList(printDoc, "tyouhyouName");
	
		//　長さを取得する
		int tyouhyouListLength = printDocuments.getLength();
		
		for (int i = 0; i < tyouhyouListLength; i++) {
			
			//　エレメントを取得する
			Element tagElm = (Element) printDocuments.item(i);
			
			//　id情報を取得する
			String id = XmlOperator.getAttrValue(tagElm, "id");

			//　案件名とidが同じ場合は　続く
			if (id.equals(tagJobNameValue)) {
				
				//　URL情報を取得する
				urlFrom = XmlOperator.getAttrValue(tagElm, "URL");

				//　fixeditemノードリストを取得する
				NodeList fixeditemDocuments = tagElm.getElementsByTagName("fixeditem");
				
				//　エレメントを取得する
				Element fixeditemElm = (Element) fixeditemDocuments.item(0);
				
				//　itemノードリストを取得する				
				NodeList itemDocuments = fixeditemElm.getElementsByTagName("item");
				
				//　長さを取得する				
				int itemListLength = itemDocuments.getLength();
				
				//　print.xml情報を取得する
				for (int j = 0; j < itemListLength; j++) {
					Element itemElement = (Element) itemDocuments.item(j);
					
					NodeList tagId = itemElement.getElementsByTagName("id");
					
					Element idElement = (Element) tagId.item(0);
					
					// idNameを取得する
					String idNameValue = idElement.getFirstChild().getNodeValue();
					
					NodeList tagRow = itemElement.getElementsByTagName("row");
					
					Element rowElement = (Element) tagRow.item(0);
					
					//　rowを取得する
					String rowNameValue = rowElement.getFirstChild().getNodeValue();
					
					NodeList tagCol = itemElement.getElementsByTagName("col");
					
					Element colElement = (Element) tagCol.item(0);
					
					//　colを取得する
					String colNameValue = colElement.getFirstChild().getNodeValue();
					
					NodeList tagSheet = itemElement.getElementsByTagName("sheet");
					
					Element sheetElement = (Element) tagSheet.item(0);
					
					//　sheetを取得する
					String sheetNameValue = sheetElement.getFirstChild().getNodeValue();

					//　必要なNodeListを取得するドキュメント
					NodeList jobDocuments = XmlOperator.getNodeList(jobDoc, "Document");

					Element jobElement = (Element) jobDocuments.item(0);
					
					//　valueの設定
					String strtagValue = "";
					
					//　Listに基本情報を出力する
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
						
					//　経過承認の情報は　Listに　出力する
					} else if ("ConfirmRoute".equals(idNameValue)) {
						ConfirmRouteValueToList(jobDoc, Integer.parseInt(rowNameValue));
					
					// 回覧票	List作成
					} else if ("Circular".equals(idNameValue)) {
						CircularToList(jobElement, jobDoc, Integer.parseInt(rowNameValue));
						
					} else if ("select".equals(idNameValue)) {
						strtagValue = stringBrowseReturn(PartCommon.getTagValue(jobElement, idNameValue));
						if ("high".equals(strtagValue)) {
							strtagValue = "高";
						} else if("low".equals(strtagValue)) {
							strtagValue = "低";
						} else {
							strtagValue = "中";
						}
						infoList.add(new PrintInformation(strtagValue, Integer.parseInt(rowNameValue),
								Integer.parseInt(colNameValue), 0));
					//　情報は　Listに　出力する
					} else {
						
						// 其他申請は　Listに　出力する 
						if ("1".equals(sheetNameValue)) {
							String[] value = idNameValue.split(",");
							for (int k = 0; k < value.length; k++) {
								String str = PartCommon.getTagValue(jobElement, value[k]);
								if ("on".equals(str)) {
									strtagValue = strtagValue + value[k] + ","; 									
								}
							}
							// ","を　削除する
							if (!"".equals(strtagValue)) {
								strtagValue = strtagValue.substring(0,strtagValue.length()-1);
							}
							PrintInformation Info = new PrintInformation(strtagValue, Integer.parseInt(rowNameValue),
									Integer.parseInt(colNameValue), 1);
							infoList.add(Info);
						} else {
						
							//　 ドキュメントの値を取得する
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

		//　excelに挿入する
		XmlToExcel(infoList, urlFrom, response);
		

	}

	/**
	 * excelの出力
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

        	// excel引用を取得する
            HSSFWorkbook workbook = new HSSFWorkbook(instream);
            int listLength = infoList.size();
        	for (int i = 0; i < listLength; i++) {

	        	//　sheetを取得する
	            HSSFSheet sheet = workbook.getSheetAt(((PrintInformation)infoList.get(i)).getSheetNo());
	
	            //　rowを取得する
	            HSSFRow row = sheet.getRow(((PrintInformation)infoList.get(i)).getRow());
	            
	            //　単元格を取得する
	            HSSFCell cell = row.getCell((short) ((PrintInformation)infoList.get(i)).getCol());
	            
	            //　単元格類型を取得する
	            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	            
	            //　単元格内容をセットする
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
        	
			// ログを出力
			logger.fatal( "致命的なエラー" );
        }     
    }

	/**
	 * 経過承認の情報は　Listに　出力する
	 * 
	 * @param Document job ジョブ
	 * @param int rows
	 * @param String url
	 */
	private void ConfirmRouteValueToList(Document job, int rows) {

		try {
			
			User user = new User();

			UserService serive = UserServiceFactory.getUserServiceInstance();

			//　WorkFlowのNodeListを取得する
			NodeList workFlowList = XmlOperator.getNodeList(job, "WorkFlow");
	
			//　WorkFlowのエレメントを取得する
			Element workFlowElement = XmlOperator.getElement(workFlowList, 0);
	
			//　StepのNodeListを取得する
			NodeList stepList = workFlowElement.getElementsByTagName("step");
	
			int strStateNum = 0;
	
			int stepListSize = stepList.getLength();
			
				//　現在状態を特定する
				for (int i = 0; i < stepListSize; i++) {
					strStateNum ++;
		
					//　Stepエレメントを取得する
					Element stepElement = XmlOperator.getElement(stepList, i);
		
					//　状態のNodeListを取得する
					NodeList stateList = stepElement.getElementsByTagName("state");
		
					//　状態のエレメントを取得する
					Element stateElement = XmlOperator.getElement(stateList, 0);
		
					//　操作者と操作内容
					String strOperatorInfo = "";
		
					if (stateElement.getAttribute("active").equals("true")) {
		
						//　操作者と操作内容
						strOperatorInfo = "○";
					} else {
		
						//　操作リストを取得する
						NodeList OperatorList = stepElement.getElementsByTagName("opr");
		
						//　操作者情報を取得する
						String strGotOperator = "";
		
						//　行った操作名を取得する
						String strGotOprName = "";
		
						int operatorListSize = OperatorList.getLength();
						
						//　条件操作を特定する
						for (int j = 0; j < operatorListSize; j++) {
							
							//　操作のエレメントを取得する
							Element OperatorElement = XmlOperator.getElement(OperatorList, j);
		
							//　ユーザーＩＤ情報が入っていれば通過ルートと見なす
							if (!OperatorElement.getAttribute("userid").equals("")) {
								
								user = serive.getUser(OperatorElement.getAttribute("userid"));
								//　操作者ＩＤを取得する
								strGotOperator = user.getUserName();
		
								//　操作内容
								strGotOprName = OperatorElement.getAttribute("name");
		
								//　表示内容
								strOperatorInfo = strGotOperator + ":" + strGotOprName;
							}
						}
					}
					
					infoList.add(new PrintInformation(strOperatorInfo, rows, i+1, 0));		
				}
			} catch(Exception e) {

				// ログを出力
				logger.fatal( "致命的なエラー" );
			}
	}

	/**
	 * Listに回覧の情報を出力する
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

			//　CircularのNodeListを取得する
			NodeList CircularList = XmlOperator.getNodeList(job, "Circular");
	
			//　Circularのエレメントを取得する
			Element CircularElement = XmlOperator.getElement(CircularList, 0);
			
			NodeList memberList = CircularElement.getElementsByTagName("member");
			
			int memberListSize = memberList.getLength();

			infoList.add(new PrintInformation(String.valueOf(memberListSize), 0, 0, 1));
			
			infoList.add(new PrintInformation(String.valueOf(rows), 0, 2, 1));
			
			for (int i = 0; i < memberListSize; i++) {
					Element memberElement = XmlOperator.getElement(memberList, i);
					
					String memberId = memberElement.getAttribute("id");
					
					user = serive.getUser(memberId);
					
					//　操作者ＩＤを取得する
					String memberName = user.getUserName();
					
					infoList.add(new PrintInformation(memberName, i+1, 0, 1));
					
					//  ドキュメントの値を取得する
					String suggest = stringBrowseReturn(PartCommon.getTagValue(jobElement, memberId));
					infoList.add(new PrintInformation(suggest, i+1, 2, 1));
					
					String problemFlg = memberElement.getAttribute("problemFlg");
					
					String jyoutai = "";
					if ("0".equals(problemFlg)) {
						jyoutai = "回覧待ち";
					} else if ("1".equals(problemFlg)) {
						jyoutai = "確認済";
					} else if ("3".equals(problemFlg)) {
						jyoutai = "処理済";
					} else {
						jyoutai = "問題あり";
					}
					
					infoList.add(new PrintInformation(jyoutai, i+1, 6, 1));
			}	
		} catch(Exception e) {

			// ログを出力
			logger.fatal( "致命的なエラー" );
		}
	}
	
	/**
	 * HTMLタグへ変換します。
	 * 例えば：　\r\n　--> <BR>
	 * 
	 * @param slTgStr ドキュメントの中に、タグの値
	 * @return　新しいHTMLタグ
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