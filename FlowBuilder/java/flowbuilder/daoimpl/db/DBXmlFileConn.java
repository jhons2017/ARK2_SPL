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
package flowbuilder.daoimpl.db;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * The <code>FileXmlBean</code> interface represents Data source connection. connect XML with file name.
 */
public class DBXmlFileConn{
	/**
	 * ロギング
	 */
	private static Log _log = LogFactory.getLog(DBXmlFileConn.class);
	
	private DBXmlFileConn(){}
	
	public static Document getDocument(String fileName){
		Document doc = null;
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			DocumentBuilder builder = factory.newDocumentBuilder();
			
			builder = factory.newDocumentBuilder();

			doc = builder.parse(fileName);

			doc.normalize();
		
		}
		catch(ParserConfigurationException e){
			
		}
		catch(IOException ex){
			
		}
		catch(SAXException ee){
			
		}
		return doc;
	}
	
	//============================================================
	//XMLファイルを保存する
	//============================================================
	public static void writeXml(Document doc, String xmlFileName)
	{

		String strExc="";

		try
		{
			TransformerFactory tfactory = TransformerFactory.newInstance();

			//
			Transformer transformer = tfactory.newTransformer();

			//
			DOMSource source = new DOMSource(doc);

			File file = new File(xmlFileName);
			
			OutputStream os = new FileOutputStream(file);
			
			//
			StreamResult result = new StreamResult(os);

			//
			transformer.transform(source,result);

		}

		catch(Exception e)
		{
			//品質保証
			_log.fatal( "致命的なエラー" );

		}
	}

}
