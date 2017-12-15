/* =================================================================
 * ITEM = 001 ; REV = 00 ; DATE 2007/06/05
 *
 * (c) 2007 WXHX Corporation  All Rights Reserved.
 * 
 * ORIGINAL SOURCE INFORMATION
 * 
 * REVISION HISTORY
 *			REV.00 2007/06/06 BY. XUXM (WXHX)
 * =================================================================
 */
package flowbuilder.presentation.webcmn.taglibs;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import fbcom.framework.exceptions.SysException;
import flowbuilder.application.util.JobOprater;
import flowbuilder.application.util.ParseXmlString;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.domain.user.UserRole;
import flowbuilder.presentation.webcmn.taglibs.common.validate.IValidate;
import flowbuilder.presentation.webcmn.taglibs.common.validate.ValidateFactory;
import flowbuilder.presentation.webcmn.taglibs.domain.page.PageInfo;

/**
 * ���i�̃X�[�p�[�N���X�@<BR>
 */
abstract class PartParent extends BodyTagSupport {
	/**
	 * �W���u�̋��ʑ���
	 */
	private JobOprater jobOpr = null;
	
	private PartCheckCondition checkCondition = null;
	
	/**
	 * �g�DID
	 */
	protected String _orgId = "";

	/**
	 * ���[�UID
	 */
	protected String _userId = "";

	/**
	 * ���iXML
	 */
	protected String _partXml = "";

	/**
	 * �Č��h�L�������g
	 */
	protected Document _job = null;

	/**
	 * �`�F�b�N�@�\�p��XML
	 */
	protected String _checkXml = "";

	/**
	 * ���[�U���[��
	 */
	protected UserRole _userRole = null;
	
	/**
	 * ����Ҏw������擾���� (��\��)
	 */
	protected String strhiddenUser = "";

	/**
	 * �����w������擾���� (��\��)
	 */ 
	protected String strhiddenRole = "";

	/**
	 * �g�D�w������擾���� (��\��)
	 */ 
	protected String strhiddenOrg = "";
	
	/**
	 * ����Ҏw������擾���� (�\��)
	 */ 
	protected String strdisplayUser = "";

	/**
	 * �����w������擾���� (�\��)
	 */ 
	protected String strdisplayRole = "";
	
	/**
	 * �g�D�w������擾���� (�\��)
	 */ 
	protected String strdisplayOrg = "";

	/**
	 * ����Ҏw������擾���� (�ҏW)
	 */ 
	protected String streditionUser = "";

	/**
	 * �����w������擾���� (�ҏW)
	 */ 
	protected String streditionRole = "";
	
	/**
	 * �g�D�w������擾���� (�ҏW)
	 */
	protected String streditionOrg = "";

	/**
	 * ����Ҏw������擾���� (�K�{)
	 */ 
	protected String strvitalUser = "";

	/**
	 * �����w������擾���� (�K�{)
	 */ 
	protected String strvitalRole = "";
	
	/**
	 * �g�D�w������擾���� (�K�{)
	 */ 
	protected String strVitalOrg = "";
	
	protected Document part = null;
	
	/**
	 * ��ID
	 */
	protected PageInfo _pInfo;
	
	/**
	 * �ł̐ݒ�
	 * 
	 * @param pInfo�@��ID
	 */
	public void setPageInfo(PageInfo pInfo) {
		_pInfo = pInfo;
	}
	
	/**
	 * �g�D�̐ݒ�
	 * 
	 * @param orgId�@�g�DID
	 */
	public void setOrgId(String orgId) {
		_orgId = orgId;
	}

	/**
	 * ���[�U�[ID�̐ݒ�
	 * 
	 * @param userId�@���[�U�[ID
	 */
	public void setUserId(String userId) {
		_userId = userId;
	}

	/**
	 * ���iXML�̐ݒ�
	 * 
	 * @param partXml�@���iXML
	 */
	public void setPartXml(String partXml) {
		_partXml = partXml;
	}

	/**
	 * �W���u�h�L�������g�̐ݒ�
	 * 
	 * @param job�@�W���u�t�@�C��
	 */
	public void setJob(Document job) {
		_job = job;
	}
	
	/**
	 * �`�F�b�N�C���t�H�̐ݒ�
	 * 
	 * @param checkXml�@�`�F�b�N�C���t�H
	 */
	public void setCheck(String checkXml) {
		_checkXml = checkXml;
	}

	/**
	 * ���[�U���[���̐ݒ�
	 * 
	 * @param userRole�@���[�U���[��
	 */
	public void setUserRole(UserRole userRole) {
		_userRole = userRole;
	}
	
	/**
	 * �^�O��������
	 * 
	 * @return int
	 */
	public int doStartTag() throws JspException {
		jobOpr = new JobOprater();
		checkCondition = new PartCheckCondition();
		StringBuffer html = toHTML();
		html.append(toValidateJs());
		try {
			pageContext.getOut().print(html.toString());
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}

		return SKIP_BODY;
	}

	/**
	 * �I������
	 * 
	 * @return int
	 */
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	/**
	 * HTML�̍쐬
	 * 
	 * @return StringBuffer�@�쐬��HTML
	 */
	protected abstract StringBuffer toHTML();


