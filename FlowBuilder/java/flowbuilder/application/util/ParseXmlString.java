package flowbuilder.application.util;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

public final class ParseXmlString {
	
	private ParseXmlString(){
	}
	
	public static Document getParsedDocument(String strXml){
		Document doc = null;
		
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	
			DocumentBuilder builder = factory.newDocumentBuilder();
	
			ByteArrayInputStream xmlStream = new ByteArrayInputStream(strXml
					.getBytes("UTF-8"));
	
			doc = builder.parse(xmlStream);
	
			xmlStream.close();
	
			doc.normalize();
		}
		catch(ParserConfigurationException e){
			
		}
		catch(Exception ex){
			
		}
		return doc;
	}
}
