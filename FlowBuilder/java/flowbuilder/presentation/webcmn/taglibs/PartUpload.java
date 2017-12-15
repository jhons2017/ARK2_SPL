/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/03/06
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/19 BY. ZHANGXINFENG (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import fbcom.framework.dao.conf.ConfigReader;
import flowbuilder.application.util.JobOprater;
import flowbuilder.application.util.ParseXmlString;
import flowbuilder.dao.conf.FlowBuilderSystemConfig;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.presentation.webcmn.taglibs.common.PartCommon;
import flowbuilder.presentation.webcmn.taglibs.view.upload.FileInformation;

/**
 * �A�b�v���[�h���i�̐ݒ�
 * 
 * @auther ZHANGXINFENG
 */
public final class PartUpload extends BodyTagSupport {

	// �g�D�̐ݒ�
	private String _orgId = "";

	// ���[�U�[ID�̐ݒ�
	private String _userId = "";

	// ���iXML�̐ݒ�
	private String _partXml = "";

	// �W���u�t�@�C���̐ݒ�
	private Document _job = null;

	/**
	 * �g�D�̐ݒ�
	 * 
	 * @param orgId String  �g�DID
	 */
	public void setOrgId(String orgId) {
		_orgId = orgId;
	}

	/**
	 * ���[�U�[ID�̐ݒ�
	 * 
	 * @param userId String ���[�UID
	 */
	public void setUserId(String userId) {
		_userId = userId;
	}

	/**
	 * ���iXML�̐ݒ�
	 * 
	 * @param partXml  String ���iXML
	 */
	public void setPartXml(String partXml) {
		_partXml = partXml;
	}

	/**
	 * �W���u�t�@�C���̐ݒ�
	 * 
	 * @param orgId Document  �W���u
	 */
	public void setJob(Document job) {
		_job = job;
	}

	/**
	 * �^�O��������
	 * 
	 * @return int 
	 */
	public int doStartTag() {
		try {
			pageContext.getOut().print(toHTML().toString());
		} catch (java.io.IOException e) {
			System.out.println("partOrgList:" + "doStartTag" + e.getMessage());
		}
		return SKIP_BODY;
	}

	/**
	 * HTML�̍쐬
	 * 
	 * @return StringBuffer
	 */
	private StringBuffer toHTML() {
		StringBuffer html = new StringBuffer();

		try {
			html.append(partUploadHtml(_job, _orgId, _userId, _partXml));
		} catch (java.lang.Exception e) {
			System.out.println("partOrgList:" + "toHTML" + e.getMessage());
		}
		return html;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	/**
	 * �A�b�v���[�h���i
	 * 
	 * @param job document �Č�
	 * @param strOrgID  String  �g�DID
	 * @param strUserID String ���[�UID
	 * @param strPartXml String ���iXML
	 */
	String partUploadHtml(Document job, String strOrgID, String strUserID, String strPartXml) {

		// ���O���o��
		Log logger = LogFactory.getLog(PartUpload.class);
		JobOprater jobOpr = new JobOprater();
		String strHtml = "";
		String strtagColspan = "";
		// �W���uID�̐ݒ�
		String strJobId = jobOpr.getJobID(job);

		try {

			// �i���ۏ�
			logger.info("�J�n");

			// ���i�w�l�k�h�L�������g�擾����
			Document part = ParseXmlString.getParsedDocument(strPartXml);

			// �Č����ݏ�Ԃ��擾
			String strCurState = jobOpr.getCurrentState(job);

			// ======�\���̊m�F======
			// �\���G�������g���擾����
			Element displayElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�\��"), 0);

			// ����Ҏw������擾����
			String strdisplayUser = XmlOperator.getAttrValue(displayElement, "user");

			// �����w������擾����
			String strdisplayRole = XmlOperator.getAttrValue(displayElement, "role");

			// ======�ҏW�̊m�F======
			// ��\���G�������g���擾����
			Element editionElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�ҏW"), 0);

			// ����Ҏw������擾����
			String streditionUser = XmlOperator.getAttrValue(editionElement, "user");

			// �����w������擾����
			String streditionRole = XmlOperator.getAttrValue(editionElement, "role");

			PartCheckCondition checkCondition = new PartCheckCondition();

			// �ҏW�̏ꍇ�A�����̃`�F�b�N���s���܂��B
			if (checkCondition.checkUserCondition(job, strCurState, streditionUser, strUserID)
					|| checkCondition.checkRoleCondition(strCurState, streditionRole, strOrgID,
							strUserID)) {

				// �^�O�̃m�[�h���擾����
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�^�O"), 0);

				// �^�O�̒l�擾����		
				String strtagUploadLable = XmlOperator.getAttrValue(tagElement, "uploadLable");

				strtagColspan = XmlOperator.getAttrValue(tagElement, "colspan");
				// �ҏW�̏ꍇ�AHTML�쐬
				strHtml = strHtml
						+ "<tr align='left' bgcolor='#ffffff' valign='middle'>\n"
						+ "<td>"
						+ strtagUploadLable
						+ "</td>\n"
						+ "<td height=25 colspan = "
						+ strtagColspan
						+ ">\n"
						+ "<table>\n"
						+ "<tr>\n"
						+ "<td>\n"
						+ "<table id='table1'>\n"
						+ "<tr>\n"
						+ "<td><input type='file' name='files[0]' id='fileId0' onpaste='return false' onkeydown='return false'></td>\n"
						+ "<td ><input type='button' name='1' value='�폜'  onClick='deleteRow(0);'></td>\n"
						+ "</tr>\n" + "</table>\n"
						+ "<input type='button' name='Submit2' value='�ǉ�' onClick='insertRow()'>\n"
						+ "</td>\n" + "</tr>\n" + "</table>\n" + "</td>\n" + "</tr>\n";

				//�@�\���̏ꍇ�A�����̃`�F�b�N���s���܂��B
			} else if (checkCondition.checkUserCondition(job, strCurState, strdisplayUser,
					strUserID)
					|| checkCondition.checkRoleCondition(strCurState, strdisplayRole, strOrgID,
							strUserID)) {

				List<FileInformation> fileList = new ArrayList<FileInformation>();

				FileInformation fileInfo = null;

				ConfigReader conf = FlowBuilderSystemConfig.getInstance();

				// �^�O�̃m�[�h���擾����
				Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�^�O"), 0);

				// �^�O�̒l�擾����
				String strtagDownLoadLable = XmlOperator.getAttrValue(tagElement, "downLoadLable");

				strtagColspan = XmlOperator.getAttrValue(tagElement, "colspan");

				// �Č���Ԃ��擾
				String strtagState = XmlOperator.getAttrValue(tagElement, "state");

				// �Č����ݏ�Ԃ��擾
				int state = jobOpr.getStep(job, strtagState);

				String urlBase = conf.getValue("UrlBase");

				// �_�E�����[�h�p�X���擾����
				String downloadPath = conf.getValue("loadPath");

				// �_�E�����[�hURL�p�X���擾����
				String urlPath = urlBase + conf.getValue("urlPath");

				// image�p�X���擾����
				String fileIcoPath = conf.getValue("fileIcoPath");

				String url = urlPath + strJobId + "/" + state + "/";

				//�p�X�̐ݒ�
				String filePath = downloadPath + strJobId + "\\" + state + "\\";

				File[] file = (new File(filePath)).listFiles();

				// �t�@�C�����X�g�̒��x���擾����
				int fileListLength;

				if (file == null) {
					fileListLength = 0;
				} else {
					fileListLength = file.length;
				}

				for (int i = 0; i < fileListLength; i++) {
					fileInfo = new FileInformation();

					// �t�@�C�����O���擾����
					String fileName = file[i].getName().toString();

					// �g���q���擾����
					String pix = this.postfix(fileName);

					String icopix = pix + ".gif";

					String realPath = pageContext.getServletContext().getRealPath("/");

					realPath += fileIcoPath + icopix;

					File imageFile = new File(realPath);

					if (!imageFile.exists()) {
						fileInfo.setIncoPath(urlBase + fileIcoPath + "pub.gif");
					} else {
						fileInfo.setIncoPath(urlBase + fileIcoPath + icopix);
					}

					// �K�v��NodeList���擾����h�L�������g
					NodeList Documents = XmlOperator.getNodeList(job, "Document");

					Element document = (Element) Documents.item(0);
					//�@�t�@�C�����O�̐ݒ�
					fileInfo.setFileName(PartCommon.getTagId(document, fileName));

					//�@�p�X�̂̐ݒ�
					fileInfo.setFileSrc(url + fileName);

					fileList.add(fileInfo);
				}

				// HTML�쐬
				strHtml = createDownLoadHtml(fileList, strtagDownLoadLable, strtagColspan);

			} else {

				// HTML�����o�͂��Ȃ�
				strHtml = "";
			}

			// �i���ۏ�
			logger.info("�I��");
		}

		catch (Exception e) {

			// �i���ۏ�
			logger.fatal("�v���I�ȃG���[");
			e.printStackTrace();
		}

		// HTML��߂�
		return (strHtml);
	}

	/**
	 * �g���q�擾����
	 * @param String fileName  �t�@�C�����O
	 * @return�@String
	 */
	private String postfix(String fileName) {
		if (fileName != null && !"".equals(fileName)) {
			return fileName.substring(fileName.indexOf(".") + 1, fileName.length());
		} else {

			// HTML��߂�
			return null;
		}
	}

	/**
	 * �ҏW�̏ꍇ�AHTML�쐬
	 * @param List fileList �t�@�C�����X�g
	 * @return String
	 */
	private String createDownLoadHtml(List<FileInformation> fileList, String strtagDownLoadLable,
			String strtagColspan) {

		// HTML�ݒ�
		String strHtml = "<tr align='left' bgcolor='#ffffff' valign='middle'>\n" + "<TD>"
				+ strtagDownLoadLable + "</TD>" + "<TD width=500 colspan = " + strtagColspan
				+ " nowrap>\n" + "<TABLE cellpadding='0' cellspacing='0' width=500>\n" + "<TR>\n";

		FileInformation fileInfo = null;

		// �t�@�C���̒��x���擾����
		int length = fileList.size();
		for (int i = 0; i < length; i++) {

			if (i != 0 && i % 5 == 0) {
				strHtml = strHtml + "</TR>\n";
				strHtml = strHtml + "<TR>\n";
			}

			strHtml = strHtml + "<TD width=150>\n";

			fileInfo = fileList.get(i);

			// HTML�쐬
			strHtml = strHtml + "<img src='" + fileInfo.getIncoPath() + "'/><BR>\n"

			+ "<A target='_blank' href='" + fileInfo.getFileSrc() + "'/>\n"

			+ fileInfo.getFileName() + "</A>\n";

			strHtml = strHtml + "</TD>\n";

		}

		// HTML�쐬
		strHtml = strHtml + "</TR>\n";
		strHtml = strHtml + "</TABLE>\n";
		strHtml = strHtml + "</TD>\n";
		strHtml = strHtml + "</TR>\n";

		// HTML��߂�
		return strHtml;
	}
}
