/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/03/06 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs.common;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


import flowbuilder.daoimpl.db.XmlOperator;

public final class PartCommon{
	/**
	 * ログ
	 */
	private static Log logger=LogFactory.getLog(PartCommon.class);
	
	// *********************************************************************************************
	// ドキュメントからノードリストを取得する
	// *********************************************************************************************
	public static String getTagValue(Element Document, String strTagName) {
		String tagValue = "";

		try {
			NodeList tagList = Document.getElementsByTagName("control");
			
			int tagListLength = tagList.getLength();
			
			for(int i=0;i<tagListLength;i++){
				
				Element tagElm = (Element)tagList.item(i);
				
				String id = XmlOperator.getAttrValue(tagElm, "id");
				
				if(id.equals(strTagName)){
					
					tagValue = tagElm.getFirstChild().getNodeValue();
					//XmlOperator.getElementValue(tagElm, "");
					break;
				}
				
			}
		}
		catch (Exception e) {
			
		}

		return (tagValue);

	}
	
	
	// *********************************************************************************************
	// ドキュメントからノードリストを取得する
	// *********************************************************************************************
	public static String getTagId(Element Document, String strTagValue) {
		String tagId = "";

		try {
			NodeList tagList = Document.getElementsByTagName("control");
			
			int tagListLength = tagList.getLength();
			
			for(int i=0;i<tagListLength;i++){
				
				Element tagElm = (Element)tagList.item(i);
				
				if(tagElm != null) {
					
					String value = XmlOperator.getAttrValue(tagElm,"id");
	
					if(value.equals(strTagValue)){
						
						tagId = tagElm.getFirstChild().getNodeValue();
						//XmlOperator.getElementValue(tagElm, "");
						break;
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return (tagId);

	}
	
	/**
	 * HTMLタグへ変換します。
	 * 例えば：　\r\n　--> <BR>
	 * 
	 * @param slTgStr ドキュメントの中に、タグの値
	 * @return　新しいHTMLタグ
	 */
	public static String stringBrowseReturn(String slTgStr) {
		String repalacedString = "";		
		if (!(slTgStr == null || "".equals(slTgStr))) {
			repalacedString = slTgStr.replace("'","&#39;");
			repalacedString = repalacedString.replace("<","&lt;");
			repalacedString = repalacedString.replace(">","&gt;");
	    	//strBrowsed = strBrowsed.replace("&","&amp;");
			repalacedString = repalacedString.replace("\"","&quot;");
		}
		return repalacedString;
	}
	
	
	/**
	 * HTMLタグへ変換します。
	 * 例えば：　\r\n　--> <BR>
	 * 
	 * @param slTgStr ドキュメントの中に、タグの値
	 * @return　新しいHTMLタグ
	 */
	public static String stringBrowseReturn(String slTgStr,String brTgStr) {
		String repalacedString = "";		
		if (!(slTgStr == null || "".equals(slTgStr))) {
			repalacedString = slTgStr.replace("'","&#39;");
			repalacedString = repalacedString.replace("<","&lt;");
			repalacedString = repalacedString.replace(">","&gt;");
	    	//strBrowsed = strBrowsed.replace("&","&amp;");
			repalacedString = repalacedString.replace("\"","&quot;");
			repalacedString = repalacedString.replace(brTgStr,"<BR>");
		}
		return repalacedString;
	}
	
	/**
	 * サーバ日付を取得
	 * @return 　サーバ日付
	 */
	public static String getCurDate(){
		Calendar c = Calendar.getInstance();
		SimpleDateFormat f=new SimpleDateFormat("yyyy/MM/dd"); 
		
		return f.format(c.getTime());
		
	}
	
	/**
	 * サーバ時間を取得
	 * @return 　サーバ時間
	 */
	public static String getCurTime(){
		Calendar c = Calendar.getInstance();
		SimpleDateFormat f=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
		
		return f.format(c.getTime());
		
	}

}
