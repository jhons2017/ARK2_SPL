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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import flowbuilder.dao.conf.FlowBuilderSystemConfig;
import fbcom.framework.dao.conf.ConfigReader;

public final class XmlFileProperity {
	/**
	 * ���O
	 */
	Log logger = LogFactory.getLog(XmlFileProperity.class);

	//�f�[�^XML�����[�h����
	private Document filedoc = null;

	//�w�l�k����p�I�u�W�F�N�g
	private XmlOperator opr = null;

	//******************************************************************************************************
	//�R���X�g���N�^
	//******************************************************************************************************
	public XmlFileProperity(String implClassRef) {
		String filePath = "";
		try {
			ConfigReader conf = FlowBuilderSystemConfig.getInstance();
			filePath = conf.getValue(implClassRef);

			//�f�[�^XML�����[�h����
			filedoc = DBXmlFileConn.getDocument(filePath);

			//�w�l�k����p�I�u�W�F�N�g
			opr = new XmlOperator();

			
		} catch (Exception e) {
			logger.fatal("�v���I�ȃG���[");
		}
	}

	//******************************************************************************************************
	//�t�@�C�������擾����
	//******************************************************************************************************
	public String getFileDir(String strManage, String strFileName) {

		String strExc = "";
		try {
			//�G�������g���擾����
			Element manageElement = opr.getElement(opr.getNodeList(filedoc, strManage), 0);

			//�Ǘ��͈͂̃t�@�C�����X�g���擾����
			NodeList fileList = manageElement.getElementsByTagName("file");

			int size = fileList.getLength();

			for (int i = 0; i < size; i++) {
				Element fileElement = (Element) fileList.item(i);

				if (strFileName.equals(opr.getElementValue(fileElement, "name"))) {
					strExc = opr.getElementValue(fileElement, "dir") + strFileName;
					break;
				}
			}

			
		} catch (Exception e) {

			logger.fatal("�v���I�ȃG���[");

			//�G���[���
			strExc = e.toString();
		}

		//�߂�
		return (strExc);
	}

	//******************************************************************************************************
	//�t�@�C���h�c�ɂ��A�t�@�C�������擾����
	//******************************************************************************************************
	public String getFileDirByID(String strManage, String strFileID) {

		String strExc = "";
		try {

			//�G�������g���擾����
			Element manageElement = opr.getElement(opr.getNodeList(filedoc, strManage), 0);

			//�Ǘ��͈͂̃t�@�C�����X�g���擾����
			NodeList fileList = manageElement.getElementsByTagName("file");

			int size = fileList.getLength();

			for (int i = 0; i < size; i++) {
				Element fileElement = (Element) fileList.item(i);

				if (strFileID.equals(opr.getAttrValue(fileElement, "id"))) {
					strExc = opr.getElementValue(fileElement, "dir")
							+ opr.getElementValue(fileElement, "name");

				}
			}

			
		} catch (Exception e) {

			logger.fatal("�v���I�ȃG���[");

			//�G���[���
			strExc = e.toString();
		}

		//�߂�
		return (strExc);
	}

	//******************************************************************************************************
	//�t�@�C���h�c�ɂ��A��ʖ����擾����
	//******************************************************************************************************
	public String getViewByID(String strManage, String strFileID) {

		String strExc = "";
		try {

			//�G�������g���擾����
			Element manageElement = opr.getElement(opr.getNodeList(filedoc, strManage), 0);

			//�Ǘ��͈͂̃t�@�C�����X�g���擾����
			NodeList fileList = manageElement.getElementsByTagName("file");

			int size = fileList.getLength();

			for (int i = 0; i < size; i++) {
				Element fileElement = (Element) fileList.item(i);

				if (strFileID.equals(opr.getAttrValue(fileElement, "id"))) {
					strExc = opr.getElementValue(fileElement, "view");

				}
			}

			
		} catch (Exception e) {

			logger.fatal("�v���I�ȃG���[");

			//�G���[���
			strExc = e.toString();
		}

		//�߂�
		return (strExc);

	}

	//******************************************************************************************************
	//�t�@�C�������擾����
	//******************************************************************************************************
	public String getFileInfo(String strManage, String strFileName, String strTagName) {

		String strExc = "";
		try {

			//�G�������g���擾����
			Element manageElement = opr.getElement(opr.getNodeList(filedoc, strManage), 0);

			//�Ǘ��͈͂̃t�@�C�����X�g���擾����
			NodeList fileList = manageElement.getElementsByTagName("file");
			int size = fileList.getLength();
			//�����J�n
			for (int i = 0; i < size; i++) {

				//�t�@�C���G�������g���擾
				Element fileElement = (Element) fileList.item(i);

				//�t�@�C�����̔�r
				if (strFileName.equals(opr.getElementValue(fileElement, "name"))) {

					//�Ή��l���擾����
					strExc = opr.getElementValue(fileElement, strTagName);
				}
			}

			
		} catch (Exception e) {

			logger.fatal("�v���I�ȃG���[");

			//�G���[���
			strExc = e.toString();
		}

		//�߂�
		return (strExc);

	}

	//******************************************************************************************************
	//�Č��t�@�C�������쐬
	//******************************************************************************************************
	public String createJobFileDir(String strJobId) {

		String strExc = "";
		try {

			//�G�������g���擾����
			Element manageElement = opr.getElement(opr.getNodeList(filedoc, "job"), 0);

			//�Ǘ��͈͂̃t�@�C�����X�g���擾����
			NodeList fileList = manageElement.getElementsByTagName("file");

			//�t�@�C���G�������g���擾
			Element fileElement = (Element) fileList.item(0);

			//�V�K�Č��w�l�k�t�@�C�������擾
			strExc = opr.getElementValue(fileElement, "dir") + "job_" + strJobId + ".xml";

			
		} catch (Exception e) {

			logger.fatal("�v���I�ȃG���[");

			//�G���[���
			strExc = e.toString();
		}
		//�߂�
		return (strExc);

	}

	//******************************************************************************************************
	//�Č��t�@�C�������擾
	//******************************************************************************************************
	public String getJobFileDir(String strJobId) {

		String strExc = "";

		try {

			//�G�������g���擾����
			Element manageElement = opr.getElement(opr.getNodeList(filedoc, "job"), 0);

			//�Ǘ��͈͂̃t�@�C�����X�g���擾����
			NodeList fileList = manageElement.getElementsByTagName("file");

			//�t�@�C���G�������g���擾
			Element fileElement = (Element) fileList.item(0);

			//�Č��w�l�k�t�@�C�������擾
			strExc = opr.getElementValue(fileElement, "dir") + "job_" + strJobId + ".xml";

		} catch (Exception e) {

			logger.fatal("�v���I�ȃG���[");

			//�G���[���
			strExc = e.toString();
		}
		//�߂�
		return (strExc);

	}
}
