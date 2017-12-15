/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/05/25
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/05/25 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs.common.validate;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fbcom.framework.exceptions.SysException;
import fbcom.framework.exceptions.XmlAccessSysException;
import flowbuilder.application.util.ParseXmlString;
import flowbuilder.daoimpl.db.XmlOperator;

/**
 *
 */
public abstract class ValidateFactory {
	//ロギング
	private static final Log _log = LogFactory.getLog(ValidateFactory.class);

	/**
	 * 
	 * @param checkXml
	 * @return
	 */
	public static IValidate create(String state, String checkXml) throws SysException {
		//　パラメータのメプ
		Map params = null;

		// チェックのタイプ
		String checkType = null;

		ValidateMulti result = new ValidateMulti();

		//　チェックXMLのドキュメントを取得する。
		Document doc = ParseXmlString.getParsedDocument(checkXml);
		
		if(doc != null) {
			// Checksに操作する。
			NodeList partNodeList = XmlOperator.getNodeList(doc, "Checks");
			Element partElm = (Element) XmlOperator.getElement(partNodeList, 0);
			// 部品の名前
			String partName = XmlOperator.getAttrValue(partElm, "partName");
			
			// Conditionに操作する。
			NodeList partCondList = partElm.getElementsByTagName("Condition");
			int partCondListLength = partCondList.getLength();
			
			for(int k = 0; k < partCondListLength;k++){
				Element condElm = (Element)partCondList.item(k);
				String value = XmlOperator.getAttrValue(condElm, "value");
				
				// 案件の状態と同じ
				if(state.equals(value)){
					NodeList checkNodeList = condElm.getElementsByTagName("CheckItem");
					int checkAmount = checkNodeList.getLength();
				
					//チェック部品の名前
					for (int i = 0; i < checkAmount; i++) {
						params = new HashMap();
						params.put("partName", partName);
						Element chkItem = (Element) checkNodeList.item(i);
						NamedNodeMap arrtList = chkItem.getAttributes();
						int arrLength = arrtList.getLength();
						
						//　メプに追加する
						for (int j = 0; j < arrLength; j++) {
							Node arrt = arrtList.item(j);
							params.put(arrt.getNodeName(), arrt.getNodeValue());
						}
	
						result.Add(createOne(params));
					}
				
				}
			}
		}

		return result;
	}

	/**
	 * 
	 * @param checkXml
	 * @return
	 */
	private static IValidate createOne(Map params) throws SysException {
		IValidate result = null;

		String checkType = params.get("type").toString();

		String className = "flowbuilder.presentation.webcmn.taglibs.common.validate." + checkType;
		try {
			result = (ValidateParent) Class.forName(className).newInstance();
		} catch (ClassNotFoundException e) {
			_log.fatal(e.getMessage(), e);
			throw new XmlAccessSysException("Error.Db.DataAccessFail");
		} catch (IllegalAccessException e) {
			_log.fatal(e.getMessage(), e);
			throw new XmlAccessSysException("Error.Db.DataAccessFail");
		} catch (InstantiationException e) {
			_log.fatal(e.getMessage(), e);
			throw new XmlAccessSysException("Error.Db.DataAccessFail");
		}

		result.init(params);

		return result;
	}
}
