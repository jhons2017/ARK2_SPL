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
	 * ���O
	 */
	//private static Log logger=LogFactory.getLog(XmlOperator.class);
	
	// *********************************************************************************************
	// �h�L�������g����m�[�h���X�g���擾����
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
	// �m�[�h���X�g����G�������g���擾����
	// *********************************************************************************************
	public static Element getElement(NodeList xmlList, int intItem) {
		Element resultElement = null;

		try
		{
			// �i���ۏ�
			

			//
			resultElement = (Element) xmlList.item(intItem);
			// �i���ۏ�
			

		}

		catch (Exception e)
		{

			// �i���ۏ�
			
		}

		return (resultElement);

	}

	// *********************************************************************************************
	// �G�������g����G�������g�l���擾����
	// *********************************************************************************************
	public static String getElementValue(Element xmlElement, String strTagName) {
		String resultValue = null;

		try
		{
			if (strTagName != null && !strTagName.equals(""))
			{
				// �q�G�������g���擾
				Element childElement = (Element) xmlElement.getElementsByTagName(strTagName).item(0);

				if (childElement != null)
				{

					// �l���擾
					resultValue = (String) childElement.getFirstChild().getNodeValue();
				}
				else
				{
					// �l���󂫂ɂ���
					resultValue = "";
				}
			}

			// �i���ۏ�
			
		}

		catch (Exception e)
		{

			// �i���ۏ�
			
		}

		return (resultValue);

	}

	// *********************************************************************************************
	// �G�������g���瑮�����擾����
	// *********************************************************************************************
	public static Attr getAttribute(Element xmlElement, String strAttrName) {
		Attr newAttr = null;

		try
		{
			// �i���ۏ�
			

			//
			newAttr = (Attr) xmlElement.getAttributeNode(strAttrName);

			// �i���ۏ�
			
		}
		catch (Exception e)
		{

			// �i���ۏ�
			

		}

		return (newAttr);


	}

	// *********************************************************************************************
	// �G�������g���瑮���l���擾����
	// *********************************************************************************************
	public static String getAttrValue(Element xmlElement, String strAttrName) {
		String resultValue = null;

		try
		{
			// �i���ۏ�
			

			if (xmlElement != null && !strAttrName.equals(""))
			{
				//
				resultValue = (String) xmlElement.getAttributeNode(strAttrName).getNodeValue();
			}
			else
			{

				resultValue = "";
			}

			// �i���ۏ�
			

		}

		catch (Exception e)
		{

			// �i���ۏ�
			

		}

		return (resultValue);
	}

	// *********************************************************************************************
	// �G�������g�̒l��ݒ肷��
	// *********************************************************************************************
	public static void setElementValue(Element xmlElement, String strTagName,
			String strValue) {
		try
		{
			xmlElement.getElementsByTagName(strTagName).item(0).getFirstChild().setNodeValue(strValue);
		}

		catch (Exception e)
		{

			// �i���ۏ�
			

		}
	}

	// *********************************************************************************************
	// �G�������g�̑����l��ݒ肷��
	// *********************************************************************************************
	public static boolean setAttrValue(Element xmlElement,
			String strAttrName, String strAttrValue) {
		boolean bResult = false;

		try
		{
			// �i���ۏ�
			if (xmlElement != null && strAttrName != null && !strAttrName.equals(""))
			{

				//
				xmlElement.getAttributeNode(strAttrName).setNodeValue(strAttrValue);

				bResult = true;
			}

			// �i���ۏ�
			
		}

		catch (Exception e)
		{

			// �i���ۏ�
			

		}

		return bResult;
	}

	// *********************************************************************************************
	// �G�������g�̑����m�[�h��ݒ肷��
	// *********************************************************************************************
	public static boolean setAttrNode(Element xmlElement, Attr attrNode) {
		boolean bResult = false;

		try
		{
			// �i���ۏ�
			

			if (xmlElement != null && attrNode != null)
			{

				// ���f�ɑ����m�[�h��ݒ肷��
				xmlElement.setAttributeNode(attrNode);

				bResult = true;
			}
		}

		catch (Exception e)
		{

			// �i���ۏ�
			
		}

		return bResult;
	}

	// *********************************************************************************************
	// �G�������g�Ɏq�m�[�h�G�������g��ݒ肷��
	// *********************************************************************************************
	public static boolean appendElementNode(Element xmlElement,
			Element xmlChildNode) {

		boolean bResult = false;

		try
		{
			// �i���ۏ�
			

			if (xmlElement != null && xmlChildNode != null)
			{

				// xmlElement�m�[�h��xmlChildNode�q�m�[�h�̃��X�g�̖����ɒǉ����܂��B
				xmlElement.appendChild(xmlChildNode);

				bResult = true;
			}

			// �i���ۏ�
			
		}

		catch (Exception e)
		{

			// �i���ۏ�
			
		}

		return bResult;
	}

	// *********************************************************************************************
	// �G�������g���쐬����
	// *********************************************************************************************
	public static Element createElement(Document doc, String strElementName,
			String strElementValue) {
		Element newElement = null;

		try
		{
			// �i���ۏ�
			
			if (doc != null)
			{
				if (strElementValue != null && strElementName != null && !strElementName.equals(""))
				{
					// ���f���쐬����
					newElement = doc.createElement(strElementName);

					// �e�L�X�g
					Text textseg = null;

					// XML�p����Text String�쐬����
					if (!strElementValue.equals(""))
					{

						textseg = doc.createTextNode(strElementValue);

						// newElement�m�[�h�̎q�m�[�h�̃��X�g�̖����ɁA�w�肵���������ǉ����܂��B
						newElement.appendChild(textseg);
					}
					else
					{

						textseg = doc.createTextNode("");

						// newElement�m�[�h�̎q�m�[�h�̃��X�g�̖����ɁA�w�肵���������ǉ����܂��B
						newElement.appendChild(textseg);
					}
				}
			}

			// �i���ۏ�
			
		}

		catch (Exception e)
		{

			// �i���ۏ�
			

		}

		return (newElement);
	}

	// *********************************************************************************************
	// �������쐬����
	// *********************************************************************************************
	public static Attr createAttrbute(Document doc, String strAttrName,
			String strAttrValue) {
		Attr newAttr = null;

		try
		{
			// �i���ۏ�
			

			// �������쐬����
			newAttr = doc.createAttribute(strAttrName);

			// �����l��^����
			newAttr.setValue(strAttrValue);

			// �i���ۏ�
			
		}

		catch (Exception e)
		{

			// �i���ۏ�
			

		}

		return (newAttr);

	}

	// *********************************************************************************************
	// �G�������g����Ή��m�[�h���폜����
	// *********************************************************************************************
	public static void removeElementNode(Element xmlElement, Node xmlChildNode) {
		try
		{
			// �i���ۏ�
			xmlElement.removeChild(xmlChildNode);
		}

		catch (Exception e)
		{

			// �i���ۏ�
			

		}
	}
}
