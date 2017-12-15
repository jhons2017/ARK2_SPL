package flowbuilder.presentation.webcmn.taglibs.presentation.circular;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import fbcom.framework.exceptions.RecordNotFoundAppException;
import fbcom.framework.exceptions.SysException;
import flowbuilder.application.orglist.OrgListService;
import flowbuilder.application.orglist.OrgListServiceFactory;
import flowbuilder.application.user.UserService;
import flowbuilder.application.user.UserServiceFactory;
import flowbuilder.daoimpl.db.DBXmlFileConn;
import flowbuilder.daoimpl.db.XmlFileProperity;
import flowbuilder.daoimpl.db.XmlOperator;
import flowbuilder.domain.user.Section;
import flowbuilder.domain.user.User;
import flowbuilder.presentation.webcmn.AuthorityChecker;


/**
 * �Č��\����ʏ������s���R���g���[���B <BR>
 */
public final class CircularAction extends DispatchAction
{
	/** �J�ږڕW��� */
	private final String FORWARD_SUCCESS = "success";
	
	/** �J�ڃ��O�A�E�g�ڕW��� */
	private final String FORWARD_LOGOUT = "logout";
	
	/** �t�@�C���C���t�H�̎擾 */
	private XmlFileProperity fileOpr = null;
		
	/**
	 * �Č������̏���
	 * 
	 * @param mapping�FActionMapping�I�u�W�F�N�g
	 * @param form�FActionForm�I�u�W�F�N�g
	 * @param request�FHttpServletRequest�I�u�W�F�N�g
	 * @param response�FHttpServletResponse�I�u�W�F�N�g
	 * @return ActionForward�FActionForward�I�u�W�F�N�g
	 * @exception java.lang.Exception�F��ʓI�ȗ�O��������throw����
	 */
	public ActionForward init(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String target = null;
		
		//url�p�����[�^���O���擾
		String httpParamName = "";
		
		//url�p�����[�^���擾
		String httpParamOrgId = "";
		
		//�Č�ID���擾
		String httpParamJobId = "";
		
		//���[�U���X�g���擾
		String strUserlst = "";
		
		if (AuthorityChecker.isSessionValid(request)) {
			// url�p�����[�^���擾
			Enumeration enmNam = request.getParameterNames();

			// ���N�G�X�g���𐔂���
			while (enmNam.hasMoreElements()) {
				httpParamName = (String) enmNam.nextElement().toString();
				// �g�DID���擾
				if ("orgId".equals(httpParamName)) {
					httpParamOrgId = (String) (request
							.getParameter(httpParamName).trim());
					// �Č�ID���擾
				} else if ("jobId".equals(httpParamName)) {
					httpParamJobId = (String) (request
							.getParameter(httpParamName).trim());
				}
			}

			// �Č��t�@�C������A�񗗐l���[�U���擾
			if (!"".equals(httpParamJobId)) {
				// �t�@�C���C���t�H�̎擾
				fileOpr = new XmlFileProperity("Path.Xml.File");

				// �t�@�C���C���t�H�̃p�X���擾
				String documentsXML = fileOpr.getJobFileDir(httpParamJobId);

				// �Č��t�@�C�����擾����B
				Document doc = DBXmlFileConn.getDocument(documentsXML);
				Element controlEle = (Element) XmlOperator.getNodeList(doc,
						"Document").item(0);
				NodeList controlLst = controlEle
						.getElementsByTagName("control");

				int len = controlLst.getLength();

				// �񗗎҂��擾
				for (int i = 0; i < len; i++) {
					Element controlNode = XmlOperator.getElement(controlLst, i);
					if ("circularID".equals(XmlOperator.getAttrValue(
							controlNode, "id"))) {
						if (controlNode.hasChildNodes()) {
							strUserlst = (String) controlNode.getFirstChild()
									.getNodeValue();
							break;
						}
					}
				}
			}
			// ���[�UID���A�S���̑g�D���擾
			UserService userService = UserServiceFactory
					.getUserServiceInstance();
			List queryUserlst = userService.getUsersByOrgId(httpParamOrgId);
			// �I���̉񗗎҂�ۑ�
			if (!"".equals(strUserlst)) {
				request.setAttribute("selectedUserlst", makeToList(strUserlst));
				// ������ݒ�
			} else {
				request.setAttribute("selectedUserlst", new ArrayList());
			}
			// �S���̑g�D���擾
			OrgListService orglstService = OrgListServiceFactory
					.getOrgListServiceInstance();
			List<Section> orgLst = orglstService.getAllOrgId();

			request.setAttribute("orglst", orgLst);
			request.setAttribute("queryUserlst", queryUserlst);

			target = FORWARD_SUCCESS;
		} else {
			target = FORWARD_LOGOUT;
		}
		return mapping.findForward(target);
	}
	/**
	 * �Č������̎��s
	 * 
	 * @param mapping�FActionMapping�I�u�W�F�N�g
	 * @param form�FActionForm�I�u�W�F�N�g
	 * @param request�FHttpServletRequest�I�u�W�F�N�g
	 * @param response�FHttpServletResponse�I�u�W�F�N�g
	 * @return ActionForward�FActionForward�I�u�W�F�N�g
	 * @exception java.lang.Exception�F��ʓI�ȗ�O��������throw����
	 */
	public ActionForward change(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String target = null;
		
		//url�p�����[�^���擾
		String httpParamName = "";
		
		//�g�D���擾
		String httpParamOrgId = "";
		
		//�񗗎�
		String strSelectedUsers = "";
		
		if (AuthorityChecker.isSessionValid(request)) {
			// url�p�����[�^���擾
			Enumeration enmNam = request.getParameterNames();

			CircularForm changeForm = (CircularForm) form;

			// ���N�G�X�g���𐔂���
			while (enmNam.hasMoreElements()) {
				// �p�����[�^���擾
				httpParamName = enmNam.nextElement().toString();
				// �g�D���擾
				if ("orgId".equals(httpParamName)) {
					httpParamOrgId = (String) (request
							.getParameter(httpParamName).trim());
					break;
				}
			}
			// �S���̑g�D���擾
			OrgListService orglstService = OrgListServiceFactory
					.getOrgListServiceInstance();
			List<Section> orgLst = orglstService.getAllOrgId();

			// ���[�UID���A�S���̑g�D���擾
			UserService userService = UserServiceFactory
					.getUserServiceInstance();
			List queryUserlst = userService.getUsersByOrgId(httpParamOrgId);

			// �񗗎҂��擾
			strSelectedUsers = changeForm.getSelectedUsers();

			// �I���̉񗗎҂��擾
			request.setAttribute("selectedUserlst",
					makeToList(strSelectedUsers));
			request.setAttribute("orglst", orgLst);
			request.setAttribute("queryUserlst", queryUserlst);

			target = FORWARD_SUCCESS;
		} else {
			target = FORWARD_LOGOUT;
			}
		return mapping.findForward(target);
	}
	
	/**
	 * 
	 * @param strSelectedUsers �I���̃��[�U
	 * @return�@���[�U���X�g
	 */	
	private List<User> makeToList(String strSelectedUsers){
		
		//���[�U���X�g
		List<User> selectedUserlst = new ArrayList<User>();
		
		//���[�U�T�[�r�X
		UserService userService;
		
		try {
			if (!"".equals(strSelectedUsers)) {			
				//���[�U�T�[�r�X
				userService = UserServiceFactory.getUserServiceInstance();
				
				//���[�U���X�g���]��
				String[] arraySelectedUsers = strSelectedUsers.split(",");
				
				int selectedUserNum = arraySelectedUsers.length;
				//���[�U���X�g
				for (int i = 0; i < selectedUserNum; i++) {
					selectedUserlst.add(userService.getUser(arraySelectedUsers[i]));
				} 
			}
		} catch (RecordNotFoundAppException e) {
			
		} catch (SysException e) {
		}
		return selectedUserlst;
	}
}