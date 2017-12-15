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


import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;


public final class XmlOperator{
	/**
	 * ログ
	 */
	//private static Log logger=LogFactory.getLog(XmlOperator.class);
	
	// *********************************************************************************************
	// ドキュメントからノードリストを取得する
	// *********************************************************************************************
	public static NodeList getNodeList(Document doc, String strTagName) {
		NodeList resultNodeList = null;

		try {
			resultNodeList = doc.getElementsByTagName(strTagName);
		}

		catch (Exception e) {

		}

		return (resultNodeList);

	}

	// *********************************************************************************************
	// ノードリストからエレメントを取得する
	// *********************************************************************************************
	public static Element getElement(NodeList xmlList, int intItem) {
		Element resultElement = null;

		try
		{
			// 品質保証
			

			//
			resultElement = (Element) xmlList.item(intItem);
			// 品質保証
			

		}

		catch (Exception e)
		{

			// 品質保証
			
		}

		return (resultElement);

	}

	// *********************************************************************************************
	// エレメントからエレメント値を取得する
	// *********************************************************************************************
	public static String getElementValue(Element xmlElement, String strTagName) {
		String resultValue = null;

		try
		{
			if (strTagName != null && !strTagName.equals(""))
			{
				// 子エレメントを取得
				Element childElement = (Element) xmlElement.getElementsByTagName(strTagName).item(0);

				if (childElement != null)
				{

					// 値を取得
					resultValue = (String) childElement.getFirstChild().getNodeValue();
				}
				else
				{
					// 値を空きにする
					resultValue = "";
				}
			}

			// 品質保証
			
		}

		catch (Exception e)
		{

			// 品質保証
			
		}

		return (resultValue);

	}

	// *********************************************************************************************
	// エレメントから属性を取得する
	// *********************************************************************************************
	public static Attr getAttribute(Element xmlElement, String strAttrName) {
		Attr newAttr = null;

		try
		{
			// 品質保証
			

			//
			newAttr = (Attr) xmlElement.getAttributeNode(strAttrName);

			// 品質保証
			
		}
		catch (Exception e)
		{

			// 品質保証
			

		}

		return (newAttr);


	}

	// *********************************************************************************************
	// エレメントから属性値を取得する
	// *********************************************************************************************
	public static String getAttrValue(Element xmlElement, String strAttrName) {
		String resultValue = null;

		try
		{
			// 品質保証
			

			if (xmlElement != null && !strAttrName.equals(""))
			{
				//
				resultValue = (String) xmlElement.getAttributeNode(strAttrName).getNodeValue();
			}
			else
			{

				resultValue = "";
			}

			// 品質保証
			

		}

		catch (Exception e)
		{

			// 品質保証
			

		}

		return (resultValue);
	}

	// *********************************************************************************************
	// エレメントの値を設定する
	// *********************************************************************************************
	public static void setElementValue(Element xmlElement, String strTagName,
			String strValue) {
		try
		{
			xmlElement.getElementsByTagName(strTagName).item(0).getFirstChild().setNodeValue(strValue);
		}

		catch (Exception e)
		{

			// 品質保証
			

		}
	}

	// *********************************************************************************************
	// エレメントの属性値を設定する
	// *********************************************************************************************
	public static boolean setAttrValue(Element xmlElement,
			String strAttrName, String strAttrValue) {
		boolean bResult = false;

		try
		{
			// 品質保証
			if (xmlElement != null && strAttrName != null && !strAttrName.equals(""))
			{

				//
				xmlElement.getAttributeNode(strAttrName).setNodeValue(strAttrValue);

				bResult = true;
			}

			// 品質保証
			
		}

		catch (Exception e)
		{

			// 品質保証
			

		}

		return bResult;
	}

	// *********************************************************************************************
	// エレメントの属性ノードを設定する
	// *********************************************************************************************
	public static boolean setAttrNode(Element xmlElement, Attr attrNode) {
		boolean bResult = false;

		try
		{
			// 品質保証
			

			if (xmlElement != null && attrNode != null)
			{

				// 元素に属性ノードを設定する
				xmlElement.setAttributeNode(attrNode);

				bResult = true;
			}
		}

		catch (Exception e)
		{

			// 品質保証
			
		}

		return bResult;
	}

	// *********************************************************************************************
	// エレメントに子ノードエレメントを設定する
	// *********************************************************************************************
	public static boolean appendElementNode(Element xmlElement,
			Element xmlChildNode) {

		boolean bResult = false;

		try
		{
			// 品質保証
			

			if (xmlElement != null && xmlChildNode != null)
			{

				// xmlElementノードのxmlChildNode子ノードのリストの末尾に追加します。
				xmlElement.appendChild(xmlChildNode);

				bResult = true;
			}

			// 品質保証
			
		}

		catch (Exception e)
		{

			// 品質保証
			
		}

		return bResult;
	}

	// *********************************************************************************************
	// エレメントを作成する
	// *********************************************************************************************
	public static Element createElement(Document doc, String strElementName,
			String strElementValue) {
		Element newElement = null;

		try
		{
			// 品質保証
			
			if (doc != null)
			{
				if (strElementValue != null && strElementName != null && !strElementName.equals(""))
				{
					// 元素を作成する
					newElement = doc.createElement(strElementName);

					// テキスト
					Text textseg = null;

					// XML用名称Text String作成する
					if (!strElementValue.equals(""))
					{

						textseg = doc.createTextNode(strElementValue);

						// newElementノードの子ノードのリストの末尾に、指定した文字列を追加します。
						newElement.appendChild(textseg);
					}
					else
					{

						textseg = doc.createTextNode("");

						// newElementノードの子ノードのリストの末尾に、指定した文字列を追加します。
						newElement.appendChild(textseg);
					}
				}
			}

			// 品質保証
			
		}

		catch (Exception e)
		{

			// 品質保証
			

		}

		return (newElement);
	}

	// *********************************************************************************************
	// 属性を作成する
	// *********************************************************************************************
	public static Attr createAttrbute(Document doc, String strAttrName,
			String strAttrValue) {
		Attr newAttr = null;

		try
		{
			// 品質保証
			

			// 属性を作成する
			newAttr = doc.createAttribute(strAttrName);

			// 属性値を与える
			newAttr.setValue(strAttrValue);

			// 品質保証
			
		}

		catch (Exception e)
		{

			// 品質保証
			

		}

		return (newAttr);

	}

	// *********************************************************************************************
	// エレメントから対応ノードを削除する
	// *********************************************************************************************
	public static void removeElementNode(Element xmlElement, Node xmlChildNode) {
		try
		{
			// 品質保証
			xmlElement.removeChild(xmlChildNode);
		}

		catch (Exception e)
		{

			// 品質保証
			

		}
	}
}