	private void init(){
		// ���i�w�l�k�h�L�������g�擾����
		part = ParseXmlString.getParsedDocument(_partXml);

		// ======��\���̊m�F======
		// ��\���G�������g���擾����
		Element hiddenElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "��\��"), 0);
		// ��\���̑���
		if ( hiddenElement != null ){
			// ����Ҏw������擾����
			strhiddenUser = XmlOperator.getAttrValue(hiddenElement, "user");
	
			// �����w������擾����
			strhiddenRole = XmlOperator.getAttrValue(hiddenElement, "role");
	
			// �g�D�w������擾����
			strhiddenOrg = XmlOperator.getAttrValue(hiddenElement, "org");
		}
		
		
		// ======�\���̊m�F======
		// �\���G�������g���擾����
		Element displayElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�\��"), 0);
		// �\���̑���
		if ( displayElement != null ){
			// ����Ҏw������擾����
			strdisplayUser = XmlOperator.getAttrValue(displayElement, "user");
	
			// �����w������擾����
			strdisplayRole = XmlOperator.getAttrValue(displayElement, "role");
			
			// �g�D�w������擾����
			strdisplayOrg = XmlOperator.getAttrValue(displayElement, "org");
		}
		
		// ======�ҏW�̊m�F======
		// �ҏW�G�������g���擾����
		Element editionElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�ҏW"), 0);
		// �ҏW�̑���
		if ( editionElement != null ){
			// ����Ҏw������擾����
			streditionUser = XmlOperator.getAttrValue(editionElement, "user");
	
			// �����w������擾����
			streditionRole = XmlOperator.getAttrValue(editionElement, "role");
			
			// �g�D�w������擾����
			streditionOrg = XmlOperator.getAttrValue(editionElement, "org");
		}
		
		// ======�K�{�̊m�F======
		// �K�{�G�������g���擾����
		Element vitalElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�K�{"), 0);
		// �K�{�̑���
		if ( vitalElement != null ){
			// ����Ҏw������擾����
			strvitalUser = XmlOperator.getAttrValue(vitalElement, "user");
	
			// �����w������擾����
			strvitalRole = XmlOperator.getAttrValue(vitalElement, "role");
			
			// �g�D�w������擾����
			strVitalOrg = XmlOperator.getAttrValue(vitalElement, "org");
		}
	}
	
	protected String getShowCase(){
		this.init();
		
		String bResult = "";
		
		// �Č����ݏ�Ԃ��擾
		String strCurState = jobOpr.getCurrentState(_job);
		// �N�Đl�g�D�h�c
		String strCreatOrg = jobOpr.getOrgID(_job);
		// �ҏW�ꍇ�����`�F�b�N
		if (checkCondition.checkUserCondition(_job, strCurState, streditionUser, _userId)
				|| (checkCondition.checkRoleCondition(strCurState, streditionRole, _orgId, _userId)
						&& checkCondition.checkOrgCondition(streditionOrg,_orgId,strCreatOrg))) {
			
			bResult = "edit";
			
			// �K�{�}�b�N
			if (checkCondition.checkUserCondition(_job, strCurState, strvitalUser, _userId)
					|| (checkCondition.checkRoleCondition(strCurState, strvitalRole, _orgId, _userId)
							&& checkCondition.checkOrgCondition(strVitalOrg,_orgId,strCreatOrg))) {
				bResult = "mustEdit";
			}			
       // �\���ꍇ�����`�F�b�N
		} else if (checkCondition.checkUserCondition(_job, strCurState, strdisplayUser, _userId)
					|| (checkCondition.checkRoleCondition(strCurState, strdisplayRole, _orgId, _userId)
						&& checkCondition.checkOrgCondition(strdisplayOrg,_orgId,strCreatOrg))) {
			bResult = "display";
		// ��\���ꍇ�����`�F�b�N
		} else if (checkCondition.checkUserCondition(_job, strCurState, strhiddenUser, _userId)
					|| (checkCondition.checkRoleCondition(strCurState, strhiddenRole, _orgId, _userId)
						&& checkCondition.checkOrgCondition(strhiddenOrg,_orgId,strCreatOrg))) {
						
			bResult = "nodisplay";
		}
		
		return bResult;
	}
	/**
	 * �`�F�b�NJS�̍쐬
	 * 
	 * @return String�@�쐬��JS
	 */
	private String toValidateJs() {
		//�`�F�b�N�@�\�̋��ʃC���^�t�F�[�X
		IValidate validate = null;
		//�Č�����̃N���X
		JobOprater jobopr = new JobOprater();
		
		//�`�F�b�N�I�u�W�F�N�g�𐶐�����
		try {
			validate = ValidateFactory.create(jobopr.getCurrentState(_job), _checkXml);
		} catch (SysException e) {

			e.printStackTrace();
		}
		
		// ���i�w�l�k�h�L�������g�擾����
		Document part = ParseXmlString.getParsedDocument(_partXml);
		
		// �^�O�̃m�[�h���擾����
		Element tagElement = XmlOperator.getElement(XmlOperator.getNodeList(part, "�^�O"), 0);

		//�@�^�O�̖��O�̎擾����
		String strtagName = XmlOperator.getAttrValue(tagElement, "name");
		
		String[] str = strtagName.split("/");
		
		
		StringBuffer result = new StringBuffer("<SCRIPT LANGAUGE='JavaScript'>\n");
			
		for(int i = 0;i<str.length;i++){
			if(!"".equals(str[i])) {
				result.append("var bResult = true;\n");
				result.append("var " + str[i] + "= new Object();\n");
				result.append(str[i] + ".Validate = function() {\n");
				result.append(validate.print());
				result.append("};\n");
			}
		}
			
		result.append("\n</SCRIPT>");
		
		return result.toString();
	}
}
